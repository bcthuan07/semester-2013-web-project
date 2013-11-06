package service;

import java.util.List;

import entity.MealType;

public interface MealTypeService {

	public void addMealType(MealType mealtype);
	public List<MealType> listMealType();
	public void removeMealType(Integer id);
	public void updateMealType(MealType mealtype);
}
