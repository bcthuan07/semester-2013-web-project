package service;

import java.util.List;

import dao.DishDAO;
import dao.DishDAOImpl;
import entity.Dish;

public class DishServiceImpl implements DishService{

	private DishDAO dishDAO = new DishDAOImpl();
	@Override
	public void addDish(Dish dish) {
		// TODO Auto-generated method stub
		dishDAO.addDish(dish);
	}

	@Override
	public List<Dish> listDish() {
		// TODO Auto-generated method stub
		return dishDAO.listDish();
	}

	@Override
	public void removeDish(Integer id) {
		// TODO Auto-generated method stub
		dishDAO.removeDish(id);
	}

	@Override
	public void updateDish(Dish dish) {
		// TODO Auto-generated method stub
		dishDAO.updateDish(dish);
	}

}
