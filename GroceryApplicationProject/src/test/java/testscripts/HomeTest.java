package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends TestNGBase {
	HomePage home;

	@Test(description = "Verify the user is able to logout from the application", retryAnalyzer = retrymachanism.Retry.class) // Applying
																																// retry
																																// machanism
																																// in
																																// this
																																// tc
	public void verifyLogoutButton() throws IOException {
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickSigninButton();

		home = new HomePage(driver);
		home.clickOnMoreInfoIconOnAdminSlide();
		home.clickOnAdminProfileIcon();
		login = home.clickOnLogoutButton();
		boolean signinTextDisplayed = login.issigninTextDisplayed();
		Assert.assertTrue(signinTextDisplayed, Constant.unsuccessfulLogoutError);
	}

}
