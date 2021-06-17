package org.choicehumanitarian.reports.enus.base;

import java.text.Normalizer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.choicehumanitarian.reports.enus.wrap.Wrap;




/**
 * Indexed: true
 * 
 * Keyword: classSimpleNameCluster
 */  
public class BaseModel extends BaseModelGen<Object> {       

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _siteRequest_(Wrap<SiteRequestEnUS> c) {}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * PrimaryKey: true
	 * Modify: false
	 * HtmlRow: 1
	 * HtmlCell: 1
	 * DisplayName.enUS: primary key
	 */
	protected void _pk(Wrap<Long> c) {}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * InheritPrimaryKey: true
	 * Define: true
	 */
	protected void _inheritPk(Wrap<String> c) {}

	/**
	 * {@inheritDoc}
	 * UniqueKey: true
	 */
	protected void _id(Wrap<String> c) {
		if(pk != null)
			c.o(getClass().getSimpleName() + "_" + pk.toString());
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * Modify: false
	 * VarCreated: true
	 * HtmlRow: 1
	 * HtmlCell: 2
	 * HtmlColumn: 2
	 * DisplayName.enUS: created
	 */
	protected void _created(Wrap<ZonedDateTime> c) {}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Modify: false
	 * VarModified: true
	 * HtmlRow: 1
	 * HtmlCell: 3
	 * DisplayName.enUS: modified
	 */ 
	protected void _modified(Wrap<ZonedDateTime> c) {
		c.o(ZonedDateTime.now(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 2
	 * HtmlCell: 1
	 * DisplayName.enUS: archived
	 */ 
	protected void _archived(Wrap<Boolean> c) {
		c.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 2
	 * HtmlCell: 2
	 * DisplayName.enUS: deleted
	 */ 
	protected void _deleted(Wrap<Boolean> c) {
		c.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _classCanonicalName(Wrap<String> c) {
		String o = getClass().getCanonicalName();
		c.o(o);
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _classSimpleName(Wrap<String> c) {
		String o = getClass().getSimpleName();
		c.o(o);
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _classCanonicalNames(List<String> l) { 
		Class<?> cl = getClass();
		if(!cl.equals(BaseModel.class))
			l.add(cl.getCanonicalName());
		l.add(BaseModel.class.getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _sessionId(Wrap<String> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Var.enUS: userId
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * Modify: false
	 */                 
	protected void _userId(Wrap<String> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Var.enUS: userKey
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * Modify: false
	 */                 
	protected void _userKey(Wrap<Long> c) {
	}
	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Saves: true
	 */ 
	protected void _saves(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * VarTitle: true
	 * HtmlColumn: 2
	 */ 
	protected void _objectTitle(Wrap<String> c) {
		if(pk != null)
			c.o(pk.toString());
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * VarId: true
	 * HtmlRow: 1
	 * HtmlCell: 4
	 * DisplayName.enUS: ID
	 */ 
	protected void _objectId(Wrap<String> c) {
		if(objectTitle != null) {
			c.o(toId(objectTitle));
		}
		else if(pk != null){
			c.o(pk.toString());
		}
	}

	public String toId(String s) {
		if(s != null) {
			s = Normalizer.normalize(s, Normalizer.Form.NFD);
			s = StringUtils.lowerCase(s);
			s = StringUtils.trim(s);
			s = StringUtils.replacePattern(s, "\\s{1,}", "-");
			s = StringUtils.replacePattern(s, "[^\\w-]", "");
			s = StringUtils.replacePattern(s, "-{2,}", "-");
		}

		return s;
	}
}
