/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.ProductType;

/**
 * @author Thuan
 * 
 */
public class ProductTypeDAO implements GeneralDAO<ProductType, Integer> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#listObject()
	 */
	@Override
	public List<ProductType> listObject() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<ProductType> list = session.createQuery("from ProductType").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#addObject(java.lang.Object)
	 */
	@Override
	public void addObject(ProductType object) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#updateObject(java.lang.Object)
	 */
	@Override
	public void updateObject(ProductType object) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#removeObject(java.lang.Object)
	 */
	@Override
	public void removeObject(Integer object) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		ProductType productType = (ProductType) session.load(ProductType.class, object);
		session.delete(productType);
		session.getTransaction().commit();
		session.close();
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
		session.beginTransaction();
		ProductType productType = (ProductType) session.load(ProductType.class, key);
		session.getTransaction().commit();
		session.close();
		return productType;
	}

}
