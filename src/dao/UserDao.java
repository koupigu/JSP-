package dao;

import java.sql.SQLException;
import java.util.List;

import jdbc.instantiation.JDBCUtil;
import pojo.User;

/**
 * 
 * */
public class UserDao {

	
	/**
	 * 验证 登录
	 * @author 舒宗梅
	 * */
	public boolean isTrue(String name,String password) {
		String sql = "select * from user where u_name = ? and u_password = ?";
		Object[] params = {name,password};
		List<User> users = null;
		try {
			users = JDBCUtil.excuteQuery(sql, params, User.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (users == null || users.size() < 1) {
			return false;
		}
		return true;
	}
	
	/**
	 * 添加用户
	 * */
	public void add(String name,String password) {
		String sql = "insert into user(u_name,u_password) value(?,?)";
		Object[] params = {name,password};
		
		try {
			JDBCUtil.executeUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
