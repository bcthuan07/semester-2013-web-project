/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.ProductType;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class ProductTypeDAO implements GeneralDAO<ProductType, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> listObject() {
		Session session = HibernateUtil.openSession();
		List<ProductType> list = new ArrayList<>();
		try {
			session.beginTransaction();
			list = session.createQuery("from ProductType").list();
		} catch (Exception e) {
			System.err.println(e.getMessage());
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
	public boolean addObject(ProductType object) {
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
	public boolean updateObject(ProductType object) {
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
				ProductType productType = (ProductType) session.load(
						ProductType.class, object);
				session.delete(productType);
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
	public ProductType getObject(Integer key) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		ProductType productType = null;
		try {
			session.beginTransaction();
			productType = (ProductType) session.get(ProductType.class, key);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return productType;
	}

}
