package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ManageNewsPage
{
	public WebDriver driver;

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

	// Manage News Page -News button Functions
	public ManageNewsPage clickNewButtonOnManageNewsPage() {
		newbuttonManageNewsPage.click();
		return this;
	}

	public ManageNewsPage enterNewsTitleOnManageNewsInfoPage(String newsinfo) {
		textareaNewInfoPage.sendKeys(newsinfo);
		return this;
	}

	public ManageNewsPage clickSaveButtonOnManageNewsInfoPage() {
		savebuttonNewInfoPage.click();
		return this;
	}

	public ManageNewsPage clickCancelButtonOnManageNewsInfoPage() {
		cancelbuttonNewInfoPage.click();
		return this;
		
	}

	// Search Button/page Functions-Manage News Page
	public ManageNewsPage clickOnSearchButtonOnManageNewsPage() {
		searchbuttonManageNewsPage.click();
		return this;
	}

	public ManageNewsPage enterTitleOnSearchManageNewsPage(String searchUserUsername) {
		titleSearchManageNewsPage.sendKeys(searchUserUsername);
		return this;
	}

	public ManageNewsPage clickOnSearchButtonOnSearchManageNewsPage() {
		searchbuttonSearchManageNewsPage.click();
		return this;
	}

	public ManageNewsPage clickOnResetButtonOnSearchManageNewsPage() {
		resetButtonSearchManageNewsPage.click();
		return this;
	}

	// Reset button -ManageNewsPage function
	public ManageNewsPage clickOnResetButtonManageNewsPage() {
		resetbuttonManageNewsPage.click();
		return this;
	}

}
