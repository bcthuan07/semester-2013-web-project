package servlet.manage;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.RoleMember;
import model.RoleMemberId;
import model.User;
import service.DAOService;
import dao.ProductDAO;

/**
 * Servlet implementation class ManageProductServlet
 */
@WebServlet("/Manage/Product")
public class ManageProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageProductServlet() {
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

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			
			Set<RoleMember> roleSet = user.getUserRoleMembers();
			
			if (roleSet.contains(new RoleMember(new RoleMemberId(user.getUserId(), 1)))) {
				DAOService<Product, Integer> service = new DAOService<Product, Integer>(
						new ProductDAO());
				List<Product> listproduct = service.listObject();
				request.setAttribute("listproduct", listproduct);
				getServletContext().getRequestDispatcher(
						"/manage/admin-product.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath()
						+ "/manage/managelogin.jsp");
			}
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/manage/managelogin.jsp");

		}

	}

}
