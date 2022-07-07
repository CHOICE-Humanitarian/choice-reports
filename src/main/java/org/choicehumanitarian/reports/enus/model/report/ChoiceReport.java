package org.choicehumanitarian.reports.enus.model.report;

import java.math.BigDecimal;

import org.choicehumanitarian.reports.enus.model.base.BaseModel;
import org.choicehumanitarian.reports.enus.model.donor.ChoiceDonor;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.search.list.SearchList;

import io.vertx.core.Promise;

/**
 * Model: true
 * Api: true
 * Page: true
 * SuperPage.enUS: BaseModelPage
 * Indexed: true
 * Saved: true
 * Map.Integer.sqlSort: 3
 * Map.Integer.classSort: 3
 * 
 * ApiTag.enUS: Report
 * ApiUri.enUS: /api/report
 * 
 * ApiMethod.enUS: PUTImport

 * ApiMethod: POST
 * ApiMethod: PATCH
 * ApiMethod: GET
 * ApiMethod.enUS: Search
 * 
 * ApiMethod.enUS: SearchPage
 * PageSearchPage.enUS: ChoiceReportPage
 * PageSuperSearchPage.enUS: BaseModelPage
 * ApiUriSearchPage.enUS: /report
 * 
 * ApiMethod.enUS: ChoiceReportDisplaySearchPage
 * PageChoiceReportDisplaySearchPage.enUS: ChoiceReportDisplayPage
 * PageSuperChoiceReportDisplaySearchPage.enUS: BaseModelPage
 * ApiUriChoiceReportDisplaySearchPage.enUS: /display-report
 * 
 * ApiMethod.enUS: ChoiceReportPdfSearchPage
 * PageChoiceReportPdfSearchPage.enUS: ChoiceReportPdfPage
 * PageSuperChoiceReportPdfSearchPage.enUS: BaseModelPage
 * ApiUriChoiceReportPdfSearchPage.enUS: /pdf-report
 * 
 * AName.enUS: a report
 * Color: cyan
 * IconGroup: duotone
 * IconName: file-chart-line
 * NameVar.enUS: report
 * 
 * Role.enUS: SiteAdmin
 * 
 * Rows: 100
**/          
public class ChoiceReport extends ChoiceReportGen<BaseModel> {

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: ChoiceDonor.reportKeys
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: donor
	 */         
	protected void _donorKey(Wrap<Long> w) {
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */      
	protected void _donorSearch(Promise<SearchList<ChoiceDonor>> promise) {
		SearchList<ChoiceDonor> l = new SearchList<>();
		l.q("*:*");
		l.fq("pk_docvalues_long:" + donorKey);
		l.setC(ChoiceDonor.class);
		l.setStore(true);
		promise.complete(l);
	}

	protected void _donor_(Wrap<ChoiceDonor> w) {
		if(donorSearch.size() > 0) {
			w.o(donorSearch.get(0));
		}
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: donor full name
	 */  
	protected void _donorFullName(Wrap<String> w) {
		if(donor_ != null)
			w.o(donor_.getDonorFullName());
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 3
	 * HtmlCell: 2
	 * DisplayName.enUS: donor parent name
	 */  
	protected void _donorParentName(Wrap<String> w) {
		if(donor_ != null)
			w.o(donor_.getDonorParentName());
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: donor ID
	 */  
	protected void _donorId(Wrap<Long> w) {
		if(donor_ != null)
			w.o(donor_.getDonorId());
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 4
	 * HtmlCell: 2
	 * DisplayName.enUS: donor attribute ID
	 */  
	protected void _donorAttributeId(Wrap<String> w) {
		if(donor_ != null)
			w.o(donor_.getDonorAttributeId());
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 4
	 * HtmlCell: 3
	 * DisplayName.enUS: in kind?
	 */  
	protected void _donorInKind(Wrap<Long> w) {
		if(donor_ != null)
			w.o(donor_.getDonorInKind());
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 5
	 * HtmlCell: 1
	 * DisplayName.enUS: total
	 */  
	protected void _donorTotal(Wrap<BigDecimal> w) {
		if(donor_ != null)
			w.o(donor_.getDonorTotal());
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 5
	 * HtmlCell: 2
	 * DisplayName.enUS: YTD
	 */  
	protected void _donorYtd(Wrap<BigDecimal> w) {
		if(donor_ != null)
			w.o(donor_.getDonorYtd());
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 6
	 * HtmlCell: 1
	 * DisplayName.enUS: Q1
	 */  
	protected void _donorQ1(Wrap<BigDecimal> w) {
		if(donor_ != null)
			w.o(donor_.getDonorQ1());
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 6
	 * HtmlCell: 2
	 * DisplayName.enUS: Q2
	 */   
	protected void _donorQ2(Wrap<BigDecimal> w) {
		if(donor_ != null)
			w.o(donor_.getDonorQ2());
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 6
	 * HtmlCell: 3
	 * DisplayName.enUS: Q3
	 */  
	protected void _donorQ3(Wrap<BigDecimal> w) {
		if(donor_ != null)
			w.o(donor_.getDonorQ3());
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 6
	 * HtmlCell: 4
	 * DisplayName.enUS: Q4
	 */  
	protected void _donorQ4(Wrap<BigDecimal> w) {
		if(donor_ != null)
			w.o(donor_.getDonorQ4());
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 7
	 * HtmlCell: 1
	 * DisplayName.enUS: Logo Filename
	 */  
	protected void _donorLogoFilename(Wrap<String> w) {
		if(donor_ != null)
			w.o(donor_.getDonorLogoFilename());
	}
}
