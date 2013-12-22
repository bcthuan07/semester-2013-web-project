/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.Role;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class RoleDAO implements GeneralDAO<Role, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listObject() {
		List<Role> list = new ArrayList<>();
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			list = session.createQuery("from Role").list();
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
	public boolean addObject(Role object) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#updateObject(java.lang.Object)
	 */
	@Override
	public boolean updateObject(Role object) {
		// TODO Auto-generated method stub
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
				Role role = (Role) session.load(Role.class, object);
				session.delete(role);
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
	public Role getObject(Integer key) {
		Session session = HibernateUtil.openSession();
		Role role = null;
		try {
			session.beginTransaction();
			role = (Role) session.get(Role.class, key);
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println(e.getMessage());
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return role;
	}

}
