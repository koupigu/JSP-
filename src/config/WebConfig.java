package config;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import dao.ArticleDao;
/**
 * 拦截器
 * 
 * */
@WebFilter("/article/*")
public class WebConfig implements Filter{
	
	ArticleDao articleDao = new ArticleDao();
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 拦截所有的文章详细请求，浏览数加一
	 * */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		String id = request.getParameter("id");
		if (id == null) {
			filterChain.doFilter(request, response);
		} else {
			try {
				articleDao.add(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			filterChain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
}
