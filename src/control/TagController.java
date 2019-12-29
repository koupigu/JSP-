package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LabelDao;
import pojo.Article;
import pojo.Tag;
import util.PageUtil;

/**
 * 标签
 */
@WebServlet("/tag")
public class TagController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LabelDao tagDao = new LabelDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("id");
		String page = request.getParameter("page");
		
		int indexPage = 1;
		int totalPages = 1;
		
		int begin = PageUtil.indexOfPage(page);
		long id = Long.parseLong(name);
		Tag tag = null;
		try {
			tag = tagDao.getTagById(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long count = tag.getT_count();
		List<Article> articles = null;
		try {
			articles = tagDao.getArticlesByTagId(id, begin, 9);
			totalPages = (int) PageUtil.getKindOfCategorySize(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (page != null) {
			indexPage = Integer.parseInt(page);
			
		}
		request.setAttribute("indexPage", indexPage);
		request.setAttribute("totalPags", totalPages);
		request.setAttribute("articles", articles);
		request.setAttribute("name",tag.getT_name());
		request.setAttribute("count", count);
		request.getRequestDispatcher("tag.jsp").forward(request, response);
	}

}
