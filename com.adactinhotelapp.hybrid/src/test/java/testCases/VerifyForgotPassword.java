package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import utilities.Reports;
import utilities.ScreenShotsUtilis;

public class VerifyForgotPassword {
	WebDriver driver;
	@BeforeMethod
	public void seUp(){
		Reports.startingReports("./Reports/test_VerifyForgotPassword.html", true);
		Reports.startingTest("test_VerifyForgotPassword", "LogIn Senario-Functional Testing");
		driver=BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
		Reports.logStatusINFO();
	}
	@Test
	public void test_VerifyForgotPassword(){
		HomePage index=PageFactory.initElements(driver, HomePage.class);
		boolean enableState=index.enabledForgotPassword();
		Reports.logStatusINFO();
		System.out.println(enableState);
		Assert.assertEquals(true, enableState); 
		Reports.logStatus1PASS();
	}
	

	@AfterMethod
	public void tearDown(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			String path=ScreenShotsUtilis.capture(driver, result.getName());
			Reports.logStatusFAIL(path); 
		}
		BrowserFactory.closeBrowser(driver);
		Reports.logEnds();
	
	}

}
