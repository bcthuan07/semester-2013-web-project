package servlet.manage.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.AdDAO;
import service.DAOService;
import util.ImageUtil;
import util.UploadFileUtil;
import model.Ads;

/**
 * Servlet implementation class EditAdServlet
 */
@WebServlet("/Manage/EditAd")
@MultipartConfig
public class EditAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String adid = request.getParameter("id");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String link = request.getParameter("link");
		Part part = request.getPart("image");
		String name_err = "", content_err = "", link_err = "";
		String filename = "";
		if (part != null) {
			filename = UploadFileUtil.getFileName(part) == null ? ""
					: UploadFileUtil.getFileName(part);
		}
		if (name == null || name.equals(""))
			name_err += "Tên không được để trống!";

		if (content == null || name.equals(""))
			content_err += "Nội dung không được để trống!";
		else {
			if (content.length() > 255)
				content_err += "Nội dung không được vượt quá 255 ký tự!";
		}

		if (link == null || link.equals(""))
			link_err += "Đường dẫn không để trống!";

		if (name_err.length() == 0 && content_err.length() == 0
				&& link_err.length() == 0) {
			Integer id = Integer.parseInt(adid);
			DAOService<Ads, Integer> service = new DAOService<>(new AdDAO());
			Ads a = service.getObjectById(id);
			a.setContent(content);
			a.setLink(link);
			a.setName(name);
			String aImg = a.getImagePath();
			if (filename != null && filename.endsWith(".jpg")) {
				String location = request.getServletContext().getRealPath("")+"/"
						+ aImg;
				System.out.println(location);
				part.write(location);
				ImageUtil.resizeImage(140, 140, location);
			}
			service.updateObject(a);
			getServletContext().getRequestDispatcher("/Manage/Ad")
					.forward(request, response);
		} else {
			request.setAttribute("name_err", name_err);
			request.setAttribute("content_err", content_err);
			request.setAttribute("link_err", link_err);

			getServletContext()
					.getRequestDispatcher("/manage/admin-edidad.jsp").forward(
							request, response);
		}
	}

}
