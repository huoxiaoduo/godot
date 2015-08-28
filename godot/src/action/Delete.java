package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.SiteDao;

public class Delete extends ActionSupport {
	
	private String id = "";
	public String execute(){
		if(!id.equals("")){
			SiteDao siteDao = new SiteDao();
			SiteDao.deleteSite(id);
		}
		System.out.println("del ------------------");
		System.out.println(id);
		return NONE;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
