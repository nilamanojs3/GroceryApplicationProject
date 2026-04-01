package testscripts;
import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import automationcore.TestNGBase;
import utilities.ExcelUtilities;

public class LoginTest extends TestNGBase
{
	@Test(priority = 1,description="Validaing user credential with Valid Credentials")
	public void verifyUserLoginwithValidCredentials() throws IOException
	{
		String username=ExcelUtilities.readStringData(0, 0,"LoginPage");
		String password=ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
	}
	
	@Test(priority = 2,description="Validaing user credential with ValidUsername and Invalidpassword")
	public void verifyUserLoginwithValidUsernameandInvalidpassword() throws IOException
	{
		String username=ExcelUtilities.readStringData(1, 0,"LoginPage");
		String password=ExcelUtilities.readStringData(1, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
	}
	
	@Test(priority = 3,description="Validaing user credential with InvalidUsername and Validpassword")
	public void verifyUserLoginwithInvalidUsernameandValidpassword() throws IOException
	{
		String username=ExcelUtilities.readStringData(2, 0,"LoginPage");
		String password=ExcelUtilities.readStringData(2, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
	}
	
	@Test(priority = 4,description="Validaing user credential with InvalidUsername and Invalidpassword ")
	public void verifyUserLoginwithInvalidUsernameandInvalidpassword() throws IOException
	{
		String username=ExcelUtilities.readStringData(3, 0,"LoginPage");
		String password=ExcelUtilities.readStringData(3, 1, "LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
	}
	
	
}
