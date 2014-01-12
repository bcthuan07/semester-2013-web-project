package servlet.manage.edit;

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
 * Servlet implementation class FeedbackDetailServlet
 */
@WebServlet("/Manage/FeedbackDetail")
public class FeedbackDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FeedbackDetailServlet() {
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

		String idFeedback = request.getParameter("feedbackid");
		int id = Integer.parseInt(idFeedback);
		System.out.println(idFeedback);
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
				request.setAttribute("feedback", service.getObjectById(id));
				if (roleSet.contains(new RoleMember(new RoleMemberId(user
						.getUserId(), 1))))
					getServletContext().getRequestDispatcher(
							"/manage/admin-feedback.jsp").forward(request,
							response);
				else
					getServletContext().getRequestDispatcher(
							"/manage/staff-feedback-detail.jsp").forward(request,
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
