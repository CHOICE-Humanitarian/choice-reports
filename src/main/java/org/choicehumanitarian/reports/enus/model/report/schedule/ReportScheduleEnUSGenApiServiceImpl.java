package org.choicehumanitarian.reports.enus.model.report.schedule;

import org.choicehumanitarian.reports.enus.model.report.type.ReportTypeEnUSApiServiceImpl;
import org.choicehumanitarian.reports.enus.model.report.type.ReportType;
import org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrativeEnUSApiServiceImpl;
import org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative;
import org.choicehumanitarian.reports.enus.model.report.event.ReportEventEnUSApiServiceImpl;
import org.choicehumanitarian.reports.enus.model.report.event.ReportEvent;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.user.SiteUser;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.search.list.SearchResult;
import org.computate.vertx.verticle.EmailVerticle;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.computate.vertx.api.BaseApiServiceImpl;
import io.vertx.ext.web.client.WebClient;
import java.util.Objects;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.EventBus;
import io.vertx.pgclient.PgPool;
import io.vertx.core.json.impl.JsonUtil;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;
import io.vertx.core.eventbus.DeliveryOptions;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.Instant;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.apache.commons.lang3.StringUtils;
import java.security.Principal;
import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.PrintWriter;
import java.util.Collection;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.apache.commons.lang3.math.NumberUtils;
import io.vertx.ext.web.Router;
import io.vertx.core.Vertx;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import io.vertx.core.MultiMap;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.sqlclient.Transaction;
import io.vertx.sqlclient.SqlConnection;
import io.vertx.sqlclient.Tuple;
import io.vertx.sqlclient.Row;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.AsyncResult;
import java.net.URLEncoder;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.CompositeFuture;
import io.vertx.core.http.HttpHeaders;
import java.nio.charset.Charset;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import java.util.HashMap;
import io.vertx.ext.auth.User;
import java.util.Optional;
import java.util.stream.Stream;
import java.net.URLDecoder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map.Entry;
import java.util.Iterator;
import org.computate.search.tool.SearchTool;
import org.computate.search.response.solr.SolrResponse;
import java.util.Base64;
import java.time.ZonedDateTime;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.choicehumanitarian.reports.enus.user.SiteUserEnUSApiServiceImpl;
import org.computate.vertx.search.list.SearchList;


/**
 * Translate: false
 **/
public class ReportScheduleEnUSGenApiServiceImpl extends BaseApiServiceImpl implements ReportScheduleEnUSGenApiService {

	protected static final Logger LOG = LoggerFactory.getLogger(ReportScheduleEnUSGenApiServiceImpl.class);

	public ReportScheduleEnUSGenApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider, HandlebarsTemplateEngine templateEngine) {
		super(eventBus, config, workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine);
	}

	// PUTImport //

	@Override
	public void putimportReportSchedule(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("putimportReportSchedule started. "));
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, "choice-reports-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);

				List<String> roles = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_REQUIRED + "_ReportSchedule")).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
				if(
						!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
						) {
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED", 
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", "roles required: " + String.join(", ", roles))
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					try {
						ApiRequest apiRequest = new ApiRequest();
						JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
						apiRequest.setRows(Long.valueOf(jsonArray.size()));
						apiRequest.setNumFound(Long.valueOf(jsonArray.size()));
						apiRequest.setNumPATCH(0L);
						apiRequest.initDeepApiRequest(siteRequest);
						siteRequest.setApiRequest_(apiRequest);
						eventBus.publish("websocketReportSchedule", JsonObject.mapFrom(apiRequest).toString());
						varsReportSchedule(siteRequest).onSuccess(d -> {
							listPUTImportReportSchedule(apiRequest, siteRequest).onSuccess(e -> {
								response200PUTImportReportSchedule(siteRequest).onSuccess(response -> {
									LOG.debug(String.format("putimportReportSchedule succeeded. "));
									eventHandler.handle(Future.succeededFuture(response));
								}).onFailure(ex -> {
									LOG.error(String.format("putimportReportSchedule failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							}).onFailure(ex -> {
								LOG.error(String.format("putimportReportSchedule failed. "), ex);
								error(siteRequest, eventHandler, ex);
							});
						}).onFailure(ex -> {
							LOG.error(String.format("putimportReportSchedule failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					} catch(Exception ex) {
						LOG.error(String.format("putimportReportSchedule failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}
			} catch(Exception ex) {
				LOG.error(String.format("putimportReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportReportSchedule failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("putimportReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<Void> listPUTImportReportSchedule(ApiRequest apiRequest, SiteRequestEnUS siteRequest) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		JsonArray jsonArray = Optional.ofNullable(siteRequest.getJsonObject()).map(o -> o.getJsonArray("list")).orElse(new JsonArray());
		try {
			jsonArray.forEach(obj -> {
				futures.add(Future.future(promise1 -> {
					JsonObject params = new JsonObject();
					params.put("body", obj);
					params.put("path", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", new JsonObject());
					params.put("form", new JsonObject());
					JsonObject query = new JsonObject();
					Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
					Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					if(softCommit != null)
						query.put("softCommit", softCommit);
					if(commitWithin != null)
						query.put("commitWithin", commitWithin);
					params.put("query", query);
					JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request("choice-reports-enUS-ReportSchedule", json, new DeliveryOptions().addHeader("action", "putimportReportScheduleFuture")).onSuccess(a -> {
						promise1.complete();
					}).onFailure(ex -> {
						LOG.error(String.format("listPUTImportReportSchedule failed. "), ex);
						promise1.fail(ex);
					});
				}));
			});
			CompositeFuture.all(futures).onSuccess(a -> {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(String.format("listPUTImportReportSchedule failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("listPUTImportReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	@Override
	public void putimportReportScheduleFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, "choice-reports-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				ApiRequest apiRequest = new ApiRequest();
				apiRequest.setRows(1L);
				apiRequest.setNumFound(1L);
				apiRequest.setNumPATCH(0L);
				apiRequest.initDeepApiRequest(siteRequest);
				siteRequest.setApiRequest_(apiRequest);
				body.put("inheritPk", body.getValue("pk"));
				if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
					siteRequest.getRequestVars().put( "refresh", "false" );
				}

				SearchList<ReportSchedule> searchList = new SearchList<ReportSchedule>();
				searchList.setStore(true);
				searchList.q("*:*");
				searchList.setC(ReportSchedule.class);
				searchList.fq("deleted_docvalues_boolean:false");
				searchList.fq("archived_docvalues_boolean:false");
				searchList.fq("inheritPk_docvalues_string:" + SearchTool.escapeQueryChars(body.getString("pk")));
				searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
					try {
						if(searchList.size() >= 1) {
							ReportSchedule o = searchList.getList().stream().findFirst().orElse(null);
							ReportSchedule o2 = new ReportSchedule();
							JsonObject body2 = new JsonObject();
							for(String f : body.fieldNames()) {
								Object bodyVal = body.getValue(f);
								if(bodyVal instanceof JsonArray) {
									JsonArray bodyVals = (JsonArray)bodyVal;
									Collection<?> vals = (Collection<?>)o.obtainForClass(f);
									if(bodyVals.size() == vals.size()) {
										Boolean match = true;
										for(Object val : vals) {
											if(val != null) {
												if(!bodyVals.contains(val.toString())) {
													match = false;
													break;
												}
											} else {
												match = false;
												break;
											}
										}
										if(!match) {
											body2.put("set" + StringUtils.capitalize(f), bodyVal);
										}
									} else {
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
									}
								} else {
									o2.defineForClass(f, bodyVal);
									o2.relateForClass(f, bodyVal);
									if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.put("set" + StringUtils.capitalize(f), bodyVal);
								}
							}
							for(String f : Optional.ofNullable(o.getSaves()).orElse(new ArrayList<>())) {
								if(!body.fieldNames().contains(f)) {
									if(!StringUtils.containsAny(f, "pk", "created", "setCreated") && !Objects.equals(o.obtainForClass(f), o2.obtainForClass(f)))
										body2.putNull("set" + StringUtils.capitalize(f));
								}
							}
							if(body2.size() > 0) {
								siteRequest.setJsonObject(body2);
								patchReportScheduleFuture(o, true).onSuccess(b -> {
									LOG.info("Import ReportSchedule {} succeeded, modified ReportSchedule. ", body.getValue("pk"));
									eventHandler.handle(Future.succeededFuture());
								}).onFailure(ex -> {
									LOG.error(String.format("putimportReportScheduleFuture failed. "), ex);
									eventHandler.handle(Future.failedFuture(ex));
								});
							} else {
								eventHandler.handle(Future.succeededFuture());
							}
						} else {
							postReportScheduleFuture(siteRequest, true).onSuccess(b -> {
								LOG.info("Import ReportSchedule {} succeeded, created new ReportSchedule. ", body.getValue("pk"));
								eventHandler.handle(Future.succeededFuture());
							}).onFailure(ex -> {
								LOG.error(String.format("putimportReportScheduleFuture failed. "), ex);
								eventHandler.handle(Future.failedFuture(ex));
							});
						}
					} catch(Exception ex) {
						LOG.error(String.format("putimportReportScheduleFuture failed. "), ex);
						eventHandler.handle(Future.failedFuture(ex));
					}
				}).onFailure(ex -> {
					LOG.error(String.format("putimportReportScheduleFuture failed. "), ex);
					eventHandler.handle(Future.failedFuture(ex));
				});
			} catch(Exception ex) {
				LOG.error(String.format("putimportReportScheduleFuture failed. "), ex);
				eventHandler.handle(Future.failedFuture(ex));
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("putimportReportSchedule failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("putimportReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<ServiceResponse> response200PUTImportReportSchedule(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200PUTImportReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// POST //

	@Override
	public void postReportSchedule(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("postReportSchedule started. "));
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, "choice-reports-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);

				List<String> roles = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_REQUIRED + "_ReportSchedule")).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
				if(
						!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
						) {
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED", 
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", "roles required: " + String.join(", ", roles))
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					ApiRequest apiRequest = new ApiRequest();
					apiRequest.setRows(1L);
					apiRequest.setNumFound(1L);
					apiRequest.setNumPATCH(0L);
					apiRequest.initDeepApiRequest(siteRequest);
					siteRequest.setApiRequest_(apiRequest);
					eventBus.publish("websocketReportSchedule", JsonObject.mapFrom(apiRequest).toString());
					JsonObject params = new JsonObject();
					params.put("body", siteRequest.getJsonObject());
					params.put("path", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", new JsonObject());
					params.put("form", new JsonObject());
					JsonObject query = new JsonObject();
					Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
					Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					if(softCommit != null)
						query.put("softCommit", softCommit);
					if(commitWithin != null)
						query.put("commitWithin", commitWithin);
					params.put("query", query);
					JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request("choice-reports-enUS-ReportSchedule", json, new DeliveryOptions().addHeader("action", "postReportScheduleFuture")).onSuccess(a -> {
						JsonObject responseMessage = (JsonObject)a.body();
						JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
						apiRequest.setPk(Long.parseLong(responseBody.getString("pk")));
						eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(responseBody.encodePrettily()))));
						LOG.debug(String.format("postReportSchedule succeeded. "));
					}).onFailure(ex -> {
						LOG.error(String.format("postReportSchedule failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("postReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postReportSchedule failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("postReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	@Override
	public void postReportScheduleFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, "choice-reports-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			ApiRequest apiRequest = new ApiRequest();
			apiRequest.setRows(1L);
			apiRequest.setNumFound(1L);
			apiRequest.setNumPATCH(0L);
			apiRequest.initDeepApiRequest(siteRequest);
			siteRequest.setApiRequest_(apiRequest);
			if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
				siteRequest.getRequestVars().put( "refresh", "false" );
			}
			postReportScheduleFuture(siteRequest, false).onSuccess(o -> {
				eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(JsonObject.mapFrom(o).encodePrettily()))));
			}).onFailure(ex -> {
				eventHandler.handle(Future.failedFuture(ex));
			});
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("postReportSchedule failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("postReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}

	public Future<ReportSchedule> postReportScheduleFuture(SiteRequestEnUS siteRequest, Boolean inheritPk) {
		Promise<ReportSchedule> promise = Promise.promise();

		try {
			pgPool.withTransaction(sqlConnection -> {
				Promise<ReportSchedule> promise1 = Promise.promise();
				siteRequest.setSqlConnection(sqlConnection);
				createReportSchedule(siteRequest).onSuccess(reportSchedule -> {
					sqlPOSTReportSchedule(reportSchedule, inheritPk).onSuccess(b -> {
						defineReportSchedule(reportSchedule).onSuccess(c -> {
							relateReportSchedule(reportSchedule).onSuccess(d -> {
								indexReportSchedule(reportSchedule).onSuccess(e -> {
									promise1.complete(reportSchedule);
								}).onFailure(ex -> {
									promise1.fail(ex);
								});
							}).onFailure(ex -> {
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				siteRequest.setSqlConnection(null);
				promise.fail(ex);
			}).compose(reportSchedule -> {
				Promise<ReportSchedule> promise2 = Promise.promise();
				refreshReportSchedule(reportSchedule).onSuccess(a -> {
					try {
						ApiRequest apiRequest = siteRequest.getApiRequest_();
						if(apiRequest != null) {
							apiRequest.setNumPATCH(apiRequest.getNumPATCH() + 1);
							reportSchedule.apiRequestReportSchedule();
							eventBus.publish("websocketReportSchedule", JsonObject.mapFrom(apiRequest).toString());
						}
						promise2.complete(reportSchedule);
					} catch(Exception ex) {
						LOG.error(String.format("postReportScheduleFuture failed. "), ex);
						promise.fail(ex);
					}
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(reportSchedule -> {
				promise.complete(reportSchedule);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("postReportScheduleFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> sqlPOSTReportSchedule(ReportSchedule o, Boolean inheritPk) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE ReportSchedule SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			ReportSchedule o2 = new ReportSchedule();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			if(siteRequest.getSessionId() != null) {
				if(bParams.size() > 0) {
					bSql.append(", ");
				}
				bSql.append("sessionId=$" + num);
				num++;
				bParams.add(siteRequest.getSessionId());
			}
			if(siteRequest.getUserKey() != null) {
				if(bParams.size() > 0) {
					bSql.append(", ");
				}
				bSql.append("userKey=$" + num);
				num++;
				bParams.add(siteRequest.getUserKey());
			}

			if(jsonObject != null) {
				Set<String> entityVars = jsonObject.fieldNames();
				for(String entityVar : entityVars) {
					switch(entityVar) {
					case ReportSchedule.VAR_inheritPk:
						o2.setInheritPk(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_inheritPk + "=$" + num);
						num++;
						bParams.add(o2.sqlInheritPk());
						break;
					case ReportSchedule.VAR_created:
						o2.setCreated(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_created + "=$" + num);
						num++;
						bParams.add(o2.sqlCreated());
						break;
					case ReportSchedule.VAR_archived:
						o2.setArchived(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_archived + "=$" + num);
						num++;
						bParams.add(o2.sqlArchived());
						break;
					case ReportSchedule.VAR_deleted:
						o2.setDeleted(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_deleted + "=$" + num);
						num++;
						bParams.add(o2.sqlDeleted());
						break;
					case ReportSchedule.VAR_sessionId:
						o2.setSessionId(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_sessionId + "=$" + num);
						num++;
						bParams.add(o2.sqlSessionId());
						break;
					case ReportSchedule.VAR_userKey:
						o2.setUserKey(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_userKey + "=$" + num);
						num++;
						bParams.add(o2.sqlUserKey());
						break;
					case ReportSchedule.VAR_typeKey:
						Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
							futures1.add(Future.future(promise2 -> {
								search(siteRequest).query(ReportType.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("ReportType");
									}
									sql(siteRequest).update(ReportSchedule.class, pk).set(ReportSchedule.VAR_typeKey, ReportType.class, pk2).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case ReportSchedule.VAR_narrativeKeys:
						Optional.ofNullable(jsonObject.getJsonArray(entityVar)).orElse(new JsonArray()).stream().map(oVal -> oVal.toString()).forEach(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(ReportNarrative.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("ReportNarrative");
									}
									sql(siteRequest).update(ReportNarrative.class, pk2).set(ReportNarrative.VAR_scheduleKey, ReportSchedule.class, pk).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case ReportSchedule.VAR_eventKeys:
						Optional.ofNullable(jsonObject.getJsonArray(entityVar)).orElse(new JsonArray()).stream().map(oVal -> oVal.toString()).forEach(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(ReportEvent.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("ReportEvent");
									}
									sql(siteRequest).update(ReportEvent.class, pk2).set(ReportEvent.VAR_scheduleKey, ReportSchedule.class, pk).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case ReportSchedule.VAR_scheduleName:
						o2.setScheduleName(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_scheduleName + "=$" + num);
						num++;
						bParams.add(o2.sqlScheduleName());
						break;
					case ReportSchedule.VAR_frequencyOneTime:
						o2.setFrequencyOneTime(jsonObject.getBoolean(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_frequencyOneTime + "=$" + num);
						num++;
						bParams.add(o2.sqlFrequencyOneTime());
						break;
					case ReportSchedule.VAR_frequencyTimesPerYear:
						o2.setFrequencyTimesPerYear(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_frequencyTimesPerYear + "=$" + num);
						num++;
						bParams.add(o2.sqlFrequencyTimesPerYear());
						break;
					case ReportSchedule.VAR_frequencyYearsAfterCompletion:
						o2.setFrequencyYearsAfterCompletion(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_frequencyYearsAfterCompletion + "=$" + num);
						num++;
						bParams.add(o2.sqlFrequencyYearsAfterCompletion());
						break;
					case ReportSchedule.VAR_firstDueDate:
						o2.setFirstDueDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_firstDueDate + "=$" + num);
						num++;
						bParams.add(o2.sqlFirstDueDate());
						break;
					case ReportSchedule.VAR_dataPullDate:
						o2.setDataPullDate(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_dataPullDate + "=$" + num);
						num++;
						bParams.add(o2.sqlDataPullDate());
						break;
					case ReportSchedule.VAR_dataSources:
						o2.setDataSources(jsonObject.getString(entityVar));
						if(bParams.size() > 0) {
							bSql.append(", ");
						}
						bSql.append(ReportSchedule.VAR_dataSources + "=$" + num);
						num++;
						bParams.add(o2.sqlDataSources());
						break;
					}
				}
			}
			bSql.append(" WHERE pk=$" + num);
			if(bParams.size() > 0) {
			bParams.add(pk);
			num++;
				futures2.add(0, Future.future(a -> {
					sqlConnection.preparedQuery(bSql.toString())
							.execute(Tuple.tuple(bParams)
							).onSuccess(b -> {
						a.handle(Future.succeededFuture());
					}).onFailure(ex -> {
						RuntimeException ex2 = new RuntimeException("value ReportSchedule failed", ex);
						LOG.error(String.format("relateReportSchedule failed. "), ex2);
						a.handle(Future.failedFuture(ex2));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPOSTReportSchedule failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPOSTReportSchedule failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPOSTReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200POSTReportSchedule(ReportSchedule o) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			JsonObject json = JsonObject.mapFrom(o);
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200POSTReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// PATCH //

	@Override
	public void patchReportSchedule(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		LOG.debug(String.format("patchReportSchedule started. "));
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, "choice-reports-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);

				List<String> roles = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_REQUIRED + "_ReportSchedule")).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
				if(
						!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
						) {
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED", 
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", "roles required: " + String.join(", ", roles))
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					searchReportScheduleList(siteRequest, false, true, true).onSuccess(listReportSchedule -> {
						try {
							List<String> roles2 = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_ADMIN)).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
							if(listReportSchedule.getQueryResponse().getResponse().getNumFound() > 1
									&& !CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles2)
									&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles2)
									) {
								String message = String.format("roles required: " + String.join(", ", roles2));
								LOG.error(message);
								error(siteRequest, eventHandler, new RuntimeException(message));
							} else {

								ApiRequest apiRequest = new ApiRequest();
								apiRequest.setRows(listReportSchedule.getRequest().getRows());
								apiRequest.setNumFound(listReportSchedule.getQueryResponse().getResponse().getNumFound());
								apiRequest.setNumPATCH(0L);
								apiRequest.initDeepApiRequest(siteRequest);
								siteRequest.setApiRequest_(apiRequest);
								if(apiRequest.getNumFound() == 1L)
									apiRequest.setOriginal(listReportSchedule.first());
								apiRequest.setPk(Optional.ofNullable(listReportSchedule.first()).map(o2 -> o2.getPk()).orElse(null));
								eventBus.publish("websocketReportSchedule", JsonObject.mapFrom(apiRequest).toString());

								listPATCHReportSchedule(apiRequest, listReportSchedule).onSuccess(e -> {
									response200PATCHReportSchedule(siteRequest).onSuccess(response -> {
										LOG.debug(String.format("patchReportSchedule succeeded. "));
										eventHandler.handle(Future.succeededFuture(response));
									}).onFailure(ex -> {
										LOG.error(String.format("patchReportSchedule failed. "), ex);
										error(siteRequest, eventHandler, ex);
									});
								}).onFailure(ex -> {
									LOG.error(String.format("patchReportSchedule failed. "), ex);
									error(siteRequest, eventHandler, ex);
								});
							}
						} catch(Exception ex) {
							LOG.error(String.format("patchReportSchedule failed. "), ex);
							error(siteRequest, eventHandler, ex);
						}
					}).onFailure(ex -> {
						LOG.error(String.format("patchReportSchedule failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("patchReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("patchReportSchedule failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("patchReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<Void> listPATCHReportSchedule(ApiRequest apiRequest, SearchList<ReportSchedule> listReportSchedule) {
		Promise<Void> promise = Promise.promise();
		List<Future> futures = new ArrayList<>();
		SiteRequestEnUS siteRequest = listReportSchedule.getSiteRequest_(SiteRequestEnUS.class);
		listReportSchedule.getList().forEach(o -> {
			SiteRequestEnUS siteRequest2 = generateSiteRequest(siteRequest.getUser(), siteRequest.getServiceRequest(), siteRequest.getJsonObject(), SiteRequestEnUS.class);
			o.setSiteRequest_(siteRequest2);
			siteRequest2.setApiRequest_(siteRequest.getApiRequest_());
			futures.add(Future.future(promise1 -> {
				patchReportScheduleFuture(o, false).onSuccess(a -> {
					promise1.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("listPATCHReportSchedule failed. "), ex);
					promise1.fail(ex);
				});
			}));
		});
		CompositeFuture.all(futures).onSuccess( a -> {
			if(apiRequest != null) {
				apiRequest.setNumPATCH(apiRequest.getNumPATCH() + listReportSchedule.getQueryResponse().getResponse().getDocs().size());
				if(apiRequest.getNumFound() == 1L)
					listReportSchedule.first().apiRequestReportSchedule();
				eventBus.publish("websocketReportSchedule", JsonObject.mapFrom(apiRequest).toString());
			}
			listReportSchedule.next().onSuccess(next -> {
				if(next) {
					listPATCHReportSchedule(apiRequest, listReportSchedule);
				} else {
					promise.complete();
				}
			}).onFailure(ex -> {
				LOG.error(String.format("listPATCHReportSchedule failed. "), ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			LOG.error(String.format("listPATCHReportSchedule failed. "), ex);
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override
	public void patchReportScheduleFuture(JsonObject body, ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, "choice-reports-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {
				siteRequest.setJsonObject(body);
				serviceRequest.getParams().getJsonObject("query").put("rows", 1);
				searchReportScheduleList(siteRequest, false, true, true).onSuccess(listReportSchedule -> {
					try {
						ReportSchedule o = listReportSchedule.first();
						if(o != null && listReportSchedule.getQueryResponse().getResponse().getNumFound() == 1) {
							ApiRequest apiRequest = new ApiRequest();
							apiRequest.setRows(1L);
							apiRequest.setNumFound(1L);
							apiRequest.setNumPATCH(0L);
							apiRequest.initDeepApiRequest(siteRequest);
							siteRequest.setApiRequest_(apiRequest);
							if(Optional.ofNullable(serviceRequest.getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getJsonArray("var")).orElse(new JsonArray()).stream().filter(s -> "refresh:false".equals(s)).count() > 0L) {
								siteRequest.getRequestVars().put( "refresh", "false" );
							}
							if(apiRequest.getNumFound() == 1L)
								apiRequest.setOriginal(o);
							apiRequest.setPk(Optional.ofNullable(listReportSchedule.first()).map(o2 -> o2.getPk()).orElse(null));
							eventBus.publish("websocketReportSchedule", JsonObject.mapFrom(apiRequest).toString());
							patchReportScheduleFuture(o, false).onSuccess(a -> {
								eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
							}).onFailure(ex -> {
								eventHandler.handle(Future.failedFuture(ex));
							});
						} else {
							eventHandler.handle(Future.succeededFuture(ServiceResponse.completedWithJson(Buffer.buffer(new JsonObject().encodePrettily()))));
						}
					} catch(Exception ex) {
						LOG.error(String.format("patchReportSchedule failed. "), ex);
						error(siteRequest, eventHandler, ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("patchReportSchedule failed. "), ex);
					error(siteRequest, eventHandler, ex);
				});
			} catch(Exception ex) {
				LOG.error(String.format("patchReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			LOG.error(String.format("patchReportSchedule failed. "), ex);
			error(null, eventHandler, ex);
		});
	}

	public Future<ReportSchedule> patchReportScheduleFuture(ReportSchedule o, Boolean inheritPk) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		Promise<ReportSchedule> promise = Promise.promise();

		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			pgPool.withTransaction(sqlConnection -> {
				Promise<ReportSchedule> promise1 = Promise.promise();
				siteRequest.setSqlConnection(sqlConnection);
				sqlPATCHReportSchedule(o, inheritPk).onSuccess(reportSchedule -> {
					defineReportSchedule(reportSchedule).onSuccess(c -> {
						relateReportSchedule(reportSchedule).onSuccess(d -> {
							indexReportSchedule(reportSchedule).onSuccess(e -> {
								promise1.complete(reportSchedule);
							}).onFailure(ex -> {
								promise1.fail(ex);
							});
						}).onFailure(ex -> {
							promise1.fail(ex);
						});
					}).onFailure(ex -> {
						promise1.fail(ex);
					});
				}).onFailure(ex -> {
					promise1.fail(ex);
				});
				return promise1.future();
			}).onSuccess(a -> {
				siteRequest.setSqlConnection(null);
			}).onFailure(ex -> {
				siteRequest.setSqlConnection(null);
				promise.fail(ex);
			}).compose(reportSchedule -> {
				Promise<ReportSchedule> promise2 = Promise.promise();
				refreshReportSchedule(reportSchedule).onSuccess(a -> {
					promise2.complete(reportSchedule);
				}).onFailure(ex -> {
					promise2.fail(ex);
				});
				return promise2.future();
			}).onSuccess(reportSchedule -> {
				promise.complete(reportSchedule);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("patchReportScheduleFuture failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ReportSchedule> sqlPATCHReportSchedule(ReportSchedule o, Boolean inheritPk) {
		Promise<ReportSchedule> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Integer num = 1;
			StringBuilder bSql = new StringBuilder("UPDATE ReportSchedule SET ");
			List<Object> bParams = new ArrayList<Object>();
			Long pk = o.getPk();
			JsonObject jsonObject = siteRequest.getJsonObject();
			Set<String> methodNames = jsonObject.fieldNames();
			ReportSchedule o2 = new ReportSchedule();
			o2.setSiteRequest_(siteRequest);
			List<Future> futures1 = new ArrayList<>();
			List<Future> futures2 = new ArrayList<>();

			for(String entityVar : methodNames) {
				switch(entityVar) {
					case "setInheritPk":
							o2.setInheritPk(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(ReportSchedule.VAR_inheritPk + "=$" + num);
							num++;
							bParams.add(o2.sqlInheritPk());
						break;
					case "setArchived":
							o2.setArchived(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(ReportSchedule.VAR_archived + "=$" + num);
							num++;
							bParams.add(o2.sqlArchived());
						break;
					case "setDeleted":
							o2.setDeleted(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(ReportSchedule.VAR_deleted + "=$" + num);
							num++;
							bParams.add(o2.sqlDeleted());
						break;
					case "setTypeKey":
						Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
							futures1.add(Future.future(promise2 -> {
								search(siteRequest).query(ReportType.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("ReportType");
									}
									sql(siteRequest).update(ReportSchedule.class, pk).set(ReportSchedule.VAR_typeKey, ReportType.class, pk2).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "setNarrativeKeys":
						JsonArray setNarrativeKeysValues = Optional.ofNullable(jsonObject.getJsonArray(entityVar)).orElse(new JsonArray());
						setNarrativeKeysValues.stream().map(oVal -> oVal.toString()).forEach(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(ReportNarrative.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("ReportNarrative");
									}
									sql(siteRequest).update(ReportNarrative.class, pk2).set(ReportNarrative.VAR_scheduleKey, ReportSchedule.class, pk).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						Optional.ofNullable(o.getNarrativeKeys()).orElse(Arrays.asList()).stream().filter(oVal -> oVal != null && !setNarrativeKeysValues.contains(oVal.toString())).forEach(pk2 -> {
							if(!pks.contains(pk2)) {
								pks.add(pk2);
								classes.add("ReportNarrative");
							}
							futures2.add(Future.future(promise2 -> {
								sql(siteRequest).update(ReportNarrative.class, pk2).setToNull(ReportNarrative.VAR_scheduleKey, ReportSchedule.class, pk2).onSuccess(a -> {
									promise2.complete();
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "addAllNarrativeKeys":
						JsonArray addAllNarrativeKeysValues = Optional.ofNullable(jsonObject.getJsonArray(entityVar)).orElse(new JsonArray());
						addAllNarrativeKeysValues.stream().map(oVal -> oVal.toString()).forEach(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(ReportNarrative.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("ReportNarrative");
									}
									sql(siteRequest).update(ReportNarrative.class, pk2).set(ReportNarrative.VAR_scheduleKey, ReportSchedule.class, pk).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "addNarrativeKeys":
						Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(ReportNarrative.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("ReportNarrative");
									}
									sql(siteRequest).update(ReportNarrative.class, pk2).set(ReportNarrative.VAR_scheduleKey, ReportSchedule.class, pk).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "removeNarrativeKeys":
						Optional.ofNullable(jsonObject.getString(entityVar)).map(val -> Long.parseLong(val)).ifPresent(pk2 -> {
							if(!pks.contains(pk2)) {
								pks.add(pk2);
								classes.add("ReportNarrative");
							}
							futures2.add(Future.future(promise2 -> {
								sql(siteRequest).update(ReportNarrative.class, pk2).setToNull(ReportNarrative.VAR_scheduleKey, ReportSchedule.class, pk2).onSuccess(a -> {
									promise2.complete();
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "setEventKeys":
						JsonArray setEventKeysValues = Optional.ofNullable(jsonObject.getJsonArray(entityVar)).orElse(new JsonArray());
						setEventKeysValues.stream().map(oVal -> oVal.toString()).forEach(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(ReportEvent.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("ReportEvent");
									}
									sql(siteRequest).update(ReportEvent.class, pk2).set(ReportEvent.VAR_scheduleKey, ReportSchedule.class, pk).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						Optional.ofNullable(o.getEventKeys()).orElse(Arrays.asList()).stream().filter(oVal -> oVal != null && !setEventKeysValues.contains(oVal.toString())).forEach(pk2 -> {
							if(!pks.contains(pk2)) {
								pks.add(pk2);
								classes.add("ReportEvent");
							}
							futures2.add(Future.future(promise2 -> {
								sql(siteRequest).update(ReportEvent.class, pk2).setToNull(ReportEvent.VAR_scheduleKey, ReportSchedule.class, pk2).onSuccess(a -> {
									promise2.complete();
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "addAllEventKeys":
						JsonArray addAllEventKeysValues = Optional.ofNullable(jsonObject.getJsonArray(entityVar)).orElse(new JsonArray());
						addAllEventKeysValues.stream().map(oVal -> oVal.toString()).forEach(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(ReportEvent.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("ReportEvent");
									}
									sql(siteRequest).update(ReportEvent.class, pk2).set(ReportEvent.VAR_scheduleKey, ReportSchedule.class, pk).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "addEventKeys":
						Optional.ofNullable(jsonObject.getString(entityVar)).ifPresent(val -> {
							futures2.add(Future.future(promise2 -> {
								search(siteRequest).query(ReportEvent.class, val, inheritPk).onSuccess(pk2 -> {
									if(!pks.contains(pk2)) {
										pks.add(pk2);
										classes.add("ReportEvent");
									}
									sql(siteRequest).update(ReportEvent.class, pk2).set(ReportEvent.VAR_scheduleKey, ReportSchedule.class, pk).onSuccess(a -> {
										promise2.complete();
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "removeEventKeys":
						Optional.ofNullable(jsonObject.getString(entityVar)).map(val -> Long.parseLong(val)).ifPresent(pk2 -> {
							if(!pks.contains(pk2)) {
								pks.add(pk2);
								classes.add("ReportEvent");
							}
							futures2.add(Future.future(promise2 -> {
								sql(siteRequest).update(ReportEvent.class, pk2).setToNull(ReportEvent.VAR_scheduleKey, ReportSchedule.class, pk2).onSuccess(a -> {
									promise2.complete();
								}).onFailure(ex -> {
									promise2.fail(ex);
								});
							}));
						});
						break;
					case "setScheduleName":
							o2.setScheduleName(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(ReportSchedule.VAR_scheduleName + "=$" + num);
							num++;
							bParams.add(o2.sqlScheduleName());
						break;
					case "setFrequencyOneTime":
							o2.setFrequencyOneTime(jsonObject.getBoolean(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(ReportSchedule.VAR_frequencyOneTime + "=$" + num);
							num++;
							bParams.add(o2.sqlFrequencyOneTime());
						break;
					case "setFrequencyTimesPerYear":
							o2.setFrequencyTimesPerYear(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(ReportSchedule.VAR_frequencyTimesPerYear + "=$" + num);
							num++;
							bParams.add(o2.sqlFrequencyTimesPerYear());
						break;
					case "setFrequencyYearsAfterCompletion":
							o2.setFrequencyYearsAfterCompletion(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(ReportSchedule.VAR_frequencyYearsAfterCompletion + "=$" + num);
							num++;
							bParams.add(o2.sqlFrequencyYearsAfterCompletion());
						break;
					case "setFirstDueDate":
							o2.setFirstDueDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(ReportSchedule.VAR_firstDueDate + "=$" + num);
							num++;
							bParams.add(o2.sqlFirstDueDate());
						break;
					case "setDataPullDate":
							o2.setDataPullDate(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(ReportSchedule.VAR_dataPullDate + "=$" + num);
							num++;
							bParams.add(o2.sqlDataPullDate());
						break;
					case "setDataSources":
							o2.setDataSources(jsonObject.getString(entityVar));
							if(bParams.size() > 0)
								bSql.append(", ");
							bSql.append(ReportSchedule.VAR_dataSources + "=$" + num);
							num++;
							bParams.add(o2.sqlDataSources());
						break;
				}
			}
			bSql.append(" WHERE pk=$" + num);
			if(bParams.size() > 0) {
				bParams.add(pk);
				num++;
				futures2.add(0, Future.future(a -> {
					sqlConnection.preparedQuery(bSql.toString())
							.execute(Tuple.tuple(bParams)
							).onSuccess(b -> {
						a.handle(Future.succeededFuture());
					}).onFailure(ex -> {
						RuntimeException ex2 = new RuntimeException("value ReportSchedule failed", ex);
						LOG.error(String.format("relateReportSchedule failed. "), ex2);
						a.handle(Future.failedFuture(ex2));
					});
				}));
			}
			CompositeFuture.all(futures1).onSuccess(a -> {
				CompositeFuture.all(futures2).onSuccess(b -> {
					ReportSchedule o3 = new ReportSchedule();
					o3.setSiteRequest_(o.getSiteRequest_());
					o3.setPk(pk);
					promise.complete(o3);
				}).onFailure(ex -> {
					LOG.error(String.format("sqlPATCHReportSchedule failed. "), ex);
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("sqlPATCHReportSchedule failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("sqlPATCHReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<ServiceResponse> response200PATCHReportSchedule(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			JsonObject json = new JsonObject();
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200PATCHReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// GET //

	@Override
	public void getReportSchedule(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, "choice-reports-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {

				List<String> roles = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_REQUIRED + "_ReportSchedule")).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
				List<String> roleReads = Arrays.asList("");
				if(
						!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roleReads)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roleReads)
						) {
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED", 
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", "roles required: " + String.join(", ", roles))
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					searchReportScheduleList(siteRequest, false, true, false).onSuccess(listReportSchedule -> {
						response200GETReportSchedule(listReportSchedule).onSuccess(response -> {
							eventHandler.handle(Future.succeededFuture(response));
							LOG.debug(String.format("getReportSchedule succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("getReportSchedule failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("getReportSchedule failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("getReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("getReportSchedule failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("getReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<ServiceResponse> response200GETReportSchedule(SearchList<ReportSchedule> listReportSchedule) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listReportSchedule.getSiteRequest_(SiteRequestEnUS.class);
			JsonObject json = JsonObject.mapFrom(listReportSchedule.getList().stream().findFirst().orElse(null));
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200GETReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// Search //

	@Override
	public void searchReportSchedule(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, "choice-reports-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {

				List<String> roles = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_REQUIRED + "_ReportSchedule")).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
				List<String> roleReads = Arrays.asList("");
				if(
						!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roleReads)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roleReads)
						) {
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED", 
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", "roles required: " + String.join(", ", roles))
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					searchReportScheduleList(siteRequest, false, true, false).onSuccess(listReportSchedule -> {
						response200SearchReportSchedule(listReportSchedule).onSuccess(response -> {
							eventHandler.handle(Future.succeededFuture(response));
							LOG.debug(String.format("searchReportSchedule succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("searchReportSchedule failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("searchReportSchedule failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("searchReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchReportSchedule failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("searchReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public Future<ServiceResponse> response200SearchReportSchedule(SearchList<ReportSchedule> listReportSchedule) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listReportSchedule.getSiteRequest_(SiteRequestEnUS.class);
			SolrResponse responseSearch = listReportSchedule.getQueryResponse();
			List<SolrResponse.Doc> solrDocuments = listReportSchedule.getQueryResponse().getResponse().getDocs();
			Long searchInMillis = Long.valueOf(responseSearch.getResponseHeader().getqTime());
			Long startNum = listReportSchedule.getRequest().getStart();
			Long foundNum = responseSearch.getResponse().getNumFound();
			Integer returnedNum = responseSearch.getResponse().getDocs().size();
			String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
			String nextCursorMark = responseSearch.getNextCursorMark();
			String exceptionSearch = Optional.ofNullable(responseSearch.getError()).map(error -> error.getMsg()).orElse(null);
			List<String> fls = listReportSchedule.getRequest().getFields();

			JsonObject json = new JsonObject();
			json.put("startNum", startNum);
			json.put("foundNum", foundNum);
			json.put("returnedNum", returnedNum);
			if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
				json.put("searchTime", searchTime);
			}
			if(nextCursorMark != null) {
				json.put("nextCursorMark", nextCursorMark);
			}
			JsonArray l = new JsonArray();
			listReportSchedule.getList().stream().forEach(o -> {
				JsonObject json2 = JsonObject.mapFrom(o);
				if(fls.size() > 0) {
					Set<String> fieldNames = new HashSet<String>();
					for(String fieldName : json2.fieldNames()) {
						String v = ReportSchedule.varIndexedReportSchedule(fieldName);
						if(v != null)
							fieldNames.add(ReportSchedule.varIndexedReportSchedule(fieldName));
					}
					if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves_docvalues_strings")) {
						fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves_docvalues_strings")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
						fieldNames.remove("pk_docvalues_long");
						fieldNames.remove("created_docvalues_date");
					}
					else if(fls.size() >= 1) {
						fieldNames.removeAll(fls);
					}
					for(String fieldName : fieldNames) {
						if(!fls.contains(fieldName))
							json2.remove(fieldName);
					}
				}
				l.add(json2);
			});
			json.put("list", l);

			SolrResponse.FacetFields facetFields = Optional.ofNullable(responseSearch.getFacetCounts()).map(f -> f.getFacetFields()).orElse(null);
			if(facetFields != null) {
				JsonObject facetFieldsJson = new JsonObject();
				json.put("facet_fields", facetFieldsJson);
				for(SolrResponse.FacetField facetField : facetFields.getFacets().values()) {
					String facetFieldVar = StringUtils.substringBefore(facetField.getName(), "_docvalues_");
					JsonObject facetFieldCounts = new JsonObject();
					facetFieldsJson.put(facetFieldVar, facetFieldCounts);
					facetField.getCounts().forEach((name, count) -> {
						facetFieldCounts.put(name, count);
					});
				}
			}

			SolrResponse.FacetRanges facetRanges = Optional.ofNullable(responseSearch.getFacetCounts()).map(f -> f.getFacetRanges()).orElse(null);
			if(facetRanges != null) {
				JsonObject rangeJson = new JsonObject();
				json.put("facet_ranges", rangeJson);
				for(SolrResponse.FacetRange rangeFacet : facetRanges.getRanges().values()) {
					JsonObject rangeFacetJson = new JsonObject();
					String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
					rangeJson.put(rangeFacetVar, rangeFacetJson);
					JsonObject rangeFacetCountsMap = new JsonObject();
					rangeFacetJson.put("counts", rangeFacetCountsMap);
					rangeFacet.getCounts().forEach((name, count) -> {
						rangeFacetCountsMap.put(name, count);
					});
				}
			}

			SolrResponse.FacetPivot facetPivot = Optional.ofNullable(responseSearch.getFacetCounts()).map(f -> f.getFacetPivot()).orElse(null);
			if(facetPivot != null) {
				JsonObject facetPivotJson = new JsonObject();
				json.put("facet_pivot", facetPivotJson);
				for(SolrResponse.Pivot pivot : facetPivot.getPivot().values()) {
					String[] varsIndexed = pivot.getName().trim().split(",");
					String[] entityVars = new String[varsIndexed.length];
					for(Integer i = 0; i < entityVars.length; i++) {
						String entityIndexed = varsIndexed[i];
						entityVars[i] = StringUtils.substringBefore(entityIndexed, "_docvalues_");
					}
					JsonArray pivotArray = new JsonArray();
					facetPivotJson.put(StringUtils.join(entityVars, ","), pivotArray);
					responsePivotSearchReportSchedule(pivot.getInternalPivot(), pivotArray);
				}
			}
			if(exceptionSearch != null) {
				json.put("exceptionSearch", exceptionSearch);
			}
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotSearchReportSchedule(List<SolrResponse.Pivot> pivots, JsonArray pivotArray) {
		for(SolrResponse.Pivot pivotField : pivots) {
			String entityIndexed = pivotField.getField();
			String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
			JsonObject pivotJson = new JsonObject();
			pivotArray.add(pivotJson);
			pivotJson.put("field", entityVar);
			pivotJson.put("value", pivotField.getValue());
			pivotJson.put("count", pivotField.getCount());
			Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
			List<SolrResponse.Pivot> pivotFields2 = pivotField.getInternalPivot();
			if(pivotRanges != null) {
				JsonObject rangeJson = new JsonObject();
				pivotJson.put("ranges", rangeJson);
				for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
					JsonObject rangeFacetJson = new JsonObject();
					String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
					rangeJson.put(rangeFacetVar, rangeFacetJson);
					JsonObject rangeFacetCountsObject = new JsonObject();
					rangeFacetJson.put("counts", rangeFacetCountsObject);
					rangeFacet.getCounts().forEach((value, count) -> {
						rangeFacetCountsObject.put(value, count);
					});
				}
			}
			if(pivotFields2 != null) {
				JsonArray pivotArray2 = new JsonArray();
				pivotJson.put("pivot", pivotArray2);
				responsePivotSearchReportSchedule(pivotFields2, pivotArray2);
			}
		}
	}

	// SearchPage //

	@Override
	public void searchpageReportScheduleId(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		searchpageReportSchedule(serviceRequest, eventHandler);
	}

	@Override
	public void searchpageReportSchedule(ServiceRequest serviceRequest, Handler<AsyncResult<ServiceResponse>> eventHandler) {
		user(serviceRequest, SiteRequestEnUS.class, SiteUser.class, "choice-reports-enUS-SiteUser", "postSiteUserFuture", "patchSiteUserFuture").onSuccess(siteRequest -> {
			try {

				List<String> roles = Optional.ofNullable(config.getValue(ConfigKeys.AUTH_ROLES_REQUIRED + "_ReportSchedule")).map(v -> v instanceof JsonArray ? (JsonArray)v : new JsonArray(v.toString())).orElse(new JsonArray()).getList();
				List<String> roleReads = Arrays.asList("");
				if(
						!CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roles)
						&& !CollectionUtils.containsAny(siteRequest.getUserResourceRoles(), roleReads)
						&& !CollectionUtils.containsAny(siteRequest.getUserRealmRoles(), roleReads)
						) {
					eventHandler.handle(Future.succeededFuture(
						new ServiceResponse(401, "UNAUTHORIZED", 
							Buffer.buffer().appendString(
								new JsonObject()
									.put("errorCode", "401")
									.put("errorMessage", "roles required: " + String.join(", ", roles))
									.encodePrettily()
								), MultiMap.caseInsensitiveMultiMap()
						)
					));
				} else {
					searchReportScheduleList(siteRequest, false, true, false).onSuccess(listReportSchedule -> {
						response200SearchPageReportSchedule(listReportSchedule).onSuccess(response -> {
							eventHandler.handle(Future.succeededFuture(response));
							LOG.debug(String.format("searchpageReportSchedule succeeded. "));
						}).onFailure(ex -> {
							LOG.error(String.format("searchpageReportSchedule failed. "), ex);
							error(siteRequest, eventHandler, ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("searchpageReportSchedule failed. "), ex);
						error(siteRequest, eventHandler, ex);
					});
				}
			} catch(Exception ex) {
				LOG.error(String.format("searchpageReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		}).onFailure(ex -> {
			if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
				try {
					eventHandler.handle(Future.succeededFuture(new ServiceResponse(302, "Found", null, MultiMap.caseInsensitiveMultiMap().add(HttpHeaders.LOCATION, "/logout?redirect_uri=" + URLEncoder.encode(serviceRequest.getExtra().getString("uri"), "UTF-8")))));
				} catch(Exception ex2) {
					LOG.error(String.format("searchpageReportSchedule failed. ", ex2));
					error(null, eventHandler, ex2);
				}
			} else {
				LOG.error(String.format("searchpageReportSchedule failed. "), ex);
				error(null, eventHandler, ex);
			}
		});
	}


	public void searchpageReportSchedulePageInit(ReportSchedulePage page, SearchList<ReportSchedule> listReportSchedule) {
	}

	public String templateSearchPageReportSchedule() {
		return Optional.ofNullable(config.getString(ConfigKeys.TEMPLATE_PATH)).orElse("templates") + "/enUS/ReportSchedulePage";
	}
	public Future<ServiceResponse> response200SearchPageReportSchedule(SearchList<ReportSchedule> listReportSchedule) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listReportSchedule.getSiteRequest_(SiteRequestEnUS.class);
			ReportSchedulePage page = new ReportSchedulePage();
			MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
			siteRequest.setRequestHeaders(requestHeaders);

			if(listReportSchedule.size() == 1)
				siteRequest.setRequestPk(listReportSchedule.get(0).getPk());
			page.setSearchListReportSchedule_(listReportSchedule);
			page.setSiteRequest_(siteRequest);
			page.promiseDeepReportSchedulePage(siteRequest).onSuccess(a -> {
				JsonObject json = JsonObject.mapFrom(page);
				templateEngine.render(json, templateSearchPageReportSchedule()).onSuccess(buffer -> {
					promise.complete(new ServiceResponse(200, "OK", buffer, requestHeaders));
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("response200SearchPageReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	// General //

	public Future<ReportSchedule> createReportSchedule(SiteRequestEnUS siteRequest) {
		Promise<ReportSchedule> promise = Promise.promise();
		try {
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			String userId = siteRequest.getUserId();
			Long userKey = siteRequest.getUserKey();
			ZonedDateTime created = Optional.ofNullable(siteRequest.getJsonObject()).map(j -> j.getString("created")).map(s -> ZonedDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))))).orElse(ZonedDateTime.now(ZoneId.of(config.getString(ConfigKeys.SITE_ZONE))));

			sqlConnection.preparedQuery("INSERT INTO ReportSchedule(created, userKey) VALUES($1, $2) RETURNING pk")
					.collecting(Collectors.toList())
					.execute(Tuple.of(created.toOffsetDateTime(), userKey)).onSuccess(result -> {
				Row createLine = result.value().stream().findFirst().orElseGet(() -> null);
				Long pk = createLine.getLong(0);
				ReportSchedule o = new ReportSchedule();
				o.setPk(pk);
				o.setSiteRequest_(siteRequest);
				promise.complete(o);
			}).onFailure(ex -> {
				RuntimeException ex2 = new RuntimeException(ex);
				LOG.error("createReportSchedule failed. ", ex2);
				promise.fail(ex2);
			});
		} catch(Exception ex) {
			LOG.error(String.format("createReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public void searchReportScheduleQ(SearchList<ReportSchedule> searchList, String entityVar, String valueIndexed, String varIndexed) {
		searchList.q(varIndexed + ":" + ("*".equals(valueIndexed) ? valueIndexed : SearchTool.escapeQueryChars(valueIndexed)));
		if(!"*".equals(entityVar)) {
		}
	}

	public String searchReportScheduleFq(SearchList<ReportSchedule> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		if(StringUtils.startsWith(valueIndexed, "[")) {
			String[] fqs = StringUtils.substringBefore(StringUtils.substringAfter(valueIndexed, "["), "]").split(" TO ");
			if(fqs.length != 2)
				throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
			String fq1 = fqs[0].equals("*") ? fqs[0] : ReportSchedule.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequestEnUS.class), fqs[0]);
			String fq2 = fqs[1].equals("*") ? fqs[1] : ReportSchedule.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequestEnUS.class), fqs[1]);
			 return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
		} else {
			return varIndexed + ":" + SearchTool.escapeQueryChars(ReportSchedule.staticSearchFqForClass(entityVar, searchList.getSiteRequest_(SiteRequestEnUS.class), valueIndexed)).replace("\\", "\\\\");
		}
	}

	public void searchReportScheduleSort(SearchList<ReportSchedule> searchList, String entityVar, String valueIndexed, String varIndexed) {
		if(varIndexed == null)
			throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
		searchList.sort(varIndexed, valueIndexed);
	}

	public void searchReportScheduleRows(SearchList<ReportSchedule> searchList, Long valueRows) {
			searchList.rows(valueRows != null ? valueRows : 10L);
	}

	public void searchReportScheduleStart(SearchList<ReportSchedule> searchList, Long valueStart) {
		searchList.start(valueStart);
	}

	public void searchReportScheduleVar(SearchList<ReportSchedule> searchList, String var, String value) {
		searchList.getSiteRequest_(SiteRequestEnUS.class).getRequestVars().put(var, value);
	}

	public void searchReportScheduleUri(SearchList<ReportSchedule> searchList) {
	}

	public Future<ServiceResponse> varsReportSchedule(SiteRequestEnUS siteRequest) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			ServiceRequest serviceRequest = siteRequest.getServiceRequest();

			serviceRequest.getParams().getJsonObject("query").stream().filter(paramRequest -> "var".equals(paramRequest.getKey()) && paramRequest.getValue() != null).findFirst().ifPresent(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					for(Object paramObject : paramObjects) {
						entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
						valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
						siteRequest.getRequestVars().put(entityVar, valueIndexed);
					}
				} catch(Exception ex) {
					LOG.error(String.format("searchReportSchedule failed. "), ex);
					promise.fail(ex);
				}
			});
			promise.complete();
		} catch(Exception ex) {
			LOG.error(String.format("searchReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<SearchList<ReportSchedule>> searchReportScheduleList(SiteRequestEnUS siteRequest, Boolean populate, Boolean store, Boolean modify) {
		Promise<SearchList<ReportSchedule>> promise = Promise.promise();
		try {
			ServiceRequest serviceRequest = siteRequest.getServiceRequest();
			String entityListStr = siteRequest.getServiceRequest().getParams().getJsonObject("query").getString("fl");
			String[] entityList = entityListStr == null ? null : entityListStr.split(",\\s*");
			SearchList<ReportSchedule> searchList = new SearchList<ReportSchedule>();
			searchList.setPopulate(populate);
			searchList.setStore(store);
			searchList.q("*:*");
			searchList.setC(ReportSchedule.class);
			searchList.setSiteRequest_(siteRequest);
			if(entityList != null) {
				for(String v : entityList) {
					searchList.fl(ReportSchedule.varIndexedReportSchedule(v));
				}
			}

			String id = serviceRequest.getParams().getJsonObject("path").getString("id");
			if(id != null && NumberUtils.isCreatable(id)) {
				searchList.fq("(pk_docvalues_long:" + SearchTool.escapeQueryChars(id) + " OR objectId_docvalues_string:" + SearchTool.escapeQueryChars(id) + ")");
			} else if(id != null) {
				searchList.fq("objectId_docvalues_string:" + SearchTool.escapeQueryChars(id));
			}

			serviceRequest.getParams().getJsonObject("query").forEach(paramRequest -> {
				String entityVar = null;
				String valueIndexed = null;
				String varIndexed = null;
				String valueSort = null;
				Long valueStart = null;
				Long valueRows = null;
				String valueCursorMark = null;
				String paramName = paramRequest.getKey();
				Object paramValuesObject = paramRequest.getValue();
				JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

				try {
					if(paramValuesObject != null && "facet.pivot".equals(paramName)) {
						Matcher mFacetPivot = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher(StringUtils.join(paramObjects.getList().toArray(), ","));
						boolean foundFacetPivot = mFacetPivot.find();
						if(foundFacetPivot) {
							String solrLocalParams = mFacetPivot.group(1);
							String[] entityVars = mFacetPivot.group(2).trim().split(",");
							String[] varsIndexed = new String[entityVars.length];
							for(Integer i = 0; i < entityVars.length; i++) {
								entityVar = entityVars[i];
								varsIndexed[i] = ReportSchedule.varIndexedReportSchedule(entityVar);
							}
							searchList.facetPivot((solrLocalParams == null ? "" : solrLocalParams) + StringUtils.join(varsIndexed, ","));
						}
					} else if(paramValuesObject != null) {
						for(Object paramObject : paramObjects) {
							switch(paramName) {
								case "q":
									Matcher mQ = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|\\^|$)))").matcher((String)paramObject);
									boolean foundQ = mQ.find();
									if(foundQ) {
										StringBuffer sb = new StringBuffer();
										while(foundQ) {
											entityVar = mQ.group(1).trim();
											valueIndexed = mQ.group(2).trim();
											varIndexed = ReportSchedule.varIndexedReportSchedule(entityVar);
											String entityQ = searchReportScheduleFq(searchList, entityVar, valueIndexed, varIndexed);
											mQ.appendReplacement(sb, entityQ);
											foundQ = mQ.find();
										}
										mQ.appendTail(sb);
										searchList.q(sb.toString());
									}
									break;
								case "fq":
									Matcher mFq = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|$)))").matcher((String)paramObject);
									boolean foundFq = mFq.find();
									if(foundFq) {
										StringBuffer sb = new StringBuffer();
										while(foundFq) {
											entityVar = mFq.group(1).trim();
											valueIndexed = mFq.group(2).trim();
											varIndexed = ReportSchedule.varIndexedReportSchedule(entityVar);
											String entityFq = searchReportScheduleFq(searchList, entityVar, valueIndexed, varIndexed);
											mFq.appendReplacement(sb, entityFq);
											foundFq = mFq.find();
										}
										mFq.appendTail(sb);
										searchList.fq(sb.toString());
									}
									break;
								case "sort":
									entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
									valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
									varIndexed = ReportSchedule.varIndexedReportSchedule(entityVar);
									searchReportScheduleSort(searchList, entityVar, valueIndexed, varIndexed);
									break;
								case "start":
									valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
									searchReportScheduleStart(searchList, valueStart);
									break;
								case "rows":
									valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
									searchReportScheduleRows(searchList, valueRows);
									break;
								case "facet":
									searchList.facet((Boolean)paramObject);
									break;
								case "facet.range.start":
									String startMathStr = (String)paramObject;
									Date start = SearchTool.parseMath(startMathStr);
									searchList.facetRangeStart(start.toInstant().toString());
									break;
								case "facet.range.end":
									String endMathStr = (String)paramObject;
									Date end = SearchTool.parseMath(endMathStr);
									searchList.facetRangeEnd(end.toInstant().toString());
									break;
								case "facet.range.gap":
									String gap = (String)paramObject;
									searchList.facetRangeGap(gap);
									break;
								case "facet.range":
									Matcher mFacetRange = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
									boolean foundFacetRange = mFacetRange.find();
									if(foundFacetRange) {
										String solrLocalParams = mFacetRange.group(1);
										entityVar = mFacetRange.group(2).trim();
										varIndexed = ReportSchedule.varIndexedReportSchedule(entityVar);
										searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
									}
									break;
								case "facet.field":
									entityVar = (String)paramObject;
									varIndexed = ReportSchedule.varIndexedReportSchedule(entityVar);
									if(varIndexed != null)
										searchList.facetField(varIndexed);
									break;
								case "var":
									entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
									valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
									searchReportScheduleVar(searchList, entityVar, valueIndexed);
									break;
								case "cursorMark":
									valueCursorMark = (String)paramObject;
									searchList.cursorMark((String)paramObject);
									break;
							}
						}
						searchReportScheduleUri(searchList);
					}
				} catch(Exception e) {
					ExceptionUtils.rethrow(e);
				}
			});
			if("*:*".equals(searchList.getQuery()) && searchList.getSorts().size() == 0) {
				searchList.sort("objectId_docvalues_string", "asc");
			}
			searchReportSchedule2(siteRequest, populate, store, modify, searchList);
			searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
				promise.complete(searchList);
			}).onFailure(ex -> {
				LOG.error(String.format("searchReportSchedule failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("searchReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void searchReportSchedule2(SiteRequestEnUS siteRequest, Boolean populate, Boolean store, Boolean modify, SearchList<ReportSchedule> searchList) {
	}

	public Future<Void> defineReportSchedule(ReportSchedule o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			sqlConnection.preparedQuery("SELECT * FROM ReportSchedule WHERE pk=$1")
					.collecting(Collectors.toList())
					.execute(Tuple.of(pk)
					).onSuccess(result -> {
				try {
					for(Row definition : result.value()) {
						for(Integer i = 0; i < definition.size(); i++) {
							String columnName = definition.getColumnName(i);
							Object columnValue = definition.getValue(i);
							if(!"pk".equals(columnName)) {
								try {
									o.defineForClass(columnName, columnValue);
								} catch(Exception e) {
									LOG.error(String.format("defineReportSchedule failed. "), e);
								}
							}
						}
					}
					promise.complete();
				} catch(Exception ex) {
					LOG.error(String.format("defineReportSchedule failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				RuntimeException ex2 = new RuntimeException(ex);
				LOG.error(String.format("defineReportSchedule failed. "), ex2);
				promise.fail(ex2);
			});
		} catch(Exception ex) {
			LOG.error(String.format("defineReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> relateReportSchedule(ReportSchedule o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			SqlConnection sqlConnection = siteRequest.getSqlConnection();
			Long pk = o.getPk();
			sqlConnection.preparedQuery("SELECT typeKey as pk1, 'typeKey' from ReportSchedule where pk=$1 UNION SELECT pk as pk2, 'narrativeKeys' from ReportNarrative where scheduleKey=$2 UNION SELECT pk as pk2, 'eventKeys' from ReportEvent where scheduleKey=$3")
					.collecting(Collectors.toList())
					.execute(Tuple.of(pk, pk, pk)
					).onSuccess(result -> {
				try {
					if(result != null) {
						for(Row definition : result.value()) {
							o.relateForClass(definition.getString(1), definition.getLong(0));
						}
					}
					promise.complete();
				} catch(Exception ex) {
					LOG.error(String.format("relateReportSchedule failed. "), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				RuntimeException ex2 = new RuntimeException(ex);
				LOG.error(String.format("relateReportSchedule failed. "), ex2);
				promise.fail(ex2);
			});
		} catch(Exception ex) {
			LOG.error(String.format("relateReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> indexReportSchedule(ReportSchedule o) {
		Promise<Void> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = o.getSiteRequest_();
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			o.promiseDeepForClass(siteRequest).onSuccess(a -> {
				JsonObject json = new JsonObject();
				JsonObject add = new JsonObject();
				json.put("add", add);
				JsonObject doc = new JsonObject();
				add.put("doc", doc);
				o.indexReportSchedule(doc);
				String solrHostName = siteRequest.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
				Integer solrPort = siteRequest.getConfig().getInteger(ConfigKeys.SOLR_PORT);
				String solrCollection = siteRequest.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
				Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
				Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					else if(softCommit == null)
						softCommit = false;
				String solrRequestUri = String.format("/solr/%s/update%s%s%s", solrCollection, "?overwrite=true&wt=json", softCommit ? "&softCommit=true" : "", commitWithin != null ? ("&commitWithin=" + commitWithin) : "");
				webClient.post(solrPort, solrHostName, solrRequestUri).putHeader("Content-Type", "application/json").expect(ResponsePredicate.SC_OK).sendBuffer(json.toBuffer()).onSuccess(b -> {
					promise.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("indexReportSchedule failed. "), new RuntimeException(ex));
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("indexReportSchedule failed. "), ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("indexReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> refreshReportSchedule(ReportSchedule o) {
		Promise<Void> promise = Promise.promise();
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		try {
			ApiRequest apiRequest = siteRequest.getApiRequest_();
			List<Long> pks = Optional.ofNullable(apiRequest).map(r -> r.getPks()).orElse(new ArrayList<>());
			List<String> classes = Optional.ofNullable(apiRequest).map(r -> r.getClasses()).orElse(new ArrayList<>());
			Boolean refresh = !"false".equals(siteRequest.getRequestVars().get("refresh"));
			if(refresh && !Optional.ofNullable(siteRequest.getJsonObject()).map(JsonObject::isEmpty).orElse(true)) {
				List<Future> futures = new ArrayList<>();

				for(int i=0; i < pks.size(); i++) {
					Long pk2 = pks.get(i);
					String classSimpleName2 = classes.get(i);

					if("ReportType".equals(classSimpleName2) && pk2 != null) {
						SearchList<ReportType> searchList2 = new SearchList<ReportType>();
						searchList2.setStore(true);
						searchList2.q("*:*");
						searchList2.setC(ReportType.class);
						searchList2.fq("pk_docvalues_long:" + pk2);
						searchList2.rows(1L);
						futures.add(Future.future(promise2 -> {
							searchList2.promiseDeepSearchList(siteRequest).onSuccess(b -> {
								ReportType o2 = searchList2.getList().stream().findFirst().orElse(null);
								if(o2 != null) {
									JsonObject params = new JsonObject();
									params.put("body", new JsonObject());
									params.put("cookie", new JsonObject());
									params.put("path", new JsonObject());
									params.put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("pk:" + pk2)));
									JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
									JsonObject json = new JsonObject().put("context", context);
									eventBus.request("choice-reports-enUS-ReportType", json, new DeliveryOptions().addHeader("action", "patchReportTypeFuture")).onSuccess(c -> {
										JsonObject responseMessage = (JsonObject)c.body();
										Integer statusCode = responseMessage.getInteger("statusCode");
										if(statusCode.equals(200))
											promise2.complete();
										else
											promise2.fail(new RuntimeException(responseMessage.getString("statusMessage")));
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}
							}).onFailure(ex -> {
								promise2.fail(ex);
							});
						}));
					}

					if("ReportNarrative".equals(classSimpleName2) && pk2 != null) {
						SearchList<ReportNarrative> searchList2 = new SearchList<ReportNarrative>();
						searchList2.setStore(true);
						searchList2.q("*:*");
						searchList2.setC(ReportNarrative.class);
						searchList2.fq("pk_docvalues_long:" + pk2);
						searchList2.rows(1L);
						futures.add(Future.future(promise2 -> {
							searchList2.promiseDeepSearchList(siteRequest).onSuccess(b -> {
								ReportNarrative o2 = searchList2.getList().stream().findFirst().orElse(null);
								if(o2 != null) {
									JsonObject params = new JsonObject();
									params.put("body", new JsonObject());
									params.put("cookie", new JsonObject());
									params.put("path", new JsonObject());
									params.put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("pk:" + pk2)));
									JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
									JsonObject json = new JsonObject().put("context", context);
									eventBus.request("choice-reports-enUS-ReportNarrative", json, new DeliveryOptions().addHeader("action", "patchReportNarrativeFuture")).onSuccess(c -> {
										JsonObject responseMessage = (JsonObject)c.body();
										Integer statusCode = responseMessage.getInteger("statusCode");
										if(statusCode.equals(200))
											promise2.complete();
										else
											promise2.fail(new RuntimeException(responseMessage.getString("statusMessage")));
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}
							}).onFailure(ex -> {
								promise2.fail(ex);
							});
						}));
					}

					if("ReportEvent".equals(classSimpleName2) && pk2 != null) {
						SearchList<ReportEvent> searchList2 = new SearchList<ReportEvent>();
						searchList2.setStore(true);
						searchList2.q("*:*");
						searchList2.setC(ReportEvent.class);
						searchList2.fq("pk_docvalues_long:" + pk2);
						searchList2.rows(1L);
						futures.add(Future.future(promise2 -> {
							searchList2.promiseDeepSearchList(siteRequest).onSuccess(b -> {
								ReportEvent o2 = searchList2.getList().stream().findFirst().orElse(null);
								if(o2 != null) {
									JsonObject params = new JsonObject();
									params.put("body", new JsonObject());
									params.put("cookie", new JsonObject());
									params.put("path", new JsonObject());
									params.put("query", new JsonObject().put("q", "*:*").put("fq", new JsonArray().add("pk:" + pk2)));
									JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
									JsonObject json = new JsonObject().put("context", context);
									eventBus.request("choice-reports-enUS-ReportEvent", json, new DeliveryOptions().addHeader("action", "patchReportEventFuture")).onSuccess(c -> {
										JsonObject responseMessage = (JsonObject)c.body();
										Integer statusCode = responseMessage.getInteger("statusCode");
										if(statusCode.equals(200))
											promise2.complete();
										else
											promise2.fail(new RuntimeException(responseMessage.getString("statusMessage")));
									}).onFailure(ex -> {
										promise2.fail(ex);
									});
								}
							}).onFailure(ex -> {
								promise2.fail(ex);
							});
						}));
					}
				}

				CompositeFuture.all(futures).onSuccess(b -> {
					JsonObject params = new JsonObject();
					params.put("body", new JsonObject());
					params.put("cookie", new JsonObject());
					params.put("header", new JsonObject());
					params.put("form", new JsonObject());
					params.put("path", new JsonObject());
					JsonObject query = new JsonObject();
					Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
					Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
					if(softCommit == null && commitWithin == null)
						softCommit = true;
					if(softCommit != null)
						query.put("softCommit", softCommit);
					if(commitWithin != null)
						query.put("commitWithin", commitWithin);
					query.put("q", "*:*").put("fq", new JsonArray().add("pk:" + o.getPk()));
					params.put("query", query);
					JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
					JsonObject json = new JsonObject().put("context", context);
					eventBus.request("choice-reports-enUS-ReportSchedule", json, new DeliveryOptions().addHeader("action", "patchReportScheduleFuture")).onSuccess(c -> {
						JsonObject responseMessage = (JsonObject)c.body();
						Integer statusCode = responseMessage.getInteger("statusCode");
						if(statusCode.equals(200))
							promise.complete();
						else
							promise.fail(new RuntimeException(responseMessage.getString("statusMessage")));
					}).onFailure(ex -> {
						LOG.error("Refresh relations failed. ", ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error("Refresh relations failed. ", ex);
					promise.fail(ex);
				});
			} else {
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error(String.format("refreshReportSchedule failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
}
