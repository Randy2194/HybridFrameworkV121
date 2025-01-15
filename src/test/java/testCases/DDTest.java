package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OrangeHRMHomePage;
import pageObjects.OrangeHRMLoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class DDTest extends BaseClass{
	
	
	
@Test (dataProvider="loginData", dataProviderClass =DataProviders.class)//getting data from different class
public void verifyLoginDDTest(String username,String password,String result) throws InterruptedException {
	logger.info("******Starting Orange HRM DD login Test********");
	OrangeHRMLoginPage page=new OrangeHRMLoginPage(driver);
	Thread.sleep(3000);
	page.setUserName(username);
	Thread.sleep(3000);
	page.setPassword(password);
	Thread.sleep(3000);
	page.clickLoginBtn();
	logger.info("Clicked on login button");
	OrangeHRMHomePage orangeHome=new OrangeHRMHomePage(driver);
	boolean status=orangeHome.isDashboardDisplayed();
	if(result.equalsIgnoreCase("valid")) {
		if(status==true) {
			orangeHome.clickUserIcon();
			orangeHome.clickLogoutButton();
			logger.info("Login success Validation passed");
			Assert.assertTrue(true);
			
		}
		else {
			logger.info("Login failed Validation failed");
			Assert.assertTrue(false);
			
		}
	}
	if(result.equalsIgnoreCase("invalid")) {
		if(status==true) {
			orangeHome.clickUserIcon();
			orangeHome.clickLogoutButton();
			logger.info("Login success Validation failed");
			Assert.assertTrue(false);
		}
		else {
			logger.info("Login failed Validation success");
			Assert.assertTrue(true);
		}
	}
	
	
	
	
}

}
