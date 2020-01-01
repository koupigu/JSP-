package control.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LabelDao;

/**
 * 删除标签
 */
@WebServlet("/admin/tag/detele")
public class DeleteTagController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LabelDao labelDao = new LabelDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		labelDao.deleteTagById(id);
		response.sendRedirect("/blog-jsp/admin/tag");
	}


}
