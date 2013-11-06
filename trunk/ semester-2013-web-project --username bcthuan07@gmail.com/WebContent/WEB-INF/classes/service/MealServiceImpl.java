package service;

import java.util.List;

import dao.MealDAO;
import entity.Meal;

public class MealServiceImpl implements MealService{

	private MealDAO mealDAO;

	public MealServiceImpl(MealDAO mealDAO) {
		super();
		this.mealDAO = mealDAO;
	}

	@Override
	public void addMeal(Meal meal) {
		// TODO Auto-generated method stub
		mealDAO.addMeal(meal);
	}

	@Override
	public List<Meal> listMeal() {
		// TODO Auto-generated method stub
		return mealDAO.listMeal();
	}

	@Override
	public void removeMeal(Integer id) {
		// TODO Auto-generated method stub
		mealDAO.removeMeal(id);
	}

	@Override
	public void updateMeal(Meal meal) {
		// TODO Auto-generated method stub
		mealDAO.updateMeal(meal);
	}
	
	
}
