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
import service.LoginService;

/**
 * Servlet implementation class LoginManageServlet
 */
@WebServlet("/Manage/LoginManage")
public class LoginManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginManageServlet() {
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String username_err = "";
		String password_err = "";
		if (username == null || username.trim().equals("")) {
			username_err += "Vui lo�ng nh��p username!";
		}
		if (password == null || password.trim().equals("")) {
			password_err += "Vui lo�ng nh��p password!";
		}

		if (username_err.length() == 0 && password_err.length() == 0) {

			LoginService ls = new LoginService();
			boolean hasUser = ls.hasUser(username);
			if (!hasUser) {
				username_err += "User kh�ng t��n ta�i!";
				request.setAttribute("username", username);
				request.setAttribute("username_err", username_err);
				request.setAttribute("password_err", password_err);
				getServletContext().getRequestDispatcher(
						"/manage/managelogin.jsp").forward(request, response);

			} else {
				User user = ls.authenticate(username, password);
				if (user == null) {
					password_err += "Password kh�ng �u�ng!";
					request.setAttribute("username", username);
					request.setAttribute("username_err", username_err);
					request.setAttribute("password_err", password_err);
					getServletContext().getRequestDispatcher(
							"/manage/managelogin.jsp").forward(request,
							response);
				} else {

					HttpSession session = request.getSession();
					Set<RoleMember> roleSet = user.getUserRoleMembers();

					if (roleSet.contains(new RoleMember(new RoleMemberId(user
							.getUserId(), 1)))) {
						session.setAttribute("user", user);
						getServletContext().getRequestDispatcher("/Manage").forward(request, response);
					} else if (roleSet.contains(new RoleMember(
							new RoleMemberId(user.getUserId(), 2)))) {
						session.setAttribute("user", user);
						getServletContext().getRequestDispatcher("/Manage").forward(request, response);
					} else {
						response.sendRedirect("home.jsp");
					}

				}
			}

		} else {
			request.setAttribute("username_err", username_err);
			request.setAttribute("password_err", password_err);
			request.setAttribute("username", username);
			getServletContext().getRequestDispatcher("/manage/managelogin.jsp")
					.forward(request, response);
		}
	}

}
