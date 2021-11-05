package org.choicehumanitarian.reports.enus.model.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;
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
import org.choicehumanitarian.reports.enus.search.SearchList;
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

	//////////////
	// donorKey //
	//////////////

	/**	 The entity donorKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long donorKey;

	/**	<br/> The entity donorKey
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorKey">Find the entity donorKey in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorKey(Wrap<Long> w);

	public Long getDonorKey() {
		return donorKey;
	}

	public void setDonorKey(Long donorKey) {
		this.donorKey = donorKey;
	}
	@JsonIgnore
	public void setDonorKey(String o) {
		this.donorKey = ChoiceReport.staticSetDonorKey(siteRequest_, o);
	}
	public static Long staticSetDonorKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ChoiceReport donorKeyInit() {
		Wrap<Long> donorKeyWrap = new Wrap<Long>().var("donorKey");
		if(donorKey == null) {
			_donorKey(donorKeyWrap);
			setDonorKey(donorKeyWrap.o);
		}
		return (ChoiceReport)this;
	}

	public static Long staticSolrDonorKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrDonorKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorKey(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorKey(siteRequest_, ChoiceReport.staticSolrDonorKey(siteRequest_, ChoiceReport.staticSetDonorKey(siteRequest_, o)));
	}

	public Long sqlDonorKey() {
		return donorKey;
	}

	/////////////////
	// donorSearch //
	/////////////////

	/**	 The entity donorSearch
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ChoiceDonor> donorSearch;

	/**	<br/> The entity donorSearch
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorSearch">Find the entity donorSearch in Solr</a>
	 * <br/>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorSearch(Promise<SearchList<ChoiceDonor>> promise);

	public SearchList<ChoiceDonor> getDonorSearch() {
		return donorSearch;
	}

	public void setDonorSearch(SearchList<ChoiceDonor> donorSearch) {
		this.donorSearch = donorSearch;
	}
	public static SearchList<ChoiceDonor> staticSetDonorSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<SearchList<ChoiceDonor>> donorSearchPromise() {
		Promise<SearchList<ChoiceDonor>> promise = Promise.promise();
		Promise<SearchList<ChoiceDonor>> promise2 = Promise.promise();
		_donorSearch(promise2);
		promise2.future().onSuccess(o -> {
			if(o != null && donorSearch == null) {
				o.promiseDeepForClass(siteRequest_).onSuccess(a -> {
					setDonorSearch(o);
					promise.complete(o);
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			} else {
				promise.complete(o);
			}
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	////////////
	// donor_ //
	////////////

	/**	 The entity donor_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ChoiceDonor donor_;

	/**	<br/> The entity donor_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donor_">Find the entity donor_ in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donor_(Wrap<ChoiceDonor> w);

	public ChoiceDonor getDonor_() {
		return donor_;
	}

	public void setDonor_(ChoiceDonor donor_) {
		this.donor_ = donor_;
	}
	public static ChoiceDonor staticSetDonor_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected ChoiceReport donor_Init() {
		Wrap<ChoiceDonor> donor_Wrap = new Wrap<ChoiceDonor>().var("donor_");
		if(donor_ == null) {
			_donor_(donor_Wrap);
			setDonor_(donor_Wrap.o);
		}
		return (ChoiceReport)this;
	}

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
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorFullName(Wrap<String> w);

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

	/////////////////////
	// donorParentName //
	/////////////////////

	/**	 The entity donorParentName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String donorParentName;

	/**	<br/> The entity donorParentName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorParentName">Find the entity donorParentName in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorParentName(Wrap<String> w);

	public String getDonorParentName() {
		return donorParentName;
	}
	public void setDonorParentName(String o) {
		this.donorParentName = ChoiceReport.staticSetDonorParentName(siteRequest_, o);
	}
	public static String staticSetDonorParentName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceReport donorParentNameInit() {
		Wrap<String> donorParentNameWrap = new Wrap<String>().var("donorParentName");
		if(donorParentName == null) {
			_donorParentName(donorParentNameWrap);
			setDonorParentName(donorParentNameWrap.o);
		}
		return (ChoiceReport)this;
	}

	public static String staticSolrDonorParentName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrDonorParentName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorParentName(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorParentName(siteRequest_, ChoiceReport.staticSolrDonorParentName(siteRequest_, ChoiceReport.staticSetDonorParentName(siteRequest_, o)));
	}

	public String sqlDonorParentName() {
		return donorParentName;
	}

	/////////////
	// donorId //
	/////////////

	/**	 The entity donorId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long donorId;

	/**	<br/> The entity donorId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorId">Find the entity donorId in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorId(Wrap<Long> w);

	public Long getDonorId() {
		return donorId;
	}

	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}
	@JsonIgnore
	public void setDonorId(String o) {
		this.donorId = ChoiceReport.staticSetDonorId(siteRequest_, o);
	}
	public static Long staticSetDonorId(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ChoiceReport donorIdInit() {
		Wrap<Long> donorIdWrap = new Wrap<Long>().var("donorId");
		if(donorId == null) {
			_donorId(donorIdWrap);
			setDonorId(donorIdWrap.o);
		}
		return (ChoiceReport)this;
	}

	public static Long staticSolrDonorId(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrDonorId(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorId(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorId(siteRequest_, ChoiceReport.staticSolrDonorId(siteRequest_, ChoiceReport.staticSetDonorId(siteRequest_, o)));
	}

	public Long sqlDonorId() {
		return donorId;
	}

	//////////////////////
	// donorAttributeId //
	//////////////////////

	/**	 The entity donorAttributeId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String donorAttributeId;

	/**	<br/> The entity donorAttributeId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorAttributeId">Find the entity donorAttributeId in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorAttributeId(Wrap<String> w);

	public String getDonorAttributeId() {
		return donorAttributeId;
	}
	public void setDonorAttributeId(String o) {
		this.donorAttributeId = ChoiceReport.staticSetDonorAttributeId(siteRequest_, o);
	}
	public static String staticSetDonorAttributeId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceReport donorAttributeIdInit() {
		Wrap<String> donorAttributeIdWrap = new Wrap<String>().var("donorAttributeId");
		if(donorAttributeId == null) {
			_donorAttributeId(donorAttributeIdWrap);
			setDonorAttributeId(donorAttributeIdWrap.o);
		}
		return (ChoiceReport)this;
	}

	public static String staticSolrDonorAttributeId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrDonorAttributeId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorAttributeId(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorAttributeId(siteRequest_, ChoiceReport.staticSolrDonorAttributeId(siteRequest_, ChoiceReport.staticSetDonorAttributeId(siteRequest_, o)));
	}

	public String sqlDonorAttributeId() {
		return donorAttributeId;
	}

	/////////////////
	// donorInKind //
	/////////////////

	/**	 The entity donorInKind
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long donorInKind;

	/**	<br/> The entity donorInKind
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorInKind">Find the entity donorInKind in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorInKind(Wrap<Long> w);

	public Long getDonorInKind() {
		return donorInKind;
	}

	public void setDonorInKind(Long donorInKind) {
		this.donorInKind = donorInKind;
	}
	@JsonIgnore
	public void setDonorInKind(String o) {
		this.donorInKind = ChoiceReport.staticSetDonorInKind(siteRequest_, o);
	}
	public static Long staticSetDonorInKind(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ChoiceReport donorInKindInit() {
		Wrap<Long> donorInKindWrap = new Wrap<Long>().var("donorInKind");
		if(donorInKind == null) {
			_donorInKind(donorInKindWrap);
			setDonorInKind(donorInKindWrap.o);
		}
		return (ChoiceReport)this;
	}

	public static Long staticSolrDonorInKind(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrDonorInKind(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorInKind(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorInKind(siteRequest_, ChoiceReport.staticSolrDonorInKind(siteRequest_, ChoiceReport.staticSetDonorInKind(siteRequest_, o)));
	}

	public Long sqlDonorInKind() {
		return donorInKind;
	}

	////////////////
	// donorTotal //
	////////////////

	/**	 The entity donorTotal
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal donorTotal;

	/**	<br/> The entity donorTotal
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorTotal">Find the entity donorTotal in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorTotal(Wrap<BigDecimal> w);

	public BigDecimal getDonorTotal() {
		return donorTotal;
	}

	public void setDonorTotal(BigDecimal donorTotal) {
		this.donorTotal = donorTotal;
	}
	@JsonIgnore
	public void setDonorTotal(String o) {
		this.donorTotal = ChoiceReport.staticSetDonorTotal(siteRequest_, o);
	}
	public static BigDecimal staticSetDonorTotal(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setDonorTotal(Double o) {
			this.donorTotal = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	@JsonIgnore
	public void setDonorTotal(Integer o) {
			this.donorTotal = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	protected ChoiceReport donorTotalInit() {
		Wrap<BigDecimal> donorTotalWrap = new Wrap<BigDecimal>().var("donorTotal");
		if(donorTotal == null) {
			_donorTotal(donorTotalWrap);
			setDonorTotal(donorTotalWrap.o);
		}
		return (ChoiceReport)this;
	}

	public static Double staticSolrDonorTotal(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSolrStrDonorTotal(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorTotal(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorTotal(siteRequest_, ChoiceReport.staticSolrDonorTotal(siteRequest_, ChoiceReport.staticSetDonorTotal(siteRequest_, o)));
	}

	public BigDecimal sqlDonorTotal() {
		return donorTotal;
	}

	//////////////
	// donorYtd //
	//////////////

	/**	 The entity donorYtd
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal donorYtd;

	/**	<br/> The entity donorYtd
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorYtd">Find the entity donorYtd in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorYtd(Wrap<BigDecimal> w);

	public BigDecimal getDonorYtd() {
		return donorYtd;
	}

	public void setDonorYtd(BigDecimal donorYtd) {
		this.donorYtd = donorYtd;
	}
	@JsonIgnore
	public void setDonorYtd(String o) {
		this.donorYtd = ChoiceReport.staticSetDonorYtd(siteRequest_, o);
	}
	public static BigDecimal staticSetDonorYtd(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setDonorYtd(Double o) {
			this.donorYtd = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	@JsonIgnore
	public void setDonorYtd(Integer o) {
			this.donorYtd = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	protected ChoiceReport donorYtdInit() {
		Wrap<BigDecimal> donorYtdWrap = new Wrap<BigDecimal>().var("donorYtd");
		if(donorYtd == null) {
			_donorYtd(donorYtdWrap);
			setDonorYtd(donorYtdWrap.o);
		}
		return (ChoiceReport)this;
	}

	public static Double staticSolrDonorYtd(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSolrStrDonorYtd(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorYtd(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorYtd(siteRequest_, ChoiceReport.staticSolrDonorYtd(siteRequest_, ChoiceReport.staticSetDonorYtd(siteRequest_, o)));
	}

	public BigDecimal sqlDonorYtd() {
		return donorYtd;
	}

	/////////////
	// donorQ1 //
	/////////////

	/**	 The entity donorQ1
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal donorQ1;

	/**	<br/> The entity donorQ1
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorQ1">Find the entity donorQ1 in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorQ1(Wrap<BigDecimal> w);

	public BigDecimal getDonorQ1() {
		return donorQ1;
	}

	public void setDonorQ1(BigDecimal donorQ1) {
		this.donorQ1 = donorQ1;
	}
	@JsonIgnore
	public void setDonorQ1(String o) {
		this.donorQ1 = ChoiceReport.staticSetDonorQ1(siteRequest_, o);
	}
	public static BigDecimal staticSetDonorQ1(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setDonorQ1(Double o) {
			this.donorQ1 = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	@JsonIgnore
	public void setDonorQ1(Integer o) {
			this.donorQ1 = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	protected ChoiceReport donorQ1Init() {
		Wrap<BigDecimal> donorQ1Wrap = new Wrap<BigDecimal>().var("donorQ1");
		if(donorQ1 == null) {
			_donorQ1(donorQ1Wrap);
			setDonorQ1(donorQ1Wrap.o);
		}
		return (ChoiceReport)this;
	}

	public static Double staticSolrDonorQ1(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSolrStrDonorQ1(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorQ1(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorQ1(siteRequest_, ChoiceReport.staticSolrDonorQ1(siteRequest_, ChoiceReport.staticSetDonorQ1(siteRequest_, o)));
	}

	public BigDecimal sqlDonorQ1() {
		return donorQ1;
	}

	/////////////
	// donorQ2 //
	/////////////

	/**	 The entity donorQ2
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal donorQ2;

	/**	<br/> The entity donorQ2
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorQ2">Find the entity donorQ2 in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorQ2(Wrap<BigDecimal> w);

	public BigDecimal getDonorQ2() {
		return donorQ2;
	}

	public void setDonorQ2(BigDecimal donorQ2) {
		this.donorQ2 = donorQ2;
	}
	@JsonIgnore
	public void setDonorQ2(String o) {
		this.donorQ2 = ChoiceReport.staticSetDonorQ2(siteRequest_, o);
	}
	public static BigDecimal staticSetDonorQ2(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setDonorQ2(Double o) {
			this.donorQ2 = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	@JsonIgnore
	public void setDonorQ2(Integer o) {
			this.donorQ2 = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	protected ChoiceReport donorQ2Init() {
		Wrap<BigDecimal> donorQ2Wrap = new Wrap<BigDecimal>().var("donorQ2");
		if(donorQ2 == null) {
			_donorQ2(donorQ2Wrap);
			setDonorQ2(donorQ2Wrap.o);
		}
		return (ChoiceReport)this;
	}

	public static Double staticSolrDonorQ2(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSolrStrDonorQ2(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorQ2(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorQ2(siteRequest_, ChoiceReport.staticSolrDonorQ2(siteRequest_, ChoiceReport.staticSetDonorQ2(siteRequest_, o)));
	}

	public BigDecimal sqlDonorQ2() {
		return donorQ2;
	}

	/////////////
	// donorQ3 //
	/////////////

	/**	 The entity donorQ3
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal donorQ3;

	/**	<br/> The entity donorQ3
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorQ3">Find the entity donorQ3 in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorQ3(Wrap<BigDecimal> w);

	public BigDecimal getDonorQ3() {
		return donorQ3;
	}

	public void setDonorQ3(BigDecimal donorQ3) {
		this.donorQ3 = donorQ3;
	}
	@JsonIgnore
	public void setDonorQ3(String o) {
		this.donorQ3 = ChoiceReport.staticSetDonorQ3(siteRequest_, o);
	}
	public static BigDecimal staticSetDonorQ3(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setDonorQ3(Double o) {
			this.donorQ3 = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	@JsonIgnore
	public void setDonorQ3(Integer o) {
			this.donorQ3 = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	protected ChoiceReport donorQ3Init() {
		Wrap<BigDecimal> donorQ3Wrap = new Wrap<BigDecimal>().var("donorQ3");
		if(donorQ3 == null) {
			_donorQ3(donorQ3Wrap);
			setDonorQ3(donorQ3Wrap.o);
		}
		return (ChoiceReport)this;
	}

	public static Double staticSolrDonorQ3(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSolrStrDonorQ3(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorQ3(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorQ3(siteRequest_, ChoiceReport.staticSolrDonorQ3(siteRequest_, ChoiceReport.staticSetDonorQ3(siteRequest_, o)));
	}

	public BigDecimal sqlDonorQ3() {
		return donorQ3;
	}

	/////////////
	// donorQ4 //
	/////////////

	/**	 The entity donorQ4
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal donorQ4;

	/**	<br/> The entity donorQ4
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorQ4">Find the entity donorQ4 in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorQ4(Wrap<BigDecimal> w);

	public BigDecimal getDonorQ4() {
		return donorQ4;
	}

	public void setDonorQ4(BigDecimal donorQ4) {
		this.donorQ4 = donorQ4;
	}
	@JsonIgnore
	public void setDonorQ4(String o) {
		this.donorQ4 = ChoiceReport.staticSetDonorQ4(siteRequest_, o);
	}
	public static BigDecimal staticSetDonorQ4(SiteRequestEnUS siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setDonorQ4(Double o) {
			this.donorQ4 = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	@JsonIgnore
	public void setDonorQ4(Integer o) {
			this.donorQ4 = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	protected ChoiceReport donorQ4Init() {
		Wrap<BigDecimal> donorQ4Wrap = new Wrap<BigDecimal>().var("donorQ4");
		if(donorQ4 == null) {
			_donorQ4(donorQ4Wrap);
			setDonorQ4(donorQ4Wrap.o);
		}
		return (ChoiceReport)this;
	}

	public static Double staticSolrDonorQ4(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSolrStrDonorQ4(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorQ4(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorQ4(siteRequest_, ChoiceReport.staticSolrDonorQ4(siteRequest_, ChoiceReport.staticSetDonorQ4(siteRequest_, o)));
	}

	public BigDecimal sqlDonorQ4() {
		return donorQ4;
	}

	///////////////////////
	// donorLogoFilename //
	///////////////////////

	/**	 The entity donorLogoFilename
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String donorLogoFilename;

	/**	<br/> The entity donorLogoFilename
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:donorLogoFilename">Find the entity donorLogoFilename in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _donorLogoFilename(Wrap<String> w);

	public String getDonorLogoFilename() {
		return donorLogoFilename;
	}
	public void setDonorLogoFilename(String o) {
		this.donorLogoFilename = ChoiceReport.staticSetDonorLogoFilename(siteRequest_, o);
	}
	public static String staticSetDonorLogoFilename(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected ChoiceReport donorLogoFilenameInit() {
		Wrap<String> donorLogoFilenameWrap = new Wrap<String>().var("donorLogoFilename");
		if(donorLogoFilename == null) {
			_donorLogoFilename(donorLogoFilenameWrap);
			setDonorLogoFilename(donorLogoFilenameWrap.o);
		}
		return (ChoiceReport)this;
	}

	public static String staticSolrDonorLogoFilename(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrDonorLogoFilename(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDonorLogoFilename(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSolrStrDonorLogoFilename(siteRequest_, ChoiceReport.staticSolrDonorLogoFilename(siteRequest_, ChoiceReport.staticSetDonorLogoFilename(siteRequest_, o)));
	}

	public String sqlDonorLogoFilename() {
		return donorLogoFilename;
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
				donorKeyInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			donorSearchPromise().onSuccess(donorSearch -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				donor_Init();
				donorFullNameInit();
				donorParentNameInit();
				donorIdInit();
				donorAttributeIdInit();
				donorInKindInit();
				donorTotalInit();
				donorYtdInit();
				donorQ1Init();
				donorQ2Init();
				donorQ3Init();
				donorQ4Init();
				donorLogoFilenameInit();
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
		if(donorSearch != null)
			donorSearch.setSiteRequest_(siteRequest_);
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
			case "donorKey":
				return oChoiceReport.donorKey;
			case "donorSearch":
				return oChoiceReport.donorSearch;
			case "donor_":
				return oChoiceReport.donor_;
			case "donorFullName":
				return oChoiceReport.donorFullName;
			case "donorParentName":
				return oChoiceReport.donorParentName;
			case "donorId":
				return oChoiceReport.donorId;
			case "donorAttributeId":
				return oChoiceReport.donorAttributeId;
			case "donorInKind":
				return oChoiceReport.donorInKind;
			case "donorTotal":
				return oChoiceReport.donorTotal;
			case "donorYtd":
				return oChoiceReport.donorYtd;
			case "donorQ1":
				return oChoiceReport.donorQ1;
			case "donorQ2":
				return oChoiceReport.donorQ2;
			case "donorQ3":
				return oChoiceReport.donorQ3;
			case "donorQ4":
				return oChoiceReport.donorQ4;
			case "donorLogoFilename":
				return oChoiceReport.donorLogoFilename;
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
			case "donorKey":
				if(oChoiceReport.getDonorKey() == null)
					oChoiceReport.setDonorKey(val == null ? null : (NumberUtils.isCreatable(val.toString()) ? Long.parseLong(val.toString()) : null));
				if(!saves.contains("donorKey"))
					saves.add("donorKey");
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
		case "donorKey":
			return ChoiceReport.staticSetDonorKey(siteRequest_, o);
		case "donorFullName":
			return ChoiceReport.staticSetDonorFullName(siteRequest_, o);
		case "donorParentName":
			return ChoiceReport.staticSetDonorParentName(siteRequest_, o);
		case "donorId":
			return ChoiceReport.staticSetDonorId(siteRequest_, o);
		case "donorAttributeId":
			return ChoiceReport.staticSetDonorAttributeId(siteRequest_, o);
		case "donorInKind":
			return ChoiceReport.staticSetDonorInKind(siteRequest_, o);
		case "donorTotal":
			return ChoiceReport.staticSetDonorTotal(siteRequest_, o);
		case "donorYtd":
			return ChoiceReport.staticSetDonorYtd(siteRequest_, o);
		case "donorQ1":
			return ChoiceReport.staticSetDonorQ1(siteRequest_, o);
		case "donorQ2":
			return ChoiceReport.staticSetDonorQ2(siteRequest_, o);
		case "donorQ3":
			return ChoiceReport.staticSetDonorQ3(siteRequest_, o);
		case "donorQ4":
			return ChoiceReport.staticSetDonorQ4(siteRequest_, o);
		case "donorLogoFilename":
			return ChoiceReport.staticSetDonorLogoFilename(siteRequest_, o);
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
		case "donorKey":
			return ChoiceReport.staticSolrDonorKey(siteRequest_, (Long)o);
		case "donorFullName":
			return ChoiceReport.staticSolrDonorFullName(siteRequest_, (String)o);
		case "donorParentName":
			return ChoiceReport.staticSolrDonorParentName(siteRequest_, (String)o);
		case "donorId":
			return ChoiceReport.staticSolrDonorId(siteRequest_, (Long)o);
		case "donorAttributeId":
			return ChoiceReport.staticSolrDonorAttributeId(siteRequest_, (String)o);
		case "donorInKind":
			return ChoiceReport.staticSolrDonorInKind(siteRequest_, (Long)o);
		case "donorTotal":
			return ChoiceReport.staticSolrDonorTotal(siteRequest_, (BigDecimal)o);
		case "donorYtd":
			return ChoiceReport.staticSolrDonorYtd(siteRequest_, (BigDecimal)o);
		case "donorQ1":
			return ChoiceReport.staticSolrDonorQ1(siteRequest_, (BigDecimal)o);
		case "donorQ2":
			return ChoiceReport.staticSolrDonorQ2(siteRequest_, (BigDecimal)o);
		case "donorQ3":
			return ChoiceReport.staticSolrDonorQ3(siteRequest_, (BigDecimal)o);
		case "donorQ4":
			return ChoiceReport.staticSolrDonorQ4(siteRequest_, (BigDecimal)o);
		case "donorLogoFilename":
			return ChoiceReport.staticSolrDonorLogoFilename(siteRequest_, (String)o);
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
		case "donorKey":
			return ChoiceReport.staticSolrStrDonorKey(siteRequest_, (Long)o);
		case "donorFullName":
			return ChoiceReport.staticSolrStrDonorFullName(siteRequest_, (String)o);
		case "donorParentName":
			return ChoiceReport.staticSolrStrDonorParentName(siteRequest_, (String)o);
		case "donorId":
			return ChoiceReport.staticSolrStrDonorId(siteRequest_, (Long)o);
		case "donorAttributeId":
			return ChoiceReport.staticSolrStrDonorAttributeId(siteRequest_, (String)o);
		case "donorInKind":
			return ChoiceReport.staticSolrStrDonorInKind(siteRequest_, (Long)o);
		case "donorTotal":
			return ChoiceReport.staticSolrStrDonorTotal(siteRequest_, (Double)o);
		case "donorYtd":
			return ChoiceReport.staticSolrStrDonorYtd(siteRequest_, (Double)o);
		case "donorQ1":
			return ChoiceReport.staticSolrStrDonorQ1(siteRequest_, (Double)o);
		case "donorQ2":
			return ChoiceReport.staticSolrStrDonorQ2(siteRequest_, (Double)o);
		case "donorQ3":
			return ChoiceReport.staticSolrStrDonorQ3(siteRequest_, (Double)o);
		case "donorQ4":
			return ChoiceReport.staticSolrStrDonorQ4(siteRequest_, (Double)o);
		case "donorLogoFilename":
			return ChoiceReport.staticSolrStrDonorLogoFilename(siteRequest_, (String)o);
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
		case "donorKey":
			return ChoiceReport.staticSolrFqDonorKey(siteRequest_, o);
		case "donorFullName":
			return ChoiceReport.staticSolrFqDonorFullName(siteRequest_, o);
		case "donorParentName":
			return ChoiceReport.staticSolrFqDonorParentName(siteRequest_, o);
		case "donorId":
			return ChoiceReport.staticSolrFqDonorId(siteRequest_, o);
		case "donorAttributeId":
			return ChoiceReport.staticSolrFqDonorAttributeId(siteRequest_, o);
		case "donorInKind":
			return ChoiceReport.staticSolrFqDonorInKind(siteRequest_, o);
		case "donorTotal":
			return ChoiceReport.staticSolrFqDonorTotal(siteRequest_, o);
		case "donorYtd":
			return ChoiceReport.staticSolrFqDonorYtd(siteRequest_, o);
		case "donorQ1":
			return ChoiceReport.staticSolrFqDonorQ1(siteRequest_, o);
		case "donorQ2":
			return ChoiceReport.staticSolrFqDonorQ2(siteRequest_, o);
		case "donorQ3":
			return ChoiceReport.staticSolrFqDonorQ3(siteRequest_, o);
		case "donorQ4":
			return ChoiceReport.staticSolrFqDonorQ4(siteRequest_, o);
		case "donorLogoFilename":
			return ChoiceReport.staticSolrFqDonorLogoFilename(siteRequest_, o);
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
			case "donorkey":
				if(val instanceof Long)
					setDonorKey((Long)val);
				saves.add("donorKey");
				return val;
			case "donorfullname":
				if(val instanceof String)
					setDonorFullName((String)val);
				saves.add("donorFullName");
				return val;
			case "donorparentname":
				if(val instanceof String)
					setDonorParentName((String)val);
				saves.add("donorParentName");
				return val;
			case "donorid":
				if(val instanceof Long)
					setDonorId((Long)val);
				saves.add("donorId");
				return val;
			case "donorattributeid":
				if(val instanceof String)
					setDonorAttributeId((String)val);
				saves.add("donorAttributeId");
				return val;
			case "donorinkind":
				if(val instanceof Long)
					setDonorInKind((Long)val);
				saves.add("donorInKind");
				return val;
			case "donortotal":
				if(val instanceof String)
					setDonorTotal((String)val);
				else if(val instanceof Number)
					setDonorTotal(new BigDecimal(((Number)val).doubleValue()));
				saves.add("donorTotal");
				return val;
			case "donorytd":
				if(val instanceof String)
					setDonorYtd((String)val);
				else if(val instanceof Number)
					setDonorYtd(new BigDecimal(((Number)val).doubleValue()));
				saves.add("donorYtd");
				return val;
			case "donorq1":
				if(val instanceof String)
					setDonorQ1((String)val);
				else if(val instanceof Number)
					setDonorQ1(new BigDecimal(((Number)val).doubleValue()));
				saves.add("donorQ1");
				return val;
			case "donorq2":
				if(val instanceof String)
					setDonorQ2((String)val);
				else if(val instanceof Number)
					setDonorQ2(new BigDecimal(((Number)val).doubleValue()));
				saves.add("donorQ2");
				return val;
			case "donorq3":
				if(val instanceof String)
					setDonorQ3((String)val);
				else if(val instanceof Number)
					setDonorQ3(new BigDecimal(((Number)val).doubleValue()));
				saves.add("donorQ3");
				return val;
			case "donorq4":
				if(val instanceof String)
					setDonorQ4((String)val);
				else if(val instanceof Number)
					setDonorQ4(new BigDecimal(((Number)val).doubleValue()));
				saves.add("donorQ4");
				return val;
			case "donorlogofilename":
				if(val instanceof String)
					setDonorLogoFilename((String)val);
				saves.add("donorLogoFilename");
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

			Long donorKey = (Long)solrDocument.get("donorKey_indexedstored_long");
			if(donorKey != null)
				oChoiceReport.setDonorKey(donorKey);

			if(saves.contains("donorFullName")) {
				String donorFullName = (String)solrDocument.get("donorFullName_indexedstored_string");
				if(donorFullName != null)
					oChoiceReport.setDonorFullName(donorFullName);
			}

			if(saves.contains("donorParentName")) {
				String donorParentName = (String)solrDocument.get("donorParentName_indexedstored_string");
				if(donorParentName != null)
					oChoiceReport.setDonorParentName(donorParentName);
			}

			if(saves.contains("donorId")) {
				Long donorId = (Long)solrDocument.get("donorId_indexedstored_long");
				if(donorId != null)
					oChoiceReport.setDonorId(donorId);
			}

			if(saves.contains("donorAttributeId")) {
				String donorAttributeId = (String)solrDocument.get("donorAttributeId_indexedstored_string");
				if(donorAttributeId != null)
					oChoiceReport.setDonorAttributeId(donorAttributeId);
			}

			if(saves.contains("donorInKind")) {
				Long donorInKind = (Long)solrDocument.get("donorInKind_indexedstored_long");
				if(donorInKind != null)
					oChoiceReport.setDonorInKind(donorInKind);
			}

			if(saves.contains("donorTotal")) {
				Double donorTotal = (Double)solrDocument.get("donorTotal_indexedstored_double");
				if(donorTotal != null)
					oChoiceReport.setDonorTotal(donorTotal);
			}

			if(saves.contains("donorYtd")) {
				Double donorYtd = (Double)solrDocument.get("donorYtd_indexedstored_double");
				if(donorYtd != null)
					oChoiceReport.setDonorYtd(donorYtd);
			}

			if(saves.contains("donorQ1")) {
				Double donorQ1 = (Double)solrDocument.get("donorQ1_indexedstored_double");
				if(donorQ1 != null)
					oChoiceReport.setDonorQ1(donorQ1);
			}

			if(saves.contains("donorQ2")) {
				Double donorQ2 = (Double)solrDocument.get("donorQ2_indexedstored_double");
				if(donorQ2 != null)
					oChoiceReport.setDonorQ2(donorQ2);
			}

			if(saves.contains("donorQ3")) {
				Double donorQ3 = (Double)solrDocument.get("donorQ3_indexedstored_double");
				if(donorQ3 != null)
					oChoiceReport.setDonorQ3(donorQ3);
			}

			if(saves.contains("donorQ4")) {
				Double donorQ4 = (Double)solrDocument.get("donorQ4_indexedstored_double");
				if(donorQ4 != null)
					oChoiceReport.setDonorQ4(donorQ4);
			}

			if(saves.contains("donorLogoFilename")) {
				String donorLogoFilename = (String)solrDocument.get("donorLogoFilename_indexedstored_string");
				if(donorLogoFilename != null)
					oChoiceReport.setDonorLogoFilename(donorLogoFilename);
			}
		}

		super.populateBaseModel(solrDocument);
	}

	public void indexChoiceReport(SolrInputDocument document) {
		if(donorKey != null) {
			document.addField("donorKey_indexedstored_long", donorKey);
		}
		if(donorFullName != null) {
			document.addField("donorFullName_indexedstored_string", donorFullName);
		}
		if(donorParentName != null) {
			document.addField("donorParentName_indexedstored_string", donorParentName);
		}
		if(donorId != null) {
			document.addField("donorId_indexedstored_long", donorId);
		}
		if(donorAttributeId != null) {
			document.addField("donorAttributeId_indexedstored_string", donorAttributeId);
		}
		if(donorInKind != null) {
			document.addField("donorInKind_indexedstored_long", donorInKind);
		}
		if(donorTotal != null) {
			document.addField("donorTotal_indexedstored_double", donorTotal.doubleValue());
		}
		if(donorYtd != null) {
			document.addField("donorYtd_indexedstored_double", donorYtd.doubleValue());
		}
		if(donorQ1 != null) {
			document.addField("donorQ1_indexedstored_double", donorQ1.doubleValue());
		}
		if(donorQ2 != null) {
			document.addField("donorQ2_indexedstored_double", donorQ2.doubleValue());
		}
		if(donorQ3 != null) {
			document.addField("donorQ3_indexedstored_double", donorQ3.doubleValue());
		}
		if(donorQ4 != null) {
			document.addField("donorQ4_indexedstored_double", donorQ4.doubleValue());
		}
		if(donorLogoFilename != null) {
			document.addField("donorLogoFilename_indexedstored_string", donorLogoFilename);
		}
		super.indexBaseModel(document);

	}

	public static String varIndexedChoiceReport(String entityVar) {
		switch(entityVar) {
			case "donorKey":
				return "donorKey_indexedstored_long";
			case "donorFullName":
				return "donorFullName_indexedstored_string";
			case "donorParentName":
				return "donorParentName_indexedstored_string";
			case "donorId":
				return "donorId_indexedstored_long";
			case "donorAttributeId":
				return "donorAttributeId_indexedstored_string";
			case "donorInKind":
				return "donorInKind_indexedstored_long";
			case "donorTotal":
				return "donorTotal_indexedstored_double";
			case "donorYtd":
				return "donorYtd_indexedstored_double";
			case "donorQ1":
				return "donorQ1_indexedstored_double";
			case "donorQ2":
				return "donorQ2_indexedstored_double";
			case "donorQ3":
				return "donorQ3_indexedstored_double";
			case "donorQ4":
				return "donorQ4_indexedstored_double";
			case "donorLogoFilename":
				return "donorLogoFilename_indexedstored_string";
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

		oChoiceReport.setDonorKey(Optional.ofNullable(solrDocument.get("donorKey_indexedstored_long")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorFullName(Optional.ofNullable(solrDocument.get("donorFullName_indexedstored_string")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorParentName(Optional.ofNullable(solrDocument.get("donorParentName_indexedstored_string")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorId(Optional.ofNullable(solrDocument.get("donorId_indexedstored_long")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorAttributeId(Optional.ofNullable(solrDocument.get("donorAttributeId_indexedstored_string")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorInKind(Optional.ofNullable(solrDocument.get("donorInKind_indexedstored_long")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorTotal(Optional.ofNullable(solrDocument.get("donorTotal_indexedstored_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorYtd(Optional.ofNullable(solrDocument.get("donorYtd_indexedstored_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorQ1(Optional.ofNullable(solrDocument.get("donorQ1_indexedstored_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorQ2(Optional.ofNullable(solrDocument.get("donorQ2_indexedstored_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorQ3(Optional.ofNullable(solrDocument.get("donorQ3_indexedstored_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorQ4(Optional.ofNullable(solrDocument.get("donorQ4_indexedstored_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorLogoFilename(Optional.ofNullable(solrDocument.get("donorLogoFilename_indexedstored_string")).map(v -> v.toString()).orElse(null));

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
			if(!Objects.equals(donorKey, original.getDonorKey()))
				apiRequest.addVars("donorKey");
			if(!Objects.equals(donorFullName, original.getDonorFullName()))
				apiRequest.addVars("donorFullName");
			if(!Objects.equals(donorParentName, original.getDonorParentName()))
				apiRequest.addVars("donorParentName");
			if(!Objects.equals(donorId, original.getDonorId()))
				apiRequest.addVars("donorId");
			if(!Objects.equals(donorAttributeId, original.getDonorAttributeId()))
				apiRequest.addVars("donorAttributeId");
			if(!Objects.equals(donorInKind, original.getDonorInKind()))
				apiRequest.addVars("donorInKind");
			if(!Objects.equals(donorTotal, original.getDonorTotal()))
				apiRequest.addVars("donorTotal");
			if(!Objects.equals(donorYtd, original.getDonorYtd()))
				apiRequest.addVars("donorYtd");
			if(!Objects.equals(donorQ1, original.getDonorQ1()))
				apiRequest.addVars("donorQ1");
			if(!Objects.equals(donorQ2, original.getDonorQ2()))
				apiRequest.addVars("donorQ2");
			if(!Objects.equals(donorQ3, original.getDonorQ3()))
				apiRequest.addVars("donorQ3");
			if(!Objects.equals(donorQ4, original.getDonorQ4()))
				apiRequest.addVars("donorQ4");
			if(!Objects.equals(donorLogoFilename, original.getDonorLogoFilename()))
				apiRequest.addVars("donorLogoFilename");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(donorKey).map(v -> "donorKey: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(donorFullName).map(v -> "donorFullName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(donorParentName).map(v -> "donorParentName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(donorId).map(v -> "donorId: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(donorAttributeId).map(v -> "donorAttributeId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(donorInKind).map(v -> "donorInKind: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(donorTotal).map(v -> "donorTotal: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(donorYtd).map(v -> "donorYtd: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(donorQ1).map(v -> "donorQ1: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(donorQ2).map(v -> "donorQ2: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(donorQ3).map(v -> "donorQ3: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(donorQ4).map(v -> "donorQ4: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(donorLogoFilename).map(v -> "donorLogoFilename: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String VAR_donorKey = "donorKey";
	public static final String VAR_donorSearch = "donorSearch";
	public static final String VAR_donor_ = "donor_";
	public static final String VAR_donorFullName = "donorFullName";
	public static final String VAR_donorParentName = "donorParentName";
	public static final String VAR_donorId = "donorId";
	public static final String VAR_donorAttributeId = "donorAttributeId";
	public static final String VAR_donorInKind = "donorInKind";
	public static final String VAR_donorTotal = "donorTotal";
	public static final String VAR_donorYtd = "donorYtd";
	public static final String VAR_donorQ1 = "donorQ1";
	public static final String VAR_donorQ2 = "donorQ2";
	public static final String VAR_donorQ3 = "donorQ3";
	public static final String VAR_donorQ4 = "donorQ4";
	public static final String VAR_donorLogoFilename = "donorLogoFilename";
}
