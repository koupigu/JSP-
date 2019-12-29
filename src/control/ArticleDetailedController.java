package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDao;
import dao.LabelDao;
import pojo.Article;

/**
 * 文章详细
 */
@WebServlet("/article/detailed")
public class ArticleDetailedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private ArticleDao dao = new ArticleDao();
	
	private LabelDao tagDao = new LabelDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取文章id
		String id = request.getParameter("id");
		
		Article article = null;
		try {
			article = dao.getArticleById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<Article> tags = null;
		try {
			tags = tagDao.getArticlesWithTagByArticleId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("article", article);
		request.setAttribute("tags", tags);
		request.getRequestDispatcher("/articleDetailed.jsp").forward(request, response);
		
	}

}
