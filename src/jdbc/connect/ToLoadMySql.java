package jdbc.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接MySQL
 * */
public class ToLoadMySql {
    static final String diver = "com.mysql.jdbc.Driver";

    static{
        try {
            //加载驱动
            Class.forName(diver);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动名字写错了！");
        }
    }

    //连接数据库
    public static Connection getConnection(String url,String account,String password) {
       try {
           return DriverManager.getConnection(url, account, password);
       } catch (SQLException e) {
           System.out.println("数据库名字或者账号密码错误！");
       }
       return null;
    }

    //关闭驱动
    public static void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
            System.out.println("驱动已关闭！");
        }
    }
}
