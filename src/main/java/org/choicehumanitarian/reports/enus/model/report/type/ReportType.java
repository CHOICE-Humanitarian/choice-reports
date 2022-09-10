package org.choicehumanitarian.reports.enus.model.report.type;

import java.util.List;

import org.choicehumanitarian.reports.enus.model.base.BaseModel;
import org.computate.search.wrap.Wrap;

/**
 * Model: true
 * Api: true
 * Page: true
 * SuperPage.enUS: BaseModelPage
 * Indexed: true
 * Saved: true
 * Map.Integer.sqlSort: 4
 * Map.Integer.classSort: 4
 * Sort.asc: objectId
 * 
 * ApiTag.enUS: Report Type
 * ApiUri.enUS: /api/report-type
 * 
 * ApiMethod.enUS: PUTImport

 * ApiMethod: POST
 * ApiMethod: PATCH
 * ApiMethod: GET
 * ApiMethod.enUS: Search
 * 
 * ApiMethod.enUS: SearchPage
 * Page.SearchPage.enUS: ReportTypePage
 * PageSuper.SearchPage.enUS: BaseModelPage
 * ApiUri.SearchPage.enUS: /report-type
 * 
 * AName.enUS: a report type
 * Color: light-green
 * IconGroup: duotone
 * IconName: list-dropdown
 * NameVar.enUS: reportType
 * 
 * Role.enUS: SiteAdmin
 * 
 * Rows: 100
**/
public class ReportType extends ReportTypeGen<BaseModel> {

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: ReportSchedule.typeKey
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: report schedules
	 */
	protected void _scheduleKeys(List<Long> l) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: type name
	 */
	protected void _typeName(Wrap<String> w) {
	}

	@Override
	protected void _objectTitle(Wrap<String> w) {
		StringBuilder b = new StringBuilder();

		if(typeName != null) {
			b.append(typeName);
		} else {
			b.append(String.format("report type: %s", pk));
		}
		w.o(b.toString());
	}
}
