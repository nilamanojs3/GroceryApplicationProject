package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ManageNewsTest extends TestNGBase
{
	@Test(priority = 1, description = "Verify the user is able to enter News info in the mnage News page")
	public void VerifyWhetherUserIsAbletoAddNewsOnManagerNewsPage() throws IOException {
		
		String username = ExcelUtilities.readStringData(0, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickSigninButton();

		HomePage logout = new HomePage(driver);
		logout.clickOnMoreInfoIconOnManageNewsSlide();
/*
		FakerUtility faker=new FakerUtility();
		String newsinfo = faker.createRandomNews();
		
		ManageNewsPage managenews = new ManageNewsPage(driver);
		// NewButton/Page ManageNews page
		managenews.clickNewButtonOnManageNewsPage();
		managenews.enterNewsTitleOnManageNewsInfoPage(newsinfo);
		managenews.clickSaveButtonOnManageNewsInfoPage();
		//managenews.clickCancelButtonOnManageNewsInfoPage();*/

	}

	

}
