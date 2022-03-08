package org.choicehumanitarian.reports.enus.model.donor;

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
import org.choicehumanitarian.reports.enus.model.donor.ChoiceDonor;
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
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ChoiceDonorGenPageGen<DEV> extends BaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(ChoiceDonorGenPage.class);

	////////////////////////////
	// searchListChoiceDonor_ //
	////////////////////////////

	/**	 The entity searchListChoiceDonor_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ChoiceDonor> searchListChoiceDonor_;

	/**	<br> The entity searchListChoiceDonor_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListChoiceDonor_">Find the entity searchListChoiceDonor_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListChoiceDonor_(Wrap<SearchList<ChoiceDonor>> w);

	public SearchList<ChoiceDonor> getSearchListChoiceDonor_() {
		return searchListChoiceDonor_;
	}

	public void setSearchListChoiceDonor_(SearchList<ChoiceDonor> searchListChoiceDonor_) {
		this.searchListChoiceDonor_ = searchListChoiceDonor_;
	}
	public static SearchList<ChoiceDonor> staticSetSearchListChoiceDonor_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceDonorGenPage searchListChoiceDonor_Init() {
		Wrap<SearchList<ChoiceDonor>> searchListChoiceDonor_Wrap = new Wrap<SearchList<ChoiceDonor>>().var("searchListChoiceDonor_");
		if(searchListChoiceDonor_ == null) {
			_searchListChoiceDonor_(searchListChoiceDonor_Wrap);
			setSearchListChoiceDonor_(searchListChoiceDonor_Wrap.o);
		}
		return (ChoiceDonorGenPage)this;
	}

	/////////////////////
	// listChoiceDonor //
	/////////////////////

	/**	 The entity listChoiceDonor
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listChoiceDonor = new JsonArray();

	/**	<br> The entity listChoiceDonor
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listChoiceDonor">Find the entity listChoiceDonor in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listChoiceDonor(JsonArray l);

	public JsonArray getListChoiceDonor() {
		return listChoiceDonor;
	}

	public void setListChoiceDonor(JsonArray listChoiceDonor) {
		this.listChoiceDonor = listChoiceDonor;
	}
	public static JsonArray staticSetListChoiceDonor(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceDonorGenPage listChoiceDonorInit() {
		_listChoiceDonor(listChoiceDonor);
		return (ChoiceDonorGenPage)this;
	}

	//////////////////////
	// choiceDonorCount //
	//////////////////////

	/**	 The entity choiceDonorCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer choiceDonorCount;

	/**	<br> The entity choiceDonorCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:choiceDonorCount">Find the entity choiceDonorCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _choiceDonorCount(Wrap<Integer> w);

	public Integer getChoiceDonorCount() {
		return choiceDonorCount;
	}

	public void setChoiceDonorCount(Integer choiceDonorCount) {
		this.choiceDonorCount = choiceDonorCount;
	}
	@JsonIgnore
	public void setChoiceDonorCount(String o) {
		this.choiceDonorCount = ChoiceDonorGenPage.staticSetChoiceDonorCount(siteRequest_, o);
	}
	public static Integer staticSetChoiceDonorCount(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ChoiceDonorGenPage choiceDonorCountInit() {
		Wrap<Integer> choiceDonorCountWrap = new Wrap<Integer>().var("choiceDonorCount");
		if(choiceDonorCount == null) {
			_choiceDonorCount(choiceDonorCountWrap);
			setChoiceDonorCount(choiceDonorCountWrap.o);
		}
		return (ChoiceDonorGenPage)this;
	}

	public static Integer staticSearchChoiceDonorCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrChoiceDonorCount(SiteRequestEnUS siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqChoiceDonorCount(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceDonorGenPage.staticSearchStrChoiceDonorCount(siteRequest_, ChoiceDonorGenPage.staticSearchChoiceDonorCount(siteRequest_, ChoiceDonorGenPage.staticSetChoiceDonorCount(siteRequest_, o)));
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

	/**	<br> The entity choiceDonor_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:choiceDonor_">Find the entity choiceDonor_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _choiceDonor_(Wrap<ChoiceDonor> w);

	public ChoiceDonor getChoiceDonor_() {
		return choiceDonor_;
	}

	public void setChoiceDonor_(ChoiceDonor choiceDonor_) {
		this.choiceDonor_ = choiceDonor_;
	}
	public static ChoiceDonor staticSetChoiceDonor_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceDonorGenPage choiceDonor_Init() {
		Wrap<ChoiceDonor> choiceDonor_Wrap = new Wrap<ChoiceDonor>().var("choiceDonor_");
		if(choiceDonor_ == null) {
			_choiceDonor_(choiceDonor_Wrap);
			setChoiceDonor_(choiceDonor_Wrap.o);
		}
		return (ChoiceDonorGenPage)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = ChoiceDonorGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ChoiceDonorGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (ChoiceDonorGenPage)this;
	}

	public static Long staticSearchPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPk(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceDonorGenPage.staticSearchStrPk(siteRequest_, ChoiceDonorGenPage.staticSearchPk(siteRequest_, ChoiceDonorGenPage.staticSetPk(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepChoiceDonorGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepChoiceDonorGenPage();
	}

	public Future<Void> promiseDeepChoiceDonorGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseChoiceDonorGenPage(promise2);
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

	public Future<Void> promiseChoiceDonorGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListChoiceDonor_Init();
				listChoiceDonorInit();
				choiceDonorCountInit();
				choiceDonor_Init();
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
		return promiseDeepChoiceDonorGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestChoiceDonorGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestChoiceDonorGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
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
			case "searchListChoiceDonor_":
				return oChoiceDonorGenPage.searchListChoiceDonor_;
			case "listChoiceDonor":
				return oChoiceDonorGenPage.listChoiceDonor;
			case "choiceDonorCount":
				return oChoiceDonorGenPage.choiceDonorCount;
			case "choiceDonor_":
				return oChoiceDonorGenPage.choiceDonor_;
			case "pk":
				return oChoiceDonorGenPage.pk;
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
				o = relateChoiceDonorGenPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateChoiceDonorGenPage(String var, Object val) {
		ChoiceDonorGenPage oChoiceDonorGenPage = (ChoiceDonorGenPage)this;
		switch(var) {
			default:
				return super.relateBaseModelPage(var, val);
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
		case "choiceDonorCount":
			return ChoiceDonorGenPage.staticSetChoiceDonorCount(siteRequest_, o);
		case "pk":
			return ChoiceDonorGenPage.staticSetPk(siteRequest_, o);
			default:
				return BaseModelPage.staticSetBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchChoiceDonorGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchChoiceDonorGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "choiceDonorCount":
			return ChoiceDonorGenPage.staticSearchChoiceDonorCount(siteRequest_, (Integer)o);
		case "pk":
			return ChoiceDonorGenPage.staticSearchPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSearchBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrChoiceDonorGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrChoiceDonorGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "choiceDonorCount":
			return ChoiceDonorGenPage.staticSearchStrChoiceDonorCount(siteRequest_, (Integer)o);
		case "pk":
			return ChoiceDonorGenPage.staticSearchStrPk(siteRequest_, (Long)o);
			default:
				return BaseModelPage.staticSearchStrBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqChoiceDonorGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqChoiceDonorGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "choiceDonorCount":
			return ChoiceDonorGenPage.staticSearchFqChoiceDonorCount(siteRequest_, o);
		case "pk":
			return ChoiceDonorGenPage.staticSearchFqPk(siteRequest_, o);
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

	public static final String VAR_searchListChoiceDonor_ = "searchListChoiceDonor_";
	public static final String VAR_listChoiceDonor = "listChoiceDonor";
	public static final String VAR_choiceDonorCount = "choiceDonorCount";
	public static final String VAR_choiceDonor_ = "choiceDonor_";
	public static final String VAR_pk = "pk";

	public static final String DISPLAY_NAME_searchListChoiceDonor_ = "";
	public static final String DISPLAY_NAME_listChoiceDonor = "";
	public static final String DISPLAY_NAME_choiceDonorCount = "";
	public static final String DISPLAY_NAME_choiceDonor_ = "";
	public static final String DISPLAY_NAME_pk = "";

	public static String displayNameForClass(String var) {
		return ChoiceDonorGenPage.displayNameChoiceDonorGenPage(var);
	}
	public static String displayNameChoiceDonorGenPage(String var) {
		switch(var) {
		case VAR_searchListChoiceDonor_:
			return DISPLAY_NAME_searchListChoiceDonor_;
		case VAR_listChoiceDonor:
			return DISPLAY_NAME_listChoiceDonor;
		case VAR_choiceDonorCount:
			return DISPLAY_NAME_choiceDonorCount;
		case VAR_choiceDonor_:
			return DISPLAY_NAME_choiceDonor_;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		default:
			return BaseModelPage.displayNameBaseModelPage(var);
		}
	}
}
