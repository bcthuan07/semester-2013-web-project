package servlet.manage.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import service.DAOService;
import model.User;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUser")
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
		HttpSession session = request.getSession();
		User staff = (User) session.getAttribute("user");

		boolean permission = false;
		if (staff != null) {
			permission = staff.getPermission();
		}

		if (!permission) {
			String error = "Bạn không có quyền truy cập trang này!";
			request.setAttribute("error", error);
			request.getRequestDispatcher("error/commonerror.jsp").forward(
					request, response);
		} else {
			Integer id = Integer.parseInt(userId);
			DAOService<User, Integer> service = new DAOService<>(new UserDAO());
			boolean isDeleted = service.removeObject(id);
			if (isDeleted) {
				response.sendRedirect("manage/user.jsp");
			} else {
				String error = "Không thể xóa đối tượng này!";
				request.setAttribute("error", error);
				request.getRequestDispatcher("error/commonerror.jsp").forward(
						request, response);
			}
		}

	}

}
