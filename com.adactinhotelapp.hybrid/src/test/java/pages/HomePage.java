package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.Reports;


public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		
	}
	
	@FindBy(xpath="//a[text()='New User Register Here']") 
	    WebElement newUserRegisterLink;	
	@FindBy(xpath="//strong[text()='Go to Build 2']") 
	    WebElement buildTwo;
	@FindBy(xpath="//a[text()='Adactin.com']") 
	    WebElement adactinDrivingInnovationLink;
	@FindBy(xpath="//a[text()='Forgot Password?']") 
	    WebElement forgetPasswodLink;
	@FindBy(xpath="//input[@id='username']")
	    WebElement userName;
	@FindBy(xpath="//input[@id='password']") 
	    WebElement passWord;
	@FindBy(xpath="//input[@id='login']") 
	    WebElement Login;
	@FindBy(xpath="//td[text()='Invalid Login Details']") 
	    WebElement Text;
	By logoutlink=By.xpath("//a[text()='Logout']");
	By textElement=By.cssSelector(".auth_error>b");

	
	public void clickonnewUserRegisterLink(){
		newUserRegisterLink.click();
	}
	
	

	public void clickonbuildTwo(){
		buildTwo.click();
	}
	
	public void clickonadactinDrivingInnovationLink(){
		adactinDrivingInnovationLink.click();
	}
	
	public void clickonForgotPassword(){
		forgetPasswodLink.click();
	}
	public boolean enabledForgotPassword(){
		return forgetPasswodLink.isEnabled();
		
	}
	
	
	public String getAppTitle(){
		return driver.getTitle();
	}
	
	public void enterUserName(String user){
		userName.sendKeys(user);
		
	}
	
	public void enterPassword(String pass){
		passWord.sendKeys(pass);
	}
	
	public void loginApplication(String user,String pass){
		
		userName.sendKeys(user);
		passWord.sendKeys(pass);
		Login.click();
		Reports.logStatus1PASS();
	}
	public void verifylogoutLink(){
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(logoutlink));
		String text=ele.getText();
		Assert.assertEquals(text, "Logout","Logout link isn't verified");
	}
	public void verifyTextEleemnt(){
		String ExpectedValue="Mnvalid";
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(textElement));
		String CaptureValue=ele.getText();
		Assert.assertEquals(CaptureValue, ExpectedValue,"Value didn't get match");

	}
	
}
