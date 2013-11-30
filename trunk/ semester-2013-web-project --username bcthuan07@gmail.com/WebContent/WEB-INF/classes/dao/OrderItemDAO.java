/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.OrderItem;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class OrderItemDAO implements GeneralDAO<OrderItem, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItem> listObject() {
		Session session = HibernateUtil.openSession();
		List<OrderItem> list = new ArrayList<>();
		try {
			session.beginTransaction();
			list = session.createQuery("from OrderItem").list();
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
	public boolean addObject(OrderItem object) {
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
	public boolean updateObject(OrderItem object) {
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
	public boolean removeObject(Integer object) {
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			OrderItem orderItem = (OrderItem) session.load(OrderItem.class,
					object);
			session.delete(orderItem);
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
	public OrderItem getObject(Integer key) {
		Session session = HibernateUtil.openSession();
		OrderItem orderItem = null;
		try {
			session.beginTransaction();
			orderItem = (OrderItem) session.get(OrderItem.class, key);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return orderItem;
	}

}
