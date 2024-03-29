package org.choicehumanitarian.reports.enus.model.page;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.computate.search.wrap.Wrap;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.choicehumanitarian.reports.enus.model.base.BaseModel;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;

import io.vertx.core.Promise;


/**
 * Api: true
 * Page: true
 * SuperPage.enUS: PageLayout
 * Indexed: true
 * Map.Integer.sqlSort: 100
 * Map.Integer.classSort: 100
 * 
 * ApiTag.enUS: Page
 * ApiUri.enUS: /api/page
 * 
 * ApiMethod.enUS: Search
 * ApiMethod: GET
 * ApiMethod: POST
 * ApiMethod: PATCH
 * ApiMethod: PUTImport
 * 
 * ApiMethod.enUS: SearchPage
 * Page.SearchPage.enUS: SitePagePage
 * ApiUri.SearchPage.enUS: /page
 * 
 * AName.enUS: an article
 * Color: 2017-navy-peony
 * IconGroup: duotone
 * IconName: newspaper
 * NameVar: page
 * 
 * Sort.asc: courseNum
 * Sort.asc: lessonNum
 * 
 * PublicRead: true
 * Role.enUS: SiteAdmin
 * Description: An article in the site. 
 */
public class SitePage extends SitePageGen<Object> {

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 * Description: The current request object
	 */
	protected void _siteRequest_(Wrap<SiteRequestEnUS> w) {
	}

