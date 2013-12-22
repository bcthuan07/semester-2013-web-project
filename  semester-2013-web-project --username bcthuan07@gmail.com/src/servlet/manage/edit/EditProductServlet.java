package servlet.manage.edit;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Product;
import model.ProductType;
import model.RoleMember;
import model.RoleMemberId;
import model.User;
import service.DAOService;
import util.ImageUtil;
import util.UploadFileUtil;
import dao.ProductDAO;
import dao.ProductTypeDAO;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/Manage/EditProduct")
@MultipartConfig
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
				.getParameter("product"));
		String description = request.getParameter("description");
		Part image = request.getPart("image");

		String name_err = "";
		String price_err = "";
		String description_err = "";
		String image_err = "";
		boolean isNumber = true;
		double price = 0;
		String locationImage = "", filename = "";

		if (name == null || name.equals("")) {
			name_err += "Tên sản phẩm không được để trống!.";
		}

		if (image == null) {
			image_err += "Ảnh sản phẩm không được để trống!";
		} else {
			filename = UploadFileUtil.getFileName(image) == null ? "temp"
					: UploadFileUtil.getFileName(image);
			locationImage = request.getServletContext().getRealPath("")
					+ File.separator + "image" + File.separator + "products"
					+ File.separator + filename;
			File upload = new File(request.getServletContext().getRealPath("")
					+ File.separator + "image" + File.separator + "products");

			if (!upload.exists()) {
				upload.mkdirs();
			}
			if (upload.exists()) {
				System.out.println(upload.getAbsolutePath());
			}
			image.write(locationImage);

		}

		if (priceString == null || priceString.equals("")) {
			price_err += "Giá sản phẩm không được để trống!";
		} else {
			try {
				price = Double.parseDouble(priceString.trim());
			} catch (NumberFormatException e) {
				isNumber = false;
			}
		}
		if (!isNumber || price <= 0.0) {
			price_err += "Giá sản phẩm không hợp lệ!";
		}

		if (description == null || description.equals("")) {
			description_err += "Mô tả sản phẩm không được để trống!";
		}

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {

			Set<RoleMember> roleSet = user.getUserRoleMembers();

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))) {

				if (name_err.length() == 0 && price_err.length() == 0
						&& description_err.length() == 0
						&& image_err.length() == 0) {
					DAOService<ProductType, Integer> ptdao = new DAOService<>(
							new ProductTypeDAO());
					DAOService<Product, Integer> pdao = new DAOService<>(
							new ProductDAO());
					ProductType pt = ptdao.getObjectById(idProductType);
					Product p = new Product();
					ImageUtil.resizeImage(300, 300, locationImage);
					p.setDescription(description);
					p.setPrice(price);
					p.setProductName(name);
					p.setProductType(pt);
					p.setImagePath("image" + File.separator + "products"
							+ File.separator + filename);
					if (pdao.updateObject(p)) {
						response.sendRedirect(request.getContextPath()
								+ "/Manage/Product");
					} else {
						String error = "Đã có lỗi xảy ra. Không thể sửa sản phẩm này!";
						request.setAttribute("error", error);
						getServletContext().getRequestDispatcher(
								"/error/commonerror.jsp").forward(request,
								response);
					}

				} else {
					request.setAttribute("name", name);
					request.setAttribute("price", priceString);
					request.setAttribute("description", description);

					request.setAttribute("image_err", image_err);
					request.setAttribute("name_err", name_err);
					request.setAttribute("price_err", price_err);
					request.setAttribute("description_err", description_err);

					getServletContext().getRequestDispatcher(
							"/manage/admin-editproduct.jsp").forward(request,
							response);
				}
			} else {
				response.sendRedirect(request.getContextPath()
						+ "/manage/managelogin.jsp");
			}
		} else {
			response.sendRedirect(request.getContextPath()
					+ "/manage/managelogin.jsp");

		}
	}

}
