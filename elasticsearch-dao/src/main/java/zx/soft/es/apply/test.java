package zx.soft.es.apply;

import java.util.List;

import zx.soft.es.mapper.WeiboMapper;
import zx.soft.es.sqloperation.SQLOperation;

public class test {

	public static void main(String[] args) {
		SQLOperation sqlOperation = new SQLOperation();
		ThreadCore threadCore = new ThreadCore();
		List<String> tablenames = sqlOperation.getTablename();
		for (String tablename : tablenames) {
			int count = sqlOperation.getCount(tablename);
			int pageCount = count / WeiboMapper.num;
			for (int i = 0; i < pageCount; i++) {
				int from = i * WeiboMapper.num;
				threadCore.getData("sina_user_weibos_1386614765", from);
			}
		}
		threadCore.close();
	}
}
