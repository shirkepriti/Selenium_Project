package com.crm.TestCase;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;


import com.crm.Baseclass.VitigerBase;
import com.crm.FileUtility.VitigerExcelFile;
import com.crm.Javautility.JavaUtility;
import com.crm.Pom.ContactTask8;
import com.crm.Pom.HomePage;
import com.crm.Pom.VitigerHomePage;

public class Testcaseno8 extends VitigerBase{
	VitigerExcelFile eUtil=new VitigerExcelFile();
	
	@Test
	public void contactcreate() throws EncryptedDocumentException, IOException {
		VitigerHomePage home=new VitigerHomePage(driver);
		home.contact();
		ContactTask8 con=new ContactTask8(driver);
		con.plus();
		int row=0;
		String conName=eUtil.getData("TC_3", row++,0);
		con.lastName(conName+JavaUtility.generaterateRandomeNumber(1000));
		con.getLastName();
	    con.endDate(JavaUtility.endDate());
	    con.saveBtn();
	    assertTrue(con.getcontactInfo().getText().contains(conName));
		
		
		
		
	}

}
