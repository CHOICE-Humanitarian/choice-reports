package org.choicehumanitarian.reports.enus.model.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.search.SearchList;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.FSEntityResolver;
import org.xml.sax.SAXException;

import com.itextpdf.text.DocumentException;

import io.vertx.core.Future;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;
import io.vertx.pgclient.PgPool;

/**
 * Translate: false
 **/
public class ChoiceReportEnUSApiServiceImpl extends ChoiceReportEnUSGenApiServiceImpl {

	public ChoiceReportEnUSApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider, HandlebarsTemplateEngine templateEngine) {
		super(eventBus, config, workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine);
	}

	@Override
	public String templateChoiceReportDisplaySearchPageChoiceReport() {
		return config.getString(ConfigKeys.TEMPLATE_PATH) + "/enUS/ChoiceReportDisplayPage";
	}

	@Override
	public String templateChoiceReportPdfSearchPageChoiceReport() {
		return config.getString(ConfigKeys.TEMPLATE_PATH) + "/enUS/ChoiceReportDisplayPage";
	}

	@Override
	public Future<ServiceResponse> response200ChoiceReportPdfSearchPageChoiceReport(SearchList<ChoiceReport> listChoiceReport) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			SiteRequestEnUS siteRequest = listChoiceReport.getSiteRequest_();
			ChoiceReportPage page = new ChoiceReportPage();
			MultiMap requestHeaders = MultiMap.caseInsensitiveMultiMap();
			siteRequest.setRequestHeaders(requestHeaders);

			if(listChoiceReport.size() == 1)
				siteRequest.setRequestPk(listChoiceReport.get(0).getPk());
			page.setSearchListChoiceReport_(listChoiceReport);
			page.setSiteRequest_(siteRequest);
			page.promiseDeepChoiceReportPage(siteRequest).onSuccess(a -> {
				JsonObject json = JsonObject.mapFrom(page);
				templateEngine.render(json, templateChoiceReportPdfSearchPageChoiceReport()).onSuccess(buffer -> {
					try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
				
						String str = buffer.toString();
						DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
						fac.setNamespaceAware(false);
						fac.setValidating(false);
						fac.setFeature("http://xml.org/sax/features/namespaces", false);
						fac.setFeature("http://xml.org/sax/features/validation", false);
						fac.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
						fac.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			
						DocumentBuilder builder = fac.newDocumentBuilder();
						builder.setEntityResolver(FSEntityResolver.instance());
						Document doc = builder.parse(new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8"))));
			
						ITextRenderer renderer = new ITextRenderer();
						renderer.setDocument(doc, null);
						renderer.layout();
						renderer.createPDF(os);
						renderer.finishPDF();
						requestHeaders
								.add("Content-Disposition", "inline; filename=\"" + "report" + ".pdf\"")
								.add("Content-Transfer-Encoding", "binary")
								.add("Content-Type", "application/pdf")
								.add("Accept-Ranges", "bytes")
								;

						Buffer buffer2 = Buffer.buffer(os.toByteArray());
						promise.complete(new ServiceResponse(200, "OK", buffer2, requestHeaders));
					} catch (IOException | ParserConfigurationException | SAXException | DocumentException e) {
						ExceptionUtils.rethrow(e);
					}
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error(String.format("response200ChoiceReportPdfSearchPageChoiceReport failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
}
