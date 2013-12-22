package servlet.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ads;
import service.DAOService;
import dao.AdDAO;

/**
 * Servlet implementation class ManageAdServlet
 */
@WebServlet("/Manage/Ad")
public class ManageAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageAdServlet() {
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
		
		DAOService<Ads, Integer> service = new DAOService<>(new AdDAO());
		List<Ads> list = service.listObject();
		request.setAttribute("listads",list);
		getServletContext().getRequestDispatcher("/manage/admin-ad.jsp").forward(request, response);
	}

}
