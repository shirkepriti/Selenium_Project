package com.crm.Pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.Javautility.JavaUtility;

public class Organization {
	public Organization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy(xpath = "//a[text() = 'Organizations']")
	WebElement organizationButton ;
	
	private @FindBy(xpath = "//img[@title='Create Organization...']")
	WebElement newOrganization;
	
	private @FindBy(xpath = "//input[@name='accountname']")
	WebElement OrganizationName;
	
	private @FindBy(xpath = "//input[@accesskey='S']")
	WebElement saveButton;
	
	private @FindBy(xpath = "//span[@class='dvHeaderText']")
	WebElement verifyCreation;
	
	private @FindBy(xpath = "//select[@name='industry']")
	WebElement industries;
	
	private @FindBy(id = "dtlview_Industry")
	WebElement industriesVerfify;
	
	JavaUtility util= new JavaUtility();
	
	
	
	public void createOrganization(String name) {
		organizationButton.click();
		newOrganization.click();
		OrganizationName.sendKeys(name + util.generaterateRandomeNumber(1000));
		saveButton.click();
	}
	
	public void createOrganizationWithIndustries(String name, String industry) {
		organizationButton.click();
		newOrganization.click();
		OrganizationName.sendKeys(name);
		Select select = new Select(industries);
		select.selectByVisibleText(industry);
		saveButton.click();
	}
	
	public String verifyText() {
		return verifyCreation.getText();
	}
	
	public String verifyTextIndustries() {
		return industriesVerfify.getText();
	}
	
	
	
}

