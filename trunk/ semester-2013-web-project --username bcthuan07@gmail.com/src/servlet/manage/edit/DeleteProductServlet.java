package servlet.manage.edit;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.RoleMember;
import model.RoleMemberId;
import model.User;
import service.DAOService;
import dao.ProductDAO;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/Manage/DeleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProductServlet() {
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

		String idProduct = request.getParameter("product");
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		if (user != null) {

			Set<RoleMember> roleSet = user.getUserRoleMembers();

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))) {
				DAOService<Product, Integer> daoService = new DAOService<>(
						new ProductDAO());
				Integer id = Integer.parseInt(idProduct);
				boolean isDeleted = daoService.removeObject(id);
				if (isDeleted) {
					response.sendRedirect(request.getContextPath()
							+ "/Manage/Product");
				} else {
					String error = "Đã có lỗi xảy ra. Không thể xóa được loại sản phẩm!";
					request.setAttribute("error", error);
					getServletContext().getRequestDispatcher(
							"/error/commonerror.jsp")
							.forward(request, response);
				}
			} else {
				response.sendRedirect("manage/managelogin.jsp");
			}
		} else {
			response.sendRedirect("manage/managelogin.jsp");

		}
	}

}
