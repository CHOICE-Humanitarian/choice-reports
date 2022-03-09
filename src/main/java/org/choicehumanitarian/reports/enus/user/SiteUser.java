package org.choicehumanitarian.reports.enus.user;       

import java.util.List;

import org.choicehumanitarian.reports.enus.base.BaseModel;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.model.user.ComputateVertxSiteUser;
import org.computate.vertx.request.ComputateVertxSiteRequest;


/**   
 * Model: true
 * Api: true
 * Page: true
 * SuperPage.enUS: BaseModelPage
 * Indexed: true
 * Map.Integer.sqlSort: 1
 * 
 * ApiTag.enUS: User
 * ApiUri.enUS: /api/user
 * 
 * ApiMethod.enUS: Search
 * ApiMethod: PATCH
 * ApiMethod: POST
 * 
 * ApiMethod.enUS: SearchPage
 * PageSearchPage.enUS: SiteUserPage
 * PageSuperSearchPage.enUS: BaseModelPage
 * ApiUriSearchPage.enUS: /user
 * 
 * Keyword: classSimpleNameSiteUser
 * Filter: userId
 * Saves: true
 * 
 * AName.enUS: a site user
 * Color: teal
 * IconGroup: regular
 * IconName: user-cog
 * NameVar.enUS: user
 * 
 * Role.enUS: SiteAdmin
 */
public class SiteUser extends SiteUserGen<BaseModel> implements ComputateVertxSiteUser {

	/** 
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: ReportNarrative.assigneeKey
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: narratives
	 */
	protected void _narrativeKeys(List<Long> l) {
	}

	/**  
	 * {@inheritDoc}
	 * DocValues: true
	 * Relate: ReportEvent.assigneeKey
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * DisplayName.enUS: events
	 */
	protected void _eventKeys(List<Long> l) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 */
	protected void _userKeys(List<Long> l) {
		l.add(pk);
	}

	/**   
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * Modify: false
	 */                 
	protected void _userId(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 */
	protected void _userName(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 */
	protected void _userEmail(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 */
	protected void _userFirstName(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 */
	protected void _userLastName(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 */
	protected void _userFullName(Wrap<String> c) {
		c.o(String.format("%s %s", userFirstName, userLastName));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 2
	 * DisplayName.enUS: see archived
	 */
	protected void _seeArchived(Wrap<Boolean> c) {
		c.o(false);
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Define: true
	 * HtmlRow: 3
	 * HtmlCell: 3
	 * DisplayName.enUS: see deleted
	 */
	protected void _seeDeleted(Wrap<Boolean> c) {
		c.o(false);
	}

	@Override
	protected void _objectTitle(Wrap<String> c) {
		c.o(String.format("%s (%s) <%s>", userFullName, userName, userEmail));
//		c.o(String.format("%s (%s)", userFullName, userName));
	}

	@Override
	public <T extends ComputateVertxSiteRequest> void setSiteRequest_(T siteRequest) {
		siteRequest_ = (SiteRequestEnUS)siteRequest;
	}
}
