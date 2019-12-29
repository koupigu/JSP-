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
import pojo.Article;

@WebServlet("/index")
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ArticleDao articleDao = new ArticleDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Article> articles = null;
		try {
			articles = articleDao.ArticleNew(6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("articles", articles);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
