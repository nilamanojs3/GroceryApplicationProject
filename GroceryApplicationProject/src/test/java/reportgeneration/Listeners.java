package reportgeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationcore.TestNGBase;
import utilities.ExtentReportUtility;

public class Listeners extends TestNGBase implements ITestListener

{
	ExtentTest test; 
 	ExtentReports extent = ExtentReportUtility.createExtentReports(); //Properties called  from ExtentReportUtility class
 	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
  
 	public void onTestStart(ITestResult result) //onTestStart method will invoke automatically before each and every test methods
 	
 	{ 
  
 		ITestListener.super.onTestStart(result); 
 		test = extent.createTest(result.getMethod().getMethodName()); //getMethod() and getMethodName() used to fetch the name of executing test method give this as a header/title
 		extentTest.set(test); 
  
 	} 
  
 	public void onTestSuccess(ITestResult result) //onTestSuccess will automatically invoke when a test method pass.It will show the testcase pass and it show the detail"Test Passed"
 	{ 
  
 		ITestListener.super.onTestSuccess(result); 
 		extentTest.get().log(Status.PASS, "Test Passed"); 
  
 	} 
  
 	public void onTestFailure(ITestResult result) //onTestSuccess will automatically invoke when a test method pass.It will show the testcase failed and it show the detail"Test Failed"
 	{ 
  
 		ITestListener.super.onTestFailure(result); 
 		 
 		extentTest.get().log(Status.FAIL, "Test Failed"); 
 		extentTest.get().fail(result.getThrowable()); 
 		 
 		WebDriver driver = null; 
 		 
 		String testMethodName = result.getMethod().getMethodName(); 
 		 
 		try //Exceptions used to report the reason for testcase failures
 		{ 
 			 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} 
 		catch (IllegalArgumentException e) 
 		{ 
  
 			e.printStackTrace(); 
 		} 
 		catch (IllegalAccessException e) 
 		{ 
  
 			e.printStackTrace(); 
 		} 
 		catch (NoSuchFieldException e) 
 		{ 
  
 			e.printStackTrace(); 
 		} 
 		catch (SecurityException e) 
 		{ 
  
 			e.printStackTrace(); 
 		} 
  
 		try 
 		{ 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} 
 		catch (Exception e) 
 		{ 
 		} 
 	} 
  
 	public void onTestSkipped(ITestResult result) //get invoke whe Tc skipped
 	{ 
 		 
 		ITestListener.super.onTestSkipped(result); 
 		extentTest.get().log(Status.SKIP, "Test Skipped"); 
 		String testMethodName = result.getMethod().getMethodName(); 
  
 	} 
  
 	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
 	{ 
  
 		ITestListener.super.onTestFailedButWithinSuccessPercentage(result); 
 	} 
  
 	public void onTestFailedWithTimeout(ITestResult result) 
 	{ 
  
 		ITestListener.super.onTestFailedWithTimeout(result); 
 	} 
  
 	public void onStart(ITestContext context) 
 	{ 
  
 		ITestListener.super.onStart(context); 
 	} 
  
 	public void onFinish(ITestContext context) 
 	{ 
  
 		ITestListener.super.onFinish(context); 
 		extent.flush(); //Flush() is the method who finalize that in the pass,failed and skipped testcase what to do in that methods and details logs.If you don't use flush() any of these data will log in your report
 	}
}
