package dao;

import java.util.List;

import entity.MealType;

public interface MealTypeDAO {

	public void addMealType(MealType mealtype);
	public List<MealType> listMealType();
	public void removeMealType(Integer id);
	public void updateMealType(MealType mealtype);
	
}
