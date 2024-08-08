package com.crm.TestCase;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Baseclass.BaseClass;
import com.crm.Pom.HomePage;

//@Listeners(com.crm.Listeners.DemoListners.class)
public class TestCaseNo1 extends BaseClass
{
	@Test
	public void testCase1() throws EncryptedDocumentException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.giftImage();
		hp.recipientDetails();
		hp.giftCardQuantity();
		hp.addGiftsToCart();
		hp.openCart();
		WebElement verification = hp.getverification();
		assertTrue(verification.isDisplayed());
		hp.removeProductsFromCart();
		hp.logOutLink();
	}
}

