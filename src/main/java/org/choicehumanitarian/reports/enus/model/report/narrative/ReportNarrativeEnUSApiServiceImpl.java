package org.choicehumanitarian.reports.enus.model.report.narrative;

import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.eventbus.EventBus;

import java.util.Optional;

import org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule;

import io.vertx.core.Future;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.PgPool;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;

/**
 * Translate: false
 **/
public class ReportNarrativeEnUSApiServiceImpl extends ReportNarrativeEnUSGenApiServiceImpl {

	public ReportNarrativeEnUSApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider, HandlebarsTemplateEngine templateEngine) {
		super(eventBus, config, workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine);
	}

	@Override
	public Future<Void> sqlPOSTReportNarrative(ReportNarrative o, Boolean inheritPk) {
		Optional.ofNullable(o.getScheduleKey()).ifPresent(scheduleKey -> {
			Optional.ofNullable(o.getSiteRequest_().getApiRequest_()).ifPresent(apiRequest -> {
				apiRequest.getPks().add(scheduleKey);
				apiRequest.getClasses().add(ReportSchedule.CLASS_SIMPLE_NAME);
			});
		});
		return super.sqlPOSTReportNarrative(o, inheritPk);
	}

	@Override
	public Future<ReportNarrative> sqlPATCHReportNarrative(ReportNarrative o, Boolean inheritPk) {
		Optional.ofNullable(o.getScheduleKey()).ifPresent(scheduleKey -> {
			Optional.ofNullable(o.getSiteRequest_().getApiRequest_()).ifPresent(apiRequest -> {
				apiRequest.getPks().add(scheduleKey);
				apiRequest.getClasses().add(ReportSchedule.CLASS_SIMPLE_NAME);
			});
		});
		return super.sqlPATCHReportNarrative(o, inheritPk);
	}
}
