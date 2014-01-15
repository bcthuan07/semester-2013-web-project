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
import model.UserOrder;
import service.DAOService;
import dao.ProductDAO;
import dao.UserDAO;
import dao.UserOrderDAO;

/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/Manage")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageServlet() {
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

			String totalUser = "", totalProduct = "", totalOrder = "", totalOrderIncomplete = "";

			DAOService<User, Integer> userService = new DAOService<>(
					new UserDAO());
			int customer = 0;
			for (User u : userService.listObject()) {
				Set<RoleMember> set = u.getUserRoleMembers();
				if (set.contains(new RoleMember(new RoleMemberId(user
						.getUserId(), 3))))
					customer++;
			}
			totalUser = customer + "";
			DAOService<Product, Integer> productService = new DAOService<>(
					new ProductDAO());
			totalProduct = productService.listObject().size() + "";
			DAOService<UserOrder, Integer> orderService = new DAOService<>(
					new UserOrderDAO());
			List<UserOrder> listOrders = orderService.listObject();
			int orderIncomp = 0;
			int orderComp = 0;
			for (UserOrder order : listOrders) {
				if (order.getOrderStatus().getOrderStatusId().equals(1))
					orderIncomp++;
				else if (order.getOrderStatus().getOrderStatusId().equals(2))
					orderComp++;
			}
			totalOrderIncomplete = orderIncomp + "";
			totalOrder = orderComp + "";

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))) {
				request.setAttribute("totaluser", totalUser);
				request.setAttribute("totalproduct", totalProduct);
				request.setAttribute("totalorder", totalOrder);
				request.setAttribute("totalorderincomplete",
						totalOrderIncomplete);
				getServletContext().getRequestDispatcher(
						"/manage/admin-manage.jsp").forward(request, response);
			} else if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 2)))) {
				request.setAttribute("totalorder", totalOrder);
				request.setAttribute("totalorderincomplete",
						totalOrderIncomplete);
				getServletContext().getRequestDispatcher(
						"/manage/staff-manage.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath()
						+ "/manage/managelogin.jsp");
			}
		} else {
			response.sendRedirect("home.jsp");
		}
	}

}
