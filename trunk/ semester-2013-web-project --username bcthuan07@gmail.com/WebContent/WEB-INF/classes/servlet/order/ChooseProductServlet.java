package servlet.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.DAOService;
import dao.ProductDAO;

/**
 * Servlet implementation class ChooseProductServlet
 */
@WebServlet("/ChooseProduct")
public class ChooseProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChooseProductServlet() {
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

		String idProduct = request.getParameter("id");
		String number = request.getParameter("number");
		String number_err = "";
		boolean isNumber = true;
		int no = 1;
		try {
			no = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			isNumber = false;
		}
		DAOService<Product, Integer> daoService = new DAOService<>(
				new ProductDAO());

		if (!isNumber) {
			number_err += "Xin hãy nhập số lượng sản phẩm.";
			request.setAttribute("number_err", number_err);
			request.setAttribute("product",
					daoService.getObjectById(Integer.parseInt(idProduct)));
			request.getRequestDispatcher("detail/productdetail.jsp").forward(
					request, response);
		} else {
			Product p = daoService.getObjectById(Integer.parseInt(idProduct));
			int left = p.getQuantity();
			if (no <= left) {
				@SuppressWarnings("unchecked")
				List<Product> listProduct = (List<Product>) request
						.getSession().getAttribute("listproduct");
				if (listProduct == null) {
					listProduct = new ArrayList<>();
				}

				for (int i = 0; i < no; i++) {
					listProduct.add(daoService.getObjectById(Integer
							.parseInt(idProduct)));
				}
				p.setQuantity(left-no);
				daoService.updateObject(p);
				request.getSession().setAttribute("listproduct", listProduct);
				System.out.println("---List Product----");
				System.out.println(listProduct);
				response.sendRedirect("Menu");
			} else {
				number_err += "Số lượng sản phẩm không đủ cho yêu cầu của bạn.";
				request.setAttribute("number_err", number_err);
				request.setAttribute("product", p);
				request.getRequestDispatcher("detail/productdetail.jsp").forward(request, response);

			}
		}
	}

}
