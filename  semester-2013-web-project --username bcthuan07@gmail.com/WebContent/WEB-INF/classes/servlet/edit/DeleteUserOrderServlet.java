package servlet.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserOrder;
import service.DAOService;
import dao.UserOrderDAO;

/**
 * Servlet implementation class DeleteUserOrderServlet
 */
@WebServlet("/DeleteUserOrder")
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

		User staff = (User) session.getAttribute("user");
		boolean permission = false;
		if (staff != null) {
			permission = staff.getPermission();
		}

		if (permission) {
			Integer id = Integer.parseInt(userOrder);
			DAOService<UserOrder, Integer> daoService = new DAOService<>(
					new UserOrderDAO());
			boolean isDeleted = daoService.removeObject(id);
			if (isDeleted) {
				response.sendRedirect("manage/order.jsp");
			} else {
				String error = "Không thể xóa hóa đơn này.";
				request.setAttribute("error", error);
				request.getRequestDispatcher("error/commonerror.jsp").forward(
						request, response);
			}
		} else {
			String error = "Bạn không có quyền truy cập trang này!";
			request.setAttribute("error", error);
			request.getRequestDispatcher("error/commonerror.jsp").forward(request, response);
		}
	}

}
