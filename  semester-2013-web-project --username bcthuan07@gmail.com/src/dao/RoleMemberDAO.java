/**
 * 
 */
package dao;

import java.util.ArrayList;
import java.util.List;

import model.RoleMember;
import model.RoleMemberId;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Thuan
 * 
 */
public class RoleMemberDAO implements GeneralDAO<RoleMember, RoleMemberId> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.GeneralDAO#listObject()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RoleMember> listObject() {
		Session session = HibernateUtil.openSession();
		List<RoleMember> list = new ArrayList<>();
		try {
			session.beginTransaction();
			list = session.createQuery("from RoleMember").list();
		} catch (Exception e) {
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
	public boolean addObject(RoleMember object) {
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
	public boolean updateObject(RoleMember object) {
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
	public boolean removeObject(RoleMemberId object) {
		Session session = HibernateUtil.openSession();
		try {
			try {
				session.beginTransaction();
				RoleMember rm = (RoleMember) session.load(RoleMember.class, object);
				session.delete(rm);
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
	public RoleMember getObject(RoleMemberId key) {
		Session session = HibernateUtil.openSession();
		RoleMember rm = null;
		try {
			session.beginTransaction();
			rm = (RoleMember) session.get(RoleMember.class, key);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return rm;
	}

}
