package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import data.FtpHistory;
import data.Site;
import db.MySQLUtil;

public class FtpHistoryDao {
	
	private static Logger logger = Logger.getLogger(FtpHistoryDao.class);
	
	/**
	 * 添加历史数据
	 * @param siteId
	 * @param count
	 * @param fileName
	 * @param date
	 * @return
	 */
	public static Long  addFtpHistory(String siteId,Long count,String fileName,String date){
		long result = 0L;
		Connection conn = MySQLUtil.getConnection();
		String sql = "insert into ftp_history (site_id,count,file_name,date) VALUES ('"+siteId+"',"+count+",'"+fileName+"','"+date+"')";
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
	
	public static Long deleteFtpHistory(String siteId,String fileName,String date){
		long result = 0L;
		Connection conn = MySQLUtil.getConnection();
		String sql = "delete from ftp_history where date = '"+date+"' and site_id='"+siteId+"' and file_name='"+fileName+"'";
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
	
	public static Long deleteFtpHistoryById(long id){
		long result = 0L;
		Connection conn = MySQLUtil.getConnection();
		String sql = "delete from ftp_history where id ="+id;
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
	
	public static FtpHistory getFtpHistory(String siteId,String fileName,String date){
		FtpHistory fh = new FtpHistory();
		Connection con = null;
		Statement stmt = null;
		con = MySQLUtil.getConnection();
		try {
			stmt=con.createStatement();
			//获取用户列表
			ResultSet rst=stmt.executeQuery("select * from ftp_history where site_id ='"+siteId+"' and `date`='"+date+"' and file_name='"+fileName+"'");
			if(rst.next()){
				long id = rst.getLong("id");
				fh.setId(id);
			}
			rst.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return fh;
	}
	
	public static FtpHistory getFtpHistory(String siteId,String date){
		FtpHistory fh = new FtpHistory();
		Connection con = null;
		Statement stmt = null;
		con = MySQLUtil.getConnection();
		try {
			stmt=con.createStatement();
			//获取用户列表
			ResultSet rst=stmt.executeQuery("select * from ftp_history where site_id ='"+siteId+"' and `date`='"+date+"'");
			if(rst.next()){
				long id = rst.getLong("id");
				fh.setId(id);
			}
			rst.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return fh;
	}
	
	
	/**
	 * 查询列表页面使用
	 * 
	 * @param siteId
	 * @param date
	 * @return
	 */
	public static List<FtpHistory> getFtpHistoryList(String siteId,String date){
		List<FtpHistory> list = new ArrayList<FtpHistory>();
		Connection con = null;
		Statement stmt = null;
		con = MySQLUtil.getConnection();
		try {
			stmt=con.createStatement();
			//获取用户列表
			ResultSet rst=stmt.executeQuery("select * from ftp_history where site_id ='"+siteId+"' and `date`='"+date+"'");
			while(rst.next()){
				FtpHistory fh = new FtpHistory();
				long id = rst.getLong("id");
				fh.setId(id);
				fh.setCount(rst.getLong("count"));
				fh.setDate(rst.getString("date"));
				fh.setFileName(rst.getString("file_name"));
				fh.setSiteId(rst.getString("site_id"));
				list.add(fh);
			}
			rst.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return list;
	}
	
	
	public static List<FtpHistory> getFtpHistoryListById(String siteId){
		List<FtpHistory> list = new ArrayList<FtpHistory>();
		Connection con = null;
		Statement stmt = null;
		con = MySQLUtil.getConnection();
		try {
			stmt=con.createStatement();
			//获取用户列表
			ResultSet rst=stmt.executeQuery("select * from ftp_history where site_id ='"+siteId+"'");
			while(rst.next()){
				FtpHistory fh = new FtpHistory();
				long id = rst.getLong("id");
				fh.setId(id);
				fh.setCount(rst.getLong("count"));
				fh.setDate(rst.getString("date"));
				fh.setFileName(rst.getString("file_name"));
				fh.setSiteId(rst.getString("site_id"));
				list.add(fh);
			}
			rst.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return list;
	}
	
}
