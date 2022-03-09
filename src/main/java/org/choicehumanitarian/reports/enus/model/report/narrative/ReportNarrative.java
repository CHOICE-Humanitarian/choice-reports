package org.choicehumanitarian.reports.enus.model.report.narrative;

import org.choicehumanitarian.reports.enus.base.BaseModel;
import org.computate.search.wrap.Wrap;

/**
 * Model: true
 * Api: true
 * Page: true
 * SuperPage.enUS: BaseModelPage
 * Indexed: true
 * Saved: true
 * Map.Integer.sqlSort: 6
 * Sort.asc: objectId
 * 
 * ApiTag.enUS: Report Narrative
 * ApiUri.enUS: /api/report-narrative
 * 
 * ApiMethod.enUS: PUTImport

 * ApiMethod: POST
 * ApiMethod: PATCH
 * ApiMethod: GET
 * ApiMethod.enUS: Search
 * 
 * ApiMethod.enUS: SearchPage
 * PageSearchPage.enUS: ReportNarrativePage
 * PageSuperSearchPage.enUS: BaseModelPage
 * ApiUriSearchPage.enUS: /report-narrative
 * 
 * AName.enUS: a report narrative
 * Color: light-green
 * IconGroup: duotone
 * IconName: calendar-pen
 * NameVar.enUS: reportNarrative
 * 
 * Role.enUS: SiteAdmin
 * 
 * Rows: 100
**/
public class ReportNarrative extends ReportNarrativeGen<BaseModel> {

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: ReportSchedule.narrativeKeys
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: schedule
	 */        
	protected void _scheduleKey(Wrap<Long> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: narrative name
	 */
	protected void _narrativeName(Wrap<String> w) {
	}

	@Override
	protected void _objectTitle(Wrap<String> w) {
		StringBuilder b = new StringBuilder();

		if(narrativeName != null) {
			b.append(narrativeName);
		} else {
			b.append(String.format("report narrative: %s", id));
		}
		w.o(b.toString());
	}
}
