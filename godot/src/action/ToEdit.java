package action;

import action.base.BaseAction;
import dao.SiteDao;
import data.Site;

public class ToEdit extends BaseAction {
	
	private String id = "";
	private Site site = new Site();
	public String execute(){
		System.out.println("to edit ------------------------");
		if(!id.equals("")){
			SiteDao dao = new SiteDao();
			site = dao.getsite(id);
			if(id.equals(site.getId())){
				System.out.println("to edit is ok");
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	
}
