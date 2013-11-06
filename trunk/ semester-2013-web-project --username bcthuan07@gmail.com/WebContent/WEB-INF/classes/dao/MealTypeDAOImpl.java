package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.HibernateUtil;
import entity.MealType;

public class MealTypeDAOImpl implements MealTypeDAO{

	@Override
	public void addMealType(MealType mealtype) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.save(mealtype);
		s.getTransaction().commit();
		s.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MealType> listMealType() {
		// TODO Auto-generated method stub
		List<MealType> list = new ArrayList<>();
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		list = s.createQuery("from MealType").list();
		s.getTransaction().commit();
		s.close();
		return list;
	}

	@Override
	public void removeMealType(Integer id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		MealType mealtype = (MealType) s.load(MealType.class,id);
		s.delete(mealtype);
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void updateMealType(MealType mealtype) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.update(mealtype);
		s.getTransaction().commit();
		s.close();
	}

}
