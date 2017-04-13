package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;





public class BrowserFactory {
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browserName){
		
		if(browserName.equalsIgnoreCase("Firefox")){
			//ConfigDataProvider conf=new ConfigDataProvider();
			//System.setProperty("webdriver.gecko.driver",conf.getFirefoxPath());
			System.setProperty("webdriver.gecko.driver",DataProviderFactory.getConfig().getFirefoxPath());
			driver=new FirefoxDriver();		
		}
		
		else if(browserName.equalsIgnoreCase("Chrome")){
			//ConfigDataProvider conf=new ConfigDataProvider();
			//System.setProperty("webdriver.chrome.driver",conf.getChromePath());
			System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfig().getChromePath());
			driver=new ChromeDriver(); 
		}
		
		else if(browserName.equalsIgnoreCase("IE")){
			//ConfigDataProvider conf=new ConfigDataProvider();
			//System.setProperty("webdriver.ie.driver",conf.getIEPath());
			//System.setProperty("webdriver.gecko.driver",DataProviderFactory.getConfig().getIEPath());
		   driver=new InternetExplorerDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	public static void closeBrowser(WebDriver driver){
		driver.close();
		driver.quit();
	}

}
