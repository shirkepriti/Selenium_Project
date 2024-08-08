package com.crm.TestCase;
import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.Baseclass.BaseClass;
import com.crm.Pom.Cart;
import com.crm.Pom.DigitalDownload;
import com.crm.Pom.HomePageDws;


public class Task5_RemoveHighestPriceProduct extends BaseClass{

	@Test
	public void highestPrice() throws InterruptedException
	{
		assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
		
		HomePageDws hPage = new HomePageDws(driver);
		hPage.digitalDownloads();
		
		DigitalDownload dd = new DigitalDownload(driver);
		List<WebElement> pro = dd.products();
		for (WebElement w : pro) {
			w.click();
			Thread.sleep(1000);
		}
		
		dd.cart();
		
		Cart c = new Cart(driver);
		
		List<WebElement> price = c.prices();
		
		List<Double> priceList = new ArrayList<Double>();
		
		for(WebElement w:price)
		{
			priceList.add(Double.parseDouble(w.getText()));
		}
		
		int index = priceList.indexOf(Collections.max(priceList));
		driver.findElement(By.xpath("(//td[@class='remove-from-cart']/input)["+(++index)+"]")).click();
		
		Thread.sleep(2000);
		
		c.updateCart();
	}
}


