package automationcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNGBase 

{
public WebDriver driver;//driver is the reference variable for webdriver class
	@BeforeMethod
	public void browserLaunch()
	{
		driver =new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");//launching the URL
		driver.manage().window().maximize();//to maximizing the window
	}
	@AfterMethod
	public void closeAndQuit()
	{
		//driver.close();
		//driver.quit();
	}

}
