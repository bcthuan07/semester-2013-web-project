/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.PaymentMethod;

/**
 * @author Thuan
 *
 */
public class PaymentMethodDAO implements GeneralDAO<PaymentMethod, Integer>{

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#listObject()
	 */
	@Override
	public List<PaymentMethod> listObject() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<PaymentMethod> list = session.createQuery("from PaymentMethod").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#addObject(java.lang.Object)
	 */
	@Override
	public void addObject(PaymentMethod object) {
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
	public void updateObject(PaymentMethod object) {
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
		PaymentMethod paymentMethod = (PaymentMethod) session.load(PaymentMethod.class, object);
		session.delete(paymentMethod);
		session.getTransaction().commit();
		session.close();
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#getObject(java.lang.Object)
	 */
	@Override
	public PaymentMethod getObject(Integer key) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		PaymentMethod paymentMethod = (PaymentMethod) session.load(PaymentMethod.class, key);
		session.getTransaction().commit();
		session.close();
		return paymentMethod;
	}

}