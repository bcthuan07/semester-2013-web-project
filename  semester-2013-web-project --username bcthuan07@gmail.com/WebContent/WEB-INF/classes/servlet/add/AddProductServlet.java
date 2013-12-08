package servlet.add;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Product;
import model.ProductType;
import service.DAOService;
import dao.ProductDAO;
import dao.ProductTypeDAO;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddProductServlet() {
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
//		response.sendRedirect("detail/productdetail.jsp");
		String idProducttype = request.getParameter("producttype");
		String name = request.getParameter("productname");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
//		Part part = request.getPart("file");
		String name_err = "";
		String description_err = "";
		String file_err = "";
		String price_err = "";
		Double priceDouble = 0.0;
		if (name == null || name.equals("")) {
			name_err += "Vui loÃng nh‚Úp tÍn sa“n ph‚“m!";
		}
		if (description == null || description.equals("")) {
			description_err += "Vui loÃng nh‚Úp mÙ ta“ sa“n ph‚“m!";
		}
//		if (part == null) {
//			file_err += "Vui loÃng choÚn a“nh aÚi diÍÚn!";
//		}
		if (price == null || price.equals("")) {
			price_err += "Vui loÃng nh‚Úp giaÏ sa“n ph‚“m!";
		}

		try {
			priceDouble = Double.parseDouble(price);
		} catch (NumberFormatException e) {
			price_err+="Vui loÃng nh‚Úp laÚi giaÏ sa“n ph‚“m!";
		}

		if (file_err.length() == 0 && name_err.length() == 0
				&& description_err.length() == 0 && price_err.length() == 0) {
			Integer idProductType = Integer.parseInt(idProducttype);
			DAOService<Product, Integer> pdService = new DAOService<>(
					new ProductDAO());
			DAOService<ProductType, Integer> pdtService = new DAOService<>(
					new ProductTypeDAO());
			ProductType pt = pdtService.getObjectById(idProductType);
			Product p = new Product();
			p.setDescription(description);
			p.setImagePath("");
			p.setProductName(name);
			p.setProductType(pt);
			p.setPrice(priceDouble);
			pdService.addObject(p);
			response.sendRedirect("Menu");
		} else {
			request.setAttribute("name_err", name_err);
			request.setAttribute("description_err", description_err);
			request.setAttribute("price_err", price_err);
			request.setAttribute("file_err",file_err);

			request.setAttribute("name", name);
			request.setAttribute("description", description);
			request.setAttribute("price", price);
			request.getRequestDispatcher("/manage/addproduct.jsp").forward(request, response);
		}
	}

}
