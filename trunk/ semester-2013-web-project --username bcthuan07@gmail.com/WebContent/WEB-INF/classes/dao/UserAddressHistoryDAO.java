/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.UserAddressHistory;
import entity.UserAddressHistoryId;

/**
 * @author Thuan
 * 
 */
public class UserAddressHistoryDAO implements
		GeneralDAO<UserAddressHistory, UserAddressHistoryId> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#listObject()
	 */
	@Override
	public List<UserAddressHistory> listObject() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<UserAddressHistory> list = session.createQuery(
				"from UserAddressHistory").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#addObject(java.lang.Object)
	 */
	@Override
	public void addObject(UserAddressHistory object) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#updateObject(java.lang.Object)
	 */
	@Override
	public void updateObject(UserAddressHistory object) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#removeObject(java.lang.Object)
	 */
	@Override
	public void removeObject(UserAddressHistoryId object) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		UserAddressHistory uah = (UserAddressHistory) session.load(
				UserAddressHistory.class, object);
		session.delete(uah);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#getObject(java.lang.Object)
	 */
	@Override
	public UserAddressHistory getObject(UserAddressHistoryId key) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		UserAddressHistory uah = (UserAddressHistory) session.load(
				UserAddressHistory.class, key);
		session.getTransaction().commit();
		session.close();
		return uah;
	}

}
