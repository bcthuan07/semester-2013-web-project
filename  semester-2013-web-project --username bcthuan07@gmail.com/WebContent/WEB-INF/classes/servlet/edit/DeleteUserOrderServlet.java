package servlet.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserOrderDAO;
import model.UserOrder;
import service.DAOService;

/**
 * Servlet implementation class DeleteUserOrderServlet
 */
@WebServlet("/DeleteUserOrder")
public class DeleteUserOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUserOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userOrder = request.getParameter("userorder");
		if(userOrder!=null){
			Integer id = Integer.parseInt(userOrder);
			DAOService<UserOrder, Integer> daoService = new DAOService<>(new UserOrderDAO());
			boolean isDeleted = daoService.removeObject(id);
			if(isDeleted){
				response.sendRedirect("manage/order.jsp");
			} else {
				String error = "Kh�ng th�� xo�a ho�a ��n na�y.";
				request.setAttribute("error", error);
			}
		} else {
			response.sendRedirect("manage/order.jsp");
		}
	}

}
