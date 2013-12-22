package servlet.order;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Feedback;
import model.User;
import service.DAOService;
import dao.FeedbackDAO;

/**
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/Feedback")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FeedbackServlet() {
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
		boolean isHave = user == null ? false : true;
		String content = request.getParameter("content");
		String content_err = "";
		if (content == null || content.equals("")) {
			content_err += "Nội dung không được để trống!";
		}
		
		if(content_err.length()==0){
			if (isHave) {
				DAOService<Feedback, Integer> service = new DAOService<>(
						new FeedbackDAO());
				Feedback fb = new Feedback();
				fb.setDateCreated(new Date());
				fb.setContent(content);
				service.addObject(fb);
			
				response.sendRedirect("home.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
		} else {
			request.setAttribute("content_err", content_err);
			request.getRequestDispatcher("feedback.jsp").forward(request, response);
		}
	}

}
