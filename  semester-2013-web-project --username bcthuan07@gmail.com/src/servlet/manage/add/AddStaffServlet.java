package servlet.manage.add;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Address;
import model.City;
import model.PaymentMethod;
import model.RoleMember;
import model.RoleMemberId;
import model.User;
import service.DAOService;
import service.RegisterService;
import util.PasswordUtil;
import util.ValidateData;
import dao.CityDAO;
import dao.PaymentMethodDAO;
import exception.UsernameException;

/**
 * Servlet implementation class AddStaffServlet
 */
@WebServlet("/Manage/AddStaff")
public class AddStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddStaffServlet() {
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

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		if (user != null) {

			Set<RoleMember> roleSet = user.getUserRoleMembers();

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))) {

				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String fullname = request.getParameter("fullname");
				String email = request.getParameter("email");
				String phonenumber = request.getParameter("phonenumber");
				String gioitinh = request.getParameter("gender");
				String buildingNumber = request.getParameter("buildingnumber");
				String cityString = request.getParameter("city");
				String street = request.getParameter("street");
				String paymentMethodStr = request.getParameter("payment");

				String username_err = "";
				String password_err = "";
				String fullname_err = "";
				String email_err = "";
				String phonenumber_err = "";
				String buildingNumber_err = "";
				String street_err = "";
				int bdn = 0;
				Integer city_id = 0, paymentId = 0;
				byte[] pass = new byte[8];
				byte[] salt = new byte[8];
				boolean gender = gioitinh.equals("Nam") ? true : false;
				try {
					city_id = Integer.parseInt(cityString);
					paymentId = Integer.parseInt(paymentMethodStr);
				} catch (Exception e) {
				}

				if (username.equals("") || username == null) {
					username_err += "Username không được để trống!";
				}

				if (password.equals("") || password == null) {
					password_err += "Password không được để trống!";
				} else {
					if (!ValidateData.isPassword(password)) {
						password_err += "Password phải có 1 ký tự là số, 1 ký tự in hoa, độ dài password nằm trong khoảng 6 đến 20 ký tự";
					} else {
						try {
							salt = PasswordUtil.generateSalt();
							pass = PasswordUtil.getEncryptedPassword(password,
									salt);
						} catch (NoSuchAlgorithmException e) {
							e.printStackTrace();
						}
					}

				}

				if (fullname.equals("") || fullname == null) {
					fullname_err += "Tên đầy đủ không được để trống!";
				}

				if (email.equals("") || email == null) {
					email_err += "Email không được để trống!";
				} else {
					email_err += ValidateData.isEmail(email) ? ""
							: "Email không hợp lệ!";
				}

				if (phonenumber.equals("") || phonenumber == null) {
					phonenumber_err += "Số điện thoại không được để trống!";
				} else {
					try {
						Integer.parseInt(phonenumber);
					} catch (NumberFormatException e) {
						phonenumber_err += "Số điện thoại không hợp lệ!";
					}
				}

				if (street.equals("") || street == null) {
					street_err += "Tên đường không được để trống!";
				}

				if (buildingNumber.equals("") || buildingNumber == null) {
					buildingNumber_err += "Số nhà không được để trống!";
				} else {
					try {
						bdn = Integer.parseInt(buildingNumber);
					} catch (NumberFormatException e) {
						buildingNumber_err += "Số nhà không hợp lệ!";
					}
				}

				if (username_err.length() == 0 && password_err.length() == 0
						&& fullname_err.length() == 0
						&& email_err.length() == 0
						&& phonenumber_err.length() == 0
						&& buildingNumber_err.length() == 0
						&& street_err.length() == 0) {
					DAOService<City, Integer> cityService = new DAOService<City, Integer>(
							new CityDAO());
					City city = cityService.getObjectById(city_id);

					DAOService<PaymentMethod, Integer> paymentService = new DAOService<PaymentMethod, Integer>(
							new PaymentMethodDAO());
					PaymentMethod payment = paymentService
							.getObjectById(paymentId);
					Address address = new Address();
					address.setBuildingNumber(bdn);
					address.setCity(city);
					address.setStreet(street);

					User newUser = new User();
					newUser.setDatecreated(new Date());
					newUser.setEmail(email);
					newUser.setFullname(fullname);
					newUser.setGender(gender);
					newUser.setUsername(username);
					newUser.setSalt(salt);
					newUser.setPassword(pass);
					newUser.setPhoneNumber(phonenumber);
					newUser.setPaymentMethod(payment);

					try {
						RegisterService registerService = new RegisterService();
						String emailManageUser = getServletContext()
								.getInitParameter("manageuser");
						String emailAdmin = getServletContext()
								.getInitParameter("admin");
						registerService.register(newUser, address,
								emailManageUser, emailAdmin, true, new Integer(
										2));

					} catch (UsernameException e) {
						System.out.println(e.getMessage());
						username_err += e.getMessage();
						request.setAttribute("username", username);
						request.setAttribute("email", email);
						request.setAttribute("fullname", fullname);
						request.setAttribute("buildingnumber", buildingNumber);
						request.setAttribute("street", street);
						request.setAttribute("phonenumber", phonenumber);

						request.setAttribute("username_err", username_err);
						request.setAttribute("email_err", email_err);
						request.setAttribute("fullname_err", fullname_err);
						request.setAttribute("buildingnumber_err",
								buildingNumber_err);
						request.setAttribute("street_err", street_err);
						request.setAttribute("phonenumber_err", phonenumber_err);
						request.setAttribute("password_err", password_err);

						getServletContext().getRequestDispatcher("/manage/admin-addstaff.jsp").forward(
								request, response);
					}

					getServletContext().getRequestDispatcher("/Manage/Staff").forward(
							request, response);
					;
				} else {
					request.setAttribute("username", username);
					request.setAttribute("email", email);
					request.setAttribute("fullname", fullname);
					request.setAttribute("buildingnumber", buildingNumber);
					request.setAttribute("street", street);
					request.setAttribute("phonenumber", phonenumber);

					request.setAttribute("username_err", username_err);
					request.setAttribute("email_err", email_err);
					request.setAttribute("fullname_err", fullname_err);
					request.setAttribute("buildingnumber_err",
							buildingNumber_err);
					request.setAttribute("street_err", street_err);
					request.setAttribute("phonenumber_err", phonenumber_err);
					request.setAttribute("password_err", password_err);

					request.getRequestDispatcher("/manage/admin-addstaff.jsp").forward(
							request, response);
				}

			} else {
				getServletContext().getRequestDispatcher(
						"/manage/managelogin.jsp").forward(request, response);
			}
		} else {
			getServletContext().getRequestDispatcher("/manage/managelogin.jsp")
					.forward(request, response);

		}
	}

}
