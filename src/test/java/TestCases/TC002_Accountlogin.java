package TestCases;

import java.io.EOFException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Accountloginpage;
import PageObjects.HomePage;
import PageObjects.MyAccountPage;
import Testbase.BaseClass;

public class TC002_Accountlogin extends BaseClass {

	@Test(groups = {"sanitytests","Master"})
	public void verify_Loginpage() {
		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.MyAccount();
			hp.login();

			// Loginpage
			Accountloginpage lp = new Accountloginpage(driver);
			lp.Enteremail(p.getProperty("email"));
			lp.Enterpassword(p.getProperty("password"));
			lp.clicksubmit();

			// MyAccountPage
			MyAccountPage mc = new MyAccountPage(driver);
			boolean targetpage = mc.isAccountpageExits();
			// Assert.assertEquals(targetpage, true, "Login failed");
			Assert.assertTrue(targetpage);
		} catch (Exception e) {

			Assert.fail();
		}
	}

}
