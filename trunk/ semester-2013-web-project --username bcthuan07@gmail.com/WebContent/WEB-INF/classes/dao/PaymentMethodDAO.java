/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.PaymentMethod;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class PaymentMethodDAO implements GeneralDAO<PaymentMethod, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public List<PaymentMethod> listObject() {
		Session session = HibernateUtil.openSession();
		List<PaymentMethod> list = new ArrayList<>();
		try {
			session.beginTransaction();
			list = session.createQuery("from PaymentMethod").list();
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
	public boolean addObject(PaymentMethod object) {
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
	public boolean updateObject(PaymentMethod object) {
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
			PaymentMethod paymentMethod = (PaymentMethod) session.load(
					PaymentMethod.class, object);
			session.delete(paymentMethod);
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
	public PaymentMethod getObject(Integer key) {
		Session session = HibernateUtil.openSession();
		PaymentMethod paymentMethod = null;
		try {
			session.beginTransaction();
			paymentMethod = (PaymentMethod) session.get(PaymentMethod.class,
					key);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return paymentMethod;
	}

}