package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminicon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and ./i[@class='ace-icon fa fa-power-off']]")
	WebElement logoutbutton;
	// adminslide -More info Webelement
	@FindBy(xpath = "//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' ]")
	WebElement adminslideMoreinfoicon;
	// ManageNewsslide -More info Webelement
	@FindBy(xpath = "//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement managenewsslideMoreinfoicon;
	// WebElement for text Sign in to start your session
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	WebElement signinText;

	public HomePage clickOnAdminProfileIcon() {
		adminicon.click();
		return this;
	}

	public LoginPage clickOnLogoutButton() {
		logoutbutton.click();
		return new LoginPage(driver);
	}

	public AdminPage clickOnMoreInfoIconOnAdminSlide() {
		adminslideMoreinfoicon.click();
		return new AdminPage(driver);
	}

	public ManageNewsPage clickOnMoreInfoIconOnManageNewsSlide() {
		managenewsslideMoreinfoicon.click();
		return new ManageNewsPage(driver);
	}

	public boolean issigninTextDisplayed() {
		return signinText.isDisplayed();
	}
}
