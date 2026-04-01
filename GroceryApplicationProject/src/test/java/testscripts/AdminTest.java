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
	@Test(priority = 1, description = "Verify the user is able to add new users in the admin page")
	public void VerifyWhetherUserIsAbletoAddNewUser() throws IOException {
		
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		HomePage logout = new HomePage(driver);
		logout.clickOnMoreInfoIconOnAdminSlide();

		FakerUtility faker=new FakerUtility();
		String newUserusername = faker.createRandomUsername();
		String newUserpassword =faker.createRandomPassword();
		//String newUserusername = ExcelUtilities.readStringData(0, 0, "AdminPage");
		//String newUserpassword = ExcelUtilities.readStringData(0, 1, "AdminPage");
		AdminPage admin = new AdminPage(driver);
		// NewButton/Page Admin page
		admin.clickNewButtonOnAdminPage();
		admin.enterUsernameOnUsernameFieldOnNewUserPage(newUserusername);
		admin.enterUsernameOnPasswordFieldOnNewUserPage(newUserpassword);
		admin.selectUserTypeDropDownonNewUserPage();
		admin.selectDropDownOptionStaffOnNewUserPage();
		// admin.selectDropDownOptionAdminOnNewUserPage();
		// admin.selectDropDownOptionPartnerOnNewUserPage();
		// admin.selectDropDownOptionDeliveryBoyOnNewUserPage();
		admin.clickOnSaveButtonOnNewUserPage();
		admin.clickOnResetButtonOnNewUserPage();

	}

	@Test(priority = 2, description = "Verify the user is able to Search user in the admin page")
	public void VerifyWhetherUserIsAbletoSearchUser() throws IOException {
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		HomePage logout = new HomePage(driver);
		logout.clickOnMoreInfoIconOnAdminSlide();

		String searchUserUsername = ExcelUtilities.readStringData(6, 0, "AdminPage");
		AdminPage admin = new AdminPage(driver);

		// SearchButton/Page Admin page
		admin.searchButtonOnAdminPage();
		admin.enterUsernameOnUsernameFieldOnSearchAdminUserPage(searchUserUsername);
		admin.selectDropDownOptionStaffOnSearchAdminUserPage();
		// admin.selectDropDownOptionAdminOnSearchAdminUserPage();
		admin.clickOnSearchButtonOnSearchAdminUserPage();
		admin.clickOnResetButtonOnSearchAdminUserPage();

	}

	@Test(priority = 3, description = "Verify the user is able to Reset the Admin page")
	public void VerifyWhetherUserIsAbletoResetAdminPage() throws IOException {
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();
		HomePage logout = new HomePage(driver);
		logout.clickOnMoreInfoIconOnAdminSlide();
		AdminPage admin = new AdminPage(driver);
		// ResetButton-AdminPage
		admin.clickNewButtonOnAdminPage();
		admin.clickOnResetButtonAdminPage();
	}

}
