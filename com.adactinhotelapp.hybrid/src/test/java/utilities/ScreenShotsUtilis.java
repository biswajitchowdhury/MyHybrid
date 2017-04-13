package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotsUtilis{
	static WebDriver driver;
	public static String capture(WebDriver driver, String screenShotName){	
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+screenShotName+System.currentTimeMillis()+".png");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			System.out.println("Failed to capture screenshots "+e.getMessage()); 
		}
		return screenShotName;			
			 
		}
}
