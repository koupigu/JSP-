package control.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AboutDao;
import pojo.About;

/**
 * 返回adminAbout页面
 */
@WebServlet("/admin/about")
public class AdminAboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AboutDao aboutDao = new AboutDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		About about = aboutDao.getAbout();
		request.setAttribute("about", about);
		request.getRequestDispatcher("./editorAbout.jsp").forward(request, response);
	}

}
