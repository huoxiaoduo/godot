package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import action.base.BaseAction;
import dao.FtpHistoryDao;
import dao.SiteDao;
import data.FtpHistory;
import data.Site;

public class AddFtpHistory extends ActionSupport{
	
	private String siteId = ""; // cookiemapping 的  id
	private Long count = 0L;
	private String fileName  = "";
	private String date = "";
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println("to add ftp history ------------------------");
		Long result = 0L;
		if(!siteId.equals("") && !date.equals("")){
			FtpHistoryDao dao = new FtpHistoryDao();
			// 是否存在
			FtpHistory fh = null;
			if(fileName.equals("")){
				fh = dao.getFtpHistory(siteId, date);
			}else{
				fh = dao.getFtpHistory(siteId, fileName, date);
			}
			if(fh.getId()>0){
				dao.deleteFtpHistoryById(fh.getId());
			}
			result = dao.addFtpHistory(siteId, count, fileName, date);
		}
		try {
			response.getWriter().write(String.valueOf(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
