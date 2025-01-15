package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	

	@Test
	public void verify_account_registration() throws InterruptedException {
		try {
		logger.info("********Starting TC001_AccountRegistrationTest **********");
		HomePage _homePage=new HomePage(driver);
		AccountRegistrationPage _accountRegistrationPage=new AccountRegistrationPage(driver);
		_homePage.checkHomePage()
		.clickMyAccount()
		.clickRegister();
		logger.info("Clicked on Account button");
		_accountRegistrationPage.enterFirstName(randomString())
		.enterLastName(randomString())
		.enterEmailId(randomString()+"@gmail.com")
		.enterPassword(randomString())
		.clickAgreeCheckBox()
		.clickContinueButton();
		String actualConfirmationMessage=_accountRegistrationPage.getConfirmationMessage();
		Assert.assertEquals(actualConfirmationMessage, "Your Account Has Been Created!","Confirmation Message is not matched");
		logger.info("Account is created successfully");
		}
		catch(Exception e) {
		  logger.error("Test failed");
		  logger.trace("Trace logs....");
		  Assert.fail();
		}
		logger.info("********Finished TC001_AccountRegistrationTest **********");
	}
	

	

}
