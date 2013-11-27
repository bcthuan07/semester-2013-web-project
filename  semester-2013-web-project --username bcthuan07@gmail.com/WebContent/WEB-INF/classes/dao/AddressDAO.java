/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.Session;

import entity.Address;
import util.HibernateUtil;

/**
 * @author Thuan
 *
 */
public class AddressDAO implements GeneralDAO<Address,Integer>{

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#listObject()
	 */
	@Override
	public List<Address> listObject() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Address> list = session.createQuery("from Address").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#addObject(java.lang.Object)
	 */
	@Override
	public void addObject(Address object) {
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
	public void updateObject(Address object) {
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
		Address address = (Address) session.load(Address.class, object);
		session.delete(address);
		session.getTransaction().commit();
		session.close();
	}

	/* (non-Javadoc)
	 * @see dao.GeneralDAO#getObject(java.lang.Object)
	 */
	@Override
	public Address getObject(Integer key) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Address address = (Address) session.load(Address.class, key);
		session.getTransaction().commit();
		session.close();
		return address;
	}

	
	
}
