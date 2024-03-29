
package dao;

import java.util.ArrayList;
import java.util.List;

import model.Product;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class ProductDAO implements GeneralDAO<Product, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listObject() {
		Session session = HibernateUtil.openSession();
		List<Product> list = new ArrayList<>();
		try {
			session.beginTransaction();
			list = session.createQuery("from Product").list();
		} catch (Exception e) {
			System.err.println(e.getMessage());
//			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return list;
	}

	@Override
	public boolean addObject(Product object) {
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
	public boolean updateObject(Product object) {
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
				Product product = (Product) session.load(Product.class, object);
				session.delete(product);
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
	public Product getObject(Integer key) {
		Session session = HibernateUtil.openSession();
		Product product = null;
		try {
			session.beginTransaction();
			product = (Product) session.get(Product.class, key);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return product;
	}

}
