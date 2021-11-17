package org.choicehumanitarian.reports.enus.vertx;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.choicehumanitarian.reports.enus.java.TimeTool;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.request.api.ApiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authentication.TokenCredentials;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailConfig;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowStream;

/**
 */
public class WorkerVerticle extends WorkerVerticleGen<AbstractVerticle> {
	private static final Logger LOG = LoggerFactory.getLogger(WorkerVerticle.class);

	public final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss VV");

	public static final Integer FACET_LIMIT = 100;

	/**
	 * A io.vertx.ext.jdbc.JDBCClient for connecting to the relational database PostgreSQL. 
	 **/
	private PgPool pgPool;

	private WebClient webClient;

	WorkerExecutor workerExecutor;

	/**	
	 *	This is called by Vert.x when the verticle instance is deployed. 
	 *	Initialize a new site context object for storing information about the entire site in English. 
	 *	Setup the startPromise to handle the configuration steps and starting the server. 
	 **/
	@Override()
	public void  start(Promise<Void> startPromise) throws Exception, Exception {

		try {
			configureWebClient().compose(a -> 
				configureData().compose(b -> 
					configureSharedWorkerExecutor().compose(c -> 
						configureEmail().compose(d -> 
							importData().compose(e -> 
								syncDbToSolr().compose(f -> 
									refreshAllData()
								)
							)
						)
					)
				)
			).onComplete(startPromise);
		} catch (Exception ex) {
			LOG.error("Couldn't start verticle. ", ex);
		}
	}

