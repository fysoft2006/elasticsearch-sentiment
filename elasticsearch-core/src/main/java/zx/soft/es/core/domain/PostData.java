package zx.soft.es.core.domain;

import java.util.List;

public class PostData {
	private List<Weibo> records;
	private int num;

	public List<Weibo> getRecords() {
		return records;
	}

	public void setRecords(List<Weibo> records) {
		this.records = records;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
