package org.choicehumanitarian.reports.enus.model.report.type;

import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.model.base.BaseModel;
import io.vertx.core.json.JsonObject;
import java.util.Date;
import java.util.Set;
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
import java.lang.Long;
import org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule;
import java.lang.String;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**	
 * <h1>Suggestions that can generate more code for you: </h1>
 * <ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ReportTypeGen into the class ReportType. 
 * </li>
 * </ol>
 * <h1>About the ReportType class and it's generated class ReportTypeGen&lt;BaseModel&gt;: </h1>
 * <p>
 * This Java class extends a generated Java class built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportType">Find the class ReportType in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * <p>This class contains a comment "Model: true", which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <p>This class contains a comment "Indexed: true", which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <p>This class contains a comment "Page: true", which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.choicehumanitarian.reports.enus.model.report.type.ReportTypePage. 
 * </p>
 * <p>This class contains a comment "SuperPage.enUS: BaseModelPage", which identifies the Java super class of the page code by it's class simple name "BaseModelPage". 
 * This means that the newly created class org.choicehumanitarian.reports.enus.model.report.type.ReportTypePage extends org.choicehumanitarian.reports.enus.model.base.BaseModelPage. 
 * </p>
 * <p>This class contains a comment "Api: true", which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <p>This class contains a comment "ApiTag: Report Type", which groups all of the OpenAPIs for ReportType objects under the tag "Report Type". 
 * </p>
 * <p>This class contains a comment "ApiUri: /api/report-type", which defines the base API URI for ReportType objects as "/api/report-type" in the OpenAPI spec. 
 * </p>
 * <p>
 * Delete the class ReportType in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportType&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.choicehumanitarian.reports.enus.model.report.type in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project choice-reports in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:choice\-reports&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 **/
