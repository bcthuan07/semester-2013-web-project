package servlet.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserOrderDAO;
import service.DAOService;
import model.User;
import model.UserOrder;

/**
 * Servlet implementation class ManageOrderServlet
 */
@WebServlet("/ManageOrder")
public class ManageOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageOrderServlet() {
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
		boolean permission = user == null ? false : user.getPermission();

		if (!permission) {
			response.sendRedirect("home.jsp");
		} else {
			DAOService<UserOrder, Integer> service = new DAOService<UserOrder, Integer>(new UserOrderDAO());
			List<UserOrder> listuserorder = service.listObject();
			request.setAttribute("listuserorder", listuserorder);
			request.getRequestDispatcher("manage/order.jsp").forward(request, response);
		}
	}

}
