package org.choicehumanitarian.reports.enus.model.donor;              

import java.math.BigDecimal;

import org.choicehumanitarian.reports.enus.base.BaseModel;
import org.choicehumanitarian.reports.enus.wrap.Wrap;

/**
 * Model: true
 * Api: true
 * Page: true
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
	protected void _donorFullName(Wrap<String> c) {
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
	protected void _donorParentName(Wrap<String> c) {
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
	protected void _donorId(Wrap<Long> c) {
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
	protected void _donorAttributeId(Wrap<String> c) {
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
	protected void _donorInKind(Wrap<Long> c) {
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
	protected void _donorTotal(Wrap<BigDecimal> c) {
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
	protected void _donorYtd(Wrap<BigDecimal> c) {
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
	protected void _donorQ1(Wrap<BigDecimal> c) {
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
	protected void _donorQ2(Wrap<BigDecimal> c) {
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
	protected void _donorQ3(Wrap<BigDecimal> c) {
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
	protected void _donorQ4(Wrap<BigDecimal> c) {
	}
}
