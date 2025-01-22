package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import PageObjects.AccountRegistrationpage;
import PageObjects.HomePage;
import Testbase.BaseClass;

public class TC001_AccountregistrationTest extends BaseClass {

	Logger logger = LogManager.getLogger(this.getClass());

	@Test(groups = { "Regression", "Master" })
	public void Verify_HomePage_Logo() throws InterruptedException {

		logger.info("**** Starting TC001 ****");
		try {
			HomePage hp = new HomePage(driver);
			hp.MyAccount();
			logger.info("**** Clicked on MyAccount TC001 ****");
			hp.Register();
			logger.info("**** Clicked on Registerbutton TC001 ****");

			AccountRegistrationpage regi = new AccountRegistrationpage(driver);
			Thread.sleep(3000);
			logger.info("**** Providing User Details TC001 ****");
			regi.setfirstname(randomstring().toUpperCase());
			regi.setlastname(randomstring().toUpperCase());
			regi.setEmail(randomstring() + "@gmail.com");
			regi.setTelephone(randomNumber());
			String password = randomNumber();
			regi.setPassword(password);
			regi.setConfirmPassword(password);
			regi.setCheckPolicy();
			regi.ContinueButton();
			logger.info("**** Validating Expected Message TC001 ****");

			String confmsg = regi.msgConfirmation();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");

			logger.info("Test passed");
		} 
		catch (Exception e)
		{
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		} 
	}

}
