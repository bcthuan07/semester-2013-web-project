/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.UserOrder;

/**
 * @author Thuan
 *
 */
public class UserOrderDAO implements GeneralDAO<UserOrder, Integer>{

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#listObject()
	 */
	@Override
	public List<UserOrder> listObject() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<UserOrder> list = session.createQuery("from UserOrder").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#addObject(java.lang.Object)
	 */
	@Override
	public void addObject(UserOrder object) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
		
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#updateObject(java.lang.Object)
	 */
	@Override
	public void updateObject(UserOrder object) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
		session.close();
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#removeObject(java.lang.Object)
	 */
	@Override
	public void removeObject(Integer object) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		UserOrder userOrder = (UserOrder) session.load(UserOrder.class, object);
		session.delete(userOrder);
		session.getTransaction().commit();
		session.close();
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#getObject(java.lang.Object)
	 */
	@Override
	public UserOrder getObject(Integer key) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		UserOrder userOrder = (UserOrder) session.load(UserOrder.class, key);
		session.getTransaction().commit();
		session.close();
		return userOrder;
	}

}
