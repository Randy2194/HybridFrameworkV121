package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRMHomePage extends BasePage{

	public OrangeHRMHomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement dashboard_Header;
	@FindBy(xpath="//*[@class='oxd-userdropdown-name']")
	WebElement userIcon;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutBtn;
	@FindBy(xpath="//p[text()='Time at Work']")
	WebElement timetoWorkHeader;
	@FindBy(xpath="//p[text()='My Actions']")
	WebElement myActionsHeader;
	
	public boolean isDashboardDisplayed() {
		try {
			return (dashboard_Header.isDisplayed());
		}
		catch(Exception e)
		{
		 System.out.println(e);	
		 return false;
		}
	}
	public boolean isTimetoWorkHeaderDisplayed() {
		try {
			Thread.sleep(1000);
			return (timetoWorkHeader.isDisplayed());
		}
		catch(Exception e)
		{
		 System.out.println(e);	
		 return false;
		}
	}
	public boolean isMyActionsHeaderDisplayed() {
		try {
			Thread.sleep(1000);
			return (myActionsHeader.isDisplayed());
		}
		catch(Exception e)
		{
		 System.out.println(e);	
		 return false;
		}
	}
	
	public void clickUserIcon() throws InterruptedException {
		Thread.sleep(3000);
		userIcon.click();
	}
	public void clickLogoutButton() throws InterruptedException {
		Thread.sleep(3000);
		logoutBtn.click();
		
	}
}
