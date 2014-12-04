package zx.soft.es.thread;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.soft.es.domain.SinaWeibo;
import zx.soft.es.sqloperation.SQLOperation;

public class GetWeiboDataThread implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(GetWeiboDataThread.class);
	private int from;
	private String tablename;

	public GetWeiboDataThread(String tablename, int from) {
		this.from = from;
		this.tablename = tablename;
	}

	@Override
	public void run() {
		SQLOperation sqlOperation = new SQLOperation();
		List<SinaWeibo> weibos = sqlOperation.getWeiboData(tablename, from);
		logger.info("succeed get weibo data size=" + weibos.size());
	}
}
