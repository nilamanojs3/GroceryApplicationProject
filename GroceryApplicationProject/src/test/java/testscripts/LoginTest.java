package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import automationcore.TestNGBase;
import constants.Constant;
import utilities.ExcelUtilities;

public class LoginTest extends TestNGBase {

	HomePage home;// creating a reference variable foe home page to use chaining of method concept

	@Test(priority = 1, description = "Validaing user credential with Valid Credentials", groups = { "smoke" },retryAnalyzer = retrymachanism.Retry.class)
	public void verifyUserLoginwithValidCredentials() throws IOException {
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);// chaining of methods
		// login.enterPasswordOnPasswordField(password);
		home = login.clickSigninButton();// signin button click navigating to Homepage thats why using the reference
											// variable home=obj.method()
		// assertTrue()
		boolean dashboarddisplay = login.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay, Constant.validCredentialError);
	}

	@Test(priority = 2, description = "Validaing user credential with ValidUsername and Invalidpassword",retryAnalyzer = retrymachanism.Retry.class)
	public void verifyUserLoginwithValidUsernameandInvalidpassword() throws IOException {
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickSigninButton();
		
		// assertEqual()
		String actual = login.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.invalidPasswordError);
	}

	@Test(priority = 3, description = "Validaing user credential with InvalidUsername and Validpassword",retryAnalyzer = retrymachanism.Retry.class)
	public void verifyUserLoginwithInvalidUsernameandValidpassword() throws IOException {
		String username = ExcelUtilities.readStringData(2, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickSigninButton();

		// assertEquals()
		String actual = login.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.invalidUsernameError);
	}

	@Test(priority = 4, description = "Validaing user credential with InvalidUsername and Invalidpassword ", groups = {
			"smoke" }, dataProvider = "loginProvider",retryAnalyzer = retrymachanism.Retry.class)
	public void verifyUserLoginwithInvalidUsernameandInvalidpassword(String username, String password)
			throws IOException {
		// String username = ExcelUtilities.readStringData(3, 0, "LoginPage");
		// String password = ExcelUtilities.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickSigninButton();

		// assertTrue
		boolean signinTextDisplayed = login.issigninTextDisplayed();
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
