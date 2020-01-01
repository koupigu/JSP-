package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AboutDao;
import pojo.About;

@WebServlet("/about")
public class AboutController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	AboutDao aboutDao = new AboutDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		About about = aboutDao.getAbout();
		req.setAttribute("about", about);
		
		req.getRequestDispatcher("about.jsp").forward(req, resp);
	}
}
