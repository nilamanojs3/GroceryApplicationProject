package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ManageNewsTest extends TestNGBase {
	HomePage home;

	@Test(priority = 1, description = "Verify the user is able to enter News info in the manage News page")
	public void VerifyWhetherUserIsAbletoAddNewsOnManagerNewsPage() throws IOException {

		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickSigninButton();

		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoIconOnManageNewsSlide();

		FakerUtility faker = new FakerUtility();
		String newsinfo = faker.createRandomNews();

		ManageNewsPage managenews = new ManageNewsPage(driver);
		// NewButtonPage ManageNews page
		managenews.clickNewButtonOnManageNewsPage().enterNewsTitleOnManageNewsInfoPage(newsinfo)
				.clickSaveButtonOnManageNewsInfoPage().clickCancelButtonOnManageNewsInfoPage();

	}

	@Test(priority = 2, description = "Verify the user is able to search news  in the manage News page")
	public void VerifyWhetherUserIsAbletoSearchNewsOnManagerNewsPage() throws IOException {

		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickSigninButton();

		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoIconOnManageNewsSlide();

		FakerUtility faker = new FakerUtility();
		String newsinfo = faker.createRandomNews();

		ManageNewsPage managenews = new ManageNewsPage(driver);
		// SearchButtonPage ManageNews page
		managenews.clickOnSearchButtonOnManageNewsPage().enterTitleOnSearchManageNewsPage(newsinfo)
				.clickOnSearchButtonOnSearchManageNewsPage().clickOnResetButtonOnSearchManageNewsPage();

	}

	@Test(priority = 3, description = "Verify the reset button on the manage News page")
	public void VerifytheResetButtonOnManagerNewsPage() throws IOException {

		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickSigninButton();

		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoIconOnManageNewsSlide();

		ManageNewsPage managenews = new ManageNewsPage(driver);
		// ResetButtonPage ManageNews page
		managenews.clickOnSearchButtonOnManageNewsPage().clickOnResetButtonManageNewsPage();

	}

}
