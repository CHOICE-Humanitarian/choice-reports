package org.choicehumanitarian.reports.enus.vertx;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.tool.TimeTool;
import org.computate.search.tool.XmlTool;
import org.computate.vertx.api.ApiCounter;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.api.ApiCounter;
import org.computate.vertx.api.ApiRequest;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.model.page.SitePage;
import org.choicehumanitarian.reports.enus.model.page.reader.SitePageReader;
import org.choicehumanitarian.reports.enus.model.htm.SiteHtm;
import org.computate.vertx.api.ApiCounter;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.handlebars.AuthHelpers;
import org.computate.vertx.handlebars.DateHelpers;
import org.computate.vertx.handlebars.SiteHelpers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Jackson2Helper;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.helper.ConditionalHelpers;
import com.github.jknack.handlebars.helper.StringHelpers;
import com.google.common.io.PatternFilenameFilter;

import io.vertx.config.yaml.YamlProcessor;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authentication.TokenCredentials;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailConfig;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.Cursor;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowStream;
import io.vertx.sqlclient.SqlConnection;
import java.time.LocalDateTime;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.sqlclient.Cursor;
import io.vertx.sqlclient.SqlConnection;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import io.vertx.ext.auth.authentication.TokenCredentials;

import org.choicehumanitarian.reports.enus.model.user.SiteUser;
import org.choicehumanitarian.reports.enus.model.donor.ChoiceDonor;
import org.choicehumanitarian.reports.enus.model.report.ChoiceReport;
import org.choicehumanitarian.reports.enus.model.report.type.ReportType;
import org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule;
import org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative;
import org.choicehumanitarian.reports.enus.model.report.event.ReportEvent;
import org.choicehumanitarian.reports.enus.model.page.SitePage;
import org.choicehumanitarian.reports.enus.model.htm.SiteHtm;

/**
 */
public class WorkerVerticle extends WorkerVerticleGen<AbstractVerticle> {
	private static final Logger LOG = LoggerFactory.getLogger(WorkerVerticle.class);

	public static final Integer FACET_LIMIT = 100;

	public final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss VV");

	/**
	 * A io.vertx.ext.jdbc.JDBCClient for connecting to the relational database PostgreSQL. 
	 **/
	private PgPool pgPool;

	public PgPool getPgPool() {
		return pgPool;
	}

	public void setPgPool(PgPool pgPool) {
		this.pgPool = pgPool;
	}

	private WebClient webClient;

	WorkerExecutor workerExecutor;

	Integer commitWithin;

	HandlebarsTemplateEngine templateEngine;

	Handlebars handlebars;

	/**	
	 *	This is called by Vert.x when the verticle instance is deployed. 
	 *	Initialize a new site context object for storing information about the entire site in English. 
	 *	Setup the startPromise to handle the configuration steps and starting the server. 
	 **/
	@Override()
	public void start(Promise<Void> startPromise) throws Exception, Exception {
		commitWithin = config().getInteger(ConfigKeys.SOLR_WORKER_COMMIT_WITHIN_MILLIS);

		try {
			configureData().onSuccess(a -> 
				configureWebClient().onSuccess(b -> 
					configureHandlebars().onSuccess(c -> 
						configureSharedWorkerExecutor().onSuccess(d -> 
							configureEmail().onSuccess(e -> 
								importData().onSuccess(f -> 
									refreshAllData().onSuccess(g -> {
										startPromise.complete();
									}).onFailure(ex -> startPromise.fail(ex))
								).onFailure(ex -> startPromise.fail(ex))
							).onFailure(ex -> startPromise.fail(ex))
						).onFailure(ex -> startPromise.fail(ex))
					).onFailure(ex -> startPromise.fail(ex))
				).onFailure(ex -> startPromise.fail(ex))
			).onFailure(ex -> startPromise.fail(ex));
		} catch (Exception ex) {
			LOG.error("Couldn't start verticle. ", ex);
		}
	}

