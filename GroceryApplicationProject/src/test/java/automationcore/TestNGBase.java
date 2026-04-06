package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;

public class TestNGBase

{
	public WebDriver driver;// driver is the reference variable for webdriver class
	Properties prop;//created a ref variable for predefined class Properties
	FileInputStream f;//FileInputStream class to read file from a given path ,creatind a ref variable for that
	
	@BeforeMethod(alwaysRun=true)//alwaysRun=true statement is given because after grouping this should be given in order  to run Before and after methods 
	@Parameters("browsers")
	
	// public void browserLaunch() {
	public void browserLaunch(String browsers) throws Exception {
		prop=new Properties();//properties object prop.
		f=new FileInputStream(Constant.configFile);//obj for FileInputSteam
		prop.load(f);//to load the file
		
		if (browsers.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsers.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsers.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("Invalid Browser");
		}
		// driver = new ChromeDriver();
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");// launching the URL
		driver.get(prop.getProperty("url"));//getting the path from config file
		driver.manage().window().maximize();// to maximizing the window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// implicitwait
	}

	@AfterMethod(alwaysRun=true)

	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		// driver.quit();

	}
	/*
	 * public void closeAndQuit() { //driver.close(); //driver.quit();
	 * 
	 * 
	 * }
	 */

}
