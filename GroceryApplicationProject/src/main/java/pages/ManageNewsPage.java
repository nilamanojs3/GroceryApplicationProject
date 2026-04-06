package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;


public class ManageNewsPage
{
	public WebDriver driver;
	WaitUtility wait=new WaitUtility();//Wait utility object
	PageUtility page=new PageUtility();
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// ManageNews-New NewsPage WebElements
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/news/add' and @class='btn btn-rounded btn-danger'] ")
	WebElement newbuttonManageNewsPage;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement textareaNewInfoPage;
	@FindBy(xpath = "//div[@class='card-footer']//child::button[@type='submit' and @name='create']")
	WebElement savebuttonNewInfoPage;
	@FindBy(xpath = "//div[@class='card-footer']//child::a[@href='https://groceryapp.uniqassosiates.comadmin/list-news' and @type='button']")
	WebElement cancelbuttonNewInfoPage;
	
	// SearchManageNewspageWebElements
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@class='btn btn-rounded btn-primary' and @href='javascript:void(0)'] ")
	WebElement searchbuttonManageNewsPage;
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement titleSearchManageNewsPage;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchbuttonSearchManageNewsPage;
	@FindBy(xpath = "//div[@class='card-body']//child::a[@type='button' and @href='https://groceryapp.uniqassosiates.com/admin/list-news'] ")
	WebElement resetButtonSearchManageNewsPage;
	
	// Resetbutton ManageNews PageWebElements
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@class='btn btn-rounded btn-warning' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']  ")
	WebElement resetbuttonManageNewsPage;
	
	//webelement for manage newstext
	@FindBy(xpath = "//h4[text()='Manage News']")WebElement managenewstxt;

	// Manage News Page -News button Functions
	public ManageNewsPage clickNewButtonOnManageNewsPage() {
		wait.waitUntilElementToBeClickable(driver, newbuttonManageNewsPage);
		newbuttonManageNewsPage.click();
		return this;
	}

	public ManageNewsPage enterNewsTitleOnManageNewsInfoPage(String newsinfo) {
		textareaNewInfoPage.sendKeys(newsinfo);
		return this;
	}

	public ManageNewsPage clickSaveButtonOnManageNewsInfoPage() {
		wait.waitUntilElementToBeClickable(driver, savebuttonNewInfoPage);
		savebuttonNewInfoPage.click();
		return this;
	}

	public ManageNewsPage clickCancelButtonOnManageNewsInfoPage() {
		wait.waitUntilElementToBeClickable(driver, cancelbuttonNewInfoPage);
		cancelbuttonNewInfoPage.click();
		return this;
		
	}

	// Search Button/page Functions-Manage News Page
	public ManageNewsPage clickOnSearchButtonOnManageNewsPage() {
		wait.waitUntilElementToBeClickable(driver, searchbuttonManageNewsPage);
		searchbuttonManageNewsPage.click();
		return this;
	}

	public ManageNewsPage enterTitleOnSearchManageNewsPage(String searchUserUsername) {
		titleSearchManageNewsPage.sendKeys(searchUserUsername);
		return this;
	}

	public ManageNewsPage clickOnSearchButtonOnSearchManageNewsPage() {
		wait.waitUntilElementToBeClickable(driver, searchbuttonSearchManageNewsPage);
		searchbuttonSearchManageNewsPage.click();
		return this;
	}

	public ManageNewsPage clickOnResetButtonOnSearchManageNewsPage() {
		wait.waitUntilElementToBeClickable(driver, resetButtonSearchManageNewsPage);
		resetButtonSearchManageNewsPage.click();
		return this;
	}

	// Reset button -ManageNewsPage function
	public ManageNewsPage clickOnResetButtonManageNewsPage() {
		wait.waitUntilElementToBeClickable(driver, resetbuttonManageNewsPage);
		resetbuttonManageNewsPage.click();
		return this;
	}
	
	public boolean isManageNewsTextDisplayed() {
		wait.waitUntilTextIsLocated(driver, managenewstxt);
		return managenewstxt.isDisplayed();

	}
	
	public boolean isNewsTextAreaDisplayed() {
		wait.waitUntilElementToBeVisible(driver, textareaNewInfoPage);
		return textareaNewInfoPage.isDisplayed();

	}
}
