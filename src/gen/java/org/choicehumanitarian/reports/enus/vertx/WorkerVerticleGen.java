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
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class WorkerVerticleGen into the class WorkerVerticle. 
 * </li>
 * <li>You can add a class comment "Api: true" if you wish to GET, POST, PATCH or PUT these WorkerVerticle objects in a RESTful API. 
 * </li>
 * </ol>
 * <h1>About the WorkerVerticle class and it's generated class WorkerVerticleGen&lt;AbstractVerticle&gt;: </h1>
 * <p>
 * This Java class extends a generated Java class built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.vertx.WorkerVerticle">Find the class WorkerVerticle in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * <p>
 * Delete the class WorkerVerticle in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.vertx.WorkerVerticle&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
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
public abstract class WorkerVerticleGen<DEV> extends AbstractVerticle {
	protected static final Logger LOG = LoggerFactory.getLogger(WorkerVerticle.class);
	public static final String configureHandlebarsFail1 = "Handlebars was not configured properly. ";
	public static final String configureHandlebarsFail = configureHandlebarsFail1;
	public static final String configureHandlebarsComplete1 = "Handlebars was configured properly. ";
	public static final String configureHandlebarsComplete = configureHandlebarsComplete1;

	public static final String configureDataConnectionError1 = "Could not open the database client connection. ";
	public static final String configureDataConnectionError = configureDataConnectionError1;
	public static final String configureDataConnectionSuccess1 = "The database client connection was successful. ";
	public static final String configureDataConnectionSuccess = configureDataConnectionSuccess1;
	public static final String configureDataInitError1 = "Could not initialize the database tables. ";
	public static final String configureDataInitError = configureDataInitError1;
	public static final String configureDataInitSuccess1 = "The database tables were created successfully. ";
	public static final String configureDataInitSuccess = configureDataInitSuccess1;

	public static final String configureSharedWorkerExecutorFail1 = "Could not configure the shared worker executor. ";
	public static final String configureSharedWorkerExecutorFail = configureSharedWorkerExecutorFail1;
	public static final String configureSharedWorkerExecutorComplete1 = "The shared worker executor \"{}\" was configured successfully. ";
	public static final String configureSharedWorkerExecutorComplete = configureSharedWorkerExecutorComplete1;

	public static final String configureEmailComplete1 = "Configure sending email succeeded. ";
	public static final String configureEmailComplete = configureEmailComplete1;
	public static final String configureEmailFail1 = "Configure sending email failed. ";
	public static final String configureEmailFail = configureEmailFail1;

	public static final String importTimerScheduling1 = "Scheduling the %s import at %s";
	public static final String importTimerScheduling = importTimerScheduling1;
	public static final String importTimerSkip1 = "Skip importing %s data. ";
	public static final String importTimerSkip = importTimerSkip1;
	public static final String importTimerFail1 = "Scheduling the import of %s data failed. ";
	public static final String importTimerFail = importTimerFail1;

	public static final String importDataComplete1 = "Importing initial data completed. ";
	public static final String importDataComplete = importDataComplete1;
	public static final String importDataFail1 = "Importing initial data failed. ";
	public static final String importDataFail = importDataFail1;
	public static final String importDataSkip1 = "Skip importing data. ";
	public static final String importDataSkip = importDataSkip1;

	public static final String refreshAllDataComplete1 = "Refresh all data completed. ";
	public static final String refreshAllDataComplete = refreshAllDataComplete1;
	public static final String refreshAllDataStarted1 = "Refresh all data started. ";
	public static final String refreshAllDataStarted = refreshAllDataStarted1;
	public static final String refreshAllDataFail1 = "Refresh all data failed. ";
	public static final String refreshAllDataFail = refreshAllDataFail1;
	public static final String refreshAllDataSkip1 = "Refresh all data skipped. ";
	public static final String refreshAllDataSkip = refreshAllDataSkip1;

	public static final String refreshDataComplete1 = "%s refresh completed. ";
	public static final String refreshDataComplete = refreshDataComplete1;
	public static final String refreshDataStarted1 = "%s data sync started. ";
	public static final String refreshDataStarted = refreshDataStarted1;
	public static final String refreshDataSkip1 = "%s refresh skipped. ";
	public static final String refreshDataSkip = refreshDataSkip1;
	public static final String refreshDataFail1 = "%s refresh failed. ";
	public static final String refreshDataFail = refreshDataFail1;
	public static final String refreshDataCounterResetFail1 = "%s data sync failed to reset counter. ";
	public static final String refreshDataCounterResetFail = refreshDataCounterResetFail1;


	//////////////
	// initDeep //
	//////////////

	public WorkerVerticle initDeepWorkerVerticle(SiteRequestEnUS siteRequest_) {
		initDeepWorkerVerticle();
		return (WorkerVerticle)this;
	}

	public void initDeepWorkerVerticle() {
		initWorkerVerticle();
	}

	public void initWorkerVerticle() {
	}

	public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepWorkerVerticle(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainWorkerVerticle(v);
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
	public Object obtainWorkerVerticle(String var) {
		WorkerVerticle oWorkerVerticle = (WorkerVerticle)this;
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
				o = relateWorkerVerticle(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateWorkerVerticle(String var, Object val) {
		WorkerVerticle oWorkerVerticle = (WorkerVerticle)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetWorkerVerticle(entityVar,  siteRequest_, o);
	}
	public static Object staticSetWorkerVerticle(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchWorkerVerticle(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchWorkerVerticle(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrWorkerVerticle(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrWorkerVerticle(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqWorkerVerticle(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqWorkerVerticle(String entityVar, SiteRequestEnUS siteRequest_, String o) {
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

	public static final String[] WorkerVerticleVals = new String[] { configureHandlebarsFail1, configureHandlebarsComplete1, configureDataConnectionError1, configureDataConnectionSuccess1, configureDataInitError1, configureDataInitSuccess1, configureSharedWorkerExecutorFail1, configureSharedWorkerExecutorComplete1, configureEmailComplete1, configureEmailFail1, importTimerScheduling1, importTimerSkip1, importTimerFail1, importDataComplete1, importDataFail1, importDataSkip1, refreshAllDataComplete1, refreshAllDataStarted1, refreshAllDataFail1, refreshAllDataSkip1, refreshDataComplete1, refreshDataStarted1, refreshDataSkip1, refreshDataFail1, refreshDataCounterResetFail1 };

	public static final String CLASS_SIMPLE_NAME = "WorkerVerticle";


	public static String displayNameForClass(String var) {
		return WorkerVerticle.displayNameWorkerVerticle(var);
	}
	public static String displayNameWorkerVerticle(String var) {
		switch(var) {
		default:
			return null;
		}
	}
}
