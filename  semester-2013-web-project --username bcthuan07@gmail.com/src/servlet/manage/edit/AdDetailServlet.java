package servlet.manage.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdDAO;
import model.Ads;
import service.DAOService;

/**
 * Servlet implementation class AdDetailServlet
 */
@WebServlet("/Manage/AdDetail")
public class AdDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		String ad = request.getParameter("ad");
		Integer id = 0;
		boolean isNumber = true;
		try {
			id = Integer.parseInt(ad);
		} catch (Exception e) {
			isNumber=false;
		}
		
		if(isNumber){
			DAOService<Ads, Integer> service = new DAOService<>(new AdDAO());
			Ads a = service.getObjectById(id);
			if(a!=null){
				request.setAttribute("ads", a);
				getServletContext().getRequestDispatcher("/manage/admin-ad-detail.jsp").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/Manage/Ad").forward(request, response);
			}
		} else {
			getServletContext().getRequestDispatcher("/Manage/Ad").forward(request, response);
		}
	}

}
