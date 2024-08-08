package com.crm.TestCase;





import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Baseclass.VitigerBase;
import com.crm.FileUtility.VitigerExcelFile;
import com.crm.Pom.Organization;




//@Listeners(com.crm.Listeners.VitigerListners.class)
public class TestcaseNo6 extends VitigerBase{
	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException, InterruptedException {
		String organizationName = VitigerExcelFile.getData("TC_1", 1, 2);
		Organization organization = new Organization(driver);
		organization.createOrganization(organizationName);
		String name1 = organization.verifyText();
		assertEquals(name1.contains(organizationName), true);
		
	}
}

