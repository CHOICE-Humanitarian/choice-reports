package org.choicehumanitarian.reports.enus.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.search.response.solr.SolrResponse;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.choicehumanitarian.reports.enus.java.ZonedDateTimeSerializer;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Boolean;
import io.vertx.core.json.JsonObject;
import java.math.RoundingMode;
import org.choicehumanitarian.reports.enus.request.api.ApiRequest;
import org.slf4j.Logger;
import java.math.MathContext;
import org.choicehumanitarian.reports.enus.java.ZonedDateTimeDeserializer;
import io.vertx.core.Promise;
import org.choicehumanitarian.reports.enus.java.LocalDateSerializer;
import org.computate.search.response.solr.SolrResponse.Doc;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.computate.search.request.SearchRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.choicehumanitarian.reports.enus.base.BaseModel;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import java.util.List;
import org.computate.search.wrap.Wrap;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.Class;
import java.lang.Object;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.search.SearchList&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class SearchListGen<DEV> {
	protected static final Logger LOG = LoggerFactory.getLogger(SearchList.class);

	///////
	// c //
	///////

	/**	 The entity c
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Class<?> c;

	/**	<br> The entity c
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.search.SearchList&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:c">Find the entity c in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _c(Wrap<Class<?>> c);

	public Class<?> getC() {
		return c;
	}

	public void setC(Class<?> c) {
		this.c = c;
	}
	public static Class<?> staticSetC(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SearchList cInit() {
		Wrap<Class<?>> cWrap = new Wrap<Class<?>>().var("c");
		if(c == null) {
			_c(cWrap);
			setC(cWrap.o);
		}
		return (SearchList)this;
	}

	/////////////
	// request //
	/////////////

	/**	 The entity request
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected SearchRequest request = new SearchRequest();

	/**	<br> The entity request
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.search.SearchList&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:request">Find the entity request in Solr</a>
	 * <br>
	 * @param o is the entity already constructed. 
	 **/
	protected abstract void _request(SearchRequest o);

	public SearchRequest getRequest() {
		return request;
	}

	public void setRequest(SearchRequest request) {
		this.request = request;
	}
	public static SearchRequest staticSetRequest(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SearchList requestInit() {
		_request(request);
		return (SearchList)this;
	}

	//////////////////
	// siteRequest_ //
	//////////////////

	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SiteRequestEnUS siteRequest_;

	/**	<br> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.search.SearchList&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<SiteRequestEnUS> c);

	public SiteRequestEnUS getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(SiteRequestEnUS siteRequest_) {
		this.siteRequest_ = siteRequest_;
	}
	public static SiteRequestEnUS staticSetSiteRequest_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SearchList siteRequest_Init() {
		Wrap<SiteRequestEnUS> siteRequest_Wrap = new Wrap<SiteRequestEnUS>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
		}
		return (SearchList)this;
	}

	///////////
	// store //
	///////////

	/**	 The entity store
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Boolean store;

	/**	<br> The entity store
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.search.SearchList&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:store">Find the entity store in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _store(Wrap<Boolean> c);

	public Boolean getStore() {
		return store;
	}

	public void setStore(Boolean store) {
		this.store = store;
	}
	@JsonIgnore
	public void setStore(String o) {
		this.store = SearchList.staticSetStore(siteRequest_, o);
	}
	public static Boolean staticSetStore(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SearchList storeInit() {
		Wrap<Boolean> storeWrap = new Wrap<Boolean>().var("store");
		if(store == null) {
			_store(storeWrap);
			setStore(storeWrap.o);
		}
		return (SearchList)this;
	}

	public static Boolean staticSolrStore(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrStore(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqStore(SiteRequestEnUS siteRequest_, String o) {
		return SearchList.staticSolrStrStore(siteRequest_, SearchList.staticSolrStore(siteRequest_, SearchList.staticSetStore(siteRequest_, o)));
	}

	//////////////
	// populate //
	//////////////

	/**	 The entity populate
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Boolean populate;

	/**	<br> The entity populate
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.search.SearchList&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:populate">Find the entity populate in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _populate(Wrap<Boolean> c);

	public Boolean getPopulate() {
		return populate;
	}

	public void setPopulate(Boolean populate) {
		this.populate = populate;
	}
	@JsonIgnore
	public void setPopulate(String o) {
		this.populate = SearchList.staticSetPopulate(siteRequest_, o);
	}
	public static Boolean staticSetPopulate(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SearchList populateInit() {
		Wrap<Boolean> populateWrap = new Wrap<Boolean>().var("populate");
		if(populate == null) {
			_populate(populateWrap);
			setPopulate(populateWrap.o);
		}
		return (SearchList)this;
	}

	public static Boolean staticSolrPopulate(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrPopulate(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPopulate(SiteRequestEnUS siteRequest_, String o) {
		return SearchList.staticSolrStrPopulate(siteRequest_, SearchList.staticSolrPopulate(siteRequest_, SearchList.staticSetPopulate(siteRequest_, o)));
	}

	///////////////
	// solrQuery //
	///////////////

	/**	 The entity solrQuery
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected JsonObject solrQuery = new JsonObject();

	/**	<br> The entity solrQuery
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.search.SearchList&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:solrQuery">Find the entity solrQuery in Solr</a>
	 * <br>
	 * @param o is the entity already constructed. 
	 **/
	protected abstract void _solrQuery(JsonObject o);

	public JsonObject getSolrQuery() {
		return solrQuery;
	}

	public void setSolrQuery(JsonObject solrQuery) {
		this.solrQuery = solrQuery;
	}
	public static JsonObject staticSetSolrQuery(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SearchList solrQueryInit() {
		_solrQuery(solrQuery);
		return (SearchList)this;
	}

	///////////////////
	// queryResponse //
	///////////////////

	/**	 The entity queryResponse
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SolrResponse queryResponse;

	/**	<br> The entity queryResponse
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.search.SearchList&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:queryResponse">Find the entity queryResponse in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _queryResponse(Promise<SolrResponse> promise);

	public SolrResponse getQueryResponse() {
		return queryResponse;
	}

	public void setQueryResponse(SolrResponse queryResponse) {
		this.queryResponse = queryResponse;
	}
	public static SolrResponse staticSetQueryResponse(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<SolrResponse> queryResponsePromise() {
		Promise<SolrResponse> promise = Promise.promise();
		Promise<SolrResponse> promise2 = Promise.promise();
		_queryResponse(promise2);
		promise2.future().onSuccess(o -> {
			setQueryResponse(o);
			promise.complete(o);
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	//////////
	// docs //
	//////////

	/**	 The entity docs
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected List<Doc> docs;

	/**	<br> The entity docs
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.search.SearchList&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:docs">Find the entity docs in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _docs(Wrap<List<Doc>> w);

	public List<Doc> getDocs() {
		return docs;
	}

	public void setDocs(List<Doc> docs) {
		this.docs = docs;
	}
	public static Doc staticSetDocs(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	public SearchList addDocs(Doc...objets) {
		for(Doc o : objets) {
			addDocs(o);
		}
		return (SearchList)this;
	}
	public SearchList addDocs(Doc o) {
		if(o != null)
			this.docs.add(o);
		return (SearchList)this;
	}
	protected SearchList docsInit() {
		Wrap<List<Doc>> docsWrap = new Wrap<List<Doc>>().var("docs");
		if(docs == null) {
			_docs(docsWrap);
			setDocs(docsWrap.o);
		}
		return (SearchList)this;
	}

	//////////
	// list //
	//////////

	/**	 The entity list
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<DEV> list = new ArrayList<DEV>();

	/**	<br> The entity list
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.search.SearchList&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:list">Find the entity list in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _list(List<DEV> l);

	public List<DEV> getList() {
		return list;
	}

	public void setList(List<DEV> list) {
		this.list = list;
	}
	public SearchList addList(DEV...objets) {
		for(DEV o : objets) {
			addList(o);
		}
		return (SearchList)this;
	}
	public SearchList addList(DEV o) {
		if(o != null)
			this.list.add(o);
		return (SearchList)this;
	}
	protected SearchList listInit() {
		_list(list);
		return (SearchList)this;
	}

	///////////
	// first //
	///////////

	/**	 The entity first
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Object first;

	/**	<br> The entity first
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.search.SearchList&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:first">Find the entity first in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _first(Wrap<Object> w);

	public Object getFirst() {
		return first;
	}

	public void setFirst(Object first) {
		this.first = first;
	}
	public static Object staticSetFirst(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SearchList firstInit() {
		Wrap<Object> firstWrap = new Wrap<Object>().var("first");
		if(first == null) {
			_first(firstWrap);
			setFirst(firstWrap.o);
		}
		return (SearchList)this;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepSearchList(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepSearchList();
	}

	public Future<Void> promiseDeepSearchList() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSearchList(promise2);
		promise2.future().onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseSearchList(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				cInit();
				requestInit();
				siteRequest_Init();
				storeInit();
				populateInit();
				solrQueryInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			queryResponsePromise().onSuccess(queryResponse -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				docsInit();
				listInit();
				firstInit();
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
		return promiseDeepSearchList(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSearchList(SiteRequestEnUS siteRequest_) {
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSearchList(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSearchList(v);
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
	public Object obtainSearchList(String var) {
		SearchList oSearchList = (SearchList)this;
		switch(var) {
			case "c":
				return oSearchList.c;
			case "request":
				return oSearchList.request;
			case "siteRequest_":
				return oSearchList.siteRequest_;
			case "store":
				return oSearchList.store;
			case "populate":
				return oSearchList.populate;
			case "solrQuery":
				return oSearchList.solrQuery;
			case "queryResponse":
				return oSearchList.queryResponse;
			case "docs":
				return oSearchList.docs;
			case "list":
				return oSearchList.list;
			case "first":
				return oSearchList.first;
			default:
				return null;
		}
	}

	///////////////
	// relate //
	///////////////

	public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateSearchList(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateSearchList(String var, Object val) {
		SearchList oSearchList = (SearchList)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetSearchList(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSearchList(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSetStore(siteRequest_, o);
		case "populate":
			return SearchList.staticSetPopulate(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrSearchList(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrSearchList(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSolrStore(siteRequest_, (Boolean)o);
		case "populate":
			return SearchList.staticSolrPopulate(siteRequest_, (Boolean)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrSearchList(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrSearchList(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSolrStrStore(siteRequest_, (Boolean)o);
		case "populate":
			return SearchList.staticSolrStrPopulate(siteRequest_, (Boolean)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqSearchList(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqSearchList(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSolrFqStore(siteRequest_, o);
		case "populate":
			return SearchList.staticSolrFqPopulate(siteRequest_, o);
			default:
				return null;
		}
	}

	/////////////
	// define //
	/////////////

	public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineSearchList(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSearchList(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return null;
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	public static final String VAR_c = "c";
	public static final String VAR_request = "request";
	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_store = "store";
	public static final String VAR_populate = "populate";
	public static final String VAR_solrQuery = "solrQuery";
	public static final String VAR_queryResponse = "queryResponse";
	public static final String VAR_docs = "docs";
	public static final String VAR_list = "list";
	public static final String VAR_first = "first";

	public static final String DISPLAY_NAME_c = "";
	public static final String DISPLAY_NAME_request = "";
	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_store = "";
	public static final String DISPLAY_NAME_populate = "";
	public static final String DISPLAY_NAME_solrQuery = "";
	public static final String DISPLAY_NAME_queryResponse = "";
	public static final String DISPLAY_NAME_docs = "";
	public static final String DISPLAY_NAME_list = "";
	public static final String DISPLAY_NAME_first = "";

	public static String displayNameForClass(String var) {
		return SearchList.displayNameSearchList(var);
	}
	public static String displayNameSearchList(String var) {
		switch(var) {
		case VAR_c:
			return DISPLAY_NAME_c;
		case VAR_request:
			return DISPLAY_NAME_request;
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
		case VAR_store:
			return DISPLAY_NAME_store;
		case VAR_populate:
			return DISPLAY_NAME_populate;
		case VAR_solrQuery:
			return DISPLAY_NAME_solrQuery;
		case VAR_queryResponse:
			return DISPLAY_NAME_queryResponse;
		case VAR_docs:
			return DISPLAY_NAME_docs;
		case VAR_list:
			return DISPLAY_NAME_list;
		case VAR_first:
			return DISPLAY_NAME_first;
		default:
			return null;
		}
	}
}
