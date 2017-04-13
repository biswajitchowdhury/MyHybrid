package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import utilities.*;

public class VerifyInvalidUserLogIn{
	WebDriver driver;
	
	@BeforeMethod
	public void seUp(){
		Reports.startingReports("./Reports/test_InvalidUserLogIn.html",true);
		Reports.startingTest("test_InvalidUserLogIn", "Login Senario-Negative Testing");
		driver=BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
		Reports.logStatusINFO();
	}
	@Test
	public void test_InvalidUserLogIn(){
		HomePage index=PageFactory.initElements(driver, HomePage.class);
		String title=index.getAppTitle();
		//Reports.captureScreenshot1();
		Reports.logStatus1PASS();
		Assert.assertTrue(title.contains("AdactIn.com")); 
		index.loginApplication(DataProviderFactory.getExcel().getData("Sheet2", 21, 4),
				                                   DataProviderFactory.getExcel().getData("Sheet2", 22, 4));
		index.verifyTextEleemnt();
		//Reports.captureScreenshot2();
		Reports.logStatus2PASS();
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			String path=ScreenShotsUtilis.capture(driver,result.getName());
			Reports.logStatusFAIL(path);
		}
		BrowserFactory.closeBrowser(driver);
		Reports.logEnds();
	}

}
