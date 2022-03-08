package org.choicehumanitarian.reports.enus.model.report.type;

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
import org.choicehumanitarian.reports.enus.model.report.type.ReportType;
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
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportTypeGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ReportTypeGenPageGen<DEV> extends BaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(ReportTypeGenPage.class);

	///////////////////////////
	// searchListReportType_ //
	///////////////////////////

	/**	 The entity searchListReportType_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ReportType> searchListReportType_;

	/**	<br> The entity searchListReportType_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportTypeGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListReportType_">Find the entity searchListReportType_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListReportType_(Wrap<SearchList<ReportType>> w);

	public SearchList<ReportType> getSearchListReportType_() {
		return searchListReportType_;
	}

	public void setSearchListReportType_(SearchList<ReportType> searchListReportType_) {
		this.searchListReportType_ = searchListReportType_;
	}
	public static SearchList<ReportType> staticSetSearchListReportType_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportTypeGenPage searchListReportType_Init() {
		Wrap<SearchList<ReportType>> searchListReportType_Wrap = new Wrap<SearchList<ReportType>>().var("searchListReportType_");
		if(searchListReportType_ == null) {
			_searchListReportType_(searchListReportType_Wrap);
			setSearchListReportType_(searchListReportType_Wrap.o);
		}
		return (ReportTypeGenPage)this;
	}

	////////////////////
	// listReportType //
	////////////////////

	/**	 The entity listReportType
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listReportType = new JsonArray();

	/**	<br> The entity listReportType
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportTypeGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listReportType">Find the entity listReportType in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listReportType(JsonArray l);

	public JsonArray getListReportType() {
		return listReportType;
	}

	public void setListReportType(JsonArray listReportType) {
		this.listReportType = listReportType;
	}
	public static JsonArray staticSetListReportType(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportTypeGenPage listReportTypeInit() {
		_listReportType(listReportType);
		return (ReportTypeGenPage)this;
	}

	/////////////////////
	// reportTypeCount //
	/////////////////////

	/**	 The entity reportTypeCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer reportTypeCount;

	/**	<br> The entity reportTypeCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportTypeGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportTypeCount">Find the entity reportTypeCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportTypeCount(Wrap<Integer> w);

	public Integer getReportTypeCount() {
		return reportTypeCount;
	}

	public void setReportTypeCount(Integer reportTypeCount) {
		this.reportTypeCount = reportTypeCount;
	}
	@JsonIgnore
	public void setReportTypeCount(String o) {
		this.reportTypeCount = ReportTypeGenPage.staticSetReportTypeCount(siteRequest_, o);
	}
	public static Integer staticSetReportTypeCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ReportTypeGenPage reportTypeCountInit() {
		Wrap<Integer> reportTypeCountWrap = new Wrap<Integer>().var("reportTypeCount");
		if(reportTypeCount == null) {
			_reportTypeCount(reportTypeCountWrap);
			setReportTypeCount(reportTypeCountWrap.o);
		}
		return (ReportTypeGenPage)this;
	}

	public static Integer staticSearchReportTypeCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrReportTypeCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqReportTypeCount(SiteRequestEnUS siteRequest_, String o) {
		return ReportTypeGenPage.staticSearchStrReportTypeCount(siteRequest_, ReportTypeGenPage.staticSearchReportTypeCount(siteRequest_, ReportTypeGenPage.staticSetReportTypeCount(siteRequest_, o)));
	}

	/////////////////
	// reportType_ //
	/////////////////

	/**	 The entity reportType_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ReportType reportType_;

	/**	<br> The entity reportType_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportTypeGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:reportType_">Find the entity reportType_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _reportType_(Wrap<ReportType> w);

	public ReportType getReportType_() {
		return reportType_;
	}

	public void setReportType_(ReportType reportType_) {
		this.reportType_ = reportType_;
	}
	public static ReportType staticSetReportType_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ReportTypeGenPage reportType_Init() {
		Wrap<ReportType> reportType_Wrap = new Wrap<ReportType>().var("reportType_");
		if(reportType_ == null) {
			_reportType_(reportType_Wrap);
			setReportType_(reportType_Wrap.o);
		}
		return (ReportTypeGenPage)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.type.ReportTypeGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = ReportTypeGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ReportTypeGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (ReportTypeGenPage)this;
	}

	public static Long staticSearchPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPk(SiteRequestEnUS siteRequest_, String o) {
		return ReportTypeGenPage.staticSearchStrPk(siteRequest_, ReportTypeGenPage.staticSearchPk(siteRequest_, ReportTypeGenPage.staticSetPk(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepReportTypeGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepReportTypeGenPage();
	}

	public Future<Void> promiseDeepReportTypeGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseReportTypeGenPage(promise2);
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

	public Future<Void> promiseReportTypeGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListReportType_Init();
				listReportTypeInit();
				reportTypeCountInit();
				reportType_Init();
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
		return promiseDeepReportTypeGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestReportTypeGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestReportTypeGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainReportTypeGenPage(v);
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
	public Object obtainReportTypeGenPage(String var) {
		ReportTypeGenPage oReportTypeGenPage = (ReportTypeGenPage)this;
		switch(var) {
			case "searchListReportType_":
				return oReportTypeGenPage.searchListReportType_;
			case "listReportType":
				return oReportTypeGenPage.listReportType;
			case "reportTypeCount":
				return oReportTypeGenPage.reportTypeCount;
			case "reportType_":
				return oReportTypeGenPage.reportType_;
			case "pk":
				return oReportTypeGenPage.pk;
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
				o = relateReportTypeGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateReportTypeGenPage(String var, Object val) {
		ReportTypeGenPage oReportTypeGenPage = (ReportTypeGenPage)this;
		switch(var) {
			default:
				return super.relateBaseModelPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetReportTypeGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetReportTypeGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "reportTypeCount":
			return ReportTypeGenPage.staticSetReportTypeCount(siteRequest_, o);
		case "pk":
			return ReportTypeGenPage.staticSetPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSetBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchReportTypeGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchReportTypeGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "reportTypeCount":
			return ReportTypeGenPage.staticSearchReportTypeCount(siteRequest_, (Integer)o);
		case "pk":
			return ReportTypeGenPage.staticSearchPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSearchBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrReportTypeGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrReportTypeGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "reportTypeCount":
			return ReportTypeGenPage.staticSearchStrReportTypeCount(siteRequest_, (Integer)o);
		case "pk":
			return ReportTypeGenPage.staticSearchStrPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSearchStrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqReportTypeGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqReportTypeGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "reportTypeCount":
			return ReportTypeGenPage.staticSearchFqReportTypeCount(siteRequest_, o);
		case "pk":
			return ReportTypeGenPage.staticSearchFqPk(siteRequest_, o);
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

	public static final String VAR_searchListReportType_ = "searchListReportType_";
	public static final String VAR_listReportType = "listReportType";
	public static final String VAR_reportTypeCount = "reportTypeCount";
	public static final String VAR_reportType_ = "reportType_";
	public static final String VAR_pk = "pk";

	public static final String DISPLAY_NAME_searchListReportType_ = "";
	public static final String DISPLAY_NAME_listReportType = "";
	public static final String DISPLAY_NAME_reportTypeCount = "";
	public static final String DISPLAY_NAME_reportType_ = "";
	public static final String DISPLAY_NAME_pk = "";

	public static String displayNameForClass(String var) {
		return ReportTypeGenPage.displayNameReportTypeGenPage(var);
	}
	public static String displayNameReportTypeGenPage(String var) {
		switch(var) {
		case VAR_searchListReportType_:
			return DISPLAY_NAME_searchListReportType_;
		case VAR_listReportType:
			return DISPLAY_NAME_listReportType;
		case VAR_reportTypeCount:
			return DISPLAY_NAME_reportTypeCount;
		case VAR_reportType_:
			return DISPLAY_NAME_reportType_;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		default:
			return BaseModelPage.displayNameBaseModelPage(var);
		}
	}
}
