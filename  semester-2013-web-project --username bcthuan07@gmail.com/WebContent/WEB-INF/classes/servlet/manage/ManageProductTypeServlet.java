package servlet.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.ProductType;
import model.User;
import service.DAOService;
import dao.ProductDAO;
import dao.ProductTypeDAO;

/**
 * Servlet implementation class ManageProductTypeServlet
 */
@WebServlet("/ManageProductType")
public class ManageProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManageProductTypeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}
	
	protected void toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		boolean permission = user==null? false: user.getPermission();
		if (!permission) {
			response.sendRedirect("home.jsp");
		} else {
			DAOService<ProductType, Integer> service = new DAOService<ProductType, Integer>(new ProductTypeDAO());
			List<ProductType> listproduct = service.listObject();
			request.setAttribute("listproducttype", listproduct);
			request.getRequestDispatcher("manage/producttype.jsp").forward(request, response);
		}

	}
}
