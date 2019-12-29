package dao;

import jdbc.instantiation.JDBCUtil;
import pojo.Article;
import pojo.Category;

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
    
    public int count(long id) throws SQLException {
    	String sql="select * from article where a_category_id = ?";
    	Object[] params = {id};
    	List<Article> articles = JDBCUtil.excuteQuery(sql, params, Article.class);
    	return articles.size();
	}
}
