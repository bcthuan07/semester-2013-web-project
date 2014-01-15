package servlet.manage;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RoleMember;
import model.RoleMemberId;
import model.User;
import model.UserOrder;
import service.DAOService;
import dao.UserOrderDAO;

/**
 * Servlet implementation class OrderDetailServlet
 */
@WebServlet("/Manage/OrderDetail")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderDetailServlet() {
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

			Integer id = Integer.parseInt(request.getParameter("idOrder"));
			UserOrder order = new DAOService<>(new UserOrderDAO())
					.getObjectById(id);
			request.setAttribute("order", order);

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))) {

				getServletContext().getRequestDispatcher(
						"/manage/admin-order-detail.jsp").forward(request,
						response);
			} else {
				getServletContext().getRequestDispatcher(
						"/manage/staff-order-detail.jsp").forward(request,
						response);
			}
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/manage/managelogin.jsp");

		}
	}

}
