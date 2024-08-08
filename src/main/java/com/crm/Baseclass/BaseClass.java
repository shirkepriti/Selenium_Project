package com.crm.Baseclass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtility.PropertyUtility;
import com.crm.Pom.LoginPage;



public class BaseClass
{
	String expectedURL="https://demowebshop.tricentis.com/";
	public static WebDriver driver;
	PropertyUtility ps = new PropertyUtility();
	@BeforeClass 
	public void preConditions() throws IOException
	{
		String browser = ps.readDataFromPropertyFile("browser");
		String url = ps.readDataFromPropertyFile("url");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		String actualURL = driver.getCurrentUrl();
		assertEquals(actualURL, expectedURL);
	}
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.login();
	}
	@AfterMethod 
	public void logout()
	{
		System.out.println("Logout From System");
	}
	@AfterClass
	public void postCondition()
	{
		driver.quit();
	}
}

