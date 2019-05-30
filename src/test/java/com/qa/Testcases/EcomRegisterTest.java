package com.qa.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.ExtentReport.ExtentFactory;
import com.qa.TestBase.TestBase;
import com.qa.TestDataDriven.TestWrite;
import com.qa.pages.EcomRegister;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EcomRegisterTest extends TestBase
{
	EcomRegisterTest etest;
	EcomRegister ereg;
	ExtentReports report; 
	ExtentTest test;
	TestWrite tw;
	SoftAssert sa=new SoftAssert();
	
	
	@BeforeClass
	public void initialze()
	{
		setup();
		//Assert.assertEquals(true, false);//hard assertion
		
		report=ExtentFactory.Instance();
		etest=new EcomRegisterTest();
		ereg=new EcomRegister();
	}
	
	@Test(priority=1)
	public void Login() throws InterruptedException
	{
		
		ereg.verifyAcc();
		System.out.println("Account icon has been clicked");
		//sa.assertEquals(true, false);
		
		ereg.verifyReg();
		System.out.println("Register button has been clicked");
		//sa.assertEquals(true, false);
		
		//sa.assertAll();
	}
	
	@Test(priority=2)
	public void verifyNamesTest() throws IOException, InterruptedException
	{
		
		ereg.verifyNames();
		test=report.startTest("Names-------- Verification");
		System.out.println("Names have been entered");
		test.log(LogStatus.PASS, "Names has been successfully Entered");
		//tw.WriteExcel();
		
	}
	
	@Test(priority=3)
	public void verifyDetailsTest() throws IOException, InterruptedException
	{
		test=report.startTest("details-------- Verification");
		ereg.verifyDetails();
		Thread.sleep(5000);
		System.out.println("Details have been entered");
		test.log(LogStatus.PASS, "email has been successfully Entered");
		
	}

	
	@AfterClass
    public void CloseConnection() 
	{
		driver.close();
		report.endTest(test);
		report.flush();
	}
		
}
