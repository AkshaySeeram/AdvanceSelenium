package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandom() {
		Random random=new Random();
		int randomNumber=random.nextInt(5000);
		return randomNumber;
	}
	
	public String getSystem() {
		Date dateObj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String result=sdf.format(dateObj);
		return result;
	}
	
	public String getRequiredDate(int days) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String regDate=sdf.format(cal.getTime());
		return regDate;
	}
//	public static void main(String[] args) {
//		JavaUtility j=new JavaUtility();
//		System.out.println(j.getRequiredDate(-30));
//		System.out.println(j.getSystem());
//	}
	
}
