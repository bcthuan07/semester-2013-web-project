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
import service.DAOService;
import dao.UserDAO;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/Manage/DeleteUser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteUserServlet() {
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

		String userId = request.getParameter("user");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {

			Set<RoleMember> roleSet = user.getUserRoleMembers();

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))) {
				Integer id = Integer.parseInt(userId);
				DAOService<User, Integer> service = new DAOService<>(
						new UserDAO());
				boolean isDeleted = service.removeObject(id);
				if (isDeleted) {
					getServletContext().getRequestDispatcher("/Manage/"+type).forward(request, response);
				} else {
					String error = "Đã có lỗi xảy ra. Không thể xóa người dùng này!";
					request.setAttribute("error", error);
					getServletContext().getRequestDispatcher(
							"/error/commonerror.jsp")
							.forward(request, response);
				}
			} else {
				response.sendRedirect("manage/managelogin.jsp");

			}
		} else {
			response.sendRedirect("manage/managelogin.jsp");

		}
	}

}
