/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.OrderItem;

/**
 * @author Thuan
 *
 */
public class OrderItemDAO implements GeneralDAO<OrderItem, Integer>{

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#listObject()
	 */
	@Override
	public List<OrderItem> listObject() {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<OrderItem> list = session.createQuery("from OrderItem").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#addObject(java.lang.Object)
	 */
	@Override
	public void addObject(OrderItem object) {
		// TODO Auto-generated method stub
		Session session =  HibernateUtil.openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#updateObject(java.lang.Object)
	 */
	@Override
	public void updateObject(OrderItem object) {
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
		OrderItem orderItem = (OrderItem) session.load(OrderItem.class, object);
		session.delete(orderItem);
		session.getTransaction().commit();
		session.close();
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#getObject(java.lang.Object)
	 */
	@Override
	public OrderItem getObject(Integer key) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		OrderItem orderItem = (OrderItem) session.load(OrderItem.class, key);
		session.getTransaction().commit();
		session.close();
		return orderItem;
	}
	

}
