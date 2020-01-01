package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.FileDao;
import util.UploadFileUtil;

/**
 * 文件上传
 * */
@WebServlet("/admin/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	FileDao fileDao = new FileDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		req.setCharacterEncoding("UTF-8");
		Part part = req.getPart("file");
		String url = UploadFileUtil.Upload(part);
		String name = req.getParameter("name");
		if ("".equals(name)) {
			name = url.substring(url.lastIndexOf("/")+1,url.length());
		}
		try {
			fileDao.saveFile(name, url, (long) 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("url",url);
		req.getRequestDispatcher("./uploadFile.jsp").forward(req,resp);
		//resp.sendRedirect();
	}
}
