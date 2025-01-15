package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id='input-firstname']")
	WebElement firstNameTxtBox;
	@FindBy(xpath="//*[@id='input-lastname']")
	WebElement lastNameTxtBox;
	@FindBy(xpath="//*[@id='input-email']")
	WebElement emailTxtBox;
	@FindBy(xpath="//*[@id='input-password']")
	WebElement passwordTxtBox;
	@FindBy(xpath="//*[@name='agree']")
	WebElement agreeCheckBox;
	@FindBy(xpath="//*[@type='submit']")
	WebElement continueButton;
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created')]")
	WebElement confirmationMessage;
	
	@FindBy(xpath="//*[text()='Edit Account']")
	WebElement editAccount;
	@FindBy(xpath="//*[text()='Your Personal Details']")
	WebElement personalDetailsHeader;
	
	public AccountRegistrationPage enterFirstName(String fName) {
		firstNameTxtBox.sendKeys(fName);
		System.out.println("First Name is entered");
		return this;
	}
	public AccountRegistrationPage enterLastName(String lName) {
		lastNameTxtBox.sendKeys(lName);
		return this;
	}
	
	public AccountRegistrationPage enterEmailId(String email) {
		emailTxtBox.sendKeys(email);
		return this;
	}
	
	public AccountRegistrationPage enterPassword(String password) {
		passwordTxtBox.sendKeys(password);
		return this;
	}
	public AccountRegistrationPage clickAgreeCheckBox() throws InterruptedException {
		Thread.sleep(2000);
		Actions actions=new Actions(driver);
		actions.moveToElement(agreeCheckBox).click().build().perform();
		System.out.println("Clicked on Agree");
		
		return this;
	}
	public AccountRegistrationPage clickContinueButton() {
		continueButton.click();
		return this;
	}
	public String getConfirmationMessage() throws InterruptedException {
		Thread.sleep(10000);
		try {
			return confirmationMessage.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public AccountRegistrationPage clickEditProfile() throws InterruptedException 
	{
		editAccount.click();
		Thread.sleep(3000);
		return this;
	}
	public AccountRegistrationPage checkAccountInformationHeader() throws InterruptedException 
	{
		personalDetailsHeader.isDisplayed();
		Thread.sleep(3000);
		System.out.println("Edit Account Information page is displayed");
		return this;
	}
}
