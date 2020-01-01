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
 * 修改标签
 */
@WebServlet("/admin/tag/change")
public class ChangeTagController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LabelDao tagDao = new LabelDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		
		tagDao.changeNameById(name, id);
		
		response.sendRedirect("/blog-jsp/admin/tag");
	}
}
