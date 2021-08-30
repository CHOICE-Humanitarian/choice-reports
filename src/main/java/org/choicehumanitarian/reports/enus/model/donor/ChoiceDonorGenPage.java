package org.choicehumanitarian.reports.enus.model.donor;


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

	protected void _pagination(JsonObject pagination) {
		JsonArray pages = new JsonArray();
		Long start = listChoiceDonor_.getStart().longValue();
		Long rows = listChoiceDonor_.getRows().longValue();
		Long foundNum = listChoiceDonor_.getQueryResponse().getResults().getNumFound();
		Long startNum = start + 1;
		Long endNum = start + rows;
		Long floorMod = Math.floorMod(foundNum, rows);
		Long last = Math.floorDiv(foundNum, rows) - (floorMod.equals(0L) ? 1L : 0L) * rows;
		endNum = endNum < foundNum ? endNum : foundNum;
		startNum = foundNum == 0L ? 0L : startNum;
		Long paginationStart = start - 10 * rows;
		if(paginationStart < 0)
			paginationStart = 0L;
		Long paginationEnd = start + 10 * rows;
		if(paginationEnd > foundNum)
			paginationEnd = foundNum;

		pagination.put("start", start);
		pagination.put("rows", rows);
		pagination.put("startNum", startNum);
		pagination.put("endNum", endNum);
		pagination.put("foundNum", foundNum);
		pagination.put("pageStart", new JsonObject().put("start", 0L).put("pageNumber", 1L));
		if(start > 0L)
			pagination.put("pagePrevious", new JsonObject().put("start", start - rows).put("pageNumber", start - rows + 1L));
		if(start + rows < foundNum)
			pagination.put("pagePrevious", new JsonObject().put("start", start + rows).put("pageNumber", start + rows + 1L));
		pagination.put("pageEnd", new JsonObject().put("start", last).put("pageNumber", last + 1L));
		pagination.put("pages", pages);
		for(Long i = paginationStart; i < paginationEnd; i += rows) {
			Long pageNumber = Math.floorDiv(i, rows) + 1L;
			JsonObject page = new JsonObject();
			page.put("pageNumber", pageNumber);
			page.put("currentPage", start.equals(i));
			page.put("start", i);
			pages.add(page);
		}
	}

	protected void _query(JsonObject query) {
		ServiceRequest serviceRequest = siteRequest_.getServiceRequest();
		JsonObject params = serviceRequest.getParams();

		JsonObject queryParams = Optional.ofNullable(serviceRequest).map(ServiceRequest::getParams).map(or -> or.getJsonObject("query")).orElse(new JsonObject());
		Long num = listChoiceDonor_.getQueryResponse().getResults().getNumFound();
		String q = "*:*";
		String q1 = "objectText";
		String q2 = "";
		for(String paramName : queryParams.fieldNames()) {
			String entityVar = null;
			String valueIndexed = null;
			Object paramObjectValues = queryParams.getValue(paramName);
			JsonArray paramObjects = paramObjectValues instanceof JsonArray ? (JsonArray)paramObjectValues : new JsonArray().add(paramObjectValues);

			try {
				for(Object paramObject : paramObjects) {
					switch(paramName) {
					case "q":
						q = (String)paramObject;
						entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
						valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
						q1 = entityVar.equals("*") ? q1 : entityVar;
						q2 = valueIndexed;
						q = q1 + ":" + q2;
					}
				}
			} catch(Exception e) {
				ExceptionUtils.rethrow(e);
			}
		}
		query.put("q", q);

		Integer rows1 = Optional.ofNullable(listChoiceDonor_).map(l -> l.getRows()).orElse(10);
		Integer start1 = Optional.ofNullable(listChoiceDonor_).map(l -> l.getStart()).orElse(1);
		Integer start2 = start1 - rows1;
		Integer start3 = start1 + rows1;
		Integer rows2 = rows1 / 2;
		Integer rows3 = rows1 * 2;
		start2 = start2 < 0 ? 0 : start2;
		JsonArray fqs = new JsonArray();
		for(String fq : Optional.ofNullable(listChoiceDonor_).map(l -> l.getFilterQueries()).orElse(new String[0])) {
			if(!StringUtils.contains(fq, "(")) {
				String fq1 = StringUtils.substringBefore(fq, "_");
				String fq2 = StringUtils.substringAfter(fq, ":");
				if(!StringUtils.startsWithAny(fq, "classCanonicalNames_", "archived_", "deleted_", "sessionId", "userKeys"))
					fqs.add(new JsonObject().put("var", fq1).put("val", fq2));
				}
			}
		query.put("fq", fqs);

		JsonArray sorts = new JsonArray();
		for(SortClause sort : Optional.ofNullable(listChoiceDonor_).map(l -> l.getSorts()).orElse(Arrays.asList())) {
			sorts.add(new JsonObject().put("var", StringUtils.substringBefore(sort.getItem(), "_")).put("order", sort.getOrder().name()));
		}
		query.put("sort", sorts);
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
