package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement Registerbutton;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement Loginbutton;
	
	

	public void MyAccount() {
		MyAccount.click();
	}
	
	public void Register() {
		Registerbutton.click();
	}
	
	public void login() {
		Loginbutton.click();
	}

}
