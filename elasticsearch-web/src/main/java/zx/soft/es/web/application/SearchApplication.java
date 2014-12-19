package zx.soft.es.web.application;

import java.io.IOException;
import java.util.Properties;

import org.elasticsearch.action.deletebyquery.DeleteByQueryResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.soft.es.client.BuildClient;
import zx.soft.es.core.delete.Delete;
import zx.soft.es.core.domain.CountResult;
import zx.soft.es.core.domain.SearchParameters;
import zx.soft.es.core.search.Count;
import zx.soft.es.core.search.SearchingData;
import zx.soft.es.web.resource.CountResource;
import zx.soft.es.web.resource.SearchServerResource;
import zx.soft.utils.config.ConfigUtil;

public class SearchApplication extends Application {

	private static Logger logger = LoggerFactory.getLogger(SearchApplication.class);
	private final SearchingData searchingData;
	private final Count count;
	private Delete delete;
	private Properties props = ConfigUtil.getProps("index.properties");

	public SearchApplication() {
		searchingData = new SearchingData(BuildClient.buildClient(), props.getProperty("name.index"),
				props.getProperty("name.type"));
		count = new Count(BuildClient.buildClient(), props.getProperty("name.index"));
		delete = new Delete(BuildClient.buildClient(), props.getProperty("name.index"));
	}

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router();
		router.attach("/search", SearchServerResource.class);
		router.attach("/search/count", CountResource.class);
		return router;
	}

	public SearchResponse doSearch(SearchParameters searchParameters) {
		SearchResponse response = null;
		try {
			response = searchingData.doSearch(searchParameters);
		} catch (IOException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	public CountResult doCount(SearchParameters searchParameters) {
		CountResult countResult = null;
		try {
			countResult = count.getMatchCount(searchParameters);
		} catch (IOException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return countResult;
	}

	public DeleteByQueryResponse doDeleteByQuery(SearchParameters searchParameters) {
		DeleteByQueryResponse response = null;
		try {
			response = delete.deleteByQuery(searchParameters);
		} catch (IOException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
}
