package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import data.Site;
import db.MySQLUtil;

public class SiteDao {
	
	private static Logger logger = Logger.getLogger(SiteDao.class);
	
	/**
	 * 获取所有原始数据集合
	 * @return
	 */
	public static List<Site> getsites(){
		List<Site> list = new ArrayList<Site>();
		Connection con = null;
		Statement stmt = null;
		con = MySQLUtil.getConnection();
		try {
			stmt=con.createStatement();
			//获取用户列表
			ResultSet rst=stmt.executeQuery("select * from site");
			while(rst.next()){
				String id = rst.getString("id");
				String name = rst.getString("name");
				long mcookie = rst.getLong("mcookie");
				long uid = rst.getLong("uid");
				long uid_month = rst.getLong("uid_month");
				long mcookie_month = rst.getLong("mcookie_month");
				Site site = new Site();
				site.setId(id);
				site.setMcookie(mcookie);
				site.setName(name);
				site.setUid(uid);
				site.setUid_month(uid_month);
				site.setFtp(rst.getString("ftp"));
				site.setDate(rst.getString("date"));
				site.setMcookie_month(mcookie_month);
				list.add(site);
			}
			rst.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return  list;
	}
	
	public static Long  deleteSite(String id){
		long result = 0L;
		Connection conn = MySQLUtil.getConnection();
		String sql = "delete from site where id = '"+id+"'";
		try {
			Statement stmt=conn.createStatement();
			result = stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(sql);
			logger.error(e.getMessage());
		}
		return result;
	}
	
	public static Long  addSite(String id,String name){
		long result = 0L;
		Connection conn = MySQLUtil.getConnection();
		String sql = "insert into site (id,name,mcookie,uid,uid_month) VALUES ('"+id+"','"+name+"',0,0,0)";
		try {
			Statement stmt=conn.createStatement();
			result = stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(sql);
			logger.error(e.getMessage());
		}
		return result;
	}
	
	
	public static Site getsite(String siteId){
		Connection con = null;
		Statement stmt = null;
		con = MySQLUtil.getConnection();
		Site site = new Site();
		try {
			stmt=con.createStatement();
			//获取用户列表
			ResultSet rst=stmt.executeQuery("select * from site where id ='"+siteId+"'");
			if(rst.next()){
				String id = rst.getString("id");
				String name = rst.getString("name");
				long mcookie = rst.getLong("mcookie");
				long uid = rst.getLong("uid");
				long uid_month = rst.getLong("uid_month");
				long mcookie_month = rst.getLong("mcookie_month");
				site.setId(id);
				site.setMcookie(mcookie);
				site.setName(name);
				site.setUid(uid);
				site.setUid_month(uid_month);
				site.setFtp(rst.getString("ftp"));
				site.setDate(rst.getString("date"));
				site.setMcookie_month(mcookie_month);
			}
			rst.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return  site;
	}
	
	public static Long  updateSite(Site site){
		long result = 0L;
		Connection conn = MySQLUtil.getConnection();
		String sql = "UPDATE site SET `name` = '"+site.getName()+"',`ftp`='"+site.getFtp().trim()+"' WHERE id = '"+site.getId()+"' ";
		try {
			Statement stmt=conn.createStatement();
			result = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(sql);
			logger.error(e.getMessage());
		}
		return result;
	}
	
	
	public static List<Site> getHistorySite(String siteId){
		Connection con = null;
		Statement stmt = null;
		con = MySQLUtil.getConnection();
		List<Site> list = new ArrayList<Site>();
		try {
			stmt=con.createStatement();
			//获取用户列表
			ResultSet rst=stmt.executeQuery("select * from history where site_id ='"+siteId+"'");
			while(rst.next()){
				Site site = new Site();
				String id = rst.getString("site_id");
				long mcookie = rst.getLong("mcookie");
				long uid = rst.getLong("uid");
				long uid_month = rst.getLong("uid_month");
				long mcookie_month = rst.getLong("mcookie_month");
				site.setId(id);
				site.setMcookie(mcookie);
				site.setUid(uid);
				site.setUid_month(uid_month);
				site.setMcookie_month(mcookie_month);
				site.setDate(rst.getString("date"));
				list.add(site);
			}
			rst.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return  list;
	}
	
}
