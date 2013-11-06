package dao;

import java.util.List;

import entity.MealKind;

public interface MealKindDAO {

	public void addMealKind(MealKind mealkind);
	public List<MealKind> listMealKind();
	public void removeMealKind(Integer id);
	public void updateMealKind(MealKind mealkind);
}