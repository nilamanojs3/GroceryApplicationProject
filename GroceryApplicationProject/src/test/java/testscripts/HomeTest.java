package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends TestNGBase {
	@Test
	public void verifyLogoutButton() throws IOException {
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		HomePage logout = new HomePage(driver);
		logout.clickOnMoreInfoIconOnAdminSlide();
		logout.clickOnAdminProfileIcon();
		logout.clickOnLogoutButton();
	}

}
