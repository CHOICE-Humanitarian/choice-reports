package org.choicehumanitarian.reports.enus.vertx;

import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.model.base.BaseModel;
import org.computate.vertx.api.ApiRequest;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import java.util.Optional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.MathContext;
import org.apache.commons.lang3.math.NumberUtils;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.RoundingMode;
import java.util.Map;
import io.vertx.core.AbstractVerticle;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**	
 * <h1>Suggestions that can generate more code for you: </h1>
 * <ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class MainVerticleGen into the class MainVerticle. 
 * </li>
 * <li>You can add a class comment "Api: true" if you wish to GET, POST, PATCH or PUT these MainVerticle objects in a RESTful API. 
 * </li>
 * </ol>
 * <h1>About the MainVerticle class and it's generated class MainVerticleGen&lt;AbstractVerticle&gt;: </h1>
 * <p>
 * This Java class extends a generated Java class built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.vertx.MainVerticle">Find the class MainVerticle in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * <p>
 * Delete the class MainVerticle in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.vertx.MainVerticle&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.choicehumanitarian.reports.enus.vertx in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.choicehumanitarian.reports.enus.vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project choice-reports in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:choice\-reports&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 **/
public abstract class MainVerticleGen<DEV> extends AbstractVerticle {
	protected static final Logger LOG = LoggerFactory.getLogger(MainVerticle.class);
	public static final String configureDataConnectionError1 = "Could not open the database client connection. ";
	public static final String configureDataConnectionError = configureDataConnectionError1;
	public static final String configureDataConnectionSuccess1 = "The database client connection was successful. ";
	public static final String configureDataConnectionSuccess = configureDataConnectionSuccess1;
	public static final String configureDataInitError1 = "Could not initialize the database. ";
	public static final String configureDataInitError = configureDataInitError1;
	public static final String configureDataInitSuccess1 = "The database was initialized successfully. ";
	public static final String configureDataInitSuccess = configureDataInitSuccess1;

	public static final String configureOpenApiError1 = "Could not configure the auth server and API. ";
	public static final String configureOpenApiError = configureOpenApiError1;
	public static final String configureOpenApiSuccess1 = "The auth server and API was configured successfully. ";
	public static final String configureOpenApiSuccess = configureOpenApiSuccess1;

	public static final String configureConfigComplete1 = "The config was configured successfully. ";
	public static final String configureConfigComplete = configureConfigComplete1;
	public static final String configureConfigFail1 = "Could not configure the config(). ";
	public static final String configureConfigFail = configureConfigFail1;

	public static final String configureSharedWorkerExecutorFail1 = "Could not configure the shared worker executor. ";
	public static final String configureSharedWorkerExecutorFail = configureSharedWorkerExecutorFail1;
	public static final String configureSharedWorkerExecutorComplete1 = "The shared worker executor \"{}\" was configured successfully. ";
	public static final String configureSharedWorkerExecutorComplete = configureSharedWorkerExecutorComplete1;

	public static final String configureHealthChecksComplete1 = "The health checks were configured successfully. ";
	public static final String configureHealthChecksComplete = configureHealthChecksComplete1;
	public static final String configureHealthChecksFail1 = "Could not configure the health checks. ";
	public static final String configureHealthChecksFail = configureHealthChecksFail1;
	public static final String configureHealthChecksErrorDatabase1 = "The database is not configured properly. ";
	public static final String configureHealthChecksErrorDatabase = configureHealthChecksErrorDatabase1;
	public static final String configureHealthChecksEmptySolr1 = "The Solr search engine is empty. ";
	public static final String configureHealthChecksEmptySolr = configureHealthChecksEmptySolr1;
	public static final String configureHealthChecksErrorSolr1 = "The Solr search engine is not configured properly. ";
	public static final String configureHealthChecksErrorSolr = configureHealthChecksErrorSolr1;
	public static final String configureHealthChecksErrorVertx1 = "The Vert.x application is not configured properly. ";
	public static final String configureHealthChecksErrorVertx = configureHealthChecksErrorVertx1;

	public static final String configureWebsocketsComplete1 = "Configure websockets succeeded. ";
	public static final String configureWebsocketsComplete = configureWebsocketsComplete1;
	public static final String configureWebsocketsFail1 = "Configure websockets failed. ";
	public static final String configureWebsocketsFail = configureWebsocketsFail1;

