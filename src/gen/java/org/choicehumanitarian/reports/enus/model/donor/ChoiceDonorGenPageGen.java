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
import java.math.RoundingMode;
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
import org.choicehumanitarian.reports.enus.page.PageLayout;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class ChoiceDonorGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOG = LoggerFactory.getLogger(ChoiceDonorGenPage.class);

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
			super.promiseDeepPageLayout(siteRequest_).onSuccess(b -> {
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
				listChoiceDonor_Init();
				choiceDonor_Init();
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
			super.siteRequestPageLayout(siteRequest_);
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
			case "listChoiceDonor_":
				return oChoiceDonorGenPage.listChoiceDonor_;
			case "choiceDonor_":
				return oChoiceDonorGenPage.choiceDonor_;
			default:
				return super.obtainPageLayout(var);
		}
	}

	///////////////
	// attribute //
	///////////////

	@Override public boolean attributeForClass(String var, Object val) {
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
				return super.attributePageLayout(var, val);
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
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
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
			default:
				return PageLayout.staticSolrPageLayout(entityVar,  siteRequest_, o);
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
			default:
				return PageLayout.staticSolrStrPageLayout(entityVar,  siteRequest_, o);
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
			default:
				return PageLayout.staticSolrFqPageLayout(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// define //
	/////////////

	@Override public boolean defineForClass(String var, String val) {
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
				return super.definePageLayout(var, val);
		}
	}

	@Override public boolean defineForClass(String var, Object val) {
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
				return super.definePageLayout(var, val);
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
			super.apiRequestPageLayout();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode());
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
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("ChoiceDonorGenPage { ");
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_listChoiceDonor_ = "listChoiceDonor_";
	public static final String VAR_choiceDonor_ = "choiceDonor_";
}
