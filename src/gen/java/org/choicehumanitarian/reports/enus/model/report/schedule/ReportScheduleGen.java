package org.choicehumanitarian.reports.enus.model.report.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import org.computate.search.response.solr.SolrResponse;
import java.lang.Long;
import org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative;
import java.util.Locale;
import java.util.Map;
import io.vertx.core.json.JsonObject;
import java.time.ZoneOffset;
import java.math.RoundingMode;
import java.math.MathContext;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import io.vertx.core.Future;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import java.time.ZoneId;
import org.choicehumanitarian.reports.enus.base.BaseModel;
import java.util.Objects;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.vertx.search.list.SearchList;
import java.util.List;
import org.computate.search.wrap.Wrap;
import java.time.LocalDate;
import java.util.Optional;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.exception.ExceptionUtils;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.HashMap;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import org.choicehumanitarian.reports.enus.model.report.type.ReportType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Boolean;
import java.lang.String;
import org.slf4j.Logger;
import io.vertx.core.Promise;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.vertx.core.json.JsonArray;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.math.NumberUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.choicehumanitarian.reports.enus.model.report.event.ReportEvent;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ReportScheduleGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(ReportSchedule.class);

	public static final String ReportSchedule_AName = "a report schedule";
	public static final String ReportSchedule_This = "this ";
	public static final String ReportSchedule_ThisName = "this report schedule";
	public static final String ReportSchedule_A = "a ";
	public static final String ReportSchedule_TheName = "the report schedule";
	public static final String ReportSchedule_NameSingular = "report schedule";
	public static final String ReportSchedule_NamePlural = "report schedules";
	public static final String ReportSchedule_NameActual = "current report schedule";
	public static final String ReportSchedule_AllName = "all the report schedules";
	public static final String ReportSchedule_SearchAllNameBy = "search report schedules by ";
	public static final String ReportSchedule_Title = "report schedules";
	public static final String ReportSchedule_ThePluralName = "the report schedules";
	public static final String ReportSchedule_NoNameFound = "no report schedule found";
	public static final String ReportSchedule_NameVar = "reportSchedule";
	public static final String ReportSchedule_OfName = "of report schedule";
	public static final String ReportSchedule_ANameAdjective = "a report schedule";
	public static final String ReportSchedule_NameAdjectiveSingular = "report schedule";
	public static final String ReportSchedule_NameAdjectivePlural = "report schedules";
	public static final String ReportSchedule_Color = "light-green";
	public static final String ReportSchedule_IconGroup = "duotone";
	public static final String ReportSchedule_IconName = "calendar-days";
	public static final Integer ReportSchedule_Rows = 100;

	/////////////
	// typeKey //
	/////////////

	/**	 The entity typeKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long typeKey;

	/**	<br> The entity typeKey
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:typeKey">Find the entity typeKey in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _typeKey(Wrap<Long> w);

	public Long getTypeKey() {
		return typeKey;
	}

	public void setTypeKey(Long typeKey) {
		this.typeKey = typeKey;
	}
	@JsonIgnore
	public void setTypeKey(String o) {
		this.typeKey = ReportSchedule.staticSetTypeKey(siteRequest_, o);
	}
	public static Long staticSetTypeKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ReportSchedule typeKeyInit() {
		Wrap<Long> typeKeyWrap = new Wrap<Long>().var("typeKey");
		if(typeKey == null) {
			_typeKey(typeKeyWrap);
			setTypeKey(typeKeyWrap.o);
		}
		return (ReportSchedule)this;
	}

	public static Long staticSearchTypeKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrTypeKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTypeKey(SiteRequestEnUS siteRequest_, String o) {
		return ReportSchedule.staticSearchStrTypeKey(siteRequest_, ReportSchedule.staticSearchTypeKey(siteRequest_, ReportSchedule.staticSetTypeKey(siteRequest_, o)));
	}

	public Long sqlTypeKey() {
		return typeKey;
	}

	///////////////////
	// narrativeKeys //
	///////////////////

	/**	 The entity narrativeKeys
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonSerialize(contentUsing = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Long> narrativeKeys = new ArrayList<Long>();

	/**	<br> The entity narrativeKeys
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:narrativeKeys">Find the entity narrativeKeys in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _narrativeKeys(List<Long> l);

	public List<Long> getNarrativeKeys() {
		return narrativeKeys;
	}

	public void setNarrativeKeys(List<Long> narrativeKeys) {
		this.narrativeKeys = narrativeKeys;
	}
	@JsonIgnore
	public void setNarrativeKeys(String o) {
		Long l = ReportSchedule.staticSetNarrativeKeys(siteRequest_, o);
		if(l != null)
			addNarrativeKeys(l);
	}
	public static Long staticSetNarrativeKeys(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public ReportSchedule addNarrativeKeys(Long...objets) {
		for(Long o : objets) {
			addNarrativeKeys(o);
		}
		return (ReportSchedule)this;
	}
	public ReportSchedule addNarrativeKeys(Long o) {
		if(o != null)
			this.narrativeKeys.add(o);
		return (ReportSchedule)this;
	}
	@JsonIgnore
	public void setNarrativeKeys(JsonArray objets) {
		narrativeKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addNarrativeKeys(o);
		}
	}
	public ReportSchedule addNarrativeKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addNarrativeKeys(p);
		}
		return (ReportSchedule)this;
	}
	protected ReportSchedule narrativeKeysInit() {
		_narrativeKeys(narrativeKeys);
		return (ReportSchedule)this;
	}

	public static Long staticSearchNarrativeKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrNarrativeKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqNarrativeKeys(SiteRequestEnUS siteRequest_, String o) {
		return ReportSchedule.staticSearchStrNarrativeKeys(siteRequest_, ReportSchedule.staticSearchNarrativeKeys(siteRequest_, ReportSchedule.staticSetNarrativeKeys(siteRequest_, o)));
	}

	public List<Long> sqlNarrativeKeys() {
		return narrativeKeys;
	}

	///////////////
	// eventKeys //
	///////////////

	/**	 The entity eventKeys
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonSerialize(contentUsing = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Long> eventKeys = new ArrayList<Long>();

	/**	<br> The entity eventKeys
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:eventKeys">Find the entity eventKeys in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _eventKeys(List<Long> l);

	public List<Long> getEventKeys() {
		return eventKeys;
	}

	public void setEventKeys(List<Long> eventKeys) {
		this.eventKeys = eventKeys;
	}
	@JsonIgnore
	public void setEventKeys(String o) {
		Long l = ReportSchedule.staticSetEventKeys(siteRequest_, o);
		if(l != null)
			addEventKeys(l);
	}
	public static Long staticSetEventKeys(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public ReportSchedule addEventKeys(Long...objets) {
		for(Long o : objets) {
			addEventKeys(o);
		}
		return (ReportSchedule)this;
	}
	public ReportSchedule addEventKeys(Long o) {
		if(o != null)
			this.eventKeys.add(o);
		return (ReportSchedule)this;
	}
	@JsonIgnore
	public void setEventKeys(JsonArray objets) {
		eventKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addEventKeys(o);
		}
	}
	public ReportSchedule addEventKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addEventKeys(p);
		}
		return (ReportSchedule)this;
	}
	protected ReportSchedule eventKeysInit() {
		_eventKeys(eventKeys);
		return (ReportSchedule)this;
	}

	public static Long staticSearchEventKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrEventKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqEventKeys(SiteRequestEnUS siteRequest_, String o) {
		return ReportSchedule.staticSearchStrEventKeys(siteRequest_, ReportSchedule.staticSearchEventKeys(siteRequest_, ReportSchedule.staticSetEventKeys(siteRequest_, o)));
	}

	public List<Long> sqlEventKeys() {
		return eventKeys;
	}

	////////////////
	// typeSearch //
	////////////////

	/**	 The entity typeSearch
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ReportType> typeSearch;

	/**	<br> The entity typeSearch
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:typeSearch">Find the entity typeSearch in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _typeSearch(Promise<SearchList<ReportType>> promise);

	public SearchList<ReportType> getTypeSearch() {
		return typeSearch;
	}

	public void setTypeSearch(SearchList<ReportType> typeSearch) {
		this.typeSearch = typeSearch;
	}
	public static SearchList<ReportType> staticSetTypeSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<SearchList<ReportType>> typeSearchPromise() {
		Promise<SearchList<ReportType>> promise = Promise.promise();
		Promise<SearchList<ReportType>> promise2 = Promise.promise();
		_typeSearch(promise2);
		promise2.future().onSuccess(o -> {
			if(o != null && typeSearch == null) {
				o.promiseDeepForClass(siteRequest_).onSuccess(a -> {
					setTypeSearch(o);
					promise.complete(o);
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			} else {
				promise.complete(o);
			}
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	///////////
	// type_ //
	///////////

	/**	 The entity type_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ReportType type_;

	/**	<br> The entity type_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:type_">Find the entity type_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _type_(Wrap<ReportType> w);

	public ReportType getType_() {
		return type_;
	}

	public void setType_(ReportType type_) {
		this.type_ = type_;
	}
	public static ReportType staticSetType_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportSchedule type_Init() {
		Wrap<ReportType> type_Wrap = new Wrap<ReportType>().var("type_");
		if(type_ == null) {
			_type_(type_Wrap);
			setType_(type_Wrap.o);
		}
		return (ReportSchedule)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:typeName">Find the entity typeName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _typeName(Wrap<String> w);

	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String o) {
		this.typeName = ReportSchedule.staticSetTypeName(siteRequest_, o);
	}
	public static String staticSetTypeName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ReportSchedule typeNameInit() {
		Wrap<String> typeNameWrap = new Wrap<String>().var("typeName");
		if(typeName == null) {
			_typeName(typeNameWrap);
			setTypeName(typeNameWrap.o);
		}
		return (ReportSchedule)this;
	}

	public static String staticSearchTypeName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrTypeName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTypeName(SiteRequestEnUS siteRequest_, String o) {
		return ReportSchedule.staticSearchStrTypeName(siteRequest_, ReportSchedule.staticSearchTypeName(siteRequest_, ReportSchedule.staticSetTypeName(siteRequest_, o)));
	}

	//////////////////
	// scheduleName //
	//////////////////

	/**	 The entity scheduleName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String scheduleName;

	/**	<br> The entity scheduleName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:scheduleName">Find the entity scheduleName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _scheduleName(Wrap<String> w);

	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String o) {
		this.scheduleName = ReportSchedule.staticSetScheduleName(siteRequest_, o);
	}
	public static String staticSetScheduleName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ReportSchedule scheduleNameInit() {
		Wrap<String> scheduleNameWrap = new Wrap<String>().var("scheduleName");
		if(scheduleName == null) {
			_scheduleName(scheduleNameWrap);
			setScheduleName(scheduleNameWrap.o);
		}
		return (ReportSchedule)this;
	}

	public static String staticSearchScheduleName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrScheduleName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqScheduleName(SiteRequestEnUS siteRequest_, String o) {
		return ReportSchedule.staticSearchStrScheduleName(siteRequest_, ReportSchedule.staticSearchScheduleName(siteRequest_, ReportSchedule.staticSetScheduleName(siteRequest_, o)));
	}

	public String sqlScheduleName() {
		return scheduleName;
	}

	//////////////////////
	// frequencyOneTime //
	//////////////////////

	/**	 The entity frequencyOneTime
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean frequencyOneTime;

	/**	<br> The entity frequencyOneTime
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:frequencyOneTime">Find the entity frequencyOneTime in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _frequencyOneTime(Wrap<Boolean> w);

	public Boolean getFrequencyOneTime() {
		return frequencyOneTime;
	}

	public void setFrequencyOneTime(Boolean frequencyOneTime) {
		this.frequencyOneTime = frequencyOneTime;
	}
	@JsonIgnore
	public void setFrequencyOneTime(String o) {
		this.frequencyOneTime = ReportSchedule.staticSetFrequencyOneTime(siteRequest_, o);
	}
	public static Boolean staticSetFrequencyOneTime(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ReportSchedule frequencyOneTimeInit() {
		Wrap<Boolean> frequencyOneTimeWrap = new Wrap<Boolean>().var("frequencyOneTime");
		if(frequencyOneTime == null) {
			_frequencyOneTime(frequencyOneTimeWrap);
			setFrequencyOneTime(frequencyOneTimeWrap.o);
		}
		return (ReportSchedule)this;
	}

	public static Boolean staticSearchFrequencyOneTime(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrFrequencyOneTime(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqFrequencyOneTime(SiteRequestEnUS siteRequest_, String o) {
		return ReportSchedule.staticSearchStrFrequencyOneTime(siteRequest_, ReportSchedule.staticSearchFrequencyOneTime(siteRequest_, ReportSchedule.staticSetFrequencyOneTime(siteRequest_, o)));
	}

	public Boolean sqlFrequencyOneTime() {
		return frequencyOneTime;
	}

	///////////////////////////
	// frequencyTimesPerYear //
	///////////////////////////

	/**	 The entity frequencyTimesPerYear
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer frequencyTimesPerYear;

	/**	<br> The entity frequencyTimesPerYear
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:frequencyTimesPerYear">Find the entity frequencyTimesPerYear in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _frequencyTimesPerYear(Wrap<Integer> w);

	public Integer getFrequencyTimesPerYear() {
		return frequencyTimesPerYear;
	}

	public void setFrequencyTimesPerYear(Integer frequencyTimesPerYear) {
		this.frequencyTimesPerYear = frequencyTimesPerYear;
	}
	@JsonIgnore
	public void setFrequencyTimesPerYear(String o) {
		this.frequencyTimesPerYear = ReportSchedule.staticSetFrequencyTimesPerYear(siteRequest_, o);
	}
	public static Integer staticSetFrequencyTimesPerYear(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ReportSchedule frequencyTimesPerYearInit() {
		Wrap<Integer> frequencyTimesPerYearWrap = new Wrap<Integer>().var("frequencyTimesPerYear");
		if(frequencyTimesPerYear == null) {
			_frequencyTimesPerYear(frequencyTimesPerYearWrap);
			setFrequencyTimesPerYear(frequencyTimesPerYearWrap.o);
		}
		return (ReportSchedule)this;
	}

	public static Integer staticSearchFrequencyTimesPerYear(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrFrequencyTimesPerYear(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqFrequencyTimesPerYear(SiteRequestEnUS siteRequest_, String o) {
		return ReportSchedule.staticSearchStrFrequencyTimesPerYear(siteRequest_, ReportSchedule.staticSearchFrequencyTimesPerYear(siteRequest_, ReportSchedule.staticSetFrequencyTimesPerYear(siteRequest_, o)));
	}

	public Integer sqlFrequencyTimesPerYear() {
		return frequencyTimesPerYear;
	}

	///////////////////////////////////
	// frequencyYearsAfterCompletion //
	///////////////////////////////////

	/**	 The entity frequencyYearsAfterCompletion
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer frequencyYearsAfterCompletion;

	/**	<br> The entity frequencyYearsAfterCompletion
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:frequencyYearsAfterCompletion">Find the entity frequencyYearsAfterCompletion in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _frequencyYearsAfterCompletion(Wrap<Integer> w);

	public Integer getFrequencyYearsAfterCompletion() {
		return frequencyYearsAfterCompletion;
	}

	public void setFrequencyYearsAfterCompletion(Integer frequencyYearsAfterCompletion) {
		this.frequencyYearsAfterCompletion = frequencyYearsAfterCompletion;
	}
	@JsonIgnore
	public void setFrequencyYearsAfterCompletion(String o) {
		this.frequencyYearsAfterCompletion = ReportSchedule.staticSetFrequencyYearsAfterCompletion(siteRequest_, o);
	}
	public static Integer staticSetFrequencyYearsAfterCompletion(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ReportSchedule frequencyYearsAfterCompletionInit() {
		Wrap<Integer> frequencyYearsAfterCompletionWrap = new Wrap<Integer>().var("frequencyYearsAfterCompletion");
		if(frequencyYearsAfterCompletion == null) {
			_frequencyYearsAfterCompletion(frequencyYearsAfterCompletionWrap);
			setFrequencyYearsAfterCompletion(frequencyYearsAfterCompletionWrap.o);
		}
		return (ReportSchedule)this;
	}

	public static Integer staticSearchFrequencyYearsAfterCompletion(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrFrequencyYearsAfterCompletion(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqFrequencyYearsAfterCompletion(SiteRequestEnUS siteRequest_, String o) {
		return ReportSchedule.staticSearchStrFrequencyYearsAfterCompletion(siteRequest_, ReportSchedule.staticSearchFrequencyYearsAfterCompletion(siteRequest_, ReportSchedule.staticSetFrequencyYearsAfterCompletion(siteRequest_, o)));
	}

	public Integer sqlFrequencyYearsAfterCompletion() {
		return frequencyYearsAfterCompletion;
	}

	//////////////////
	// firstDueDate //
	//////////////////

	/**	 The entity firstDueDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateLocalDateDeserializer.class)
	@JsonSerialize(using = ComputateLocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonInclude(Include.NON_NULL)
	protected LocalDate firstDueDate;

	/**	<br> The entity firstDueDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:firstDueDate">Find the entity firstDueDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _firstDueDate(Wrap<LocalDate> w);

	public LocalDate getFirstDueDate() {
		return firstDueDate;
	}

	public void setFirstDueDate(LocalDate firstDueDate) {
		this.firstDueDate = firstDueDate;
	}
	@JsonIgnore
	public void setFirstDueDate(Instant o) {
		this.firstDueDate = o == null ? null : LocalDate.from(o);
	}
	/** Example: 2011-12-03+01:00 **/
	@JsonIgnore
	public void setFirstDueDate(String o) {
		this.firstDueDate = ReportSchedule.staticSetFirstDueDate(siteRequest_, o);
	}
	public static LocalDate staticSetFirstDueDate(SiteRequestEnUS siteRequest_, String o) {
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
	public void setFirstDueDate(Date o) {
		this.firstDueDate = o == null ? null : o.toInstant().atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toLocalDate();
	}
	protected ReportSchedule firstDueDateInit() {
		Wrap<LocalDate> firstDueDateWrap = new Wrap<LocalDate>().var("firstDueDate");
		if(firstDueDate == null) {
			_firstDueDate(firstDueDateWrap);
			setFirstDueDate(firstDueDateWrap.o);
		}
		return (ReportSchedule)this;
	}

	public static Date staticSearchFirstDueDate(SiteRequestEnUS siteRequest_, LocalDate o) {
		return o == null ? null : Date.from(o.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z")).toInstant());
	}

	public static String staticSearchStrFirstDueDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqFirstDueDate(SiteRequestEnUS siteRequest_, String o) {
		return ReportSchedule.staticSearchStrFirstDueDate(siteRequest_, ReportSchedule.staticSearchFirstDueDate(siteRequest_, ReportSchedule.staticSetFirstDueDate(siteRequest_, o)));
	}

	public LocalDate sqlFirstDueDate() {
		return firstDueDate;
	}

	//////////////////
	// dataPullDate //
	//////////////////

	/**	 The entity dataPullDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateLocalDateDeserializer.class)
	@JsonSerialize(using = ComputateLocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonInclude(Include.NON_NULL)
	protected LocalDate dataPullDate;

	/**	<br> The entity dataPullDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:dataPullDate">Find the entity dataPullDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dataPullDate(Wrap<LocalDate> w);

	public LocalDate getDataPullDate() {
		return dataPullDate;
	}

	public void setDataPullDate(LocalDate dataPullDate) {
		this.dataPullDate = dataPullDate;
	}
	@JsonIgnore
	public void setDataPullDate(Instant o) {
		this.dataPullDate = o == null ? null : LocalDate.from(o);
	}
	/** Example: 2011-12-03+01:00 **/
	@JsonIgnore
	public void setDataPullDate(String o) {
		this.dataPullDate = ReportSchedule.staticSetDataPullDate(siteRequest_, o);
	}
	public static LocalDate staticSetDataPullDate(SiteRequestEnUS siteRequest_, String o) {
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
	public void setDataPullDate(Date o) {
		this.dataPullDate = o == null ? null : o.toInstant().atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toLocalDate();
	}
	protected ReportSchedule dataPullDateInit() {
		Wrap<LocalDate> dataPullDateWrap = new Wrap<LocalDate>().var("dataPullDate");
		if(dataPullDate == null) {
			_dataPullDate(dataPullDateWrap);
			setDataPullDate(dataPullDateWrap.o);
		}
		return (ReportSchedule)this;
	}

	public static Date staticSearchDataPullDate(SiteRequestEnUS siteRequest_, LocalDate o) {
		return o == null ? null : Date.from(o.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z")).toInstant());
	}

	public static String staticSearchStrDataPullDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqDataPullDate(SiteRequestEnUS siteRequest_, String o) {
		return ReportSchedule.staticSearchStrDataPullDate(siteRequest_, ReportSchedule.staticSearchDataPullDate(siteRequest_, ReportSchedule.staticSetDataPullDate(siteRequest_, o)));
	}

	public LocalDate sqlDataPullDate() {
		return dataPullDate;
	}

	/////////////////
	// dataSources //
	/////////////////

	/**	 The entity dataSources
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String dataSources;

	/**	<br> The entity dataSources
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:dataSources">Find the entity dataSources in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _dataSources(Wrap<String> w);

	public String getDataSources() {
		return dataSources;
	}
	public void setDataSources(String o) {
		this.dataSources = ReportSchedule.staticSetDataSources(siteRequest_, o);
	}
	public static String staticSetDataSources(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ReportSchedule dataSourcesInit() {
		Wrap<String> dataSourcesWrap = new Wrap<String>().var("dataSources");
		if(dataSources == null) {
			_dataSources(dataSourcesWrap);
			setDataSources(dataSourcesWrap.o);
		}
		return (ReportSchedule)this;
	}

	public static String staticSearchDataSources(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDataSources(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDataSources(SiteRequestEnUS siteRequest_, String o) {
		return ReportSchedule.staticSearchStrDataSources(siteRequest_, ReportSchedule.staticSearchDataSources(siteRequest_, ReportSchedule.staticSetDataSources(siteRequest_, o)));
	}

	public String sqlDataSources() {
		return dataSources;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepReportSchedule(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepReportSchedule();
	}

	public Future<Void> promiseDeepReportSchedule() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseReportSchedule(promise2);
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

	public Future<Void> promiseReportSchedule(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				typeKeyInit();
				narrativeKeysInit();
				eventKeysInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			typeSearchPromise().onSuccess(typeSearch -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				type_Init();
				typeNameInit();
				scheduleNameInit();
				frequencyOneTimeInit();
				frequencyTimesPerYearInit();
				frequencyYearsAfterCompletionInit();
				firstDueDateInit();
				dataPullDateInit();
				dataSourcesInit();
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
		return promiseDeepReportSchedule(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportSchedule(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
		if(typeSearch != null)
			typeSearch.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestReportSchedule(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainReportSchedule(v);
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
	public Object obtainReportSchedule(String var) {
		ReportSchedule oReportSchedule = (ReportSchedule)this;
		switch(var) {
			case "typeKey":
				return oReportSchedule.typeKey;
			case "narrativeKeys":
				return oReportSchedule.narrativeKeys;
			case "eventKeys":
				return oReportSchedule.eventKeys;
			case "typeSearch":
				return oReportSchedule.typeSearch;
			case "type_":
				return oReportSchedule.type_;
			case "typeName":
				return oReportSchedule.typeName;
			case "scheduleName":
				return oReportSchedule.scheduleName;
			case "frequencyOneTime":
				return oReportSchedule.frequencyOneTime;
			case "frequencyTimesPerYear":
				return oReportSchedule.frequencyTimesPerYear;
			case "frequencyYearsAfterCompletion":
				return oReportSchedule.frequencyYearsAfterCompletion;
			case "firstDueDate":
				return oReportSchedule.firstDueDate;
			case "dataPullDate":
				return oReportSchedule.dataPullDate;
			case "dataSources":
				return oReportSchedule.dataSources;
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
				o = relateReportSchedule(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateReportSchedule(String var, Object val) {
		ReportSchedule oReportSchedule = (ReportSchedule)this;
		switch(var) {
			case "typeKey":
				if(oReportSchedule.getTypeKey() == null)
					oReportSchedule.setTypeKey(val == null ? null : (NumberUtils.isCreatable(val.toString()) ? Long.parseLong(val.toString()) : null));
				if(!saves.contains("typeKey"))
					saves.add("typeKey");
				return val;
			case "narrativeKeys":
				oReportSchedule.addNarrativeKeys((Long)val);
				if(!saves.contains("narrativeKeys"))
					saves.add("narrativeKeys");
				return val;
			case "eventKeys":
				oReportSchedule.addEventKeys((Long)val);
				if(!saves.contains("eventKeys"))
					saves.add("eventKeys");
				return val;
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetReportSchedule(entityVar,  siteRequest_, o);
	}
	public static Object staticSetReportSchedule(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "typeKey":
			return ReportSchedule.staticSetTypeKey(siteRequest_, o);
		case "narrativeKeys":
			return ReportSchedule.staticSetNarrativeKeys(siteRequest_, o);
		case "eventKeys":
			return ReportSchedule.staticSetEventKeys(siteRequest_, o);
		case "typeName":
			return ReportSchedule.staticSetTypeName(siteRequest_, o);
		case "scheduleName":
			return ReportSchedule.staticSetScheduleName(siteRequest_, o);
		case "frequencyOneTime":
			return ReportSchedule.staticSetFrequencyOneTime(siteRequest_, o);
		case "frequencyTimesPerYear":
			return ReportSchedule.staticSetFrequencyTimesPerYear(siteRequest_, o);
		case "frequencyYearsAfterCompletion":
			return ReportSchedule.staticSetFrequencyYearsAfterCompletion(siteRequest_, o);
		case "firstDueDate":
			return ReportSchedule.staticSetFirstDueDate(siteRequest_, o);
		case "dataPullDate":
			return ReportSchedule.staticSetDataPullDate(siteRequest_, o);
		case "dataSources":
			return ReportSchedule.staticSetDataSources(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchReportSchedule(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchReportSchedule(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "typeKey":
			return ReportSchedule.staticSearchTypeKey(siteRequest_, (Long)o);
		case "narrativeKeys":
			return ReportSchedule.staticSearchNarrativeKeys(siteRequest_, (Long)o);
		case "eventKeys":
			return ReportSchedule.staticSearchEventKeys(siteRequest_, (Long)o);
		case "typeName":
			return ReportSchedule.staticSearchTypeName(siteRequest_, (String)o);
		case "scheduleName":
			return ReportSchedule.staticSearchScheduleName(siteRequest_, (String)o);
		case "frequencyOneTime":
			return ReportSchedule.staticSearchFrequencyOneTime(siteRequest_, (Boolean)o);
		case "frequencyTimesPerYear":
			return ReportSchedule.staticSearchFrequencyTimesPerYear(siteRequest_, (Integer)o);
		case "frequencyYearsAfterCompletion":
			return ReportSchedule.staticSearchFrequencyYearsAfterCompletion(siteRequest_, (Integer)o);
		case "firstDueDate":
			return ReportSchedule.staticSearchFirstDueDate(siteRequest_, (LocalDate)o);
		case "dataPullDate":
			return ReportSchedule.staticSearchDataPullDate(siteRequest_, (LocalDate)o);
		case "dataSources":
			return ReportSchedule.staticSearchDataSources(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrReportSchedule(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrReportSchedule(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "typeKey":
			return ReportSchedule.staticSearchStrTypeKey(siteRequest_, (Long)o);
		case "narrativeKeys":
			return ReportSchedule.staticSearchStrNarrativeKeys(siteRequest_, (Long)o);
		case "eventKeys":
			return ReportSchedule.staticSearchStrEventKeys(siteRequest_, (Long)o);
		case "typeName":
			return ReportSchedule.staticSearchStrTypeName(siteRequest_, (String)o);
		case "scheduleName":
			return ReportSchedule.staticSearchStrScheduleName(siteRequest_, (String)o);
		case "frequencyOneTime":
			return ReportSchedule.staticSearchStrFrequencyOneTime(siteRequest_, (Boolean)o);
		case "frequencyTimesPerYear":
			return ReportSchedule.staticSearchStrFrequencyTimesPerYear(siteRequest_, (Integer)o);
		case "frequencyYearsAfterCompletion":
			return ReportSchedule.staticSearchStrFrequencyYearsAfterCompletion(siteRequest_, (Integer)o);
		case "firstDueDate":
			return ReportSchedule.staticSearchStrFirstDueDate(siteRequest_, (Date)o);
		case "dataPullDate":
			return ReportSchedule.staticSearchStrDataPullDate(siteRequest_, (Date)o);
		case "dataSources":
			return ReportSchedule.staticSearchStrDataSources(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqReportSchedule(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqReportSchedule(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "typeKey":
			return ReportSchedule.staticSearchFqTypeKey(siteRequest_, o);
		case "narrativeKeys":
			return ReportSchedule.staticSearchFqNarrativeKeys(siteRequest_, o);
		case "eventKeys":
			return ReportSchedule.staticSearchFqEventKeys(siteRequest_, o);
		case "typeName":
			return ReportSchedule.staticSearchFqTypeName(siteRequest_, o);
		case "scheduleName":
			return ReportSchedule.staticSearchFqScheduleName(siteRequest_, o);
		case "frequencyOneTime":
			return ReportSchedule.staticSearchFqFrequencyOneTime(siteRequest_, o);
		case "frequencyTimesPerYear":
			return ReportSchedule.staticSearchFqFrequencyTimesPerYear(siteRequest_, o);
		case "frequencyYearsAfterCompletion":
			return ReportSchedule.staticSearchFqFrequencyYearsAfterCompletion(siteRequest_, o);
		case "firstDueDate":
			return ReportSchedule.staticSearchFqFirstDueDate(siteRequest_, o);
		case "dataPullDate":
			return ReportSchedule.staticSearchFqDataPullDate(siteRequest_, o);
		case "dataSources":
			return ReportSchedule.staticSearchFqDataSources(siteRequest_, o);
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
					o = defineReportSchedule(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineReportSchedule(String var, Object val) {
		switch(var.toLowerCase()) {
			case "typekey":
				if(val instanceof Long)
					setTypeKey((Long)val);
				else if(val instanceof String)
					setTypeKey((String)val);
				saves.add("typeKey");
				return val;
			case "schedulename":
				if(val instanceof String)
					setScheduleName((String)val);
				saves.add("scheduleName");
				return val;
			case "frequencyonetime":
				if(val instanceof Boolean)
					setFrequencyOneTime((Boolean)val);
				else if(val instanceof String)
					setFrequencyOneTime((String)val);
				saves.add("frequencyOneTime");
				return val;
			case "frequencytimesperyear":
				if(val instanceof Integer)
					setFrequencyTimesPerYear((Integer)val);
				else if(val instanceof String)
					setFrequencyTimesPerYear((String)val);
				saves.add("frequencyTimesPerYear");
				return val;
			case "frequencyyearsaftercompletion":
				if(val instanceof Integer)
					setFrequencyYearsAfterCompletion((Integer)val);
				else if(val instanceof String)
					setFrequencyYearsAfterCompletion((String)val);
				saves.add("frequencyYearsAfterCompletion");
				return val;
			case "firstduedate":
				if(val instanceof LocalDate)
					setFirstDueDate((LocalDate)val);
				else if(val instanceof String)
					setFirstDueDate((String)val);
				saves.add("firstDueDate");
				return val;
			case "datapulldate":
				if(val instanceof LocalDate)
					setDataPullDate((LocalDate)val);
				else if(val instanceof String)
					setDataPullDate((String)val);
				saves.add("dataPullDate");
				return val;
			case "datasources":
				if(val instanceof String)
					setDataSources((String)val);
				saves.add("dataSources");
				return val;
			default:
				return super.defineBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateReportSchedule(doc);
	}
	public void populateReportSchedule(SolrResponse.Doc doc) {
		ReportSchedule oReportSchedule = (ReportSchedule)this;
		saves = doc.get("saves_docvalues_strings");
		if(saves != null) {
		}

		super.populateBaseModel(doc);
	}

	public void indexReportSchedule(JsonObject doc) {
		if(typeKey != null) {
			doc.put("typeKey_docvalues_long", typeKey);
		}
		if(narrativeKeys != null) {
			JsonArray l = new JsonArray();
			doc.put("narrativeKeys_docvalues_longs", l);
			for(Long o : narrativeKeys) {
				l.add(o);
			}
		}
		if(eventKeys != null) {
			JsonArray l = new JsonArray();
			doc.put("eventKeys_docvalues_longs", l);
			for(Long o : eventKeys) {
				l.add(o);
			}
		}
		if(typeName != null) {
			doc.put("typeName_docvalues_string", typeName);
		}
		if(scheduleName != null) {
			doc.put("scheduleName_docvalues_string", scheduleName);
		}
		if(frequencyOneTime != null) {
			doc.put("frequencyOneTime_docvalues_boolean", frequencyOneTime);
		}
		if(frequencyTimesPerYear != null) {
			doc.put("frequencyTimesPerYear_docvalues_int", frequencyTimesPerYear);
		}
		if(frequencyYearsAfterCompletion != null) {
			doc.put("frequencyYearsAfterCompletion_docvalues_int", frequencyYearsAfterCompletion);
		}
		if(firstDueDate != null) {
			doc.put("firstDueDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(firstDueDate.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z"))));
		}
		if(dataPullDate != null) {
			doc.put("dataPullDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(dataPullDate.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z"))));
		}
		if(dataSources != null) {
			doc.put("dataSources_docvalues_string", dataSources);
		}
		super.indexBaseModel(doc);

	}

	public static String varIndexedReportSchedule(String entityVar) {
		switch(entityVar) {
			case "typeKey":
				return "typeKey_docvalues_long";
			case "narrativeKeys":
				return "narrativeKeys_docvalues_longs";
			case "eventKeys":
				return "eventKeys_docvalues_longs";
			case "typeName":
				return "typeName_docvalues_string";
			case "scheduleName":
				return "scheduleName_docvalues_string";
			case "frequencyOneTime":
				return "frequencyOneTime_docvalues_boolean";
			case "frequencyTimesPerYear":
				return "frequencyTimesPerYear_docvalues_int";
			case "frequencyYearsAfterCompletion":
				return "frequencyYearsAfterCompletion_docvalues_int";
			case "firstDueDate":
				return "firstDueDate_docvalues_date";
			case "dataPullDate":
				return "dataPullDate_docvalues_date";
			case "dataSources":
				return "dataSources_docvalues_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String varSearchReportSchedule(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedReportSchedule(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeReportSchedule(doc);
	}
	public void storeReportSchedule(SolrResponse.Doc doc) {
		ReportSchedule oReportSchedule = (ReportSchedule)this;

		oReportSchedule.setTypeKey(Optional.ofNullable(doc.get("typeKey_docvalues_long")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("narrativeKeys_docvalues_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oReportSchedule.addNarrativeKeys(v.toString());
		});
		Optional.ofNullable((List<?>)doc.get("eventKeys_docvalues_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oReportSchedule.addEventKeys(v.toString());
		});
		oReportSchedule.setTypeName(Optional.ofNullable(doc.get("typeName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oReportSchedule.setScheduleName(Optional.ofNullable(doc.get("scheduleName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oReportSchedule.setFrequencyOneTime(Optional.ofNullable(doc.get("frequencyOneTime_docvalues_boolean")).map(v -> v.toString()).orElse(null));
		oReportSchedule.setFrequencyTimesPerYear(Optional.ofNullable(doc.get("frequencyTimesPerYear_docvalues_int")).map(v -> v.toString()).orElse(null));
		oReportSchedule.setFrequencyYearsAfterCompletion(Optional.ofNullable(doc.get("frequencyYearsAfterCompletion_docvalues_int")).map(v -> v.toString()).orElse(null));
		oReportSchedule.setFirstDueDate(Optional.ofNullable(doc.get("firstDueDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oReportSchedule.setDataPullDate(Optional.ofNullable(doc.get("dataPullDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oReportSchedule.setDataSources(Optional.ofNullable(doc.get("dataSources_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestReportSchedule() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ReportSchedule) {
			ReportSchedule original = (ReportSchedule)o;
			if(!Objects.equals(typeKey, original.getTypeKey()))
				apiRequest.addVars("typeKey");
			if(!Objects.equals(narrativeKeys, original.getNarrativeKeys()))
				apiRequest.addVars("narrativeKeys");
			if(!Objects.equals(eventKeys, original.getEventKeys()))
				apiRequest.addVars("eventKeys");
			if(!Objects.equals(typeName, original.getTypeName()))
				apiRequest.addVars("typeName");
			if(!Objects.equals(scheduleName, original.getScheduleName()))
				apiRequest.addVars("scheduleName");
			if(!Objects.equals(frequencyOneTime, original.getFrequencyOneTime()))
				apiRequest.addVars("frequencyOneTime");
			if(!Objects.equals(frequencyTimesPerYear, original.getFrequencyTimesPerYear()))
				apiRequest.addVars("frequencyTimesPerYear");
			if(!Objects.equals(frequencyYearsAfterCompletion, original.getFrequencyYearsAfterCompletion()))
				apiRequest.addVars("frequencyYearsAfterCompletion");
			if(!Objects.equals(firstDueDate, original.getFirstDueDate()))
				apiRequest.addVars("firstDueDate");
			if(!Objects.equals(dataPullDate, original.getDataPullDate()))
				apiRequest.addVars("dataPullDate");
			if(!Objects.equals(dataSources, original.getDataSources()))
				apiRequest.addVars("dataSources");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(typeKey).map(v -> "typeKey: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(narrativeKeys).map(v -> "narrativeKeys: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(eventKeys).map(v -> "eventKeys: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(typeName).map(v -> "typeName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(scheduleName).map(v -> "scheduleName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(frequencyOneTime).map(v -> "frequencyOneTime: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(frequencyTimesPerYear).map(v -> "frequencyTimesPerYear: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(frequencyYearsAfterCompletion).map(v -> "frequencyYearsAfterCompletion: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(firstDueDate).map(v -> "firstDueDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(dataPullDate).map(v -> "dataPullDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(dataSources).map(v -> "dataSources: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String VAR_typeKey = "typeKey";
	public static final String VAR_narrativeKeys = "narrativeKeys";
	public static final String VAR_eventKeys = "eventKeys";
	public static final String VAR_typeSearch = "typeSearch";
	public static final String VAR_type_ = "type_";
	public static final String VAR_typeName = "typeName";
	public static final String VAR_scheduleName = "scheduleName";
	public static final String VAR_frequencyOneTime = "frequencyOneTime";
	public static final String VAR_frequencyTimesPerYear = "frequencyTimesPerYear";
	public static final String VAR_frequencyYearsAfterCompletion = "frequencyYearsAfterCompletion";
	public static final String VAR_firstDueDate = "firstDueDate";
	public static final String VAR_dataPullDate = "dataPullDate";
	public static final String VAR_dataSources = "dataSources";

	public static final String DISPLAY_NAME_typeKey = "report type";
	public static final String DISPLAY_NAME_narrativeKeys = "narratives";
	public static final String DISPLAY_NAME_eventKeys = "events";
	public static final String DISPLAY_NAME_typeSearch = "";
	public static final String DISPLAY_NAME_type_ = "";
	public static final String DISPLAY_NAME_typeName = "report type name";
	public static final String DISPLAY_NAME_scheduleName = "schedule name";
	public static final String DISPLAY_NAME_frequencyOneTime = "one time";
	public static final String DISPLAY_NAME_frequencyTimesPerYear = "times per year";
	public static final String DISPLAY_NAME_frequencyYearsAfterCompletion = "years after completion";
	public static final String DISPLAY_NAME_firstDueDate = "first due date";
	public static final String DISPLAY_NAME_dataPullDate = "data pull date";
	public static final String DISPLAY_NAME_dataSources = "data sources";

	public static String displayNameForClass(String var) {
		return ReportSchedule.displayNameReportSchedule(var);
	}
	public static String displayNameReportSchedule(String var) {
		switch(var) {
		case VAR_typeKey:
			return DISPLAY_NAME_typeKey;
		case VAR_narrativeKeys:
			return DISPLAY_NAME_narrativeKeys;
		case VAR_eventKeys:
			return DISPLAY_NAME_eventKeys;
		case VAR_typeSearch:
			return DISPLAY_NAME_typeSearch;
		case VAR_type_:
			return DISPLAY_NAME_type_;
		case VAR_typeName:
			return DISPLAY_NAME_typeName;
		case VAR_scheduleName:
			return DISPLAY_NAME_scheduleName;
		case VAR_frequencyOneTime:
			return DISPLAY_NAME_frequencyOneTime;
		case VAR_frequencyTimesPerYear:
			return DISPLAY_NAME_frequencyTimesPerYear;
		case VAR_frequencyYearsAfterCompletion:
			return DISPLAY_NAME_frequencyYearsAfterCompletion;
		case VAR_firstDueDate:
			return DISPLAY_NAME_firstDueDate;
		case VAR_dataPullDate:
			return DISPLAY_NAME_dataPullDate;
		case VAR_dataSources:
			return DISPLAY_NAME_dataSources;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}
}