public abstract class ReportTypeGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(ReportType.class);

	public static final String ReportType_AName_enUS = "a report type";
	public static final String ReportType_This_enUS = "this ";
	public static final String ReportType_ThisName_enUS = "this report type";
	public static final String ReportType_A_enUS = "a ";
	public static final String ReportType_TheName_enUS = "the report type";
	public static final String ReportType_NameSingular_enUS = "report type";
	public static final String ReportType_NamePlural_enUS = "report types";
	public static final String ReportType_NameActual_enUS = "current report type";
	public static final String ReportType_AllName_enUS = "all the report types";
	public static final String ReportType_SearchAllNameBy_enUS = "search report types by ";
	public static final String ReportType_Title_enUS = "report types";
	public static final String ReportType_ThePluralName_enUS = "the report types";
	public static final String ReportType_NoNameFound_enUS = "no report type found";
	public static final String ReportType_NameVar_enUS = "reportType";
	public static final String ReportType_OfName_enUS = "of report type";
	public static final String ReportType_ANameAdjective_enUS = "a report type";
	public static final String ReportType_NameAdjectiveSingular_enUS = "report type";
	public static final String ReportType_NameAdjectivePlural_enUS = "report types";
	public static final String PUTImport_enUS_Uri = "/api/report-type-import";
	public static final String PUTImport_enUS_ImageUri = "/png/api/report-type-import-999.png";
	public static final String POST_enUS_Uri = "/api/report-type";
	public static final String POST_enUS_ImageUri = "/png/api/report-type-999.png";
	public static final String PATCH_enUS_Uri = "/api/report-type";
	public static final String PATCH_enUS_ImageUri = "/png/api/report-type-999.png";
	public static final String GET_enUS_Uri = "/api/report-type/{id}";
	public static final String GET_enUS_ImageUri = "/png/api/report-type/{id}-999.png";
	public static final String Search_enUS_Uri = "/api/report-type";
	public static final String Search_enUS_ImageUri = "/png/api/report-type-999.png";
	public static final String SearchPage_enUS_Uri = "/report-type";
	public static final String SearchPage_enUS_ImageUri = "/png/report-type-999.png";

	public static final String ReportType_Color = "light-green";
	public static final String ReportType_IconGroup = "duotone";
	public static final String ReportType_IconName = "list-dropdown";
	public static final Integer ReportType_Rows = 100;

	//////////////////
	// scheduleKeys //
	//////////////////

	/**	 The entity scheduleKeys
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonSerialize(contentUsing = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Long> scheduleKeys = new ArrayList<Long>();

	/**	<br> The entity scheduleKeys
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportType&fq=entiteVar_enUS_indexed_string:scheduleKeys">Find the entity scheduleKeys in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _scheduleKeys(List<Long> l);

	public List<Long> getScheduleKeys() {
		return scheduleKeys;
	}

	public void setScheduleKeys(List<Long> scheduleKeys) {
		this.scheduleKeys = scheduleKeys;
	}
	@JsonIgnore
	public void setScheduleKeys(String o) {
		Long l = ReportType.staticSetScheduleKeys(siteRequest_, o);
		if(l != null)
			addScheduleKeys(l);
	}
	public static Long staticSetScheduleKeys(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public ReportType addScheduleKeys(Long...objects) {
		for(Long o : objects) {
			addScheduleKeys(o);
		}
		return (ReportType)this;
	}
	public ReportType addScheduleKeys(Long o) {
		if(o != null)
			this.scheduleKeys.add(o);
		return (ReportType)this;
	}
	@JsonIgnore
	public void setScheduleKeys(JsonArray objects) {
		scheduleKeys.clear();
		for(int i = 0; i < objects.size(); i++) {
			Long o = objects.getLong(i);
			addScheduleKeys(o);
		}
	}
	public ReportType addScheduleKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addScheduleKeys(p);
		}
		return (ReportType)this;
	}
	protected ReportType scheduleKeysInit() {
		_scheduleKeys(scheduleKeys);
		return (ReportType)this;
	}

	public static Long staticSearchScheduleKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrScheduleKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqScheduleKeys(SiteRequestEnUS siteRequest_, String o) {
		return ReportType.staticSearchStrScheduleKeys(siteRequest_, ReportType.staticSearchScheduleKeys(siteRequest_, ReportType.staticSetScheduleKeys(siteRequest_, o)));
	}

	public List<Long> sqlScheduleKeys() {
		return scheduleKeys;
	}

	//////////////
	// typeName //
	//////////////

	/**	 The entity typeName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String typeName;

	/**	<br> The entity typeName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportType&fq=entiteVar_enUS_indexed_string:typeName">Find the entity typeName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _typeName(Wrap<String> w);

	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String o) {
		this.typeName = ReportType.staticSetTypeName(siteRequest_, o);
	}
	public static String staticSetTypeName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ReportType typeNameInit() {
		Wrap<String> typeNameWrap = new Wrap<String>().var("typeName");
		if(typeName == null) {
			_typeName(typeNameWrap);
			setTypeName(typeNameWrap.o);
		}
		return (ReportType)this;
	}

	public static String staticSearchTypeName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTypeName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTypeName(SiteRequestEnUS siteRequest_, String o) {
		return ReportType.staticSearchStrTypeName(siteRequest_, ReportType.staticSearchTypeName(siteRequest_, ReportType.staticSetTypeName(siteRequest_, o)));
	}

	public String sqlTypeName() {
		return typeName;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepReportType(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepReportType();
	}

	public Future<Void> promiseDeepReportType() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseReportType(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepBaseModel(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseReportType(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				scheduleKeysInit();
				typeNameInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override public Future<Void> promiseDeepForClass(SiteRequestEnUS siteRequest_) {
		return promiseDeepReportType(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportType(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestReportType(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainReportType(v);
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
	public Object obtainReportType(String var) {
		ReportType oReportType = (ReportType)this;
		switch(var) {
			case "scheduleKeys":
				return oReportType.scheduleKeys;
			case "typeName":
				return oReportType.typeName;
			default:
				return super.obtainBaseModel(var);
		}
	}

	///////////////
	// relate //
	///////////////

	@Override public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateReportType(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateReportType(String var, Object val) {
		ReportType oReportType = (ReportType)this;
		switch(var) {
			case "scheduleKeys":
				oReportType.addScheduleKeys((Long)val);
				if(!saves.contains("scheduleKeys"))
					saves.add("scheduleKeys");
				return val;
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetReportType(entityVar,  siteRequest_, o);
	}
	public static Object staticSetReportType(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "scheduleKeys":
			return ReportType.staticSetScheduleKeys(siteRequest_, o);
		case "typeName":
			return ReportType.staticSetTypeName(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchReportType(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchReportType(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "scheduleKeys":
			return ReportType.staticSearchScheduleKeys(siteRequest_, (Long)o);
		case "typeName":
			return ReportType.staticSearchTypeName(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrReportType(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrReportType(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "scheduleKeys":
			return ReportType.staticSearchStrScheduleKeys(siteRequest_, (Long)o);
		case "typeName":
			return ReportType.staticSearchStrTypeName(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqReportType(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqReportType(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "scheduleKeys":
			return ReportType.staticSearchFqScheduleKeys(siteRequest_, o);
		case "typeName":
			return ReportType.staticSearchFqTypeName(siteRequest_, o);
			default:
				return BaseModel.staticSearchFqBaseModel(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// persist //
	/////////////

	@Override public boolean persistForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = persistReportType(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistReportType(String var, Object val) {
		switch(var.toLowerCase()) {
			case "typename":
				if(val instanceof String)
					setTypeName((String)val);
				saves.add("typeName");
				return val;
			default:
				return super.persistBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateReportType(doc);
	}
	public void populateReportType(SolrResponse.Doc doc) {
		ReportType oReportType = (ReportType)this;
		saves = doc.get("saves_docvalues_strings");
		if(saves != null) {
		}

		super.populateBaseModel(doc);
	}

	public void indexReportType(JsonObject doc) {
		if(scheduleKeys != null) {
			JsonArray l = new JsonArray();
			doc.put("scheduleKeys_docvalues_longs", l);
			for(Long o : scheduleKeys) {
				l.add(o);
			}
		}
		if(typeName != null) {
			doc.put("typeName_docvalues_string", typeName);
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredReportType(String entityVar) {
		switch(entityVar) {
			case "scheduleKeys":
				return "scheduleKeys_docvalues_longs";
			case "typeName":
				return "typeName_docvalues_string";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedReportType(String entityVar) {
		switch(entityVar) {
			case "scheduleKeys":
				return "scheduleKeys_docvalues_longs";
			case "typeName":
				return "typeName_docvalues_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarReportType(String searchVar) {
		switch(searchVar) {
			case "scheduleKeys_docvalues_longs":
				return "scheduleKeys";
			case "typeName_docvalues_string":
				return "typeName";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
		}
	}

	public static String varSearchReportType(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedReportType(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeReportType(doc);
	}
	public void storeReportType(SolrResponse.Doc doc) {
		ReportType oReportType = (ReportType)this;

		Optional.ofNullable((List<?>)doc.get("scheduleKeys_docvalues_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oReportType.addScheduleKeys(v.toString());
		});
		oReportType.setTypeName(Optional.ofNullable(doc.get("typeName_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestReportType() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ReportType) {
			ReportType original = (ReportType)o;
			if(!Objects.equals(scheduleKeys, original.getScheduleKeys()))
				apiRequest.addVars("scheduleKeys");
			if(!Objects.equals(typeName, original.getTypeName()))
				apiRequest.addVars("typeName");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(scheduleKeys).map(v -> "scheduleKeys: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(typeName).map(v -> "typeName: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "ReportType";
	public static final String VAR_scheduleKeys = "scheduleKeys";
	public static final String VAR_typeName = "typeName";

	public static List<String> varsQForClass() {
		return ReportType.varsQReportType(new ArrayList<String>());
	}
	public static List<String> varsQReportType(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return ReportType.varsFqReportType(new ArrayList<String>());
	}
	public static List<String> varsFqReportType(List<String> vars) {
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return ReportType.varsRangeReportType(new ArrayList<String>());
	}
	public static List<String> varsRangeReportType(List<String> vars) {
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_scheduleKeys = "report schedules";
	public static final String DISPLAY_NAME_typeName = "type name";

	public static String displayNameForClass(String var) {
		return ReportType.displayNameReportType(var);
	}
	public static String displayNameReportType(String var) {
		switch(var) {
		case VAR_scheduleKeys:
			return DISPLAY_NAME_scheduleKeys;
		case VAR_typeName:
			return DISPLAY_NAME_typeName;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionReportType(String var) {
		switch(var) {
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameReportType(String var) {
		switch(var) {
		case VAR_scheduleKeys:
			return "List";
		case VAR_typeName:
			return "String";
			default:
				return BaseModel.classSimpleNameBaseModel(var);
		}
	}

	public static Integer htmlColumnReportType(String var) {
		switch(var) {
			default:
				return BaseModel.htmlColumnBaseModel(var);
		}
	}

	public static Integer htmlRowReportType(String var) {
		switch(var) {
		case VAR_scheduleKeys:
			return 3;
		case VAR_typeName:
			return 3;
			default:
				return BaseModel.htmlRowBaseModel(var);
		}
	}

	public static Integer htmlCellReportType(String var) {
		switch(var) {
		case VAR_scheduleKeys:
			return 1;
		case VAR_typeName:
			return 1;
			default:
				return BaseModel.htmlCellBaseModel(var);
		}
	}

	public static Integer lengthMinReportType(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxReportType(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxReportType(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minReportType(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
