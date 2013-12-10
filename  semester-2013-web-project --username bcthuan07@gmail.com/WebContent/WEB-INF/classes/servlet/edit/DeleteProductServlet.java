package servlet.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.User;
import service.DAOService;
import dao.ProductDAO;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProductServlet() {
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
		
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

		String idProduct = request.getParameter("product");
		HttpSession session = request.getSession();

		User staff = (User) session.getAttribute("user");
		boolean permission = false;
		if (staff != null) {
			permission = staff.getPermission();
		}

		if (!permission) {
			DAOService<Product, Integer> daoService = new DAOService<>(
					new ProductDAO());
			Integer id = Integer.parseInt(idProduct);
			boolean isDeleted = daoService.removeObject(id);
			if (isDeleted) {
				response.sendRedirect("manage/product.jsp");
			} else {
				String error = "Không thể xóa sản phẩm này.";
				request.setAttribute("error", error);
				request.getRequestDispatcher("error/commonerror.jsp").forward(request,
						response);
			}
		} else {
			String error = "Bạn không có quyền truy cập trang này!";
			request.setAttribute("error", error);
			request.getRequestDispatcher("error/commonerror.jsp").forward(
					request, response);
		}
	}

}
