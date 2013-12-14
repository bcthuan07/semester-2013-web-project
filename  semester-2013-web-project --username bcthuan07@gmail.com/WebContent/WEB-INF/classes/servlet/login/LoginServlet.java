package servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String username_err = "";
		String password_err = "";
		if (username.trim().equals("") || username == null) {
			username_err += "Vui loÌng nhâòp username!";
		}
		if (password.trim().equals("") || password == null) {
			password_err += "Vui loÌng nhâòp password!";
		}

		if (username_err.length() == 0 && password_err.length() == 0) {

			LoginService ls = new LoginService();
			boolean hasUser = ls.hasUser(username);
			if (!hasUser) {
				username_err += "User không tôÌn taòi!";
				request.setAttribute("username_err", username_err);
				request.setAttribute("password_err", password_err);
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			} else {
				User user = ls.authenticate(username, password);
				if (user == null) {
					password_err += "Password không ðuìng!";
					request.setAttribute("username_err", username_err);
					request.setAttribute("password_err", password_err);
					request.getRequestDispatcher("login.jsp").forward(request,
							response);
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					boolean permission = user.getPermission();
					if (permission) {
						response.sendRedirect("manage/manage.jsp");
					} else {
						response.sendRedirect("home.jsp");
					}

				}
			}

		} else {
			request.setAttribute("username_err", username_err);
			request.setAttribute("password_err", password_err);
			request.setAttribute("username", username);
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}
	}

}
