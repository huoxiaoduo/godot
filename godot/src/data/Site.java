package data;

public class Site {
	
	private String id = "";
	private String name = "";
	private long mcookie = 0L;
	private long uid = 0L;
	private long uid_month = 0L;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMcookie() {
		return mcookie;
	}
	public void setMcookie(long mcookie) {
		this.mcookie = mcookie;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public long getUid_month() {
		return uid_month;
	}
	public void setUid_month(long uid_month) {
		this.uid_month = uid_month;
	}
}
