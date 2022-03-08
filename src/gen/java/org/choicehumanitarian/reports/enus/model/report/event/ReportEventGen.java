package org.choicehumanitarian.reports.enus.model.report.event;

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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import java.math.RoundingMode;
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
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEvent&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ReportEventGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(ReportEvent.class);

	public static final String ReportEvent_AName = "a donor";
	public static final String ReportEvent_This = "this ";
	public static final String ReportEvent_ThisName = "this donor";
	public static final String ReportEvent_A = "a ";
	public static final String ReportEvent_TheName = "the donor";
	public static final String ReportEvent_NameSingular = "donor";
	public static final String ReportEvent_NamePlural = "donors";
	public static final String ReportEvent_NameActual = "current donor";
	public static final String ReportEvent_AllName = "all the donors";
	public static final String ReportEvent_SearchAllNameBy = "search donors by ";
	public static final String ReportEvent_Title = "donors";
	public static final String ReportEvent_ThePluralName = "the donors";
	public static final String ReportEvent_NoNameFound = "no donor found";
	public static final String ReportEvent_NameVar = "reportEvent";
	public static final String ReportEvent_OfName = "of donor";
	public static final String ReportEvent_ANameAdjective = "a donor";
	public static final String ReportEvent_NameAdjectiveSingular = "donor";
	public static final String ReportEvent_NameAdjectivePlural = "donors";
	public static final String ReportEvent_Color = "light-green";
	public static final String ReportEvent_IconGroup = "duotone";
	public static final String ReportEvent_IconName = "hands-heart";
	public static final Integer ReportEvent_Rows = 100;

	///////////////
	// eventName //
	///////////////

	/**	 The entity eventName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String eventName;

	/**	<br> The entity eventName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEvent&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:eventName">Find the entity eventName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _eventName(Wrap<String> w);

	public String getEventName() {
		return eventName;
	}
	public void setEventName(String o) {
		this.eventName = ReportEvent.staticSetEventName(siteRequest_, o);
	}
	public static String staticSetEventName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ReportEvent eventNameInit() {
		Wrap<String> eventNameWrap = new Wrap<String>().var("eventName");
		if(eventName == null) {
			_eventName(eventNameWrap);
			setEventName(eventNameWrap.o);
		}
		return (ReportEvent)this;
	}

	public static String staticSearchEventName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrEventName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqEventName(SiteRequestEnUS siteRequest_, String o) {
		return ReportEvent.staticSearchStrEventName(siteRequest_, ReportEvent.staticSearchEventName(siteRequest_, ReportEvent.staticSetEventName(siteRequest_, o)));
	}

	public String sqlEventName() {
		return eventName;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepReportEvent(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepReportEvent();
	}

	public Future<Void> promiseDeepReportEvent() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseReportEvent(promise2);
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

	public Future<Void> promiseReportEvent(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				eventNameInit();
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
		return promiseDeepReportEvent(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportEvent(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestReportEvent(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainReportEvent(v);
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
	public Object obtainReportEvent(String var) {
		ReportEvent oReportEvent = (ReportEvent)this;
		switch(var) {
			case "eventName":
				return oReportEvent.eventName;
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
				o = relateReportEvent(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateReportEvent(String var, Object val) {
		ReportEvent oReportEvent = (ReportEvent)this;
		switch(var) {
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetReportEvent(entityVar,  siteRequest_, o);
	}
	public static Object staticSetReportEvent(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "eventName":
			return ReportEvent.staticSetEventName(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchReportEvent(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchReportEvent(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "eventName":
			return ReportEvent.staticSearchEventName(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrReportEvent(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrReportEvent(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "eventName":
			return ReportEvent.staticSearchStrEventName(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqReportEvent(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqReportEvent(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "eventName":
			return ReportEvent.staticSearchFqEventName(siteRequest_, o);
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
					o = defineReportEvent(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineReportEvent(String var, Object val) {
		switch(var.toLowerCase()) {
			case "eventname":
				if(val instanceof String)
					setEventName((String)val);
				saves.add("eventName");
				return val;
			default:
				return super.defineBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateReportEvent(doc);
	}
	public void populateReportEvent(SolrResponse.Doc doc) {
		ReportEvent oReportEvent = (ReportEvent)this;
		saves = doc.get("saves_docvalues_strings");
		if(saves != null) {
		}

		super.populateBaseModel(doc);
	}

	public void indexReportEvent(JsonObject doc) {
		if(eventName != null) {
			doc.put("eventName_docvalues_string", eventName);
		}
		super.indexBaseModel(doc);

	}

	public static String varIndexedReportEvent(String entityVar) {
		switch(entityVar) {
			case "eventName":
				return "eventName_docvalues_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String varSearchReportEvent(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedReportEvent(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeReportEvent(doc);
	}
	public void storeReportEvent(SolrResponse.Doc doc) {
		ReportEvent oReportEvent = (ReportEvent)this;

		oReportEvent.setEventName(Optional.ofNullable(doc.get("eventName_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestReportEvent() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ReportEvent) {
			ReportEvent original = (ReportEvent)o;
			if(!Objects.equals(eventName, original.getEventName()))
				apiRequest.addVars("eventName");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(eventName).map(v -> "eventName: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String VAR_eventName = "eventName";

	public static final String DISPLAY_NAME_eventName = "event name";

	public static String displayNameForClass(String var) {
		return ReportEvent.displayNameReportEvent(var);
	}
	public static String displayNameReportEvent(String var) {
		switch(var) {
		case VAR_eventName:
			return DISPLAY_NAME_eventName;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}
}