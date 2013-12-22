/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.UserOrder;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class UserOrderDAO implements GeneralDAO<UserOrder, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserOrder> listObject() {
		Session session = HibernateUtil.openSession();
		List<UserOrder> list = new ArrayList<>();
		try {
			session.beginTransaction();
			list = session.createQuery("from UserOrder").list();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return list;
	}

	@Override
	public boolean addObject(UserOrder object) {
		Session session = HibernateUtil.openSession();
		try {
			try {
				session.beginTransaction();
				session.save(object);
				return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				System.err.println(e.getMessage());
				return false;
			} finally {
				session.getTransaction().commit();
				session.close();
			}
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateObject(UserOrder object) {
		Session session = HibernateUtil.openSession();
		try {
			try {
				session.beginTransaction();
				session.update(object);
				return true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				session.getTransaction().rollback();
				return false;
			} finally {
				session.getTransaction().commit();
				session.close();
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeObject(Integer object) {
		Session session = HibernateUtil.openSession();
		try {
			try {
				session.beginTransaction();
				UserOrder userOrder = (UserOrder) session.load(UserOrder.class,
						object);
				session.delete(userOrder);
				return true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				session.getTransaction().rollback();
				return false;
			} finally {
				session.getTransaction().commit();
				session.close();
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public UserOrder getObject(Integer key) {
		Session session = HibernateUtil.openSession();
		UserOrder userOrder = null;
		try {
			session.beginTransaction();
			userOrder = (UserOrder) session.get(UserOrder.class, key);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}

		return userOrder;
	}

}
