package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MealKindService;
import service.MealKindServiceImpl;
import dao.MealKindDAO;
import dao.MealKindDAOImpl;
import entity.Meal;
import entity.MealKind;

/**
 * Servlet implementation class FoodView
 */
@WebServlet("/foods")
public class FoodView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWork(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWork(request, response);
		
	}

	private void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
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
//		System.out.println(meal);
		
		request.setAttribute("foodlist", meal);
		request.getRequestDispatcher("/foods.jsp").forward(request, response);
	}
}
