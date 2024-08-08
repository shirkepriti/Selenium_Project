package com.crm.Pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VitigerLogout {
	public VitigerLogout(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	private @FindBy(xpath="(//td[@class='small'])[2]")
	WebElement Acbutton;
	private @FindBy(linkText = "Sign Out")
	WebElement signout;
	public void singout() {
		Acbutton.click();
		signout.click();
	}
	
}
