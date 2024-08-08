package com.crm.Pom;


import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.FileUtility.ExcelUtility;



public class HomePage
{
	ExcelUtility ex = new ExcelUtility();
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	private @FindBy (css = "img[src='https://demowebshop.tricentis.com/content/images/thumbs/0000015_25-virtual-gift-card_125.jpeg']")
	WebElement GiftImage;
	
	public WebElement getgiftImage()
	{
		return GiftImage;
	}
	public void giftImage()
	{
		GiftImage.click();
	}
	private @FindBy(id = "giftcard_2_RecipientName")
	WebElement recipientName;
	
	public WebElement getRecipientName()
	{
		return recipientName;
	}
	private @FindBy(id = "giftcard_2_RecipientEmail")
	WebElement recipientEmail;
	
	public WebElement getRecipientEmail()
	{
		return recipientEmail;
	}
	private @FindBy(id = "giftcard_2_Message")
	WebElement Message;
	public WebElement getMessage()
	{
		return Message;
	}
	private @FindBy(name = "addtocart_2.EnteredQuantity")
	WebElement qty_input;
	
	public WebElement getqty_input()
	{
		return qty_input;
	}
	
	public void recipientDetails() throws EncryptedDocumentException, IOException
	{
		recipientName.sendKeys(ex.getDataFromEXcelSheet("Login", 2, 1));
		recipientEmail.sendKeys(ex.getDataFromEXcelSheet("Login", 3, 1));
		Message.sendKeys(ex.getDataFromEXcelSheet("Login", 4, 1));
	}
	
	public void giftCardQuantity() throws EncryptedDocumentException, IOException
	{
		qty_input.clear();
		qty_input.sendKeys("5");
	}
	private @FindBy(id = "add-to-cart-button-2")
	WebElement addToCart;
	public WebElement getAddTOCart()
	{
		return addToCart;
	}
	public void addGiftsToCart()
	{
		addToCart.click();
	}
	private @FindBy (xpath = "//span[text()='Shopping cart']")
	WebElement cart;
	
	public WebElement getCart()
	{
		return cart;
	}
	
	private @FindBy (className = "product-name")
	WebElement verification;
	
	public WebElement getverification()
	{
		return verification;
	}
	
	public void openCart()
	{
		cart.click();
	}
	
	private @FindBy(xpath = "//a[text()='Log out']")
	WebElement logOut;
	
	public WebElement getLogOut()
	{
		return logOut;
	}
	public void logOutLink()
	{
		logOut.click();
	}
	private @FindBy(name = "removefromcart")
	WebElement removeFromCart;
	
	public WebElement getremovefromcart()
	{
		return removeFromCart;
	}
	
	private @FindBy (name = "updatecart")
	WebElement updateCart;
	
	public WebElement getupdatecart()
	{
		return updateCart;
	}
	public void removeProductsFromCart()
	{
		removeFromCart.click();
		updateCart.click();
	}
}

