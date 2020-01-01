package control.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassifyDao;

/**
 * 添加分类
 */
@WebServlet("/admin/category/add")
public class AddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClassifyDao kindDao = new ClassifyDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		
		if ("".equals(name)) {
			request.setAttribute("msg", "不能为空");
			request.getRequestDispatcher("/admin/kind").forward(request, response);
			return;
		}
		
		kindDao.addCategory(name);
		
		response.sendRedirect("/blog-jsp/admin/kind");
	}

}
