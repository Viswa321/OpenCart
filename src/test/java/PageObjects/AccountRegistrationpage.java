package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationpage extends BasePage {

	// Constructor
	public AccountRegistrationpage(WebDriver driver) {
		super(driver);

	}

	// WebElements
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkPolicy;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfiramtion;

	// Action Methods
	
	public void setfirstname(String firstname) {
		txtFirstname.sendKeys(firstname);
	}

	public void setlastname(String lastname) {
		txtLastname.sendKeys(lastname);
	}

	public void setEmail(String txtemail) {
		txtEmail.sendKeys(txtemail);
	}

	public void setTelephone(String EnterPhoneNumber) {
		txtTelephone.sendKeys(EnterPhoneNumber);
	}

	public void setPassword(String EnterPassword) {
		txtPassword.sendKeys(EnterPassword);
	}

	public void setConfirmPassword(String EnterConfirmPassword) {
		txtConfirmPassword.sendKeys(EnterConfirmPassword);
	}

	public void setCheckPolicy() {
		checkPolicy.click();
	}

	public void ContinueButton() {
		btnContinue.click();
	}

	public String msgConfirmation() {

		try {
			return (msgConfiramtion.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}

}
