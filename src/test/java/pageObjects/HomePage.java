package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@title='Your Store']")
	WebElement homePageTitle;
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAcccount;
	@FindBy(xpath="//a[text()='Register']")
	WebElement register;
	
	public HomePage checkHomePage() {
		homePageTitle.isDisplayed();
		System.out.println("Title is displayed");
		return this;
	}
	public HomePage clickMyAccount() throws InterruptedException {
		Actions actions=new Actions(driver);
		actions.moveToElement(myAcccount).click().build().perform();
		Thread.sleep(10000);
		return this;
	}
	
	public HomePage clickRegister() throws InterruptedException {
		register.click();
		Thread.sleep(15000);
		return this;
	}
	

}
