package servlet.common;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Feedback;
import service.DAOService;
import util.ValidateData;
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
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String content = request.getParameter("content");

		String fullname_err = "";
		String email_err = "";
		String content_err = "";

		if (fullname == null || fullname.equals(""))
			fullname_err += "Họ và tên không được để trống!";

		if (email == null || email.equals("")) {
			email_err += "Email không được để trống!";
		} else {
			boolean isEmail = ValidateData.isEmail(email);
			email_err += isEmail ? "" : "Email không hợp lệ!";
		}

		if (content == null || content.equals(""))
			content_err += "Nội dung không được để trống!";

		if (content_err.length() == 0 && email_err.length() == 0
				&& fullname_err.length() == 0) {
			DAOService<Feedback, Integer> service = new DAOService<>(new FeedbackDAO());
			Feedback fb = new Feedback();
			fb.setContent(content);
			fb.setDateCreated(new Date());
			fb.setFullname(fullname);
			fb.setEmail(email);
			
			boolean isAdded = service.addObject(fb);
			if(!isAdded){
				String error = "Rất tiếc, chúng tôi không thể gửi phản hồi của bạn!";
				request.setAttribute("error", error);
				getServletContext().getRequestDispatcher("/error/commonerror.jsp").forward(request, response);
			} else {
				String message = "Phản hồi của bạn đã được gửi đi!";
				request.setAttribute("message", message);
				getServletContext().getRequestDispatcher("/complete.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("fullname",fullname);
			request.setAttribute("email", email);
			request.setAttribute("content", content);
			
			request.setAttribute("fullname_err", fullname_err);
			request.setAttribute("email_err", email_err);
			request.setAttribute("content_err", content_err);
			
			getServletContext().getRequestDispatcher("/lienhe.jsp").forward(request, response);
		}
	}

}
