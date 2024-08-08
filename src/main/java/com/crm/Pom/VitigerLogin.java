package com.crm.Pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VitigerLogin {
	
	public VitigerLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(xpath = "//input[@type='text']")
	WebElement username ;
	private @FindBy(xpath = "//input[@type='password']")
	WebElement password ;
	private @FindBy(id = "submitButton")
	WebElement loginButton ;
	private @FindBy(xpath = "//a[contains(text(), 'Sign Out')]")
	WebElement signOut;
	
	public void login(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
		
	}
	
	
}

