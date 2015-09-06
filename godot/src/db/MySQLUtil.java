package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import data.Site;
import util.properties.PropertitesUtil;
import util.string.StringUtil;


public class MySQLUtil {
	
	private static Logger logger = Logger.getLogger(MySQLUtil.class);
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis()/1000);
	}
	
	public static Connection getConnection(){
		
		String user = PropertitesUtil.readValue("mysql.username");
		String password = PropertitesUtil.readValue("mysql.password");
		String ip = PropertitesUtil.readValue("mysql.ip");
		String port = PropertitesUtil.readValue("mysql.port");
		String db = PropertitesUtil.readValue("mysql.db");
		String url = "jdbc:mysql://"+ip+":"+port+"/"+db+"?useUnicode=true&characterEncoding=utf-8";
		
		Connection con = null ;
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = java.sql.DriverManager.getConnection(url,user,password);
		} catch (InstantiationException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return con ;
	}
	
	
	
	/**
	 * 更新网站的mcookie、uid、月匹配度 等数据
	 * @param site
	 * @return
	 */
	public static Long  updateSite(Site site){
		long result = 0L;
		Connection conn = getConnection();
		String sql = "UPDATE site SET `uid` = "+site.getUid()+",`mcookie`="+site.getMcookie()+",`uid_month`="+site.getUid_month()+" WHERE id = '"+site.getId()+"' ";
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
	public static Long  insert(String content,String datetimeStr,Connection connection){
		
		content = StringUtil.convert(content);
		long result = 0 ;
		Connection conn = connection;
		String sql = "insert into tb_news_content (news_content,news_time_level) values ('"+content+"','"+datetimeStr+"')";
		try {
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()){
				result = rs.getLong(1);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
			logger.error(sql);
			logger.error(e.getMessage());
		}
		
		
		return result;
	}
	
	
	public static Long  insertNews(String channel,String title,String keyword ,String sentence,String titleJson ,String keywodJson,String sentenceJson,String datetime ,Connection connection){
		title = StringUtil.convert(title);
		keyword = StringUtil.convert(keyword);
		sentence = StringUtil.convert(sentence);
		if(StringUtil.isNotBlank(sentence) && sentence.length()>200){
			sentence = sentence.substring(0, 200);
		}
		titleJson = StringUtil.convert(titleJson);
		keywodJson = StringUtil.convert(keywodJson);
		sentenceJson = StringUtil.convert(sentenceJson);
		
		Long  date = System.currentTimeMillis()/1000;
		
		long result = 0 ;
		Connection conn = connection;
		String sql = "insert into tb_event (event_title,event_keywords,event_longwords,event_channelcode," +
				"event_title_news,event_keywords_news,event_longwords_news,event_addtime,event_time_level" +
				") values ('"+title+"','"+keyword+"','"+sentence+"','"+channel+"','"+titleJson+"','"+keywodJson+"','"+sentenceJson+"',"+date+",'"+datetime+"')";
		try {
			Statement stmt=conn.createStatement();
			result = stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
			logger.error(sql);
			logger.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 删除昨天的数据
	 * @param date 时间前缀 eg 20150101
	 * @return
	 */
	public static long deleteYesterdayData(String date){
		long result = 0 ;
		Connection conn = MySQLUtil.getConnection();
		String sql = "delete from tb_event where event_time_level < '"+date+"2350'";
		String contentSql = "delete from tb_news_content where news_time_level < '"+date+"2350' or news_time_level is null";
		try {
			logger.info("del sql:"+sql);
			Statement stmt=conn.createStatement();
			result = stmt.executeUpdate(sql);
			result = stmt.executeUpdate(contentSql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
			logger.error(sql);
			logger.error(e.getMessage());
		}
		return result ;
	}

}
