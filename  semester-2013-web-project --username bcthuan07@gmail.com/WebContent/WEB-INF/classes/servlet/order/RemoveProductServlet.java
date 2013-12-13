package servlet.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String ind = request.getParameter("index");
		if(ind==null || ind.equals("")){
			response.sendRedirect("order/cartview.jsp");
		} else {
			HttpSession session = request.getSession();
			List<Product> list = (List<Product>) session.getAttribute("listproduct");
			int index = 0;
			try {
				index = Integer.parseInt(ind);
			} catch (Exception e) {
				response.sendRedirect("order/cartview.jsp");
			}
			list.remove(index);
			session.setAttribute("listproduct", list);
			response.sendRedirect("order/cartview.jsp");
		}
	}

}
