package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import db.MySQLUtil;

public class IndustryDao {
	private static Logger logger = Logger.getLogger(IndustryDao.class);
	public static List<String> getIndustry(){
		List<String> list = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		con = MySQLUtil.getConnection();
		try {
			stmt=con.createStatement();
			//获取用户列表
			ResultSet rst=stmt.executeQuery("select * from industry");
			while(rst.next()){
				String content = rst.getString("content");
				list.add(content);
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
