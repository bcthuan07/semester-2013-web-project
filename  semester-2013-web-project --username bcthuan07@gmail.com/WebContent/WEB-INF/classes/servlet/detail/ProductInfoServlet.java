package servlet.detail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.DAOService;
import dao.ProductDAO;

/**
 * Servlet implementation class ProductInfoServlet
 */
@WebServlet("/ProductInfo")
public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}
	
	protected void toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

		String idProduct = request.getParameter("idProduct");
		if(idProduct==null){
			response.sendRedirect("menu.jsp");
		} else {
			Integer id = Integer.parseInt(idProduct);
			DAOService<Product, Integer> daoService = new DAOService<>(new ProductDAO());
			Product product = daoService.getObjectById(id);
			request.setAttribute("product", product);
			request.getRequestDispatcher("detail/productdetail.jsp").forward(request, response);
		}
	}
	
	

}
