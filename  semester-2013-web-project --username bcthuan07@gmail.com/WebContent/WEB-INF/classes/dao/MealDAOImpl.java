package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.HibernateUtil;
import entity.Meal;

public class MealDAOImpl implements MealDAO{

	@Override
	public void addMeal(Meal meal) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.save(meal);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Meal> listMeal() {
		// TODO Auto-generated method stub
		List<Meal> list = new ArrayList<>();
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		list = session.createQuery("from Meal").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public void removeMeal(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Meal meal = (Meal) session.load(Meal.class, id);
		session.delete(meal);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void updateMeal(Meal meal) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.update(meal);
		session.getTransaction().commit();
		session.close();
	}

}
