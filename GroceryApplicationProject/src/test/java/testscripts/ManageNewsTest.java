package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ManageNewsTest extends TestNGBase {
	HomePage home;

	@Test(priority = 1, description = "Verify the user is able to enter News info in the manage News page",retryAnalyzer = retrymachanism.Retry.class)
	public void VerifyWhetherUserIsAbletoAddNewsOnManagerNewsPage() throws IOException {

		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home = login.clickSigninButton();

		home = new HomePage(driver);
		home.clickOnMoreInfoIconOnManageNewsSlide();

		FakerUtility faker = new FakerUtility();
		String newsinfo = faker.createRandomNews();

		ManageNewsPage managenews = new ManageNewsPage(driver);
		// NewButtonPage ManageNews page
		managenews.clickNewButtonOnManageNewsPage().enterNewsTitleOnManageNewsInfoPage(newsinfo)
				.clickSaveButtonOnManageNewsInfoPage();
		/*managenews.clickNewButtonOnManageNewsPage().enterNewsTitleOnManageNewsInfoPage(newsinfo)
		.clickCancelButtonOnManageNewsInfoPage();*/
		
		boolean textareaNewInfoPage = managenews.isNewsTextAreaDisplayed();
		Assert.assertTrue(textareaNewInfoPage, Constant.newsEntryError);
	}

	@Test(priority = 2, description = "Verify the user is able to search news  in the manage News page",retryAnalyzer = retrymachanism.Retry.class)
	public void VerifyWhetherUserIsAbletoSearchNewsOnManagerNewsPage() throws IOException {

		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickSigninButton();

		 home = new HomePage(driver);
		home.clickOnMoreInfoIconOnManageNewsSlide();

		FakerUtility faker = new FakerUtility();
		String newsinfo = faker.createRandomNews();

		ManageNewsPage managenews = new ManageNewsPage(driver);
		// SearchButtonPage ManageNews page
		managenews.clickOnSearchButtonOnManageNewsPage().enterTitleOnSearchManageNewsPage(newsinfo)
				.clickOnSearchButtonOnSearchManageNewsPage().clickOnResetButtonOnSearchManageNewsPage();

		boolean managenewstxt = managenews.isManageNewsTextDisplayed();
		Assert.assertTrue(managenewstxt, Constant.newsSearchError);
	}

	@Test(priority = 3, description = "Verify the reset button on the manage News page",retryAnalyzer = retrymachanism.Retry.class)
	public void VerifytheResetButtonOnManagerNewsPage() throws IOException {

		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickSigninButton();

	    home = new HomePage(driver);
		home.clickOnMoreInfoIconOnManageNewsSlide();

		ManageNewsPage managenews = new ManageNewsPage(driver);
		// ResetButtonPage ManageNews page
		managenews.clickOnSearchButtonOnManageNewsPage().clickOnResetButtonManageNewsPage();

		boolean managenewstxt = managenews.isManageNewsTextDisplayed();
		Assert.assertTrue(managenewstxt, Constant.newsResetError);
	}

}
