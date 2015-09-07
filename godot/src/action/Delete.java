package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.SiteDao;

public class Delete extends ActionSupport {
	
	private String id = "";
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		if(!session.getAttribute("user").equals("admin2015")){
			return "home";
		}
		
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
