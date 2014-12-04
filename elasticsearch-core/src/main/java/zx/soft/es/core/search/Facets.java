package zx.soft.es.core.search;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder.Operator;
import org.elasticsearch.search.facet.FacetBuilder;
import org.elasticsearch.search.facet.FacetBuilders;
import org.elasticsearch.search.facet.terms.TermsFacet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Facets {
	private static Logger logger = LoggerFactory.getLogger(Facets.class);
	private TransportClient client;

	public Facets(TransportClient client) {
		this.client = client;
	}

	public void facetstest() {
		FacetBuilder fb = FacetBuilders.termsFacet("新浪微博").field("source_name").size(20);
		QueryBuilder qb = QueryBuilders.queryString("风暴").defaultOperator(Operator.AND);
		SearchResponse sr = client.prepareSearch("spiderindextest").setQuery(qb).addFacet(fb).execute().actionGet();

		TermsFacet f = (TermsFacet) sr.getFacets().facetsAsMap().get("新浪微博");
		System.out.println(f.getTotalCount());
		System.out.println(f.getOtherCount());
		System.out.println(f.getMissingCount());

		for (TermsFacet.Entry entry : f) {
			System.out.print(entry.getTerm() + ":");
			System.out.println(entry.getCount());
		}
		logger.info("facets ok!");
	}
}
