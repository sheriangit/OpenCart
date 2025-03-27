package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test
	public void verifyLogin() {

		logger.info("**** TC002 Login Test Started ***");
		try {
			// Home Page
			HomePage hp = new HomePage(driver);
			logger.info("Click on My Account tab");
			hp.clickMyAccount();
			logger.info("Click on Login tab");
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setpassword(p.getProperty("password"));
			lp.clickLogin();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean b = macc.isMyAccountPageExists();
			Assert.assertTrue(b);

		} 
		catch (Exception e) 
		{
			Assert.fail();
		}

	}

}
