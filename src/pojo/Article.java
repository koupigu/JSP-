package pojo;

import java.sql.Timestamp;

/**
 * 文章实体类
 * @author 蒋超辉
 * */
public class Article {

  private long a_id;
  private long a_user_id;
  private String a_title;
  private String a_context;
  private long a_page_view;
  private long a_comment;
  private java.sql.Timestamp a_publish_time;
  private String a_cover_picture;
  private String a_preview_text;
  private String a_diff;
  private long a_category_id;

  public long getA_id() {
    return a_id;
  }

  public void setA_id(long a_id) {
    this.a_id = a_id;
  }

  public long getA_user_id() {
    return a_user_id;
  }

  public void setA_user_id(long a_user_id) {
    this.a_user_id = a_user_id;
  }

  public String getA_title() {
    return a_title;
  }

  public void setA_title(String a_title) {
    this.a_title = a_title;
  }

  public String getA_context() {
    return a_context;
  }

  public void setA_context(String a_context) {
    this.a_context = a_context;
  }

  public long getA_page_view() {
    return a_page_view;
  }

  public void setA_page_view(long a_page_view) {
    this.a_page_view = a_page_view;
  }

  public long getA_comment() {
    return a_comment;
  }

  public void setA_comment(long a_comment) {
    this.a_comment = a_comment;
  }

  public Timestamp getA_publish_time() {
    return a_publish_time;
  }

  public void setA_publish_time(Timestamp a_publish_time) {
    this.a_publish_time = a_publish_time;
  }

  public String getA_cover_picture() {
    return a_cover_picture;
  }

  public void setA_cover_picture(String a_cover_picture) {
    this.a_cover_picture = a_cover_picture;
  }

  public String getA_preview_text() {
    return a_preview_text;
  }

  public void setA_preview_text(String a_preview_text) {
    this.a_preview_text = a_preview_text;
  }

  public String getA_diff() {
    return a_diff;
  }

  public void setA_diff(String a_diff) {
    this.a_diff = a_diff;
  }

  public long getA_category_id() {
    return a_category_id;
  }

  public void setA_category_id(long a_category_id) {
    this.a_category_id = a_category_id;
  }

  @Override
  public String toString() {
    return "Article{" +
            "a_id=" + a_id +
            ", a_user_id=" + a_user_id +
            ", a_title='" + a_title + '\'' +
            ", a_context='" + a_context + '\'' +
            ", a_page_view=" + a_page_view +
            ", a_comment=" + a_comment +
            ", a_publish_time=" + a_publish_time +
            ", a_cover_picture='" + a_cover_picture + '\'' +
            ", a_preview_text='" + a_preview_text + '\'' +
            ", a_diff='" + a_diff + '\'' +
            ", a_category_id=" + a_category_id +
            '}';
  }
}
