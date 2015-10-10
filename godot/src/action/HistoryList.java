package action;

import java.util.ArrayList;
import java.util.List;

import action.base.BaseAction;
import dao.SiteDao;
import data.Site;

public class HistoryList extends BaseAction {
	
	private String id = "";
	private List<Site> list = new ArrayList<Site>();
	public String execute(){
		if(!id.equals("")){
			SiteDao dao = new SiteDao();
			list = dao.getHistorySite(id);
			if(list.size()>0){
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

	public List<Site> getList() {
		return list;
	}

	public void setList(List<Site> list) {
		this.list = list;
	}
	
}
