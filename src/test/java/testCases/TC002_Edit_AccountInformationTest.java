package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import testBase.BaseClass;

public class TC002_Edit_AccountInformationTest extends BaseClass{
@Test
public void editAccountDetails() throws InterruptedException {
	AccountRegistrationPage _accountRegistrationPage=new AccountRegistrationPage(driver);
	_accountRegistrationPage.clickEditProfile()
	.checkAccountInformationHeader();
}
}
