package servlet.manage.add;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductType;
import model.RoleMember;
import model.RoleMemberId;
import model.User;
import service.DAOService;
import dao.ProductTypeDAO;

/**
 * Servlet implementation class AddProductTypeServlet
 */
@WebServlet("/Manage/AddProductType")
public class AddProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddProductTypeServlet() {
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

		String description = request.getParameter("description");
		String description_err = "";
		if (description.equals("") || description == null) {
			description_err += "Tên loại mặt hàng không được để trống!";
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {

			Set<RoleMember> roleSet = user.getUserRoleMembers();

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))) {
				if (description_err.length() == 0) {
					DAOService<ProductType, Integer> daoService = new DAOService<>(
							new ProductTypeDAO());
					List<ProductType> list = daoService.listObject();
					boolean exists = false;
					for (ProductType pt : list) {
						if (pt.getDescription().equals(description))
							exists = true;
					}
					if (exists) {
						description_err += "Loại sản phẩm này đã có.";
						request.setAttribute("error", description_err);
						getServletContext().getRequestDispatcher(
								"/manage/admin-producttype.jsp").forward(
								request, response);
					} else {
						ProductType pt = new ProductType();
						pt.setDescription(description);
						daoService.addObject(pt);
						response.sendRedirect(request.getContextPath()
								+ "/manage/admin-producttype.jsp");
					}
				} else {
					request.setAttribute("error", description_err);
					getServletContext().getRequestDispatcher(
							"/manage/admin-producttype.jsp").forward(request,
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
