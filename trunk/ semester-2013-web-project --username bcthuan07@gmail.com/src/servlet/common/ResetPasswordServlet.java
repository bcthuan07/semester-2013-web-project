package servlet.common;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import org.hibernate.Query;
import org.hibernate.Session;

import service.DAOService;
import util.HibernateUtil;
import util.MailUtil;
import util.PasswordUtil;
import util.ValidateData;
import dao.UserDAO;

/**
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet("/ResetPassword")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetPasswordServlet() {
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

		String email = request.getParameter("email");
		String email_err = "";

		if (email == null || email.equals("")) {
			email_err += "Email không được để trống!";
		} else {
			boolean isEmail = ValidateData.isEmail(email);
			email_err += isEmail ? "" : "Email không hợp lệ!";
		}

		if (email_err.length() == 0) {
			Session session = HibernateUtil.openSession();
			Query query = session
					.createQuery("from User u where u.email = :e ");
			query.setString("e", email);
			@SuppressWarnings("unchecked")
			List<User> list = query.list();
			session.close();
			if (list.size() == 0) {
				String error = "Không tìm thấy user này!";
				request.setAttribute("error", error);
				getServletContext().getRequestDispatcher("/resetpassword.jsp")
						.forward(request, response);
			} else {
				User u = list.get(0);

				String rPass = u.hashCode() + "";

				try {
					byte[] salt = PasswordUtil.generateSalt();
					byte[] newPass = PasswordUtil.getEncryptedPassword(rPass,
							salt);
					u.setPassword(newPass);
					u.setSalt(salt);
				} catch (NoSuchAlgorithmException e) {
				}
				DAOService<User, Integer> service = new DAOService<>(
						new UserDAO());
				service.updateObject(u);
				String username = getServletContext().getInitParameter(
						"manageuser");
				String pass = "dfghjhFGHJKL";
				String msgBody = "Password mới của bạn là:\n\r" + rPass;
				boolean isSent = MailUtil.send(username, "Thay đổi mật khẩu",
						pass, email, u.getUsername(), "Thay đổi password",
						msgBody, "text/plain");
				if (isSent) {
					String message = "Password mới đã được gửi tới email của bạn!";
					request.setAttribute("message", message);
					getServletContext().getRequestDispatcher("/complete.jsp")
							.forward(request, response);
				} else {
					String message = "Không thể reset password!";
					request.setAttribute("error", message);
					getServletContext().getRequestDispatcher(
							"/error/commonerror.jsp")
							.forward(request, response);

				}
			}
		} else {
			request.setAttribute("error", email_err);
			getServletContext().getRequestDispatcher("/resetpassword.jsp").forward(request, response);
		}
	}

}
