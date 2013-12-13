package servlet.manage.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.ProductType;
import model.User;
import service.DAOService;
import dao.ProductDAO;
import dao.ProductTypeDAO;

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

		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

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
			name_err += "Vui lòng nhập tên sản phẩm.";
		}

		if (priceString == null || priceString.equals("")) {
			price_err += "Vui lòng nhập giá sản phẩm.";
		} else {
			try {
				price = Double.parseDouble(priceString.trim());
			} catch (NumberFormatException e) {
				isNumber = false;
			}
		}
		if (!isNumber) {
			price_err += "Vui lòng nhập lại giá sản phẩm.";
		}

		if (description == null || description.equals("")) {
			description_err += "Vui lòng nhập mô tả sản phẩm.";
		}

		HttpSession session = request.getSession();
		User staff = (User) session.getAttribute("user");
		boolean permission = false;
		if (staff != null) {
			permission = staff.getPermission();
		}

		if (permission) {

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
				if (pdao.updateObject(p)) {
					response.sendRedirect("manage/product.jsp");
				} else {
					String error = "Không thể thêm sản phẩm này.";
					request.setAttribute("error", error);
					request.getRequestDispatcher("error/commonerror.jsp").forward(request,response);
				}

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
		} else {
			String error = "Bạn không có quyền truy cập trang này.";
			request.setAttribute("error", error);
			request.getRequestDispatcher("error/commonerror.jsp").forward(
					request, response);
		}
	}

}
