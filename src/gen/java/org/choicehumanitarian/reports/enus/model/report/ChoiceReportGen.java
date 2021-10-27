package org.choicehumanitarian.reports.enus.model.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.choicehumanitarian.reports.enus.model.donor.ChoiceDonor;
import org.choicehumanitarian.reports.enus.wrap.Wrap;
import java.lang.Long;
import java.util.Map;
import io.vertx.core.json.JsonObject;
import java.math.RoundingMode;
import java.math.MathContext;
import java.util.Set;
import org.choicehumanitarian.reports.enus.java.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.choicehumanitarian.reports.enus.base.BaseModel;
import java.util.Objects;
import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import java.util.Optional;
import org.apache.solr.client.solrj.util.ClientUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.HashMap;
import org.choicehumanitarian.reports.enus.writer.AllWriter;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.choicehumanitarian.reports.enus.java.ZonedDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.String;
import org.choicehumanitarian.reports.enus.request.api.ApiRequest;
import org.slf4j.Logger;
import org.choicehumanitarian.reports.enus.java.ZonedDateTimeDeserializer;
import io.vertx.core.Promise;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.apache.solr.client.solrj.SolrClient;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import org.apache.commons.lang3.math.NumberUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class ChoiceReportGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(ChoiceReport.class);

	public static final String ChoiceReport_AName = "a report";
	public static final String ChoiceReport_This = "this ";
	public static final String ChoiceReport_ThisName = "this report";
	public static final String ChoiceReport_A = "a ";
	public static final String ChoiceReport_TheName = "the report";
	public static final String ChoiceReport_NameSingular = "report";
	public static final String ChoiceReport_NamePlural = "reports";
	public static final String ChoiceReport_NameActual = "current report";
	public static final String ChoiceReport_AllName = "all the reports";
	public static final String ChoiceReport_SearchAllNameBy = "search reports by ";
	public static final String ChoiceReport_Title = "reports";
	public static final String ChoiceReport_ThePluralName = "the reports";
	public static final String ChoiceReport_NoNameFound = "no report found";
	public static final String ChoiceReport_NameVar = "report";
	public static final String ChoiceReport_OfName = "of report";
	public static final String ChoiceReport_ANameAdjective = "a report";
	public static final String ChoiceReport_NameAdjectiveSingular = "report";
	public static final String ChoiceReport_NameAdjectivePlural = "reports";
	public static final String ChoiceReport_Color = "pale-blue";
	public static final String ChoiceReport_IconGroup = "regular";
	public static final String ChoiceReport_IconName = "globe-americas";
	public static final Integer ChoiceReport_Rows = 100;

	///////////////////
	// donorFullName //
	///////////////////

	/**	 The entity donorFullName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String donorFullName;

	/**	<br/> The entity donorFullName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorFullName">Find the entity donorFullName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorFullName(Wrap<String> c);

	public String getDonorFullName() {
		return donorFullName;
	}
	public void setDonorFullName(String o) {
		this.donorFullName = ChoiceReport.staticSetDonorFullName(siteRequest_, o);
	}
	public static String staticSetDonorFullName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceReport donorFullNameInit() {
		Wrap<String> donorFullNameWrap = new Wrap<String>().var("donorFullName");
		if(donorFullName == null) {
			_donorFullName(donorFullNameWrap);
			setDonorFullName(donorFullNameWrap.o);
		}
		return (ChoiceReport)this;
	}

	public static String staticSolrDonorFullName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrDonorFullName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorFullName(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorFullName(siteRequest_, ChoiceReport.staticSolrDonorFullName(siteRequest_, ChoiceReport.staticSetDonorFullName(siteRequest_, o)));
	}

	public String sqlDonorFullName() {
		return donorFullName;
	}

	///////////////
	// donorKeys //
	///////////////

	/**	 The entity donorKeys
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonSerialize(contentUsing = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Long> donorKeys = new ArrayList<Long>();

	/**	<br/> The entity donorKeys
	 *  It is constructed before being initialized with the constructor by default List<Long>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorKeys">Find the entity donorKeys in Solr</a>
	 * <br/>
	 * @param donorKeys is the entity already constructed. 
	 **/
	protected abstract void _donorKeys(List<Long> c);

	public List<Long> getDonorKeys() {
		return donorKeys;
	}

	public void setDonorKeys(List<Long> donorKeys) {
		this.donorKeys = donorKeys;
	}
	@JsonIgnore
	public void setDonorKeys(String o) {
		Long l = ChoiceReport.staticSetDonorKeys(siteRequest_, o);
		if(l != null)
			addDonorKeys(l);
	}
	public static Long staticSetDonorKeys(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public ChoiceReport addDonorKeys(Long...objets) {
		for(Long o : objets) {
			addDonorKeys(o);
		}
		return (ChoiceReport)this;
	}
	public ChoiceReport addDonorKeys(Long o) {
		if(o != null && !donorKeys.contains(o))
			this.donorKeys.add(o);
		return (ChoiceReport)this;
	}
	@JsonIgnore
	public void setDonorKeys(JsonArray objets) {
		donorKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addDonorKeys(o);
		}
	}
	public ChoiceReport addDonorKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addDonorKeys(p);
		}
		return (ChoiceReport)this;
	}
	protected ChoiceReport donorKeysInit() {
		_donorKeys(donorKeys);
		return (ChoiceReport)this;
	}

	public static Long staticSolrDonorKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrDonorKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorKeys(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorKeys(siteRequest_, ChoiceReport.staticSolrDonorKeys(siteRequest_, ChoiceReport.staticSetDonorKeys(siteRequest_, o)));
	}

	public List<Long> sqlDonorKeys() {
		return donorKeys;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepChoiceReport(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepChoiceReport();
	}

	public Future<Void> promiseDeepChoiceReport() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseChoiceReport(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepBaseModel(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseChoiceReport(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				donorFullNameInit();
				donorKeysInit();
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
		return promiseDeepChoiceReport(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestChoiceReport(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestChoiceReport(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainChoiceReport(v);
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
	public Object obtainChoiceReport(String var) {
		ChoiceReport oChoiceReport = (ChoiceReport)this;
		switch(var) {
			case "donorFullName":
				return oChoiceReport.donorFullName;
			case "donorKeys":
				return oChoiceReport.donorKeys;
			default:
				return super.obtainBaseModel(var);
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
				o = relateChoiceReport(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateChoiceReport(String var, Object val) {
		ChoiceReport oChoiceReport = (ChoiceReport)this;
		switch(var) {
			case "donorKeys":
				oChoiceReport.addDonorKeys((Long)val);
				if(!saves.contains("donorKeys"))
					saves.add("donorKeys");
				return val;
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetChoiceReport(entityVar,  siteRequest_, o);
	}
	public static Object staticSetChoiceReport(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "donorFullName":
			return ChoiceReport.staticSetDonorFullName(siteRequest_, o);
		case "donorKeys":
			return ChoiceReport.staticSetDonorKeys(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrChoiceReport(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrChoiceReport(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "donorFullName":
			return ChoiceReport.staticSolrDonorFullName(siteRequest_, (String)o);
		case "donorKeys":
			return ChoiceReport.staticSolrDonorKeys(siteRequest_, (Long)o);
			default:
				return BaseModel.staticSolrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrChoiceReport(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrChoiceReport(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "donorFullName":
			return ChoiceReport.staticSolrStrDonorFullName(siteRequest_, (String)o);
		case "donorKeys":
			return ChoiceReport.staticSolrStrDonorKeys(siteRequest_, (Long)o);
			default:
				return BaseModel.staticSolrStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqChoiceReport(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqChoiceReport(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "donorFullName":
			return ChoiceReport.staticSolrFqDonorFullName(siteRequest_, o);
		case "donorKeys":
			return ChoiceReport.staticSolrFqDonorKeys(siteRequest_, o);
			default:
				return BaseModel.staticSolrFqBaseModel(entityVar,  siteRequest_, o);
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
					o = defineChoiceReport(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineChoiceReport(String var, Object val) {
		switch(var.toLowerCase()) {
			case "donorfullname":
				if(val instanceof String)
					setDonorFullName((String)val);
				saves.add("donorFullName");
				return val;
			default:
				return super.defineBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateChoiceReport(solrDocument);
	}
	public void populateChoiceReport(SolrDocument solrDocument) {
		ChoiceReport oChoiceReport = (ChoiceReport)this;
		saves = (List<String>)solrDocument.get("saves_indexedstored_strings");
		if(saves != null) {

			if(saves.contains("donorFullName")) {
				String donorFullName = (String)solrDocument.get("donorFullName_indexedstored_string");
				if(donorFullName != null)
					oChoiceReport.setDonorFullName(donorFullName);
			}

			List<Long> donorKeys = (List<Long>)solrDocument.get("donorKeys_indexedstored_longs");
			if(donorKeys != null)
				oChoiceReport.donorKeys.addAll(donorKeys);
		}

		super.populateBaseModel(solrDocument);
	}

	public void indexChoiceReport(SolrInputDocument document) {
		if(donorFullName != null) {
			document.addField("donorFullName_indexedstored_string", donorFullName);
		}
		if(donorKeys != null) {
			for(java.lang.Long o : donorKeys) {
				document.addField("donorKeys_indexedstored_longs", o);
			}
		}
		super.indexBaseModel(document);

	}

	public static String varIndexedChoiceReport(String entityVar) {
		switch(entityVar) {
			case "donorFullName":
				return "donorFullName_indexedstored_string";
			case "donorKeys":
				return "donorKeys_indexedstored_longs";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String varSearchChoiceReport(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedChoiceReport(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeChoiceReport(solrDocument);
	}
	public void storeChoiceReport(SolrDocument solrDocument) {
		ChoiceReport oChoiceReport = (ChoiceReport)this;

		oChoiceReport.setDonorFullName(Optional.ofNullable(solrDocument.get("donorFullName_indexedstored_string")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)solrDocument.get("donorKeys_indexedstored_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oChoiceReport.addDonorKeys(v.toString());
		});

		super.storeBaseModel(solrDocument);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestChoiceReport() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ChoiceReport) {
			ChoiceReport original = (ChoiceReport)o;
			if(!Objects.equals(donorFullName, original.getDonorFullName()))
				apiRequest.addVars("donorFullName");
			if(!Objects.equals(donorKeys, original.getDonorKeys()))
				apiRequest.addVars("donorKeys");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("ChoiceReport { ");
		sb.append( "donorFullName: \"" ).append(donorFullName).append( "\"" );
		sb.append( ", donorKeys: " ).append(donorKeys);
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_donorFullName = "donorFullName";
	public static final String VAR_donorKeys = "donorKeys";
}
