import java.util.ArrayList;
import java.util.List;

import dao.MealDAO;
import dao.MealDAOImpl;
import dao.MealKindDAO;
import dao.MealKindDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import entity.Meal;
import entity.MealKind;
import entity.User;
import service.MealKindService;
import service.MealKindServiceImpl;
import service.MealService;
import service.UserService;
import service.UserServiceImpl;


public class testcsdl {

	public static void main(String[] args) {
//		DishService dishService = new DishServiceImpl();
//		List<Dish> list = dishService.listDish();
//		for(Dish d: list){
//			System.out.println(d);
//		}
		
//		UserDAO u = new UserDAOImpl();
//		UserService us = new UserServiceImpl(u);
//		List<User> l = us.listUser();
//		for(User user: l){
//			System.out.println(user);
//		}
		
		MealKindDAO mealKindDAO = new MealKindDAOImpl();
		MealKindService mealKindService = new MealKindServiceImpl(mealKindDAO);
		List<MealKind> lmealKind = mealKindService.listMealKind();
		MealKind mealkind = new MealKind();
		for(MealKind m : lmealKind){
//			System.out.println(m);
			if(m.getName().equals("food")) mealkind=m;
		}
		
//		System.out.println(mealkind);
		List<Meal> meal = mealkind.getlMeal();
		System.out.println(meal);
		
		
	}
}
