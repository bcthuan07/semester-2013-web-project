package servlet.add;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductType;
import model.User;
import service.DAOService;
import dao.ProductTypeDAO;

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
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

		
		String description = request.getParameter("description");
		String description_err = "";
		
		HttpSession session = request.getSession();
		User staff = (User) session.getAttribute("user");
		boolean permission = false;
		if(staff!=null){
			permission = staff.getPermission();
		}
		
		if(description.equals("") || description==null){
			description_err+="Trường này không được để trống.";
		} 
		
		if(permission){
			if(description_err.length() == 0){
				DAOService<ProductType, Integer> daoService = new DAOService<>(new ProductTypeDAO());
				List<ProductType> list = daoService.listObject();
				boolean exists = false;
				for(ProductType pt : list){
					if(pt.getDescription().equals(description))
						exists=true;
				}
				if(exists){
					description_err+="Loại sản phẩm này đã có.";
					request.setAttribute("error", description_err);
					request.getRequestDispatcher("manage/producttype.jsp").forward(request, response);
				}else{
					ProductType pt = new ProductType();
					pt.setDescription(description);
					daoService.addObject(pt);
					response.sendRedirect("manage/producttype.jsp");
				}
			} else {
				request.setAttribute("error", description_err);
				request.getRequestDispatcher("/manage/producttype.jsp").forward(request, response);
			}
		} else {
			String error = "Bạn không có quyền truy cập trang này.";
			request.setAttribute("error", error);
			request.getRequestDispatcher("error/commonerror.jsp").forward(request, response);
		}
		
	}

}
