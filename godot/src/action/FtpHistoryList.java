package action;

import java.util.ArrayList;
import java.util.List;

import action.base.BaseAction;
import dao.FtpHistoryDao;
import dao.SiteDao;
import data.FtpHistory;
import data.Site;

public class FtpHistoryList extends BaseAction {
	
	private String id = "";
	private List<FtpHistory> list = new ArrayList<FtpHistory>();
	public String execute(){
		if(!id.equals("")){
			FtpHistoryDao fdao = new FtpHistoryDao();
//			list = dao.getHistorySite(id);
			list = fdao.getFtpHistoryListById(id);
			if(list.size()>0){
				
			}
		}
		return SUCCESS;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public List<FtpHistory> getList() {
		return list;
	}

	public void setList(List<FtpHistory> list) {
		this.list = list;
	}
	
	
}