	/**
	 * Val.Fail.enUS:Handlebars was not configured properly. 
	 * Val.Complete.enUS:Handlebars was configured properly. 
	 */
	private Future<Void> configureHandlebars() {
		Promise<Void> promise = Promise.promise();
		try {
			templateEngine = HandlebarsTemplateEngine.create(vertx);
			handlebars = (Handlebars)templateEngine.unwrap();

			handlebars.registerHelpers(ConditionalHelpers.class);
			handlebars.registerHelpers(StringHelpers.class);
			handlebars.registerHelpers(AuthHelpers.class);
			handlebars.registerHelpers(SiteHelpers.class);
			handlebars.registerHelpers(DateHelpers.class);
			handlebars.registerHelper("json", Jackson2Helper.INSTANCE);

			LOG.info(configureHandlebarsComplete);
			promise.complete();
		} catch(Exception ex) {
			LOG.error(configureHandlebarsFail, ex);
			promise.fail(ex);
		}
		return promise.future();
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
	 * Val.Scheduling.enUS:Scheduling the %s import at %s
	 * Val.Skip.enUS:Skip importing %s data. 
	 * Val.Fail.enUS:Scheduling the import of %s data failed. 
	 */
	private Future<Void> importTimer(String classSimpleName) {
		Promise<Void> promise = Promise.promise();
		if(config().getBoolean(String.format("%s_%s", ConfigKeys.ENABLE_IMPORT_DATA, classSimpleName), true)) {
			// Load the import start time and period configuration. 
			String importStartTime = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_START_TIME, classSimpleName));
			String importPeriod = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
			// Get the duration of the import period. 
			// Calculate the next start time, or the next start time after that, if the start time is in less than a minute, 
			// to give the following code enough time to complete it's calculations to ensure the import starts correctly. 

			Duration nextStartDuration = null;
			ZonedDateTime nextStartTime = null;
			if(importPeriod != null) {
				Duration duration = TimeTool.parseNextDuration(importPeriod);
				if(importStartTime == null) {
					nextStartTime = Optional.of(ZonedDateTime.now(ZoneId.of(config().getString(ConfigKeys.SITE_ZONE))))
							.map(t -> Duration.between(Instant.now(), t).toMinutes() < 1L ? t.plus(duration) : t).get();
				} else {
					nextStartTime = Optional.of(ZonedDateTime.now(ZoneId.of(config().getString(ConfigKeys.SITE_ZONE))))
							.map(t -> Duration.between(Instant.now(), t).toMinutes() < 1L ? t.plus(duration) : t).get();
				}

				// Get the time now for the import start time zone. 
				ZonedDateTime now = ZonedDateTime.now(nextStartTime.getZone());
				BigDecimal[] divideAndRemainder = BigDecimal.valueOf(Duration.between(now, nextStartTime).toMillis())
						.divideAndRemainder(BigDecimal.valueOf(duration.toMillis()));
				nextStartDuration = Duration.between(now, nextStartTime);
				if(divideAndRemainder[0].compareTo(BigDecimal.ONE) >= 0) {
					nextStartDuration = Duration.ofMillis(divideAndRemainder[1].longValueExact());
					nextStartTime = now.plus(nextStartDuration);
				}
				LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
			}
			ZonedDateTime nextStartTime2 = nextStartTime;

			if(importStartTime == null) {
				importDataClass(classSimpleName, nextStartTime2).onSuccess(a -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format(importTimerFail, classSimpleName), ex);
					promise.fail(ex);
				});
			} else {
				vertx.setTimer(nextStartDuration.toMillis(), a -> {
					importDataClass(classSimpleName, nextStartTime2);
				});
				promise.complete();
			}
		} else {
			LOG.info(String.format(importTimerSkip, classSimpleName));
			promise.complete();
		}
		return promise.future();
	}

	/**	
	 * Import initial data
	 * Val.Complete.enUS:Importing initial data completed. 
	 * Val.Fail.enUS:Importing initial data failed. 
	 * Val.Skip.enUS:Skip importing data. 
	 **/
	private Future<Void> importData() {
		Promise<Void> promise = Promise.promise();
		importTimer("ChoiceDonor");
		importTimer("ChoiceImage");
		importTimer("ReportType");
		return promise.future();
	}

	private Future<Void> importDataClass(String classSimpleName, ZonedDateTime startDateTime) {
		Promise<Void> promise = Promise.promise();
		if("ChoiceDonor".equals(classSimpleName)) {
			importDataChoiceDonor().onComplete(a -> {
				String importPeriod = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
				if(importPeriod != null && startDateTime != null) {
					Duration duration = TimeTool.parseNextDuration(importPeriod);
					ZonedDateTime nextStartTime = startDateTime.plus(duration);
					LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
					Duration nextStartDuration = Duration.between(Instant.now(), nextStartTime);
					vertx.setTimer(nextStartDuration.toMillis(), b -> {
						importDataClass(classSimpleName, nextStartTime);
					});
					promise.complete();
				} else {
					promise.complete();
				}
			});
		} else if("ChoiceImage".equals(classSimpleName)) {
			importDataChoiceImage().onComplete(a -> {
				String importPeriod = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
				if(importPeriod != null && startDateTime != null) {
					Duration duration = TimeTool.parseNextDuration(importPeriod);
					ZonedDateTime nextStartTime = startDateTime.plus(duration);
					LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
					Duration nextStartDuration = Duration.between(Instant.now(), nextStartTime);
					vertx.setTimer(nextStartDuration.toMillis(), c -> {
						importDataClass(classSimpleName, nextStartTime);
					});
					promise.complete();
				} else {
					promise.complete();
				}
			});
		} else if("ReportType".equals(classSimpleName)) {
			importDataReportType().onComplete(a -> {
				String importPeriod = config().getString(String.format("%s_%s", ConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
				if(importPeriod != null && startDateTime != null) {
					Duration duration = TimeTool.parseNextDuration(importPeriod);
					ZonedDateTime nextStartTime = startDateTime.plus(duration);
					LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
					Duration nextStartDuration = Duration.between(Instant.now(), nextStartTime);
					vertx.setTimer(nextStartDuration.toMillis(), c -> {
						importDataClass(classSimpleName, nextStartTime);
					});
					promise.complete();
				} else {
					promise.complete();
				}
			});
		}
		return promise.future();
	}

	private Future<Void> importDataChoiceDonor() {
		Promise<Void> promise = Promise.promise();
		webClient.post(config().getInteger(ConfigKeys.DOMO_PORT), config().getString(ConfigKeys.DOMO_HOST_NAME), config().getString(ConfigKeys.DOMO_AUTH_TOKEN_URI))
				.expect(ResponsePredicate.SC_OK)
				.ssl(config().getBoolean(ConfigKeys.DOMO_SSL))
				.authentication(new UsernamePasswordCredentials(config().getString(ConfigKeys.DOMO_AUTH_CLIENT_ID), config().getString(ConfigKeys.DOMO_AUTH_CLIENT_SECRET)))
				.putHeader("Content-Type", "application/x-www-form-urlencoded")
				.sendForm(MultiMap.caseInsensitiveMultiMap().set("grant_type", "client_credentials").set("scope", config().getString(ConfigKeys.DOMO_AUTH_SCOPE)))
				.onSuccess(tokenResponse -> {
			JsonObject token = tokenResponse.bodyAsJsonObject();
			webClient.post(config().getInteger(ConfigKeys.DOMO_PORT), config().getString(ConfigKeys.DOMO_HOST_NAME), config().getString(ConfigKeys.DOMO_DATASET_CPP_URI))
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
		return promise.future();
	}

	private Future<Void> importDataChoiceImage() {
		Promise<Void> promise = Promise.promise();
		webClient.post(config().getInteger(ConfigKeys.DOMO_PORT), config().getString(ConfigKeys.DOMO_HOST_NAME), config().getString(ConfigKeys.DOMO_AUTH_TOKEN_URI))
				.expect(ResponsePredicate.SC_OK)
				.ssl(config().getBoolean(ConfigKeys.DOMO_SSL))
				.authentication(new UsernamePasswordCredentials(config().getString(ConfigKeys.DOMO_AUTH_CLIENT_ID), config().getString(ConfigKeys.DOMO_AUTH_CLIENT_SECRET)))
				.putHeader("Content-Type", "application/x-www-form-urlencoded")
				.sendForm(MultiMap.caseInsensitiveMultiMap().set("grant_type", "client_credentials").set("scope", config().getString(ConfigKeys.DOMO_AUTH_SCOPE)))
				.onSuccess(tokenResponse -> {
			JsonObject token = tokenResponse.bodyAsJsonObject();
			webClient.post(config().getInteger(ConfigKeys.DOMO_PORT), config().getString(ConfigKeys.DOMO_HOST_NAME), config().getString(ConfigKeys.DOMO_DATASET_CPP_URI))
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
		return promise.future();
	}

	private Future<Void> importDataReportType() {
		Promise<Void> promise = Promise.promise();
		JsonArray reportTypes = Optional.ofNullable(config().getValue(String.format("IMPORT_DATA_%s", "ReportType"))).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray());
		List<Future> futures = new ArrayList<>();

		reportTypes.stream().map(o -> (JsonObject)o).forEach(reportType -> {
	
			JsonObject body = new JsonObject()
					.put(ReportType.VAR_saves, new JsonArray().add(ReportType.VAR_inheritPk).add(ReportType.VAR_typeName))
					.put(ReportType.VAR_pk, reportType.getString(ReportType.VAR_typeName))
					.put(ReportType.VAR_typeName, reportType.getString(ReportType.VAR_typeName))
					;
			JsonObject params = new JsonObject();
			params.put("body", body);
			params.put("path", new JsonObject());
			params.put("cookie", new JsonObject());
			params.put("query", new JsonObject().put("commitWithin", 10000).put("q", "*:*").put("var", new JsonArray().add("refresh:false")));
			JsonObject context = new JsonObject().put("params", params);
			JsonObject json = new JsonObject().put("context", context);
			futures.add(vertx.eventBus().request(String.format("choice-reports-enUS-%s", "ReportType"), json, new DeliveryOptions().addHeader("action", String.format("putimport%sFuture", "ReportType"))));
		});
		CompositeFuture.all(futures).onSuccess(a -> {
			LOG.info(importDataComplete);
			promise.complete();
		}).onFailure(ex -> {
			LOG.error(importDataFail, ex);
			promise.fail(ex);
		});
		return promise.future();
	}

	/**
	 * Val.Complete.enUS:Refresh all data completed. 
	 * Val.Started.enUS:Refresh all data started. 
	 * Val.Fail.enUS:Refresh all data failed. 
	 * Val.Skip.enUS:Refresh all data skipped. 
	 **/
	private Future<Void> refreshAllData() {
		Promise<Void> promise = Promise.promise();
		try {
			if(config().getBoolean(ConfigKeys.ENABLE_REFRESH_DATA, false)) {
				LOG.info(refreshAllDataStarted);
				refreshData(SiteUser.CLASS_SIMPLE_NAME).onSuccess(q -> {
					refreshData(ChoiceDonor.CLASS_SIMPLE_NAME).onSuccess(q1 -> {
						refreshData(ChoiceReport.CLASS_SIMPLE_NAME).onSuccess(q2 -> {
							refreshData(ReportType.CLASS_SIMPLE_NAME).onSuccess(q3 -> {
								refreshData(ReportSchedule.CLASS_SIMPLE_NAME).onSuccess(q4 -> {
									refreshData(ReportNarrative.CLASS_SIMPLE_NAME).onSuccess(q5 -> {
										refreshData(ReportEvent.CLASS_SIMPLE_NAME).onSuccess(q6 -> {
											refreshData(SitePage.CLASS_SIMPLE_NAME).onSuccess(q7 -> {
												refreshData(SiteHtm.CLASS_SIMPLE_NAME).onSuccess(q8 -> {
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
		} catch(Exception ex) {
			LOG.error(refreshAllDataFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**
	 * Sync %s data from the database to Solr. 
	 * Refresh %s data from the database to Solr. 
	 * Val.Complete.enUS:%s refresh completed. 
	 * Val.Started.enUS:%s data sync started. 
	 * Val.Skip.enUS:%s refresh skipped. 
	 * Val.Fail.enUS:%s refresh failed. 
	 * Val.CounterResetFail.enUS:%s data sync failed to reset counter. 
	 **/
	private Future<Void> refreshData(String tableName) {
		Promise<Void> promise = Promise.promise();
		if(config().getBoolean(String.format("%s_%s", ConfigKeys.ENABLE_REFRESH_DATA, tableName), false)) {
			vertx.setTimer(10000, timer -> {
				try {
					LOG.info(String.format(refreshDataStarted, tableName));
					pgPool.withTransaction(sqlConnection -> {
						Promise<Void> promise1 = Promise.promise();
						sqlConnection.query(String.format("SELECT count(pk) FROM %s", tableName)).execute().onSuccess(countRowSet -> {
							try {
								Optional<Long> rowCountOptional = Optional.ofNullable(countRowSet.iterator().next()).map(row -> row.getLong(0));
								if(rowCountOptional.isPresent()) {
									Integer apiCounterResume = config().getInteger(ConfigKeys.API_COUNTER_RESUME);
									Integer apiCounterFetch = config().getInteger(ConfigKeys.API_COUNTER_FETCH);
									ApiCounter apiCounter = new ApiCounter();
		
									SiteRequestEnUS siteRequest = new SiteRequestEnUS();
									siteRequest.setConfig(config());
									siteRequest.initDeepSiteRequestEnUS(siteRequest);
			
									ApiRequest apiRequest = new ApiRequest();
									apiRequest.setRows(apiCounterFetch.longValue());
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
												LOG.error(String.format(refreshDataFail, tableName), new RuntimeException(ex));
												promise1.fail(ex);
											});
											stream.endHandler(v -> {
												LOG.info(String.format(refreshDataComplete, tableName));
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
														if(apiCounter.getQueueNum().compareTo(apiCounterResume.longValue()) == 0) {
															stream.fetch(apiCounterFetch);
															apiRequest.setNumPATCH(apiCounter.getTotalNum());
															apiRequest.setTimeRemaining(apiRequest.calculateTimeRemaining());
															vertx.eventBus().publish(String.format("websocket%s", tableName), JsonObject.mapFrom(apiRequest));
														}
													}).onFailure(ex -> {
														LOG.error(String.format(refreshDataFail, tableName), ex);
														promise1.fail(ex);
													});
												} catch (Exception ex) {
													LOG.error(String.format(refreshDataFail, tableName), ex);
													promise1.fail(ex);
												}
											});
										} catch (Exception ex) {
											LOG.error(String.format(refreshDataFail, tableName), ex);
											promise1.fail(ex);
										}
									}).onFailure(ex -> {
										LOG.error(String.format(refreshDataFail, tableName), ex);
										promise1.fail(ex);
									});
								} else {
									promise1.complete();
								}
							} catch (Exception ex) {
								LOG.error(String.format(refreshDataFail, tableName), ex);
								promise1.fail(ex);
							}
						}).onFailure(ex -> {
							LOG.error(String.format(refreshDataFail, tableName), ex);
							promise1.fail(ex);
						});
						return promise1.future();
					}).onSuccess(a -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error(String.format(refreshDataFail, tableName), ex);
						promise.fail(ex);
					});
				} catch (Exception ex) {
					LOG.error(String.format(refreshDataFail, tableName), ex);
					promise.fail(ex);
				}
			});
		} else {
			LOG.info(String.format(refreshDataSkip, tableName));
			promise.complete();
		}
		return promise.future();
	}
}
