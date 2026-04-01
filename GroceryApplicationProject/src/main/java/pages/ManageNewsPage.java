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
	public void clickNewButtonOnManageNewsPage() {
		newbuttonManageNewsPage.click();
	}

	public void enterNewsTitleOnManageNewsInfoPage(String newsinfo) {
		textareaNewInfoPage.sendKeys(newsinfo);
	}

	public void clickSaveButtonOnManageNewsInfoPage() {
		savebuttonNewInfoPage.click();
	}

	public void clickCancelButtonOnManageNewsInfoPage() {
		cancelbuttonNewInfoPage.click();
	}

	// Search Button/page Functions-Manage News Page
	public void searchButtonOnManageNewsPage() {
		searchbuttonManageNewsPage.click();
	}

	public void enterTitleOnSearchManageNewsPage(String searchUserUsername) {
		titleSearchManageNewsPage.sendKeys(searchUserUsername);
	}

	public void clickOnSearchButtonOnSearchManageNewsPage() {
		searchbuttonSearchManageNewsPage.click();
	}

	public void clickOnResetButtonOnSearchManageNewsPage() {
		resetButtonSearchManageNewsPage.click();
	}

	// Reset button -ManageNewsPage function
	public void clickOnResetButtonManageNewsPage() {
		resetbuttonManageNewsPage.click();
	}

}
