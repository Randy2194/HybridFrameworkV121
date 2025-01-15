package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.OrangeHRMHomePage;
import pageObjects.OrangeHRMLoginPage;
import testBase.BaseClass;

public class TC004_ValidateOrangeHRMDashboard extends BaseClass {
	@Test(groups="sanity")
	public void validateDashboard() {
		try {
		logger.info("******Validation Orange HRM Test********");
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
		SoftAssert sAssert=new SoftAssert();
		sAssert.assertTrue(orangeHome.isTimetoWorkHeaderDisplayed(),"Time to work Header not displayed");
		sAssert.assertTrue(orangeHome.isMyActionsHeaderDisplayed(),"Time to work Header not displayed");
		sAssert.assertAll();
		}
		catch(Exception e) {
			System.out.println(e);
			logger.error("error..");
			Assert.fail();
		}
		logger.info("******Finished Orange HRM Validation Test********");
	}

}
