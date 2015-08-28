package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.SiteDao;

public class Add extends ActionSupport {
	
	private String name = "";
	private String id = "";
	public String execute(){
		System.out.println("add ------------------------");
		if(!name.equals("") && !id.equals("")){
			SiteDao siteDao = new SiteDao();
			siteDao.addSite(id, name);
			System.out.println("add ok");
		}
		
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
