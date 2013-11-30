/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.Address;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class AddressDAO implements GeneralDAO<Address, Integer> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#listObject()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> listObject() {
		// TODO Auto-generated method stub
		List<Address> list = new ArrayList<>();
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			list = session.createQuery("from Address").list();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#addObject(java.lang.Object)
	 */
	@Override
	public boolean addObject(Address object) {
		// TODO Auto-generated method stub
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#updateObject(java.lang.Object)
	 */
	@Override
	public boolean updateObject(Address object) {
		// TODO Auto-generated method stub
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#removeObject(java.lang.Object)
	 */
	@Override
	public boolean removeObject(Integer object) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			Address address = (Address) session.load(Address.class, object);
			session.delete(address);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#getObject(java.lang.Object)
	 */
	@Override
	public Address getObject(Integer key) {
		Session session = HibernateUtil.openSession();
		Address address = null;
		try {
			session.beginTransaction();
			address = (Address) session.get(Address.class, key);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return address;
	}

}
