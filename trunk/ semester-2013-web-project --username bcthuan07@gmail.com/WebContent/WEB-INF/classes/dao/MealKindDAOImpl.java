package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.HibernateUtil;
import entity.MealKind;

public class MealKindDAOImpl implements MealKindDAO {

	@Override
	public void addMealKind(MealKind mealkind) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.save(mealkind);
		s.getTransaction().commit();
		s.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MealKind> listMealKind() {
		// TODO Auto-generated method stub
		List<MealKind> list = new ArrayList<>();
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		list = s.createQuery("from MealKind").list();
		s.getTransaction().commit();
		s.close();
		return list;
	}

	@Override
	public void removeMealKind(Integer id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		MealKind mealkind = (MealKind) s.load(MealKind.class, id);
		s.delete(mealkind);
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void updateMealKind(MealKind mealkind) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.update(mealkind);
		s.getTransaction().commit();
		s.close();
	}

}
