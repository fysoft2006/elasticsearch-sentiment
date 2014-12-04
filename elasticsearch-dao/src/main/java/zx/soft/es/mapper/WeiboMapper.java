package zx.soft.es.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import zx.soft.es.domain.SinaWeibo;

public interface WeiboMapper {
	public static final int num = 1000;

	@Select("SELECT * FROM  ${tablename} WHERE id>=#{from} AND id<(#{from}+" + num + ")")
	public List<SinaWeibo> getWeiboData(@Param("tablename") String tablename, @Param("from") int from);

	@Select("SELECT MAX(id) FROM  ${tablename}")
	public int getCount(@Param("tablename") String tablename);

	@Select("SELECT name FROM sina_tablenames")
	public List<String> getTablename();
}
