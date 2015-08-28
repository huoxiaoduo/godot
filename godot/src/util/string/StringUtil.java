package util.string;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class StringUtil {
	private static Logger logger = Logger.getLogger(StringUtil.class);
	
	public static String convert(String str){
		if(StringUtils.isNotBlank(str)){
		str = str.replace("\\", "\\\\");
		str = str.replace("'", "\\'");
		}else{
			str = "";
		}
		return str;
	}
	
	
	public static boolean isNotBlank(String str){
		boolean flag = false ;
		if(StringUtils.isNotBlank(str) && !str.equals("null")){
			flag = true ;
		}
		return flag ;
	}
	
	public static boolean isBlank(String str){
		boolean flag = false ;
		if(StringUtils.isBlank(str) || str.equals("null")){
			flag = true ;
		}
		return flag ;
	}
	
	
	/**
	 * 获取最多的前两个关键词
	 * @param list 所有关键词的集合
	 * @return 返回最大两个关键词 没有返回null
	 */
	public static String [] getHotKeyWords(List<String> list){
		String [] result = new String [] {"",""};
		if(list==null || list.size()<1){
			return result;
		}
		try {
			// 累加
			int i = 0 ;
			Map<String,Integer> map = new HashMap<String,Integer>();
			for (String str : list) {
				if(map.get(str)==null){
					map.put(str, 1);
				}else{
					String key = str ;
					int val = map.get(str);
					map.remove(str);
					map.put(key, val+1);
					i++;
				}
			}
			// 排序
			ArrayList<Entry<String,Integer>> l = new ArrayList<Entry<String,Integer>>(map.entrySet());    
			          
			Collections.sort(l, new Comparator<Map.Entry<String, Integer>>() {    
		            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {    
		                return (o2.getValue() - o1.getValue());    
		            }    
		    }); 
			
			// 构造结果
	       
	        if(l.size()>=1){
	        	result[0] =l.get(0).getKey();
	        }
	        if(l.size()>=2){
	        	result[1] =l.get(1).getKey();
	        }
	        
	        if(i==0){
	        	// 只取前两个
	        	result[0] = list.get(0);
	        	if(list.size()>=2){
	        		result[1] = list.get(1);
	        	}
	        	
	        }else if(i==1){
	        	// 第二个要替换
	        	result[1] = list.get(0);
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return result ;
	}
	
	
	public static String getJsonStr(String str){
		if(isNotBlank(str)){
			str = str.replace("\"", "'");
		}
		return str ;
	}

}