	/**	
	 **/
	private Future<Void> configureWebClient() {
		Promise<Void> promise = Promise.promise();

		try {
			webClient = WebClient.create(vertx);
			promise.complete();
		} catch(Exception ex) {
			LOG.error("Unable to configure site context. ", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**	
	 * 
	 * Val.ConnectionError.enUS:Could not open the database client connection. 
	 * Val.ConnectionSuccess.enUS:The database client connection was successful. 
	 * 
	 * Val.InitError.enUS:Could not initialize the database tables. 
	 * Val.InitSuccess.enUS:The database tables were created successfully. 
	 * 
	 *	Configure shared database connections across the cluster for massive scaling of the application. 
	 *	Return a promise that configures a shared database client connection. 
	 *	Load the database configuration into a shared io.vertx.ext.jdbc.JDBCClient for a scalable, clustered datasource connection pool. 
	 *	Initialize the database tables if not already created for the first time. 
	 **/
	private Future<Void> configureData() {
		Promise<Void> promise = Promise.promise();
		try {
			PgConnectOptions pgOptions = new PgConnectOptions();
			Integer jdbcMaxPoolSize = config().getInteger(ConfigKeys.JDBC_MAX_POOL_SIZE, 1);

			pgOptions.setPort(config().getInteger(ConfigKeys.JDBC_PORT));
			pgOptions.setHost(config().getString(ConfigKeys.JDBC_HOST));
			pgOptions.setDatabase(config().getString(ConfigKeys.JDBC_DATABASE));
			pgOptions.setUser(config().getString(ConfigKeys.JDBC_USERNAME));
			pgOptions.setPassword(config().getString(ConfigKeys.JDBC_PASSWORD));
			pgOptions.setIdleTimeout(config().getInteger(ConfigKeys.JDBC_MAX_IDLE_TIME, 24));
			pgOptions.setIdleTimeoutUnit(TimeUnit.HOURS);
			pgOptions.setConnectTimeout(config().getInteger(ConfigKeys.JDBC_CONNECT_TIMEOUT, 86400000));

			PoolOptions poolOptions = new PoolOptions();
			poolOptions.setMaxSize(jdbcMaxPoolSize);
			poolOptions.setMaxWaitQueueSize(config().getInteger(ConfigKeys.JDBC_MAX_WAIT_QUEUE_SIZE, 10));

			pgPool = PgPool.pool(vertx, pgOptions, poolOptions);

			LOG.info(configureDataInitSuccess);
			promise.complete();
		} catch (Exception ex) {
			LOG.error(configureDataInitError, ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**	
	 * Val.Fail.enUS:Could not configure the shared worker executor. 
	 * Val.Complete.enUS:The shared worker executor "{}" was configured successfully. 
	 * 
	 *	Configure a shared worker executor for running blocking tasks in the background. 
	 *	Return a promise that configures the shared worker executor. 
	 **/
	private Future<Void> configureSharedWorkerExecutor() {
		Promise<Void> promise = Promise.promise();
		try {
			String name = "WorkerVerticle-WorkerExecutor";
			Integer workerPoolSize = System.getenv(ConfigKeys.WORKER_POOL_SIZE) == null ? 5 : Integer.parseInt(System.getenv(ConfigKeys.WORKER_POOL_SIZE));
			workerExecutor = vertx.createSharedWorkerExecutor(name, workerPoolSize);
			LOG.info(configureSharedWorkerExecutorComplete, name);
			promise.complete();
		} catch (Exception ex) {
			LOG.error(configureSharedWorkerExecutorFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**	
	 * Configure sending email. 
	 * Val.Complete.enUS:Configure sending email succeeded. 
	 * Val.Fail.enUS:Configure sending email failed. 
	 **/
	private Future<Void> configureEmail() {
		Promise<Void> promise = Promise.promise();
		try {
			String emailHost = config().getString(ConfigKeys.EMAIL_HOST);
			if(StringUtils.isNotBlank(emailHost)) {
				MailConfig mailConfig = new MailConfig();
				mailConfig.setHostname(emailHost);
				mailConfig.setPort(config().getInteger(ConfigKeys.EMAIL_PORT));
				mailConfig.setSsl(config().getBoolean(ConfigKeys.EMAIL_SSL));
				mailConfig.setUsername(config().getString(ConfigKeys.EMAIL_USERNAME));
				mailConfig.setPassword(config().getString(ConfigKeys.EMAIL_PASSWORD));
				MailClient.createShared(vertx, mailConfig);
				LOG.info(configureEmailComplete);
				promise.complete();
			} else {
				LOG.info(configureEmailComplete);
				promise.complete();
			}
		} catch (Exception ex) {
			LOG.error(configureEmailFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**
	 * Val.Scheduling.enUS:Scheduling the import at %s
	 */
	private Future<Void> importTimer() {
		Promise<Void> promise = Promise.promise();

		if(!config().getBoolean(ConfigKeys.ENABLE_IMPORT_DATA)) {
			LOG.info(importDataSkip);
			promise.complete();
		} else {
			// Load the import start time and period configuration. 
			String importStartTime = config().getString(ConfigKeys.IMPORT_DATA_START_TIME);
			String importPeriod = config().getString(ConfigKeys.IMPORT_DATA_PERIOD);
			// Get the duration of the import period. 
			Duration duration = TimeTool.parseNextDuration(importPeriod);
			// Calculate the next start time, or the next start time after that, if the start time is in less than a minute, 
			// to give the following code enough time to complete it's calculations to ensure the import starts correctly. 
			ZonedDateTime nextStartTime = Optional.of(TimeTool.parseNextZonedTime(importStartTime))
					.map(t -> Duration.between(Instant.now(), t).toMinutes() < 1L ? t.plus(duration) : t).get();
			// Get the time now for the import start time zone. 
			ZonedDateTime now = ZonedDateTime.now(nextStartTime.getZone());
			BigDecimal[] divideAndRemainder = BigDecimal.valueOf(Duration.between(now, nextStartTime).toMillis())
					.divideAndRemainder(BigDecimal.valueOf(duration.toMillis()));
			Duration nextStartDuration = Duration.between(now, nextStartTime);
			if(divideAndRemainder[0].compareTo(BigDecimal.ONE) >= 0) {
				nextStartDuration = Duration.ofMillis(divideAndRemainder[1].longValueExact());
				nextStartTime = now.plus(nextStartDuration);
			}
			LOG.info(String.format(importTimerScheduling, nextStartTime.format(timeFormat)));
			ZonedDateTime nextStartTime2 = nextStartTime;
			vertx.setTimer(nextStartDuration.toMillis(), a -> {
				importData(nextStartTime2);
			});
		}
		return promise.future();
	}

	private void importData(ZonedDateTime startDateTime) {
		importData().onComplete(a -> {
			String importPeriod = config().getString(ConfigKeys.IMPORT_DATA_PERIOD);
			Duration duration = TimeTool.parseNextDuration(importPeriod);
			ZonedDateTime nextStartTime = startDateTime.plus(duration);
			LOG.info(String.format(importTimerScheduling, nextStartTime.format(timeFormat)));
			Duration nextStartDuration = Duration.between(Instant.now(), nextStartTime);
			vertx.setTimer(nextStartDuration.toMillis(), b -> {
				importData(nextStartTime);
			});
		});
	}

	/**	
	 * Import initial data
	 * Val.Complete.enUS:Importing initial data completed. 
	 * Val.Fail.enUS:Importing initial data failed. 
	 * Val.Skip.enUS:Skip importing data. 
	 **/
	private Future<Void> importData() {
		Promise<Void> promise = Promise.promise();
		if(config().getBoolean(ConfigKeys.ENABLE_IMPORT_DATA, false)) {
			importDataChoiceDonor().onSuccess(a -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} else {
			LOG.info(importDataSkip);
			promise.complete();
		}
		return promise.future();
	}

	private Future<Void> importDataChoiceDonor() {
		Promise<Void> promise = Promise.promise();
		try {
			if(config().getBoolean(String.format("%s_%s", ConfigKeys.ENABLE_IMPORT_DATA, "ChoiceDonor"), true)) {

				webClient.post(config().getInteger(ConfigKeys.DOMO_PORT), config().getString(ConfigKeys.DOMO_HOST_NAME), config().getString(ConfigKeys.DOMO_AUTH_TOKEN_URI))
						.expect(ResponsePredicate.SC_OK)
						.ssl(config().getBoolean(ConfigKeys.DOMO_SSL))
						.authentication(new UsernamePasswordCredentials(config().getString(ConfigKeys.DOMO_AUTH_CLIENT_ID), config().getString(ConfigKeys.DOMO_AUTH_CLIENT_SECRET)))
						.putHeader("Content-Type", "application/x-www-form-urlencoded")
						.sendForm(MultiMap.caseInsensitiveMultiMap().set("grant_type", "client_credentials").set("scope", config().getString(ConfigKeys.DOMO_AUTH_SCOPE)))
						.onSuccess(tokenResponse -> {
					JsonObject token = tokenResponse.bodyAsJsonObject();
					webClient.post(config().getInteger(ConfigKeys.DOMO_PORT), config().getString(ConfigKeys.DOMO_HOST_NAME), config().getString(ConfigKeys.DOMO_DATASET_CPP_URI))
//							.expect(ResponsePredicate.SC_OK)
							.ssl(config().getBoolean(ConfigKeys.DOMO_SSL))
							.authentication(new TokenCredentials(token.getString("access_token")))
							.sendJson(new JsonObject().put("sql", "SELECT * FROM table"))
							.onSuccess(cppResponse -> {
						JsonObject cppData = cppResponse.bodyAsJsonObject();
						List<Future> futures = new ArrayList<>();

						cppData.getJsonArray("rows").stream().map(o -> (JsonArray)o).forEach(row -> {
							String donorFullName = row.getString(0);
							Long donorId = row.getLong(1);
							String donorAttributeName = row.getString(2);
							Long donorAttributeId = row.getLong(3);
							String donorInKind = row.getString(4);
							BigDecimal donorTotal = BigDecimal.valueOf(row.getDouble(5));
							BigDecimal donorYtd = BigDecimal.valueOf(row.getDouble(6));
							BigDecimal donorQ1 = BigDecimal.valueOf(row.getDouble(7));
							BigDecimal donorQ2 = BigDecimal.valueOf(row.getDouble(8));
							BigDecimal donorQ3 = BigDecimal.valueOf(row.getDouble(9));
							BigDecimal donorQ4 = BigDecimal.valueOf(row.getDouble(10));
							String donorParentName = row.getString(11);
		
							JsonObject body = new JsonObject()
									.put("saves", new JsonArray().add("inheritPk").add("donorFullName").add("donorId").add("stateKey").add("donorAttributeName").add("donorAttributeId").add("donorInKind").add("donorTotal").add("donorYtd").add("donorQ1").add("donorQ2").add("donorQ3").add("donorQ4").add("donorParentName"))
									.put("pk", Optional.ofNullable(donorId).map(v -> v.toString()).orElse(null))
									.put("donorFullName", Optional.ofNullable(donorFullName).map(v -> v.trim()).orElse(null))
									.put("donorId", Optional.ofNullable(donorId).map(v -> v.toString()).orElse(null))
									.put("donorAttributeName", Optional.ofNullable(donorAttributeName).map(v -> v.trim()).orElse(null))
									.put("donorAttributeId", Optional.ofNullable(donorAttributeId).map(v -> v.toString()).orElse(null))
									.put("donorInKind", Optional.ofNullable(donorInKind).map(v -> v.toString()).orElse(null))
									.put("donorTotal", Optional.ofNullable(donorTotal).map(v -> v.toString()).orElse(null))
									.put("donorYtd", Optional.ofNullable(donorYtd).map(v -> v.toString()).orElse(null))
									.put("donorQ1", Optional.ofNullable(donorQ1).map(v -> v.toString()).orElse(null))
									.put("donorQ2", Optional.ofNullable(donorQ2).map(v -> v.toString()).orElse(null))
									.put("donorQ3", Optional.ofNullable(donorQ3).map(v -> v.toString()).orElse(null))
									.put("donorQ4", Optional.ofNullable(donorQ4).map(v -> v.toString()).orElse(null))
									.put("donorParentName", Optional.ofNullable(donorParentName).map(v -> v.trim()).orElse(null))
									;
							JsonObject params = new JsonObject();
							params.put("body", body);
							params.put("path", new JsonObject());
							params.put("cookie", new JsonObject());
							params.put("query", new JsonObject().put("commitWithin", 10000).put("q", "*:*").put("var", new JsonArray().add("refresh:false")));
							JsonObject context = new JsonObject().put("params", params);
							JsonObject json = new JsonObject().put("context", context);
							futures.add(vertx.eventBus().request(String.format("choice-reports-enUS-%s", "ChoiceDonor"), json, new DeliveryOptions().addHeader("action", String.format("putimport%sFuture", "ChoiceDonor"))));
						});
						CompositeFuture.all(futures).onSuccess(a -> {
							LOG.info(importDataComplete);
							promise.complete();
						}).onFailure(ex -> {
							LOG.error(importDataFail, ex);
							promise.fail(ex);
						});
					}).onFailure(ex -> {
						LOG.error(importDataFail, ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error(importDataFail, ex);
					promise.fail(ex);
				});
			} else {
				LOG.info(importDataSkip);
				promise.complete();
			}
		} catch (Exception ex) {
			LOG.error(importDataFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**	
	 * Val.Complete.enUS:Syncing database to Solr completed. 
	 * Val.Fail.enUS:Syncing database to Solr failed. 
	 * Val.Skip.enUS:Skip syncing database to Solr. 
	 **/
	private Future<Void> syncDbToSolr() {
		Promise<Void> promise = Promise.promise();
		try {
			if(config().getBoolean(ConfigKeys.ENABLE_DB_SOLR_SYNC, false)) {
				Long millis = 1000L * config().getInteger(ConfigKeys.TIMER_DB_SOLR_SYNC_IN_SECONDS, 10);
				vertx.setTimer(millis, a -> {
					syncData("ChoiceDonor").onSuccess(b -> {
						LOG.info(syncDbToSolrComplete);
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(syncDbToSolrFail, ex);
						promise.fail(ex);
					});
				});
			} else {
				LOG.info(syncDbToSolrSkip);
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error(syncDbToSolrFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**	
	 * Sync %s data from the database to Solr. 
	 * Val.Complete.enUS:%s data sync completed. 
	 * Val.Fail.enUS:%s data sync failed. 
	 * Val.CounterResetFail.enUS:%s data sync failed to reset counter. 
	 * Val.Skip.enUS:%s data sync skipped. 
	 * Val.Started.enUS:%s data sync started. 
	 **/
	private Future<Void> syncData(String tableName) {
		Promise<Void> promise = Promise.promise();
		try {
			if(config().getBoolean(String.format("%s%s", ConfigKeys.ENABLE_DB_SOLR_SYNC, tableName), true)) {

				LOG.info(String.format(syncDataStarted, tableName));
				pgPool.withTransaction(sqlConnection -> {
					Promise<Void> promise1 = Promise.promise();
					sqlConnection.query(String.format("SELECT count(pk) FROM %s", tableName)).execute().onSuccess(countRowSet -> {
						try {
							Optional<Long> rowCountOptional = Optional.ofNullable(countRowSet.iterator().next()).map(row -> row.getLong(0));
							if(rowCountOptional.isPresent()) {
								Long apiCounterResume = config().getLong(ConfigKeys.API_COUNTER_RESUME);
								Integer apiCounterFetch = config().getInteger(ConfigKeys.API_COUNTER_FETCH);
								ApiCounter apiCounter = new ApiCounter();
	
								SiteRequestEnUS siteRequest = new SiteRequestEnUS();
								siteRequest.setConfig(config());
								siteRequest.initDeepSiteRequestEnUS(siteRequest);
		
								ApiRequest apiRequest = new ApiRequest();
								apiRequest.setRows(apiCounterFetch.intValue());
								apiRequest.setNumFound(rowCountOptional.get());
								apiRequest.setNumPATCH(apiCounter.getQueueNum());
								apiRequest.setCreated(ZonedDateTime.now(ZoneId.of(config().getString(ConfigKeys.SITE_ZONE))));
								apiRequest.initDeepApiRequest(siteRequest);
								vertx.eventBus().publish(String.format("websocket%s", tableName), JsonObject.mapFrom(apiRequest));
		
								sqlConnection.prepare(String.format("SELECT pk FROM %s", tableName)).onSuccess(preparedStatement -> {
									apiCounter.setQueueNum(0L);
									apiCounter.setTotalNum(0L);
									try {
										RowStream<Row> stream = preparedStatement.createStream(apiCounterFetch);
										stream.pause();
										stream.fetch(apiCounterFetch);
										stream.exceptionHandler(ex -> {
											LOG.error(String.format(syncDataFail, tableName), new RuntimeException(ex));
											promise1.fail(ex);
										});
										stream.endHandler(v -> {
											LOG.info(String.format(syncDataComplete, tableName));
											promise1.complete();
										});
										stream.handler(row -> {
											apiCounter.incrementQueueNum();
											try {
												vertx.eventBus().request(
														String.format("choice-reports-enUS-%s", tableName)
														, new JsonObject().put(
																"context"
																, new JsonObject().put(
																		"params"
																		, new JsonObject()
																				.put("body", new JsonObject().put("pk", row.getLong(0).toString()))
																				.put("path", new JsonObject())
																				.put("cookie", new JsonObject())
																				.put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("pk:" + row.getLong(0))).put("var", new JsonArray().add("refresh:false")))
																)
														)
														, new DeliveryOptions().addHeader("action", String.format("patch%sFuture", tableName))).onSuccess(a -> {
													apiCounter.incrementTotalNum();
													apiCounter.decrementQueueNum();
													if(apiCounter.getQueueNum().compareTo(apiCounterResume) == 0) {
														stream.fetch(apiCounterFetch);
														apiRequest.setNumPATCH(apiCounter.getTotalNum());
														apiRequest.setTimeRemaining(apiRequest.calculateTimeRemaining());
														vertx.eventBus().publish(String.format("websocket%s", tableName), JsonObject.mapFrom(apiRequest));
													}
												}).onFailure(ex -> {
													LOG.error(String.format(syncDataFail, tableName), ex);
													promise1.fail(ex);
												});
											} catch (Exception ex) {
												LOG.error(String.format(syncDataFail, tableName), ex);
												promise1.fail(ex);
											}
										});
									} catch (Exception ex) {
										LOG.error(String.format(syncDataFail, tableName), ex);
										promise1.fail(ex);
									}
								}).onFailure(ex -> {
									LOG.error(String.format(syncDataFail, tableName), ex);
									promise1.fail(ex);
								});
							} else {
								promise1.complete();
							}
						} catch (Exception ex) {
							LOG.error(String.format(syncDataFail, tableName), ex);
							promise1.fail(ex);
						}
					}).onFailure(ex -> {
						LOG.error(String.format(syncDataFail, tableName), ex);
						promise1.fail(ex);
					});
					return promise1.future();
				}).onSuccess(a -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format(syncDataFail, tableName), ex);
					promise.fail(ex);
				});
			} else {
				LOG.info(String.format(syncDataSkip, tableName));
				promise.complete();
			}
		} catch (Exception ex) {
			LOG.error(String.format(syncDataFail, tableName), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**	
	 * Val.Complete.enUS:Refresh all data completed. 
	 * Val.Fail.enUS:Refresh all data failed. 
	 * Val.Skip.enUS:Refresh all data skipped. 
	 **/
	private Future<Void> refreshAllData() {
		Promise<Void> promise = Promise.promise();
		vertx.setTimer(1000 * 10, a -> {
			if(config().getBoolean(ConfigKeys.ENABLE_REFRESH_DATA, false)) {
				refreshData("TrafficContraband").onSuccess(b -> {
					refreshData("SearchBasis").onSuccess(c -> {
						refreshData("TrafficSearch").onSuccess(d -> {
							refreshData("TrafficPerson").onSuccess(e -> {
								refreshData("TrafficStop").onSuccess(f -> {
									LOG.info(refreshAllDataComplete);
									promise.complete();
								}).onFailure(ex -> {
									LOG.error(refreshAllDataFail, ex);
									promise.fail(ex);
								});
							}).onFailure(ex -> {
								LOG.error(refreshAllDataFail, ex);
								promise.fail(ex);
							});
						}).onFailure(ex -> {
							LOG.error(refreshAllDataFail, ex);
							promise.fail(ex);
						});
					}).onFailure(ex -> {
						LOG.error(refreshAllDataFail, ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error(refreshAllDataFail, ex);
					promise.fail(ex);
				});
			} else {
				LOG.info(refreshAllDataSkip);
				promise.complete();
			}
		});
		return promise.future();
	}

	/**	
	 * Refresh %s data from the database to Solr. 
	 * Val.Complete.enUS:%s refresh completed. 
	 * Val.Fail.enUS:%s refresh failed. 
	 * Val.Skip.enUS:%s refresh skipped. 
	 **/
	private Future<Void> refreshData(String tableName) {
		Promise<Void> promise = Promise.promise();
		try {
			if(config().getBoolean(String.format("%s%s", ConfigKeys.ENABLE_REFRESH_DATA, tableName), true)) {
				JsonObject params = new JsonObject();
				params.put("body", new JsonObject());
				params.put("path", new JsonObject());
				params.put("cookie", new JsonObject());
				params.put("query", new JsonObject().put("q", "*:*").put("var", new JsonArray().add("refresh:false")));
				JsonObject context = new JsonObject().put("params", params);
				JsonObject json = new JsonObject().put("context", context);
				vertx.eventBus().request(String.format("choice-reports-enUS-%s", tableName), json, new DeliveryOptions().addHeader("action", String.format("patch%s", tableName))).onSuccess(a -> {
					LOG.info(String.format(refreshDataComplete, tableName));
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format(refreshDataFail, tableName), ex);
					promise.fail(ex);
				});
			} else {
				LOG.info(String.format(refreshDataSkip, tableName));
				promise.complete();
			}
		} catch (Exception ex) {
			LOG.error(String.format(refreshDataFail, tableName), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
}
