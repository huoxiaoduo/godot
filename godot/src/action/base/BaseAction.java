package action.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class BaseAction extends ActionSupport implements Preparable,ServletRequestAware, ServletResponseAware {
	
	public HttpServletResponse response;
	public HttpServletRequest request;
	public HttpSession session;
	//清空js，css缓存
	public String cleancache;
	//token 
	public String token;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}

	@Override
	public void prepare() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		if(!session.getAttribute("user").equals("admin2015")){
			try {
				response.sendRedirect("/");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getCleancache() {
		return cleancache;
	}

	public void setCleancache(String cleancache) {
		this.cleancache = cleancache;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
