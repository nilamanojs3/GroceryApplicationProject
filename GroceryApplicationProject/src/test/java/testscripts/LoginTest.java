package testscripts;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import automationcore.TestNGBase;
import constants.Constant;
import utilities.ExcelUtilities;

public class LoginTest extends TestNGBase {
	@Test(priority = 1, description = "Validaing user credential with Valid Credentials",groups = {"smoke"})
	public void verifyUserLoginwithValidCredentials() throws IOException {
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		// assertTrue()
		boolean dashboarddisplay = login.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay,Constant.validCredentialError);
	}

	@Test(priority = 2, description = "Validaing user credential with ValidUsername and Invalidpassword")
	public void verifyUserLoginwithValidUsernameandInvalidpassword() throws IOException {
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		// asserFalse()
		boolean dashboarddisplay = login.isDashboardDisplayed();
		//Assert.assertFalse(dashboarddisplay,Constant. invalidCredentialError);
		Assert.assertTrue(dashboarddisplay,Constant.invalidUsernameError);
	}

	@Test(priority = 3, description = "Validaing user credential with InvalidUsername and Validpassword")
	public void verifyUserLoginwithInvalidUsernameandValidpassword() throws IOException {
		String username = ExcelUtilities.readStringData(2, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		// assertEquals()
		String actual = login.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.invalidPasswordError);
	}

	@Test(priority = 4, description = "Validaing user credential with InvalidUsername and Invalidpassword ",groups = {"smoke"},dataProvider = "loginProvider")
	public void verifyUserLoginwithInvalidUsernameandInvalidpassword(String username,String password) throws IOException {
		//String username = ExcelUtilities.readStringData(3, 0, "LoginPage");
		//String password = ExcelUtilities.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		
		//assertTrue
		boolean signinTextDisplayed=login.issigninTextDisplayed();
		Assert.assertTrue(signinTextDisplayed, Constant.invalidCredentialError);
	}
	 @DataProvider(name = "loginProvider") 
	 	public Object[][] getDataFromDataProvider() throws IOException { 
	  
	 		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" }, 
	 				// new Object[] {ExcelUtility.getStringData(3, 
	 				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")} 
	 		}; 
	 	}

}
