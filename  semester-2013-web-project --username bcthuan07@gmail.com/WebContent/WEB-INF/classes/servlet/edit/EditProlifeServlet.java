package servlet.edit;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;
import service.DAOService;
import util.PasswordUtil;
import util.ValidateData;

/**
 * Servlet implementation class EditProlifeServlet
 */
@WebServlet("/EditProlife")
public class EditProlifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditProlifeServlet() {
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
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String oldpassword = request.getParameter("oldpassword");
		String password1 = request.getParameter("newpassword1");
		String password2 = request.getParameter("newpassword2");
		String gioitinh = request.getParameter("gioitinh");
		String fullname = request.getParameter("fullname") == null ? "" : "";

		String username_err = "";
		String phonenumber_err = "";
		String email_err = "";
		String oldpassword_err = "";
		String password1_err = "";
		String password2_err = "";
		boolean gender = false;
		int phone = 0;
		

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (username == null || username.equals("")) {
			username_err += "Vui loÌng nhâòp username.";
		} else {
			username_err = ValidateData.isUsername(username) ? ""
					: "Vui loÌng nhâòp laòi username.";
		}

		if (phonenumber == null || phonenumber.equals("")) {
			phonenumber_err += "Vui loÌng nhâòp sôì ðiêòn thoaòi";
		} else {
			try {
				phone = Integer.parseInt(phonenumber);
			} catch (NumberFormatException e) {
				phonenumber_err+="Vui loÌng nhâòp laòi sôì ðiêòn thoaòi.";
			}
		}

		if (email == null || email.equals("")) {
			email_err += "Vui loÌng nhâòp email.";
		} else {
			email_err = ValidateData.isEmail(email) ? ""
					: "Vui loÌng nhâòp laòi email.";
		}

		if (oldpassword == null || oldpassword.equals("")) {
			oldpassword_err += "Vui loÌng nhâòp password cuÞ.";
		} else {
			oldpassword_err += PasswordUtil.authenticate(oldpassword,
					user.getPassword(), user.getSalt()) ? "" : "Password sai.";
		}

		if (password1 == null || password1.equals("")) {
			password1_err += "Vui loÌng nhâòp laòi password1.";
		}

		if (password2 == null || password2.equals("")) {
			password2_err += "Vui loÌng nhâòp password2.";
		} else if (!password2.equals(password1)) {
			password2_err += "Password2 vaÌ password1 không truÌng nhau.";
		}

		gender = gioitinh.equals("Nam") ? true : false;

		if (username_err.length() == 0 && password1_err.length() == 0
				&& password2_err.length() == 0 && oldpassword_err.length() == 0
				&& email_err.length() == 0 && phonenumber_err.length() == 0) {

			DAOService<User, Integer> daoService = new DAOService<>(new UserDAO());
			User userUpdate = new User();
			userUpdate.setEmail(email);
			byte[] saltUpdate = new byte[8];
			try {
				saltUpdate = PasswordUtil.generateSalt();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			userUpdate.setSalt(saltUpdate);
			userUpdate.setPassword(PasswordUtil.getEncryptedPassword(password1, saltUpdate));
			userUpdate.setFullname(fullname);
			userUpdate.setGender(gender);
			userUpdate.setUsername(username);
			userUpdate.setPhoneNumber(phone+"");
			daoService.updateObject(userUpdate);
		} else {
			request.setAttribute("username_err", username_err);
			request.setAttribute("oldpassword_err", oldpassword_err);
			request.setAttribute("phonenumber_err", phonenumber_err);
			request.setAttribute("email_err", email_err);
			request.setAttribute("password1_err", password1_err);
			request.setAttribute("password2_err", password2_err);
			request.getRequestDispatcher("detail/prolifeedit.jsp").forward(request, response);
		}

	}

}
