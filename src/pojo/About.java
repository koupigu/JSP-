package pojo;

public class About {
	
	private long id;
	
	private String content;
	
	private java.sql.Timestamp time;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.sql.Timestamp getTime() {
		return time;
	}

	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "About [id=" + id + ", content=" + content + ", time=" + time + "]";
	}
	
	
}
