package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.SiteDao;
import data.Site;

public class Edit extends ActionSupport {
	
	private String name = "";
	private String ftp = "";
	private String id = "";
	public String execute(){
		System.out.println("edit ------------------------");
		if(!name.equals("") && !ftp.equals("")&&!id.equals("")){
			SiteDao siteDao = new SiteDao();
			Site site = siteDao.getsite(id);
			if(site.getId().equals(id)){
				site.setName(name);
				site.setFtp(ftp);
				SiteDao.updateSite(site);
				System.out.println("edit ok");
				return SUCCESS;
			}
			
		}
		return ERROR;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFtp() {
		return ftp;
	}
	public void setFtp(String ftp) {
		this.ftp = ftp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
