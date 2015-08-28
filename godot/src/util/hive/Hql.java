package util.hive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Hql {
	
	public static String exec(String sql) throws Exception{
		String result = null;
		List<String> command = new ArrayList<String>();
		command.add("hive");
		command.add("-e");
		command.add(sql);
		
		ProcessBuilder hiveProcessBuilder = new ProcessBuilder(command);
		Process hiveProcess = hiveProcessBuilder.start();

		BufferedReader br = new BufferedReader(new InputStreamReader(hiveProcess.getInputStream()));
		if(br.readLine()!=null){
			result = br.readLine(); 
		}
		return result;
	}

	
	public static void t() throws Exception{
		String sql="select * from t_hxd_publicis_uid limit 10";
		List<String> command = new ArrayList<String>();
		command.add("hive");
		command.add("-e");
		command.add(sql);
		
		List<String> results = new ArrayList<String>();
		ProcessBuilder hiveProcessBuilder = new ProcessBuilder(command);
		Process hiveProcess = hiveProcessBuilder.start();

		BufferedReader br = new BufferedReader(new InputStreamReader(hiveProcess.getInputStream()));
		String data = null;
		if ((data = br.readLine()) != null) {
			results.add(data);
		}
	}

}
