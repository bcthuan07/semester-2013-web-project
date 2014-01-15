package servlet.manage.add;

import java.io.IOException;
import java.text.Collator;
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
					System.out.println(description);
					Collator collator = Collator.getInstance();
					for (ProductType pt : list) {
						boolean equal = collator.compare(pt.getDescription(), description)==0? true: false;
						if (equal)
							exists = true;
					}
					
					if (exists) {
						description_err += "Loại sản phẩm này đã có.";
						request.setAttribute("error", description_err);
						getServletContext().getRequestDispatcher(
								"/Manage/ProductType").forward(request,
								response);
					} else {
						ProductType productType = new ProductType(description);
						daoService.addObject(productType);
						response.sendRedirect(request.getContextPath()
								+ "/Manage/ProductType");
					}
				} else {
					request.setAttribute("error", description_err);
					getServletContext().getRequestDispatcher(
							"/Manage/ProductType").forward(request, response);
				}
			} else {
				getServletContext().getRequestDispatcher(
						"/manage/managelogin.jsp").forward(request, response);
			}
		} else {
			getServletContext().getRequestDispatcher("/manage/managelogin.jsp")
					.forward(request, response);
		}
	}
}
