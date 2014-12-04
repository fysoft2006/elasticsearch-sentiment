package zx.soft.es.web.application;

import java.util.List;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import zx.soft.es.client.BuildClient;
import zx.soft.es.core.domain.Weibo;
import zx.soft.es.core.index.BulkIndex;
import zx.soft.es.web.resource.IndexServerResource;

/**
 * 微博数据索引应用类
 * @author fgq
 *
 */
public class IndexApplication extends Application {

	//private final Index in;

	private final BulkIndex bulkIndex;

	public IndexApplication() {
		//in = new Index(BuildClient.buildClient(), "spiderindextest", "spidertypetest");
		bulkIndex = new BulkIndex(BuildClient.buildClient(), "spiderindextest", "spidertypetest");
	}

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/index", IndexServerResource.class);
		return router;
	}

	public void createIndex(List<Weibo> weibos) {
		//in.createIndex(weibos);
		bulkIndex.doIndex(weibos);
	}

}
