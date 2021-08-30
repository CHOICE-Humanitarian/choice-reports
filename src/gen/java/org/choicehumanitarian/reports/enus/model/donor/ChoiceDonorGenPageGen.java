package org.choicehumanitarian.reports.enus.model.donor;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.choicehumanitarian.reports.enus.search.SearchList;
import org.choicehumanitarian.reports.enus.writer.AllWriter;
import org.apache.commons.lang3.StringUtils;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.choicehumanitarian.reports.enus.model.donor.ChoiceDonor;
import org.choicehumanitarian.reports.enus.wrap.Wrap;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.choicehumanitarian.reports.enus.java.ZonedDateTimeSerializer;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.String;
import java.math.RoundingMode;
import java.lang.Void;
import org.choicehumanitarian.reports.enus.request.api.ApiRequest;
import org.slf4j.Logger;
import java.math.MathContext;
import org.choicehumanitarian.reports.enus.java.ZonedDateTimeDeserializer;
import io.vertx.core.Promise;
import org.choicehumanitarian.reports.enus.java.LocalDateSerializer;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.choicehumanitarian.reports.enus.base.BaseModel;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.Object;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class ChoiceDonorGenPageGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(ChoiceDonorGenPage.class);

	//////////////////
	// siteRequest_ //
	//////////////////

	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SiteRequestEnUS siteRequest_;
	@JsonIgnore
	public Wrap<SiteRequestEnUS> siteRequest_Wrap = new Wrap<SiteRequestEnUS>().var("siteRequest_").o(siteRequest_);

	/**	<br/> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<SiteRequestEnUS> c);

	public SiteRequestEnUS getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(SiteRequestEnUS siteRequest_) {
		this.siteRequest_ = siteRequest_;
		this.siteRequest_Wrap.alreadyInitialized = true;
	}
	public static SiteRequestEnUS staticSetSiteRequest_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceDonorGenPage siteRequest_Init() {
		if(!siteRequest_Wrap.alreadyInitialized) {
			_siteRequest_(siteRequest_Wrap);
			if(siteRequest_ == null)
				setSiteRequest_(siteRequest_Wrap.o);
			siteRequest_Wrap.o(null);
		}
		siteRequest_Wrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	//////////////////////
	// listChoiceDonor_ //
	//////////////////////

	/**	 The entity listChoiceDonor_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ChoiceDonor> listChoiceDonor_;
	@JsonIgnore
	public Wrap<SearchList<ChoiceDonor>> listChoiceDonor_Wrap = new Wrap<SearchList<ChoiceDonor>>().var("listChoiceDonor_").o(listChoiceDonor_);

	/**	<br/> The entity listChoiceDonor_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listChoiceDonor_">Find the entity listChoiceDonor_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _listChoiceDonor_(Wrap<SearchList<ChoiceDonor>> c);

	public SearchList<ChoiceDonor> getListChoiceDonor_() {
		return listChoiceDonor_;
	}

	public void setListChoiceDonor_(SearchList<ChoiceDonor> listChoiceDonor_) {
		this.listChoiceDonor_ = listChoiceDonor_;
		this.listChoiceDonor_Wrap.alreadyInitialized = true;
	}
	public static SearchList<ChoiceDonor> staticSetListChoiceDonor_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceDonorGenPage listChoiceDonor_Init() {
		if(!listChoiceDonor_Wrap.alreadyInitialized) {
			_listChoiceDonor_(listChoiceDonor_Wrap);
			if(listChoiceDonor_ == null)
				setListChoiceDonor_(listChoiceDonor_Wrap.o);
			listChoiceDonor_Wrap.o(null);
		}
		listChoiceDonor_Wrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	//////////////////
	// choiceDonor_ //
	//////////////////

	/**	 The entity choiceDonor_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ChoiceDonor choiceDonor_;
	@JsonIgnore
	public Wrap<ChoiceDonor> choiceDonor_Wrap = new Wrap<ChoiceDonor>().var("choiceDonor_").o(choiceDonor_);

	/**	<br/> The entity choiceDonor_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:choiceDonor_">Find the entity choiceDonor_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _choiceDonor_(Wrap<ChoiceDonor> c);

	public ChoiceDonor getChoiceDonor_() {
		return choiceDonor_;
	}

	public void setChoiceDonor_(ChoiceDonor choiceDonor_) {
		this.choiceDonor_ = choiceDonor_;
		this.choiceDonor_Wrap.alreadyInitialized = true;
	}
	public static ChoiceDonor staticSetChoiceDonor_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceDonorGenPage choiceDonor_Init() {
		if(!choiceDonor_Wrap.alreadyInitialized) {
			_choiceDonor_(choiceDonor_Wrap);
			if(choiceDonor_ == null)
				setChoiceDonor_(choiceDonor_Wrap.o);
			choiceDonor_Wrap.o(null);
		}
		choiceDonor_Wrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	///////////////////
	// promiseBefore //
	///////////////////

	/**	 The entity promiseBefore
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Void promiseBefore;
	@JsonIgnore
	public Wrap<Void> promiseBeforeWrap = new Wrap<Void>().var("promiseBefore").o(promiseBefore);

	/**	<br/> The entity promiseBefore
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:promiseBefore">Find the entity promiseBefore in Solr</a>
	 * <br/>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _promiseBefore(Promise<Void> promise);

	public Void getPromiseBefore() {
		return promiseBefore;
	}

	public void setPromiseBefore(Void promiseBefore) {
		this.promiseBefore = promiseBefore;
		this.promiseBeforeWrap.alreadyInitialized = true;
	}
	public static Void staticSetPromiseBefore(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<Void> promiseBeforePromise() {
		Promise<Void> promise = Promise.promise();
		if(!promiseBeforeWrap.alreadyInitialized) {
			Promise<Void> promise2 = Promise.promise();
			_promiseBefore(promise2);
			promise2.future().onSuccess(o -> {
				setPromiseBefore(o);
				promiseBeforeWrap.alreadyInitialized(true);
				promise.complete(o);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} else {
			promise.complete();
		}
		return promise.future();
	}

	////////////
	// pageH1 //
	////////////

	/**	 The entity pageH1
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageH1;
	@JsonIgnore
	public Wrap<String> pageH1Wrap = new Wrap<String>().var("pageH1").o(pageH1);

	/**	<br/> The entity pageH1
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH1">Find the entity pageH1 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH1(Wrap<String> c);

	public String getPageH1() {
		return pageH1;
	}
	public void setPageH1(String o) {
		this.pageH1 = ChoiceDonorGenPage.staticSetPageH1(siteRequest_, o);
		this.pageH1Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceDonorGenPage pageH1Init() {
		if(!pageH1Wrap.alreadyInitialized) {
			_pageH1(pageH1Wrap);
			if(pageH1 == null)
				setPageH1(pageH1Wrap.o);
			pageH1Wrap.o(null);
		}
		pageH1Wrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	public static String staticSolrPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH1(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceDonorGenPage.staticSolrStrPageH1(siteRequest_, ChoiceDonorGenPage.staticSolrPageH1(siteRequest_, ChoiceDonorGenPage.staticSetPageH1(siteRequest_, o)));
	}

	public String solrPageH1() {
		return ChoiceDonorGenPage.staticSolrPageH1(siteRequest_, pageH1);
	}

	public String strPageH1() {
		return pageH1 == null ? "" : pageH1;
	}

	public String sqlPageH1() {
		return pageH1;
	}

	public String jsonPageH1() {
		return pageH1 == null ? "" : pageH1;
	}

	////////////
	// pageH2 //
	////////////

	/**	 The entity pageH2
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageH2;
	@JsonIgnore
	public Wrap<String> pageH2Wrap = new Wrap<String>().var("pageH2").o(pageH2);

	/**	<br/> The entity pageH2
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH2">Find the entity pageH2 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH2(Wrap<String> c);

	public String getPageH2() {
		return pageH2;
	}
	public void setPageH2(String o) {
		this.pageH2 = ChoiceDonorGenPage.staticSetPageH2(siteRequest_, o);
		this.pageH2Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceDonorGenPage pageH2Init() {
		if(!pageH2Wrap.alreadyInitialized) {
			_pageH2(pageH2Wrap);
			if(pageH2 == null)
				setPageH2(pageH2Wrap.o);
			pageH2Wrap.o(null);
		}
		pageH2Wrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	public static String staticSolrPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH2(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH2(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceDonorGenPage.staticSolrStrPageH2(siteRequest_, ChoiceDonorGenPage.staticSolrPageH2(siteRequest_, ChoiceDonorGenPage.staticSetPageH2(siteRequest_, o)));
	}

	public String solrPageH2() {
		return ChoiceDonorGenPage.staticSolrPageH2(siteRequest_, pageH2);
	}

	public String strPageH2() {
		return pageH2 == null ? "" : pageH2;
	}

	public String sqlPageH2() {
		return pageH2;
	}

	public String jsonPageH2() {
		return pageH2 == null ? "" : pageH2;
	}

	////////////
	// pageH3 //
	////////////

	/**	 The entity pageH3
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageH3;
	@JsonIgnore
	public Wrap<String> pageH3Wrap = new Wrap<String>().var("pageH3").o(pageH3);

	/**	<br/> The entity pageH3
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH3">Find the entity pageH3 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH3(Wrap<String> c);

	public String getPageH3() {
		return pageH3;
	}
	public void setPageH3(String o) {
		this.pageH3 = ChoiceDonorGenPage.staticSetPageH3(siteRequest_, o);
		this.pageH3Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceDonorGenPage pageH3Init() {
		if(!pageH3Wrap.alreadyInitialized) {
			_pageH3(pageH3Wrap);
			if(pageH3 == null)
				setPageH3(pageH3Wrap.o);
			pageH3Wrap.o(null);
		}
		pageH3Wrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	public static String staticSolrPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH3(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH3(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceDonorGenPage.staticSolrStrPageH3(siteRequest_, ChoiceDonorGenPage.staticSolrPageH3(siteRequest_, ChoiceDonorGenPage.staticSetPageH3(siteRequest_, o)));
	}

	public String solrPageH3() {
		return ChoiceDonorGenPage.staticSolrPageH3(siteRequest_, pageH3);
	}

	public String strPageH3() {
		return pageH3 == null ? "" : pageH3;
	}

	public String sqlPageH3() {
		return pageH3;
	}

	public String jsonPageH3() {
		return pageH3 == null ? "" : pageH3;
	}

	///////////////
	// pageTitle //
	///////////////

	/**	 The entity pageTitle
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageTitle;
	@JsonIgnore
	public Wrap<String> pageTitleWrap = new Wrap<String>().var("pageTitle").o(pageTitle);

	/**	<br/> The entity pageTitle
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageTitle">Find the entity pageTitle in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageTitle(Wrap<String> c);

	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String o) {
		this.pageTitle = ChoiceDonorGenPage.staticSetPageTitle(siteRequest_, o);
		this.pageTitleWrap.alreadyInitialized = true;
	}
	public static String staticSetPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceDonorGenPage pageTitleInit() {
		if(!pageTitleWrap.alreadyInitialized) {
			_pageTitle(pageTitleWrap);
			if(pageTitle == null)
				setPageTitle(pageTitleWrap.o);
			pageTitleWrap.o(null);
		}
		pageTitleWrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	public static String staticSolrPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageTitle(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceDonorGenPage.staticSolrStrPageTitle(siteRequest_, ChoiceDonorGenPage.staticSolrPageTitle(siteRequest_, ChoiceDonorGenPage.staticSetPageTitle(siteRequest_, o)));
	}

	public String solrPageTitle() {
		return ChoiceDonorGenPage.staticSolrPageTitle(siteRequest_, pageTitle);
	}

	public String strPageTitle() {
		return pageTitle == null ? "" : pageTitle;
	}

	public String sqlPageTitle() {
		return pageTitle;
	}

	public String jsonPageTitle() {
		return pageTitle == null ? "" : pageTitle;
	}

	/////////////
	// pageUri //
	/////////////

	/**	 The entity pageUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUri;
	@JsonIgnore
	public Wrap<String> pageUriWrap = new Wrap<String>().var("pageUri").o(pageUri);

	/**	<br/> The entity pageUri
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUri">Find the entity pageUri in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUri(Wrap<String> c);

	public String getPageUri() {
		return pageUri;
	}
	public void setPageUri(String o) {
		this.pageUri = ChoiceDonorGenPage.staticSetPageUri(siteRequest_, o);
		this.pageUriWrap.alreadyInitialized = true;
	}
	public static String staticSetPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceDonorGenPage pageUriInit() {
		if(!pageUriWrap.alreadyInitialized) {
			_pageUri(pageUriWrap);
			if(pageUri == null)
				setPageUri(pageUriWrap.o);
			pageUriWrap.o(null);
		}
		pageUriWrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	public static String staticSolrPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUri(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUri(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceDonorGenPage.staticSolrStrPageUri(siteRequest_, ChoiceDonorGenPage.staticSolrPageUri(siteRequest_, ChoiceDonorGenPage.staticSetPageUri(siteRequest_, o)));
	}

	public String solrPageUri() {
		return ChoiceDonorGenPage.staticSolrPageUri(siteRequest_, pageUri);
	}

	public String strPageUri() {
		return pageUri == null ? "" : pageUri;
	}

	public String sqlPageUri() {
		return pageUri;
	}

	public String jsonPageUri() {
		return pageUri == null ? "" : pageUri;
	}

	////////////////
	// pagination //
	////////////////

	/**	 The entity pagination
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut JsonObject(). 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject pagination = new JsonObject();
	@JsonIgnore
	public Wrap<JsonObject> paginationWrap = new Wrap<JsonObject>().var("pagination").o(pagination);

	/**	<br/> The entity pagination
	 *  It is constructed before being initialized with the constructor by default JsonObject(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pagination">Find the entity pagination in Solr</a>
	 * <br/>
	 * @param pagination is the entity already constructed. 
	 **/
	protected abstract void _pagination(JsonObject pagination);

	public JsonObject getPagination() {
		return pagination;
	}

	public void setPagination(JsonObject pagination) {
		this.pagination = pagination;
		this.paginationWrap.alreadyInitialized = true;
	}
	public static JsonObject staticSetPagination(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceDonorGenPage paginationInit() {
		if(!paginationWrap.alreadyInitialized) {
			_pagination(pagination);
		}
		paginationWrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	///////////
	// query //
	///////////

	/**	 The entity query
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut JsonObject(). 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject query = new JsonObject();
	@JsonIgnore
	public Wrap<JsonObject> queryWrap = new Wrap<JsonObject>().var("query").o(query);

	/**	<br/> The entity query
	 *  It is constructed before being initialized with the constructor by default JsonObject(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:query">Find the entity query in Solr</a>
	 * <br/>
	 * @param query is the entity already constructed. 
	 **/
	protected abstract void _query(JsonObject query);

	public JsonObject getQuery() {
		return query;
	}

	public void setQuery(JsonObject query) {
		this.query = query;
		this.queryWrap.alreadyInitialized = true;
	}
	public static JsonObject staticSetQuery(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceDonorGenPage queryInit() {
		if(!queryWrap.alreadyInitialized) {
			_query(query);
		}
		queryWrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	//////////////////
	// promiseAfter //
	//////////////////

	/**	 The entity promiseAfter
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Void promiseAfter;
	@JsonIgnore
	public Wrap<Void> promiseAfterWrap = new Wrap<Void>().var("promiseAfter").o(promiseAfter);

	/**	<br/> The entity promiseAfter
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:promiseAfter">Find the entity promiseAfter in Solr</a>
	 * <br/>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _promiseAfter(Promise<Void> promise);

	public Void getPromiseAfter() {
		return promiseAfter;
	}

	public void setPromiseAfter(Void promiseAfter) {
		this.promiseAfter = promiseAfter;
		this.promiseAfterWrap.alreadyInitialized = true;
	}
	public static Void staticSetPromiseAfter(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<Void> promiseAfterPromise() {
		Promise<Void> promise = Promise.promise();
		if(!promiseAfterWrap.alreadyInitialized) {
			Promise<Void> promise2 = Promise.promise();
			_promiseAfter(promise2);
			promise2.future().onSuccess(o -> {
				setPromiseAfter(o);
				promiseAfterWrap.alreadyInitialized(true);
				promise.complete(o);
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} else {
			promise.complete();
		}
		return promise.future();
	}

	//////////////////
	// pageImageUri //
	//////////////////

	/**	 The entity pageImageUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageImageUri;
	@JsonIgnore
	public Wrap<String> pageImageUriWrap = new Wrap<String>().var("pageImageUri").o(pageImageUri);

	/**	<br/> The entity pageImageUri
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageImageUri">Find the entity pageImageUri in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageImageUri(Wrap<String> c);

	public String getPageImageUri() {
		return pageImageUri;
	}
	public void setPageImageUri(String o) {
		this.pageImageUri = ChoiceDonorGenPage.staticSetPageImageUri(siteRequest_, o);
		this.pageImageUriWrap.alreadyInitialized = true;
	}
	public static String staticSetPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceDonorGenPage pageImageUriInit() {
		if(!pageImageUriWrap.alreadyInitialized) {
			_pageImageUri(pageImageUriWrap);
			if(pageImageUri == null)
				setPageImageUri(pageImageUriWrap.o);
			pageImageUriWrap.o(null);
		}
		pageImageUriWrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	public static String staticSolrPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageImageUri(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceDonorGenPage.staticSolrStrPageImageUri(siteRequest_, ChoiceDonorGenPage.staticSolrPageImageUri(siteRequest_, ChoiceDonorGenPage.staticSetPageImageUri(siteRequest_, o)));
	}

	public String solrPageImageUri() {
		return ChoiceDonorGenPage.staticSolrPageImageUri(siteRequest_, pageImageUri);
	}

	public String strPageImageUri() {
		return pageImageUri == null ? "" : pageImageUri;
	}

	public String sqlPageImageUri() {
		return pageImageUri;
	}

	public String jsonPageImageUri() {
		return pageImageUri == null ? "" : pageImageUri;
	}

	//////////////////////
	// contextIconGroup //
	//////////////////////

	/**	 The entity contextIconGroup
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String contextIconGroup;
	@JsonIgnore
	public Wrap<String> contextIconGroupWrap = new Wrap<String>().var("contextIconGroup").o(contextIconGroup);

	/**	<br/> The entity contextIconGroup
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconGroup">Find the entity contextIconGroup in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconGroup(Wrap<String> c);

	public String getContextIconGroup() {
		return contextIconGroup;
	}
	public void setContextIconGroup(String o) {
		this.contextIconGroup = ChoiceDonorGenPage.staticSetContextIconGroup(siteRequest_, o);
		this.contextIconGroupWrap.alreadyInitialized = true;
	}
	public static String staticSetContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceDonorGenPage contextIconGroupInit() {
		if(!contextIconGroupWrap.alreadyInitialized) {
			_contextIconGroup(contextIconGroupWrap);
			if(contextIconGroup == null)
				setContextIconGroup(contextIconGroupWrap.o);
			contextIconGroupWrap.o(null);
		}
		contextIconGroupWrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	public static String staticSolrContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContextIconGroup(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceDonorGenPage.staticSolrStrContextIconGroup(siteRequest_, ChoiceDonorGenPage.staticSolrContextIconGroup(siteRequest_, ChoiceDonorGenPage.staticSetContextIconGroup(siteRequest_, o)));
	}

	public String solrContextIconGroup() {
		return ChoiceDonorGenPage.staticSolrContextIconGroup(siteRequest_, contextIconGroup);
	}

	public String strContextIconGroup() {
		return contextIconGroup == null ? "" : contextIconGroup;
	}

	public String sqlContextIconGroup() {
		return contextIconGroup;
	}

	public String jsonContextIconGroup() {
		return contextIconGroup == null ? "" : contextIconGroup;
	}

	/////////////////////
	// contextIconName //
	/////////////////////

	/**	 The entity contextIconName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String contextIconName;
	@JsonIgnore
	public Wrap<String> contextIconNameWrap = new Wrap<String>().var("contextIconName").o(contextIconName);

	/**	<br/> The entity contextIconName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconName">Find the entity contextIconName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconName(Wrap<String> c);

	public String getContextIconName() {
		return contextIconName;
	}
	public void setContextIconName(String o) {
		this.contextIconName = ChoiceDonorGenPage.staticSetContextIconName(siteRequest_, o);
		this.contextIconNameWrap.alreadyInitialized = true;
	}
	public static String staticSetContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceDonorGenPage contextIconNameInit() {
		if(!contextIconNameWrap.alreadyInitialized) {
			_contextIconName(contextIconNameWrap);
			if(contextIconName == null)
				setContextIconName(contextIconNameWrap.o);
			contextIconNameWrap.o(null);
		}
		contextIconNameWrap.alreadyInitialized(true);
		return (ChoiceDonorGenPage)this;
	}

	public static String staticSolrContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContextIconName(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceDonorGenPage.staticSolrStrContextIconName(siteRequest_, ChoiceDonorGenPage.staticSolrContextIconName(siteRequest_, ChoiceDonorGenPage.staticSetContextIconName(siteRequest_, o)));
	}

	public String solrContextIconName() {
		return ChoiceDonorGenPage.staticSolrContextIconName(siteRequest_, contextIconName);
	}

	public String strContextIconName() {
		return contextIconName == null ? "" : contextIconName;
	}

	public String sqlContextIconName() {
		return contextIconName;
	}

	public String jsonContextIconName() {
		return contextIconName == null ? "" : contextIconName;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedChoiceDonorGenPage = false;

	public Future<Void> promiseDeepChoiceDonorGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedChoiceDonorGenPage) {
			alreadyInitializedChoiceDonorGenPage = true;
			return promiseDeepChoiceDonorGenPage();
		} else {
			return Future.succeededFuture();
		}
	}

	public Future<Void> promiseDeepChoiceDonorGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseChoiceDonorGenPage(promise2);
		promise2.future().onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseChoiceDonorGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				siteRequest_Init();
				listChoiceDonor_Init();
				choiceDonor_Init();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			promiseBeforePromise().onSuccess(promiseBefore -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				pageH1Init();
				pageH2Init();
				pageH3Init();
				pageTitleInit();
				pageUriInit();
				paginationInit();
				queryInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			promiseAfterPromise().onSuccess(promiseAfter -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				pageImageUriInit();
				contextIconGroupInit();
				contextIconNameInit();
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

	public Future<Void> promiseDeepForClass(SiteRequestEnUS siteRequest_) {
		return promiseDeepChoiceDonorGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestChoiceDonorGenPage(SiteRequestEnUS siteRequest_) {
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestChoiceDonorGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainChoiceDonorGenPage(v);
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
	public Object obtainChoiceDonorGenPage(String var) {
		ChoiceDonorGenPage oChoiceDonorGenPage = (ChoiceDonorGenPage)this;
		switch(var) {
			case "siteRequest_":
				return oChoiceDonorGenPage.siteRequest_;
			case "listChoiceDonor_":
				return oChoiceDonorGenPage.listChoiceDonor_;
			case "choiceDonor_":
				return oChoiceDonorGenPage.choiceDonor_;
			case "promiseBefore":
				return oChoiceDonorGenPage.promiseBefore;
			case "pageH1":
				return oChoiceDonorGenPage.pageH1;
			case "pageH2":
				return oChoiceDonorGenPage.pageH2;
			case "pageH3":
				return oChoiceDonorGenPage.pageH3;
			case "pageTitle":
				return oChoiceDonorGenPage.pageTitle;
			case "pageUri":
				return oChoiceDonorGenPage.pageUri;
			case "pagination":
				return oChoiceDonorGenPage.pagination;
			case "query":
				return oChoiceDonorGenPage.query;
			case "promiseAfter":
				return oChoiceDonorGenPage.promiseAfter;
			case "pageImageUri":
				return oChoiceDonorGenPage.pageImageUri;
			case "contextIconGroup":
				return oChoiceDonorGenPage.contextIconGroup;
			case "contextIconName":
				return oChoiceDonorGenPage.contextIconName;
			default:
				return null;
		}
	}

	///////////////
	// attribute //
	///////////////

	public boolean attributeForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attributeChoiceDonorGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeChoiceDonorGenPage(String var, Object val) {
		ChoiceDonorGenPage oChoiceDonorGenPage = (ChoiceDonorGenPage)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetChoiceDonorGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetChoiceDonorGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageH1":
			return ChoiceDonorGenPage.staticSetPageH1(siteRequest_, o);
		case "pageH2":
			return ChoiceDonorGenPage.staticSetPageH2(siteRequest_, o);
		case "pageH3":
			return ChoiceDonorGenPage.staticSetPageH3(siteRequest_, o);
		case "pageTitle":
			return ChoiceDonorGenPage.staticSetPageTitle(siteRequest_, o);
		case "pageUri":
			return ChoiceDonorGenPage.staticSetPageUri(siteRequest_, o);
		case "pageImageUri":
			return ChoiceDonorGenPage.staticSetPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return ChoiceDonorGenPage.staticSetContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return ChoiceDonorGenPage.staticSetContextIconName(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrChoiceDonorGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrChoiceDonorGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageH1":
			return ChoiceDonorGenPage.staticSolrPageH1(siteRequest_, (String)o);
		case "pageH2":
			return ChoiceDonorGenPage.staticSolrPageH2(siteRequest_, (String)o);
		case "pageH3":
			return ChoiceDonorGenPage.staticSolrPageH3(siteRequest_, (String)o);
		case "pageTitle":
			return ChoiceDonorGenPage.staticSolrPageTitle(siteRequest_, (String)o);
		case "pageUri":
			return ChoiceDonorGenPage.staticSolrPageUri(siteRequest_, (String)o);
		case "pageImageUri":
			return ChoiceDonorGenPage.staticSolrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return ChoiceDonorGenPage.staticSolrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return ChoiceDonorGenPage.staticSolrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrChoiceDonorGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrChoiceDonorGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageH1":
			return ChoiceDonorGenPage.staticSolrStrPageH1(siteRequest_, (String)o);
		case "pageH2":
			return ChoiceDonorGenPage.staticSolrStrPageH2(siteRequest_, (String)o);
		case "pageH3":
			return ChoiceDonorGenPage.staticSolrStrPageH3(siteRequest_, (String)o);
		case "pageTitle":
			return ChoiceDonorGenPage.staticSolrStrPageTitle(siteRequest_, (String)o);
		case "pageUri":
			return ChoiceDonorGenPage.staticSolrStrPageUri(siteRequest_, (String)o);
		case "pageImageUri":
			return ChoiceDonorGenPage.staticSolrStrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return ChoiceDonorGenPage.staticSolrStrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return ChoiceDonorGenPage.staticSolrStrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqChoiceDonorGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqChoiceDonorGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageH1":
			return ChoiceDonorGenPage.staticSolrFqPageH1(siteRequest_, o);
		case "pageH2":
			return ChoiceDonorGenPage.staticSolrFqPageH2(siteRequest_, o);
		case "pageH3":
			return ChoiceDonorGenPage.staticSolrFqPageH3(siteRequest_, o);
		case "pageTitle":
			return ChoiceDonorGenPage.staticSolrFqPageTitle(siteRequest_, o);
		case "pageUri":
			return ChoiceDonorGenPage.staticSolrFqPageUri(siteRequest_, o);
		case "pageImageUri":
			return ChoiceDonorGenPage.staticSolrFqPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return ChoiceDonorGenPage.staticSolrFqContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return ChoiceDonorGenPage.staticSolrFqContextIconName(siteRequest_, o);
			default:
				return null;
		}
	}

	/////////////
	// define //
	/////////////

	public boolean defineForClass(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineChoiceDonorGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineChoiceDonorGenPage(String var, String val) {
		switch(var.toLowerCase()) {
			default:
				return null;
		}
	}

	public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineChoiceDonorGenPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineChoiceDonorGenPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return null;
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestChoiceDonorGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ChoiceDonorGenPage) {
			ChoiceDonorGenPage original = (ChoiceDonorGenPage)o;
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash();
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof ChoiceDonorGenPage))
			return false;
		ChoiceDonorGenPage that = (ChoiceDonorGenPage)o;
		return true;
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ChoiceDonorGenPage { ");
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_listChoiceDonor_ = "listChoiceDonor_";
	public static final String VAR_choiceDonor_ = "choiceDonor_";
	public static final String VAR_promiseBefore = "promiseBefore";
	public static final String VAR_pageH1 = "pageH1";
	public static final String VAR_pageH2 = "pageH2";
	public static final String VAR_pageH3 = "pageH3";
	public static final String VAR_pageTitle = "pageTitle";
	public static final String VAR_pageUri = "pageUri";
	public static final String VAR_pagination = "pagination";
	public static final String VAR_query = "query";
	public static final String VAR_promiseAfter = "promiseAfter";
	public static final String VAR_pageImageUri = "pageImageUri";
	public static final String VAR_contextIconGroup = "contextIconGroup";
	public static final String VAR_contextIconName = "contextIconName";
}
