package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[@id='content']/h2[1]")
	WebElement txtAccountHeading;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']") //added in step num 6
	WebElement logout;

	public boolean isAccountpageExits() {
		try {
			return (txtAccountHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}
	
	public void clickLogout() {
		logout.click();
	}

}
