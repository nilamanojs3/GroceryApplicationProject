package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ManageNewsTest extends TestNGBase
{
	@Test(priority = 1, description = "Verify the user is able to enter News info in the manage News page")
	public void VerifyWhetherUserIsAbletoAddNewsOnManagerNewsPage() throws IOException {
		
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		HomePage logout = new HomePage(driver);
		logout.clickOnMoreInfoIconOnManageNewsSlide();

		FakerUtility faker=new FakerUtility();
		String newsinfo = faker.createRandomNews();
		
		ManageNewsPage managenews = new ManageNewsPage(driver);
		// NewButtonPage ManageNews page
		managenews.clickNewButtonOnManageNewsPage();
		managenews.enterNewsTitleOnManageNewsInfoPage(newsinfo);
		managenews.clickSaveButtonOnManageNewsInfoPage();
		managenews.clickCancelButtonOnManageNewsInfoPage();

	}

	@Test(priority = 2, description = "Verify the user is able to search news  in the manage News page")
	public void VerifyWhetherUserIsAbletoSearchNewsOnManagerNewsPage() throws IOException {
		
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		HomePage logout = new HomePage(driver);
		logout.clickOnMoreInfoIconOnManageNewsSlide();

		FakerUtility faker=new FakerUtility();
		String newsinfo = faker.createRandomNews();
		
		ManageNewsPage managenews = new ManageNewsPage(driver);
		// SearchButtonPage ManageNews page
		managenews.clickOnSearchButtonOnManageNewsPage();
		managenews.enterTitleOnSearchManageNewsPage(newsinfo);;
		managenews.clickOnSearchButtonOnSearchManageNewsPage();;
		managenews.clickOnResetButtonOnSearchManageNewsPage();

	}
	@Test(priority = 3, description = "Verify the reset button on the manage News page")
	public void VerifytheResetButtonOnManagerNewsPage() throws IOException {
		
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		HomePage logout = new HomePage(driver);
		logout.clickOnMoreInfoIconOnManageNewsSlide();

		ManageNewsPage managenews = new ManageNewsPage(driver);
		// ResetButtonPage ManageNews page
		managenews.clickOnSearchButtonOnManageNewsPage();
		managenews.clickOnResetButtonManageNewsPage();

	}

}
