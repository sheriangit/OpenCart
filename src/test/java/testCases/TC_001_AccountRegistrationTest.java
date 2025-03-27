package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test
	public void verify_account_registration()
	{
		
		logger.info("**** Starting TC_001_AccountRegistrationTest ****");
		
		try
		{
			HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("**** Clicked on My Account tab ****");
		hp.clickRegister();
		logger.info("**** Clicked on Register link ****");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("**** Providing registration details ****");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		logger.info("**** Validation expected message ****");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		}
		catch(Exception e)
		{
			logger.info("**** Test failed ****" );
			logger.debug("Debug Logs");
			Assert.fail();
		}
	
		logger.info("**** Completed TC_001_AccountRegistrationTest ****");
	}
	
	
	
	
	
}








