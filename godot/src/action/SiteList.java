package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.SiteDao;
import data.Site;

public class SiteList extends ActionSupport {
	
	List<Site> list = new ArrayList<Site>();
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		if(session.getAttribute("user").equals("admin2015")){
			SiteDao siteDao = new SiteDao();
			list = siteDao.getsites();
			return SUCCESS;
		}
		return "home";
	}

	public List<Site> getList() {
		return list;
	}

	public void setList(List<Site> list) {
		this.list = list;
	}

}
