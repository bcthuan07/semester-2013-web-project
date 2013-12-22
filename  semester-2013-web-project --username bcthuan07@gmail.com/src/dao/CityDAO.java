/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.City;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class CityDAO implements GeneralDAO<City, Integer> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#listObject()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<City> listObject() {
		List<City> list = new ArrayList<>();
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			list = session.createQuery("from City").list();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println(e.getMessage());
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
	public boolean addObject(City object) {
		Session session = HibernateUtil.openSession();
		try {
			try {
				session.beginTransaction();
				session.save(object);
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				session.getTransaction().rollback();
				return false;
			} finally {
				session.getTransaction().commit();
				session.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#updateObject(java.lang.Object)
	 */
	@Override
	public boolean updateObject(City object) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#removeObject(java.lang.Object)
	 */
	@Override
	public boolean removeObject(Integer object) {
		Session session = HibernateUtil.openSession();
		try {
			try {
				session.beginTransaction();
				City city = (City) session.load(City.class, object);
				session.delete(city);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#getObject(java.lang.Object)
	 */
	@Override
	public City getObject(Integer key) {
		Session session = HibernateUtil.openSession();
		City city = null;
		try {
			session.beginTransaction();
			city = (City) session.get(City.class, key);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return city;
	}

}
