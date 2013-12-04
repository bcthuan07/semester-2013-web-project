package servlet.add;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductTypeDAO;
import model.ProductType;
import service.DAOService;

/**
 * Servlet implementation class AddProductTypeServlet
 */
@WebServlet("/AddProductType")
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
		String description = request.getParameter("description");
		String description_err = "";
		if(description.equals("") || description==null){
			description_err+="TrýõÌng naÌy không ðýõòc ðêÒ trôìng.";
		} 
		
		if(description_err.length() == 0){
			DAOService<ProductType, Integer> daoService = new DAOService<>(new ProductTypeDAO());
			ProductType pt = new ProductType();
			pt.setDescription(description);
			daoService.addObject(pt);
		} else {
			request.setAttribute("description_err", description_err);
			request.getRequestDispatcher("manage/producttype.jsp").forward(request, response);
		}
		
	}

}
