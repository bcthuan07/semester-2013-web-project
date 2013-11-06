package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.HibernateUtil;
import entity.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.save(user);
		s.getTransaction().commit();
		s.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		list = s.createQuery("from User").list();
		s.getTransaction().commit();
		s.close();
		return list;
	}

	@Override
	public void removeUser(Integer iduser) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		User user = (User) s.load(User.class, iduser);
		s.delete(user);
		s.getTransaction().commit();
		s.close();
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.update(user);
		s.getTransaction().commit();
		s.close();
	}

	
}
