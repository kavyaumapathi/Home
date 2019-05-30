package com.qa.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase 
{
	public static WebDriver driver;
	
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KUMAPATH\\Downloads\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://magento.com/");
		System.out.println("Browser has been launched");
		
	}

}
