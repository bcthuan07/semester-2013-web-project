package servlet.detail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductType;
import dao.ProductTypeDAO;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/Menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MenuServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void  toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

		String idproducttype = request.getParameter("producttype");
		System.out.println(idproducttype);
		if(idproducttype!=null){
			Integer id = Integer.parseInt(idproducttype);
			ProductType pt = new ProductTypeDAO().getObject(id);
			System.out.println(pt);
			request.setAttribute("producttype", pt);
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		} else {
			response.sendRedirect("menu.jsp");
		}
	}
}
