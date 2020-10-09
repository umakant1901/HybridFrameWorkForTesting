package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	
	public ReadConfig()
	{
		
		File src=new File("./Configurations/config.properties");
		
		try
		{
			
			FileInputStream fis=new FileInputStream(src);
			properties=new Properties();
			properties.load(fis);
		} 
		catch (Exception e)
		{
			e.getStackTrace();
		}
		
	}
	
	public String getURL()
	{
		String url=properties.getProperty("baseURL");
		return url;
	}
	
	
	public String getLoginUserName()
	{
		String user_name=properties.getProperty("loginUserName");
		return user_name;
	}
	
	public String getLoginPassword()
	{
		String pwd=properties.getProperty("loginPassword");
		return pwd;
	}
	
	public String getChromePath()
	{
		String chromePath=properties.getProperty("ChromePath");
		return chromePath;
	}
	
	public String getFireFoxPath()
	{
		String firefoxPath=properties.getProperty("FireFoxPath");
		return firefoxPath;
	}
	
	public String getIEPath()
	{
		String iePath=properties.getProperty("IEPath");
		return iePath;
	}
}
