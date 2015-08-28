package action;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import dao.IndustryDao;
import dao.SiteDao;
import data.Site;

public class IndustrytList extends ActionSupport {
	
	List<String> list = new ArrayList<String>();
	public String execute(){
		IndustryDao dao = new IndustryDao();
		list = dao.getIndustry();
		return SUCCESS;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
