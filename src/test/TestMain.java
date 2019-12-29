package test;

import java.io.File;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import jdbc.instantiation.JDBCUtil;
import pojo.Tag;

public class TestMain {

	public static void main(String[] args) throws SQLException, InstantiationException, Exception {
//		String SQL = "select * from tag";
//		Object[] params = null;
//		
//		List<Tag> tags = JDBCUtil.excuteQuery(SQL, params, Tag.class);
//		for(Tag tag:tags) {
//			System.out.println(tag.getT_name());
//		}
		String path = "./WebContent/upload/";
		String fileName = UUID.randomUUID()+".jpg";
		File file = new File(path+fileName);
		if(!file.exists()) {
			file.getParentFile().mkdir();
			file.createNewFile();
	    }
	}
}
