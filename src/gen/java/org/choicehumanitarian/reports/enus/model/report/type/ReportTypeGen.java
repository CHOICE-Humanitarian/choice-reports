package org.choicehumanitarian.reports.enus.model.report.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import org.computate.search.response.solr.SolrResponse;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import java.math.RoundingMode;
import org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule;
import org.slf4j.Logger;
import java.math.MathContext;
import io.vertx.core.Promise;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import org.choicehumanitarian.reports.enus.base.BaseModel;
import java.util.Objects;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import io.vertx.core.json.JsonArray;
import java.util.List;
import org.computate.search.wrap.Wrap;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportType&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ReportTypeGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(ReportType.class);

	public static final String ReportType_AName = "a donor";
	public static final String ReportType_This = "this ";
	public static final String ReportType_ThisName = "this donor";
	public static final String ReportType_A = "a ";
	public static final String ReportType_TheName = "the donor";
	public static final String ReportType_NameSingular = "donor";
	public static final String ReportType_NamePlural = "donors";
	public static final String ReportType_NameActual = "current donor";
	public static final String ReportType_AllName = "all the donors";
	public static final String ReportType_SearchAllNameBy = "search donors by ";
	public static final String ReportType_Title = "donors";
	public static final String ReportType_ThePluralName = "the donors";
	public static final String ReportType_NoNameFound = "no donor found";
	public static final String ReportType_NameVar = "reportType";
	public static final String ReportType_OfName = "of donor";
	public static final String ReportType_ANameAdjective = "a donor";
	public static final String ReportType_NameAdjectiveSingular = "donor";
	public static final String ReportType_NameAdjectivePlural = "donors";
	public static final String ReportType_Color = "light-green";
	public static final String ReportType_IconGroup = "duotone";
	public static final String ReportType_IconName = "hands-heart";
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportType&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:scheduleKeys">Find the entity scheduleKeys in Solr</a>
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
	public ReportType addScheduleKeys(Long...objets) {
		for(Long o : objets) {
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
	public void setScheduleKeys(JsonArray objets) {
		scheduleKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportType&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:typeName">Find the entity typeName in Solr</a>
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
	// define //
	/////////////

	@Override public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineReportType(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineReportType(String var, Object val) {
		switch(var.toLowerCase()) {
			case "typename":
				if(val instanceof String)
					setTypeName((String)val);
				saves.add("typeName");
				return val;
			default:
				return super.defineBaseModel(var, val);
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

	public static final String VAR_scheduleKeys = "scheduleKeys";
	public static final String VAR_typeName = "typeName";

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
}
