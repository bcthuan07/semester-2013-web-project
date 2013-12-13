package servlet.manage.add;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

		// response.sendRedirect("detail/productdetail.jsp");
		String idProducttype = request.getParameter("producttype");
		String name = request.getParameter("productname");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		// Part part = request.getPart("file");
		String name_err = "";
		String description_err = "";
		String file_err = "";
		String price_err = "";
		String quantity_err = "";
		Double priceDouble = 0.0;
		Integer quantityNumber = 0;
		if (name == null || name.equals("")) {
			name_err += "Vui lòng nhập tên sản phẩm!";
		}
		if (description == null || description.equals("")) {
			description_err += "Vui lòng nhập mô tả sản phẩm!";
		}
		// if (part == null) {
		// file_err += "Vui lòng chọn ảnh đại diện!";
		// }
		if (price == null || price.equals("")) {
			price_err += "Vui lòng nhập giá sản phẩm!";
		}

		try {
			priceDouble = Double.parseDouble(price);
		} catch (NumberFormatException e) {
			price_err += "Vui lòng nhập lại giá sản phẩm!";
		}
		
		if(quantity == null || quantity.equals("")){
			quantity_err += "Vui lòng nhập số lượng sản phẩm còn trong cửa hàng";
		} else {
			try {
				quantityNumber = Integer.parseInt(quantity);
			} catch (NumberFormatException e) {
				quantity_err += "Vui lòng nhập lại số lượng sản phẩm.";
			}
		}

		HttpSession session = request.getSession();
		User staff = (User) session.getAttribute("user");
		boolean permission = false;
		if (staff != null) {
			permission = staff.getPermission();
		}

		if (permission) {
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
				p.setQuantity(quantityNumber);
				boolean isAdded = pdService.addObject(p);
				if (isAdded) {
					response.sendRedirect("Menu");
				} else {
					String error = "Không thể thêm sản phẩm.";
					request.setAttribute("error", error);
					request.getRequestDispatcher("error/commonerror.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("quantity_err", quantity_err);
				request.setAttribute("name_err", name_err);
				request.setAttribute("description_err", description_err);
				request.setAttribute("price_err", price_err);
				request.setAttribute("file_err", file_err);

				request.setAttribute("quantity", quantity);
				request.setAttribute("name", name);
				request.setAttribute("description", description);
				request.setAttribute("price", price);
				request.getRequestDispatcher("/manage/addproduct.jsp").forward(
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
