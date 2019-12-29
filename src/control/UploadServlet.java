package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import util.UploadFileUtil;

/**
 * 文件上传
 * */
@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Part part = req.getPart("file");
		String url = UploadFileUtil.Upload(part);
		req.setAttribute("url",url);
		req.getRequestDispatcher("uploadFile.jsp").forward(req,resp);
		//resp.sendRedirect();
	}
}
