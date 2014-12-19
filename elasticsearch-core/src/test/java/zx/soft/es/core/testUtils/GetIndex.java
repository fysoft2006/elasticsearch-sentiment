package zx.soft.es.core.testUtils;

import java.util.Properties;

import zx.soft.utils.config.ConfigUtil;

public class GetIndex {

	public static String getIndex() {
		try {
			Properties props = ConfigUtil.getProps("elasticsearch.properties");
			String index = props.getProperty("es.index");
			return index;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getType() {
		try {
			Properties props = ConfigUtil.getProps("elasticsearch.properties");
			String type = props.getProperty("es.type");
			return type;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
