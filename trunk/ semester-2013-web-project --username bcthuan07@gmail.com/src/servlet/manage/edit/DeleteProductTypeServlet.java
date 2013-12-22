package servlet.manage.edit;

import java.io.IOException;
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
 * Servlet implementation class DeleteProductTypeServlet
 */
@WebServlet("/Manage/DeleteProductType")
public class DeleteProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProductTypeServlet() {
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
		String pt = request.getParameter("pt");

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		if (user != null) {

			Set<RoleMember> roleSet = user.getUserRoleMembers();

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))) {
				DAOService<ProductType, Integer> daoService = new DAOService<>(
						new ProductTypeDAO());
				Integer id = Integer.parseInt(pt);
				boolean isDeleted = daoService.removeObject(id);
				if (isDeleted) {
					response.sendRedirect(request.getContextPath()
							+ "/Manage/ProductType");
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
