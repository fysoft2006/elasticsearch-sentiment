package zx.soft.es.sqlhandle;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import zx.soft.es.domain.SinaWeibo;
import zx.soft.es.utils.HibernateConfig;

public class JDBC {

	private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	/**
	 * 获得表中记录数
	 * @return 记录数
	 */
	public Object getTableCount() {
		Session session = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			String sql = "SELECT max(s.id) FROM SinaWeibo s";
			Query query = session.createQuery(sql);
			Object count = query.uniqueResult();
			t.commit();
			return count;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			session.close();
		}
	}

	/**
	 * 获取数据库SianWeibo对象列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SinaWeibo> getText(String from, String size) {
		Session session = sessionFactory.openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			String hql = "FROM SinaWeibo WHERE id>=:id_from and id<:id_to";

			Query Query = session.createQuery(hql);
			Query.setParameter("id_from", from);
			Query.setParameter("id_to", String.valueOf(Integer.valueOf(from) + Integer.valueOf(size)));
			List<SinaWeibo> sinaWeibos = Query.list();
			t.commit();
			return sinaWeibos;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		JDBC jdbc = new JDBC();
		/*Object count = jdbc.getTableCount();
		System.out.println(count);*/
		List<SinaWeibo> textList = new ArrayList<>();
		textList = jdbc.getText(String.valueOf(100), String.valueOf(1000));
		System.out.println(textList.size());
	}
}
