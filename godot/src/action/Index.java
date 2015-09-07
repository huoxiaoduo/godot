package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport {
	
	private String name = "";
	private String pwd = "";
	
	public String execute(){
		if(name.equals("admin") && pwd.equals("2015")){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			HttpSession session = request.getSession();
			session.setAttribute("user", "admin2015");
			return SUCCESS;
		}
		if(name.equals("")&&pwd.equals("")){
			return "login";
		}
		return ERROR;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
