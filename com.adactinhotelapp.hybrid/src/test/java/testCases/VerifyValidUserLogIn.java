package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.SearchHotelPage;
import utilities.Reports;
import utilities.ScreenShotsUtilis;

/* Check the user are able to login in www.adactin.com/HotelApp with valid credential &
 *  Verify the Logout Link.
 */
public class VerifyValidUserLogIn{
WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception{
		Reports.startingReports("./Reports/test_ValidUserLogIn.html",true);
		Reports.startingTest("test_ValidUserLogIn", "LogIn Senario -Positive Testing");
		driver=BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
		Reports.logStatusINFO();
	}
	@Test
	public void test_ValidUserLogIn(){
		HomePage index=PageFactory.initElements(driver, HomePage.class);
		String title=index.getAppTitle();
		Assert.assertTrue(title.contains("AdactIn.com"));
		index.loginApplication(DataProviderFactory.getExcel().getData(1, 10, 4),
												 DataProviderFactory.getExcel().getData(1, 11, 4));
		index.verifylogoutLink();
		Reports.logStatus1PASS();
		SearchHotelPage search=PageFactory.initElements(driver, SearchHotelPage.class);
		search.clickonlogoutLink();
		
		//System.out.println("My Application Title is "+title);
		
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
