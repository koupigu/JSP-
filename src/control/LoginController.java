package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/login")
public class LoginController  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserDao userDao = new UserDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		boolean isTrue = userDao.isTrue(name, password);
		if (isTrue) {
			req.getRequestDispatcher("/admin/adminIndex.jsp").forward(req, resp);
			return;
		}
		req.setAttribute("msg", "账号密码错误");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
}
