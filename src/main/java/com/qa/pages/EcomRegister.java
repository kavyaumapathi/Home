package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;
import com.qa.TestDataDriven.ExcelUtility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EcomRegister extends TestBase
{
	@FindBy(xpath="//*[@id=\"block-header\"]/ul/li[9]/a")
	public WebElement myAccount;
	
	@FindBy(xpath="//*[@id='login-form']/div/div/div[2]/div/button/span/span")
	public WebElement register;
	
	@FindBy(xpath="//input[@id='firstname' and @name='firstname']")
	public WebElement fname;
	
	@FindBy(xpath="//input[@id='lastname' and @name='lastname']")
	public WebElement lname;
	
	@FindBy(xpath="//*[@id='email_address']")
	//*[@id="email_address"]
	public WebElement email;
	
	@FindBy(xpath="//select[@id='country']")
	public WebElement country;
	
	@FindBy(xpath="//select[@id='customer_company_type']")
	public WebElement company;
	
	@FindBy(xpath="//select[@id='customer_individual_role']")
	public WebElement role;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	public WebElement password;
	
	@FindBy(xpath="//*[@id=\"confirmation\"]")
	public WebElement confirmpass;
	
	public String first,last,emailadd,pass,cp;
	public EcomRegister()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAcc()
	{
		myAccount.click();
	}
	
	public void verifyReg() throws InterruptedException
	{
		Thread.sleep(3000);
		register.click();
	}
	
	public void verifyNames() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		fname.click();
		first=ExcelUtility.getCellData("Sheet1", 1, 0);
		first=ExcelUtility.writeCellData("Sheet1", 5, 0);
		fname.sendKeys(first);
		System.out.println("FirstName-----Data has been fetched from excel");
		
		Thread.sleep(4000);
		lname.click();
		last=ExcelUtility.getCellData("Sheet1", 1, 1);
		last=ExcelUtility.writeCellData("Sheet1", 5, 1);
		lname.sendKeys(last);
		System.out.println("LastName-----Data has been fetched from excel");
	}
	
	public void verifyDetails() throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		email.click();
		//test.log(LogStatus.PASS, "email link is clicked");
		emailadd=ExcelUtility.getCellData("Sheet1", 1, 2);
		email.sendKeys(emailadd);
		System.out.println("Email------Data has been fetched from excel");
		
		country.click();
		country.sendKeys("India");
		
		
		company.click();
		company.sendKeys("Analyst/Media");
		
	
		role.click();
		role.sendKeys("Technical/developer");
		
		password.click();
		pass=ExcelUtility.getCellData("Sheet1", 1, 3);
		password.sendKeys(pass);
		System.out.println("Password-------Data has been fetched from excel");
		
		confirmpass.click();
		cp=ExcelUtility.getCellData("Sheet1", 1, 4);
		confirmpass.sendKeys(cp);
		System.out.println("Confirm-Password-------Data has been fetched from excel");
		
	}
	
}
