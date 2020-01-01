package dao;

import java.sql.SQLException;
import java.util.List;

import jdbc.instantiation.JDBCUtil;
import pojo.About;

public class AboutDao {

	
	public void save(String content) {
		String sql = "insert into about(content) values(?)";
		Object[] params = {content};
		
		try {
			JDBCUtil.executeUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public About getAbout() {
		String sql = "SELECT * from about ORDER BY time DESC LIMIT 1";
		Object[] params=null;
		About about = null;
		try {
			List<About> abouts = JDBCUtil.excuteQuery(sql, params, About.class);
			about = abouts.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return about;
	}
}
