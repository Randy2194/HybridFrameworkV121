package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OrangeHRMHomePage;
import pageObjects.OrangeHRMLoginPage;
import testBase.BaseClass;

public class TC003_LoginOrangeHRMTest extends BaseClass {
	
	@Test(groups="sanity")
	public void loginOrangeHRM() {
		try {
		logger.info("******Starting Orange HRM login Test********");
		OrangeHRMLoginPage page=new OrangeHRMLoginPage(driver);
		Thread.sleep(3000);
		System.out.println("Username==== "+prop.getProperty("username"));
		System.out.println("Username==== "+prop.getProperty("password"));
		page.setUserName(prop.getProperty("username"));
		Thread.sleep(3000);
		page.setPassword(prop.getProperty("password"));
		Thread.sleep(3000);
		page.clickLoginBtn();
		logger.info("Clicked on login button");
		OrangeHRMHomePage orangeHome=new OrangeHRMHomePage(driver);
		Assert.assertTrue(orangeHome.isDashboardDisplayed(),"Login failed");
		logger.info("Login Success");
		}
		catch(Exception e) {
			System.out.println(e);
			logger.error("error..");
			Assert.fail();
		}
		logger.info("******Finished Orange HRM login Test********");
	}

}
