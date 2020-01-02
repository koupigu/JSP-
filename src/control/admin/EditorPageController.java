package control.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassifyDao;
import pojo.Category;

/**
 * 文章编辑页面
 */
@WebServlet("/admin/articlePage")
public class EditorPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ClassifyDao categoryDao = new ClassifyDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Category> categories = categoryDao.FindAllClass();
		request.setAttribute("categories", categories);
		
		request.getRequestDispatcher("./editor.jsp").forward(request, response);
	}

}