	public static final String configureEmailComplete1 = "Configure sending email succeeded. ";
	public static final String configureEmailComplete = configureEmailComplete1;
	public static final String configureEmailFail1 = "Configure sending email failed. ";
	public static final String configureEmailFail = configureEmailFail1;

	public static final String configureHandlebarsFail1 = "Handlebars was not configured properly. ";
	public static final String configureHandlebarsFail = configureHandlebarsFail1;
	public static final String configureHandlebarsComplete1 = "Handlebars was configured properly. ";
	public static final String configureHandlebarsComplete = configureHandlebarsComplete1;

	public static final String configureApiFail1 = "The API was not configured properly. ";
	public static final String configureApiFail = configureApiFail1;
	public static final String configureApiComplete1 = "The API was configured properly. ";
	public static final String configureApiComplete = configureApiComplete1;

	public static final String configureUiFail1 = "The UI was not configured properly. ";
	public static final String configureUiFail = configureUiFail1;
	public static final String configureUiComplete1 = "The UI was configured properly. ";
	public static final String configureUiComplete = configureUiComplete1;

	public static final String configureCamelFail1 = "The Camel Component was not configured properly. ";
	public static final String configureCamelFail = configureCamelFail1;
	public static final String configureCamelComplete1 = "The Camel Component was configured properly. ";
	public static final String configureCamelComplete = configureCamelComplete1;

	public static final String startServerErrorServer1 = "The server is not configured properly. ";
	public static final String startServerErrorServer = startServerErrorServer1;
	public static final String startServerSuccessServer1 = "The HTTP server is running: %s";
	public static final String startServerSuccessServer = startServerSuccessServer1;
	public static final String startServerBeforeServer1 = "HTTP server starting: %s";
	public static final String startServerBeforeServer = startServerBeforeServer1;
	public static final String startServerSsl1 = "Configuring SSL: %s";
	public static final String startServerSsl = startServerSsl1;

	public static final String stopFail1 = "Could not close the database client connection. ";
	public static final String stopFail = stopFail1;
	public static final String stopComplete1 = "The database client connection was closed. ";
	public static final String stopComplete = stopComplete1;


	//////////////
	// initDeep //
	//////////////

	public MainVerticle initDeepMainVerticle(SiteRequestEnUS siteRequest_) {
		initDeepMainVerticle();
		return (MainVerticle)this;
	}

	public void initDeepMainVerticle() {
		initMainVerticle();
	}

	public void initMainVerticle() {
	}

	public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepMainVerticle(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainMainVerticle(v);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.obtainForClass(v);
			}
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainMainVerticle(String var) {
		MainVerticle oMainVerticle = (MainVerticle)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// relate //
	///////////////

	public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateMainVerticle(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateMainVerticle(String var, Object val) {
		MainVerticle oMainVerticle = (MainVerticle)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetMainVerticle(entityVar,  siteRequest_, o);
	}
	public static Object staticSetMainVerticle(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchMainVerticle(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchMainVerticle(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrMainVerticle(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrMainVerticle(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqMainVerticle(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqMainVerticle(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	public static final String[] MainVerticleVals = new String[] { configureDataConnectionError1, configureDataConnectionSuccess1, configureDataInitError1, configureDataInitSuccess1, configureOpenApiError1, configureOpenApiSuccess1, configureConfigComplete1, configureConfigFail1, configureSharedWorkerExecutorFail1, configureSharedWorkerExecutorComplete1, configureHealthChecksComplete1, configureHealthChecksFail1, configureHealthChecksErrorDatabase1, configureHealthChecksEmptySolr1, configureHealthChecksErrorSolr1, configureHealthChecksErrorVertx1, configureWebsocketsComplete1, configureWebsocketsFail1, configureEmailComplete1, configureEmailFail1, configureHandlebarsFail1, configureHandlebarsComplete1, configureApiFail1, configureApiComplete1, configureUiFail1, configureUiComplete1, configureCamelFail1, configureCamelComplete1, startServerErrorServer1, startServerSuccessServer1, startServerBeforeServer1, startServerSsl1, stopFail1, stopComplete1 };

	public static final String CLASS_SIMPLE_NAME = "MainVerticle";


	public static String displayNameForClass(String var) {
		return MainVerticle.displayNameMainVerticle(var);
	}
	public static String displayNameMainVerticle(String var) {
		switch(var) {
		default:
			return null;
		}
	}
}
