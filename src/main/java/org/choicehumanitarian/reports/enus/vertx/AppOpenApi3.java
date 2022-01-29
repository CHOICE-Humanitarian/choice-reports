package org.choicehumanitarian.reports.enus.vertx;

import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.computate.search.wrap.Wrap;

import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;

public class AppOpenApi3 extends AppOpenApi3Gen<AppSwagger2> {

	@Override()
	protected void  _apiVersion(Wrap<String> c) {
		c.o("3.0.0");
	}

	public static void  main(String[] args) {
		Vertx vertx = Vertx.vertx();
		String configPath = System.getenv("CONFIG_PATH");
		configureConfig(vertx).onSuccess(config -> {
			AppOpenApi3 api = new AppOpenApi3();
			WebClient webClient = WebClient.create(vertx);
			SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.setConfig(config);
			siteRequest.setWebClient(webClient);
			api.setWebClient(webClient);
			api.setConfig(config);
			siteRequest.initDeepSiteRequestEnUS();
			api.initDeepAppOpenApi3(siteRequest);
			api.writeOpenApi().onSuccess(a -> {
				LOG.info("Write OpenAPI completed. ");
				vertx.close();
			}).onFailure(ex -> {
				LOG.error("Write OpenAPI failed. ", ex);
				vertx.close();
			});
			
		}).onFailure(ex -> {
			LOG.error(String.format("Error loading config: %s", configPath), ex);
			vertx.close();
		});
	}
}
