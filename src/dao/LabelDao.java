package dao;

import jdbc.instantiation.JDBCUtil;
import pojo.Article;
import pojo.Tag;
import java.sql.SQLException;
import java.util.List;

/**
 * 标签dao
 * @author 蒋超辉
 * */
public class LabelDao {
	
    //标签
    //获取文章数最多的标签（前?个）
    public List<Tag> getNTag(int a) throws SQLException {
        String sql="select * from tag  ORDER BY t_count desc LIMIT ?";
        Object[] params = {a};
        List<Tag> category = JDBCUtil.excuteQuery(sql, params, Tag.class);
        return category;
    }
    
    //根据标签id查找所有文章分页
    public List<Article> getArticlesByTagId(long id,int begin,int size) throws SQLException {
        String sql=  "SELECT * FROM article WHERE a_id in (SELECT relationship_a_id FROM tag_relationship WHERE relationship_t_id = ? ) LIMIT ?,?";
        Object[] params = {id,begin,size};
        List<Article> category = JDBCUtil.excuteQuery(sql, params, Article.class);
        return category;
    }
    
    /**
     * 根据文章id查找同标签的文章（不包含自身）
     * @throws SQLException 
     * */
    public List<Article> getArticlesWithTagByArticleId(String id) throws SQLException {
		String sql = "SELECT * FROM article where a_id in ( SELECT relationship_a_id FROM tag_relationship WHERE relationship_t_id in ( " + 
				" SELECT relationship_t_id FROM tag_relationship where relationship_a_id = ? " + 
				" ) AND a_id != ? ) ORDER BY a_publish_time desc LIMIT 5 ";
		Object[] params = {id,id};
		List<Article> articles = JDBCUtil.excuteQuery(sql, params, Article.class);

		return articles;
	}
    
    /**
     * 获取标签总数
     * @throws SQLException 
     * */
    public Tag getTagById(long id) throws SQLException {
    	String sql="select * from tag where t_id = ?";
    	Object[] params = {id};
    	List<Tag> tag = JDBCUtil.excuteQuery(sql, params, Tag.class);
    	Tag object = tag.get(0);
    	return object;
	}
}
