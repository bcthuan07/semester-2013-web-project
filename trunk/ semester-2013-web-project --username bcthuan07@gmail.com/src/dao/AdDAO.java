/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.Ads;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class AdDAO implements GeneralDAO<Ads, Integer> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#listObject()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Ads> listObject() {
		List<Ads> list = new ArrayList<>();
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			list = session.createQuery("from Ads").list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
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
	public boolean addObject(Ads object) {
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
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#updateObject(java.lang.Object)
	 */
	@Override
	public boolean updateObject(Ads object) {
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
				Ads ad = (Ads) session.load(Ads.class, object);
				session.delete(ad);
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
	public Ads getObject(Integer key) {
		Session session = HibernateUtil.openSession();
		Ads ad = null;
		try {
			session.beginTransaction();
			ad = (Ads) session.get(Ads.class, key);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return ad;
	}

}
