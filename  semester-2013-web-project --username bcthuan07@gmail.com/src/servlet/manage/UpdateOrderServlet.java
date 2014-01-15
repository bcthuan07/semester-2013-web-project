package servlet.manage;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderStatus;
import model.RoleMember;
import model.RoleMemberId;
import model.User;
import model.UserOrder;
import service.DAOService;
import dao.OrderStatusDAO;
import dao.UserOrderDAO;

/**
 * Servlet implementation class UpdateOrderServlet
 */
@WebServlet("/Manage/UpdateOrder")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateOrderServlet() {
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
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {

			Set<RoleMember> roleSet = user.getUserRoleMembers();

			if (roleSet.contains(new RoleMember(new RoleMemberId(user
					.getUserId(), 1)))
					|| roleSet.contains(new RoleMember(new RoleMemberId(user
							.getUserId(), 2)))) {
				DAOService<UserOrder, Integer> service = new DAOService<UserOrder, Integer>(
						new UserOrderDAO());
				DAOService<OrderStatus, Integer> service2 = new DAOService<>(
						new OrderStatusDAO());

				Integer idStatus = Integer.parseInt(request
						.getParameter("idStatus"));
				Integer idOrder = Integer.parseInt(request
						.getParameter("idOrder"));
				UserOrder order = service.getObjectById(idOrder);
				order.setOrderStatus(service2.getObjectById(idStatus));
				boolean isUpdate = service.updateObject(order);
				if (isUpdate) {
					
						getServletContext().getRequestDispatcher(
								"/Manage/Order").forward(request,
								response);
					
				} else {
					String error = "Đã có lỗi xảy ra, không thể cập nhật hóa đơn này.";
					request.setAttribute("error", error);
					getServletContext().getRequestDispatcher(
							"/error/commonerror.jsp")
							.forward(request, response);

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
