package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage 

{
	public WebDriver driver;
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//AdminUserNewUserWebElements
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@href='javascript:void(0)' and @class='btn btn-rounded btn-danger'] ")WebElement newbutton;
	@FindBy(xpath = "//input[@id=\"username\"]")WebElement newUserUsernamefield;
	@FindBy(xpath = "//input[@id='password']")WebElement newUserPasswordfield;
	@FindBy(xpath = "//select[@id='user_type']")WebElement newUserUserTypefield;
	@FindBy(xpath ="//div[@class='card-footer center']//child::button[@type='submit']") WebElement newUserSavebutton;
	@FindBy(xpath = "//div[@class='card-footer center']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement newUserResetbutton;
	//SearchAdminUserpageWebElements
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@href='javascript:void(0)' and @class='btn btn-rounded btn-primary'] ")WebElement searchbutton;
	@FindBy(xpath = "//input[@id='un']")WebElement searchAdminUserUsernamefield;
	@FindBy(xpath = "//select[@id='ut']")WebElement searchAdminUserUserTypefield;
	@FindBy(xpath = "//button[@name='Search']")WebElement searchAdminUserSearchButton;
	@FindBy(xpath = "//div[@class='card-body']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-default btn-fix']")WebElement searchAdminUserResetButton;
	//ResetAdminUserpageWebElements
	@FindBy(xpath = "//div[@class='col-sm-12']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning'] ")WebElement resetbutton;
	
	
	//NewUserFunctions-AdminPage
	public  void clickNewButtonOnAdminPage()
	{
	newbutton.click();
	}
	public void enterUsernameOnUsernameFieldOnNewUserPage(String newUserusername)
	{
		newUserUsernamefield.sendKeys(newUserusername);
	}
	public void enterUsernameOnPasswordFieldOnNewUserPage(String newUserpassword)
	{
		newUserPasswordfield.sendKeys(newUserpassword);
	}
	public void selectUserTypeDropDownonNewUserPage()
	{
		newUserUserTypefield.click();
	}
	public void selectDropDownOptionStaffOnNewUserPage()
	{
		Select select=new Select(newUserUserTypefield);
		//select.deselectByVisibleText("Staff");
		select.selectByIndex(1);
	}
	public void selectDropDownOptionAdminOnNewUserPage()
	{
		Select select=new Select(newUserUserTypefield);
		select.selectByIndex(2);
	}
	public void selectDropDownOptionPartnerOnNewUserPage()
	{
		Select select=new Select(newUserUserTypefield);
		select.selectByIndex(3);
	}
	public void selectDropDownOptionDeliveryBoyOnNewUserPage()
	{
		Select select=new Select(newUserUserTypefield);
		select.selectByIndex(4);
	}
	public void clickOnSaveButtonOnNewUserPage()
	{
		newUserSavebutton.click();
	}
	public void clickOnResetButtonOnNewUserPage()
	{
		newUserResetbutton.click();
	}
	
	//Search Button/page Functions-AdminPage
	public  void searchButtonOnAdminPage()
	{
		searchbutton.click();
	}
	public void enterUsernameOnUsernameFieldOnSearchAdminUserPage(String searchUserUsername)
	{
		searchAdminUserUsernamefield.sendKeys(searchUserUsername);
	}
	public void selectUserTypeDropDownonSearchAdminUserPage()
	{
		searchAdminUserUserTypefield.click();
	}
	public void selectDropDownOptionStaffOnSearchAdminUserPage()
	{
		Select select=new Select(searchAdminUserUserTypefield);
		select.selectByIndex(1);
	}
	public void selectDropDownOptionAdminOnSearchAdminUserPage()
	{
		Select select=new Select(searchAdminUserUserTypefield);
		select.selectByIndex(2);
	}
	public void clickOnSearchButtonOnSearchAdminUserPage()
	{
		searchAdminUserSearchButton.click();
	}
	public void clickOnResetButtonOnSearchAdminUserPage()
	{
		searchAdminUserResetButton.click();
	}
	
	//Reset button -Admin Page function
	public void clickOnResetButtonAdminPage()
	{
		resetbutton.click();
	}
}
