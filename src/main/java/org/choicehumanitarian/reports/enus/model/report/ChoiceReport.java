package org.choicehumanitarian.reports.enus.model.report;

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
 * Map.Integer.sqlSort: 6
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
 * AName.enUS: a report
 * Color: pale-blue
 * IconGroup: regular
 * IconName: globe-americas
 * NameVar.enUS: report
 * 
 * Role.enUS: SiteAdmin
 * 
 * Rows: 100
**/          
public class ChoiceReport extends ChoiceReportGen<BaseModel> {

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
	 * Relate: ChoiceDonor.reportKeys
	 * HtmlRow: 10
	 * HtmlCell: 1
	 * DisplayName.enUS: donors
	 */        
	protected void _donorKeys(List<Long> c) {}
}
