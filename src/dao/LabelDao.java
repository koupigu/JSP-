package dao;

import jdbc.instantiation.JDBCUtil;
import pojo.Article;
import pojo.Tag;
import java.sql.SQLException;
import java.util.List;

/**
 * 标签dao
 * @author 舒宗梅
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
     * 根据id查找tag
     * @throws SQLException 
     * */
    public Tag getTagById(long id) throws SQLException {
    	String sql="select * from tag where t_id = ?";
    	Object[] params = {id};
    	List<Tag> tag = JDBCUtil.excuteQuery(sql, params, Tag.class);
    	Tag object = tag.get(0);
    	return object;
	}
    
    /**
     * 获取标签总数
     * */
    public int count() {
    	String sql = "select * from tag";
		Object[] params = null;
		List<Tag> tags = null;
		try {
			tags = JDBCUtil.excuteQuery(sql, params, Article.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tags.size();
	}
    
    /**
     * 标签分页
     * */
    public List<Tag> limiTags(int begin,int size) {
    	String sql = "select * from tag limit ?,?";
    	Object[] params = {begin,size};
    	List<Tag> tags = null;
		try {
			tags = JDBCUtil.excuteQuery(sql, params, Tag.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return tags;
    }
    
    /**
     * 根据id删除标签
     * */
    public void deleteTagById(String id) {
    	String sql = "delete from  tag where T_id =  ?";
    	Object[] params= {id};
    	try {
			JDBCUtil.executeUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    /**
     * 修改标签
     * */
    public void changeNameById(String name,String id) {
    	String sql = "update tag set t_name=?  where  t_id = ?";
    	Object[] params = {name,id};
    	
    	try {
			JDBCUtil.executeUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * 添加标签
     * */
    public void addTag(String tag) {
    	
    	String sql = "insert into tag(t_name) values(?)";
    	Object[] params= {tag};
    	try {
			JDBCUtil.executeUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public boolean isHas(String name) {
    	String sql = "select * from tag where c_name= ?";
    	Object[] params = {name};
    	try {
			List list = JDBCUtil.excuteQuery(sql, params, Tag.class);
			if (list.size() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
}
