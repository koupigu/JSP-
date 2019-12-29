package pojo;


/**
 * 用户实体类
 * @author 蒋超辉
 * */
public class User {

  private long u_Id;
  private String u_name;
  private String u_password;
  private String u_email;
  private String u_photo;


  public long getU_Id() {
    return u_Id;
  }

  public void setU_Id(long u_Id) {
    this.u_Id = u_Id;
  }

  public String getU_name() {
    return u_name;
  }

  public void setU_name(String u_name) {
    this.u_name = u_name;
  }

  public String getU_password() {
    return u_password;
  }

  public void setU_password(String u_password) {
    this.u_password = u_password;
  }

  public String getU_email() {
    return u_email;
  }

  public void setU_email(String u_email) {
    this.u_email = u_email;
  }

  public String getU_photo() {
    return u_photo;
  }

  public void setU_photo(String u_photo) {
    this.u_photo = u_photo;
  }

  @Override
  public String toString() {
    return "User{" +
            "u_Id=" + u_Id +
            ", u_name='" + u_name + '\'' +
            ", u_password='" + u_password + '\'' +
            ", u_email='" + u_email + '\'' +
            ", u_photo='" + u_photo + '\'' +
            '}';
  }
}
