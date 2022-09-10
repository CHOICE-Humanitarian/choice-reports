package org.choicehumanitarian.reports.enus.model.report.schedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.choicehumanitarian.reports.enus.model.base.BaseModel;
import org.choicehumanitarian.reports.enus.model.report.type.ReportType;
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
 * Map.Integer.sqlSort: 5
 * Map.Integer.classSort: 5
 * Sort.asc: objectId
 * 
 * ApiTag.enUS: Report Schedule
 * ApiUri.enUS: /api/report-schedule
 * 
 * ApiMethod.enUS: PUTImport

 * ApiMethod: POST
 * ApiMethod: PATCH
 * ApiMethod: GET
 * ApiMethod.enUS: Search
 * 
 * ApiMethod.enUS: SearchPage
 * Page.SearchPage.enUS: ReportSchedulePage
 * PageSuper.SearchPage.enUS: BaseModelPage
 * ApiUri.SearchPage.enUS: /report-schedule
 * 
 * AName.enUS: a report schedule
 * Color: light-green
 * IconGroup: duotone
 * IconName: calendar-days
 * NameVar.enUS: reportSchedule
 * 
 * Role.enUS: SiteAdmin
 * 
 * Rows: 100
**/
public class ReportSchedule extends ReportScheduleGen<BaseModel> {

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: ReportType.scheduleKeys
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * DisplayName.enUS: report type
	 */       
	protected void _typeKey(Wrap<Long> w) {
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */      
	protected void _typeSearch(Promise<SearchList<ReportType>> promise) {
		SearchList<ReportType> l = new SearchList<>();
		if(typeKey != null) {
			l.q("*:*");
			l.fq("pk_docvalues_long:" + typeKey);
			l.setC(ReportType.class);
			l.setStore(true);
		}
		promise.complete(l);
	}

	protected void _type_(Wrap<ReportType> w) {
		if(typeSearch.size() > 0) {
			w.o(typeSearch.get(0));
		}
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * DisplayName.enUS: report type name
	 */  
	protected void _typeName(Wrap<String> w) {
		if(type_ != null)
			w.o(type_.getTypeName());
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: ReportNarrative.scheduleKey
	 * HtmlRow: 3
	 * HtmlCell: 2
	 * DisplayName.enUS: narratives
	 */
	protected void _narrativeKeys(List<Long> l) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: ReportEvent.scheduleKey
	 * HtmlRow: 3
	 * HtmlCell: 3
	 * DisplayName.enUS: calendar items
	 */
	protected void _eventKeys(List<Long> l) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: SiteUser.pullOwnerReportScheduleKeys
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: pull owner
	 */
	protected void _pullOwnerKey(Wrap<Long> w) {
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */      
	protected void _pullOwnerSearch(Promise<SearchList<SiteUser>> promise) {
		SearchList<SiteUser> l = new SearchList<>();
		if(pullOwnerKey != null) {
			l.q("*:*");
			l.fq("pk_docvalues_long:" + pullOwnerKey);
			l.setC(SiteUser.class);
			l.setStore(true);
		}
		promise.complete(l);
	}

	protected void _pullOwner_(Wrap<SiteUser> w) {
		if(pullOwnerSearch.size() > 0) {
			w.o(pullOwnerSearch.get(0));
		}
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * DisplayName.enUS: pull owner name
	 */
	protected void _pullOwnerName(Wrap<String> w) {
		w.o(Optional.ofNullable(pullOwner_).map(a -> a.getUserFullName()).orElse(null));
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: SiteUser.finalOwnerReportScheduleKeys
	 * HtmlRow: 4
	 * HtmlCell: 2
	 * DisplayName.enUS: final owner
	 */
	protected void _finalOwnerKey(Wrap<Long> w) {
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */      
	protected void _finalOwnerSearch(Promise<SearchList<SiteUser>> promise) {
		SearchList<SiteUser> l = new SearchList<>();
		if(finalOwnerKey != null) {
			l.q("*:*");
			l.fq("pk_docvalues_long:" + finalOwnerKey);
			l.setC(SiteUser.class);
			l.setStore(true);
		}
		promise.complete(l);
	}

	protected void _finalOwner_(Wrap<SiteUser> w) {
		if(finalOwnerSearch.size() > 0) {
			w.o(finalOwnerSearch.get(0));
		}
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * DisplayName.enUS: final owner name
	 */
	protected void _finalOwnerName(Wrap<String> w) {
		w.o(Optional.ofNullable(finalOwner_).map(a -> a.getUserFullName()).orElse(null));
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 5
	 * HtmlCell: 1
	 * DisplayName.enUS: schedule name
	 */  
	protected void _scheduleName(Wrap<String> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 5
	 * HtmlCell: 2
	 * DisplayName.enUS: one time
	 */  
	protected void _frequencyOneTime(Wrap<Boolean> w) {
		w.o(false);
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 5
	 * HtmlCell: 3
	 * DisplayName.enUS: times per year
	 */  
	protected void _frequencyTimesPerYear(Wrap<Integer> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 5
	 * HtmlCell: 4
	 * DisplayName.enUS: years after completion
	 */
	protected void _frequencyYearsAfterCompletion(Wrap<Integer> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 6
	 * HtmlCell: 1
	 * DisplayName.enUS: final report due date
	 */
	protected void _firstDueDate(Wrap<LocalDate> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 6
	 * HtmlCell: 2
	 * DisplayName.enUS: data period start date
	 */
	protected void _dataPeriodStartDate(Wrap<LocalDate> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 6
	 * HtmlCell: 3
	 * DisplayName.enUS: data period end date
	 */
	protected void _dataPullEndDate(Wrap<LocalDate> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 6
	 * HtmlCell: 4
	 * DisplayName.enUS: data pull date
	 */
	protected void _dataPullDate(Wrap<LocalDate> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 7
	 * HtmlCell: 1
	 * Multiline: true
	 * DisplayName.enUS: data sources
	 */
	protected void _dataSources(Wrap<String> w) {
	}

	@Override
	protected void _objectTitle(Wrap<String> w) {
		StringBuilder b = new StringBuilder();

		if(type_ != null) {
			b.append(String.format("%s %s", typeName, scheduleName));
		} else if(scheduleName != null) {
			b.append(scheduleName);
		} else {
			b.append(String.format("report schedule: %s", pk));
		}

		if(frequencyOneTime) {
			b.append(" one time");
		} else if(frequencyTimesPerYear != null && frequencyYearsAfterCompletion != null) {
			b.append(String.format(" %sx/year until complete + %s-yrs after completion", frequencyTimesPerYear, frequencyYearsAfterCompletion));
		} else if(frequencyTimesPerYear != null) {
			b.append(String.format(" %sx/year", frequencyTimesPerYear));
		}
		w.o(b.toString());
	}
}
