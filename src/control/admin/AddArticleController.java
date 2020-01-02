package control.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArticleDao;
import dao.ClassifyDao;
import dao.LabelDao;

/**
 * 添加文章
 */
@WebServlet("/admin/article/add")
public class AddArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ArticleDao articleDao = new ArticleDao();
	LabelDao tagDao = new LabelDao();
	ClassifyDao categoryDao = new ClassifyDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String tags = request.getParameter("tags");
		String category = request.getParameter("category");
		System.out.println(title+"+++"+tags+"+++"+category+"+++"+content);
		tags.replaceAll(" ","");
		String[] tagsArray = tags.split("#");
		for (String tag:tagsArray) {
			if(!tagDao.isHas(tag)) {
				tagDao.addTag(tag);
			}	
		}
		Long id = categoryDao.getIdByName(category);
		
		articleDao.addArticle(title, content, filterTheHtml(content), id);
		
		
	}
	
    private String filterTheHtml(String html) {
        String preview = html.replaceAll("<.*?>", "").replaceAll("&nbsp;","");
        int previewLength = 50;
        if (preview.length() > previewLength) {
            preview = preview.substring(0,70);
        }
        return preview;
    }
}
