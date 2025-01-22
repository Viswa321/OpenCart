package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountloginpage extends BasePage{

	public Accountloginpage(WebDriver driver) {

		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	 WebElement txtEmailaddres;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnsubmit;

	
	
	public void Enteremail(String email) {

		txtEmailaddres.sendKeys(email);
	}
	
	public void Enterpassword(String password) {

		txtpassword.sendKeys(password);
	}
	
	public void clicksubmit() {

		btnsubmit.click();
	}
	
}
