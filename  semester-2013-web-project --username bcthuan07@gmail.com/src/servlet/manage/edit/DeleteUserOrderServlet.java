package servlet.manage.edit;

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
 * Servlet implementation class DeleteUserOrderServlet
 */
@WebServlet("/Manage/DeleteUserOrder")
public class DeleteUserOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteUserOrderServlet() {
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

		String userOrder = request.getParameter("userorder");
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		if (user != null) {

			Set<RoleMember> roleSet = user.getUserRoleMembers();

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))) {
				Integer id = Integer.parseInt(userOrder);
				DAOService<UserOrder, Integer> daoService = new DAOService<>(
						new UserOrderDAO());
				boolean isDeleted = daoService.removeObject(id);
				if (isDeleted) {
					response.sendRedirect(request.getContextPath()
							+ "/manage/admin-order.jsp");
				} else {
					String error = "Đã có lỗi xảy ra. Không thể xóa hóa đơn này!";
					request.setAttribute("error", error);
					getServletContext().getRequestDispatcher(
							"/error/commonerror.jsp")
							.forward(request, response);
				}
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
