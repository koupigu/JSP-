package jdbc.connect;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * 数据库实例化对象
 * */
public class ConnectMySQL {

    private Connection conn = null;
    private PreparedStatement res = null;
    /**
     * 连接数据库
     * @param SQL SQL语句
     * @return 返回 实例化 PreparedStatement 对象
     * */
    public PreparedStatement QuerySQL(String SQL) throws SQLException {
        conn = ToLoadMySql.getConnection(DataBaseInfo.URL,DataBaseInfo.ACCOUNT,DataBaseInfo.PASSWORD);
        try {
            //Connect对象不能为空
            assert conn != null;

            res = (PreparedStatement) conn.prepareStatement(SQL);
        } catch (NullPointerException e){
            System.out.println("SQL语句不能为空");
        }
        return res;
    }
    //断开数据库的连接
    public void close() throws SQLException {
        if(res != null) res.close();
        System.out.println("数据库已断开连接");
        ToLoadMySql.closeConnection(conn);
    }
}
