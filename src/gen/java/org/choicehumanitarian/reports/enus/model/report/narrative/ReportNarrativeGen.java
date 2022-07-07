package org.choicehumanitarian.reports.enus.model.report.narrative;

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
import org.computate.vertx.search.list.SearchList;
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
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative">Find the class ReportNarrative in Solr. </a>
 * <br><br>Delete the class ReportNarrative in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the package org.choicehumanitarian.reports.enus.model.report.narrative in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the project choice-reports in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:choice\-reports&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>
 **/
public abstract class ReportNarrativeGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(ReportNarrative.class);

	public static final String ReportNarrative_AName_enUS = "a report narrative";
	public static final String ReportNarrative_This_enUS = "this ";
	public static final String ReportNarrative_ThisName_enUS = "this report narrative";
	public static final String ReportNarrative_A_enUS = "a ";
	public static final String ReportNarrative_TheName_enUS = "the report narrative";
	public static final String ReportNarrative_NameSingular_enUS = "report narrative";
	public static final String ReportNarrative_NamePlural_enUS = "report narratives";
	public static final String ReportNarrative_NameActual_enUS = "current report narrative";
	public static final String ReportNarrative_AllName_enUS = "all the report narratives";
	public static final String ReportNarrative_SearchAllNameBy_enUS = "search report narratives by ";
	public static final String ReportNarrative_Title_enUS = "report narratives";
	public static final String ReportNarrative_ThePluralName_enUS = "the report narratives";
	public static final String ReportNarrative_NoNameFound_enUS = "no report narrative found";
	public static final String ReportNarrative_NameVar_enUS = "reportNarrative";
	public static final String ReportNarrative_OfName_enUS = "of report narrative";
	public static final String ReportNarrative_ANameAdjective_enUS = "a report narrative";
	public static final String ReportNarrative_NameAdjectiveSingular_enUS = "report narrative";
	public static final String ReportNarrative_NameAdjectivePlural_enUS = "report narratives";
	public static final String PUTImport_enUS_Uri = "/api/report-narrative-import";
	public static final String PUTImport_enUS_ImageUri = "/png/api/report-narrative-import-999.png";
	public static final String POST_enUS_Uri = "/api/report-narrative";
	public static final String POST_enUS_ImageUri = "/png/api/report-narrative-999.png";
	public static final String PATCH_enUS_Uri = "/api/report-narrative";
	public static final String PATCH_enUS_ImageUri = "/png/api/report-narrative-999.png";
	public static final String GET_enUS_Uri = "/api/report-narrative/{id}";
	public static final String GET_enUS_ImageUri = "/png/api/report-narrative/{id}-999.png";
	public static final String Search_enUS_Uri = "/api/report-narrative";
	public static final String Search_enUS_ImageUri = "/png/api/report-narrative-999.png";
	public static final String SearchPage_enUS_Uri = "/report-narrative";
	public static final String SearchPage_enUS_ImageUri = "/png/report-narrative-999.png";

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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:scheduleKey">Find the entity scheduleKey in Solr</a>
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

	////////////////////
	// scheduleSearch //
	////////////////////

	/**	 The entity scheduleSearch
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ReportSchedule> scheduleSearch;

	/**	<br> The entity scheduleSearch
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:scheduleSearch">Find the entity scheduleSearch in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _scheduleSearch(Promise<SearchList<ReportSchedule>> promise);

	public SearchList<ReportSchedule> getScheduleSearch() {
		return scheduleSearch;
	}

	public void setScheduleSearch(SearchList<ReportSchedule> scheduleSearch) {
		this.scheduleSearch = scheduleSearch;
	}
	public static SearchList<ReportSchedule> staticSetScheduleSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<SearchList<ReportSchedule>> scheduleSearchPromise() {
		Promise<SearchList<ReportSchedule>> promise = Promise.promise();
		Promise<SearchList<ReportSchedule>> promise2 = Promise.promise();
		_scheduleSearch(promise2);
		promise2.future().onSuccess(o -> {
			if(o != null && scheduleSearch == null) {
				o.promiseDeepForClass(siteRequest_).onSuccess(a -> {
					setScheduleSearch(o);
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

	///////////////
	// schedule_ //
	///////////////

	/**	 The entity schedule_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ReportSchedule schedule_;

	/**	<br> The entity schedule_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:schedule_">Find the entity schedule_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _schedule_(Wrap<ReportSchedule> w);

	public ReportSchedule getSchedule_() {
		return schedule_;
	}

	public void setSchedule_(ReportSchedule schedule_) {
		this.schedule_ = schedule_;
	}
	public static ReportSchedule staticSetSchedule_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportNarrative schedule_Init() {
		Wrap<ReportSchedule> schedule_Wrap = new Wrap<ReportSchedule>().var("schedule_");
		if(schedule_ == null) {
			_schedule_(schedule_Wrap);
			setSchedule_(schedule_Wrap.o);
		}
		return (ReportNarrative)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:assigneeKey">Find the entity assigneeKey in Solr</a>
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

	////////////////////
	// assigneeSearch //
	////////////////////

	/**	 The entity assigneeSearch
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteUser> assigneeSearch;

	/**	<br> The entity assigneeSearch
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:assigneeSearch">Find the entity assigneeSearch in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _assigneeSearch(Promise<SearchList<SiteUser>> promise);

	public SearchList<SiteUser> getAssigneeSearch() {
		return assigneeSearch;
	}

	public void setAssigneeSearch(SearchList<SiteUser> assigneeSearch) {
		this.assigneeSearch = assigneeSearch;
	}
	public static SearchList<SiteUser> staticSetAssigneeSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<SearchList<SiteUser>> assigneeSearchPromise() {
		Promise<SearchList<SiteUser>> promise = Promise.promise();
		Promise<SearchList<SiteUser>> promise2 = Promise.promise();
		_assigneeSearch(promise2);
		promise2.future().onSuccess(o -> {
			if(o != null && assigneeSearch == null) {
				o.promiseDeepForClass(siteRequest_).onSuccess(a -> {
					setAssigneeSearch(o);
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

	///////////////
	// assignee_ //
	///////////////

	/**	 The entity assignee_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected SiteUser assignee_;

	/**	<br> The entity assignee_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:assignee_">Find the entity assignee_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _assignee_(Wrap<SiteUser> w);

	public SiteUser getAssignee_() {
		return assignee_;
	}

	public void setAssignee_(SiteUser assignee_) {
		this.assignee_ = assignee_;
	}
	public static SiteUser staticSetAssignee_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportNarrative assignee_Init() {
		Wrap<SiteUser> assignee_Wrap = new Wrap<SiteUser>().var("assignee_");
		if(assignee_ == null) {
			_assignee_(assignee_Wrap);
			setAssignee_(assignee_Wrap.o);
		}
		return (ReportNarrative)this;
	}

	//////////////////
	// assigneeName //
	//////////////////

	/**	 The entity assigneeName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String assigneeName;

	/**	<br> The entity assigneeName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:assigneeName">Find the entity assigneeName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _assigneeName(Wrap<String> w);

	public String getAssigneeName() {
		return assigneeName;
	}
	public void setAssigneeName(String o) {
		this.assigneeName = ReportNarrative.staticSetAssigneeName(siteRequest_, o);
	}
	public static String staticSetAssigneeName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ReportNarrative assigneeNameInit() {
		Wrap<String> assigneeNameWrap = new Wrap<String>().var("assigneeName");
		if(assigneeName == null) {
			_assigneeName(assigneeNameWrap);
			setAssigneeName(assigneeNameWrap.o);
		}
		return (ReportNarrative)this;
	}

	public static String staticSearchAssigneeName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAssigneeName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAssigneeName(SiteRequestEnUS siteRequest_, String o) {
		return ReportNarrative.staticSearchStrAssigneeName(siteRequest_, ReportNarrative.staticSearchAssigneeName(siteRequest_, ReportNarrative.staticSetAssigneeName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:narrativeName">Find the entity narrativeName in Solr</a>
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:firstDueDate">Find the entity firstDueDate in Solr</a>
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
		this.firstDueDate = ReportNarrative.staticSetFirstDueDate(siteRequest_, o);
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
	protected ReportNarrative firstDueDateInit() {
		Wrap<LocalDate> firstDueDateWrap = new Wrap<LocalDate>().var("firstDueDate");
		if(firstDueDate == null) {
			_firstDueDate(firstDueDateWrap);
			setFirstDueDate(firstDueDateWrap.o);
		}
		return (ReportNarrative)this;
	}

	public static Date staticSearchFirstDueDate(SiteRequestEnUS siteRequest_, LocalDate o) {
		return o == null ? null : Date.from(o.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z")).toInstant());
	}

	public static String staticSearchStrFirstDueDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqFirstDueDate(SiteRequestEnUS siteRequest_, String o) {
		return ReportNarrative.staticSearchStrFirstDueDate(siteRequest_, ReportNarrative.staticSearchFirstDueDate(siteRequest_, ReportNarrative.staticSetFirstDueDate(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:dataPullDate">Find the entity dataPullDate in Solr</a>
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
		this.dataPullDate = ReportNarrative.staticSetDataPullDate(siteRequest_, o);
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
	protected ReportNarrative dataPullDateInit() {
		Wrap<LocalDate> dataPullDateWrap = new Wrap<LocalDate>().var("dataPullDate");
		if(dataPullDate == null) {
			_dataPullDate(dataPullDateWrap);
			setDataPullDate(dataPullDateWrap.o);
		}
		return (ReportNarrative)this;
	}

	public static Date staticSearchDataPullDate(SiteRequestEnUS siteRequest_, LocalDate o) {
		return o == null ? null : Date.from(o.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z")).toInstant());
	}

	public static String staticSearchStrDataPullDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqDataPullDate(SiteRequestEnUS siteRequest_, String o) {
		return ReportNarrative.staticSearchStrDataPullDate(siteRequest_, ReportNarrative.staticSearchDataPullDate(siteRequest_, ReportNarrative.staticSetDataPullDate(siteRequest_, o)));
	}

	///////////////////
	// pullStartDate //
	///////////////////

	/**	 The entity pullStartDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateLocalDateDeserializer.class)
	@JsonSerialize(using = ComputateLocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonInclude(Include.NON_NULL)
	protected LocalDate pullStartDate;

	/**	<br> The entity pullStartDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:pullStartDate">Find the entity pullStartDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pullStartDate(Wrap<LocalDate> w);

	public LocalDate getPullStartDate() {
		return pullStartDate;
	}

	public void setPullStartDate(LocalDate pullStartDate) {
		this.pullStartDate = pullStartDate;
	}
	@JsonIgnore
	public void setPullStartDate(Instant o) {
		this.pullStartDate = o == null ? null : LocalDate.from(o);
	}
	/** Example: 2011-12-03+01:00 **/
	@JsonIgnore
	public void setPullStartDate(String o) {
		this.pullStartDate = ReportNarrative.staticSetPullStartDate(siteRequest_, o);
	}
	public static LocalDate staticSetPullStartDate(SiteRequestEnUS siteRequest_, String o) {
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
	public void setPullStartDate(Date o) {
		this.pullStartDate = o == null ? null : o.toInstant().atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toLocalDate();
	}
	protected ReportNarrative pullStartDateInit() {
		Wrap<LocalDate> pullStartDateWrap = new Wrap<LocalDate>().var("pullStartDate");
		if(pullStartDate == null) {
			_pullStartDate(pullStartDateWrap);
			setPullStartDate(pullStartDateWrap.o);
		}
		return (ReportNarrative)this;
	}

	public static Date staticSearchPullStartDate(SiteRequestEnUS siteRequest_, LocalDate o) {
		return o == null ? null : Date.from(o.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z")).toInstant());
	}

	public static String staticSearchStrPullStartDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqPullStartDate(SiteRequestEnUS siteRequest_, String o) {
		return ReportNarrative.staticSearchStrPullStartDate(siteRequest_, ReportNarrative.staticSearchPullStartDate(siteRequest_, ReportNarrative.staticSetPullStartDate(siteRequest_, o)));
	}

	public LocalDate sqlPullStartDate() {
		return pullStartDate;
	}

	/////////////////
	// pullEndDate //
	/////////////////

	/**	 The entity pullEndDate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateLocalDateDeserializer.class)
	@JsonSerialize(using = ComputateLocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonInclude(Include.NON_NULL)
	protected LocalDate pullEndDate;

	/**	<br> The entity pullEndDate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative&fq=entiteVar_enUS_indexed_string:pullEndDate">Find the entity pullEndDate in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pullEndDate(Wrap<LocalDate> w);

	public LocalDate getPullEndDate() {
		return pullEndDate;
	}

	public void setPullEndDate(LocalDate pullEndDate) {
		this.pullEndDate = pullEndDate;
	}
	@JsonIgnore
	public void setPullEndDate(Instant o) {
		this.pullEndDate = o == null ? null : LocalDate.from(o);
	}
	/** Example: 2011-12-03+01:00 **/
	@JsonIgnore
	public void setPullEndDate(String o) {
		this.pullEndDate = ReportNarrative.staticSetPullEndDate(siteRequest_, o);
	}
	public static LocalDate staticSetPullEndDate(SiteRequestEnUS siteRequest_, String o) {
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
	public void setPullEndDate(Date o) {
		this.pullEndDate = o == null ? null : o.toInstant().atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toLocalDate();
	}
	protected ReportNarrative pullEndDateInit() {
		Wrap<LocalDate> pullEndDateWrap = new Wrap<LocalDate>().var("pullEndDate");
		if(pullEndDate == null) {
			_pullEndDate(pullEndDateWrap);
			setPullEndDate(pullEndDateWrap.o);
		}
		return (ReportNarrative)this;
	}

	public static Date staticSearchPullEndDate(SiteRequestEnUS siteRequest_, LocalDate o) {
		return o == null ? null : Date.from(o.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z")).toInstant());
	}

	public static String staticSearchStrPullEndDate(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqPullEndDate(SiteRequestEnUS siteRequest_, String o) {
		return ReportNarrative.staticSearchStrPullEndDate(siteRequest_, ReportNarrative.staticSearchPullEndDate(siteRequest_, ReportNarrative.staticSetPullEndDate(siteRequest_, o)));
	}

	public LocalDate sqlPullEndDate() {
		return pullEndDate;
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
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			scheduleSearchPromise().onSuccess(scheduleSearch -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				schedule_Init();
				assigneeKeyInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			assigneeSearchPromise().onSuccess(assigneeSearch -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				assignee_Init();
				assigneeNameInit();
				narrativeNameInit();
				firstDueDateInit();
				dataPullDateInit();
				pullStartDateInit();
				pullEndDateInit();
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
		if(scheduleSearch != null)
			scheduleSearch.setSiteRequest_(siteRequest_);
		if(assigneeSearch != null)
			assigneeSearch.setSiteRequest_(siteRequest_);
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
			case "scheduleSearch":
				return oReportNarrative.scheduleSearch;
			case "schedule_":
				return oReportNarrative.schedule_;
			case "assigneeKey":
				return oReportNarrative.assigneeKey;
			case "assigneeSearch":
				return oReportNarrative.assigneeSearch;
			case "assignee_":
				return oReportNarrative.assignee_;
			case "assigneeName":
				return oReportNarrative.assigneeName;
			case "narrativeName":
				return oReportNarrative.narrativeName;
			case "firstDueDate":
				return oReportNarrative.firstDueDate;
			case "dataPullDate":
				return oReportNarrative.dataPullDate;
			case "pullStartDate":
				return oReportNarrative.pullStartDate;
			case "pullEndDate":
				return oReportNarrative.pullEndDate;
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
					oReportNarrative.setScheduleKey(val == null ? null : (NumberUtils.isCreatable(val.toString()) ? Long.parseLong(val.toString()) : -1));
				if(!saves.contains("scheduleKey"))
					saves.add("scheduleKey");
				return val;
			case "assigneeKey":
				if(oReportNarrative.getAssigneeKey() == null)
					oReportNarrative.setAssigneeKey(val == null ? null : (NumberUtils.isCreatable(val.toString()) ? Long.parseLong(val.toString()) : -1));
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
		case "assigneeName":
			return ReportNarrative.staticSetAssigneeName(siteRequest_, o);
		case "narrativeName":
			return ReportNarrative.staticSetNarrativeName(siteRequest_, o);
		case "firstDueDate":
			return ReportNarrative.staticSetFirstDueDate(siteRequest_, o);
		case "dataPullDate":
			return ReportNarrative.staticSetDataPullDate(siteRequest_, o);
		case "pullStartDate":
			return ReportNarrative.staticSetPullStartDate(siteRequest_, o);
		case "pullEndDate":
			return ReportNarrative.staticSetPullEndDate(siteRequest_, o);
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
		case "assigneeName":
			return ReportNarrative.staticSearchAssigneeName(siteRequest_, (String)o);
		case "narrativeName":
			return ReportNarrative.staticSearchNarrativeName(siteRequest_, (String)o);
		case "firstDueDate":
			return ReportNarrative.staticSearchFirstDueDate(siteRequest_, (LocalDate)o);
		case "dataPullDate":
			return ReportNarrative.staticSearchDataPullDate(siteRequest_, (LocalDate)o);
		case "pullStartDate":
			return ReportNarrative.staticSearchPullStartDate(siteRequest_, (LocalDate)o);
		case "pullEndDate":
			return ReportNarrative.staticSearchPullEndDate(siteRequest_, (LocalDate)o);
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
		case "assigneeName":
			return ReportNarrative.staticSearchStrAssigneeName(siteRequest_, (String)o);
		case "narrativeName":
			return ReportNarrative.staticSearchStrNarrativeName(siteRequest_, (String)o);
		case "firstDueDate":
			return ReportNarrative.staticSearchStrFirstDueDate(siteRequest_, (Date)o);
		case "dataPullDate":
			return ReportNarrative.staticSearchStrDataPullDate(siteRequest_, (Date)o);
		case "pullStartDate":
			return ReportNarrative.staticSearchStrPullStartDate(siteRequest_, (Date)o);
		case "pullEndDate":
			return ReportNarrative.staticSearchStrPullEndDate(siteRequest_, (Date)o);
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
		case "assigneeName":
			return ReportNarrative.staticSearchFqAssigneeName(siteRequest_, o);
		case "narrativeName":
			return ReportNarrative.staticSearchFqNarrativeName(siteRequest_, o);
		case "firstDueDate":
			return ReportNarrative.staticSearchFqFirstDueDate(siteRequest_, o);
		case "dataPullDate":
			return ReportNarrative.staticSearchFqDataPullDate(siteRequest_, o);
		case "pullStartDate":
			return ReportNarrative.staticSearchFqPullStartDate(siteRequest_, o);
		case "pullEndDate":
			return ReportNarrative.staticSearchFqPullEndDate(siteRequest_, o);
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
					o = persistReportNarrative(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistReportNarrative(String var, Object val) {
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
			case "pullstartdate":
				if(val instanceof LocalDate)
					setPullStartDate((LocalDate)val);
				else if(val instanceof String)
					setPullStartDate((String)val);
				saves.add("pullStartDate");
				return val;
			case "pullenddate":
				if(val instanceof LocalDate)
					setPullEndDate((LocalDate)val);
				else if(val instanceof String)
					setPullEndDate((String)val);
				saves.add("pullEndDate");
				return val;
			default:
				return super.persistBaseModel(var, val);
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
		if(assigneeName != null) {
			doc.put("assigneeName_docvalues_string", assigneeName);
		}
		if(narrativeName != null) {
			doc.put("narrativeName_docvalues_string", narrativeName);
		}
		if(firstDueDate != null) {
			doc.put("firstDueDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(firstDueDate.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z"))));
		}
		if(dataPullDate != null) {
			doc.put("dataPullDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(dataPullDate.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z"))));
		}
		if(pullStartDate != null) {
			doc.put("pullStartDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(pullStartDate.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z"))));
		}
		if(pullEndDate != null) {
			doc.put("pullEndDate_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(pullEndDate.atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).toInstant().atZone(ZoneId.of("Z"))));
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredReportNarrative(String entityVar) {
		switch(entityVar) {
			case "scheduleKey":
				return "scheduleKey_docvalues_long";
			case "assigneeKey":
				return "assigneeKey_docvalues_long";
			case "assigneeName":
				return "assigneeName_docvalues_string";
			case "narrativeName":
				return "narrativeName_docvalues_string";
			case "firstDueDate":
				return "firstDueDate_docvalues_date";
			case "dataPullDate":
				return "dataPullDate_docvalues_date";
			case "pullStartDate":
				return "pullStartDate_docvalues_date";
			case "pullEndDate":
				return "pullEndDate_docvalues_date";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedReportNarrative(String entityVar) {
		switch(entityVar) {
			case "scheduleKey":
				return "scheduleKey_docvalues_long";
			case "assigneeKey":
				return "assigneeKey_docvalues_long";
			case "assigneeName":
				return "assigneeName_docvalues_string";
			case "narrativeName":
				return "narrativeName_docvalues_string";
			case "firstDueDate":
				return "firstDueDate_docvalues_date";
			case "dataPullDate":
				return "dataPullDate_docvalues_date";
			case "pullStartDate":
				return "pullStartDate_docvalues_date";
			case "pullEndDate":
				return "pullEndDate_docvalues_date";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarReportNarrative(String searchVar) {
		switch(searchVar) {
			case "scheduleKey_docvalues_long":
				return "scheduleKey";
			case "assigneeKey_docvalues_long":
				return "assigneeKey";
			case "assigneeName_docvalues_string":
				return "assigneeName";
			case "narrativeName_docvalues_string":
				return "narrativeName";
			case "firstDueDate_docvalues_date":
				return "firstDueDate";
			case "dataPullDate_docvalues_date":
				return "dataPullDate";
			case "pullStartDate_docvalues_date":
				return "pullStartDate";
			case "pullEndDate_docvalues_date":
				return "pullEndDate";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
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
		oReportNarrative.setAssigneeName(Optional.ofNullable(doc.get("assigneeName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oReportNarrative.setNarrativeName(Optional.ofNullable(doc.get("narrativeName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oReportNarrative.setFirstDueDate(Optional.ofNullable(doc.get("firstDueDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oReportNarrative.setDataPullDate(Optional.ofNullable(doc.get("dataPullDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oReportNarrative.setPullStartDate(Optional.ofNullable(doc.get("pullStartDate_docvalues_date")).map(v -> v.toString()).orElse(null));
		oReportNarrative.setPullEndDate(Optional.ofNullable(doc.get("pullEndDate_docvalues_date")).map(v -> v.toString()).orElse(null));

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
			if(!Objects.equals(assigneeName, original.getAssigneeName()))
				apiRequest.addVars("assigneeName");
			if(!Objects.equals(narrativeName, original.getNarrativeName()))
				apiRequest.addVars("narrativeName");
			if(!Objects.equals(firstDueDate, original.getFirstDueDate()))
				apiRequest.addVars("firstDueDate");
			if(!Objects.equals(dataPullDate, original.getDataPullDate()))
				apiRequest.addVars("dataPullDate");
			if(!Objects.equals(pullStartDate, original.getPullStartDate()))
				apiRequest.addVars("pullStartDate");
			if(!Objects.equals(pullEndDate, original.getPullEndDate()))
				apiRequest.addVars("pullEndDate");
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
		sb.append(Optional.ofNullable(assigneeName).map(v -> "assigneeName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(narrativeName).map(v -> "narrativeName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(firstDueDate).map(v -> "firstDueDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(dataPullDate).map(v -> "dataPullDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(pullStartDate).map(v -> "pullStartDate: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(pullEndDate).map(v -> "pullEndDate: " + v + "\n").orElse(""));
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "ReportNarrative";
	public static final String VAR_scheduleKey = "scheduleKey";
	public static final String VAR_scheduleSearch = "scheduleSearch";
	public static final String VAR_schedule_ = "schedule_";
	public static final String VAR_assigneeKey = "assigneeKey";
	public static final String VAR_assigneeSearch = "assigneeSearch";
	public static final String VAR_assignee_ = "assignee_";
	public static final String VAR_assigneeName = "assigneeName";
	public static final String VAR_narrativeName = "narrativeName";
	public static final String VAR_firstDueDate = "firstDueDate";
	public static final String VAR_dataPullDate = "dataPullDate";
	public static final String VAR_pullStartDate = "pullStartDate";
	public static final String VAR_pullEndDate = "pullEndDate";

	public static List<String> varsQForClass() {
		return ReportNarrative.varsQReportNarrative(new ArrayList<String>());
	}
	public static List<String> varsQReportNarrative(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return ReportNarrative.varsFqReportNarrative(new ArrayList<String>());
	}
	public static List<String> varsFqReportNarrative(List<String> vars) {
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return ReportNarrative.varsRangeReportNarrative(new ArrayList<String>());
	}
	public static List<String> varsRangeReportNarrative(List<String> vars) {
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_scheduleKey = "schedule";
	public static final String DISPLAY_NAME_scheduleSearch = "";
	public static final String DISPLAY_NAME_schedule_ = "";
	public static final String DISPLAY_NAME_assigneeKey = "assignee";
	public static final String DISPLAY_NAME_assigneeSearch = "";
	public static final String DISPLAY_NAME_assignee_ = "";
	public static final String DISPLAY_NAME_assigneeName = "assignee name";
	public static final String DISPLAY_NAME_narrativeName = "narrative name";
	public static final String DISPLAY_NAME_firstDueDate = "report first due date";
	public static final String DISPLAY_NAME_dataPullDate = "report data pull date";
	public static final String DISPLAY_NAME_pullStartDate = "pull start date";
	public static final String DISPLAY_NAME_pullEndDate = "pull end date";

	public static String displayNameForClass(String var) {
		return ReportNarrative.displayNameReportNarrative(var);
	}
	public static String displayNameReportNarrative(String var) {
		switch(var) {
		case VAR_scheduleKey:
			return DISPLAY_NAME_scheduleKey;
		case VAR_scheduleSearch:
			return DISPLAY_NAME_scheduleSearch;
		case VAR_schedule_:
			return DISPLAY_NAME_schedule_;
		case VAR_assigneeKey:
			return DISPLAY_NAME_assigneeKey;
		case VAR_assigneeSearch:
			return DISPLAY_NAME_assigneeSearch;
		case VAR_assignee_:
			return DISPLAY_NAME_assignee_;
		case VAR_assigneeName:
			return DISPLAY_NAME_assigneeName;
		case VAR_narrativeName:
			return DISPLAY_NAME_narrativeName;
		case VAR_firstDueDate:
			return DISPLAY_NAME_firstDueDate;
		case VAR_dataPullDate:
			return DISPLAY_NAME_dataPullDate;
		case VAR_pullStartDate:
			return DISPLAY_NAME_pullStartDate;
		case VAR_pullEndDate:
			return DISPLAY_NAME_pullEndDate;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionReportNarrative(String var) {
		switch(var) {
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameReportNarrative(String var) {
		switch(var) {
		case VAR_scheduleKey:
			return "Long";
		case VAR_scheduleSearch:
			return "SearchList";
		case VAR_schedule_:
			return "ReportSchedule";
		case VAR_assigneeKey:
			return "Long";
		case VAR_assigneeSearch:
			return "SearchList";
		case VAR_assignee_:
			return "SiteUser";
		case VAR_assigneeName:
			return "String";
		case VAR_narrativeName:
			return "String";
		case VAR_firstDueDate:
			return "LocalDate";
		case VAR_dataPullDate:
			return "LocalDate";
		case VAR_pullStartDate:
			return "LocalDate";
		case VAR_pullEndDate:
			return "LocalDate";
			default:
				return BaseModel.classSimpleNameBaseModel(var);
		}
	}

	public static Integer htmlColumnReportNarrative(String var) {
		switch(var) {
			default:
				return BaseModel.htmlColumnBaseModel(var);
		}
	}

	public static Integer htmlRowReportNarrative(String var) {
		switch(var) {
		case VAR_scheduleKey:
			return 3;
		case VAR_assigneeKey:
			return 3;
		case VAR_narrativeName:
			return 3;
		case VAR_firstDueDate:
			return 4;
		case VAR_dataPullDate:
			return 4;
		case VAR_pullStartDate:
			return 4;
		case VAR_pullEndDate:
			return 4;
			default:
				return BaseModel.htmlRowBaseModel(var);
		}
	}

	public static Integer htmlCellReportNarrative(String var) {
		switch(var) {
		case VAR_scheduleKey:
			return 1;
		case VAR_assigneeKey:
			return 1;
		case VAR_narrativeName:
			return 1;
		case VAR_firstDueDate:
			return 1;
		case VAR_dataPullDate:
			return 2;
		case VAR_pullStartDate:
			return 3;
		case VAR_pullEndDate:
			return 4;
			default:
				return BaseModel.htmlCellBaseModel(var);
		}
	}

	public static Integer lengthMinReportNarrative(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxReportNarrative(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxReportNarrative(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minReportNarrative(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
