package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

/**
 * 文件上传类
 * @author
 * */
public class UploadFileUtil {
	
	/**
	 * 上传文件
	 * @return 返回上传后的 url 地址
	 * */
	public static String Upload(Part part) throws IOException {
		// 得到完整的文件名
		String disposition = part.getHeader("Content-Disposition");
		// 获取后缀
		String suffix = disposition.substring(disposition.lastIndexOf("."), disposition.length() - 1);
		// 文件名
		String fileName = System.nanoTime() + suffix;

		InputStream is = part.getInputStream();
		
		//这里是你的虚拟映射的路径，在tomcat设置
		String path = "C:\\blogData\\jsp\\";
		
		File file = new File(path + fileName);
		// 如果file不存在,在这个路径下创建文件
		if (!file.exists()) {
			file.getParentFile().mkdir();
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		byte[] b = new byte[1024];
		int length = 0;

		while ((length = is.read(b)) != -1) {
			fos.write(b, 0, length);
		}
		fos.close();
		is.close();
		return "http://localhost:8080/"+fileName;
	}

}
