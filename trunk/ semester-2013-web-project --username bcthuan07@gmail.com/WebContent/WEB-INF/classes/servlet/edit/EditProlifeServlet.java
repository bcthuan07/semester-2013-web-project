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
		
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String oldpassword = request.getParameter("oldpassword");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String gioitinh = request.getParameter("gioitinh");
		String fullname = request.getParameter("fullname");

		String phonenumber_err = "";
		String email_err = "";
		String oldpassword_err = "";
		String password1_err = "";
		String password2_err = "";
		String fullname_err="";
		boolean gender = false;
		int phone = 0;
		
		System.out.println(password1);System.out.println(password2);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(fullname==null || fullname.equals("")){
			fullname_err+="Vui lòng nhập tên đầy đủ!";
		}

		if (phonenumber == null || phonenumber.equals("")) {
			phonenumber_err += "Vui lòng nhập số điện thoại";
		} else {
			try {
				phone = Integer.parseInt(phonenumber);
			} catch (NumberFormatException e) {
				phonenumber_err+="Vui lòng nhập lại số điện thoại.";
			}
		}

		if (email == null || email.equals("")) {
			email_err += "Vui lòng nhập email.";
		} else {
			email_err = ValidateData.isEmail(email) ? ""
					: "Vui lòng nhập lại email.";
		}

		if (oldpassword == null || oldpassword.equals("")) {
			oldpassword_err += "Vui lòng nhập password cũ.";
		} else {
			oldpassword_err += PasswordUtil.authenticate(oldpassword,
					user.getPassword(), user.getSalt()) ? "" : "Password sai.";
		}

		if (password1 == null || password1.equals("")) {
			password1_err += "Vui lòng nhập lại password1.";
		}

		if (password2 == null || password2.equals("")) {
			password2_err += "Vui lòng nhập password2.";
		} else if (!password2.equals(password1)) {
			password2_err += "Password2 và password1 không trùng nhau.";
		}

		gender = gioitinh.equals("Nam") ? true : false;

		if (  password1_err.length() == 0
				&& password2_err.length() == 0 && oldpassword_err.length() == 0
				&& email_err.length() == 0 && phonenumber_err.length() == 0 && fullname_err.length()==0) {

			DAOService<User, Integer> daoService = new DAOService<>(new UserDAO());
			User userUpdate = (User) session.getAttribute("user");
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
			userUpdate.setPhoneNumber(phone+"");
			System.out.println(daoService.updateObject(userUpdate));
			response.sendRedirect("home.jsp");
		} else {
			request.setAttribute("phonenumber", phonenumber);
			request.setAttribute("email", email);
			request.setAttribute("fullname", fullname);
			
			request.setAttribute("fullname_err", fullname_err);
			request.setAttribute("oldpassword_err", oldpassword_err);
			request.setAttribute("phonenumber_err", phonenumber_err);
			request.setAttribute("email_err", email_err);
			request.setAttribute("password1_err", password1_err);
			request.setAttribute("password2_err", password2_err);
			request.getRequestDispatcher("detail/prolifeedit.jsp").forward(request, response);
		}

	}

}
