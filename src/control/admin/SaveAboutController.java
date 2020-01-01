package control.admin;

import java.io.IOException;import java.security.interfaces.RSAKey;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AboutDao;

/**
 * 保存about的编写
 */
@WebServlet("/admin/about/save")
public class SaveAboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	AboutDao aboutDao = new AboutDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String content = request.getParameter("content");
		aboutDao.save(content);
		response.sendRedirect("/blog-jsp/admin/about");
	}

}
