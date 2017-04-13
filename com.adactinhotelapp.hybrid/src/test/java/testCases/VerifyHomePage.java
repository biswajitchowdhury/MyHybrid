package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import utilities.Reports;
import utilities.ScreenShotsUtilis;

//Verify the title of index page
public class VerifyHomePage {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger; 

	@BeforeMethod
	public void setUp() throws Exception{
		Reports.startingReports("./Reports/test_VerifyHomePage.html", true);
		Reports.startingTest("test_VerifyHomePage", "This page will verify the Page Title");
		//report = new ExtentReports("./Reports/VerifyHomePage-Report.html",true);
		//logger = new ExtentTest("VerifyHomePage","This page will verify the login steps");
		//logger=report.startTest("VerifyHomePage", "This page will verify the login steps"); 
		driver=BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
		Reports.logStatusINFO();
	}
	@Test
	public void test_VerifyHomePage(){
		HomePage index=PageFactory.initElements(driver, HomePage.class);
		String title=index.getAppTitle();
		Reports.logStatus1PASS();
		//logger.log(LogStatus.INFO, "Application is up and running");
		Assert.assertTrue(title.contains("AdactIn.com"));  
		//System.out.println("My Application Title is "+title);
		//logger.log(LogStatus.PASS, "Application is lunched successfully-Verified Title of Page");
		Reports.logStatus2PASS();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			String path=ScreenShotsUtilis.capture(driver, result.getName());
			Reports.logStatusFAIL(path); 
		}
		BrowserFactory.closeBrowser(driver);
		Reports.logEnds();
		
		//report.endTest(logger);
		//report.flush();	
	}
	
	

}
