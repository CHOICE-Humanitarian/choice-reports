package org.choicehumanitarian.reports.enus.model.report.event;

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
import org.choicehumanitarian.reports.enus.model.report.event.ReportEvent;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEventGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ReportEventGenPageGen<DEV> extends BaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(ReportEventGenPage.class);

	////////////////////////////
	// searchListReportEvent_ //
	////////////////////////////

	/**	 The entity searchListReportEvent_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ReportEvent> searchListReportEvent_;

	/**	<br> The entity searchListReportEvent_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEventGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListReportEvent_">Find the entity searchListReportEvent_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListReportEvent_(Wrap<SearchList<ReportEvent>> w);

	public SearchList<ReportEvent> getSearchListReportEvent_() {
		return searchListReportEvent_;
	}

	public void setSearchListReportEvent_(SearchList<ReportEvent> searchListReportEvent_) {
		this.searchListReportEvent_ = searchListReportEvent_;
	}
	public static SearchList<ReportEvent> staticSetSearchListReportEvent_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportEventGenPage searchListReportEvent_Init() {
		Wrap<SearchList<ReportEvent>> searchListReportEvent_Wrap = new Wrap<SearchList<ReportEvent>>().var("searchListReportEvent_");
		if(searchListReportEvent_ == null) {
			_searchListReportEvent_(searchListReportEvent_Wrap);
			setSearchListReportEvent_(searchListReportEvent_Wrap.o);
		}
		return (ReportEventGenPage)this;
	}

	/////////////////////
	// listReportEvent //
	/////////////////////

	/**	 The entity listReportEvent
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listReportEvent = new JsonArray();

	/**	<br> The entity listReportEvent
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEventGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listReportEvent">Find the entity listReportEvent in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listReportEvent(JsonArray l);

	public JsonArray getListReportEvent() {
		return listReportEvent;
	}

	public void setListReportEvent(JsonArray listReportEvent) {
		this.listReportEvent = listReportEvent;
	}
	public static JsonArray staticSetListReportEvent(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportEventGenPage listReportEventInit() {
		_listReportEvent(listReportEvent);
		return (ReportEventGenPage)this;
	}

	//////////////////////
	// reportEventCount //
	//////////////////////

	/**	 The entity reportEventCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer reportEventCount;

	/**	<br> The entity reportEventCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEventGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportEventCount">Find the entity reportEventCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportEventCount(Wrap<Integer> w);

	public Integer getReportEventCount() {
		return reportEventCount;
	}

	public void setReportEventCount(Integer reportEventCount) {
		this.reportEventCount = reportEventCount;
	}
	@JsonIgnore
	public void setReportEventCount(String o) {
		this.reportEventCount = ReportEventGenPage.staticSetReportEventCount(siteRequest_, o);
	}
	public static Integer staticSetReportEventCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ReportEventGenPage reportEventCountInit() {
		Wrap<Integer> reportEventCountWrap = new Wrap<Integer>().var("reportEventCount");
		if(reportEventCount == null) {
			_reportEventCount(reportEventCountWrap);
			setReportEventCount(reportEventCountWrap.o);
		}
		return (ReportEventGenPage)this;
	}

	public static Integer staticSearchReportEventCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrReportEventCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReportEventCount(SiteRequestEnUS siteRequest_, String o) {
		return ReportEventGenPage.staticSearchStrReportEventCount(siteRequest_, ReportEventGenPage.staticSearchReportEventCount(siteRequest_, ReportEventGenPage.staticSetReportEventCount(siteRequest_, o)));
	}

	//////////////////
	// reportEvent_ //
	//////////////////

	/**	 The entity reportEvent_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ReportEvent reportEvent_;

	/**	<br> The entity reportEvent_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEventGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportEvent_">Find the entity reportEvent_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportEvent_(Wrap<ReportEvent> w);

	public ReportEvent getReportEvent_() {
		return reportEvent_;
	}

	public void setReportEvent_(ReportEvent reportEvent_) {
		this.reportEvent_ = reportEvent_;
	}
	public static ReportEvent staticSetReportEvent_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportEventGenPage reportEvent_Init() {
		Wrap<ReportEvent> reportEvent_Wrap = new Wrap<ReportEvent>().var("reportEvent_");
		if(reportEvent_ == null) {
			_reportEvent_(reportEvent_Wrap);
			setReportEvent_(reportEvent_Wrap.o);
		}
		return (ReportEventGenPage)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.event.ReportEventGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = ReportEventGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ReportEventGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (ReportEventGenPage)this;
	}

	public static Long staticSearchPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPk(SiteRequestEnUS siteRequest_, String o) {
		return ReportEventGenPage.staticSearchStrPk(siteRequest_, ReportEventGenPage.staticSearchPk(siteRequest_, ReportEventGenPage.staticSetPk(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepReportEventGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepReportEventGenPage();
	}

	public Future<Void> promiseDeepReportEventGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseReportEventGenPage(promise2);
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

	public Future<Void> promiseReportEventGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListReportEvent_Init();
				listReportEventInit();
				reportEventCountInit();
				reportEvent_Init();
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
		return promiseDeepReportEventGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportEventGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestReportEventGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainReportEventGenPage(v);
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
	public Object obtainReportEventGenPage(String var) {
		ReportEventGenPage oReportEventGenPage = (ReportEventGenPage)this;
		switch(var) {
			case "searchListReportEvent_":
				return oReportEventGenPage.searchListReportEvent_;
			case "listReportEvent":
				return oReportEventGenPage.listReportEvent;
			case "reportEventCount":
				return oReportEventGenPage.reportEventCount;
			case "reportEvent_":
				return oReportEventGenPage.reportEvent_;
			case "pk":
				return oReportEventGenPage.pk;
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
				o = relateReportEventGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateReportEventGenPage(String var, Object val) {
		ReportEventGenPage oReportEventGenPage = (ReportEventGenPage)this;
		switch(var) {
			default:
				return super.relateBaseModelPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetReportEventGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetReportEventGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "reportEventCount":
			return ReportEventGenPage.staticSetReportEventCount(siteRequest_, o);
		case "pk":
			return ReportEventGenPage.staticSetPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSetBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchReportEventGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchReportEventGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "reportEventCount":
			return ReportEventGenPage.staticSearchReportEventCount(siteRequest_, (Integer)o);
		case "pk":
			return ReportEventGenPage.staticSearchPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSearchBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrReportEventGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrReportEventGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "reportEventCount":
			return ReportEventGenPage.staticSearchStrReportEventCount(siteRequest_, (Integer)o);
		case "pk":
			return ReportEventGenPage.staticSearchStrPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSearchStrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqReportEventGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqReportEventGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "reportEventCount":
			return ReportEventGenPage.staticSearchFqReportEventCount(siteRequest_, o);
		case "pk":
			return ReportEventGenPage.staticSearchFqPk(siteRequest_, o);
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

	public static final String VAR_searchListReportEvent_ = "searchListReportEvent_";
	public static final String VAR_listReportEvent = "listReportEvent";
	public static final String VAR_reportEventCount = "reportEventCount";
	public static final String VAR_reportEvent_ = "reportEvent_";
	public static final String VAR_pk = "pk";

	public static final String DISPLAY_NAME_searchListReportEvent_ = "";
	public static final String DISPLAY_NAME_listReportEvent = "";
	public static final String DISPLAY_NAME_reportEventCount = "";
	public static final String DISPLAY_NAME_reportEvent_ = "";
	public static final String DISPLAY_NAME_pk = "";

	public static String displayNameForClass(String var) {
		return ReportEventGenPage.displayNameReportEventGenPage(var);
	}
	public static String displayNameReportEventGenPage(String var) {
		switch(var) {
		case VAR_searchListReportEvent_:
			return DISPLAY_NAME_searchListReportEvent_;
		case VAR_listReportEvent:
			return DISPLAY_NAME_listReportEvent;
		case VAR_reportEventCount:
			return DISPLAY_NAME_reportEventCount;
		case VAR_reportEvent_:
			return DISPLAY_NAME_reportEvent_;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		default:
			return BaseModelPage.displayNameBaseModelPage(var);
		}
	}
}
