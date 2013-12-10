/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.User;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class UserDAO implements GeneralDAO<User, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listObject() {
		Session session = HibernateUtil.openSession();
		List<User> list = new ArrayList<>();
		try {
			session.beginTransaction();
			list = session.createQuery("from User").list();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return list;
	}

	@Override
	public boolean addObject(User object) {
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
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateObject(User object) {
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
				User user = (User) session.load(User.class, object);
				session.delete(user);
				
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
	public User getObject(Integer key) {
		Session session = HibernateUtil.openSession();
		User user = null;
		try {
			session.beginTransaction();
			user = (User) session.get(User.class, key);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return user;
	}

}
