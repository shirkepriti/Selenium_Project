package com.crm.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VitigerHomePage {
	public VitigerHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	private @FindBy(xpath = "//a[text() = 'Organizations']")
	WebElement organization ;
	private @FindBy(linkText = "Contacts")
	WebElement contact;
	public void contact()
	{
		contact.click();
	}
}
