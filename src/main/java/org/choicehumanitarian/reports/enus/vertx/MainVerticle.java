package org.choicehumanitarian.reports.enus.vertx;

import java.net.URLDecoder;
import java.text.Normalizer;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.solr.client.solrj.SolrQuery;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorEnUSGenApiService;
import org.choicehumanitarian.reports.enus.model.report.ChoiceReportEnUSGenApiService;
import org.choicehumanitarian.reports.enus.user.SiteUserEnUSGenApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.helper.ConditionalHelpers;
import com.github.jknack.handlebars.helper.StringHelpers;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.EventBusOptions;
import io.vertx.core.eventbus.MessageConsumer;
import io.vertx.core.http.Cookie;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.JksOptions;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.auth.oauth2.OAuth2FlowType;
import io.vertx.ext.auth.oauth2.OAuth2Options;
import io.vertx.ext.auth.oauth2.authorization.KeycloakAuthorization;
import io.vertx.ext.auth.oauth2.providers.OpenIDConnectAuth;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.healthchecks.HealthCheckHandler;
import io.vertx.ext.healthchecks.Status;
import io.vertx.ext.mail.MailClient;
import io.vertx.ext.mail.MailConfig;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.handler.OAuth2AuthHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.TemplateHandler;
import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.openapi.RouterBuilder;
import io.vertx.ext.web.sstore.LocalSessionStore;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;
import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.spi.cluster.zookeeper.ZookeeperClusterManager;
import io.vertx.sqlclient.PoolOptions;

/**	
 *	A Java class to start the Vert.x application as a main method. 
 * Keyword: classSimpleNameVerticle
 **/  
