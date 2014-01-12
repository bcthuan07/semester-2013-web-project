package servlet.manage;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Feedback;
import model.RoleMember;
import model.RoleMemberId;
import model.User;
import service.DAOService;
import dao.FeedbackDAO;

/**
 * Servlet implementation class ManageFeedbackServlet
 */
@WebServlet("/Manage/Feedback")
public class ManageFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageFeedbackServlet() {
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
					.getUserId(), 1)))
					|| roleSet.contains(new RoleMember(new RoleMemberId(user
							.getUserId(), 2)))) {
				DAOService<Feedback, Integer> service = new DAOService<Feedback, Integer>(
						new FeedbackDAO());
				request.setAttribute("listfeedback", service.listObject());
				if (roleSet.contains(new RoleMember(new RoleMemberId(user
						.getUserId(), 1))))
					getServletContext().getRequestDispatcher(
							"/manage/admin-feedback.jsp").forward(request,
							response);
				else
					getServletContext().getRequestDispatcher(
							"/manage/staff-feedback.jsp").forward(request,
							response);
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
