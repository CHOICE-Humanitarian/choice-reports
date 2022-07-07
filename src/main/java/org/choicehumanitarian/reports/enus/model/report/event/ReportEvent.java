package org.choicehumanitarian.reports.enus.model.report.event;

import java.time.LocalDate;

import org.choicehumanitarian.reports.enus.model.base.BaseModel;
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
 * ApiTag.enUS: Calendar Item
 * ApiUri.enUS: /api/calendar-item
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
 * ApiUriSearchPage.enUS: /calendar-item
 * 
 * AName.enUS: a calendar item
 * Color: light-green
 * IconGroup: duotone
 * IconName: calendar-star
 * NameVar.enUS: calendarItem
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
	 * Persist: true
	 * HtmlRow: 3
	 * HtmlCell: 3
	 * DisplayName.enUS: event name
	 */
	protected void _eventName(Wrap<String> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
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
