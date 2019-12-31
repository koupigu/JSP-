package dao;

import java.sql.SQLException;
import java.util.List;

import jdbc.instantiation.JDBCUtil;
import pojo.File;

public class FileDao {
	
	/**
	 * 获取全部文件
	 * */
	public List<File> getAllFile() throws SQLException {
		String sql = "select * from file";
		Object[] params = null;
		
		List<File> files = JDBCUtil.excuteQuery(sql, params, File.class);
		
		return files;
	}
	
	/**
	 * 保存文件
	 * @throws SQLException 
	 * */
	public void saveFile(String name,String url,Long type) throws SQLException {
		String sql = "insert into file (name,url,type) value(?,?,?)";
		Object[] params = {name,url,type};
		JDBCUtil.executeUpdate(sql, params);
	}
	
	/**
	 * 删除文件
	 * @throws SQLException 
	 * */
	public void deleteByUrl(String url) throws SQLException {
		String sql = "delete from file where url = ?";
		Object[] params = {url};
		JDBCUtil.executeUpdate(sql, params);
	}
}
