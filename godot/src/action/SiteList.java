package action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import dao.SiteDao;
import data.Site;

public class SiteList extends ActionSupport {
	
	List<Site> list = new ArrayList<Site>();
	public String execute(){
		SiteDao siteDao = new SiteDao();
		list = siteDao.getsites();
		return SUCCESS;
	}

	public List<Site> getList() {
		return list;
	}

	public void setList(List<Site> list) {
		this.list = list;
	}

}
