package org.choicehumanitarian.reports.enus.model.report.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import java.util.HashMap;
import org.choicehumanitarian.reports.enus.base.BaseModelPage;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.String;
import java.math.RoundingMode;
import org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule;
import org.slf4j.Logger;
import java.math.MathContext;
import io.vertx.core.Promise;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import org.choicehumanitarian.reports.enus.base.BaseModel;
import java.util.Objects;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.vertx.search.list.SearchList;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportScheduleGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ReportScheduleGenPageGen<DEV> extends BaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(ReportScheduleGenPage.class);

	///////////////////////////////
	// searchListReportSchedule_ //
	///////////////////////////////

	/**	 The entity searchListReportSchedule_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ReportSchedule> searchListReportSchedule_;

	/**	<br> The entity searchListReportSchedule_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportScheduleGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListReportSchedule_">Find the entity searchListReportSchedule_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListReportSchedule_(Wrap<SearchList<ReportSchedule>> w);

	public SearchList<ReportSchedule> getSearchListReportSchedule_() {
		return searchListReportSchedule_;
	}

	public void setSearchListReportSchedule_(SearchList<ReportSchedule> searchListReportSchedule_) {
		this.searchListReportSchedule_ = searchListReportSchedule_;
	}
	public static SearchList<ReportSchedule> staticSetSearchListReportSchedule_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportScheduleGenPage searchListReportSchedule_Init() {
		Wrap<SearchList<ReportSchedule>> searchListReportSchedule_Wrap = new Wrap<SearchList<ReportSchedule>>().var("searchListReportSchedule_");
		if(searchListReportSchedule_ == null) {
			_searchListReportSchedule_(searchListReportSchedule_Wrap);
			setSearchListReportSchedule_(searchListReportSchedule_Wrap.o);
		}
		return (ReportScheduleGenPage)this;
	}

	////////////////////////
	// listReportSchedule //
	////////////////////////

	/**	 The entity listReportSchedule
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listReportSchedule = new JsonArray();

	/**	<br> The entity listReportSchedule
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportScheduleGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listReportSchedule">Find the entity listReportSchedule in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listReportSchedule(JsonArray l);

	public JsonArray getListReportSchedule() {
		return listReportSchedule;
	}

	public void setListReportSchedule(JsonArray listReportSchedule) {
		this.listReportSchedule = listReportSchedule;
	}
	public static JsonArray staticSetListReportSchedule(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportScheduleGenPage listReportScheduleInit() {
		_listReportSchedule(listReportSchedule);
		return (ReportScheduleGenPage)this;
	}

	/////////////////////////
	// reportScheduleCount //
	/////////////////////////

	/**	 The entity reportScheduleCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer reportScheduleCount;

	/**	<br> The entity reportScheduleCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportScheduleGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportScheduleCount">Find the entity reportScheduleCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportScheduleCount(Wrap<Integer> w);

	public Integer getReportScheduleCount() {
		return reportScheduleCount;
	}

	public void setReportScheduleCount(Integer reportScheduleCount) {
		this.reportScheduleCount = reportScheduleCount;
	}
	@JsonIgnore
	public void setReportScheduleCount(String o) {
		this.reportScheduleCount = ReportScheduleGenPage.staticSetReportScheduleCount(siteRequest_, o);
	}
	public static Integer staticSetReportScheduleCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ReportScheduleGenPage reportScheduleCountInit() {
		Wrap<Integer> reportScheduleCountWrap = new Wrap<Integer>().var("reportScheduleCount");
		if(reportScheduleCount == null) {
			_reportScheduleCount(reportScheduleCountWrap);
			setReportScheduleCount(reportScheduleCountWrap.o);
		}
		return (ReportScheduleGenPage)this;
	}

	public static Integer staticSearchReportScheduleCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrReportScheduleCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReportScheduleCount(SiteRequestEnUS siteRequest_, String o) {
		return ReportScheduleGenPage.staticSearchStrReportScheduleCount(siteRequest_, ReportScheduleGenPage.staticSearchReportScheduleCount(siteRequest_, ReportScheduleGenPage.staticSetReportScheduleCount(siteRequest_, o)));
	}

	/////////////////////
	// reportSchedule_ //
	/////////////////////

	/**	 The entity reportSchedule_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ReportSchedule reportSchedule_;

	/**	<br> The entity reportSchedule_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportScheduleGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportSchedule_">Find the entity reportSchedule_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportSchedule_(Wrap<ReportSchedule> w);

	public ReportSchedule getReportSchedule_() {
		return reportSchedule_;
	}

	public void setReportSchedule_(ReportSchedule reportSchedule_) {
		this.reportSchedule_ = reportSchedule_;
	}
	public static ReportSchedule staticSetReportSchedule_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportScheduleGenPage reportSchedule_Init() {
		Wrap<ReportSchedule> reportSchedule_Wrap = new Wrap<ReportSchedule>().var("reportSchedule_");
		if(reportSchedule_ == null) {
			_reportSchedule_(reportSchedule_Wrap);
			setReportSchedule_(reportSchedule_Wrap.o);
		}
		return (ReportScheduleGenPage)this;
	}

	////////
	// pk //
	////////

	/**	 The entity pk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long pk;

	/**	<br> The entity pk
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.schedule.ReportScheduleGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pk(Wrap<Long> w);

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}
	@JsonIgnore
	public void setPk(String o) {
		this.pk = ReportScheduleGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ReportScheduleGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (ReportScheduleGenPage)this;
	}

	public static Long staticSearchPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPk(SiteRequestEnUS siteRequest_, String o) {
		return ReportScheduleGenPage.staticSearchStrPk(siteRequest_, ReportScheduleGenPage.staticSearchPk(siteRequest_, ReportScheduleGenPage.staticSetPk(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepReportScheduleGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepReportScheduleGenPage();
	}

	public Future<Void> promiseDeepReportScheduleGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseReportScheduleGenPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepBaseModelPage(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseReportScheduleGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListReportSchedule_Init();
				listReportScheduleInit();
				reportScheduleCountInit();
				reportSchedule_Init();
				pkInit();
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
		return promiseDeepReportScheduleGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportScheduleGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestReportScheduleGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainReportScheduleGenPage(v);
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
	public Object obtainReportScheduleGenPage(String var) {
		ReportScheduleGenPage oReportScheduleGenPage = (ReportScheduleGenPage)this;
		switch(var) {
			case "searchListReportSchedule_":
				return oReportScheduleGenPage.searchListReportSchedule_;
			case "listReportSchedule":
				return oReportScheduleGenPage.listReportSchedule;
			case "reportScheduleCount":
				return oReportScheduleGenPage.reportScheduleCount;
			case "reportSchedule_":
				return oReportScheduleGenPage.reportSchedule_;
			case "pk":
				return oReportScheduleGenPage.pk;
			default:
				return super.obtainBaseModelPage(var);
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
				o = relateReportScheduleGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateReportScheduleGenPage(String var, Object val) {
		ReportScheduleGenPage oReportScheduleGenPage = (ReportScheduleGenPage)this;
		switch(var) {
			default:
				return super.relateBaseModelPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetReportScheduleGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetReportScheduleGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "reportScheduleCount":
			return ReportScheduleGenPage.staticSetReportScheduleCount(siteRequest_, o);
		case "pk":
			return ReportScheduleGenPage.staticSetPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSetBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchReportScheduleGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchReportScheduleGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "reportScheduleCount":
			return ReportScheduleGenPage.staticSearchReportScheduleCount(siteRequest_, (Integer)o);
		case "pk":
			return ReportScheduleGenPage.staticSearchPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSearchBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrReportScheduleGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrReportScheduleGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "reportScheduleCount":
			return ReportScheduleGenPage.staticSearchStrReportScheduleCount(siteRequest_, (Integer)o);
		case "pk":
			return ReportScheduleGenPage.staticSearchStrPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSearchStrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqReportScheduleGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqReportScheduleGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "reportScheduleCount":
			return ReportScheduleGenPage.staticSearchFqReportScheduleCount(siteRequest_, o);
		case "pk":
			return ReportScheduleGenPage.staticSearchFqPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSearchFqBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		return sb.toString();
	}

	public static final String VAR_searchListReportSchedule_ = "searchListReportSchedule_";
	public static final String VAR_listReportSchedule = "listReportSchedule";
	public static final String VAR_reportScheduleCount = "reportScheduleCount";
	public static final String VAR_reportSchedule_ = "reportSchedule_";
	public static final String VAR_pk = "pk";

	public static final String DISPLAY_NAME_searchListReportSchedule_ = "";
	public static final String DISPLAY_NAME_listReportSchedule = "";
	public static final String DISPLAY_NAME_reportScheduleCount = "";
	public static final String DISPLAY_NAME_reportSchedule_ = "";
	public static final String DISPLAY_NAME_pk = "";

	public static String displayNameForClass(String var) {
		return ReportScheduleGenPage.displayNameReportScheduleGenPage(var);
	}
	public static String displayNameReportScheduleGenPage(String var) {
		switch(var) {
		case VAR_searchListReportSchedule_:
			return DISPLAY_NAME_searchListReportSchedule_;
		case VAR_listReportSchedule:
			return DISPLAY_NAME_listReportSchedule;
		case VAR_reportScheduleCount:
			return DISPLAY_NAME_reportScheduleCount;
		case VAR_reportSchedule_:
			return DISPLAY_NAME_reportSchedule_;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		default:
			return BaseModelPage.displayNameBaseModelPage(var);
		}
	}
}
