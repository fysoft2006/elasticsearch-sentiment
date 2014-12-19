package zx.soft.es.core.search;

import java.io.IOException;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder.Operator;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.soft.es.core.domain.SearchParameters;

public class SearchingData {
	private static Logger logger = LoggerFactory.getLogger(SearchingData.class);

	private static TransportClient client;
	private static String index;
	private static String type;

	public SearchingData(TransportClient client, String index, String type) {
		this.client = client;
		this.index = index;
		this.type = type;
	}

	public SearchResponse doSearch(SearchParameters searchParameters) throws IOException {
		SearchRequestBuilder searchRequest = client.prepareSearch(index).setTypes(type);
		logger.info("index=" + index + ",type=" + type);

		if (searchParameters.getFq() != "*") {

			QueryStringQueryBuilder qb = QueryBuilders.queryString(searchParameters.getFq());
			if (searchParameters.getAnalyzer() != "ik") {
				qb.analyzer(searchParameters.getAnalyzer());
				logger.info("analyzer=" + searchParameters.getAnalyzer());
			}

			if (searchParameters.getDf() != "") {
				qb.defaultField(searchParameters.getDf());
				logger.info("default_field=" + searchParameters.getDf());
			}

			if (searchParameters.getDefault_operator() != Operator.OR) {
				qb.defaultOperator(searchParameters.getDefault_operator());
				logger.info("operator=" + searchParameters.getDefault_operator());
			}

			if (searchParameters.isLowercase_expanded_terms() != true) {
				qb.lowercaseExpandedTerms(searchParameters.isLowercase_expanded_terms());
				logger.info("Lowercase_expanded_terms=" + searchParameters.isLowercase_expanded_terms());
			}

			if (searchParameters.isAnalyze_wildcard() != true) {
				qb.analyzeWildcard(searchParameters.isAnalyze_wildcard());
				logger.info("analyze_wildcard=" + searchParameters.isAnalyze_wildcard());
			}
			QueryBuilder matchAllQuery = QueryBuilders.matchAllQuery();
			FilterBuilder filterBuilder = FilterBuilders.queryFilter(qb);
			QueryBuilder filterquery = QueryBuilders.filteredQuery(matchAllQuery, filterBuilder);
			searchRequest.setQuery(filterquery);
			logger.info("set query succeed!");
		} else {
			QueryStringQueryBuilder qb = QueryBuilders.queryString(searchParameters.getQ());
			if (searchParameters.getAnalyzer() != "ik") {
				qb.analyzer(searchParameters.getAnalyzer());
				logger.info("analyzer=" + searchParameters.getAnalyzer());
			}

			if (searchParameters.getDf() != "") {
				qb.defaultField(searchParameters.getDf());
				logger.info("default_field=" + searchParameters.getDf());
			}

			if (searchParameters.getDefault_operator() != Operator.OR) {
				qb.defaultOperator(searchParameters.getDefault_operator());
				logger.info("operator=" + searchParameters.getDefault_operator());
			}

			if (searchParameters.isLowercase_expanded_terms() != true) {
				qb.lowercaseExpandedTerms(searchParameters.isLowercase_expanded_terms());
				logger.info("Lowercase_expanded_terms=" + searchParameters.isLowercase_expanded_terms());
			}

			if (searchParameters.isAnalyze_wildcard() != true) {
				qb.analyzeWildcard(searchParameters.isAnalyze_wildcard());
				logger.info("analyze_wildcard=" + searchParameters.isAnalyze_wildcard());
			}
			searchRequest.setQuery(qb);
			logger.info("set query succeed!");
		}
		if (searchParameters.getExplain() != false)
			searchRequest.setExplain(searchParameters.getExplain());

		if (searchParameters.getFrom() != 0)
			searchRequest.setFrom(searchParameters.getFrom());

		if (searchParameters.getSort() != "") {
			for (String sort : searchParameters.getSort().split(",")) {
				searchRequest.addSort(sort.split(":")[0], "desc".equalsIgnoreCase(sort.split(":")[1]) ? SortOrder.DESC
						: SortOrder.ASC);
			}
		}
		if (searchParameters.getSize() != 10)
			searchRequest.setSize(searchParameters.getSize());

		if (searchParameters.getTimeout() != new TimeValue(1000000))
			searchRequest.setTimeout(searchParameters.getTimeout());

		if (searchParameters.isTrack_scores() != true)
			searchRequest.setTrackScores(searchParameters.isTrack_scores());

		if (searchParameters.getSearch_type() != "query_then_fetch")
			searchRequest.setSearchType(searchParameters.getSearch_type());
		if (searchParameters.getFields() != "") {
			String[] fields = searchParameters.getFields().split(",");
			searchRequest.addFields(fields);
		}
		if (searchParameters.is_source() != false)
			searchRequest.setFetchSource(searchParameters.is_source());

		return searchRequest.execute().actionGet();
	}

}
