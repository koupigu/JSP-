package control.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassifyDao;
import pojo.Category;
import pojo.Tag;
import util.PageUtil;

/**
 * 
 */
@WebServlet("/admin/kind")
public class AdminKindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClassifyDao kindDao = new ClassifyDao();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int indexPage = 1;
		int totalPages = 0;
		
		List<Category> categories = null;
		int begin = PageUtil.indexOfPage(page);
		try {
			categories = kindDao.limiCategories(begin, 9);
			int count = kindDao.count();
			totalPages = (int) PageUtil.getKindOfCategorySize(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("indexPage", indexPage);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("kinds", categories);
		
		request.getRequestDispatcher("./admin-kind.jsp").forward(request, response);
	}

	
}
