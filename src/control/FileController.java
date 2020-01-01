package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FileDao;
import pojo.File;


@WebServlet("/admin/file")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private FileDao fileDao = new FileDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<File> files = null;
		try {
			files = fileDao.getAllFile();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("files", files);
		
		request.getRequestDispatcher("./file.jsp").forward(request, response);
	}

}
