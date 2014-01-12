package servlet.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
 * Servlet implementation class ManageCustomerServlet
 */
@WebServlet("/Manage/Customer")
public class ManageCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageCustomerServlet() {
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
		if (user != null) {

			Set<RoleMember> roleSet = user.getUserRoleMembers();

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))) {
				DAOService<User, Integer> service = new DAOService<User, Integer>(
						new UserDAO());
				List<User> listcustomer = new ArrayList<User>();
				for (User u : service.listObject()) {
					Set<RoleMember> set = u.getUserRoleMembers();
					System.out.println(set);
					if (set.contains(new RoleMember(new RoleMemberId(user
							.getUserId(), new Integer(3)))))
						listcustomer.add(u);
				}
				System.out.println(listcustomer);
				request.setAttribute("listcustomer", listcustomer);
				getServletContext().getRequestDispatcher(
						"/manage/admin-customer.jsp").forward(request, response);
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
