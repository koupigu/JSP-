package dao;

import jdbc.instantiation.JDBCUtil;
import pojo.Article;

import java.sql.SQLException;
import java.util.List;

/**
 * 文章dao
 * @author 蒋超辉
 * */
public class ArticleDao {
    //文章
    //文章分页（按时间排序）
    public List<Article> ArticleClassify(int a,int b) throws SQLException {
        String sql = "select * from article order by a_publish_time desc LIMIT ?,?";
        Object[] params = {a,b};
        List<Article> articles = JDBCUtil.excuteQuery(sql, params,Article.class);
        return articles;
    }
    
    //根据id查找文章
    public Article getArticleById(String id) throws SQLException {
        String sql="select * from article where a_id=?";
        Object[] params = {id};
        List<Article> articles = JDBCUtil.excuteQuery(sql, params, Article.class);
        Article article = articles.get(0);
        return article;
    }
    
    //获取最新?篇文章
    public List<Article> ArticleNew(int a) throws SQLException {
        String sql="select * from article order by a_publish_time desc LIMIT ?";
        Object[] params = {a};
        List<Article> articles = JDBCUtil.excuteQuery(sql, params, Article.class);
        return articles;
    }
    
    /**
     * 文章总数
     * */
    public int count() throws SQLException {
		String sql = "select * from article";
		Object[] params = null;
		List<Article> articles = JDBCUtil.excuteQuery(sql, params, Article.class);
		return articles.size();
	}
    
    /**
     * 浏览数加一
     * @throws SQLException 
     * */
    public void add(String id) throws SQLException {
    	Article article = getArticleById(id);
    	String sql = "UPDATE article SET a_page_view = ? WHERE a_id = ?";
    	Object[] params = {article.getA_page_view()+1,id};
    	JDBCUtil.executeUpdate(sql, params);
    }
    
    public void deleteById(String id) throws SQLException {
    	String sql = "delete from  article where a_id =  ?";
    	Object[] params = {id};
    	JDBCUtil.executeUpdate(sql, params);
	}
    
}
