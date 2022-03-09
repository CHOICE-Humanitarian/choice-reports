package org.choicehumanitarian.reports.enus.model.report.event;

import org.choicehumanitarian.reports.enus.base.BaseModel;
import org.computate.search.wrap.Wrap;

/**
 * Model: true
 * Api: true
 * Page: true
 * SuperPage.enUS: BaseModelPage
 * Indexed: true
 * Saved: true
 * Map.Integer.sqlSort: 5
 * Sort.asc: objectId
 * 
 * ApiTag.enUS: Report Event
 * ApiUri.enUS: /api/report-event
 * 
 * ApiMethod.enUS: PUTImport

 * ApiMethod: POST
 * ApiMethod: PATCH
 * ApiMethod: GET
 * ApiMethod.enUS: Search
 * 
 * ApiMethod.enUS: SearchPage
 * PageSearchPage.enUS: ReportEventPage
 * PageSuperSearchPage.enUS: BaseModelPage
 * ApiUriSearchPage.enUS: /report-event
 * 
 * AName.enUS: a donor
 * Color: light-green
 * IconGroup: duotone
 * IconName: hands-heart
 * NameVar.enUS: reportEvent
 * 
 * Role.enUS: SiteAdmin
 * 
 * Rows: 100
**/          
public class ReportEvent extends ReportEventGen<BaseModel> {

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: event name
	 */
	protected void _eventName(Wrap<String> w) {
	}

	@Override
	protected void _objectTitle(Wrap<String> w) {
		StringBuilder b = new StringBuilder();

		if(eventName != null) {
			b.append(eventName);
		} else {
			b.append(String.format("report event: %s", id));
		}
		w.o(b.toString());
	}
}
