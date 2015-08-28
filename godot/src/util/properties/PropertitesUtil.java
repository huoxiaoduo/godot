package util.properties;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * properties工具类
 * @author wxj
 *
 */
public class PropertitesUtil
{

	private final static Log log = LogFactory.getLog(PropertitesUtil.class);
	
	private static Properties prop;

	
	static
	{
		init();
	}
	
	private static void init()
	{
		prop = new Properties();
		try
		{
			//加载src/下的config.properties
			InputStream bis = PropertitesUtil.class.getResourceAsStream("/config.properties");
			prop.load(bis);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 读一个值
	 * @param key 
	 * @param backupString 值为空时，返回这个值
	 * @return
	 */
	public static String readValue(String key)
	{
		String value = prop.getProperty(key);
//		log.info(key + "=" + value);
		return value;
	}
	
	/**
	 * 读一个值
	 * @param key 
	 * @param backupString 值为空时，返回这个值
	 * @return
	 */
	public static String readValue(String key,String backupString)
	{
		try
		{
			String value = prop.getProperty(key);
//			log.info(key + "=" + value);
			return value != null ? value : backupString;
		} catch (Exception e)
		{
			return backupString;
		}
	}
	
	/**
	 * 读取properties的全部信息
	 * @param filePath
	 * @return
	 */
	public static Map<String, String> readProperties() 
	{
		Enumeration en = prop.propertyNames();
		Map<String, String> map = new HashMap<String, String>();
		while (en.hasMoreElements())
		{
			String key = (String) en.nextElement();
			String value = prop.getProperty(key);
//			log.info(key + "=" + value);
			map.put(key, value);
		}
		return map;
	}
	
	public static void main(String[] args)
	{
		PropertitesUtil.readProperties();
	}

}
