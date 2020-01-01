package control.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LabelDao;
import pojo.Category;
import pojo.Tag;
import util.PageUtil;

/**
 * 标签
 */
@WebServlet("/admin/tag")
public class AdminTagController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LabelDao tagDao = new LabelDao();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		int indexPage = 1;
		int totalPages = 0;
		
		int begin = PageUtil.indexOfPage(page);
		List<Tag> tags = tagDao.limiTags(begin, 9);
		int count = tagDao.count();
		totalPages = (int) PageUtil.getKindOfCategorySize(count);
		
		
		request.setAttribute("indexPage", indexPage);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("tags", tags);
		
		request.getRequestDispatcher("./admin-tag.jsp").forward(request, response);
	}

}
