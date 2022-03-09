package org.choicehumanitarian.reports.enus.model.report.narrative;

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
import org.choicehumanitarian.reports.enus.user.SiteUser;
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
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ReportNarrativeGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(ReportNarrative.class);

	public static final String ReportNarrative_AName = "a report narrative";
	public static final String ReportNarrative_This = "this ";
	public static final String ReportNarrative_ThisName = "this report narrative";
	public static final String ReportNarrative_A = "a ";
	public static final String ReportNarrative_TheName = "the report narrative";
	public static final String ReportNarrative_NameSingular = "report narrative";
	public static final String ReportNarrative_NamePlural = "report narratives";
	public static final String ReportNarrative_NameActual = "current report narrative";
	public static final String ReportNarrative_AllName = "all the report narratives";
	public static final String ReportNarrative_SearchAllNameBy = "search report narratives by ";
	public static final String ReportNarrative_Title = "report narratives";
	public static final String ReportNarrative_ThePluralName = "the report narratives";
	public static final String ReportNarrative_NoNameFound = "no report narrative found";
	public static final String ReportNarrative_NameVar = "reportNarrative";
	public static final String ReportNarrative_OfName = "of report narrative";
	public static final String ReportNarrative_ANameAdjective = "a report narrative";
	public static final String ReportNarrative_NameAdjectiveSingular = "report narrative";
	public static final String ReportNarrative_NameAdjectivePlural = "report narratives";
	public static final String ReportNarrative_Color = "light-green";
	public static final String ReportNarrative_IconGroup = "duotone";
	public static final String ReportNarrative_IconName = "calendar-pen";
	public static final Integer ReportNarrative_Rows = 100;

	/////////////////
	// scheduleKey //
	/////////////////

	/**	 The entity scheduleKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long scheduleKey;

	/**	<br> The entity scheduleKey
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:scheduleKey">Find the entity scheduleKey in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _scheduleKey(Wrap<Long> w);

	public Long getScheduleKey() {
		return scheduleKey;
	}

	public void setScheduleKey(Long scheduleKey) {
		this.scheduleKey = scheduleKey;
	}
	@JsonIgnore
	public void setScheduleKey(String o) {
		this.scheduleKey = ReportNarrative.staticSetScheduleKey(siteRequest_, o);
	}
	public static Long staticSetScheduleKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ReportNarrative scheduleKeyInit() {
		Wrap<Long> scheduleKeyWrap = new Wrap<Long>().var("scheduleKey");
		if(scheduleKey == null) {
			_scheduleKey(scheduleKeyWrap);
			setScheduleKey(scheduleKeyWrap.o);
		}
		return (ReportNarrative)this;
	}

	public static Long staticSearchScheduleKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrScheduleKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqScheduleKey(SiteRequestEnUS siteRequest_, String o) {
		return ReportNarrative.staticSearchStrScheduleKey(siteRequest_, ReportNarrative.staticSearchScheduleKey(siteRequest_, ReportNarrative.staticSetScheduleKey(siteRequest_, o)));
	}

	public Long sqlScheduleKey() {
		return scheduleKey;
	}

	/////////////////
	// assigneeKey //
	/////////////////

	/**	 The entity assigneeKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long assigneeKey;

	/**	<br> The entity assigneeKey
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:assigneeKey">Find the entity assigneeKey in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _assigneeKey(Wrap<Long> w);

	public Long getAssigneeKey() {
		return assigneeKey;
	}

	public void setAssigneeKey(Long assigneeKey) {
		this.assigneeKey = assigneeKey;
	}
	@JsonIgnore
	public void setAssigneeKey(String o) {
		this.assigneeKey = ReportNarrative.staticSetAssigneeKey(siteRequest_, o);
	}
	public static Long staticSetAssigneeKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ReportNarrative assigneeKeyInit() {
		Wrap<Long> assigneeKeyWrap = new Wrap<Long>().var("assigneeKey");
		if(assigneeKey == null) {
			_assigneeKey(assigneeKeyWrap);
			setAssigneeKey(assigneeKeyWrap.o);
		}
		return (ReportNarrative)this;
	}

	public static Long staticSearchAssigneeKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrAssigneeKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAssigneeKey(SiteRequestEnUS siteRequest_, String o) {
		return ReportNarrative.staticSearchStrAssigneeKey(siteRequest_, ReportNarrative.staticSearchAssigneeKey(siteRequest_, ReportNarrative.staticSetAssigneeKey(siteRequest_, o)));
	}

	public Long sqlAssigneeKey() {
		return assigneeKey;
	}

	///////////////////
	// narrativeName //
	///////////////////

	/**	 The entity narrativeName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String narrativeName;

	/**	<br> The entity narrativeName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:narrativeName">Find the entity narrativeName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _narrativeName(Wrap<String> w);

	public String getNarrativeName() {
		return narrativeName;
	}
	public void setNarrativeName(String o) {
		this.narrativeName = ReportNarrative.staticSetNarrativeName(siteRequest_, o);
	}
	public static String staticSetNarrativeName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ReportNarrative narrativeNameInit() {
		Wrap<String> narrativeNameWrap = new Wrap<String>().var("narrativeName");
		if(narrativeName == null) {
			_narrativeName(narrativeNameWrap);
			setNarrativeName(narrativeNameWrap.o);
		}
		return (ReportNarrative)this;
	}

	public static String staticSearchNarrativeName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrNarrativeName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNarrativeName(SiteRequestEnUS siteRequest_, String o) {
		return ReportNarrative.staticSearchStrNarrativeName(siteRequest_, ReportNarrative.staticSearchNarrativeName(siteRequest_, ReportNarrative.staticSetNarrativeName(siteRequest_, o)));
	}

	public String sqlNarrativeName() {
		return narrativeName;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepReportNarrative(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepReportNarrative();
	}

	public Future<Void> promiseDeepReportNarrative() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseReportNarrative(promise2);
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

	public Future<Void> promiseReportNarrative(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				scheduleKeyInit();
				assigneeKeyInit();
				narrativeNameInit();
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
		return promiseDeepReportNarrative(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportNarrative(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestReportNarrative(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainReportNarrative(v);
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
	public Object obtainReportNarrative(String var) {
		ReportNarrative oReportNarrative = (ReportNarrative)this;
		switch(var) {
			case "scheduleKey":
				return oReportNarrative.scheduleKey;
			case "assigneeKey":
				return oReportNarrative.assigneeKey;
			case "narrativeName":
				return oReportNarrative.narrativeName;
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
				o = relateReportNarrative(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateReportNarrative(String var, Object val) {
		ReportNarrative oReportNarrative = (ReportNarrative)this;
		switch(var) {
			case "scheduleKey":
				if(oReportNarrative.getScheduleKey() == null)
					oReportNarrative.setScheduleKey(val == null ? null : (NumberUtils.isCreatable(val.toString()) ? Long.parseLong(val.toString()) : null));
				if(!saves.contains("scheduleKey"))
					saves.add("scheduleKey");
				return val;
			case "assigneeKey":
				if(oReportNarrative.getAssigneeKey() == null)
					oReportNarrative.setAssigneeKey(val == null ? null : (NumberUtils.isCreatable(val.toString()) ? Long.parseLong(val.toString()) : null));
				if(!saves.contains("assigneeKey"))
					saves.add("assigneeKey");
				return val;
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetReportNarrative(entityVar,  siteRequest_, o);
	}
	public static Object staticSetReportNarrative(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "scheduleKey":
			return ReportNarrative.staticSetScheduleKey(siteRequest_, o);
		case "assigneeKey":
			return ReportNarrative.staticSetAssigneeKey(siteRequest_, o);
		case "narrativeName":
			return ReportNarrative.staticSetNarrativeName(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchReportNarrative(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchReportNarrative(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "scheduleKey":
			return ReportNarrative.staticSearchScheduleKey(siteRequest_, (Long)o);
		case "assigneeKey":
			return ReportNarrative.staticSearchAssigneeKey(siteRequest_, (Long)o);
		case "narrativeName":
			return ReportNarrative.staticSearchNarrativeName(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrReportNarrative(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrReportNarrative(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "scheduleKey":
			return ReportNarrative.staticSearchStrScheduleKey(siteRequest_, (Long)o);
		case "assigneeKey":
			return ReportNarrative.staticSearchStrAssigneeKey(siteRequest_, (Long)o);
		case "narrativeName":
			return ReportNarrative.staticSearchStrNarrativeName(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqReportNarrative(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqReportNarrative(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "scheduleKey":
			return ReportNarrative.staticSearchFqScheduleKey(siteRequest_, o);
		case "assigneeKey":
			return ReportNarrative.staticSearchFqAssigneeKey(siteRequest_, o);
		case "narrativeName":
			return ReportNarrative.staticSearchFqNarrativeName(siteRequest_, o);
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
					o = defineReportNarrative(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineReportNarrative(String var, Object val) {
		switch(var.toLowerCase()) {
			case "schedulekey":
				if(val instanceof Long)
					setScheduleKey((Long)val);
				else if(val instanceof String)
					setScheduleKey((String)val);
				saves.add("scheduleKey");
				return val;
			case "assigneekey":
				if(val instanceof Long)
					setAssigneeKey((Long)val);
				else if(val instanceof String)
					setAssigneeKey((String)val);
				saves.add("assigneeKey");
				return val;
			case "narrativename":
				if(val instanceof String)
					setNarrativeName((String)val);
				saves.add("narrativeName");
				return val;
			default:
				return super.defineBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateReportNarrative(doc);
	}
	public void populateReportNarrative(SolrResponse.Doc doc) {
		ReportNarrative oReportNarrative = (ReportNarrative)this;
		saves = doc.get("saves_docvalues_strings");
		if(saves != null) {
		}

		super.populateBaseModel(doc);
	}

	public void indexReportNarrative(JsonObject doc) {
		if(scheduleKey != null) {
			doc.put("scheduleKey_docvalues_long", scheduleKey);
		}
		if(assigneeKey != null) {
			doc.put("assigneeKey_docvalues_long", assigneeKey);
		}
		if(narrativeName != null) {
			doc.put("narrativeName_docvalues_string", narrativeName);
		}
		super.indexBaseModel(doc);

	}

	public static String varIndexedReportNarrative(String entityVar) {
		switch(entityVar) {
			case "scheduleKey":
				return "scheduleKey_docvalues_long";
			case "assigneeKey":
				return "assigneeKey_docvalues_long";
			case "narrativeName":
				return "narrativeName_docvalues_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String varSearchReportNarrative(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedReportNarrative(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeReportNarrative(doc);
	}
	public void storeReportNarrative(SolrResponse.Doc doc) {
		ReportNarrative oReportNarrative = (ReportNarrative)this;

		oReportNarrative.setScheduleKey(Optional.ofNullable(doc.get("scheduleKey_docvalues_long")).map(v -> v.toString()).orElse(null));
		oReportNarrative.setAssigneeKey(Optional.ofNullable(doc.get("assigneeKey_docvalues_long")).map(v -> v.toString()).orElse(null));
		oReportNarrative.setNarrativeName(Optional.ofNullable(doc.get("narrativeName_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestReportNarrative() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ReportNarrative) {
			ReportNarrative original = (ReportNarrative)o;
			if(!Objects.equals(scheduleKey, original.getScheduleKey()))
				apiRequest.addVars("scheduleKey");
			if(!Objects.equals(assigneeKey, original.getAssigneeKey()))
				apiRequest.addVars("assigneeKey");
			if(!Objects.equals(narrativeName, original.getNarrativeName()))
				apiRequest.addVars("narrativeName");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(scheduleKey).map(v -> "scheduleKey: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(assigneeKey).map(v -> "assigneeKey: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(narrativeName).map(v -> "narrativeName: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String VAR_scheduleKey = "scheduleKey";
	public static final String VAR_assigneeKey = "assigneeKey";
	public static final String VAR_narrativeName = "narrativeName";

	public static final String DISPLAY_NAME_scheduleKey = "schedule";
	public static final String DISPLAY_NAME_assigneeKey = "assignee";
	public static final String DISPLAY_NAME_narrativeName = "narrative name";

	public static String displayNameForClass(String var) {
		return ReportNarrative.displayNameReportNarrative(var);
	}
	public static String displayNameReportNarrative(String var) {
		switch(var) {
		case VAR_scheduleKey:
			return DISPLAY_NAME_scheduleKey;
		case VAR_assigneeKey:
			return DISPLAY_NAME_assigneeKey;
		case VAR_narrativeName:
			return DISPLAY_NAME_narrativeName;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}
}
