package servlet.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.DAOService;
import dao.UserDAO;

/**
 * Servlet implementation class ManageUserServlet
 */
@WebServlet("/ManageUser")
public class ManageUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManageUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		boolean permission = user == null ? false : user.getPermission();

		if (!permission) {
			response.sendRedirect("home.jsp");
		} else {
			DAOService<User, Integer> service = new DAOService<User, Integer>(new UserDAO());
			List<User> listuser = service.listObject();
			List<User> listcustomer = new ArrayList<User>();
			for(User u: listuser){
				if(!u.getPermission())
					listcustomer.add(u);
			}
			request.setAttribute("listcustomer", listcustomer);
			request.getRequestDispatcher("manage/user.jsp").forward(request, response);
		}

	}

}
