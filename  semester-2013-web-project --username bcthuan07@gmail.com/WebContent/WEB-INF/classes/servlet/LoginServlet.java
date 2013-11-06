package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserService;
import service.UserServiceImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWork(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doWork(request, response);
	}

	private void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password");
		String username_err = "";
		String password_err = "";

		if(username.length()==0) username_err+="Bạn chưa nhập username!";
		if(password.length()==0) password_err+="Bạn chưa nhập password!";
		
		
		if (username.length()>0 && password.length()>0) {

			UserDAO userDAO = new UserDAOImpl();
			UserService userService = new UserServiceImpl(userDAO);
			User user = new User();
			List<User> listUser = userService.listUser();
			boolean cont = true;
			for (User u : listUser) {
				System.out.println(u.getUsername());
				System.out.println(username);
				if (u.getUsername().equals(username)) {				
					cont = false;
					user = u;
					break;
				}
			}
			System.out.println(user);
			if (cont)
				username_err += "User không tồn tại!";

			if(user.getPassword()!=null)
				if (!user.getPassword().equals(password))
					password_err += "Password không đúng!";
			System.out.println(cont);
			if(username_err.length()==0&&password_err.length()==0){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("index.jsp");
			}else{
				System.out.println(username_err + "  "+password_err);
				request.setAttribute("username_err", username_err);
				request.setAttribute("password_err", password_err);
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
				;
			}
		} else {
//			request.setAttribute(username_err, "username_err");
//			request.setAttribute(password_err, "password_err");
			request.setAttribute("username_err", username_err);
			request.setAttribute("password_err", password_err);
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			;
		}
		
//		if(username_err.length()>0&&password_err.length()>0)
//		{
//			request.setAttribute("username", username);
//			request.getRequestDispatcher("/login.jsp").forward(request,response);
//		}
	}

}
