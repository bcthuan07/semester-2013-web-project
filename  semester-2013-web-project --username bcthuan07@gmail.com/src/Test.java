import java.util.List;

import entity.Dish;
import service.DishService;
import service.DishServiceImpl;


public class Test {

	public static void main(String[] args) {
		DishService dishService = new DishServiceImpl();
		List<Dish> list = dishService.listDish();
		for(Dish d: list){
			System.out.println(d);
		}
	}
}
