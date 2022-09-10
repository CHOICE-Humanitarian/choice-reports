package org.choicehumanitarian.reports.enus.model.report;

import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.model.base.BaseModel;
import io.vertx.core.json.JsonObject;
import java.util.Date;
import java.util.Set;
import org.computate.vertx.api.ApiRequest;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import java.util.Optional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.MathContext;
import org.apache.commons.lang3.math.NumberUtils;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.RoundingMode;
import java.util.Map;
import java.lang.Long;
import org.choicehumanitarian.reports.enus.model.donor.ChoiceDonor;
import java.lang.String;
import org.computate.vertx.search.list.SearchList;
import java.math.BigDecimal;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.response.solr.SolrResponse;

/**	
 * <h1>Suggestions that can generate more code for you: </h1>
 * <ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ChoiceReportGen into the class ChoiceReport. 
 * </li>
 * </ol>
 * <h1>About the ChoiceReport class and it's generated class ChoiceReportGen&lt;BaseModel&gt;: </h1>
 * <p>
 * This Java class extends a generated Java class built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport">Find the class ChoiceReport in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * <p>This class contains a comment "Model: true", which means this class will be stored in the database. 
 * Every protected void method that begins with "_" that contains a "Persist: true" comment will be a persisted field in the database table. 
 * </p>
 * <p>This class contains a comment "Indexed: true", which means this class will be indexed in the search engine. 
 * Every protected void method that begins with "_" that is marked to be searched with a comment like "Indexed: true", "Stored: true", or "DocValues: true" will be indexed in the search engine. 
 * </p>
 * <p>This class contains a comment "Page: true", which means this class will have webpage code generated for these objects. 
 * Java Vert.x backend API code, Handlebars HTML template frontend code, and JavaScript code will all generated and can be extended. 
 * This creates a new Java class org.choicehumanitarian.reports.enus.model.report.ChoiceReportPage. 
 * </p>
 * <p>This class contains a comment "SuperPage.enUS: BaseModelPage", which identifies the Java super class of the page code by it's class simple name "BaseModelPage". 
 * This means that the newly created class org.choicehumanitarian.reports.enus.model.report.ChoiceReportPage extends org.choicehumanitarian.reports.enus.model.base.BaseModelPage. 
 * </p>
 * <p>This class contains a comment "Api: true", which means this class will have Java Vert.x API backend code generated for these objects. 
 * </p>
 * <p>This class contains a comment "ApiTag: Report", which groups all of the OpenAPIs for ChoiceReport objects under the tag "Report". 
 * </p>
 * <p>This class contains a comment "ApiUri: /api/report", which defines the base API URI for ChoiceReport objects as "/api/report" in the OpenAPI spec. 
 * </p>
 * <p>
 * Delete the class ChoiceReport in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.choicehumanitarian.reports.enus.model.report in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project choice-reports in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:choice\-reports&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 **/
