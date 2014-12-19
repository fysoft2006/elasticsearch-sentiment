package zx.soft.es.core.search;

import org.junit.Test;

import zx.soft.es.core.testUtils.BuildTestClient;

public class AggregationTest {

	@Test
	public void test() {

		Aggregation aggregation = new Aggregation(BuildTestClient.buildClient());
		aggregation.termsAggregation("风暴");
	}

}
