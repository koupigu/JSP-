package jdbc.instantiation;
import com.mysql.jdbc.PreparedStatement;
import jdbc.connect.ConnectMySQL;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * SQL语句
 * 增 删 改 查
 * */
public class JDBCUtil {
    /**
     * SQL 查询将查询结果直接放入ResultSet中
     * @param SQL SQL语句
     * @param params 参数数组，若没有参数则为null
     * @return 结果集
     */
    public static ResultSet executeQueryRS(String SQL, Object[] params) throws SQLException {
        ConnectMySQL connectMySQL = new ConnectMySQL();
        PreparedStatement prepared = connectMySQL.QuerySQL(SQL);
        if (params != null) {
        	for (int i = 0; i < params.length; i++) {
                prepared.setObject(i+1,params[i]);
            }
		}
        
        ResultSet set = null;
        set = prepared.executeQuery();
        return set;
    }

    /**
     * 获取结果集，并将结果放在List中
     * @param SQL  SQL语句
     * @params  参数，没有则为null
     * @return List 结果集
     * */
    public static List excuteQuery(String SQL, Object[] params,Class cc) throws SQLException{
    	ResultSet rs = executeQueryRS(SQL,params);
    	List list = null;
		try {
			list = Populate(rs,cc);
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return list;
    }
    
    public static List Populate(ResultSet rs,Class cc) throws SQLException, InstantiationException, IllegalAccessException{
        
        //结果集 中列的名称和类型的信息
        ResultSetMetaData rsm = rs.getMetaData();
        int colNumber = rsm.getColumnCount();
        List list = new ArrayList();
        Field[] fields = cc.getDeclaredFields();
        
        //遍历每条记录
        while(rs.next()){
            //实例化对象
            Object obj = cc.newInstance();
            //取出每一个字段进行赋值
            for(int i=1;i<=colNumber;i++){
                Object value = rs.getObject(i);
                //匹配实体类中对应的属性
                for(int j = 0;j<fields.length;j++){
                    Field f = fields[j];
                    if(f.getName().equals(rsm.getColumnName(i))){
                        boolean flag = f.isAccessible();
                        f.setAccessible(true);
                        f.set(obj, value);
                        f.setAccessible(flag);
                        break;
                    }
                }
                 
            }
            list.add(obj);
        }
        return list;
    }

    /**
     * insert update delete SQL语句的执行的统一方法
     * @param SQL SQL语句
     * @param params 参数数组，若没有参数则为null
     * @version 2.0
     * */
    public static void executeUpdate(String SQL,Object[] params) throws SQLException {
        ConnectMySQL connectMySQL = new ConnectMySQL();
        PreparedStatement prepared = connectMySQL.QuerySQL(SQL);
        for (int i = 0; i < params.length; i++) {
            prepared.setObject(i+1,params[i]);
        }
        int count = prepared.executeUpdate();
        if (count > 0) {
            System.out.println("执行成功！");
            System.out.println(count+"行受影响");
        } else {
            System.out.println("执行失败！");
        }

        connectMySQL.close();
    }
}
