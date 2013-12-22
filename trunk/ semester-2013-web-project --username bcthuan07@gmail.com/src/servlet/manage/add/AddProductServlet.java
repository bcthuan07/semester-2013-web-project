package servlet.manage.add;

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
 * Servlet implementation class AddProduct
 */
@WebServlet("/Manage/AddProduct")
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

		//Các field từ trang jsp
		String idProducttype = request.getParameter("producttype");
		String name = request.getParameter("productname");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		//
		Part image = request.getPart("image");
		
		//Lỗi
		String name_err = "";
		String description_err = "";
		String price_err = "";
		Double priceDouble = 0.0;
		String image_err = "";
		String locationImage = "";
		
		//Tên ảnh sản phẩm
		String filename = UploadFileUtil.getFileName(image) == null ? "temp"
				: UploadFileUtil.getFileName(image);
		
		//Kiểm tra các thuộc tính của sản phẩm có được tải lên hay không
		if (name == null || name.equals("")) {
			name_err += "Tên sản phẩm không được để trống!";
		}
		if (description == null || description.equals("")) {
			description_err += "Mô tả sản phẩm không được để trống";
		}
		

		if (price == null || price.equals("")) {
			price_err += "Giá sản phẩm không được để trống!";
		}

		try {
			priceDouble = Double.parseDouble(price);
		} catch (NumberFormatException e) {
			price_err += "Giá sản phẩm không hợp lệ!";
		}

		//Kiểm tra ảnh sản phẩm có được tải lên hay không
		if (filename.equals("")) {
			image_err += "Ảnh sản phẩm không được để trống!";
		}
		

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {

			Set<RoleMember> roleSet = user.getUserRoleMembers();

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))) {
				if (image_err.length() == 0 && name_err.length() == 0
						&& description_err.length() == 0
						&& price_err.length() == 0) {
					Integer idProductType = Integer.parseInt(idProducttype);
					DAOService<Product, Integer> pdService = new DAOService<>(
							new ProductDAO());
					DAOService<ProductType, Integer> pdtService = new DAOService<>(
							new ProductTypeDAO());
					ProductType pt = pdtService.getObjectById(idProductType);
					Product p = new Product();
					
					//Tải ảnh sản phẩm lên server, đường dẫn: "image/products/"
					locationImage = request.getServletContext().getRealPath("")
							+ File.separator + "image" + File.separator + "products"
							+ File.separator + filename;
					File upload = new File(request.getServletContext().getRealPath("")
							+ File.separator + "image" + File.separator + "products");
//					System.out.println(locationImage);
					if (!upload.exists()) {
						upload.mkdirs();
					}
					image.write(locationImage);
					ImageUtil.resizeImage(300, 300, locationImage);
					
					p.setDescription(description);
					p.setImagePath("image" + File.separator + "products"
							+ File.separator + filename);
					p.setProductName(name);
					p.setProductType(pt);
					p.setPrice(priceDouble);
					boolean isAdded = pdService.addObject(p);
					if (isAdded) {
						response.sendRedirect("Menu");
					} else {
						String error = "Đã có lỗi xảy ra, không thể thêm được sản phẩm này!";
						request.setAttribute("error", error);
						getServletContext().getRequestDispatcher(
								"/error/commonerror.jsp").forward(request,
								response);
					}
				} else {
					request.setAttribute("name_err", name_err);
					request.setAttribute("description_err", description_err);
					request.setAttribute("price_err", price_err);
					request.setAttribute("image_err", image_err);

					request.setAttribute("name", name);
					request.setAttribute("description", description);
					request.setAttribute("price", price);
					getServletContext().getRequestDispatcher(
							"/manage/admin-addproduct.jsp").forward(request,
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
