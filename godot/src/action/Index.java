package action;

import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport {
	
	private String name = "";
	private String pwd = "";
	public String execute(){
		if(name.equals("admin") && pwd.equals("2015")){
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
