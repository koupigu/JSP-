package pojo;


/**
 * 分类实体类
 * @author 蒋超辉
 * */
public class Category {

	private long c_id;
	private String c_name;
	private long c_count;
	public long getC_id() {
		return c_id;
	}
	public void setC_id(long c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public long getC_count() {
		return c_count;
	}
	public void setC_count(long c_count) {
		this.c_count = c_count;
	}
	@Override
	public String toString() {
		return "Category [c_id=" + c_id + ", c_name=" + c_name + ", c_count=" + c_count + "]";
	}

	

  
  
  
}
