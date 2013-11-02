package service;

import java.util.List;

import entity.Dish;

public interface DishService {

	public void addDish(Dish dish);
	public List<Dish> listDish();
	public void removeDish(Integer id);
	public void updateDish(Dish dish);
	
}
