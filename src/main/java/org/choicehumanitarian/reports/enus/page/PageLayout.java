package org.choicehumanitarian.reports.enus.page;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.wrap.Wrap;

import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;

/**
 * Keyword: classSimpleNamePageLayout
 **/
public class PageLayout extends PageLayoutGen<Object> {

	/**
	 * Ignore: true
	**/
	protected void _siteRequest_(Wrap<SiteRequestEnUS> c) {
	}

	/**
	 * Ignore: true
	**/
	protected void _promiseBefore(Promise<Void> promise) {
		promise.complete();
	}

	protected void _pageH1(Wrap<String> c) {
			c.o("pets");
	}

	protected void _pageH2(Wrap<String> c) {
		c.o("");
	}

	protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	protected void _pageTitle(Wrap<String> c) {
	}

	protected void _pageUri(Wrap<String> c) {
	}

	protected void _roles(List<String> l) {
		if(siteRequest_ != null) {
			l.addAll(Stream.concat(siteRequest_.getUserResourceRoles().stream(), siteRequest_.getUserResourceRoles().stream()).collect(Collectors.toList()));
		}
	}

	protected void _rolesRequired(List<String> l) {
	}

	protected void _authRolesAdmin(List<String> l) {
		l.addAll(Arrays.asList("SiteAdmin"));
	}

	protected void _pagination(JsonObject pagination) {
	}

	protected void _query(JsonObject query) {
	}

	/**
	 * Ignore: true
	**/
	protected void _promiseAfter(Promise<Void> promise) {
		promise.complete();
	}

	protected void _pageImageUri(Wrap<String> c) {
	}

	protected void _contextIconGroup(Wrap<String> c) {
	}

	protected void _contextIconName(Wrap<String> c) {
	}
}
