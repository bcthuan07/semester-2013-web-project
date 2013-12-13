package servlet.detail;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.User;
import service.RegisterService;
import util.PasswordUtil;
import util.ValidateData;
import exception.UsernameException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		String gioitinh = request.getParameter("gender");
		String buildingNumber = request.getParameter("buildingnumber");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String street = request.getParameter("street");

		String username_err = "";
		String password_err = "";
		String fullname_err = "";
		String email_err = "";
		String phonenumber_err = "";
		String buildingNumber_err = "";
		String city_err = "";
		String zipcode_err = "";
		String street_err = "";
		int bdn = 0;
		int zc = 0;
		byte[] pass = new byte[8];
		byte[] salt = new byte[8];
		String common_err = "Trường này không được để trống.";
		boolean gender = gioitinh.equals("Nam") ? true : false;
		if (username.equals("") || username == null) {
			username_err += common_err;
		}

		if (password.equals("") || password == null) {
			password_err += common_err;
		} else {
			if (!ValidateData.isPassword(password)) {
				password_err += "Password phải có 1 kí tự in hoa, 1 chữ số.";
			} else {
				try {
					salt = PasswordUtil.generateSalt();
					pass = PasswordUtil.getEncryptedPassword(password, salt);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			}

		}

		if (fullname.equals("") || fullname == null) {
			fullname_err += common_err;
		}

		if (email.equals("") || email == null) {
			email_err += common_err;
		} else {
			email_err += ValidateData.isEmail(email) ? ""
					: "Email không hợp lệ.";
		}

		if (phonenumber.equals("") || phonenumber == null) {
			phonenumber_err += common_err;
		} else {
			try {
				Integer.parseInt(phonenumber);
			} catch (NumberFormatException e) {
				phonenumber_err += "Số điện thoại không hợp lệ.";
			}
		}

		if (street.equals("") || street == null) {
			street_err += common_err;
		}

		if (buildingNumber.equals("") || buildingNumber == null) {
			buildingNumber_err += common_err;
		} else {
			try {
				bdn = Integer.parseInt(buildingNumber);
			} catch (NumberFormatException e) {
				buildingNumber_err += "Số nhà không hợp lệ.";
			}
		}

		if (zipcode.equals("") || zipcode == null) {
			zipcode_err += common_err;
		} else {
			try {
				zc = Integer.parseInt(zipcode);
			} catch (NumberFormatException e) {
				zipcode_err += "Mã Zipcode không hợp lệ.";
			}
		}

		if (city.equals("") || city == null) {
			city_err += common_err;
		}

		if (username_err.length() == 0 && password_err.length() == 0
				&& fullname_err.length() == 0 && email_err.length() == 0
				&& phonenumber_err.length() == 0
				&& buildingNumber_err.length() == 0 && city_err.length() == 0
				&& zipcode_err.length() == 0 && street_err.length() == 0) {
			Address address = new Address();
			address.setBuildingNumber(bdn);
			address.setCity(city);
			address.setStreet(street);
			address.setZipCode(zc);

			User user = new User();
			user.setDatecreated(new Date());
			user.setEmail(email);
			user.setFullname(fullname);
			user.setGender(gender);
			user.setPermission(false);
			user.setUsername(username);
			user.setSalt(salt);
			user.setPassword(pass);
			user.setPhoneNumber(phonenumber);

			try {
				RegisterService registerService = new RegisterService();
				registerService.register(user, address);

			} catch (UsernameException e) {
				System.out.println(e.getMessage());
				username_err += e.getMessage();
				request.setAttribute("username", username);
				request.setAttribute("email", email);
				request.setAttribute("fullname", fullname);
				request.setAttribute("buildingnumber", buildingNumber);
				request.setAttribute("city", city);
				request.setAttribute("street", street);
				request.setAttribute("zipcode", zipcode);
				request.setAttribute("phonenumber", phonenumber);

				request.setAttribute("username_err", username_err);
				request.setAttribute("email_err", email_err);
				request.setAttribute("fullname_err", fullname_err);
				request.setAttribute("buildingnumber_err", buildingNumber_err);
				request.setAttribute("city_err", city_err);
				request.setAttribute("street_err", street_err);
				request.setAttribute("zipcode_err", zipcode_err);
				request.setAttribute("phonenumber_err", phonenumber_err);

				request.getRequestDispatcher("register.jsp").forward(request,
						response);
			}
			String message = "Bạn đã đăng kí thành công!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("complete.jsp").forward(request, response);;
		} else {
			request.setAttribute("username", username);
			request.setAttribute("email", email);
			request.setAttribute("fullname", fullname);
			request.setAttribute("buildingnumber", buildingNumber);
			request.setAttribute("city", city);
			request.setAttribute("street", street);
			request.setAttribute("zipcode", zipcode);
			request.setAttribute("phonenumber", phonenumber);

			request.setAttribute("username_err", username_err);
			request.setAttribute("email_err", email_err);
			request.setAttribute("fullname_err", fullname_err);
			request.setAttribute("buildingnumber_err", buildingNumber_err);
			request.setAttribute("city_err", city_err);
			request.setAttribute("street_err", street_err);
			request.setAttribute("zipcode_err", zipcode_err);
			request.setAttribute("phonenumber_err", phonenumber_err);

			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		}
	}

}
