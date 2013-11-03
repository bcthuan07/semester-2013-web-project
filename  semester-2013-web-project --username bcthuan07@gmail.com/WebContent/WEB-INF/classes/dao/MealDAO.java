package dao;

import java.util.List;

import entity.Meal;

public interface MealDAO {

	public void addMeal(Meal meal);
	public List<Meal> listMeal();
	public void removeMeal(Integer id);
	public void updateMeal(Meal meal);
}
