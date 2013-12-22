package servlet.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import util.ImageUtil;
import util.UploadFileUtil;

/**
 * Servlet implementation class ManageImageServlet
 */
@WebServlet("/Manage/EditImage")
public class ManageEditImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageEditImageServlet() {
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

		Part image = request.getPart("image");
		String index =request.getParameter("index");
		int i = Integer.parseInt(index);
		String type = request.getParameter("type");
		String error = "";
		String origin =request.getParameter("origin");
		String imageName = UploadFileUtil.getFileName(image);
		if (imageName == null || imageName.length() == 0) {
			error += "Hình ảnh không được để trống";
		}

		if (error.length() == 0) {
			image.write(request.getContextPath()+"/"+origin);
			
			getServletContext().getRequestDispatcher("/manage/admin-image.jsp").forward(request, response);
		} else {
			String home1 = "";
			String error1 = i==1? "Hình ảnh không được để trống!":"";
			String error2 = i==2? "Hình ảnh không được để trống!":"";
			String error3 = i==3? "Hình ảnh không được để trống!":"";
			request.setAttribute("error1", error1);
			request.setAttribute("error2", error2);
			request.setAttribute("error3", error3);
			getServletContext().getRequestDispatcher("/manage/admin-image.jsp").forward(request, response);
		}
	}

}