	/**
	 * {@inheritDoc}
	 */
	protected void _siteName(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_NAME));
	}

	/**
	 * {@inheritDoc}
	 */
	protected void _siteDisplayName(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_DISPLAY_NAME));
	}

	/**
	 * {@inheritDoc}
	 */
	protected void _staticBaseUrl(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ConfigKeys.STATIC_BASE_URL));
	}

	/**
	 * {@inheritDoc}
	 */
	protected void _staticPath(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ConfigKeys.STATIC_PATH));
	}

	/**
	 * {@inheritDoc}
	 */
	protected void _siteBaseUrl(Wrap<String> w) {
		w.o(siteRequest_.getConfig().getString(ConfigKeys.SITE_BASE_URL));
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 * Description: An asynchronous method for searching for a computer related to this message
	 */
	protected void _promiseBefore(Promise<Void> promise) {
		promise.complete();
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * Facet: true
	 * DisplayName: Course Number
	 * Description: The course number for this page. 
	 */
	protected void _courseNum(Wrap<Integer> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * Facet: true
	 * DisplayName: Lesson Number
	 * Description: The lesson number for this page. 
	 */
	protected void _lessonNum(Wrap<Integer> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 3
	 * HtmlCell: 2
	 * HtmlColumn: 4
	 * Facet: true
	 * DisplayName: URI
	 * Description: The relative URI for this page. 
	 */
	protected void _uri(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 3
	 * HtmlCell: 1
	 * Facet: true
	 * DisplayName: Page ID
	 * Description: The ID for this page. 
	 */
	protected void _pageId(Wrap<String> w) {
		if(uri != null)
			w.o(StringUtils.substringAfterLast(uri, "/"));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: header 1
	 * Description: The 1st header of this page. 
	 */
	protected void _h1(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * DisplayName: header 2
	 * Description: The 2nd header of this page. 
	 */
	protected void _h2(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * InheritPrimaryKey: true
	 * Persist: true
	 * Description: An optional inherited primary key from a legacy system for this object in the database
	 */
	protected void _inheritPk(Wrap<String> w) {}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * Modify: false
	 * VarCreated: true
	 * HtmlRow: 1
	 * HtmlCell: 2
	 * HtmlColumn: 1
	 * Facet: true
	 * DisplayName.enUS: created
	 * FormatHtm: MMM d, yyyy h:mm:ss a
	 * Description: A created timestamp for this record in the database
	 */
	protected void _created(Wrap<ZonedDateTime> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Modify: false
	 * VarModified: true
	 * HtmlRow: 1
	 * HtmlCell: 3
	 * DisplayName.enUS: modified
	 * Description: A modified timestamp for this record in the database
	 */
	protected void _modified(Wrap<ZonedDateTime> w) {
		w.o(ZonedDateTime.now(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 3
	 * HtmlCell: 3
	 * Facet: true
	 * DisplayName.enUS: author
	 * Description: The author
	 */
	protected void _author(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 4
	 * HtmlCell: 1
	 * Facet: true
	 * DisplayName.enUS: imageUri
	 * Description: The page image URI
	 */
	protected void _pageImageUri(Wrap<String> w) {
	}

	/**
	 * Description: The image width
	 */
	protected void _pageImageWidth(Wrap<Integer> w) {
		if(pageImageUri != null) {
			Path path = Paths.get(siteRequest_.getConfig().getString(ConfigKeys.STATIC_PATH), pageImageUri);
			File file = path.toFile();
			if(file.exists()) {
				try {
					BufferedImage img = ImageIO.read(file);
					w.o(img.getWidth());
					setPageImageHeight(img.getHeight());
					setPageImageType(Files.probeContentType(path));
				} catch (Exception ex) {
					ExceptionUtils.rethrow(ex);
				}
			}
		}
	}

	/**
	 * Description: The image height
	 */
	protected void _pageImageHeight(Wrap<Integer> c) {
	}

	/**
	 * Description: The image height
	 */
	protected void _pageImageType(Wrap<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 2
	 * HtmlCell: 1
	 * DisplayName.enUS: archived
	 * Description: For archiving this record
	 */
	protected void _archived(Wrap<Boolean> w) {
		w.o(false);
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * HtmlRow: 2
	 * HtmlCell: 2
	 * DisplayName.enUS: deleted
	 * Description: For deleting this record
	 */
	protected void _deleted(Wrap<Boolean> w) {
		w.o(false);
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Description: the canonical name of this Java class
	 */
	protected void _classCanonicalName(Wrap<String> w) {
		w.o(getClass().getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Description: The simple name of this Java class
	 * DisplayName.enUS: object type
	 * Facet: true
	 */
	protected void _classSimpleName(Wrap<String> w) {
		w.o(getClass().getSimpleName());
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Description: All the inherited canonical names of this Java class
	 */
	protected void _classCanonicalNames(List<String> l) { 
		Class<?> cl = getClass();
		if(!cl.equals(BaseModel.class))
			l.add(cl.getCanonicalName());
		l.add(BaseModel.class.getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * Modify: false
	 * Description: The session ID of the user that created this object
	 */
	protected void _sessionId(Wrap<String> w) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: userKey
	 * DocValues: true
	 * Persist: true
	 * Modify: false
	 * Description: The primary key of the user that created this record
	 */
	protected void _userKey(Wrap<Long> c) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Saves: true
	 * Description: A list of fields that are saved for this record in the database
	 */
	protected void _saves(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * VarTitle: true
	 * HtmlColumn: 2
	 * Description: The title of this object
	 */
	protected void _objectTitle(Wrap<String> w) {
		StringBuilder b = new StringBuilder();
		if(h1 != null)
			b.append(" ").append(h1);
		if(h2 != null)
			b.append(" ").append(h2);
		w.o(b.toString());
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Persist: true
	 * VarId: true
	 * HtmlRow: 1
	 * HtmlCell: 4
	 * DisplayName.enUS: ID
	 * Description: A URL friendly unique ID for this object
	 */
	protected void _objectId(Wrap<String> w) {
	}

	/**
	 * Description: A helper method for generating a URL friendly unique ID for this object
	 */
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

	/**
	 * Description: The var that identifies this type of object in the API
	 */
	protected void _objectNameVar(Wrap<String> w) {
		if(objectId != null) {
			Class<?> cl = getClass();

			try {
				String o = toId(StringUtils.join(StringUtils.splitByCharacterTypeCamelCase((String)FieldUtils.getField(cl, cl.getSimpleName() + "_NameVar_enUS").get(this)), "-"));
				w.o(o);
			} catch (Exception e) {
				ExceptionUtils.rethrow(e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * Suggested: true
	 * Description: The indexed field in the search engine for this record while using autosuggest
	 * DisplayName: autosuggest
	 */
	protected void _objectSuggest(Wrap<String> w) { 
		StringBuilder b = new StringBuilder();
		if(objectNameVar != null)
			b.append(" ").append(objectNameVar);
		if(objectId != null)
			b.append(" ").append(objectId);
		if(objectTitle != null)
			b.append(" ").append(objectTitle);
		w.o(b.toString());
	}

	/**
	 * {@inheritDoc}
	 * Text: true
	 * Persist: true
	 * Description: The full text search field in the search engine for this record while using autosuggest
	 * DisplayName: text
	 */
	protected void _objectText(List<String> l) { 
		if(objectNameVar != null)
			l.add(objectNameVar);
		if(objectId != null)
			l.add(objectId);
		if(objectTitle != null)
			l.add(objectTitle);
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * VarUrlId: true
	 * Description: The link by name for this object in the UI
	 */
	protected void _pageUrlId(Wrap<String> w) {
		if(objectId != null) {
			w.o(String.format("%s%s", siteRequest_.getConfig().getString(ConfigKeys.SITE_BASE_URL), uri));
		}
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * VarUrlPk: true
	 * Description: The link by primary key for this object in the UI
	 */
	protected void _pageUrlPk(Wrap<String> w) {
		w.o(pageUrlId);
	}

	/**
	 * {@inheritDoc}
	 * DocValues: true
	 * Description: The link to this object in the API
	 */
	protected void _pageUrlApi(Wrap<String> w) {
		String o = siteRequest_.getConfig().getString(ConfigKeys.SITE_BASE_URL) + "/api/" + objectNameVar + "/" + objectId;
		w.o(o);
	}

	/**
	 * {@inheritDoc}
	 * UniqueKey: true
	 * Description: The unique key for this record in the search engine
	 */
	protected void _id(Wrap<String> w) {
		w.o(objectId);
	}
}
