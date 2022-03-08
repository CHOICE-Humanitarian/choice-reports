package org.choicehumanitarian.reports.enus.model.report.narrative;

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
import org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrative;
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

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrativeGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ReportNarrativeGenPageGen<DEV> extends BaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(ReportNarrativeGenPage.class);

	////////////////////////////////
	// searchListReportNarrative_ //
	////////////////////////////////

	/**	 The entity searchListReportNarrative_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ReportNarrative> searchListReportNarrative_;

	/**	<br> The entity searchListReportNarrative_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrativeGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListReportNarrative_">Find the entity searchListReportNarrative_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListReportNarrative_(Wrap<SearchList<ReportNarrative>> w);

	public SearchList<ReportNarrative> getSearchListReportNarrative_() {
		return searchListReportNarrative_;
	}

	public void setSearchListReportNarrative_(SearchList<ReportNarrative> searchListReportNarrative_) {
		this.searchListReportNarrative_ = searchListReportNarrative_;
	}
	public static SearchList<ReportNarrative> staticSetSearchListReportNarrative_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportNarrativeGenPage searchListReportNarrative_Init() {
		Wrap<SearchList<ReportNarrative>> searchListReportNarrative_Wrap = new Wrap<SearchList<ReportNarrative>>().var("searchListReportNarrative_");
		if(searchListReportNarrative_ == null) {
			_searchListReportNarrative_(searchListReportNarrative_Wrap);
			setSearchListReportNarrative_(searchListReportNarrative_Wrap.o);
		}
		return (ReportNarrativeGenPage)this;
	}

	/////////////////////////
	// listReportNarrative //
	/////////////////////////

	/**	 The entity listReportNarrative
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listReportNarrative = new JsonArray();

	/**	<br> The entity listReportNarrative
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrativeGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listReportNarrative">Find the entity listReportNarrative in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listReportNarrative(JsonArray l);

	public JsonArray getListReportNarrative() {
		return listReportNarrative;
	}

	public void setListReportNarrative(JsonArray listReportNarrative) {
		this.listReportNarrative = listReportNarrative;
	}
	public static JsonArray staticSetListReportNarrative(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportNarrativeGenPage listReportNarrativeInit() {
		_listReportNarrative(listReportNarrative);
		return (ReportNarrativeGenPage)this;
	}

	//////////////////////////
	// reportNarrativeCount //
	//////////////////////////

	/**	 The entity reportNarrativeCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer reportNarrativeCount;

	/**	<br> The entity reportNarrativeCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrativeGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportNarrativeCount">Find the entity reportNarrativeCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportNarrativeCount(Wrap<Integer> w);

	public Integer getReportNarrativeCount() {
		return reportNarrativeCount;
	}

	public void setReportNarrativeCount(Integer reportNarrativeCount) {
		this.reportNarrativeCount = reportNarrativeCount;
	}
	@JsonIgnore
	public void setReportNarrativeCount(String o) {
		this.reportNarrativeCount = ReportNarrativeGenPage.staticSetReportNarrativeCount(siteRequest_, o);
	}
	public static Integer staticSetReportNarrativeCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ReportNarrativeGenPage reportNarrativeCountInit() {
		Wrap<Integer> reportNarrativeCountWrap = new Wrap<Integer>().var("reportNarrativeCount");
		if(reportNarrativeCount == null) {
			_reportNarrativeCount(reportNarrativeCountWrap);
			setReportNarrativeCount(reportNarrativeCountWrap.o);
		}
		return (ReportNarrativeGenPage)this;
	}

	public static Integer staticSearchReportNarrativeCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrReportNarrativeCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReportNarrativeCount(SiteRequestEnUS siteRequest_, String o) {
		return ReportNarrativeGenPage.staticSearchStrReportNarrativeCount(siteRequest_, ReportNarrativeGenPage.staticSearchReportNarrativeCount(siteRequest_, ReportNarrativeGenPage.staticSetReportNarrativeCount(siteRequest_, o)));
	}

	//////////////////////
	// reportNarrative_ //
	//////////////////////

	/**	 The entity reportNarrative_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ReportNarrative reportNarrative_;

	/**	<br> The entity reportNarrative_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrativeGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportNarrative_">Find the entity reportNarrative_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportNarrative_(Wrap<ReportNarrative> w);

	public ReportNarrative getReportNarrative_() {
		return reportNarrative_;
	}

	public void setReportNarrative_(ReportNarrative reportNarrative_) {
		this.reportNarrative_ = reportNarrative_;
	}
	public static ReportNarrative staticSetReportNarrative_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportNarrativeGenPage reportNarrative_Init() {
		Wrap<ReportNarrative> reportNarrative_Wrap = new Wrap<ReportNarrative>().var("reportNarrative_");
		if(reportNarrative_ == null) {
			_reportNarrative_(reportNarrative_Wrap);
			setReportNarrative_(reportNarrative_Wrap.o);
		}
		return (ReportNarrativeGenPage)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.narrative.ReportNarrativeGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = ReportNarrativeGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ReportNarrativeGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (ReportNarrativeGenPage)this;
	}

	public static Long staticSearchPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPk(SiteRequestEnUS siteRequest_, String o) {
		return ReportNarrativeGenPage.staticSearchStrPk(siteRequest_, ReportNarrativeGenPage.staticSearchPk(siteRequest_, ReportNarrativeGenPage.staticSetPk(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepReportNarrativeGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepReportNarrativeGenPage();
	}

	public Future<Void> promiseDeepReportNarrativeGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseReportNarrativeGenPage(promise2);
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

	public Future<Void> promiseReportNarrativeGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListReportNarrative_Init();
				listReportNarrativeInit();
				reportNarrativeCountInit();
				reportNarrative_Init();
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
		return promiseDeepReportNarrativeGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportNarrativeGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestReportNarrativeGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainReportNarrativeGenPage(v);
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
	public Object obtainReportNarrativeGenPage(String var) {
		ReportNarrativeGenPage oReportNarrativeGenPage = (ReportNarrativeGenPage)this;
		switch(var) {
			case "searchListReportNarrative_":
				return oReportNarrativeGenPage.searchListReportNarrative_;
			case "listReportNarrative":
				return oReportNarrativeGenPage.listReportNarrative;
			case "reportNarrativeCount":
				return oReportNarrativeGenPage.reportNarrativeCount;
			case "reportNarrative_":
				return oReportNarrativeGenPage.reportNarrative_;
			case "pk":
				return oReportNarrativeGenPage.pk;
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
				o = relateReportNarrativeGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateReportNarrativeGenPage(String var, Object val) {
		ReportNarrativeGenPage oReportNarrativeGenPage = (ReportNarrativeGenPage)this;
		switch(var) {
			default:
				return super.relateBaseModelPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetReportNarrativeGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetReportNarrativeGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "reportNarrativeCount":
			return ReportNarrativeGenPage.staticSetReportNarrativeCount(siteRequest_, o);
		case "pk":
			return ReportNarrativeGenPage.staticSetPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSetBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchReportNarrativeGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchReportNarrativeGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "reportNarrativeCount":
			return ReportNarrativeGenPage.staticSearchReportNarrativeCount(siteRequest_, (Integer)o);
		case "pk":
			return ReportNarrativeGenPage.staticSearchPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSearchBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrReportNarrativeGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrReportNarrativeGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "reportNarrativeCount":
			return ReportNarrativeGenPage.staticSearchStrReportNarrativeCount(siteRequest_, (Integer)o);
		case "pk":
			return ReportNarrativeGenPage.staticSearchStrPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSearchStrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqReportNarrativeGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqReportNarrativeGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "reportNarrativeCount":
			return ReportNarrativeGenPage.staticSearchFqReportNarrativeCount(siteRequest_, o);
		case "pk":
			return ReportNarrativeGenPage.staticSearchFqPk(siteRequest_, o);
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

	public static final String VAR_searchListReportNarrative_ = "searchListReportNarrative_";
	public static final String VAR_listReportNarrative = "listReportNarrative";
	public static final String VAR_reportNarrativeCount = "reportNarrativeCount";
	public static final String VAR_reportNarrative_ = "reportNarrative_";
	public static final String VAR_pk = "pk";

	public static final String DISPLAY_NAME_searchListReportNarrative_ = "";
	public static final String DISPLAY_NAME_listReportNarrative = "";
	public static final String DISPLAY_NAME_reportNarrativeCount = "";
	public static final String DISPLAY_NAME_reportNarrative_ = "";
	public static final String DISPLAY_NAME_pk = "";

	public static String displayNameForClass(String var) {
		return ReportNarrativeGenPage.displayNameReportNarrativeGenPage(var);
	}
	public static String displayNameReportNarrativeGenPage(String var) {
		switch(var) {
		case VAR_searchListReportNarrative_:
			return DISPLAY_NAME_searchListReportNarrative_;
		case VAR_listReportNarrative:
			return DISPLAY_NAME_listReportNarrative;
		case VAR_reportNarrativeCount:
			return DISPLAY_NAME_reportNarrativeCount;
		case VAR_reportNarrative_:
			return DISPLAY_NAME_reportNarrative_;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		default:
			return BaseModelPage.displayNameBaseModelPage(var);
		}
	}
}
