package control.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDao;
import dao.ClassifyDao;
import pojo.Article;
import pojo.Category;
import util.PageUtil;

/**
 * 
 */
@WebServlet("/admin/article")
public class AdminArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleDao articleDao = new ArticleDao();
	
	private ClassifyDao classifyDao = new ClassifyDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kind = request.getParameter("kind");
		String page = request.getParameter("page");
		List<Article> articles = new ArrayList<Article>();
		int indexPage = 1;
		int totalPages = 0;
		int begin = PageUtil.indexOfPage(page);
		if (kind == null ||kind == "") {
			try {
				kind = "";
				articles = articleDao.ArticleClassify(begin, 10);
				int count = articleDao.count();
				totalPages = (int) PageUtil.getKindOfCategorySize(count);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			long id = Long.parseLong(kind);
			try {
				articles = classifyDao.FindAllCategory(id, begin, 10);
				int count = classifyDao.count(id);
				totalPages = (int) PageUtil.getKindOfCategorySize(count);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		List<Category> categories = null;
		categories = classifyDao.FindAllClass();
		
		if (page != null) {
			indexPage = Integer.parseInt(page);
			
		}
		
		request.setAttribute("indexPage", indexPage);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("kind", kind);
		request.setAttribute("articles", articles);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("./admin-article.jsp").forward(request, response);
	}
}
