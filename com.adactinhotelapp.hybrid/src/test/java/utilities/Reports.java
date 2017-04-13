package utilities;



import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {
	static ExtentReports report;
	static ExtentTest logger;
	static WebDriver driver;
	
	// Report for Log Start
	public static void startingReports(String one, boolean two) {
		report = new ExtentReports(one,two);
		//logger=report.startTest("test_InvalidUserLogIn", "This page will verify the login steps");	
}
	public static void startingTest(String one, String two){
		logger=report.startTest(one,two);
	}
	// Report for Log INFO
	public static void logStatusINFO(){
		logger.log(LogStatus.INFO, "This Step is Executed Successfully as Expected.");

	}
	
	public static void logStatus1PASS(){ // Report for FIRST  Verification.
		logger.log(LogStatus.PASS, "Verification=1 is Successfull.");

	}
	
	public static void captureScreenshot1(){ // ScreenShot for FIRST  Verification.
		logger.log(LogStatus.INFO, logger.addScreenCapture(ScreenShotsUtilis.capture(driver, "Verification=1 is Successfull.")));

	}
	
	public static void logStatus2PASS(){ // Report for SECOND  Verification.
		logger.log(LogStatus.PASS, "Verification=2 is Successfull.");

	}
	public static void captureScreenshot2(){ // ScreenShot for SECOND  Verification.
		logger.log(LogStatus.INFO, logger.addScreenCapture(ScreenShotsUtilis.capture(driver, "Verification=2 is Successfull.")));

	}
	
	public static void logStatus3PASS(){ // Report for THIRD  Verification.
		logger.log(LogStatus.PASS, "Verification=3 is Successfull.");

	}
	public static void captureScreenshot3(){ // ScreenShot for THIRD  Verification.
		logger.log(LogStatus.INFO, logger.addScreenCapture(ScreenShotsUtilis.capture(driver, "Verification=3 is Successfull.")));

	}
	// Report for Log Fail
	public static void logStatusFAIL(String path){
		logger.log(LogStatus.FAIL,logger.addScreenCapture(path)); 

	}
	// Report for Log Skip
	public static void logStatusSKIP(){
		logger.log(LogStatus.SKIP, "");

	}
	// Report for Log Unknown
	public static void logStatusUNKNOWN(){
		logger.log(LogStatus.UNKNOWN, "");

	}
	
	// Report for Log Warning
	public static void logStatusWARNING(){
		logger.log(LogStatus.WARNING, "");

	}
	
	// Report for Log End
	public static void logEnds(){
		report.endTest(logger);
		report.flush();

	}
	
	
	
}