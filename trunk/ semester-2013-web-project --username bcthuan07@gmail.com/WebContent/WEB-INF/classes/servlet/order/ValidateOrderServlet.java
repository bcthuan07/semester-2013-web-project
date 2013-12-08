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
import model.Product;
import model.User;
import service.OrderService;
import util.ValidateData;

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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) session
				.getAttribute("listproduct");

		String email = request.getParameter("email");
		String phonenumber = request.getParameter("phonenumber");
		String street = request.getParameter("street");
		String buildingNumber = request.getParameter("buildingNumber");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String fullname = request.getParameter("fullname");

		String email_err = "";
		String phonenumber_err = "";
		String street_err = "";
		String buildingNumber_err = "";
		String city_err = "";
		String zipcode_err = "";
		String fullname_err = "";

		int bdn = 0;
		int zc = 0;
		int phone = 0;
		String common_err = "TrýõÌng naÌy không ðýõòc ðêÒ trôìng.";
		if (fullname.equals("") || fullname == null) {
			fullname_err += common_err;
			fullname="";
		}

		if (email.equals("") || email == null) {
			email_err += common_err;
			email="";
		} else {
			email_err += ValidateData.isEmail(email) ? ""
					: "Email không hõòp lêò.";
		}

		if (phonenumber.equals("") || phonenumber == null) {
			phonenumber_err += common_err;
			phonenumber="";
		} else {
			try {
				phone = Integer.parseInt(phonenumber);
			} catch (NumberFormatException e) {
				phonenumber_err += "Sôì ðiêòn thoaòi không hõòp lêò.";
			}
		}

		if (street.equals("") || street == null) {
			street_err += common_err;
			street="";
		}

		if (buildingNumber.equals("") || buildingNumber == null) {
			buildingNumber_err += common_err;
			buildingNumber="";
		} else {
			try {
				bdn = Integer.parseInt(buildingNumber);
			} catch (NumberFormatException e) {
				buildingNumber_err += "Sôì nhaÌ không hõòp lêò.";
			}
		}

		if (zipcode.equals("") || zipcode == null) {
			zipcode_err += common_err;
			zipcode="";
		} else {
			try {
				zc = Integer.parseInt(zipcode);
			} catch (NumberFormatException e) {
				zipcode_err += "MaÞ Zipcode không hõòp lêò.";
			}
		}

		if (city.equals("") || city == null) {
			city_err += common_err;
			city="";
		}

		if (listProduct == null) {
			response.sendRedirect("home.jsp");
		} else if (listProduct.size() == 0) {
			response.sendRedirect("menu.jsp");
		} else if (user == null) {
			if (email_err.length() == 0 && phonenumber_err.length() == 0
					&& street_err.length() == 0
					&& buildingNumber_err.length() == 0
					&& city_err.length() == 0 && zipcode_err.length() == 0
					&& fullname_err.length() == 0) {
				Address address = new Address();
				address.setBuildingNumber(bdn);
				address.setCity(city);
				address.setStreet(street);
				address.setZipCode(zc);

				User newUser = new User();
				newUser.setEmail(email);
				newUser.setDatecreated(new Date());
				newUser.setFullname(fullname);
				newUser.setPermission(false);
				newUser.setPhoneNumber(phone+"");
				OrderService orderService= new OrderService();
				if(orderService.order(listProduct, newUser, address, new Date())){
					response.sendRedirect("thanks.jsp");
				} else {
					response.sendError(200);
				}
				
			} else {
				request.setAttribute("fullname_err", fullname_err);
				request.setAttribute("email_err", email_err);
				request.setAttribute("phoneumber_err", phonenumber_err);
				request.setAttribute("street_err", street_err);
				request.setAttribute("buildingnumber_err", buildingNumber_err);
				request.setAttribute("city_err", city_err);
				request.setAttribute("zipcode_err", zipcode_err);
				
				request.setAttribute("fullname", fullname);
				request.setAttribute("email", email);
				request.setAttribute("phonenumber", phonenumber);
				request.setAttribute("street", street);
				request.setAttribute("buildingNumber", buildingNumber);
				request.setAttribute("city", city);
				request.setAttribute("zipcode", zipcode);
				request.getRequestDispatcher("").forward(request, response);
			}
		} else {
			OrderService orderService = new OrderService();
			if (orderService.order(listProduct, user, new Date())) {
				response.sendRedirect("thanks.jsp");
			} else {
				response.sendError(200);
			}
		}
	}

}
