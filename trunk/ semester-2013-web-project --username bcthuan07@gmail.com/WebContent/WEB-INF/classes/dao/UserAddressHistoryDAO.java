/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.UserAddressHistory;
import model.UserAddressHistoryId;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class UserAddressHistoryDAO implements
		GeneralDAO<UserAddressHistory, UserAddressHistoryId> {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAddressHistory> listObject() {
		Session session = HibernateUtil.openSession();
		List<UserAddressHistory> list = new ArrayList<>();
		try {
			session.beginTransaction();
			list = session.createQuery("from UserAddressHistory").list();
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
	public boolean addObject(UserAddressHistory object) {
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			session.save(object);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public boolean updateObject(UserAddressHistory object) {
		Session session = HibernateUtil.openSession();
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
	}

	@Override
	public boolean removeObject(UserAddressHistoryId object) {
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			UserAddressHistory uah = (UserAddressHistory) session.load(
					UserAddressHistory.class, object);
			session.delete(uah);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
			return false;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	@Override
	public UserAddressHistory getObject(UserAddressHistoryId key) {
		Session session = HibernateUtil.openSession();
		UserAddressHistory uah = null;
		try {
			session.beginTransaction();
			uah = (UserAddressHistory) session.get(UserAddressHistory.class,
					key);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return uah;
	}

}
