package zx.soft.es.core.search;

import java.io.IOException;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryStringQueryBuilder.Operator;
import org.junit.Test;

import zx.soft.es.core.domain.SearchParameters;
import zx.soft.es.core.testUtils.BuildTestClient;
import zx.soft.es.core.testUtils.GetIndex;

public class SearchingDataTest {

	@Test
	public void test() throws IOException {
		SearchParameters searchParameters = new SearchParameters();
		searchParameters.setFq(" 相信  ");
		searchParameters.setTimeout(new TimeValue(1000000));
		searchParameters.setSize(5);
		searchParameters.setFields("_source,content,nickname,read_count");
		searchParameters.setLowercase_expanded_terms(Boolean.FALSE);
		searchParameters.setTrack_scores(false);
		searchParameters.setFq("lasttime:[1416384000 TO 1416384010]");
		searchParameters.setFrom(1);
		searchParameters.setExplain(true);
		searchParameters.setDefault_operator(Operator.OR);
		SearchingData searchingData = new SearchingData(BuildTestClient.buildClient(), GetIndex.getIndex(),
				GetIndex.getType());
		SearchResponse response = searchingData.doSearch(searchParameters);
		System.out.println(response);
	}

}
