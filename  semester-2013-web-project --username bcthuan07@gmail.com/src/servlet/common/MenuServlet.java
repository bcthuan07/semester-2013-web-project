package servlet.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductType;
import service.DAOService;
import dao.ProductDAO;
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

		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

		String idproducttype = request.getParameter("producttype");
		String indexString = request.getParameter("index") == null ? "1"
				: request.getParameter("index");
		System.out.println("index = " + indexString);
		System.out.println("producttype = " + idproducttype);
		int total = 0;
		int index = Integer.parseInt(indexString);

		System.out.println(idproducttype);
		List<Product> listProduct = new ArrayList<>();
		List<ProductType> listProductTypes = new DAOService<ProductType, Integer>(
				new ProductTypeDAO()).listObject();
		if (idproducttype != null && !idproducttype.equals("")) {
			Integer id = Integer.parseInt(idproducttype);
			ProductType pt = new DAOService<>(new ProductTypeDAO())
					.getObjectById(id);
			System.out.println(pt);
			List<Product> products = new ArrayList<Product>(pt.getProducts());
			total = products.size();
			int count = total % 6 > 0 ? (total / 6) + 1 : total / 6;
			int start = (index - 1) * 6;
			int end = (total - start) < 6 ? total : start + 3;
			for (int i = start; i < end; i++) {
				listProduct.add(products.get(i));

			}
			request.setAttribute("index", index);
			request.setAttribute("count", count);
			request.setAttribute("listproducttype", listProductTypes);
			request.setAttribute("producttype", pt);
			request.setAttribute("listproduct", listProduct);
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		} else {
			List<Product> products = new DAOService<>(new ProductDAO())
					.listObject();
			total = products.size();
			int count = total % 6 > 0 ? (total / 6) + 1 : total / 6;
			int start = (index - 1) * 6;
			int end = (total - start) < 6 ? total : start + 3;
			for (int i = start; i < end; i++) {
				listProduct.add(products.get(i));
			}
			request.setAttribute("index", index);
			request.setAttribute("count", count);
			request.setAttribute("listproducttype", listProductTypes);
			request.setAttribute("listproduct", listProduct);
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		}

	}
}
