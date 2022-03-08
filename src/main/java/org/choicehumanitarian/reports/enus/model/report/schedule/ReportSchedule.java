package org.choicehumanitarian.reports.enus.model.report.schedule;

import java.time.LocalDate;

import org.choicehumanitarian.reports.enus.base.BaseModel;
import org.choicehumanitarian.reports.enus.model.report.type.ReportType;
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
 * PageSearchPage.enUS: ReportSchedulePage
 * PageSuperSearchPage.enUS: BaseModelPage
 * ApiUriSearchPage.enUS: /report-schedule
 * 
 * AName.enUS: a donor
 * Color: light-green
 * IconGroup: duotone
 * IconName: hands-heart
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
		l.q("*:*");
		l.fq("pk_docvalues_long:" + typeKey);
		l.setC(ReportType.class);
		l.setStore(true);
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
	 * Define: true
	 * HtmlRow: 4
	 * HtmlCell: 2
	 * DisplayName.enUS: schedule name
	 */  
	protected void _scheduleName(Wrap<String> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: one time
	 */  
	protected void _frequencyOneTime(Wrap<Boolean> w) {
		w.o(false);
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 4
	 * HtmlCell: 2
	 * DisplayName.enUS: times per year
	 */  
	protected void _frequencyTimesPerYear(Wrap<Integer> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 4
	 * HtmlCell: 3
	 * DisplayName.enUS: years after completion
	 */  
	protected void _frequencyYearsAfterCompletion(Wrap<Integer> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 1
	 * DisplayName.enUS: first due date
	 */  
	protected void _firstDueDate(Wrap<LocalDate> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 1
	 * DisplayName.enUS: data pull date
	 */  
	protected void _dataPullDate(Wrap<LocalDate> w) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 5
	 * HtmlCell: 2
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
			b.append(String.format("%sx/year until complete + %s-yrs after completion", frequencyTimesPerYear, frequencyYearsAfterCompletion));
		} else if(frequencyTimesPerYear != null) {
			b.append(String.format("%sx/year until complete", frequencyTimesPerYear));
		}
		w.o(b.toString());
	}
}