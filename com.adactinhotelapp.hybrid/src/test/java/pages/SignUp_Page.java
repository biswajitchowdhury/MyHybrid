package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUp_Page {
	
	WebDriver driver;
	public SignUp_Page(WebDriver driver){
		this.driver=driver;
	}
	@FindBy(xpath="//input[@name='firstname']") 
	WebElement firstName;
	@FindBy(xpath="//input[@name='lastname']") 
	WebElement lastName;
	@FindBy(xpath="//input[@name='reg_email__']") 
	WebElement mobileNumber;
	@FindBy(xpath="//select[@id='month']") 
	WebElement month;
	@FindBy(xpath="//select[@id='day']") 
	WebElement day;
	@FindBy(xpath="//select[@id='year']") 
	WebElement year;
	@FindBy(xpath="//input[@value='1']") 
	WebElement female;
	@FindBy(xpath="//input[@value='2']") 
	WebElement male;
	@FindBy(xpath="//button[text()='Create Account']") 
	WebElement createAccount; 
	@FindBy(xpath="//div[text()='Enter a combination of at least six numbers, letters and punctuation marks (like ! and &).']") 
	WebElement popUpText; 
	By femaleButton=By.xpath("//input[@value='1']");
	
	public void enterUserName(String fName){
		firstName.sendKeys(fName);
		
	}
	
	public void enterPassword(String lName){
		lastName.sendKeys(lName);
	}
	
	public void enterMobileNumber(String pNumber){
		mobileNumber.sendKeys(pNumber);
		
	}
	
	
	public void registrationData(String fName, String lName, String pNumber){
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		mobileNumber.sendKeys(pNumber);	
	}

	public void dropDown(String monthName, String dayValue, String yearValue){
		Select dropdown=new Select(month);
		dropdown.selectByVisibleText(monthName);
		dropdown=new Select(day);
		dropdown.selectByVisibleText(dayValue);
		dropdown=new Select(year);
		dropdown.selectByVisibleText(yearValue);
	
	}
	
	public void clickonRadioButton(){
		female.click();
	}
	
	
	public void clickonCreateAccountButton(){
		createAccount.click();
	}
	
	public String capturePopUpText(){
		return popUpText.getText();
	}
	
	public boolean selectedRadioButton(){
		return female.isSelected();
	
	}
	public boolean displayedRadioButton(){
		return female.isDisplayed();
	}
	
}
