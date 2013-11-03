package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.Dish;
import entity.HibernateUtil;

public class DishDAOImpl implements DishDAO {

	@Override
	public void addDish(Dish dish) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.save(dish);
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public List<Dish> listDish() {
		// TODO Auto-generated method stub
		List<Dish> list = new ArrayList<>();
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		list = s.createQuery("from Dish").list();
		s.getTransaction().commit();
		s.close();
		return list;
	}

	@Override
	public void removeDish(Integer id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		Dish d = (Dish) s.load(Dish.class, id);
		s.delete(d);
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void updateDish(Dish dish) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.update(dish);
		s.getTransaction().commit();
		s.close();
	}

}
