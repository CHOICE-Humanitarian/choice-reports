package org.choicehumanitarian.reports.enus.model.report.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.choicehumanitarian.reports.enus.model.report.event.ReportEvent;
import org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative;
import org.choicehumanitarian.reports.enus.model.report.type.ReportType;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.search.list.SearchList;

import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;
import io.vertx.pgclient.PgPool;

/**
 * Translate: false
 **/
public class ReportScheduleEnUSApiServiceImpl extends ReportScheduleEnUSGenApiServiceImpl {

	public ReportScheduleEnUSApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider, HandlebarsTemplateEngine templateEngine) {
		super(eventBus, config, workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine);
	}

	@Override
	public Future<Void> sqlPOSTReportSchedule(ReportSchedule o, Boolean inheritPk) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		JsonObject jsonObject = siteRequest.getJsonObject();
		jsonObject.put("setInheritPk", o.getPk().toString());
		return super.sqlPOSTReportSchedule(o, inheritPk);
	}

	@Override
	public Future<ReportSchedule> sqlPATCHReportSchedule(ReportSchedule o, Boolean inheritPk) {
		SiteRequestEnUS siteRequest = o.getSiteRequest_();
		JsonObject jsonObject = siteRequest.getJsonObject();
		jsonObject.put("setInheritPk", o.getPk().toString());
		return super.sqlPATCHReportSchedule(o, inheritPk);
	}

	public Future<Void> importReportEventFutureFirstDueDate(ReportSchedule reportSchedule) {
		try {
			String inheritPk = String.format("%s%s_%s", ReportSchedule.CLASS_SIMPLE_NAME, reportSchedule.getInheritPk(), ReportSchedule.VAR_firstDueDate);
			ReportEvent reportEvent = new ReportEvent();
			reportEvent.setEventDate(reportSchedule.getFirstDueDate());
			reportEvent.setEventName(String.format("%s due %s", reportSchedule.getScheduleName(), ComputateLocalDateSerializer.LOCAL_DATE_FORMATTER_DISPLAY_LONG_EEEE_MMMM_D_YYYY.format(reportSchedule.getFirstDueDate())));
			return importReportEventFuture(reportSchedule, reportEvent, inheritPk);
		} catch(Exception ex) {
			LOG.error(String.format("importReportEventFutureFirstDueDate failed. "), ex);
			return Future.failedFuture(ex);
		}
	}

	public Future<Void> importReportEventFutureDataPullDate(ReportSchedule reportSchedule) {
		try {
			String inheritPk = String.format("%s%s_%s", ReportSchedule.CLASS_SIMPLE_NAME, reportSchedule.getInheritPk(), ReportSchedule.VAR_dataPullDate);
			ReportEvent reportEvent = new ReportEvent();
			reportEvent.setEventDate(reportSchedule.getDataPullDate());
			reportEvent.setEventName(String.format("%s data pull due %s", reportSchedule.getScheduleName(), ComputateLocalDateSerializer.LOCAL_DATE_FORMATTER_DISPLAY_LONG_EEEE_MMMM_D_YYYY.format(reportSchedule.getDataPullDate())));
			return importReportEventFuture(reportSchedule, reportEvent, inheritPk);
		} catch(Exception ex) {
			LOG.error(String.format("importReportEventFutureDataPullDate failed. "), ex);
			return Future.failedFuture(ex);
		}
	}

	public Future<Void> importReportEventFutureNarrative(ReportSchedule reportSchedule, ReportNarrative reportNarrative) {
		try {
			String inheritPk = String.format("%s%s_%s%s_%s", ReportSchedule.CLASS_SIMPLE_NAME, reportSchedule.getInheritPk(), ReportNarrative.CLASS_SIMPLE_NAME, reportNarrative.getInheritPk(), ReportSchedule.VAR_dataPullDate);
			ReportEvent reportEvent = new ReportEvent();
			reportEvent.setEventDate(reportNarrative.getPullStartDate());
			reportEvent.setEventName(String.format("%s narrative \"%s\" %s should pull between %s - %s"
					, reportSchedule.getScheduleName()
					, reportNarrative.getNarrativeName()
					, Optional.ofNullable(reportNarrative.getAssigneeName()).orElse("someone")
					, Optional.ofNullable(reportNarrative.getPullStartDate()).map(d -> ComputateLocalDateSerializer.LOCAL_DATE_FORMATTER_DISPLAY_LONG_EEEE_MMMM_D_YYYY.format(d)).orElse("")
					, Optional.ofNullable(reportNarrative.getPullEndDate()).map(d -> ComputateLocalDateSerializer.LOCAL_DATE_FORMATTER_DISPLAY_LONG_EEEE_MMMM_D_YYYY.format(d)).orElse("")
					));
			return importReportEventFuture(reportSchedule, reportEvent, inheritPk);
		} catch(Exception ex) {
			LOG.error(String.format("importReportEventFutureNarrative failed. "), ex);
			return Future.failedFuture(ex);
		}
	}

	public Future<Void> importReportEventFuture(ReportSchedule reportSchedule, ReportEvent reportEvent, String inheritPk) {
		return Future.future(promise1 -> {
			try {
				SiteRequestEnUS siteRequest = reportSchedule.getSiteRequest_();
				JsonObject config = siteRequest.getConfig();
				reportEvent.setInheritPk(inheritPk);
	
				JsonObject params = new JsonObject();
				params.put("body", JsonObject.mapFrom(reportEvent).put(ReportEvent.VAR_pk, inheritPk).put(ReportEvent.VAR_scheduleKey, reportSchedule.getInheritPk()));
				params.put("path", new JsonObject());
				params.put("cookie", new JsonObject());
				params.put("header", new JsonObject());
				params.put("form", new JsonObject());
				JsonObject query = new JsonObject();
				query.put("commitWithin", 5);
				query.put("var", new JsonArray().add("refresh:false"));
				params.put("query", query);
				JsonObject context = new JsonObject().put("params", params).put("user", siteRequest.getUserPrincipal());
				JsonObject json = new JsonObject().put("context", context);
				eventBus.request(String.format("%s-enUS-%s", config.getString(ConfigKeys.SITE_NAME), ReportEvent.CLASS_SIMPLE_NAME), json, new DeliveryOptions().addHeader("action", String.format("putimport%sFuture", ReportEvent.CLASS_SIMPLE_NAME))).onSuccess(a -> {
					promise1.complete();
				}).onFailure(ex -> {
					LOG.error(String.format("importReportEventFuture failed. "), ex);
					promise1.fail(ex);
				});
			} catch(Exception ex) {
				LOG.error(String.format("importReportEventFuture failed. "), ex);
				promise1.fail(ex);
			}
		});
	}

	@Override
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
				Optional.ofNullable(o.getFirstDueDate()).ifPresent(firstDueDate -> {
					futures.add(importReportEventFutureFirstDueDate(o));
				});
				Optional.ofNullable(o.getDataPullDate()).ifPresent(firstDueDate -> {
					futures.add(importReportEventFutureDataPullDate(o));
				});
				SearchList<ReportNarrative> narrativeSearch = new SearchList<ReportNarrative>();
				narrativeSearch.setC(ReportNarrative.class);
				narrativeSearch.q("*:*");
				narrativeSearch.fq(String.format("scheduleKey_docvalues_long:%s", o.getPk()));
				narrativeSearch.rows(1000);
				narrativeSearch.setStore(true);
				narrativeSearch.promiseDeepSearchList(siteRequest).onSuccess(s -> {
					narrativeSearch.getList().forEach(reportNarrative -> {
						futures.add(importReportEventFutureNarrative(o, reportNarrative));
					});
					
					CompositeFuture.all(futures).onSuccess(a -> {
						super.refreshReportSchedule(o).onSuccess(b -> {
							promise.complete();
						}).onFailure(ex -> {
							LOG.error(String.format("listPUTImportReportSchedule failed. "), ex);
							promise.fail(ex);
						});
					}).onFailure(ex -> {
						LOG.error(String.format("listPUTImportReportSchedule failed. "), ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error(String.format("listPUTImportReportSchedule failed. "), ex);
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
