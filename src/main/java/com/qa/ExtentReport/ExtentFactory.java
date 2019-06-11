package com.qa.ExtentReport;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory 
{
public static ExtentReports Instance()
{
	ExtentReports extent;
	String path="C:\\Users\\KUMAPATH\\eclipse-workspace\\Magento\\TestReport\\Logreport.html";
	extent=new ExtentReports(path,false);
	extent.addSystemInfo("Selenium version", "3.14");
	extent.addSystemInfo("platform", "windows");
	
	
	
	
	return extent;
	
	
}

}
