package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRMLoginPage extends BasePage{

	public OrangeHRMLoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement txt_username;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txt_password;
	@FindBy(xpath="(//button[normalize-space()='Login'])[1]")
	WebElement btn_LoginButton;
	
	public void setUserName(String userName) {
		txt_username.sendKeys(userName);
		
	}
	public void setPassword(String password) {
		txt_password.sendKeys(password);
		
	}
	public void clickLoginBtn() {
		btn_LoginButton.click();
	}
}
