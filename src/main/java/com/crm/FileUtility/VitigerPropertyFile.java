package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class VitigerPropertyFile {
	public static String getInputData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("F:\\eclipse\\com.crm.finalMock\\src\\test\\resources\\Configuration\\Vitiger.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}
