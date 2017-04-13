package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	public ConfigDataProvider(){
		File src =new File("./Configuration/config.properties");
				
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
			
		}
	}
	
	public String getAppURL(){
		String url=pro.getProperty("url1");
		return url;
	}
	
	public String getApplicationURL(){
		String url=pro.getProperty("url");
		return url;
	}
	
	public String getChromePath(){
		String url=pro.getProperty("ChromePath");
		return url;
	}
	public String getIEPath(){
		String url=pro.getProperty("IEPath");
		return url;
	}
	public String getFirefoxPath(){
		String url=pro.getProperty("FirefoxPath");
		return url;
	}

}
