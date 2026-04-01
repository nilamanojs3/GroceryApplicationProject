package automationcore;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenshotUtility;

public class TestNGBase 

{
public WebDriver driver;//driver is the reference variable for webdriver class
	@BeforeMethod
	public void browserLaunch()
	{
		driver =new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");//launching the URL
		driver.manage().window().maximize();//to maximizing the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicitwait
	}
	@AfterMethod
	
	public void driverQuit(ITestResult iTestResult) throws IOException { 
		  
 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
  
 			ScreenshotUtility screenShot = new ScreenshotUtility(); 
 			screenShot.getScreenshot(driver, iTestResult.getName()); 
 		} 
 		//driver.quit(); 
  
 	}
	/*public void closeAndQuit()
	{
		//driver.close();
		//driver.quit();
		
		
	}*/

}
