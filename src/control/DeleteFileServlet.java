package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FileDao;

/**
 * 文件删除
 */
@WebServlet("/delete")
public class DeleteFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	FileDao fileDao = new FileDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("url");
		try {
			fileDao.deleteByUrl(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/blog-jsp/admin/file");
	}



}
