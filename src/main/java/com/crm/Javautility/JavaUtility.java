package com.crm.Javautility;

import java.time.LocalDate;
import java.util.Random;

public class JavaUtility {
	public static int  generaterateRandomeNumber(int limit) {
		Random random=new Random();
		return random.nextInt(limit);
		
	}
	public static String endDate() {
		LocalDate eDate=LocalDate.now();
		return eDate.toString();
	
		
	}
	public static String startDate() {
		LocalDate sDate=LocalDate.now();
		return sDate.plusDays(20).toString();
	}
}
	
