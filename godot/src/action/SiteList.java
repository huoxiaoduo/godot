package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.FtpHistoryDao;
import dao.SiteDao;
import data.FtpHistory;
import data.Site;

public class SiteList extends ActionSupport {
	
	List<Site> list = new ArrayList<Site>();
	String ftpCount = "0"; // 输出的用户数量：
	String mcookieCount = "0"; // mcookie 》 1000
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		if(session.getAttribute("user").equals("admin2015")){
			SiteDao siteDao = new SiteDao();
			list = siteDao.getsites();
			int fcount = 0 ;
			int mcount = 0 ;
			for (Site site : list) {
				if(site.getFtp().equals("1")){
					fcount++;
				}
				if(site.getMcookie()>1000){
					mcount++;
				}
			}
			ftpCount = String.valueOf(fcount);
			mcookieCount = String.valueOf(mcount);
			// reset mcookie month
			FtpHistoryDao fdao = new FtpHistoryDao();
			for (Site site : list) {
				List<FtpHistory> flist =  fdao.getFtpHistoryList(site.getId(),site.getDate());
				if(flist.size()==1){
					site.setMcookie_month(flist.get(0).getCount());
				}else if(flist.size() >= 1){
					site.setMcookie_month(-1);
					String mcookieMore = "";
					for (FtpHistory ftpHistory : flist) {
						mcookieMore = mcookieMore +","+ ftpHistory.getFileName()+":"+ftpHistory.getCount();
					}
					mcookieMore = mcookieMore.replaceFirst(",", "");
					site.setMcookieMore(mcookieMore);
				}else{
					site.setMcookie_month(0);
				}
			}
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

	public String getFtpCount() {
		return ftpCount;
	}

	public void setFtpCount(String ftpCount) {
		this.ftpCount = ftpCount;
	}

	public String getMcookieCount() {
		return mcookieCount;
	}

	public void setMcookieCount(String mcookieCount) {
		this.mcookieCount = mcookieCount;
	}
	
}