public class MainVerticle extends MainVerticleGen<AbstractVerticle> {
	private static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);

	public final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

	private Integer siteInstances;

	private Integer workerPoolSize;

	private Integer jdbcMaxPoolSize;

	private Integer jdbcMaxWaitQueueSize;

	/**
	 * A io.vertx.ext.jdbc.JDBCClient for connecting to the relational database PostgreSQL. 
	 **/
	private PgPool pgPool;

	private WebClient webClient;

	private Router router;

	WorkerExecutor workerExecutor;

	OAuth2Auth oauth2AuthenticationProvider;

	AuthorizationProvider authorizationProvider;

	HandlebarsTemplateEngine templateEngine;

	/**	
	 *	The main method for the Vert.x application that runs the Vert.x Runner class
	 **/
	public static void  main(String[] args) {
		run();
	}

	/**	
	 * Val.Complete.enUS:The config was configured successfully. 
	 * Val.Fail.enUS:Could not configure the config(). 
	 **/
	public static Future<JsonObject> configureConfig(Vertx vertx) {
		Promise<JsonObject> promise = Promise.promise();

		try {
			ConfigRetrieverOptions retrieverOptions = new ConfigRetrieverOptions();

			retrieverOptions.addStore(new ConfigStoreOptions().setType("file").setFormat("properties").setConfig(new JsonObject().put("path", "application.properties")));

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

	public static void  run() {
		JsonObject zkConfig = new JsonObject();
		String zookeeperHostName = System.getenv(ConfigKeys.ZOOKEEPER_HOST_NAME);
		Integer zookeeperPort = Integer.parseInt(Optional.ofNullable(System.getenv(ConfigKeys.ZOOKEEPER_PORT)).orElse("2181"));
		String zookeeperHosts = Optional.ofNullable(System.getenv(ConfigKeys.ZOOKEEPER_HOSTS)).orElse(zookeeperHostName + ":" + zookeeperPort);
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(zookeeperHosts, retryPolicy);
		curatorFramework.start();
		Integer clusterPort = Optional.ofNullable(System.getenv(ConfigKeys.CLUSTER_PORT)).map(s -> Integer.parseInt(s)).orElse(null);
		String clusterHostName = System.getenv(ConfigKeys.CLUSTER_HOST_NAME);
		Integer clusterPublicPort = Optional.ofNullable(System.getenv(ConfigKeys.CLUSTER_PUBLIC_PORT)).map(s -> Integer.parseInt(s)).orElse(null);
		Integer siteInstances = Optional.ofNullable(System.getenv(ConfigKeys.SITE_INSTANCES)).map(s -> Integer.parseInt(s)).orElse(1);
		Long vertxWarningExceptionSeconds = Optional.ofNullable(System.getenv(ConfigKeys.VERTX_WARNING_EXCEPTION_SECONDS)).map(s -> Long.parseLong(s)).orElse(10L);
		String clusterPublicHostName = System.getenv(ConfigKeys.CLUSTER_PUBLIC_HOST_NAME);
		zkConfig.put("zookeeperHosts", zookeeperHosts);
		zkConfig.put("sessionTimeout", 500000);
		zkConfig.put("connectTimeout", 3000);
		zkConfig.put("rootPath", "choice-reports");
		zkConfig.put("retry", new JsonObject() {
			{
				put("initialSleepTime", 3000);
				put("intervalTimes", 10000);
				put("maxTimes", 3);
			}
		});
		ClusterManager clusterManager = new ZookeeperClusterManager(zkConfig);
		VertxOptions vertxOptions = new VertxOptions();
		// For OpenShift
		EventBusOptions eventBusOptions = new EventBusOptions();
		String hostname = System.getenv(ConfigKeys.HOSTNAME);
		String openshiftService = System.getenv(ConfigKeys.OPENSHIFT_SERVICE);
		if(clusterHostName == null) {
			clusterHostName = hostname;
		}
		if(clusterPublicHostName == null) {
			if(hostname != null && openshiftService != null) {
				clusterPublicHostName = hostname + "." + openshiftService;
			}
		}
		if(clusterHostName != null) {
			LOG.info(String.format("%s: %s", ConfigKeys.CLUSTER_HOST_NAME, clusterHostName));
			eventBusOptions.setHost(clusterHostName);
		}
		if(clusterPort != null) {
			LOG.info(String.format("%s: %s", ConfigKeys.CLUSTER_PORT, clusterPort));
			eventBusOptions.setPort(clusterPort);
		}
		if(clusterPublicHostName != null) {
			LOG.info(String.format("%s: %s", ConfigKeys.CLUSTER_PUBLIC_HOST_NAME, clusterPublicHostName));
			eventBusOptions.setClusterPublicHost(clusterPublicHostName);
		}
		if(clusterPublicPort != null) {
			LOG.info(String.format("%s: %s", ConfigKeys.CLUSTER_PUBLIC_PORT, clusterPublicPort));
			eventBusOptions.setClusterPublicPort(clusterPublicPort);
		}
		vertxOptions.setEventBusOptions(eventBusOptions);
		vertxOptions.setClusterManager(clusterManager);
		vertxOptions.setWarningExceptionTime(vertxWarningExceptionSeconds);
		vertxOptions.setWarningExceptionTimeUnit(TimeUnit.SECONDS);
		vertxOptions.setWorkerPoolSize(System.getenv(ConfigKeys.WORKER_POOL_SIZE) == null ? 5 : Integer.parseInt(System.getenv(ConfigKeys.WORKER_POOL_SIZE)));
		Consumer<Vertx> runner = vertx -> {
			configureConfig(vertx).onSuccess(config -> {
				try {
					List<Future> futures = new ArrayList<>();

					DeploymentOptions deploymentOptions = new DeploymentOptions();
					deploymentOptions.setInstances(siteInstances);
					deploymentOptions.setConfig(config);
		
					DeploymentOptions mailVerticleDeploymentOptions = new DeploymentOptions();
					mailVerticleDeploymentOptions.setConfig(config);
					mailVerticleDeploymentOptions.setWorker(true);
		
					DeploymentOptions workerVerticleDeploymentOptions = new DeploymentOptions();
					workerVerticleDeploymentOptions.setConfig(config);
					workerVerticleDeploymentOptions.setInstances(1);
		
					DeploymentOptions ceylonVerticleDeploymentOptions = new DeploymentOptions();
					ceylonVerticleDeploymentOptions.setConfig(config);
					ceylonVerticleDeploymentOptions.setInstances(1);
		
					vertx.deployVerticle(MainVerticle.class, deploymentOptions).onSuccess(a -> {
						LOG.info("Started main verticle. ");
						vertx.deployVerticle(WorkerVerticle.class, workerVerticleDeploymentOptions).onSuccess(b -> {
							LOG.info("Started worker verticle. ");
//							vertx.deployVerticle(AppCeylonVerticle.class, ceylonVerticleDeploymentOptions).onSuccess(c -> {
//								scheduling(vertx);
								LOG.info("Started scheduler verticle. ");
//							}).onFailure(ex -> {
//								LOG.error("Failed to start scheduler verticle. ", ex);
//							});
						}).onFailure(ex -> {
							LOG.error("Failed to start worker verticle. ", ex);
						});
					}).onFailure(ex -> {
						LOG.error("Failed to start main verticle. ", ex);
					});
				} catch (Throwable ex) {
					LOG.error("Creating clustered Vertx failed. ", ex);
					ExceptionUtils.rethrow(ex);
				}
			}).onFailure(ex -> {
				LOG.error("Creating clustered Vertx failed. ", ex);
				ExceptionUtils.rethrow(ex);
			});
		};

		Vertx.clusteredVertx(vertxOptions).onSuccess(vertx -> {
			runner.accept(vertx);
		}).onFailure(ex -> {
			LOG.error("Creating clustered Vertx failed. ", ex);
			ExceptionUtils.rethrow(ex);
		});
	}

	// Scheduling with Chime
	static void scheduling(Vertx vertx) {
		EventBus eventBus = vertx.eventBus();
		// Consumer of the timer events
		MessageConsumer<JsonObject> consumer = eventBus.consumer("scheduler:timer");
		// Listens and prints timer events. When timer completes stops the Vertx 
		consumer.handler (
			message -> {
				JsonObject event = message.body();
				if (event.getString("event").equals("complete")) {
					System.out.println("completed");
					vertx.close();
				}
				else {
					System.out.println(event);
				}
		  	}
		);
		// Create new timer
		eventBus.request("chime",
			(new JsonObject()).put("operation", "create").put("name", "scheduler:timer")
				.put("publish", false).put("max count", 3)
				.put("description", (new JsonObject()).put("type", "interval").put("delay", 1))).onSuccess(a -> {
			LOG.info("scheduling succeeded");
		}).onFailure(ex -> {
			LOG.error("Scheduling failed. ", ex);
		});
	}

	/**	
	 *	This is called by Vert.x when the verticle instance is deployed. 
	 *	Initialize a new site context object for storing information about the entire site in English. 
	 *	Setup the startPromise to handle the configuration steps and starting the server. 
	 **/
	@Override()
	public void  start(Promise<Void> startPromise) throws Exception, Exception {

		try {
			Future<Void> promiseSteps = configureWebClient().compose(a ->
				configureData().compose(b -> 
					configureOpenApi().compose(d -> 
						configureHealthChecks().compose(e -> 
							configureSharedWorkerExecutor().compose(f -> 
								configureWebsockets().compose(g -> 
									configureEmail().compose(h -> 
										configureApi().compose(i -> 
											configureUi().compose(j -> 
												startServer()
											)
										)
									)
								)
							)
						)
					)
				)
			);
			promiseSteps.onComplete(startPromise);
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
			pgOptions.setPort(config().getInteger(ConfigKeys.JDBC_PORT));
			pgOptions.setHost(config().getString(ConfigKeys.JDBC_HOST));
			pgOptions.setDatabase(config().getString(ConfigKeys.JDBC_DATABASE));
			pgOptions.setUser(config().getString(ConfigKeys.JDBC_USERNAME));
			pgOptions.setPassword(config().getString(ConfigKeys.JDBC_PASSWORD));
			pgOptions.setIdleTimeout(config().getInteger(ConfigKeys.JDBC_MAX_IDLE_TIME, 10));
			pgOptions.setIdleTimeoutUnit(TimeUnit.SECONDS);
			pgOptions.setConnectTimeout(config().getInteger(ConfigKeys.JDBC_CONNECT_TIMEOUT, 5));

			PoolOptions poolOptions = new PoolOptions();
			jdbcMaxPoolSize = config().getInteger(ConfigKeys.JDBC_MAX_POOL_SIZE, 1);
			jdbcMaxWaitQueueSize = config().getInteger(ConfigKeys.JDBC_MAX_WAIT_QUEUE_SIZE, 10);
			poolOptions.setMaxSize(jdbcMaxPoolSize);
			poolOptions.setMaxWaitQueueSize(jdbcMaxWaitQueueSize);

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
	 * 
	 * Val.Error.enUS:Could not configure the auth server and API. 
	 * Val.Success.enUS:The auth server and API was configured successfully. 
	 * 
	 *	Configure the connection to the auth server and setup the routes based on the OpenAPI definition. 
	 *	Setup a callback route when returning from the auth server after successful authentication. 
	 *	Setup a logout route for logging out completely of the application. 
	 *	Return a promise that configures the authentication server and OpenAPI. 
	 **/
	private Future<Void> configureOpenApi() {
		Promise<Void> promise = Promise.promise();
		try {
			String siteBaseUrl = config().getString(ConfigKeys.SITE_BASE_URL);

			OAuth2Options oauth2ClientOptions = new OAuth2Options();
			Boolean authSsl = config().getBoolean(ConfigKeys.AUTH_SSL);
			String authHostName = config().getString(ConfigKeys.AUTH_HOST_NAME);
			Integer authPort = config().getInteger(ConfigKeys.AUTH_PORT);
			String authUrl = String.format("%s://%s%s/auth", (authSsl ? "https" : "http"), authHostName, (authPort == 443 || authPort == 80 ? "" : ":" + authPort));
			oauth2ClientOptions.setSite(authUrl + "/realms/" + config().getString(ConfigKeys.AUTH_REALM));
			oauth2ClientOptions.setTenant(config().getString(ConfigKeys.AUTH_REALM));
			oauth2ClientOptions.setClientID(config().getString(ConfigKeys.AUTH_RESOURCE));
			oauth2ClientOptions.setClientSecret(config().getString(ConfigKeys.AUTH_SECRET));
			oauth2ClientOptions.setFlow(OAuth2FlowType.AUTH_CODE);
			JsonObject extraParams = new JsonObject();
			extraParams.put("scope", "DefaultAuthScope");
			oauth2ClientOptions.setExtraParameters(extraParams);

			OpenIDConnectAuth.discover(vertx, oauth2ClientOptions, a -> {
				if(a.succeeded()) {
					oauth2AuthenticationProvider = a.result();

					authorizationProvider = KeycloakAuthorization.create();

					OAuth2AuthHandler oauth2AuthHandler = OAuth2AuthHandler.create(vertx, oauth2AuthenticationProvider, siteBaseUrl + "/callback");
					{
						Router tempRouter = Router.router(vertx);
						oauth2AuthHandler.setupCallback(tempRouter.get("/callback"));
					}
			
					//ClusteredSessionStore sessionStore = ClusteredSessionStore.create(vertx);
					LocalSessionStore sessionStore = LocalSessionStore.create(vertx, "choice-reports-sessions");
					SessionHandler sessionHandler = SessionHandler.create(sessionStore);
					if(StringUtils.startsWith(siteBaseUrl, "https://"))
						sessionHandler.setCookieSecureFlag(true);
			
					RouterBuilder.create(vertx, "webroot/openapi3-enUS.yaml", b -> {
						if (b.succeeded()) {
							RouterBuilder routerBuilder = b.result();
							routerBuilder.mountServicesFromExtensions();
			
							routerBuilder.serviceExtraPayloadMapper(routingContext -> new JsonObject()
									.put("uri", routingContext.request().uri())
									.put("method", routingContext.request().method().name())
									);
							routerBuilder.rootHandler(sessionHandler);
							routerBuilder.securityHandler("openIdConnect", oauth2AuthHandler);
							routerBuilder.operation("callback").handler(ctx -> {
			
								// Handle the callback of the flow
								final String code = ctx.request().getParam("code");
			
								// code is a require value
								if (code == null) {
									ctx.fail(400);
									return;
								}
			
								final String state = ctx.request().getParam("state");
			
								final JsonObject config = new JsonObject().put("code", code);
			
								config.put("redirect_uri", siteBaseUrl + "/callback");
			
								oauth2AuthenticationProvider.authenticate(config, res -> {
									if (res.failed()) {
										LOG.error("Failed to authenticate user. ", res.cause());
										ctx.fail(res.cause());
									} else {
										ctx.setUser(res.result());
										Session session = ctx.session();
										if (session != null) {
											// the user has upgraded from unauthenticated to authenticated
											// session should be upgraded as recommended by owasp
											Cookie cookie = Cookie.cookie("sessionIdBefore", session.id());
											if(StringUtils.startsWith(siteBaseUrl, "https://"))
												cookie.setSecure(true);
											ctx.addCookie(cookie);
											session.regenerateId();
											String redirectUri = session.get("redirect_uri");
											// we should redirect the UA so this link becomes invalid
											ctx.response()
													// disable all caching
													.putHeader(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate")
													.putHeader("Pragma", "no-cache")
													.putHeader(HttpHeaders.EXPIRES, "0")
													// redirect (when there is no state, redirect to home
													.putHeader(HttpHeaders.LOCATION, redirectUri != null ? redirectUri : "/")
													.setStatusCode(302)
													.end("Redirecting to " + (redirectUri != null ? redirectUri : "/") + ".");
										} else {
											// there is no session object so we cannot keep state
											ctx.reroute(state != null ? state : "/");
										}
									}
								});
							});
							routerBuilder.operation("callback").failureHandler(c -> {});
			
							routerBuilder.operation("logout").handler(rc -> {
								String redirectUri = rc.request().params().get("redirect_uri");
								if(redirectUri == null)
									redirectUri = "/";
								rc.clearUser();
								rc.response()
										.putHeader(HttpHeaders.LOCATION, redirectUri)
										.setStatusCode(302)
										.end("Redirecting to " + redirectUri + ".");
							});
							routerBuilder.operation("logout").handler(c -> {});
			
							router = routerBuilder.createRouter();
			
							LOG.info(configureOpenApiSuccess);
							promise.complete();
						} else {
							LOG.error(configureOpenApiError, b.cause());
							promise.fail(b.cause());
						}
					});
				} else {
					LOG.error(configureOpenApiError, a.cause());
					promise.fail(a.cause());
				}
			});
		} catch (Exception ex) {
			LOG.error(configureOpenApiError, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**
	 * 
	 * Val.Fail.enUS:Could not configure the shared worker executor. 
	 * Val.Complete.enUS:The shared worker executor "{}" was configured successfully. 
	 * 
	 *	Configure a shared worker executor for running blocking tasks in the background. 
	 *	Return a promise that configures the shared worker executor. 
	 **/
	private Future<Void> configureSharedWorkerExecutor() {
		Promise<Void> promise = Promise.promise();
		try {
			String name = "MainVerticle-WorkerExecutor";
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
	 * Val.Complete.enUS:The health checks were configured successfully. 
	 * Val.Fail.enUS:Could not configure the health checks. 
	 * Val.ErrorDatabase.enUS:The database is not configured properly. 
	 * Val.EmptySolr.enUS:The Solr search engine is empty. 
	 * Val.ErrorSolr.enUS:The Solr search engine is not configured properly. 
	 * Val.ErrorVertx.enUS:The Vert.x application is not configured properly. 
	 *	Configure health checks for the status of the website and it's dependent services. 
	 *	Return a promise that configures the health checks. 
	 **/
	private Future<Void> configureHealthChecks() {
		Promise<Void> promise = Promise.promise();
		try {
			HealthCheckHandler healthCheckHandler = HealthCheckHandler.create(vertx);
			siteInstances = Optional.ofNullable(System.getenv(ConfigKeys.SITE_INSTANCES)).map(s -> Integer.parseInt(s)).orElse(1);
			workerPoolSize = System.getenv(ConfigKeys.WORKER_POOL_SIZE) == null ? null : Integer.parseInt(System.getenv(ConfigKeys.WORKER_POOL_SIZE));

			healthCheckHandler.register("database", 2000, a -> {
				pgPool.preparedQuery("select current_timestamp").execute(selectCAsync -> {
					if(selectCAsync.succeeded()) {
						a.complete(Status.OK(new JsonObject().put("jdbcMaxPoolSize", jdbcMaxPoolSize).put("jdbcMaxWaitQueueSize", jdbcMaxWaitQueueSize)));
					} else {
						LOG.error(configureHealthChecksErrorDatabase, a.future().cause());
						promise.fail(a.future().cause());
					}
				});
			});
			healthCheckHandler.register("solr", 2000, a -> {
				SolrQuery query = new SolrQuery();
				query.setQuery("*:*");
				try {
					String solrHostName = config().getString(ConfigKeys.SOLR_HOST_NAME);
					Integer solrPort = config().getInteger(ConfigKeys.SOLR_PORT);
					String solrCollection = config().getString(ConfigKeys.SOLR_COLLECTION);
					String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, query.toQueryString());
					webClient.get(solrPort, solrHostName, solrRequestUri).send().onSuccess(b -> {
						try {
							a.complete(Status.OK());
						} catch(Exception ex) {
							LOG.error("Could not read response from Solr. ", ex);
							a.fail(ex);
						}
					}).onFailure(ex -> {
						LOG.error(String.format("Solr request failed. "), new RuntimeException(ex));
						a.fail(ex);
					});
				} catch (Exception e) {
					LOG.error(configureHealthChecksErrorSolr, a.future().cause());
					a.fail(a.future().cause());
				}
			});
			healthCheckHandler.register("vertx", 2000, a -> {
				a.complete(Status.OK(new JsonObject().put(ConfigKeys.SITE_INSTANCES, siteInstances).put("workerPoolSize", workerPoolSize)));
			});
			router.get("/health").handler(healthCheckHandler);
			LOG.info(configureHealthChecksComplete);
			promise.complete();
		} catch (Exception ex) {
			LOG.error(configureHealthChecksFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**	
	 * Configure websockets for realtime messages. 
	 * Val.Complete.enUS:Configure websockets succeeded. 
	 * Val.Fail.enUS:Configure websockets failed. 
	 **/
	private Future<Void> configureWebsockets() {
		Promise<Void> promise = Promise.promise();
		try {
			SockJSBridgeOptions options = new SockJSBridgeOptions()
					.addOutboundPermitted(new PermittedOptions().setAddressRegex("websocket.*"));
			SockJSHandler sockJsHandler = SockJSHandler.create(vertx);
			sockJsHandler.bridge(options);
			router.route("/eventbus/*").handler(sockJsHandler);
			LOG.info(configureWebsocketsComplete);
			promise.complete();
		} catch (Exception ex) {
			LOG.error(configureWebsocketsFail, ex);
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
	 * Val.Fail.enUS:The API was not configured properly. 
	 * Val.Complete.enUS:The API was configured properly. 
	 */
	private Future<Void> configureApi() {
		Promise<Void> promise = Promise.promise();
		try {
			templateEngine = HandlebarsTemplateEngine.create(vertx);

			SiteUserEnUSGenApiService.registerService(vertx.eventBus(), config(), workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine, vertx);
			ChoiceDonorEnUSGenApiService.registerService(vertx.eventBus(), config(), workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine, vertx);
			ChoiceReportEnUSGenApiService.registerService(vertx.eventBus(), config(), workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine, vertx);

			LOG.info(configureApiComplete);
			promise.complete();
		} catch(Exception ex) {
			LOG.error(configureApiFail, ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**
	 * Val.Fail.enUS:The UI was not configured properly. 
	 * Val.Complete.enUS:The UI was configured properly. 
	 */
	private Future<Void> configureUi() {
		Promise<Void> promise = Promise.promise();
		try {
			String staticPath = config().getString(ConfigKeys.STATIC_PATH);
			String staticBaseUrl = config().getString(ConfigKeys.STATIC_BASE_URL);
			String siteBaseUrl = config().getString(ConfigKeys.SITE_BASE_URL);
			String templatePath = config().getString(ConfigKeys.TEMPLATE_PATH);
			Handlebars handlebars = (Handlebars)templateEngine.unwrap();
			TemplateHandler templateHandler;
			if(StringUtils.isBlank(templatePath))
				templateHandler = TemplateHandler.create(templateEngine);
			else
				templateHandler = TemplateHandler.create(templateEngine, templatePath, "text/html");

			handlebars.registerHelpers(ConditionalHelpers.class);
			handlebars.registerHelpers(StringHelpers.class);
			handlebars.registerHelpers(AuthHelpers.class);
			handlebars.registerHelpers(SiteHelpers.class);

			router.get("/").handler(a -> {
				a.reroute("/template/enUS/home-page");
			});

			router.get("/api").handler(ctx -> {
				ctx.reroute("/template/enUS/openapi");
			});

			router.get("/template/*").handler(ctx -> {
				ctx.put(ConfigKeys.STATIC_BASE_URL, staticBaseUrl);
				ctx.put(ConfigKeys.SITE_BASE_URL, siteBaseUrl);
				ctx.put(ConfigKeys.AUTH_URL, config().getString(ConfigKeys.AUTH_URL));
				ctx.put(ConfigKeys.AUTH_REALM, config().getString(ConfigKeys.AUTH_REALM));
				ctx.put("staticBaseUrl", staticBaseUrl);
				ctx.put("siteBaseUrl", siteBaseUrl);
				ctx.next();
			});

			router.get("/template/*").handler(templateHandler);
			router.errorHandler(500,  ctx -> {
				Throwable ex = ctx.failure();
				LOG.error("Error occured. ", ex);
				ctx.json(new JsonObject().put("error", new JsonObject().put("message", ex.getMessage())));
			});

			StaticHandler staticHandler = StaticHandler.create().setCachingEnabled(false).setFilesReadOnly(false);
			if(staticPath != null) {
				staticHandler.setAllowRootFileSystemAccess(true);
				staticHandler.setWebRoot(staticPath);
			}
			router.route("/static/*").handler(staticHandler);

			LOG.info(configureUiComplete);
			promise.complete();
		} catch(Exception ex) {
			LOG.error(configureUiFail);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> putVarsInRoutingContext(RoutingContext ctx) {
		Promise<Void> promise = Promise.promise();
		try {
			for(Entry<String, String> entry : ctx.queryParams()) {
				String paramName = entry.getKey();
				String paramObject = entry.getValue();
				String entityVar = null;
				String valueIndexed = null;

				switch(paramName) {
					case "var":
						entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
						valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
						ctx.put(entityVar, valueIndexed);
						break;
				}
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error(String.format("putVarsInRoutingContext failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**	
	 * 
	 * Val.ErrorServer.enUS:The server is not configured properly. 
	 * Val.SuccessServer.enUS:The HTTP server is running: %s
	 * Val.BeforeServer.enUS:HTTP server starting: %s
	 * Val.Ssl.enUS:Configuring SSL: %s
	 * 
	 *	Start the Vert.x server. 
	 *	Démarrer le serveur Vert.x. 
	 **/
	private Future<Void> startServer() {
		Promise<Void> promise = Promise.promise();

		try {
			Boolean sslPassthrough = config().getBoolean(ConfigKeys.SSL_PASSTHROUGH, false);
			String siteBaseUrl = config().getString(ConfigKeys.SITE_BASE_URL);
			Integer sitePort = config().getInteger(ConfigKeys.SITE_PORT);
			String sslJksPath = config().getString(ConfigKeys.SSL_JKS_PATH);
			HttpServerOptions options = new HttpServerOptions();
			if(sslPassthrough) {
				options.setKeyStoreOptions(new JksOptions().setPath(sslJksPath).setPassword(config().getString(ConfigKeys.SSL_JKS_PASSWORD)));
				options.setSsl(true);
				LOG.info(String.format(startServerSsl, sslJksPath));
			}
			options.setPort(sitePort);
	
			LOG.info(String.format(startServerBeforeServer, siteBaseUrl));
			vertx.createHttpServer(options).requestHandler(router).listen(ar -> {
				if (ar.succeeded()) {
					LOG.info(String.format(startServerSuccessServer, siteBaseUrl));
					promise.complete();
				} else {
					LOG.error(startServerErrorServer, ar.cause());
					promise.fail(ar.cause());
				}
			});
		} catch (Exception ex) {
			LOG.error(startServerErrorServer, ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	/**	
	 *	This is called by Vert.x when the verticle instance is undeployed. 
	 *	Setup the stopPromise to handle tearing down the server. 
	 * Val.Fail.enUS:Could not close the database client connection. 
	 * Val.Complete.enUS:The database client connection was closed. 
	 **/
	@Override()
	public void  stop(Promise<Void> promise) throws Exception, Exception {
		if(pgPool != null) {
			pgPool.close().onSuccess(a -> {
				LOG.info(stopComplete);
				promise.complete();
			}).onFailure(ex -> {
				LOG.error(stopFail, ex);
				promise.fail(ex);
			});
		}
	}

	public String toId(String s) {
		if(s != null) {
			s = Normalizer.normalize(s, Normalizer.Form.NFD);
			s = StringUtils.lowerCase(s);
			s = StringUtils.trim(s);
			s = StringUtils.replacePattern(s, "\\s{1,}", "-");
			s = StringUtils.replacePattern(s, "[^\\w-]", "");
			s = StringUtils.replacePattern(s, "-{2,}", "-");
		}

		return s;
	}
}
