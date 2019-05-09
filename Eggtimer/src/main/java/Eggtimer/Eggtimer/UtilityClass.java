package Eggtimer.Eggtimer;

import java.io.FileInputStream;
import java.util.Properties;

public class UtilityClass {
	public static String ReadPropertiesFile(String path,String key)
	{
		String val="";
		try{
		FileInputStream fi = new FileInputStream(path);
		 Properties pr = new Properties();
		 pr.load(fi);
		 val=pr.getProperty(key);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		 return val;
		
	}
}
