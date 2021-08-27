package org.choicehumanitarian.reports.enus.model.donor;

import java.util.Arrays;
import java.util.List;

import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.search.SearchList;
import org.choicehumanitarian.reports.enus.wrap.Wrap;

import io.vertx.core.Promise;

/**
 * Translate: false
 **/
public class ChoiceDonorGenPage extends ChoiceDonorGenPageGen<Object> {

	public static final List<String> ROLES = Arrays.asList("SiteAdmin");
	public static final List<String> ROLE_READS = Arrays.asList("");

	/**
	 * Ignore: true
	**/
	protected void _siteRequest_(Wrap<SiteRequestEnUS> c) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listChoiceDonor_(Wrap<SearchList<ChoiceDonor>> c) {
	}

	protected void _choiceDonor_(Wrap<ChoiceDonor> c) {
		if(listChoiceDonor_ != null && listChoiceDonor_.size() == 1)
			c.o(listChoiceDonor_.get(0));
	}

	/**
	 * Ignore: true
	**/
	protected void _promiseBefore(Promise<Void> promise) {
		promise.complete();
	}

	protected void _pageH1(Wrap<String> c) {
			c.o("donors");
	}

	protected void _pageH2(Wrap<String> c) {
		c.o("");
	}

	protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	protected void _pageTitle(Wrap<String> c) {
		if(choiceDonor_ != null && choiceDonor_.getObjectTitle() != null)
			c.o(choiceDonor_.getObjectTitle());
		else if(choiceDonor_ != null)
			c.o("donors");
		else if(listChoiceDonor_ == null || listChoiceDonor_.size() == 0)
			c.o("no donor found");
		else
			c.o("donors");
	}

	protected void _pageUri(Wrap<String> c) {
		c.o("/api/donor");
	}

	/**
	 * Ignore: true
	**/
	protected void _promiseAfter(Promise<Void> promise) {
		promise.complete();
	}

	protected void _pageImageUri(Wrap<String> c) {
			c.o("/png/api/donor-999.png");
	}

	protected void _contextIconGroup(Wrap<String> c) {
			c.o("regular");
	}

	protected void _contextIconName(Wrap<String> c) {
			c.o("globe-americas");
	}
}
