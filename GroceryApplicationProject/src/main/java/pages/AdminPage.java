package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminPage

{
	public WebDriver driver;
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

	// NewUserFunctions-AdminPage
	public AdminPage clickNewButtonOnAdminPage() {
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
		Select select = new Select(newUserUserTypefield);
		select.selectByIndex(2);
		return this;
	}

	public AdminPage selectDropDownOptionPartnerOnNewUserPage() {
		Select select = new Select(newUserUserTypefield);
		select.selectByIndex(3);
		return this;
	}

	public AdminPage selectDropDownOptionDeliveryBoyOnNewUserPage() {
		Select select = new Select(newUserUserTypefield);
		select.selectByIndex(4);
		return this;
	}

	public AdminPage clickOnSaveButtonOnNewUserPage() {
		newUserSavebutton.click();
		return this;
	}

	public AdminPage clickOnResetButtonOnNewUserPage() {
		newUserResetbutton.click();
		return this;
	}

	// Search Button/page Functions-AdminPage
	public AdminPage searchButtonOnAdminPage() {
		searchbutton.click();
		return this;
	}

	public AdminPage enterUsernameOnUsernameFieldOnSearchAdminUserPage(String searchUserUsername) {
		searchAdminUserUsernamefield.sendKeys(searchUserUsername);
		return this;
	}

	public AdminPage selectUserTypeDropDownonSearchAdminUserPage() {
		searchAdminUserUserTypefield.click();
		return this;
	}

	public AdminPage selectDropDownOptionStaffOnSearchAdminUserPage() {
		Select select = new Select(searchAdminUserUserTypefield);
		select.selectByIndex(1);
		return this;
	}

	public AdminPage selectDropDownOptionAdminOnSearchAdminUserPage() {
		Select select = new Select(searchAdminUserUserTypefield);
		select.selectByIndex(2);
		return this;
	}

	public AdminPage clickOnSearchButtonOnSearchAdminUserPage() {
		searchAdminUserSearchButton.click();
		return this;
	}

	public AdminPage clickOnResetButtonOnSearchAdminUserPage() {
		searchAdminUserResetButton.click();
		return this;
	}

	// Reset button -Admin Page function
	public AdminPage clickOnResetButtonAdminPage() {
		resetbutton.click();
		return this;
	}
}
