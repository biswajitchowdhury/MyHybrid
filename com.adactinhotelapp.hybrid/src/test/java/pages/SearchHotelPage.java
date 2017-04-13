package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Reports;

public class SearchHotelPage {
	WebDriver driver;
	
	public SearchHotelPage(WebDriver driver){
	this.driver=driver;	
	}
	@FindBy(xpath="//a[text()='Logout']") WebElement logoutLink;
	
	public void clickonlogoutLink(){
		logoutLink.click();
		Reports.logStatus1PASS();
	}


}
