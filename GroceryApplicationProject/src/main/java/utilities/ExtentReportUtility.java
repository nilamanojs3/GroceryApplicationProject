package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility 

{
	//What is ExcelReport- It is a customized  detailed HTMLreport
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extentreports that can 
		// be shared across the application 

	public synchronized static ExtentReports createExtentReports() //created a method of predefied class 	ExtentReports
		{ 
			ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //to store my report i need a folder name "extent-reports" in project directory and followed by the file format
			reporter.config().setReportName("7RMartSupermarketProject"); //setting ReportName
			extentReports.attachReporter(reporter); 
			extentReports.setSystemInfo("Organization", "Obsqura"); //settingOrganisation name
			extentReports.setSystemInfo("Name", " Nila"); // setting the name
			return extentReports; 
		}


}
