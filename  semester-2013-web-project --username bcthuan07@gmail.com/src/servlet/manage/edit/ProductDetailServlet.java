package servlet.manage.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;
import service.DAOService;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/Manage/ProductDetail")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductDetailServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void toDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String product = request.getParameter("p") == null ? "" : request
				.getParameter("p");
		Integer id = 0;
		boolean isNumber = true;
		try {
			id = Integer.parseInt(product);
		} catch (Exception e) {
			isNumber = false;
		}
		if (isNumber) {
			DAOService<Product, Integer> service = new DAOService<Product, Integer>(
					new ProductDAO());
			Product p = service.getObjectById(id);
			if (p == null) {
				response.sendRedirect(request.getContextPath()+"/Manage/Product");
			} else {
				request.setAttribute("product", p);
				getServletContext().getRequestDispatcher("/manage/admin-editproduct.jsp").forward(
						request, response);
			}
		} else {
			response.sendRedirect(request.getContextPath()+"/Manage/Product");
		}
	}

}
