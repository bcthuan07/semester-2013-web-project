package servlet.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import service.DAOService;
import model.Product;

/**
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet("/RemoveProduct")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	toDo(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product = request.getParameter("product");
		if(product==null || product.equals("")){
			response.sendRedirect("order/cartview.jsp");
		} else {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			List<Product> list = (List<Product>) session.getAttribute("listproduct");
			int id = 0;
			try {
				id = Integer.parseInt(product);
			} catch (Exception e) {
				response.sendRedirect("order/cartview.jsp");
			}
			DAOService<Product, Integer> service = new DAOService<>(new ProductDAO());
			Product p = service.getObjectById(id);
			list.remove(p);
			session.setAttribute("listproduct", list);
			response.sendRedirect("order/cartview.jsp");
		}
	}

}
