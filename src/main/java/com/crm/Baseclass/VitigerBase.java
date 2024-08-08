package com.crm.Baseclass;





import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.FileUtility.VitigerPropertyFile;
import com.crm.Pom.VitigerLogin;
import com.crm.Pom.VitigerLogout;





public class VitigerBase {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void preCondition() throws IOException {
		String browser=VitigerPropertyFile.getInputData("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(VitigerPropertyFile.getInputData("url"));
	}

	@BeforeMethod
	public void login() throws IOException {
		VitigerLogin login = new VitigerLogin(driver);
		login.login(VitigerPropertyFile.getInputData("username"),VitigerPropertyFile.getInputData("password"));
	}

	@AfterMethod
	public void logout() {
		VitigerLogout logout=new VitigerLogout(driver);
		logout.singout();
		
		//Login login = new Login(driver);
//		login.signOut();
	}

	@AfterClass
	public void postCondition() {
		driver.quit();
	}
}
