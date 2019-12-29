package jdbc.connect;
/**
 * 数据库的名字，账号和密码
 * */
public class DataBaseInfo {

    //数据库名字
    static  String URL = "jdbc:mysql://localhost:3306/blogsdb?useSSL=false";

    //账号
    public static final String ACCOUNT = "root";

    //密码
    public static final String PASSWORD = "123456";

    //修改指定数据库
    public static void setUrl(String databaseName) {
        String left = "jdbc:mysql://localhost:3306/";
        String right = "?useSSL=false";
        URL = left + databaseName + right;
    }

    //URL 默认应该为空
    //如果不指明数据库应当读取databaseName.txt中上次使用过的数据库的名字
    //然后保存在databaseName.txt中
}
