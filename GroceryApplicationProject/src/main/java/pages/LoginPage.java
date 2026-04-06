package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage

{
	public WebDriver driver;
	WaitUtility wait=new WaitUtility();//Wait utility object
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement usernamefield;
	@FindBy(name = "password")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signinbutton;
//webelement for dashboard slide
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	// Webelement for text 7rmart supermarket
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement pageText;
	// WebElement for text Sign in to start your session
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	WebElement signinText;

	public LoginPage enterUsernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage clickSigninButton() {
		wait.waitUntilElementToBeClickable(driver, signinbutton);//applying wait before click action
		signinbutton.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplayed() {
		wait.waitUntilElementToBeVisible(driver, dashboard);
		return dashboard.isDisplayed();
	}

	public String getPageText() {
		return pageText.getText();
	}

	public boolean issigninTextDisplayed() {
		wait.waitUntilTextIsLocated(driver, signinText);
		return signinText.isDisplayed();
	}

}
