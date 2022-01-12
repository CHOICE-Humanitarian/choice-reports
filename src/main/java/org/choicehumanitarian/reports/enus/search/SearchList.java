package org.choicehumanitarian.reports.enus.search;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.choicehumanitarian.reports.enus.config.ConfigKeys;
import org.choicehumanitarian.reports.enus.request.SiteRequestEnUS;
import org.choicehumanitarian.reports.enus.user.SiteUser;
import org.choicehumanitarian.reports.enus.wrap.Wrap;
import org.computate.search.request.SearchRequest;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;

/** 
 * Keyword: classSimpleNameSearchList
 */ 
public class SearchList<DEV> extends SearchListGen<DEV> implements Iterable<DEV> {

	public SearchList q(String s) {
		request.q(s);
		return this;
	}

	public SearchList fq(String s) {
		request.fq(s);
		return this;
	}

	public SearchList fl(String s) {
		request.fl(s);
		return this;
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _c(Wrap<Class<?>> c) {
	}

	/**
	 * {@inheritDoc}
	 */
	protected void _request(SearchRequest o) {
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _siteRequest_(Wrap<SiteRequestEnUS> c) {
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _store(Wrap<Boolean> c) {
		c.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _populate(Wrap<Boolean> c) {
		c.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _solrQuery(JsonObject o) {
	}

	public DEV get(Integer index) {
		return list.get(index);
	}

	public Future<Boolean> next() {
		Promise<Boolean> promise = Promise.promise();
		try {
			Long start = Optional.ofNullable(getSolrDocumentList()).map(l -> l.getStart()).orElse(0L);
			Integer rows = Optional.ofNullable(getRows()).orElse(0);
			Long numFound = Optional.ofNullable(getSolrDocumentList()).map(l -> l.getNumFound()).orElse(0L);
			if(rows > 0 && (start + rows) < numFound) {
				setStart(start.intValue() + rows);
				String solrHostName = siteRequest_.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
				Integer solrPort = siteRequest_.getConfig().getInteger(ConfigKeys.SOLR_PORT);
				String solrCollection = siteRequest_.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
				String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, solrQuery.toQueryString());
				siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).send().onSuccess(a -> {
					JsonObject json = a.bodyAsJsonObject();
					Map<String, Object> map = json.getMap();
					QueryResponse r = generateSolrQueryResponse(map);
					setQueryResponse(r);
					Wrap<SolrDocumentList> solrDocumentListWrap = new Wrap<SolrDocumentList>().var("solrDocumentList").o(solrDocumentList);
					_solrDocumentList(solrDocumentListWrap);
					setSolrDocumentList(solrDocumentListWrap.o);
					list.clear();
					_list(list);

					promise.complete(true);
				}).onFailure(ex -> {
					LOG.error(String.format("Search failed. "), ex);
					promise.fail(ex);
				});
			} else {
				promise.complete(false);
			}
		} catch (Exception ex) {
			promise.fail(ex);
			LOG.error(String.format("Solr search failed. "), ex);
		}
		return promise.future();
	}

	public Future<Boolean> query() {
		Promise<Boolean> promise = Promise.promise();
		try {
			String solrHostName = siteRequest_.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
			Integer solrPort = siteRequest_.getConfig().getInteger(ConfigKeys.SOLR_PORT);
			String solrCollection = siteRequest_.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, request.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).send().onSuccess(a -> {
				JsonObject json = a.bodyAsJsonObject();
				QueryResponse r = generateSolrQueryResponse(json);
				setQueryResponse(r);
				Wrap<SolrDocumentList> solrDocumentListWrap = new Wrap<SolrDocumentList>().var("solrDocumentList").o(solrDocumentList);
				_solrDocumentList(solrDocumentListWrap);
				setSolrDocumentList(solrDocumentListWrap.o);
				list.clear();
				_list(list);

				promise.complete(true);
			}).onFailure(ex -> {
				promise.fail(ex);
				LOG.error(String.format("Solr search failed. "), ex);
			});
		} catch (Exception ex) {
			promise.fail(ex);
			LOG.error(String.format("Solr search failed. "), ex);
		}
		return promise.future();
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _queryResponse(Promise<QueryResponse> promise) {        
		try {
			if(this.c != null)
				solrQuery.addFilterQuery("classCanonicalName_docvalues_string:" + ClientUtils.escapeQueryChars(this.c.getCanonicalName()));
			SiteUser siteUser = siteRequest_.getSiteUser_();
			if(siteUser == null || BooleanUtils.isNotTrue(siteUser.getSeeDeleted()))
				solrQuery.addFilterQuery("deleted_docvalues_boolean:false");
			if(siteUser == null || BooleanUtils.isNotTrue(siteUser.getSeeArchived()))
				solrQuery.addFilterQuery("archived_docvalues_boolean:false");
			if(solrQuery.getQuery() != null) {
				String solrHostName = siteRequest_.getConfig().getString(ConfigKeys.SOLR_HOST_NAME);
				Integer solrPort = siteRequest_.getConfig().getInteger(ConfigKeys.SOLR_PORT);
				String solrCollection = siteRequest_.getConfig().getString(ConfigKeys.SOLR_COLLECTION);
				String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, solrQuery.toQueryString());
				siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).send().onSuccess(a -> {
					try {
						JsonObject json = a.bodyAsJsonObject();
						Map<String, Object> map = json.getMap();
						QueryResponse r = generateSolrQueryResponse(map);
						setQueryResponse(r);
						promise.complete(r);
					} catch(Exception ex) {
						LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
						promise.fail(ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("Search failed. "), new RuntimeException(ex));
					promise.fail(ex);
				});
			} else {
				promise.complete();
			}
		} catch (Exception ex) {
			promise.fail(ex);
			LOG.error(String.format("Search failed. "), ex);
		}
	}

	public QueryResponse generateSolrQueryResponse(JsonObject json) {
		NamedList<Object> l = new NamedList<>();
		SolrDocumentList response = new SolrDocumentList();
		ArrayList<NamedList<Object>> clusters = new ArrayList<>();
		Map<String, NamedList<Object>> suggestInfo = new HashMap<>();
		NamedList<NamedList<Object>> terms = new NamedList<NamedList<Object>>();
		NamedList<SolrDocumentList> moreLikeThis = new NamedList<SolrDocumentList>();

		// clusters //
		clusters.addAll(Optional.ofNullable((List<Map<String, Object>>)map.get("clusters")).orElse(Arrays.asList()).stream().map(m -> new NamedList<Object>(m)).collect(Collectors.toList()));

		// suggest //
		Optional.ofNullable((Map<String, Map<String, Object>>)map.get("suggest")).orElse(new HashMap<String, Map<String, Object>>()).forEach((key, value) -> {
			suggestInfo.put(key, new NamedList<Object>(value));
		});

		// terms //
		Optional.ofNullable((Map<String, List<Object>>)map.get("terms")).orElse(new HashMap<String, List<Object>>()).forEach((key, list) -> {
			NamedList<Object> namedList1 = new NamedList<>();

			for(Integer i = 0; i < list.size(); i+=2) {
				NamedList<Object> namedList2 = new NamedList<>();
				namedList1.add((String)list.get(i), list.get(i + 1));
			}
			terms.add(key, namedList1);
		});

		// response //
		Optional.ofNullable((LinkedHashMap<String, Object>)map.get("response")).ifPresent(m -> {
			response.setStart(((Integer)m.get("start")).longValue());
			response.setNumFound(((Integer)m.get("numFound")).longValue());
			response.setMaxScore((Float)m.get("maxScore"));
			((ArrayList<LinkedHashMap<String, Object>>)m.get("docs")).stream().forEach(doc -> {
				response.add(new SolrDocument(doc));
			});
		});

		// facet_counts //
		NamedList<Object> facetCounts = new NamedList<Object>();
		Map<String, ? extends Object> facetCountsJson = (Map<String, Object>)map.get("facet_counts");
		if(facetCountsJson != null) {

			// facet_fields //
			Optional.ofNullable(facetCountsJson.get("facet_fields")).ifPresent(facetFieldsJson -> {
				NamedList<Object> facetFields = new NamedList<Object>();
				((Map<String, List<Object>>)facetFieldsJson).forEach((key1, value1) -> {
					NamedList<Object> namedList1 = new NamedList<>();
					for(Integer i = 0; i < value1.size(); i+=2) {
						namedList1.add((String)value1.get(i), value1.get(i + 1));
					}
					facetFields.add(key1, namedList1);
				});
				facetCounts.add("facet_fields", facetFields);
			});

			// terms //
			Optional.ofNullable((Map<String, List<Object>>)map.get("terms")).orElse(new HashMap<String, List<Object>>()).forEach((key, list) -> {
			});

			// facet_queries //
			Optional.ofNullable(facetCountsJson.get("facet_queries")).ifPresent(facet_queries -> {
				facetCounts.add("facet_queries", new NamedList<Object>((Map<String, ? extends Object>)facet_queries));
			});

			// facet_ranges //
			Optional.ofNullable(facetCountsJson.get("facet_ranges")).ifPresent(facetRangesJson -> {
				NamedList<Object> facetRanges = new NamedList<Object>();
				facetCounts.add("facet_ranges", facetRanges);
				((Map<String, Map<String, Object>>)facetRangesJson).forEach((key1, value1) -> {
					NamedList<Object> namedList1 = new NamedList<>();
					facetRanges.add(key1, namedList1);
					List<Object> countsJson = (List<Object>)value1.get("counts");
					NamedList<Integer> counts = new NamedList<>();
					namedList1.add("counts", counts);
					Optional.ofNullable((String)value1.get("gap")).ifPresent(gap -> {
						namedList1.add("gap", gap);
					});
					Optional.ofNullable((String)value1.get("start")).ifPresent(start -> {
						namedList1.add("start", start);
					});
					Optional.ofNullable((String)value1.get("end")).ifPresent(end -> {
						namedList1.add("end", end);
					});
					for(Integer i = 0; i < countsJson.size(); i+=2) {
						counts.add((String)countsJson.get(i), (Integer)countsJson.get(i + 1));
					}
				});
			});

			// facet_pivot //
			Optional.ofNullable((Map<String, List<Map<String, Object>>>)facetCountsJson.get("facet_pivot")).ifPresent(pivotsItem1 -> {
				NamedList<Object> facetPivots = new NamedList<Object>();
				facetCounts.add("facet_pivot", facetPivots);
				pivotsItem1.forEach((key1, pivotsJson1) -> {
					List<NamedList<Object>> pivots1 = new ArrayList<>();
					facetPivots.add(key1, pivots1);
					for(Map<String, Object> pivotJson1 : pivotsJson1) {
						generateFacetPivotResponse(pivotJson1, pivots1);
					}
				});
			});
			Optional.ofNullable(facetCountsJson.get("facet_intervals")).ifPresent(facet_intervals -> {
				facetCounts.add("facet_intervals", new NamedList<Object>((Map<String, ? extends Object>)facet_intervals));
			});
		}

		// facets //
		NamedList<Object> facets = new SimpleOrderedMap<Object>();
		Optional.ofNullable(((Map<String, ? extends Object>) map.get("facets"))).orElse(new HashMap<>())
				.forEach((key, value) -> {
					if (value instanceof LinkedHashMap) {
						LinkedHashMap<String, Object> linkedHashMap1 = (LinkedHashMap<String, Object>) value;
						SimpleOrderedMap simpleOrderedMap1 = new SimpleOrderedMap<Object>();
						facets.add(key, simpleOrderedMap1);
						ArrayList<LinkedHashMap<String, Object>> bucketsIn = (ArrayList<LinkedHashMap<String, Object>>) linkedHashMap1
								.get("buckets");
						ArrayList<SimpleOrderedMap<Object>> bucketsOut = new ArrayList<SimpleOrderedMap<Object>>();
						simpleOrderedMap1.add("buckets", bucketsOut);
						bucketsIn.forEach(bucket -> {
							SimpleOrderedMap simpleOrderedMap2 = new SimpleOrderedMap<Object>();
							simpleOrderedMap2.add("val", bucket.get("val").toString());
							simpleOrderedMap2.add("count", bucket.get("count"));
							bucketsOut.add(simpleOrderedMap2);
						});
					} else {
						facets.add(key, value);
					}
				});

		// Look for known things
		l.add("responseHeader", new NamedList<Object>(((Map<String, ? extends Object>)map.get("responseHeader"))));
		l.add("response", response);
		l.add("sort_values", new NamedList<Object>(((Map<String, ? extends Object>)map.get("sort_values"))));
		l.add("facet_counts", facetCounts);
		l.add("debug", new NamedList<Object>(((Map<String, ? extends Object>)map.get("debug"))));
		l.add("grouped", new NamedList<Object>(((Map<String, ? extends Object>)map.get("grouped"))));
		l.add("expanded", new NamedList<Object>(((Map<String, ? extends Object>)map.get("expanded"))));
		l.add("highlighting", new NamedList<Object>(((Map<String, ? extends Object>)map.get("highlighting"))));
		l.add("spellcheck", new NamedList<Object>(((Map<String, ? extends Object>)map.get("spellcheck"))));
		l.add("clusters", clusters);
		l.add("facets", facets);
		l.add("suggest", suggestInfo);
		l.add("stats", new NamedList<Object>(((Map<String, ? extends Object>)map.get("stats"))));
		l.add("terms", terms);
		l.add("moreLikeThis", moreLikeThis);
		l.add(CursorMarkParams.CURSOR_MARK_NEXT, (String)map.get(CursorMarkParams.CURSOR_MARK_NEXT));

		QueryResponse r = new QueryResponse(l, null);
		return r;
	}

	private void generateFacetPivotResponse(Map<String, Object> pivotJson, List<NamedList<Object>> pivots) {
		NamedList<Object> namedList1 = new NamedList<>();
		pivots.add(namedList1);
		namedList1.add("field", pivotJson.get("field"));
		namedList1.add("value", pivotJson.get("value"));
		namedList1.add("count", pivotJson.get("count"));
		List<NamedList<Object>> pivots2 = new ArrayList<>();
		namedList1.add("pivot", pivots2);
		Optional.ofNullable((List<Map<String, Object>>)pivotJson.get("pivot")).ifPresent(pivotsJson2 -> {
			pivotsJson2.forEach(pivotJson2 -> {
				generateFacetPivotResponse(pivotJson2, pivots2);
			});
			
		});
		Optional.ofNullable(pivotJson.get("ranges")).ifPresent(facetRangesJson -> {
			NamedList<Object> facetRanges = new NamedList<Object>();
			namedList1.add("ranges", facetRanges);
			((Map<String, Map<String, Object>>)facetRangesJson).forEach((key2, value2) -> {
				NamedList<Object> namedList2 = new NamedList<>();
				facetRanges.add(key2, namedList2);
				List<Object> countsJson = (List<Object>)value2.get("counts");
				NamedList<Integer> counts = new NamedList<>();
				namedList2.add("counts", counts);
				Optional.ofNullable((String)value2.get("gap")).ifPresent(gap -> {
					namedList2.add("gap", gap);
				});
				Optional.ofNullable((String)value2.get("start")).ifPresent(start -> {
					namedList2.add("start", start);
				});
				Optional.ofNullable((String)value2.get("end")).ifPresent(end -> {
					namedList2.add("end", end);
				});
				for(Integer i = 0; i < countsJson.size(); i+=2) {
					counts.add((String)countsJson.get(i), (Integer)countsJson.get(i + 1));
				}
			});
		});
	}

	private void searchFacetPivot() {
		
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _solrDocumentList(Wrap<SolrDocumentList> c) {
		if(solrQuery.getQuery() != null) {
			SolrDocumentList o = queryResponse.getResults();
			c.o(o);
		}
	}

	protected void _list(List<DEV> l) {
		if(solrQuery.getQuery() != null) {
			for(SolrDocument solrDocument : solrDocumentList) {
				try {
					if(solrDocument != null) {
						String classCanonicalName = (String)solrDocument.get("classCanonicalName_docvalues_string");
						DEV o = (DEV)Class.forName(classCanonicalName).newInstance();
						MethodUtils.invokeMethod(o, "setSiteRequest_", siteRequest_);
						if(populate)
							MethodUtils.invokeMethod(o, "populateForClass", solrDocument);
						if(store)
							MethodUtils.invokeMethod(o, "storeForClass", solrDocument);
						l.add(o);
					}
				} catch (InstantiationException | IllegalAccessException | NoSuchMethodException
						| InvocationTargetException | ClassNotFoundException e) {
					ExceptionUtils.rethrow(e);
				}
			}
		}
	}

	protected void _first(Wrap<Object> w) {
		if(list.size() > 0)
			w.o(list.get(0));
	}

	public DEV first() {
		if(list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	public int getSize() {
		return list.size();
	}

	public int size() {
		return list.size();
	}

	@Override()
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		try {
			sb.append(URLDecoder.decode(solrQuery.toString(), "UTF-8")).append("\n");
		} catch (UnsupportedEncodingException e) {
			ExceptionUtils.rethrow(e);
		}
		Long numFound = Optional.ofNullable(getQueryResponse()).map(QueryResponse::getResults).map(SolrDocumentList::getNumFound).orElse(null);
		if(numFound != null)
			sb.append("numFound: ").append(numFound).append("\n");
		return sb.toString();
	}

	@Override
	public Iterator<DEV> iterator() {
		return list.iterator();
	}
}
