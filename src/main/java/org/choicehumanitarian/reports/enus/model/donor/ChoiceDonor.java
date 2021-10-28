package org.choicehumanitarian.reports.enus.model.donor;                 

import java.math.BigDecimal;
import java.util.List;

import org.choicehumanitarian.reports.enus.base.BaseModel;
import org.choicehumanitarian.reports.enus.wrap.Wrap;

/**
 * Model: true
 * Api: true
 * Page: true
 * SuperPage.enUS: BaseModelPage
 * Indexed: true
 * Saved: true
 * Map.Integer.sqlSort: 5
 * 
 * ApiTag.enUS: Donor
 * ApiUri.enUS: /api/donor
 * 
 * ApiMethod.enUS: PUTImport

 * ApiMethod: POST
 * ApiMethod: PATCH
 * ApiMethod: GET
 * ApiMethod.enUS: Search
 * 
 * ApiMethod.enUS: SearchPage
 * PageSearchPage.enUS: ChoiceDonorPage
 * PageSuperSearchPage.enUS: BaseModelPage
 * ApiUriSearchPage.enUS: /donor
 * 
 * AName.enUS: a donor
 * Color: pale-blue
 * IconGroup: regular
 * IconName: globe-americas
 * NameVar.enUS: donor
 * 
 * Role.enUS: SiteAdmin
 * 
 * Rows: 100
**/         
public class ChoiceDonor extends ChoiceDonorGen<BaseModel> {

	/**  
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: donor full name
	 */  
	protected void _donorFullName(Wrap<String> w) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 2
	 * DisplayName.enUS: donor parent name
	 */  
	protected void _donorParentName(Wrap<String> w) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: donor ID
	 */  
	protected void _donorId(Wrap<Long> w) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 4
	 * HtmlCell: 2
	 * DisplayName.enUS: donor attribute ID
	 */  
	protected void _donorAttributeId(Wrap<String> w) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 4
	 * HtmlCell: 3
	 * DisplayName.enUS: in kind?
	 */  
	protected void _donorInKind(Wrap<Long> w) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 1
	 * DisplayName.enUS: total
	 */  
	protected void _donorTotal(Wrap<BigDecimal> w) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 2
	 * DisplayName.enUS: YTD
	 */  
	protected void _donorYtd(Wrap<BigDecimal> w) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 6
	 * HtmlCell: 1
	 * DisplayName.enUS: Q1
	 */  
	protected void _donorQ1(Wrap<BigDecimal> w) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 6
	 * HtmlCell: 2
	 * DisplayName.enUS: Q2
	 */   
	protected void _donorQ2(Wrap<BigDecimal> w) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 6
	 * HtmlCell: 3
	 * DisplayName.enUS: Q3
	 */  
	protected void _donorQ3(Wrap<BigDecimal> w) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 6
	 * HtmlCell: 4
	 * DisplayName.enUS: Q4
	 */  
	protected void _donorQ4(Wrap<BigDecimal> w) {
	}

	/**   
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 7
	 * HtmlCell: 1
	 * DisplayName.enUS: Logo Filename
	 */  
	protected void _donorLogoFilename(Wrap<String> w) {
	}

	/**  
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Relate: ChoiceReport.donorKey
	 * HtmlRow: 10
	 * HtmlCell: 1
	 * DisplayName.enUS: reports
	 */         
	protected void _reportKeys(List<Long> w) {}

	@Override
	protected void _objectTitle(Wrap<String> w) {
		w.o(donorFullName);
	}
}
