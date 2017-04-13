package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.SignUp_Page;
import utilities.Reports;
import utilities.ScreenShotsUtilis;

public class VerifyPopUpTextNewUserRegistration {
	WebDriver driver; 
	String ExpectedText="Enter a combination of at least six numbers, letters and punctuation marks (like ! and &).";
	
	
	
	@BeforeMethod
	public void setUp(){
		Reports.startingReports("./Reports/test_VerifyPopUpTextNewUserRegistration.html", true);
		Reports.startingTest("test_VerifyPopUpTextNewUserRegistration", "LogIn Senario-Functional Testing");
		driver=BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getAppURL());
		Reports.logStatusINFO();	
	}
	@Test
	public void test_VerifyNewUserRegistration(){
		SignUp_Page sign=PageFactory.initElements(driver, SignUp_Page.class);
		sign.registrationData(
		 DataProviderFactory.getExcel().getData(1, 34, 4), 
		 DataProviderFactory.getExcel().getData(1, 35, 4),
	     DataProviderFactory.getExcel().getData(1, 36, 4));
		 Reports.logStatusINFO();
		 sign.dropDown(
		 DataProviderFactory.getExcel().getData(1, 37, 4), 
		 DataProviderFactory.getExcel().getData(1, 38, 4),
		 DataProviderFactory.getExcel().getData(1, 39,4));
		 Reports.logStatusINFO();
		 sign.clickonRadioButton();
		 Reports.logStatusINFO();
		 sign.selectedRadioButton();
		boolean button=sign.displayedRadioButton();
		//System.out.println(button);
		Reports.logStatusINFO();
		Assert.assertTrue(button);
		Reports.logStatus1PASS();
		sign.clickonCreateAccountButton();
		String text=sign.capturePopUpText();
		System.out.println(text);
		Assert.assertEquals(text, ExpectedText); 
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
