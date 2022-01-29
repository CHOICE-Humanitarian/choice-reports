package org.choicehumanitarian.reports.enus.vertx;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.writer.AllWriter;
import org.choicehumanitarian.reports.enus.writer.ApiWriter;
import org.computate.search.computate.enus.ComputateEnUSClass;
import org.computate.search.request.SearchRequest;
import org.computate.search.response.solr.SolrResponse;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClient;

public class AppSwagger2 extends AppSwagger2Gen<Object> {

	public static void  main(String[] args) {
		AppSwagger2 api = new AppSwagger2();
		api.initDeepAppSwagger2();
		api.writeOpenApi();
	}

	/**	
	 * Val.Complete.enUS:The config was configured successfully. 
	 * Val.Fail.enUS:Could not configure the config(). 
	 **/
	public static Future<JsonObject> configureConfig(Vertx vertx) {
		Promise<JsonObject> promise = Promise.promise();

		try {
			ConfigRetrieverOptions retrieverOptions = new ConfigRetrieverOptions();

			retrieverOptions.addStore(new ConfigStoreOptions().setType("file").setFormat("yaml").setConfig(new JsonObject().put("path", Thread.currentThread().getContextClassLoader().getResource("application.yml").getPath())));

			String configPath = System.getenv(ConfigKeys.CONFIG_PATH);
			if(StringUtils.isNotBlank(configPath)) {
				ConfigStoreOptions configIni = new ConfigStoreOptions().setType("file").setFormat("yaml").setConfig(new JsonObject().put("path", configPath));
				retrieverOptions.addStore(configIni);
			}

			ConfigStoreOptions storeEnv = new ConfigStoreOptions().setType("env");
			retrieverOptions.addStore(storeEnv);

			ConfigRetriever configRetriever = ConfigRetriever.create(vertx, retrieverOptions);
			configRetriever.getConfig().onSuccess(config -> {
				LOG.info("The config was configured successfully. ");
				promise.complete(config);
			}).onFailure(ex -> {
				LOG.error("Unable to configure site context. ", ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error("Unable to configure site context. ", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	protected void _webClient(Wrap<WebClient> w) {
	}

	protected void _siteRequest_(Wrap<SiteRequestEnUS> c) {
	}

	protected void _config(Wrap<JsonObject> c) {
	}

	protected void _appName(Wrap<String> c) {
		c.o("choice-reports");
	}

	protected void _languageName(Wrap<String> c) {
		c.o("enUS");
	}

	protected void _appPath(Wrap<String> c) {
		c.o(config.getString(ConfigKeys.SITE_PATH + "_" + languageName));
	}

	protected void _openApiVersion(Wrap<String> c) {
		c.o(config.getString(ConfigKeys.OPEN_API_VERSION, "3.0"));
	}

	protected void _openApiVersionNumber(Wrap<Integer> c) {
		c.o((int)Double.parseDouble(StringUtils.substringBefore(openApiVersion, ".")));
	}

	protected void _tabsSchema(Wrap<Integer> c) {
		if(openApiVersionNumber == 2)
			c.o(1);
		else
			c.o(2);
	}

	protected void _apiVersion(Wrap<String> c) {
		c.o(config.getString(ConfigKeys.API_VERSION));
	}

	protected void _openApiYamlPath(Wrap<String> c) {
		c.o(appPath + "/src/main/resources/webroot/" + ("2.0".equals(apiVersion) ? "swagger2" : "openapi3") + "-enUS.yml");
	}

	protected void _openApiYamlFile(Wrap<File> c) {
		c.o(new File(openApiYamlPath));
	}

	protected void _w(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, openApiYamlFile, "  "));
	}

	protected void _wPaths(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _wRequestBodies(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _wSchemas(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	public Future<Void> writeOpenApi() {
		Promise<Void> promise = Promise.promise();

		writeInfo();
		writeApi().onSuccess(a -> {
			w.s(wPaths.toString());
			w.s(wRequestBodies.toString());
			w.s(wSchemas.toString());
			w.flushClose();
			promise.complete();
		}).onFailure(ex -> {
			w.flushClose();
			promise.fail(ex);
		});



		return promise.future();
	}

	public void  writeInfo() {

		if(openApiVersionNumber == 2)
			wPaths.l("swagger: \"", apiVersion, "\"");
		else
			wPaths.l("openapi: ", apiVersion);

		wPaths.l("info:");

		wPaths.t(1, "title: ").string(config.getString(ConfigKeys.API_TITLE)).l();
//		wPaths.t(1, "description: ").yamlStr(2, siteConfig.getApiDescription());
		if(openApiVersionNumber == 2) {
			wPaths.t(1, "version: ").string(apiVersion).l();
		}
		else if(openApiVersionNumber > 2) {
			wPaths.tl(1, "version: ", apiVersion);
		}
	}

	/**
	 * 
	 * Val.Error.enUS:An error occured while writing the API. 
	 * Val.Error2.enUS:An error occured while writing the API. 
	 */
	public Future<Void> writeApi() {
		Promise<Void> promise = Promise.promise();

		try {
			wPaths.tl(0, "paths:");
			wPaths.l();
			wPaths.tl(1, "/callback:");
			wPaths.tl(2, "get:");
			wPaths.tl(3, "operationId: callback");
			wPaths.tl(3, "x-vertx-event-bus: ", appName, "-", languageName, "-callback");
			wPaths.tl(3, "description: >+");
			wPaths.tl(3, "responses:");
			wPaths.tl(4, "'200':");
			wPaths.tl(5, "description: >+");
			wPaths.tl(5, "content:");
			wPaths.tl(6, "application/json; charset=utf-8:");
			wPaths.tl(7, "schema:");
			wPaths.tl(8, "type: string");
			wPaths.l();
			wPaths.tl(1, "/logout:");
			wPaths.tl(2, "get:");
			wPaths.tl(3, "operationId: logout");
			wPaths.tl(3, "x-vertx-event-bus: ", appName, "-", languageName, "-logout");
			wPaths.tl(3, "description: >+");
			wPaths.tl(3, "responses:");
			wPaths.tl(4, "'200':");
			wPaths.tl(5, "description: >+");
			wPaths.tl(5, "content:");
			wPaths.tl(6, "application/json; charset=utf-8:");
			wPaths.tl(7, "schema:");
			wPaths.tl(8, "type: string");
			wPaths.l();

			if(openApiVersionNumber == 2) {
				wSchemas.tl(0, "definitions:");
			}
			else {
				wRequestBodies.tl(0, "components:");
				if(config.getString(ConfigKeys.AUTH_URL) != null) {
					wRequestBodies.tl(1, "securitySchemes:");
						wRequestBodies.tl(2, "basicAuth:");
						wRequestBodies.tl(3, "type: http");
						wRequestBodies.tl(3, "scheme: basic");
						wRequestBodies.tl(2, "openIdConnect:");
						wRequestBodies.tl(3, "type: openIdConnect");
						wRequestBodies.tl(3, "openIdConnectUrl: ", config.getString(ConfigKeys.AUTH_URL), "/realms/", config.getString(ConfigKeys.AUTH_REALM), "/.well-known/openid-configuration");
				}
				wRequestBodies.tl(1, "requestBodies:");

				wSchemas.tl(1, "schemas:");
			}

			loadClasses().onSuccess(classDoc -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});

		} catch (Exception ex) {
			LOG.error(writeApiError, ex);
		}

		return promise.future();
	}

	public Future<Void> loadClasses() {
		Promise<Void> promise = Promise.promise();

		try {
			SearchRequest searchClasses = new SearchRequest();
			searchClasses.q("*:*");
			searchClasses.rows(1000000);
			searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath));
			searchClasses.fq("classeApi_indexed_boolean:true");
			searchClasses.fq("partEstClasse_indexed_boolean:true");
			searchClasses.sortAsc("classeNomCanonique_enUS_indexed_string");
			searchClasses.sortAsc("partNumero_indexed_int");
			searchClasses.initDeepForClass(siteRequest_);

			String solrHostName = siteRequest_.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
			Integer solrPort = siteRequest_.getConfig().getInteger(ConfigKeys.SOLR_PORT);
			String solrCollection = siteRequest_.getConfig().getString(ConfigKeys.SOLR_COLLECTION_COMPUTATE);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).send().onSuccess(a -> {
				try {
					SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
					loadClass(queryResponse.getResponse().getDocs(), 0).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("Search failed. "), new RuntimeException(ex));
				promise.fail(ex);
			});
		} catch (Exception ex) {
			promise.fail(ex);
		}

		return promise.future();
	}

	public Future<Void> loadClass(List<SolrResponse.Doc> docs, Integer i) {
		Promise<Void> promise = Promise.promise();
		if(docs.size() >= (i + 1)) {
			SolrResponse.Doc doc = docs.get(i);
			ComputateEnUSClass classDoc = JsonObject.mapFrom(doc.getFields()).mapTo(ComputateEnUSClass.class);
			List<ApiWriter> apiWriters = new ArrayList<>();

			ArrayList<String> classUris = new ArrayList<>();

			for(String classApiMethode : classDoc.getClassApiMethods()) {
				ApiWriter apiWriter = new ApiWriter();
				apiWriter.setClassSolrDocument(doc);
				apiWriter.setClassApiMethod(classApiMethode);
				apiWriter.setContextRows(classDoc.getContextRows());
				apiWriter.setWPaths(wPaths);
				apiWriter.setWRequestBodies(wRequestBodies);
				apiWriter.setWSchemas(wSchemas);
				apiWriter.setOpenApiVersion(openApiVersion);
				apiWriter.setAppSwagger2(this);
				apiWriter.setClassUris(classUris);
				apiWriter.initDeepApiWriter(siteRequest_);
				apiWriters.add(apiWriter);
			}
			Collections.sort(apiWriters);
			loadEntities(classDoc, apiWriters).onSuccess(a -> {
				try {
					for(ApiWriter apiWriter : apiWriters) {
						apiWriter.getWriters().flushClose();
						apiWriter.writeApi(false);
					}

					for(ApiWriter apiWriter : apiWriters) {
						apiWriter.getWResponseDescription().flushClose();
					}
					loadClass(docs, i + 1).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error("loadClass failed", ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} else {
			promise.complete();
		}
		return promise.future();
	}

	public Future<List<SolrResponse.Doc>> loadEntities(ComputateEnUSClass classDoc, List<ApiWriter> apiWriters) {
		Promise<List<SolrResponse.Doc>> promise = Promise.promise();

		try {
			SearchRequest searchEntities = new SearchRequest();
			searchEntities.q("*:*");
			searchEntities.rows(1000000);
			searchEntities.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath));
			searchEntities.fq("classeCheminAbsolu_indexed_string:" + SearchTool.escapeQueryChars(classDoc.getClassAbsolutePath()));
			searchEntities.fq("partEstEntite_indexed_boolean:true");
			searchEntities.sortAsc("partNumero_indexed_int");
			searchEntities.initDeepForClass(siteRequest_);

			String solrHostName = siteRequest_.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
			Integer solrPort = siteRequest_.getConfig().getInteger(ConfigKeys.SOLR_PORT);
			String solrCollection = siteRequest_.getConfig().getString(ConfigKeys.SOLR_COLLECTION_COMPUTATE);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchEntities.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).send().onSuccess(a -> {
				try {
					SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
					List<SolrResponse.Doc> searchEntitiesResults = queryResponse.getResponse().getDocs();

					Long searchEntitesLines = queryResponse.getResponse().getNumFound();

					for(Long k = searchEntities.getStart(); k < queryResponse.getResponse().getNumFound(); k+=searchEntitesLines) {
						for(Integer l = 0; l < searchEntitiesResults.size(); l++) {
							for(ApiWriter apiWriter : apiWriters) {
								SolrResponse.Doc entiteDocumentSolr = searchEntitiesResults.get(l);

								apiWriter.initEntity(entiteDocumentSolr);
								apiWriter.writeEntityHeaders();
								apiWriter.writeEntitySchema(null);
							}
						}
					}

					promise.complete(searchEntitiesResults);
				} catch(Exception ex) {
					LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("Search failed. "), new RuntimeException(ex));
				promise.fail(ex);
			});
		} catch (Exception e) {
			ExceptionUtils.rethrow(e);
		}

		return promise.future();
	}
}
