package org.choicehumanitarian.reports.enus.model.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.choicehumanitarian.reports.enus.base.BaseModelPage;
import org.choicehumanitarian.reports.enus.search.SearchList;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.choicehumanitarian.reports.enus.wrap.Wrap;
import org.apache.commons.collections.CollectionUtils;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.choicehumanitarian.reports.enus.java.ZonedDateTimeSerializer;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.String;
import java.math.RoundingMode;
import org.choicehumanitarian.reports.enus.request.api.ApiRequest;
import org.slf4j.Logger;
import java.math.MathContext;
import org.choicehumanitarian.reports.enus.java.ZonedDateTimeDeserializer;
import io.vertx.core.Promise;
import org.choicehumanitarian.reports.enus.java.LocalDateSerializer;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.choicehumanitarian.reports.enus.model.report.ChoiceReport;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.choicehumanitarian.reports.enus.base.BaseModel;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReportGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class ChoiceReportGenPageGen<DEV> extends BaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(ChoiceReportGenPage.class);

	/////////////////////////////
	// searchListChoiceReport_ //
	/////////////////////////////

	/**	 The entity searchListChoiceReport_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ChoiceReport> searchListChoiceReport_;

	/**	<br/> The entity searchListChoiceReport_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReportGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListChoiceReport_">Find the entity searchListChoiceReport_ in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListChoiceReport_(Wrap<SearchList<ChoiceReport>> w);

	public SearchList<ChoiceReport> getSearchListChoiceReport_() {
		return searchListChoiceReport_;
	}

	public void setSearchListChoiceReport_(SearchList<ChoiceReport> searchListChoiceReport_) {
		this.searchListChoiceReport_ = searchListChoiceReport_;
	}
	public static SearchList<ChoiceReport> staticSetSearchListChoiceReport_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceReportGenPage searchListChoiceReport_Init() {
		Wrap<SearchList<ChoiceReport>> searchListChoiceReport_Wrap = new Wrap<SearchList<ChoiceReport>>().var("searchListChoiceReport_");
		if(searchListChoiceReport_ == null) {
			_searchListChoiceReport_(searchListChoiceReport_Wrap);
			setSearchListChoiceReport_(searchListChoiceReport_Wrap.o);
		}
		return (ChoiceReportGenPage)this;
	}

	//////////////////////
	// listChoiceReport //
	//////////////////////

	/**	 The entity listChoiceReport
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut JsonArray(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listChoiceReport = new JsonArray();

	/**	<br/> The entity listChoiceReport
	 *  It is constructed before being initialized with the constructor by default JsonArray(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReportGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listChoiceReport">Find the entity listChoiceReport in Solr</a>
	 * <br/>
	 * @param listChoiceReport is the entity already constructed. 
	 **/
	protected abstract void _listChoiceReport(JsonArray l);

	public JsonArray getListChoiceReport() {
		return listChoiceReport;
	}

	public void setListChoiceReport(JsonArray listChoiceReport) {
		this.listChoiceReport = listChoiceReport;
	}
	public static JsonArray staticSetListChoiceReport(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceReportGenPage listChoiceReportInit() {
		_listChoiceReport(listChoiceReport);
		return (ChoiceReportGenPage)this;
	}

	///////////////////////
	// choiceReportCount //
	///////////////////////

	/**	 The entity choiceReportCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer choiceReportCount;

	/**	<br/> The entity choiceReportCount
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReportGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:choiceReportCount">Find the entity choiceReportCount in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _choiceReportCount(Wrap<Integer> w);

	public Integer getChoiceReportCount() {
		return choiceReportCount;
	}

	public void setChoiceReportCount(Integer choiceReportCount) {
		this.choiceReportCount = choiceReportCount;
	}
	@JsonIgnore
	public void setChoiceReportCount(String o) {
		this.choiceReportCount = ChoiceReportGenPage.staticSetChoiceReportCount(siteRequest_, o);
	}
	public static Integer staticSetChoiceReportCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ChoiceReportGenPage choiceReportCountInit() {
		Wrap<Integer> choiceReportCountWrap = new Wrap<Integer>().var("choiceReportCount");
		if(choiceReportCount == null) {
			_choiceReportCount(choiceReportCountWrap);
			setChoiceReportCount(choiceReportCountWrap.o);
		}
		return (ChoiceReportGenPage)this;
	}

	public static Integer staticSolrChoiceReportCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrChoiceReportCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqChoiceReportCount(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReportGenPage.staticSolrStrChoiceReportCount(siteRequest_, ChoiceReportGenPage.staticSolrChoiceReportCount(siteRequest_, ChoiceReportGenPage.staticSetChoiceReportCount(siteRequest_, o)));
	}

	///////////////////
	// choiceReport_ //
	///////////////////

	/**	 The entity choiceReport_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ChoiceReport choiceReport_;

	/**	<br/> The entity choiceReport_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReportGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:choiceReport_">Find the entity choiceReport_ in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _choiceReport_(Wrap<ChoiceReport> w);

	public ChoiceReport getChoiceReport_() {
		return choiceReport_;
	}

	public void setChoiceReport_(ChoiceReport choiceReport_) {
		this.choiceReport_ = choiceReport_;
	}
	public static ChoiceReport staticSetChoiceReport_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceReportGenPage choiceReport_Init() {
		Wrap<ChoiceReport> choiceReport_Wrap = new Wrap<ChoiceReport>().var("choiceReport_");
		if(choiceReport_ == null) {
			_choiceReport_(choiceReport_Wrap);
			setChoiceReport_(choiceReport_Wrap.o);
		}
		return (ChoiceReportGenPage)this;
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

	/**	<br/> The entity pk
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReportGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
	 * <br/>
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
		this.pk = ChoiceReportGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ChoiceReportGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (ChoiceReportGenPage)this;
	}

	public static Long staticSolrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPk(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReportGenPage.staticSolrStrPk(siteRequest_, ChoiceReportGenPage.staticSolrPk(siteRequest_, ChoiceReportGenPage.staticSetPk(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepChoiceReportGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepChoiceReportGenPage();
	}

	public Future<Void> promiseDeepChoiceReportGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseChoiceReportGenPage(promise2);
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

	public Future<Void> promiseChoiceReportGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListChoiceReport_Init();
				listChoiceReportInit();
				choiceReportCountInit();
				choiceReport_Init();
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
		return promiseDeepChoiceReportGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestChoiceReportGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestChoiceReportGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainChoiceReportGenPage(v);
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
	public Object obtainChoiceReportGenPage(String var) {
		ChoiceReportGenPage oChoiceReportGenPage = (ChoiceReportGenPage)this;
		switch(var) {
			case "searchListChoiceReport_":
				return oChoiceReportGenPage.searchListChoiceReport_;
			case "listChoiceReport":
				return oChoiceReportGenPage.listChoiceReport;
			case "choiceReportCount":
				return oChoiceReportGenPage.choiceReportCount;
			case "choiceReport_":
				return oChoiceReportGenPage.choiceReport_;
			case "pk":
				return oChoiceReportGenPage.pk;
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
				o = relateChoiceReportGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateChoiceReportGenPage(String var, Object val) {
		ChoiceReportGenPage oChoiceReportGenPage = (ChoiceReportGenPage)this;
		switch(var) {
			default:
				return super.relateBaseModelPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetChoiceReportGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetChoiceReportGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "choiceReportCount":
			return ChoiceReportGenPage.staticSetChoiceReportCount(siteRequest_, o);
		case "pk":
			return ChoiceReportGenPage.staticSetPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSetBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrChoiceReportGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrChoiceReportGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "choiceReportCount":
			return ChoiceReportGenPage.staticSolrChoiceReportCount(siteRequest_, (Integer)o);
		case "pk":
			return ChoiceReportGenPage.staticSolrPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSolrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrChoiceReportGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrChoiceReportGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "choiceReportCount":
			return ChoiceReportGenPage.staticSolrStrChoiceReportCount(siteRequest_, (Integer)o);
		case "pk":
			return ChoiceReportGenPage.staticSolrStrPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSolrStrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqChoiceReportGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqChoiceReportGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "choiceReportCount":
			return ChoiceReportGenPage.staticSolrFqChoiceReportCount(siteRequest_, o);
		case "pk":
			return ChoiceReportGenPage.staticSolrFqPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSolrFqBaseModelPage(entityVar,  siteRequest_, o);
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
					o = defineChoiceReportGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineChoiceReportGenPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineBaseModelPage(var, val);
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestChoiceReportGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ChoiceReportGenPage) {
			ChoiceReportGenPage original = (ChoiceReportGenPage)o;
			super.apiRequestBaseModelPage();
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

	public static final String VAR_searchListChoiceReport_ = "searchListChoiceReport_";
	public static final String VAR_listChoiceReport = "listChoiceReport";
	public static final String VAR_choiceReportCount = "choiceReportCount";
	public static final String VAR_choiceReport_ = "choiceReport_";
	public static final String VAR_pk = "pk";
}
