/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.OrderStatus;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class OrderStatusDAO implements GeneralDAO<OrderStatus, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderStatus> listObject() {
		Session session = HibernateUtil.openSession();
		List<OrderStatus> list = new ArrayList<>();
		try {
			session.beginTransaction();
			list = session.createQuery("from OrderStatus").list();
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
	public boolean addObject(OrderStatus object) {
		Session session = HibernateUtil.openSession();
		try {
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
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateObject(OrderStatus object) {
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
				OrderStatus orderStatus = (OrderStatus) session.load(
						OrderStatus.class, object);
				session.delete(orderStatus);
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
	public OrderStatus getObject(Integer key) {
		Session session = HibernateUtil.openSession();
		OrderStatus orderStatus = null;
		try {
			session.beginTransaction();
			orderStatus = (OrderStatus) session.get(OrderStatus.class, key);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return orderStatus;
	}

}
