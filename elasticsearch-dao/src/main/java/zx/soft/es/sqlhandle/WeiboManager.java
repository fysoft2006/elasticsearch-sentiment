package zx.soft.es.sqlhandle;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.soft.es.domain.SinaWeibo;
import zx.soft.es.utils.HibernateConfig;

public class WeiboManager {
	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(WeiboManager.class);

		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "FROM SinaWeibo WHERE id<=2000 AND id>1000";
			@SuppressWarnings("unchecked")
			List<SinaWeibo> sinaWeibos = session.createQuery(hql).list();
			for (SinaWeibo sinaWeibo : sinaWeibos) {
				logger.info("get sinaWeibo :" + sinaWeibo.getId());
				System.out.println(sinaWeibo.getText());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
