package org.choicehumanitarian.reports.enus.model.donor;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import java.text.NumberFormat;
import java.util.ArrayList;
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
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorGenPage;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.donor.ChoiceDonorPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class ChoiceDonorPageGen<DEV> extends ChoiceDonorGenPage {
	protected static final Logger LOG = LoggerFactory.getLogger(ChoiceDonorPage.class);

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepChoiceDonorPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepChoiceDonorPage();
	}

	public Future<Void> promiseDeepChoiceDonorPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseChoiceDonorPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepChoiceDonorGenPage(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseChoiceDonorPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
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
		return promiseDeepChoiceDonorPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestChoiceDonorPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestChoiceDonorGenPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestChoiceDonorPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainChoiceDonorPage(v);
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
	public Object obtainChoiceDonorPage(String var) {
		ChoiceDonorPage oChoiceDonorPage = (ChoiceDonorPage)this;
		switch(var) {
			default:
				return super.obtainChoiceDonorGenPage(var);
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
				o = relateChoiceDonorPage(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateChoiceDonorPage(String var, Object val) {
		ChoiceDonorPage oChoiceDonorPage = (ChoiceDonorPage)this;
		switch(var) {
			default:
				return super.relateChoiceDonorGenPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetChoiceDonorPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetChoiceDonorPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return ChoiceDonorGenPage.staticSetChoiceDonorGenPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrChoiceDonorPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrChoiceDonorPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return ChoiceDonorGenPage.staticSolrChoiceDonorGenPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrChoiceDonorPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrChoiceDonorPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return ChoiceDonorGenPage.staticSolrStrChoiceDonorGenPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqChoiceDonorPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqChoiceDonorPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return ChoiceDonorGenPage.staticSolrFqChoiceDonorGenPage(entityVar,  siteRequest_, o);
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
					o = defineChoiceDonorPage(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineChoiceDonorPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineChoiceDonorGenPage(var, val);
		}
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestChoiceDonorPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ChoiceDonorPage) {
			ChoiceDonorPage original = (ChoiceDonorPage)o;
			super.apiRequestChoiceDonorGenPage();
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

}
