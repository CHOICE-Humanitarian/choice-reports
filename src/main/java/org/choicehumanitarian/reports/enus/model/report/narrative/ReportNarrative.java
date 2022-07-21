package org.choicehumanitarian.reports.enus.model.report.narrative;

import java.time.LocalDate;
import java.util.Optional;

import org.choicehumanitarian.reports.enus.model.base.BaseModel;
import org.choicehumanitarian.reports.enus.model.report.schedule.ReportSchedule;
import org.choicehumanitarian.reports.enus.model.user.SiteUser;
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
 * Map.Integer.sqlSort: 6
 * Map.Integer.classSort: 6
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
	 * Ignore: true
	 */      
	protected void _scheduleSearch(Promise<SearchList<ReportSchedule>> promise) {
		SearchList<ReportSchedule> l = new SearchList<>();
		if(scheduleKey != null) {
			l.q("*:*");
			l.fq("pk_docvalues_long:" + scheduleKey);
			l.setC(ReportSchedule.class);
			l.setStore(true);
		}
		promise.complete(l);
	}

	protected void _schedule_(Wrap<ReportSchedule> w) {
		if(scheduleSearch.size() > 0) {
			w.o(scheduleSearch.get(0));
		}
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: SiteUser.narrativeKeys
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: assignee
	 */
	protected void _assigneeKey(Wrap<Long> w) {
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */      
	protected void _assigneeSearch(Promise<SearchList<SiteUser>> promise) {
		SearchList<SiteUser> l = new SearchList<>();
		if(assigneeKey != null) {
			l.q("*:*");
			l.fq("pk_docvalues_long:" + assigneeKey);
			l.setC(SiteUser.class);
			l.setStore(true);
		}
		promise.complete(l);
	}

	protected void _assignee_(Wrap<SiteUser> w) {
		if(assigneeSearch.size() > 0) {
			w.o(assigneeSearch.get(0));
		}
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * DisplayName.enUS: assignee name
	 * Facet: true
	 */
	protected void _assigneeName(Wrap<String> w) {
		w.o(Optional.ofNullable(assignee_).map(a -> a.getUserFullName()).orElse(null));
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: narrative name
	 * Facet: true
	 */
	protected void _narrativeName(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: report first due date
	 * Facet: true
	 */
	protected void _firstDueDate(Wrap<LocalDate> w) {
		w.o(Optional.ofNullable(schedule_).map(s -> s.getFirstDueDate()).orElse(null));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * HtmlRow: 4
	 * HtmlCell: 2
	 * DisplayName.enUS: report data pull date
	 * Facet: true
	 */
	protected void _dataPullDate(Wrap<LocalDate> w) {
		w.o(Optional.ofNullable(schedule_).map(s -> s.getDataPullDate()).orElse(null));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 4
	 * HtmlCell: 3
	 * DisplayName.enUS: narrative due date
	 * Facet: true
	 */
	protected void _narrativeDueDate(Wrap<LocalDate> w) {
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
