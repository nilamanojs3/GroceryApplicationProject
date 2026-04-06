package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminPage

{
	public WebDriver driver;
	WaitUtility wait=new WaitUtility();//Wait utility object
	PageUtility page=new PageUtility();
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// AdminUserNewUserWebElements
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@href='javascript:void(0)' and @class='btn btn-rounded btn-danger'] ")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id=\"username\"]")
	WebElement newUserUsernamefield;
	@FindBy(xpath = "//input[@id='password']")
	WebElement newUserPasswordfield;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement newUserUserTypefield;
	@FindBy(xpath = "//div[@class='card-footer center']//child::button[@type='submit']")
	WebElement newUserSavebutton;
	@FindBy(xpath = "//div[@class='card-footer center']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement newUserResetbutton;
	// SearchAdminUserpageWebElements
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@href='javascript:void(0)' and @class='btn btn-rounded btn-primary'] ")
	WebElement searchbutton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement searchAdminUserUsernamefield;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement searchAdminUserUserTypefield;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchAdminUserSearchButton;
	@FindBy(xpath = "//div[@class='card-body']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-default btn-fix']")
	WebElement searchAdminUserResetButton;
	// ResetAdminUserpageWebElements
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning'] ")
	WebElement resetbutton;
	
	//WebElement for admin user second header for checking assertion
	@FindBy(xpath = "//h4[text()='Admin Users']")WebElement adminusr;

	// NewUserFunctions-AdminPage
	public AdminPage clickNewButtonOnAdminPage() {
		wait.waitUntilElementToBeClickable(driver, newbutton);
		newbutton.click();
		return this;
	}

	public AdminPage enterUsernameOnUsernameFieldOnNewUserPage(String newUserusername) {
		newUserUsernamefield.sendKeys(newUserusername);
		return this;
	}

	public AdminPage enterUsernameOnPasswordFieldOnNewUserPage(String newUserpassword) {
		newUserPasswordfield.sendKeys(newUserpassword);
		return this;
	}

	public AdminPage selectUserTypeDropDownonNewUserPage() {
		wait.waitUntilElementToBeClickable(driver, newUserUserTypefield);
		newUserUserTypefield.click();
		return this;
	}

	public AdminPage selectDropDownOptionStaffOnNewUserPage() {
		
		page.selectDropdownWithIndex(newUserUserTypefield, 1);//pageutility functions used
		//Select select = new Select(newUserUserTypefield);
		//select.selectByIndex(1);
		return this;
	}

	public AdminPage selectDropDownOptionAdminOnNewUserPage() {
		page.selectDropdownWithIndex(newUserUserTypefield, 2);
		return this;
	}

	public AdminPage selectDropDownOptionPartnerOnNewUserPage() {
		page.selectDropdownWithIndex(newUserUserTypefield, 3);
		return this;
	}

	public AdminPage selectDropDownOptionDeliveryBoyOnNewUserPage() {
		page.selectDropdownWithIndex(newUserUserTypefield, 4);
		return this;
	}

	public AdminPage clickOnSaveButtonOnNewUserPage() {
		wait.waitUntilElementToBeClickable(driver, newUserSavebutton);
		newUserSavebutton.click();
		return this;
	}

	public AdminPage clickOnResetButtonOnNewUserPage() {
		wait.waitUntilElementToBeClickable(driver, newUserResetbutton);
		newUserResetbutton.click();
		return this;
	}

	// Search Button/page Functions-AdminPage
	public AdminPage searchButtonOnAdminPage() {
		wait.waitUntilElementToBeClickable(driver, searchbutton);
		searchbutton.click();
		return this;
	}

	public AdminPage enterUsernameOnUsernameFieldOnSearchAdminUserPage(String searchUserUsername) {
		searchAdminUserUsernamefield.sendKeys(searchUserUsername);
		return this;
	}

	public AdminPage selectUserTypeDropDownonSearchAdminUserPage() {
		wait.waitUntilElementToBeClickable(driver, searchAdminUserUserTypefield);
		searchAdminUserUserTypefield.click();
		return this;
	}

	public AdminPage selectDropDownOptionStaffOnSearchAdminUserPage() {
		page.selectDropdownWithIndex(searchAdminUserUserTypefield, 1);
		return this;
	}

	public AdminPage selectDropDownOptionAdminOnSearchAdminUserPage() {
		page.selectDropdownWithIndex(searchAdminUserUserTypefield, 2);
		return this;
	}

	public AdminPage clickOnSearchButtonOnSearchAdminUserPage() {
		wait.waitUntilElementToBeClickable(driver, searchAdminUserSearchButton);
		searchAdminUserSearchButton.click();
		return this;
	}

	public AdminPage clickOnResetButtonOnSearchAdminUserPage() {
		wait.waitUntilElementToBeClickable(driver, searchAdminUserResetButton);
		searchAdminUserResetButton.click();
		return this;
	}

	// Reset button -Admin Page function
	public AdminPage clickOnResetButtonAdminPage() {
		wait.waitUntilElementToBeClickable(driver, resetbutton);
		resetbutton.click();
		return this;
	}
	//method to check admin user text displayed on admin page
	public boolean adminUserTextDisplayed() {
		wait.waitUntilTextIsLocated(driver, adminusr);
		return adminusr.isDisplayed();
	}
}
