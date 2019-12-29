package pojo;


/**
 * 标签实体类
 * @author 蒋超辉
 * */
public class Tag {

  private long t_id;
  private String t_name;
  private long t_count;

  public long getT_id() {
    return t_id;
  }

  public void setT_id(long t_id) {
    this.t_id = t_id;
  }

  public String getT_name() {
    return t_name;
  }

  public void setT_name(String t_name) {
    this.t_name = t_name;
  }

  public long getT_count() {
    return t_count;
  }

  public void setT_count(long t_count) {
    this.t_count = t_count;
  }

  @Override
  public String toString() {
    return "Tag{" +
            "t_id=" + t_id +
            ", t_name='" + t_name + '\'' +
            ", t_count=" + t_count +
            '}';
  }
}
