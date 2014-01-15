package servlet.order;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Address;
import model.City;
import model.PaymentMethod;
import model.Product;
import model.User;
import service.DAOService;
import service.OrderService;
import service.RegisterService;
import util.ValidateData;
import dao.CityDAO;
import dao.PaymentMethodDAO;
import dao.UserDAO;
import exception.UsernameException;

/**
 * Servlet implementation class ValidateOrderServlet
 */
@WebServlet("/ValidateOrder")
public class ValidateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidateOrderServlet() {
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
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) session
				.getAttribute("listproduct");

		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		String street = request.getParameter("street");
		String buildingNumber = request.getParameter("buildingnumber");
		String cityString = request.getParameter("city");
		String fullname = request.getParameter("fullname");
		String paymentmethod = request.getParameter("payment");

		if (user != null) {
			fullname = user.getUsername();
			email = user.getEmail();
		}
		String email_err = "";
		String phonenumber_err = "";
		String street_err = "";
		String buildingNumber_err = "";
		String fullname_err = "";

		String emailManageUser = getServletContext().getInitParameter(
				"manageuser");

		int bdn = 0;
		Integer cityId = 0, paymentId = 0;
		;
		try {
			cityId = Integer.parseInt(cityString);
			paymentId = Integer.parseInt(paymentmethod);
		} catch (Exception e) {
		}
		if (fullname == null || fullname.equals("")) {
			fullname_err += "Tên không được để trống!";
		}

		if (email == null || email.equals("")) {
			email_err += "Email không được để trống!";
		} else {
			email_err += ValidateData.isEmail(email) ? ""
					: "Email không hợp lệ!";
		}

		if (phonenumber == null || phonenumber.equals("")) {
			phonenumber_err += "Số đt không được để trống!";
		} else {
			try {
				Integer.parseInt(phonenumber);
			} catch (NumberFormatException e) {
				phonenumber_err += "Số điện thoại không hợp lệ!";
			}
		}

		if (street == null || street.equals("")) {
			street_err += "Đường không được để trống!";
		}

		if (buildingNumber == null || buildingNumber.equals("")) {
			buildingNumber_err += "Số nhà không được để trống!";
		} else {
			try {
				bdn = Integer.parseInt(buildingNumber);
			} catch (NumberFormatException e) {
				buildingNumber_err += "Số nhà không hợp lệ!";
			}
		}

		if (email_err.length() == 0 && phonenumber_err.length() == 0
				&& street_err.length() == 0 && buildingNumber_err.length() == 0
				&& fullname_err.length() == 0) {
			DAOService<City, Integer> cityService = new DAOService<>(
					new CityDAO());
			City city = cityService.getObjectById(cityId);
			DAOService<PaymentMethod, Integer> paymentMethodService = new DAOService<PaymentMethod, Integer>(
					new PaymentMethodDAO());
			PaymentMethod paymentMethod = paymentMethodService
					.getObjectById(paymentId);

			Address address = new Address();
			address.setBuildingNumber(bdn);
			address.setCity(city);
			address.setStreet(street);
			if (user == null) {
				user = new User();
				user.setEmail(email);
				user.setDatecreated(new Date());
				user.setFullname(fullname);
				user.setPhoneNumber(phonenumber);
				user.setPaymentMethod(paymentMethod);
				RegisterService rs = new RegisterService();
				try {
					rs.register(user, address, "", "", false, new Integer(3));
				} catch (UsernameException e) {
				}
			} else {
				DAOService<User, Integer> userDaoService = new DAOService<User, Integer>(
						new UserDAO());
				user.setPhoneNumber(phonenumber);
				userDaoService.updateObject(user);
			}
			OrderService orderService = new OrderService();

			if (orderService.order(listProduct, user, new Date(),
					emailManageUser, email, address)) {
				listProduct.clear();
				session.setAttribute("listproduct", listProduct);

				String message = "Cảm ơn " + user.getFullname()
						+ " đã mua hàng ở đây!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("thanks.jsp").forward(request,
						response);
			} else {
				String error = "Rất tiếc, không thể thực hiện được giao dịch!";
				request.setAttribute("error", error);
				request.getRequestDispatcher("error/commonerror.jsp").forward(
						request, response);
			}

		} else {
			request.setAttribute("fullname_err", fullname_err);
			request.setAttribute("email_err", email_err);
			request.setAttribute("phonenumber_err", phonenumber_err);
			request.setAttribute("street_err", street_err);
			request.setAttribute("buildingnumber_err", buildingNumber_err);

			request.setAttribute("fullname", fullname);
			request.setAttribute("email", email);
			request.setAttribute("phonenumber", phonenumber);
			request.setAttribute("street", street);
			request.setAttribute("buildingNumber", buildingNumber);
			request.getRequestDispatcher("order/validatecart.jsp").forward(
					request, response);
		}
	}
}
