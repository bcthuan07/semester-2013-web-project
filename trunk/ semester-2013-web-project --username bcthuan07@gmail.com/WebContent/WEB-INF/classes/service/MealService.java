package service;

import java.util.List;

import entity.Meal;

public interface MealService {

	public void addMeal(Meal meal);
	public List<Meal> listMeal();
	public void removeMeal(Integer id);
	public void updateMeal(Meal meal);
}
