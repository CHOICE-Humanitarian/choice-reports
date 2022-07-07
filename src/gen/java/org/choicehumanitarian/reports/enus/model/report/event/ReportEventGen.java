package org.choicehumanitarian.reports.enus.model.report.event;

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
import org.choicehumanitarian.reports.enus.model.user.SiteUser;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.util.Locale;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEvent">Find the class ReportEvent in Solr. </a>
 * <br><br>Delete the class ReportEvent in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEvent&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the package org.choicehumanitarian.reports.enus.model.report.event in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the project choice-reports in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:choice\-reports&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>
 **/
public abstract class ReportEventGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(ReportEvent.class);

	public static final String ReportEvent_AName_enUS = "a calendar item";
	public static final String ReportEvent_This_enUS = "this ";
	public static final String ReportEvent_ThisName_enUS = "this calendar item";
	public static final String ReportEvent_A_enUS = "a ";
	public static final String ReportEvent_TheName_enUS = "the calendar item";
	public static final String ReportEvent_NameSingular_enUS = "calendar item";
	public static final String ReportEvent_NamePlural_enUS = "calendar items";
	public static final String ReportEvent_NameActual_enUS = "current calendar item";
	public static final String ReportEvent_AllName_enUS = "all the calendar items";
	public static final String ReportEvent_SearchAllNameBy_enUS = "search calendar items by ";
	public static final String ReportEvent_Title_enUS = "calendar items";
	public static final String ReportEvent_ThePluralName_enUS = "the calendar items";
	public static final String ReportEvent_NoNameFound_enUS = "no calendar item found";
	public static final String ReportEvent_NameVar_enUS = "calendarItem";
	public static final String ReportEvent_OfName_enUS = "of calendar item";
	public static final String ReportEvent_ANameAdjective_enUS = "a calendar item";
	public static final String ReportEvent_NameAdjectiveSingular_enUS = "calendar item";
	public static final String ReportEvent_NameAdjectivePlural_enUS = "calendar items";
	public static final String PUTImport_enUS_Uri = "/api/calendar-item-import";
	public static final String PUTImport_enUS_ImageUri = "/png/api/calendar-item-import-999.png";
	public static final String POST_enUS_Uri = "/api/calendar-item";
	public static final String POST_enUS_ImageUri = "/png/api/calendar-item-999.png";
	public static final String PATCH_enUS_Uri = "/api/calendar-item";
	public static final String PATCH_enUS_ImageUri = "/png/api/calendar-item-999.png";
	public static final String GET_enUS_Uri = "/api/calendar-item/{id}";
	public static final String GET_enUS_ImageUri = "/png/api/calendar-item/{id}-999.png";
	public static final String Search_enUS_Uri = "/api/calendar-item";
	public static final String Search_enUS_ImageUri = "/png/api/calendar-item-999.png";
	public static final String SearchPage_enUS_Uri = "/calendar-item";
	public static final String SearchPage_enUS_ImageUri = "/png/calendar-item-999.png";

	public static final String ReportEvent_Color = "light-green";
	public static final String ReportEvent_IconGroup = "duotone";
	public static final String ReportEvent_IconName = "calendar-star";
	public static final Integer ReportEvent_Rows = 100;

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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEvent&fq=entiteVar_enUS_indexed_string:scheduleKey">Find the entity scheduleKey in Solr</a>
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
		this.scheduleKey = ReportEvent.staticSetScheduleKey(siteRequest_, o);
	}
	public static Long staticSetScheduleKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ReportEvent scheduleKeyInit() {
		Wrap<Long> scheduleKeyWrap = new Wrap<Long>().var("scheduleKey");
		if(scheduleKey == null) {
			_scheduleKey(scheduleKeyWrap);
			setScheduleKey(scheduleKeyWrap.o);
		}
		return (ReportEvent)this;
	}

	public static Long staticSearchScheduleKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrScheduleKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqScheduleKey(SiteRequestEnUS siteRequest_, String o) {
		return ReportEvent.staticSearchStrScheduleKey(siteRequest_, ReportEvent.staticSearchScheduleKey(siteRequest_, ReportEvent.staticSetScheduleKey(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEvent&fq=entiteVar_enUS_indexed_string:assigneeKey">Find the entity assigneeKey in Solr</a>
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
		this.assigneeKey = ReportEvent.staticSetAssigneeKey(siteRequest_, o);
	}
	public static Long staticSetAssigneeKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ReportEvent assigneeKeyInit() {
		Wrap<Long> assigneeKeyWrap = new Wrap<Long>().var("assigneeKey");
		if(assigneeKey == null) {
			_assigneeKey(assigneeKeyWrap);
			setAssigneeKey(assigneeKeyWrap.o);
		}
		return (ReportEvent)this;
	}

	public static Long staticSearchAssigneeKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrAssigneeKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAssigneeKey(SiteRequestEnUS siteRequest_, String o) {
		return ReportEvent.staticSearchStrAssigneeKey(siteRequest_, ReportEvent.staticSearchAssigneeKey(siteRequest_, ReportEvent.staticSetAssigneeKey(siteRequest_, o)));
	}

	public Long sqlAssigneeKey() {
		return assigneeKey;
	}

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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEvent&fq=entiteVar_enUS_indexed_string:eventName">Find the entity eventName in Solr</a>
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

	///////////////
	// eventDate //
	///////////////

	/**	 The entity eventDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateLocalDateDeserializer.class)
	@JsonSerialize(using = ComputateLocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonInclude(Include.NON_NULL)
	protected LocalDate eventDate;

	/**	<br> The entity eventDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEvent&fq=entiteVar_enUS_indexed_string:eventDate">Find the entity eventDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _eventDate(Wrap<LocalDate> w);

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	@JsonIgnore
	public void setEventDate(Instant o) {
		this.eventDate = o == null ? null : LocalDate.from(o);
	}
	/** Example: 2011-12-03+01:00 **/
	@JsonIgnore
	public void setEventDate(String o) {
		this.eventDate = ReportEvent.staticSetEventDate(siteRequest_, o);
	}
	public static LocalDate staticSetEventDate(SiteRequestEnUS siteRequest_, String o) {
		if(o != null) {
			if(o.contains("T")) {
				return java.time.LocalDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toLocalDate();
			} else {
				return LocalDate.parse(o, DateTimeFormatter.ISO_DATE);
			}
		}
		return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE);
	}
	@JsonIgnore
	public void setEventDate(Date o) {
		this.eventDate = o == null ? null : o.toInstant().atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toLocalDate();
	}
	protected ReportEvent eventDateInit() {
		Wrap<LocalDate> eventDateWrap = new Wrap<LocalDate>().var("eventDate");
		if(eventDate == null) {
			_eventDate(eventDateWrap);
			setEventDate(eventDateWrap.o);
		}
		return (ReportEvent)this;
	}

	public static Date staticSearchEventDate(SiteRequestEnUS siteRequest_, LocalDate o) {
		return o == null ? null : Date.from(o.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z")).toInstant());
	}

	public static String staticSearchStrEventDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqEventDate(SiteRequestEnUS siteRequest_, String o) {
		return ReportEvent.staticSearchStrEventDate(siteRequest_, ReportEvent.staticSearchEventDate(siteRequest_, ReportEvent.staticSetEventDate(siteRequest_, o)));
	}

	public LocalDate sqlEventDate() {
		return eventDate;
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
				scheduleKeyInit();
				assigneeKeyInit();
				eventNameInit();
				eventDateInit();
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
			case "scheduleKey":
				return oReportEvent.scheduleKey;
			case "assigneeKey":
				return oReportEvent.assigneeKey;
			case "eventName":
				return oReportEvent.eventName;
			case "eventDate":
				return oReportEvent.eventDate;
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
			case "scheduleKey":
				if(oReportEvent.getScheduleKey() == null)
					oReportEvent.setScheduleKey(val == null ? null : (NumberUtils.isCreatable(val.toString()) ? Long.parseLong(val.toString()) : -1));
				if(!saves.contains("scheduleKey"))
					saves.add("scheduleKey");
				return val;
			case "assigneeKey":
				if(oReportEvent.getAssigneeKey() == null)
					oReportEvent.setAssigneeKey(val == null ? null : (NumberUtils.isCreatable(val.toString()) ? Long.parseLong(val.toString()) : -1));
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
		return staticSetReportEvent(entityVar,  siteRequest_, o);
	}
	public static Object staticSetReportEvent(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "scheduleKey":
			return ReportEvent.staticSetScheduleKey(siteRequest_, o);
		case "assigneeKey":
			return ReportEvent.staticSetAssigneeKey(siteRequest_, o);
		case "eventName":
			return ReportEvent.staticSetEventName(siteRequest_, o);
		case "eventDate":
			return ReportEvent.staticSetEventDate(siteRequest_, o);
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
		case "scheduleKey":
			return ReportEvent.staticSearchScheduleKey(siteRequest_, (Long)o);
		case "assigneeKey":
			return ReportEvent.staticSearchAssigneeKey(siteRequest_, (Long)o);
		case "eventName":
			return ReportEvent.staticSearchEventName(siteRequest_, (String)o);
		case "eventDate":
			return ReportEvent.staticSearchEventDate(siteRequest_, (LocalDate)o);
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
		case "scheduleKey":
			return ReportEvent.staticSearchStrScheduleKey(siteRequest_, (Long)o);
		case "assigneeKey":
			return ReportEvent.staticSearchStrAssigneeKey(siteRequest_, (Long)o);
		case "eventName":
			return ReportEvent.staticSearchStrEventName(siteRequest_, (String)o);
		case "eventDate":
			return ReportEvent.staticSearchStrEventDate(siteRequest_, (Date)o);
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
		case "scheduleKey":
			return ReportEvent.staticSearchFqScheduleKey(siteRequest_, o);
		case "assigneeKey":
			return ReportEvent.staticSearchFqAssigneeKey(siteRequest_, o);
		case "eventName":
			return ReportEvent.staticSearchFqEventName(siteRequest_, o);
		case "eventDate":
			return ReportEvent.staticSearchFqEventDate(siteRequest_, o);
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
					o = persistReportEvent(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistReportEvent(String var, Object val) {
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
			case "eventname":
				if(val instanceof String)
					setEventName((String)val);
				saves.add("eventName");
				return val;
			case "eventdate":
				if(val instanceof LocalDate)
					setEventDate((LocalDate)val);
				else if(val instanceof String)
					setEventDate((String)val);
				saves.add("eventDate");
				return val;
			default:
				return super.persistBaseModel(var, val);
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
		if(scheduleKey != null) {
			doc.put("scheduleKey_docvalues_long", scheduleKey);
		}
		if(assigneeKey != null) {
			doc.put("assigneeKey_docvalues_long", assigneeKey);
		}
		if(eventName != null) {
			doc.put("eventName_docvalues_string", eventName);
		}
		if(eventDate != null) {
			doc.put("eventDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(eventDate.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z"))));
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredReportEvent(String entityVar) {
		switch(entityVar) {
			case "scheduleKey":
				return "scheduleKey_docvalues_long";
			case "assigneeKey":
				return "assigneeKey_docvalues_long";
			case "eventName":
				return "eventName_docvalues_string";
			case "eventDate":
				return "eventDate_docvalues_date";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedReportEvent(String entityVar) {
		switch(entityVar) {
			case "scheduleKey":
				return "scheduleKey_docvalues_long";
			case "assigneeKey":
				return "assigneeKey_docvalues_long";
			case "eventName":
				return "eventName_docvalues_string";
			case "eventDate":
				return "eventDate_docvalues_date";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarReportEvent(String searchVar) {
		switch(searchVar) {
			case "scheduleKey_docvalues_long":
				return "scheduleKey";
			case "assigneeKey_docvalues_long":
				return "assigneeKey";
			case "eventName_docvalues_string":
				return "eventName";
			case "eventDate_docvalues_date":
				return "eventDate";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
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

		oReportEvent.setScheduleKey(Optional.ofNullable(doc.get("scheduleKey_docvalues_long")).map(v -> v.toString()).orElse(null));
		oReportEvent.setAssigneeKey(Optional.ofNullable(doc.get("assigneeKey_docvalues_long")).map(v -> v.toString()).orElse(null));
		oReportEvent.setEventName(Optional.ofNullable(doc.get("eventName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oReportEvent.setEventDate(Optional.ofNullable(doc.get("eventDate_docvalues_date")).map(v -> v.toString()).orElse(null));

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
			if(!Objects.equals(scheduleKey, original.getScheduleKey()))
				apiRequest.addVars("scheduleKey");
			if(!Objects.equals(assigneeKey, original.getAssigneeKey()))
				apiRequest.addVars("assigneeKey");
			if(!Objects.equals(eventName, original.getEventName()))
				apiRequest.addVars("eventName");
			if(!Objects.equals(eventDate, original.getEventDate()))
				apiRequest.addVars("eventDate");
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
		sb.append(Optional.ofNullable(eventName).map(v -> "eventName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(eventDate).map(v -> "eventDate: " + v + "\n").orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "ReportEvent";
	public static final String VAR_scheduleKey = "scheduleKey";
	public static final String VAR_assigneeKey = "assigneeKey";
	public static final String VAR_eventName = "eventName";
	public static final String VAR_eventDate = "eventDate";

	public static List<String> varsQForClass() {
		return ReportEvent.varsQReportEvent(new ArrayList<String>());
	}
	public static List<String> varsQReportEvent(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return ReportEvent.varsFqReportEvent(new ArrayList<String>());
	}
	public static List<String> varsFqReportEvent(List<String> vars) {
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return ReportEvent.varsRangeReportEvent(new ArrayList<String>());
	}
	public static List<String> varsRangeReportEvent(List<String> vars) {
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_scheduleKey = "schedule";
	public static final String DISPLAY_NAME_assigneeKey = "assignee";
	public static final String DISPLAY_NAME_eventName = "event name";
	public static final String DISPLAY_NAME_eventDate = "event date";

	public static String displayNameForClass(String var) {
		return ReportEvent.displayNameReportEvent(var);
	}
	public static String displayNameReportEvent(String var) {
		switch(var) {
		case VAR_scheduleKey:
			return DISPLAY_NAME_scheduleKey;
		case VAR_assigneeKey:
			return DISPLAY_NAME_assigneeKey;
		case VAR_eventName:
			return DISPLAY_NAME_eventName;
		case VAR_eventDate:
			return DISPLAY_NAME_eventDate;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionReportEvent(String var) {
		switch(var) {
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameReportEvent(String var) {
		switch(var) {
		case VAR_scheduleKey:
			return "Long";
		case VAR_assigneeKey:
			return "Long";
		case VAR_eventName:
			return "String";
		case VAR_eventDate:
			return "LocalDate";
			default:
				return BaseModel.classSimpleNameBaseModel(var);
		}
	}

	public static Integer htmlColumnReportEvent(String var) {
		switch(var) {
			default:
				return BaseModel.htmlColumnBaseModel(var);
		}
	}

	public static Integer htmlRowReportEvent(String var) {
		switch(var) {
		case VAR_scheduleKey:
			return 3;
		case VAR_assigneeKey:
			return 3;
		case VAR_eventName:
			return 3;
		case VAR_eventDate:
			return 4;
			default:
				return BaseModel.htmlRowBaseModel(var);
		}
	}

	public static Integer htmlCellReportEvent(String var) {
		switch(var) {
		case VAR_scheduleKey:
			return 1;
		case VAR_assigneeKey:
			return 2;
		case VAR_eventName:
			return 3;
		case VAR_eventDate:
			return 1;
			default:
				return BaseModel.htmlCellBaseModel(var);
		}
	}

	public static Integer lengthMinReportEvent(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxReportEvent(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxReportEvent(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minReportEvent(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
