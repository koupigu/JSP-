package dao;

import jdbc.instantiation.JDBCUtil;
import pojo.Article;
import pojo.Category;
import pojo.Tag;

import java.sql.SQLException;
import java.util.List;
/**
 * 分类 dao
 * @author 蒋超辉
 * */
public class ClassifyDao {
    //分类
    //查询所有分类
    public List<Category> FindAllClass() throws SQLException {
        String sql="select * from category";
        Object[] params = null;
        List<Category> category = JDBCUtil.excuteQuery(sql, params, Category.class);
        return category;
    }

    //根据分类id查找所有文章分页
    
    public List<Article> FindAllCategory(long id,int a,int b) throws SQLException {
        String sql="select * from article where a_category_id = ? order by a_publish_time LIMIT ?,?";
        Object[] params = {id,a,b};
        List<Article> articles = JDBCUtil.excuteQuery(sql, params, Article.class);
        return articles;
    }
    
    /**
     * 分类文章总数
     * */
    public int count(long id) throws SQLException {
    	String sql="select * from article where a_category_id = ?";
    	Object[] params = {id};
    	List<Article> articles = JDBCUtil.excuteQuery(sql, params, Article.class);
    	return articles.size();
	}
    /**
     * 分类总数
     * */
    public int count() throws SQLException {
    	String sql = "select * from category";
		Object[] params = null;
		List<Category> categories = JDBCUtil.excuteQuery(sql, params, Category.class);
		return categories.size();
	}
    
    /**
     * 分类分页
     * */
    public List<Category> limiCategories(int begin,int size) throws SQLException {
    	String sql = "select * from category limit ?,?";
    	Object[] params = {begin,size};
    	List<Category> categories = JDBCUtil.excuteQuery(sql, params, Category.class);
    	return categories;
    }
    
    /**
     * 根据分类id 删除分类
     * @throws SQLException 
     * */
    public void deleteCategoryById(String id) throws SQLException {
    	String sql = " delete from  category where c_id =  ? ";
    	Object[] params = {id};
    	JDBCUtil.executeUpdate(sql, params);
    }
    
    /**
     * 根据id修改名称
     * */
    public void changeNameById(String id,String name) throws SQLException {
    	String sql = "update category set c_name=?  where  c_id = ?";
		Object[] params = {name,id};
		JDBCUtil.executeUpdate(sql, params);
	}
    
    /**
     * 添加分类
     * */
    public void addCategory(String name) {
    	String sql = "insert into category(c_name) value(?)";
    	Object[] params = {name};
    	try {
			JDBCUtil.executeUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
