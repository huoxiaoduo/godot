package data;

public class Site {
	
	private String id = "";
	private String name = "";
	private long mcookie = 0L;
	private long uid = 0L;
	private long uid_month = 0L;
	private long mcookie_month = 0L;
	private String ftp = "0";
	private String date = "";
	
	private String mcookieMore = "";  // 多个 mcookie_month 用于页面显示
	
	
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
	public String getFtp() {
		return ftp;
	}
	public void setFtp(String ftp) {
		this.ftp = ftp;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getMcookie_month() {
		return mcookie_month;
	}
	public void setMcookie_month(long mcookie_month) {
		this.mcookie_month = mcookie_month;
	}
	public String getMcookieMore() {
		return mcookieMore;
	}
	public void setMcookieMore(String mcookieMore) {
		this.mcookieMore = mcookieMore;
	}
	
}
