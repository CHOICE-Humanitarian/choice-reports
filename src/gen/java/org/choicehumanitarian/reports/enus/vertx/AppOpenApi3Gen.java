package org.choicehumanitarian.reports.enus.vertx;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import org.choicehumanitarian.reports.enus.vertx.AppSwagger2;
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

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.vertx.AppOpenApi3&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class AppOpenApi3Gen<DEV> extends AppSwagger2 {
	protected static final Logger LOG = LoggerFactory.getLogger(AppOpenApi3.class);

	//////////////
	// initDeep //
	//////////////

	public AppOpenApi3 initDeepAppOpenApi3(SiteRequestEnUS siteRequest_) {
		initDeepAppOpenApi3();
		return (AppOpenApi3)this;
	}

	public void initDeepAppOpenApi3() {
		initAppOpenApi3();
	}

	public void initAppOpenApi3() {
	}

	public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepAppOpenApi3(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainAppOpenApi3(v);
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
	public Object obtainAppOpenApi3(String var) {
		AppOpenApi3 oAppOpenApi3 = (AppOpenApi3)this;
		switch(var) {
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
				o = relateAppOpenApi3(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateAppOpenApi3(String var, Object val) {
		AppOpenApi3 oAppOpenApi3 = (AppOpenApi3)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetAppOpenApi3(entityVar,  siteRequest_, o);
	}
	public static Object staticSetAppOpenApi3(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrAppOpenApi3(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrAppOpenApi3(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrAppOpenApi3(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrAppOpenApi3(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqAppOpenApi3(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqAppOpenApi3(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
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
					o = defineAppOpenApi3(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineAppOpenApi3(String var, Object val) {
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

}
