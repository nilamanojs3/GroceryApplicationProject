package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminTest extends TestNGBase

{
	HomePage home;

	@Test(priority = 1, description = "Verify the user is able to add new users in the admin page")
	public void VerifyWhetherUserIsAbletoAddNewUser() throws IOException {

		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickSigninButton();

		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoIconOnAdminSlide();

		FakerUtility faker = new FakerUtility();
		String newUserusername = faker.createRandomUsername();
		String newUserpassword = faker.createRandomPassword();
		// String newUserusername = ExcelUtilities.readStringData(0, 0, "AdminPage");
		// String newUserpassword = ExcelUtilities.readStringData(0, 1, "AdminPage");
		AdminPage admin = new AdminPage(driver);

		// NewButton/Page Admin page
		admin.clickNewButtonOnAdminPage().enterUsernameOnUsernameFieldOnNewUserPage(newUserusername)
				.enterUsernameOnPasswordFieldOnNewUserPage(newUserpassword).selectUserTypeDropDownonNewUserPage()
				.selectDropDownOptionStaffOnNewUserPage().clickOnSaveButtonOnNewUserPage()
				.clickOnResetButtonOnNewUserPage();
		// admin.selectDropDownOptionAdminOnNewUserPage();
		// admin.selectDropDownOptionPartnerOnNewUserPage();
		// admin.selectDropDownOptionDeliveryBoyOnNewUserPage();

	}

	@Test(priority = 2, description = "Verify the user is able to Search user in the admin page")
	public void VerifyWhetherUserIsAbletoSearchUser() throws IOException {
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickSigninButton();

		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoIconOnAdminSlide();

		String searchUserUsername = ExcelUtilities.readStringData(6, 0, "AdminPage");
		AdminPage admin = new AdminPage(driver);

		// SearchButton/Page Admin page
		admin.searchButtonOnAdminPage().enterUsernameOnUsernameFieldOnSearchAdminUserPage(searchUserUsername)
				.selectDropDownOptionStaffOnSearchAdminUserPage().clickOnSearchButtonOnSearchAdminUserPage()
				.clickOnResetButtonOnSearchAdminUserPage();
		// admin.selectDropDownOptionAdminOnSearchAdminUserPage();

	}

	@Test(priority = 3, description = "Verify the user is able to Reset the Admin page")
	public void VerifyWhetherUserIsAbletoResetAdminPage() throws IOException {
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickSigninButton();
		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoIconOnAdminSlide();
		AdminPage admin = new AdminPage(driver);
		// ResetButton-AdminPage
		admin.clickNewButtonOnAdminPage().clickOnResetButtonAdminPage();
	}

}
