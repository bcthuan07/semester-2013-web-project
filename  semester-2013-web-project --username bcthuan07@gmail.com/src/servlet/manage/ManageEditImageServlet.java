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

		int hWidth=900,hHeight=500,mWidth=800,mHeight=300;
		Part image = request.getPart("image");
		String index = request.getParameter("index");
		int i = Integer.parseInt(index);
		String error = "";
		String origin = request.getParameter("origin");
		String imageName = "";
		if (image != null)
			imageName = UploadFileUtil.getFileName(image);
		if (imageName == null || imageName.length() == 0) {
			error += "Hình ảnh không được để trống";
		}

		if (error.length() == 0) {
			image.write(request.getContextPath() + "/" + origin);
			if(i>=0 && i<=3)
				ImageUtil.resizeImage(hWidth, hHeight, request.getContextPath()+"/"+origin);
			else
				ImageUtil.resizeImage(mWidth, mHeight, request.getContextPath()+"/"+origin);
			getServletContext().getRequestDispatcher("/manage/admin-image.jsp")
					.forward(request, response);
		} else {
			String home1 = i == 1 ? "Hình ảnh không được để trống!":"";
			String home2 = i == 2 ? "Hình ảnh không được để trống!":"";
			String home3 = i == 3 ? "Hình ảnh không được để trống!":"";
			
			String menu1 = i == 4 ? "Hình ảnh không được để trống!" : "";
			String menu2 = i == 5 ? "Hình ảnh không được để trống!" : "";
			String menu3 = i == 6 ? "Hình ảnh không được để trống!" : "";
			request.setAttribute("home1", home1);
			request.setAttribute("home2", home2);
			request.setAttribute("home3", home3);
			request.setAttribute("menu1", menu1);
			request.setAttribute("menu2", menu2);
			request.setAttribute("menu3", menu3);
			getServletContext().getRequestDispatcher("/manage/admin-image.jsp")
					.forward(request, response);
		}
	}

}
