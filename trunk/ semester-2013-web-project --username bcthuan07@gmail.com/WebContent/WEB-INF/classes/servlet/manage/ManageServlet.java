package servlet.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

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
		User staff = (User) session.getAttribute("user");
		boolean permission = false;
		if (staff != null) {
			permission = staff.getPermission();
		}
		
		if(permission){
			response.sendRedirect("manage/manage.jsp");
		} else {
			String error = "Bạn không có quyền truy cập trang này.";
			request.setAttribute("error", error);
			request.getRequestDispatcher("error/commonerror.jsp").forward(request, response);
		}
	}

}
