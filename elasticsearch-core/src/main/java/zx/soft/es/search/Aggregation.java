package zx.soft.es.search;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder.Operator;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.elasticsearch.search.aggregations.metrics.min.Min;

import zx.soft.es.client.BuildClient;

public class Aggregation {
	public static void main(String[] args) {
		QueryBuilder qb = QueryBuilders.queryString("风暴").defaultOperator(Operator.AND);
		AggregationBuilder<?> ab = AggregationBuilders.terms("新浪微博").field("source_name")
				.subAggregation(AggregationBuilders.min("last_time").field("source_id"));
		SearchResponse sr = BuildClient.buildClient().prepareSearch("spiderindextest").setQuery(qb).addAggregation(ab)
				.execute().actionGet();

		Terms terms = sr.getAggregations().get("新浪微博");
		for (Bucket b : terms.getBuckets()) {
			Min min = b.getAggregations().get("last_time");
			System.out.println("source_name:" + b.getKey() + "  docCount:" + b.getDocCount() + "   last_time  min="
					+ min.getValue());
		}
	}
}
