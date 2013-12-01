package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DAOService;
import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class ChooseProductServlet
 */
@WebServlet("/ChooseProduct")
public class ChooseProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChooseProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}
	protected void toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] listIdProduct = request.getParameterValues("idProducts");
		int[] idsProduct = new int[listIdProduct.length];
		for(int i = 0; i < listIdProduct.length;i++){
			idsProduct[i] = Integer.parseInt(listIdProduct[i]);
		}
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) request.getSession().getAttribute("listproduct");
		if(listProduct == null){
			listProduct = new ArrayList<>();
		}
		DAOService<Product, Integer> daoService = new DAOService<>(new ProductDAO());
		for(int i = 0; i < listIdProduct.length;i++){
			listProduct.add(daoService.getObjectById(new Integer(idsProduct[i])));
		}
		
		request.getSession().setAttribute("listproduct", listProduct);
		response.sendRedirect("validateorder.jsp");
	}

	
}
