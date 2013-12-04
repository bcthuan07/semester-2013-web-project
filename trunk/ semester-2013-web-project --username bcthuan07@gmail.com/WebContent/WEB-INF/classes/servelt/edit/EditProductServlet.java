package servelt.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dao.ProductTypeDAO;
import model.Product;
import model.ProductType;
import service.DAOService;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditProductServlet() {
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
		String name = request.getParameter("name");
		String priceString = request.getParameter("price");
		Integer idProductType = Integer.parseInt(request
				.getParameter("idproducttype"));
		String description = request.getParameter("description");

		String name_err = "";
		String price_err = "";
		String description_err = "";
		boolean isNumber = true;
		double price = 0;

		if (name == null || name.equals("")) {
			name_err += "Vui loÃng nh‚Úp tÍn sa“n ph‚“m.";
		}

		if (priceString == null || priceString.equals("")) {
			price_err += "Vui loÃng nh‚Úp giaÏ sa“n ph‚“m.";
		} else {
			try {
				price = Double.parseDouble(priceString.trim());
			} catch (NumberFormatException e) {
				isNumber = false;
			}
		}
		if (!isNumber) {
			price_err += "Vui loÃng nh‚Úp laÚi giaÏ sa“n ph‚“m.";
		}

		if (description == null || description.equals("")) {
			description_err += "Vui loÃng nh‚Úp mÙ ta“ sa“n ph‚“m.";
		}

		if (name_err.length() == 0 && price_err.length() == 0
				&& description_err.length() == 0) {
			DAOService<ProductType, Integer> ptdao = new DAOService<>(
					new ProductTypeDAO());
			DAOService<Product, Integer> pdao = new DAOService<>(
					new ProductDAO());
			ProductType pt = ptdao.getObjectById(idProductType);
			Product p = new Product();
			p.setDescription(description);
			p.setPrice(price);
			p.setProductName(name);
			p.setProductType(pt);
			pdao.updateObject(p);
			response.sendRedirect("manage/product.jsp");

		} else {
			request.setAttribute("name", name);
			request.setAttribute("price", priceString);
			request.setAttribute("description", description);

			request.setAttribute("name_err", name_err);
			request.setAttribute("price_err", price_err);
			request.setAttribute("description_err", description_err);

			request.getRequestDispatcher("manage/editproduct.jsp").forward(
					request, response);
		}

	}

}