public abstract class ChoiceReportGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(ChoiceReport.class);

	public static final String ChoiceReport_AName_enUS = "a report";
	public static final String ChoiceReport_This_enUS = "this ";
	public static final String ChoiceReport_ThisName_enUS = "this report";
	public static final String ChoiceReport_A_enUS = "a ";
	public static final String ChoiceReport_TheName_enUS = "the report";
	public static final String ChoiceReport_NameSingular_enUS = "report";
	public static final String ChoiceReport_NamePlural_enUS = "reports";
	public static final String ChoiceReport_NameActual_enUS = "current report";
	public static final String ChoiceReport_AllName_enUS = "all the reports";
	public static final String ChoiceReport_SearchAllNameBy_enUS = "search reports by ";
	public static final String ChoiceReport_Title_enUS = "reports";
	public static final String ChoiceReport_ThePluralName_enUS = "the reports";
	public static final String ChoiceReport_NoNameFound_enUS = "no report found";
	public static final String ChoiceReport_NameVar_enUS = "report";
	public static final String ChoiceReport_OfName_enUS = "of report";
	public static final String ChoiceReport_ANameAdjective_enUS = "a report";
	public static final String ChoiceReport_NameAdjectiveSingular_enUS = "report";
	public static final String ChoiceReport_NameAdjectivePlural_enUS = "reports";
	public static final String PUTImport_enUS_Uri = "/api/report-import";
	public static final String PUTImport_enUS_ImageUri = "/png/api/report-import-999.png";
	public static final String POST_enUS_Uri = "/api/report";
	public static final String POST_enUS_ImageUri = "/png/api/report-999.png";
	public static final String PATCH_enUS_Uri = "/api/report";
	public static final String PATCH_enUS_ImageUri = "/png/api/report-999.png";
	public static final String GET_enUS_Uri = "/api/report/{id}";
	public static final String GET_enUS_ImageUri = "/png/api/report/{id}-999.png";
	public static final String Search_enUS_Uri = "/api/report";
	public static final String Search_enUS_ImageUri = "/png/api/report-999.png";
	public static final String SearchPage_enUS_Uri = "/report";
	public static final String SearchPage_enUS_ImageUri = "/png/report-999.png";
	public static final String ChoiceReportDisplaySearchPage_enUS_Uri = "/display-report";
	public static final String ChoiceReportDisplaySearchPage_enUS_ImageUri = "/png/display-report-999.png";
	public static final String ChoiceReportPdfSearchPage_enUS_Uri = "/pdf-report";
	public static final String ChoiceReportPdfSearchPage_enUS_ImageUri = "/png/pdf-report-999.png";

	public static final String ChoiceReport_Color = "cyan";
	public static final String ChoiceReport_IconGroup = "duotone";
	public static final String ChoiceReport_IconName = "file-chart-line";
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

	/**	<br> The entity donorKey
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorKey">Find the entity donorKey in Solr</a>
	 * <br>
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

	public static Long staticSearchDonorKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrDonorKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorKey(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorKey(siteRequest_, ChoiceReport.staticSearchDonorKey(siteRequest_, ChoiceReport.staticSetDonorKey(siteRequest_, o)));
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

	/**	<br> The entity donorSearch
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorSearch">Find the entity donorSearch in Solr</a>
	 * <br>
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

	/**	<br> The entity donor_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donor_">Find the entity donor_ in Solr</a>
	 * <br>
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

	/**	<br> The entity donorFullName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorFullName">Find the entity donorFullName in Solr</a>
	 * <br>
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

	public static String staticSearchDonorFullName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDonorFullName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorFullName(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorFullName(siteRequest_, ChoiceReport.staticSearchDonorFullName(siteRequest_, ChoiceReport.staticSetDonorFullName(siteRequest_, o)));
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

	/**	<br> The entity donorParentName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorParentName">Find the entity donorParentName in Solr</a>
	 * <br>
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

	public static String staticSearchDonorParentName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDonorParentName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorParentName(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorParentName(siteRequest_, ChoiceReport.staticSearchDonorParentName(siteRequest_, ChoiceReport.staticSetDonorParentName(siteRequest_, o)));
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

	/**	<br> The entity donorId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorId">Find the entity donorId in Solr</a>
	 * <br>
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

	public static Long staticSearchDonorId(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrDonorId(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorId(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorId(siteRequest_, ChoiceReport.staticSearchDonorId(siteRequest_, ChoiceReport.staticSetDonorId(siteRequest_, o)));
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

	/**	<br> The entity donorAttributeId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorAttributeId">Find the entity donorAttributeId in Solr</a>
	 * <br>
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

	public static String staticSearchDonorAttributeId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDonorAttributeId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorAttributeId(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorAttributeId(siteRequest_, ChoiceReport.staticSearchDonorAttributeId(siteRequest_, ChoiceReport.staticSetDonorAttributeId(siteRequest_, o)));
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

	/**	<br> The entity donorInKind
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorInKind">Find the entity donorInKind in Solr</a>
	 * <br>
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

	public static Long staticSearchDonorInKind(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrDonorInKind(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorInKind(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorInKind(siteRequest_, ChoiceReport.staticSearchDonorInKind(siteRequest_, ChoiceReport.staticSetDonorInKind(siteRequest_, o)));
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

	/**	<br> The entity donorTotal
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorTotal">Find the entity donorTotal in Solr</a>
	 * <br>
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

	public static Double staticSearchDonorTotal(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrDonorTotal(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorTotal(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorTotal(siteRequest_, ChoiceReport.staticSearchDonorTotal(siteRequest_, ChoiceReport.staticSetDonorTotal(siteRequest_, o)));
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

	/**	<br> The entity donorYtd
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorYtd">Find the entity donorYtd in Solr</a>
	 * <br>
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

	public static Double staticSearchDonorYtd(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrDonorYtd(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorYtd(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorYtd(siteRequest_, ChoiceReport.staticSearchDonorYtd(siteRequest_, ChoiceReport.staticSetDonorYtd(siteRequest_, o)));
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

	/**	<br> The entity donorQ1
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorQ1">Find the entity donorQ1 in Solr</a>
	 * <br>
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

	public static Double staticSearchDonorQ1(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrDonorQ1(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorQ1(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorQ1(siteRequest_, ChoiceReport.staticSearchDonorQ1(siteRequest_, ChoiceReport.staticSetDonorQ1(siteRequest_, o)));
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

	/**	<br> The entity donorQ2
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorQ2">Find the entity donorQ2 in Solr</a>
	 * <br>
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

	public static Double staticSearchDonorQ2(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrDonorQ2(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorQ2(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorQ2(siteRequest_, ChoiceReport.staticSearchDonorQ2(siteRequest_, ChoiceReport.staticSetDonorQ2(siteRequest_, o)));
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

	/**	<br> The entity donorQ3
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorQ3">Find the entity donorQ3 in Solr</a>
	 * <br>
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

	public static Double staticSearchDonorQ3(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrDonorQ3(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorQ3(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorQ3(siteRequest_, ChoiceReport.staticSearchDonorQ3(siteRequest_, ChoiceReport.staticSetDonorQ3(siteRequest_, o)));
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

	/**	<br> The entity donorQ4
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorQ4">Find the entity donorQ4 in Solr</a>
	 * <br>
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

	public static Double staticSearchDonorQ4(SiteRequestEnUS siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrDonorQ4(SiteRequestEnUS siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorQ4(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorQ4(siteRequest_, ChoiceReport.staticSearchDonorQ4(siteRequest_, ChoiceReport.staticSetDonorQ4(siteRequest_, o)));
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

	/**	<br> The entity donorLogoFilename
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.choicehumanitarian.reports.enus.model.report.ChoiceReport&fq=entiteVar_enUS_indexed_string:donorLogoFilename">Find the entity donorLogoFilename in Solr</a>
	 * <br>
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

	public static String staticSearchDonorLogoFilename(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDonorLogoFilename(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDonorLogoFilename(SiteRequestEnUS siteRequest_, String o) {
		return ChoiceReport.staticSearchStrDonorLogoFilename(siteRequest_, ChoiceReport.staticSearchDonorLogoFilename(siteRequest_, ChoiceReport.staticSetDonorLogoFilename(siteRequest_, o)));
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
					oChoiceReport.setDonorKey(val == null ? null : (NumberUtils.isCreatable(val.toString()) ? Long.parseLong(val.toString()) : -1));
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
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchChoiceReport(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchChoiceReport(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "donorKey":
			return ChoiceReport.staticSearchDonorKey(siteRequest_, (Long)o);
		case "donorFullName":
			return ChoiceReport.staticSearchDonorFullName(siteRequest_, (String)o);
		case "donorParentName":
			return ChoiceReport.staticSearchDonorParentName(siteRequest_, (String)o);
		case "donorId":
			return ChoiceReport.staticSearchDonorId(siteRequest_, (Long)o);
		case "donorAttributeId":
			return ChoiceReport.staticSearchDonorAttributeId(siteRequest_, (String)o);
		case "donorInKind":
			return ChoiceReport.staticSearchDonorInKind(siteRequest_, (Long)o);
		case "donorTotal":
			return ChoiceReport.staticSearchDonorTotal(siteRequest_, (BigDecimal)o);
		case "donorYtd":
			return ChoiceReport.staticSearchDonorYtd(siteRequest_, (BigDecimal)o);
		case "donorQ1":
			return ChoiceReport.staticSearchDonorQ1(siteRequest_, (BigDecimal)o);
		case "donorQ2":
			return ChoiceReport.staticSearchDonorQ2(siteRequest_, (BigDecimal)o);
		case "donorQ3":
			return ChoiceReport.staticSearchDonorQ3(siteRequest_, (BigDecimal)o);
		case "donorQ4":
			return ChoiceReport.staticSearchDonorQ4(siteRequest_, (BigDecimal)o);
		case "donorLogoFilename":
			return ChoiceReport.staticSearchDonorLogoFilename(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSearchStrChoiceReport(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrChoiceReport(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "donorKey":
			return ChoiceReport.staticSearchStrDonorKey(siteRequest_, (Long)o);
		case "donorFullName":
			return ChoiceReport.staticSearchStrDonorFullName(siteRequest_, (String)o);
		case "donorParentName":
			return ChoiceReport.staticSearchStrDonorParentName(siteRequest_, (String)o);
		case "donorId":
			return ChoiceReport.staticSearchStrDonorId(siteRequest_, (Long)o);
		case "donorAttributeId":
			return ChoiceReport.staticSearchStrDonorAttributeId(siteRequest_, (String)o);
		case "donorInKind":
			return ChoiceReport.staticSearchStrDonorInKind(siteRequest_, (Long)o);
		case "donorTotal":
			return ChoiceReport.staticSearchStrDonorTotal(siteRequest_, (Double)o);
		case "donorYtd":
			return ChoiceReport.staticSearchStrDonorYtd(siteRequest_, (Double)o);
		case "donorQ1":
			return ChoiceReport.staticSearchStrDonorQ1(siteRequest_, (Double)o);
		case "donorQ2":
			return ChoiceReport.staticSearchStrDonorQ2(siteRequest_, (Double)o);
		case "donorQ3":
			return ChoiceReport.staticSearchStrDonorQ3(siteRequest_, (Double)o);
		case "donorQ4":
			return ChoiceReport.staticSearchStrDonorQ4(siteRequest_, (Double)o);
		case "donorLogoFilename":
			return ChoiceReport.staticSearchStrDonorLogoFilename(siteRequest_, (String)o);
			default:
				return BaseModel.staticSearchStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSearchFqChoiceReport(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqChoiceReport(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "donorKey":
			return ChoiceReport.staticSearchFqDonorKey(siteRequest_, o);
		case "donorFullName":
			return ChoiceReport.staticSearchFqDonorFullName(siteRequest_, o);
		case "donorParentName":
			return ChoiceReport.staticSearchFqDonorParentName(siteRequest_, o);
		case "donorId":
			return ChoiceReport.staticSearchFqDonorId(siteRequest_, o);
		case "donorAttributeId":
			return ChoiceReport.staticSearchFqDonorAttributeId(siteRequest_, o);
		case "donorInKind":
			return ChoiceReport.staticSearchFqDonorInKind(siteRequest_, o);
		case "donorTotal":
			return ChoiceReport.staticSearchFqDonorTotal(siteRequest_, o);
		case "donorYtd":
			return ChoiceReport.staticSearchFqDonorYtd(siteRequest_, o);
		case "donorQ1":
			return ChoiceReport.staticSearchFqDonorQ1(siteRequest_, o);
		case "donorQ2":
			return ChoiceReport.staticSearchFqDonorQ2(siteRequest_, o);
		case "donorQ3":
			return ChoiceReport.staticSearchFqDonorQ3(siteRequest_, o);
		case "donorQ4":
			return ChoiceReport.staticSearchFqDonorQ4(siteRequest_, o);
		case "donorLogoFilename":
			return ChoiceReport.staticSearchFqDonorLogoFilename(siteRequest_, o);
			default:
				return BaseModel.staticSearchFqBaseModel(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// persist //
	/////////////

	@Override public boolean persistForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = persistChoiceReport(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object persistChoiceReport(String var, Object val) {
		switch(var.toLowerCase()) {
			case "donorkey":
				if(val instanceof Long)
					setDonorKey((Long)val);
				else if(val instanceof String)
					setDonorKey((String)val);
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
				else if(val instanceof String)
					setDonorId((String)val);
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
				else if(val instanceof String)
					setDonorInKind((String)val);
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
				return super.persistBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateChoiceReport(doc);
	}
	public void populateChoiceReport(SolrResponse.Doc doc) {
		ChoiceReport oChoiceReport = (ChoiceReport)this;
		saves = doc.get("saves_docvalues_strings");
		if(saves != null) {
		}

		super.populateBaseModel(doc);
	}

	public void indexChoiceReport(JsonObject doc) {
		if(donorKey != null) {
			doc.put("donorKey_docvalues_long", donorKey);
		}
		if(donorFullName != null) {
			doc.put("donorFullName_docvalues_string", donorFullName);
		}
		if(donorParentName != null) {
			doc.put("donorParentName_docvalues_string", donorParentName);
		}
		if(donorId != null) {
			doc.put("donorId_docvalues_long", donorId);
		}
		if(donorAttributeId != null) {
			doc.put("donorAttributeId_docvalues_string", donorAttributeId);
		}
		if(donorInKind != null) {
			doc.put("donorInKind_docvalues_long", donorInKind);
		}
		if(donorTotal != null) {
			doc.put("donorTotal_docvalues_double", donorTotal.doubleValue());
		}
		if(donorYtd != null) {
			doc.put("donorYtd_docvalues_double", donorYtd.doubleValue());
		}
		if(donorQ1 != null) {
			doc.put("donorQ1_docvalues_double", donorQ1.doubleValue());
		}
		if(donorQ2 != null) {
			doc.put("donorQ2_docvalues_double", donorQ2.doubleValue());
		}
		if(donorQ3 != null) {
			doc.put("donorQ3_docvalues_double", donorQ3.doubleValue());
		}
		if(donorQ4 != null) {
			doc.put("donorQ4_docvalues_double", donorQ4.doubleValue());
		}
		if(donorLogoFilename != null) {
			doc.put("donorLogoFilename_docvalues_string", donorLogoFilename);
		}
		super.indexBaseModel(doc);

	}

	public static String varStoredChoiceReport(String entityVar) {
		switch(entityVar) {
			case "donorKey":
				return "donorKey_docvalues_long";
			case "donorFullName":
				return "donorFullName_docvalues_string";
			case "donorParentName":
				return "donorParentName_docvalues_string";
			case "donorId":
				return "donorId_docvalues_long";
			case "donorAttributeId":
				return "donorAttributeId_docvalues_string";
			case "donorInKind":
				return "donorInKind_docvalues_long";
			case "donorTotal":
				return "donorTotal_docvalues_double";
			case "donorYtd":
				return "donorYtd_docvalues_double";
			case "donorQ1":
				return "donorQ1_docvalues_double";
			case "donorQ2":
				return "donorQ2_docvalues_double";
			case "donorQ3":
				return "donorQ3_docvalues_double";
			case "donorQ4":
				return "donorQ4_docvalues_double";
			case "donorLogoFilename":
				return "donorLogoFilename_docvalues_string";
			default:
				return BaseModel.varStoredBaseModel(entityVar);
		}
	}

	public static String varIndexedChoiceReport(String entityVar) {
		switch(entityVar) {
			case "donorKey":
				return "donorKey_docvalues_long";
			case "donorFullName":
				return "donorFullName_docvalues_string";
			case "donorParentName":
				return "donorParentName_docvalues_string";
			case "donorId":
				return "donorId_docvalues_long";
			case "donorAttributeId":
				return "donorAttributeId_docvalues_string";
			case "donorInKind":
				return "donorInKind_docvalues_long";
			case "donorTotal":
				return "donorTotal_docvalues_double";
			case "donorYtd":
				return "donorYtd_docvalues_double";
			case "donorQ1":
				return "donorQ1_docvalues_double";
			case "donorQ2":
				return "donorQ2_docvalues_double";
			case "donorQ3":
				return "donorQ3_docvalues_double";
			case "donorQ4":
				return "donorQ4_docvalues_double";
			case "donorLogoFilename":
				return "donorLogoFilename_docvalues_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String searchVarChoiceReport(String searchVar) {
		switch(searchVar) {
			case "donorKey_docvalues_long":
				return "donorKey";
			case "donorFullName_docvalues_string":
				return "donorFullName";
			case "donorParentName_docvalues_string":
				return "donorParentName";
			case "donorId_docvalues_long":
				return "donorId";
			case "donorAttributeId_docvalues_string":
				return "donorAttributeId";
			case "donorInKind_docvalues_long":
				return "donorInKind";
			case "donorTotal_docvalues_double":
				return "donorTotal";
			case "donorYtd_docvalues_double":
				return "donorYtd";
			case "donorQ1_docvalues_double":
				return "donorQ1";
			case "donorQ2_docvalues_double":
				return "donorQ2";
			case "donorQ3_docvalues_double":
				return "donorQ3";
			case "donorQ4_docvalues_double":
				return "donorQ4";
			case "donorLogoFilename_docvalues_string":
				return "donorLogoFilename";
			default:
				return BaseModel.searchVarBaseModel(searchVar);
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

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeChoiceReport(doc);
	}
	public void storeChoiceReport(SolrResponse.Doc doc) {
		ChoiceReport oChoiceReport = (ChoiceReport)this;

		oChoiceReport.setDonorKey(Optional.ofNullable(doc.get("donorKey_docvalues_long")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorFullName(Optional.ofNullable(doc.get("donorFullName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorParentName(Optional.ofNullable(doc.get("donorParentName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorId(Optional.ofNullable(doc.get("donorId_docvalues_long")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorAttributeId(Optional.ofNullable(doc.get("donorAttributeId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorInKind(Optional.ofNullable(doc.get("donorInKind_docvalues_long")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorTotal(Optional.ofNullable(doc.get("donorTotal_docvalues_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorYtd(Optional.ofNullable(doc.get("donorYtd_docvalues_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorQ1(Optional.ofNullable(doc.get("donorQ1_docvalues_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorQ2(Optional.ofNullable(doc.get("donorQ2_docvalues_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorQ3(Optional.ofNullable(doc.get("donorQ3_docvalues_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorQ4(Optional.ofNullable(doc.get("donorQ4_docvalues_double")).map(v -> v.toString()).orElse(null));
		oChoiceReport.setDonorLogoFilename(Optional.ofNullable(doc.get("donorLogoFilename_docvalues_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestChoiceReport() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(r -> r.getApiRequest_()).orElse(null);
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

	public static final String CLASS_SIMPLE_NAME = "ChoiceReport";
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

	public static List<String> varsQForClass() {
		return ChoiceReport.varsQChoiceReport(new ArrayList<String>());
	}
	public static List<String> varsQChoiceReport(List<String> vars) {
		BaseModel.varsQBaseModel(vars);
		return vars;
	}

	public static List<String> varsFqForClass() {
		return ChoiceReport.varsFqChoiceReport(new ArrayList<String>());
	}
	public static List<String> varsFqChoiceReport(List<String> vars) {
		BaseModel.varsFqBaseModel(vars);
		return vars;
	}

	public static List<String> varsRangeForClass() {
		return ChoiceReport.varsRangeChoiceReport(new ArrayList<String>());
	}
	public static List<String> varsRangeChoiceReport(List<String> vars) {
		BaseModel.varsRangeBaseModel(vars);
		return vars;
	}

	public static final String DISPLAY_NAME_donorKey = "donor";
	public static final String DISPLAY_NAME_donorSearch = "";
	public static final String DISPLAY_NAME_donor_ = "";
	public static final String DISPLAY_NAME_donorFullName = "donor full name";
	public static final String DISPLAY_NAME_donorParentName = "donor parent name";
	public static final String DISPLAY_NAME_donorId = "donor ID";
	public static final String DISPLAY_NAME_donorAttributeId = "donor attribute ID";
	public static final String DISPLAY_NAME_donorInKind = "in kind?";
	public static final String DISPLAY_NAME_donorTotal = "total";
	public static final String DISPLAY_NAME_donorYtd = "YTD";
	public static final String DISPLAY_NAME_donorQ1 = "Q1";
	public static final String DISPLAY_NAME_donorQ2 = "Q2";
	public static final String DISPLAY_NAME_donorQ3 = "Q3";
	public static final String DISPLAY_NAME_donorQ4 = "Q4";
	public static final String DISPLAY_NAME_donorLogoFilename = "Logo Filename";

	public static String displayNameForClass(String var) {
		return ChoiceReport.displayNameChoiceReport(var);
	}
	public static String displayNameChoiceReport(String var) {
		switch(var) {
		case VAR_donorKey:
			return DISPLAY_NAME_donorKey;
		case VAR_donorSearch:
			return DISPLAY_NAME_donorSearch;
		case VAR_donor_:
			return DISPLAY_NAME_donor_;
		case VAR_donorFullName:
			return DISPLAY_NAME_donorFullName;
		case VAR_donorParentName:
			return DISPLAY_NAME_donorParentName;
		case VAR_donorId:
			return DISPLAY_NAME_donorId;
		case VAR_donorAttributeId:
			return DISPLAY_NAME_donorAttributeId;
		case VAR_donorInKind:
			return DISPLAY_NAME_donorInKind;
		case VAR_donorTotal:
			return DISPLAY_NAME_donorTotal;
		case VAR_donorYtd:
			return DISPLAY_NAME_donorYtd;
		case VAR_donorQ1:
			return DISPLAY_NAME_donorQ1;
		case VAR_donorQ2:
			return DISPLAY_NAME_donorQ2;
		case VAR_donorQ3:
			return DISPLAY_NAME_donorQ3;
		case VAR_donorQ4:
			return DISPLAY_NAME_donorQ4;
		case VAR_donorLogoFilename:
			return DISPLAY_NAME_donorLogoFilename;
		default:
			return BaseModel.displayNameBaseModel(var);
		}
	}

	public static String descriptionChoiceReport(String var) {
		switch(var) {
			default:
				return BaseModel.descriptionBaseModel(var);
		}
	}

	public static String classSimpleNameChoiceReport(String var) {
		switch(var) {
		case VAR_donorKey:
			return "Long";
		case VAR_donorSearch:
			return "SearchList";
		case VAR_donor_:
			return "ChoiceDonor";
		case VAR_donorFullName:
			return "String";
		case VAR_donorParentName:
			return "String";
		case VAR_donorId:
			return "Long";
		case VAR_donorAttributeId:
			return "String";
		case VAR_donorInKind:
			return "Long";
		case VAR_donorTotal:
			return "BigDecimal";
		case VAR_donorYtd:
			return "BigDecimal";
		case VAR_donorQ1:
			return "BigDecimal";
		case VAR_donorQ2:
			return "BigDecimal";
		case VAR_donorQ3:
			return "BigDecimal";
		case VAR_donorQ4:
			return "BigDecimal";
		case VAR_donorLogoFilename:
			return "String";
			default:
				return BaseModel.classSimpleNameBaseModel(var);
		}
	}

	public static Integer htmlColumnChoiceReport(String var) {
		switch(var) {
			default:
				return BaseModel.htmlColumnBaseModel(var);
		}
	}

	public static Integer htmlRowChoiceReport(String var) {
		switch(var) {
		case VAR_donorKey:
			return 3;
		case VAR_donorFullName:
			return 3;
		case VAR_donorParentName:
			return 3;
		case VAR_donorId:
			return 4;
		case VAR_donorAttributeId:
			return 4;
		case VAR_donorInKind:
			return 4;
		case VAR_donorTotal:
			return 5;
		case VAR_donorYtd:
			return 5;
		case VAR_donorQ1:
			return 6;
		case VAR_donorQ2:
			return 6;
		case VAR_donorQ3:
			return 6;
		case VAR_donorQ4:
			return 6;
		case VAR_donorLogoFilename:
			return 7;
			default:
				return BaseModel.htmlRowBaseModel(var);
		}
	}

	public static Integer htmlCellChoiceReport(String var) {
		switch(var) {
		case VAR_donorKey:
			return 1;
		case VAR_donorFullName:
			return 1;
		case VAR_donorParentName:
			return 2;
		case VAR_donorId:
			return 1;
		case VAR_donorAttributeId:
			return 2;
		case VAR_donorInKind:
			return 3;
		case VAR_donorTotal:
			return 1;
		case VAR_donorYtd:
			return 2;
		case VAR_donorQ1:
			return 1;
		case VAR_donorQ2:
			return 2;
		case VAR_donorQ3:
			return 3;
		case VAR_donorQ4:
			return 4;
		case VAR_donorLogoFilename:
			return 1;
			default:
				return BaseModel.htmlCellBaseModel(var);
		}
	}

	public static Integer lengthMinChoiceReport(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMinBaseModel(var);
		}
	}

	public static Integer lengthMaxChoiceReport(String var) {
		switch(var) {
			default:
				return BaseModel.lengthMaxBaseModel(var);
		}
	}

	public static Integer maxChoiceReport(String var) {
		switch(var) {
			default:
				return BaseModel.maxBaseModel(var);
		}
	}

	public static Integer minChoiceReport(String var) {
		switch(var) {
			default:
				return BaseModel.minBaseModel(var);
		}
	}
}
