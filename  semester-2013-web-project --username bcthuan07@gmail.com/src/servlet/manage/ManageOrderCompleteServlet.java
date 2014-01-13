package servlet.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
 * Servlet implementation class ManageOrderCompleteServlet
 */
@WebServlet("/Manage/OrderComplete")
public class ManageOrderCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageOrderCompleteServlet() {
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
			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))
					|| roleSet.contains(new RoleMember(new RoleMemberId(user
							.getUserId(), 2)))) {
				DAOService<UserOrder, Integer> service = new DAOService<>(
						new UserOrderDAO());
				List<UserOrder> incomplete = new ArrayList<>();
				for (UserOrder uo : service.listObject()) {
					if (uo.getOrderStatus().getOrderStatusId() == 2)
						incomplete.add(uo);
				}
				request.setAttribute("listorder", incomplete);
				String link = roleSet.contains(new RoleMember(new RoleMemberId(
						user.getUserId(), 1))) ? "admin-order.jsp" : "staff-order.jsp";

				getServletContext().getRequestDispatcher(
						"/manage/"+link).forward(request, response);
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
