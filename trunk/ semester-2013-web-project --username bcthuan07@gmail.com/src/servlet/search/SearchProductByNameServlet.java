package servlet.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Servlet implementation class SearchProductByNameServlet
 */
@WebServlet("/SearchProductByName")
public class SearchProductByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchProductByNameServlet() {
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
		String input = request.getParameter("search") == null ? "" : request
				.getParameter("search");
		System.out.println(request.getParameter("search"));
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Product where productName like :name ");
		query.setString("name", "%"+input+"%");
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println(list);
		request.setAttribute("listproduct", list);
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

}
