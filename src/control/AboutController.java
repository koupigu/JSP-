package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/about")
public class AboutController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/**
		 * List<Article> articles =  dao.getArticles(begin,size);
		 * 
		 * */
		
		req.setAttribute("articles", "articles");
		
		req.getRequestDispatcher("about.jsp").forward(req, resp);
	}
}
