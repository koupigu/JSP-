package control;

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
import dao.LabelDao;
import pojo.Article;
import pojo.Category;
import pojo.Tag;
import util.PageUtil;

@WebServlet("/article")
public class ArticleController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private ArticleDao articleDao = new ArticleDao();
	
	private ClassifyDao classifyDao = new ClassifyDao();
	
	private LabelDao labeDao = new LabelDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String kind = req.getParameter("kind");
		String page = req.getParameter("page");
		System.out.println(kind+"======"+page);
		
		List<Article> articles = new ArrayList<Article>();
		int indexPage = 1;
		int totalPages = 0;
		int begin = PageUtil.indexOfPage(page);
		if (kind == null ||kind == "") {
			try {
				kind = "";
				articles = articleDao.ArticleClassify(begin, 10);
				int count = articleDao.count();
				System.out.println(count);
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
		try {
			categories = classifyDao.FindAllClass();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Tag> tags = null;
		try {
			tags = labeDao.getNTag(6);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (page != null) {
			indexPage = Integer.parseInt(page);
			
		}
		
		req.setAttribute("indexPage", indexPage);
		req.setAttribute("totalPages", totalPages);
		req.setAttribute("kind", kind);
		req.setAttribute("articles", articles);
		req.setAttribute("categories", categories);
		req.setAttribute("tags",tags );
		
		req.getRequestDispatcher("article.jsp").forward(req, resp);
	}
	
	 
}
