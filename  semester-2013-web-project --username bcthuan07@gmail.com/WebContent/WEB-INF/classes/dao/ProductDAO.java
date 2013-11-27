/**
 * 
 */
package dao;

import java.util.List;

import util.HibernateUtil;

import org.hibernate.Session;

import entity.Product;

/**
 * @author Thuan
 *
 */
public class ProductDAO implements GeneralDAO<Product, Integer>{

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#listObject()
	 */
	@Override
	public List<Product> listObject() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Product> list = session.createQuery("from Product").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#addObject(java.lang.Object)
	 */
	@Override
	public void addObject(Product object) {
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
	public void updateObject(Product object) {
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
		Product product = (Product) session.load(Product.class, object);
		session.delete(product);
		session.getTransaction().commit();
		session.close();
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#getObject(java.lang.Object)
	 */
	@Override
	public Product getObject(Integer key) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Product product = (Product) session.load(Product.class, key);
		session.delete(product);
		session.getTransaction().commit();
		session.close();
		return product;
	}

}
