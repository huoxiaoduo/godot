package util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	
	public static void main(String[] args) {
		System.out.println(getYesterday());
	}
	
	public static String getYesterday(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		String yesterday = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
		return yesterday;
	}

}
