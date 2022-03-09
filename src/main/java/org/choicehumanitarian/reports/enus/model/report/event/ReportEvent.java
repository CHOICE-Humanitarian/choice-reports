package org.choicehumanitarian.reports.enus.model.report.event;

import java.time.LocalDate;

import org.choicehumanitarian.reports.enus.base.BaseModel;
import org.computate.search.wrap.Wrap;

/**
 * Model: true
 * Api: true
 * Page: true
 * SuperPage.enUS: BaseModelPage
 * Indexed: true
 * Saved: true
 * Map.Integer.sqlSort: 7
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
 * AName.enUS: a report event
 * Color: light-green
 * IconGroup: duotone
 * IconName: calendar-star
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
	 * Relate: ReportSchedule.eventKeys
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: schedule
	 */        
	protected void _scheduleKey(Wrap<Long> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: SiteUser.eventKeys
	 * HtmlRow: 3
	 * HtmlCell: 2
	 * DisplayName.enUS: assignee
	 */       
	protected void _assigneeKey(Wrap<Long> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 3
	 * DisplayName.enUS: event name
	 */
	protected void _eventName(Wrap<String> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: event date
	 */  
	protected void _eventDate(Wrap<LocalDate> w) {
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
