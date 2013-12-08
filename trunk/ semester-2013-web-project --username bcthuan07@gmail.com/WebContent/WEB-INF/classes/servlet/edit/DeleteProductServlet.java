package servlet.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.DAOService;
import dao.ProductDAO;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		toDo(request, response);
	}

	protected void toDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProduct = request.getParameter("idproduct");
		if(idProduct!=null){
			DAOService<Product, Integer> daoService = new DAOService<>(new ProductDAO());
			Integer id = Integer.parseInt(idProduct);
			boolean isDeleted = daoService.removeObject(id);
			if(isDeleted){
				response.sendRedirect("manage/product.jsp");
			} else {
				String error = "Không thêÒ xoìa saÒn phâÒm naÌy.";
				request.setAttribute("error", error);
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect("manage/product.jsp");
		}
	}

}
