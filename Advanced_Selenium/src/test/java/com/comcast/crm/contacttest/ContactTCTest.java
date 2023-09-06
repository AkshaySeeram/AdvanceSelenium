package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.generic.ObjectRepo.ContactsPage;
import com.comcast.crm.generic.ObjectRepo.HomePage;
import com.crm.comcast.basetest.BaseClass;

public class ContactTCTest extends BaseClass{
	
	
	
	
	@Test
	public void createcontact() throws InterruptedException, IOException {
		contact=new ContactsPage(driver);
		home=new HomePage(driver);
		home.getConlnk().click();
		contact.getCreatecon().click();
		contact.getLastname().sendKeys(eu.getExcelData("Contact",1,2)+ju.getRandom());
		contact.getSavebtn();
		
//		driver.findElement(By.linkText("Contacts")).click();
//		driver.findElement(By.xpath("//img[contains(@title,'Create')]")).click();
//		driver.findElement(By.name("lastname")).sendKeys(eu.getExcelData("Contact",1,2)+ju.getRandom());
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
	@Test
	public void createcontactwithorg() throws EncryptedDocumentException, IOException, InterruptedException {
		home=new HomePage(driver);
		home.getConlnk().click();
		contact.getCreatecon().click();
		contact.getLastname().sendKeys(eu.getExcelData("Contact",9,2)+ju.getRandom());
		driver.findElement(By.xpath("(//img[@title=\"Select\"])[1]")).click();
		wu.switchNewBrowser(driver, "Accounts&action");
		Thread.sleep(1000);
		driver.findElement(By.linkText("faceBook_")).click();
		wu.switchNewBrowser(driver, "EditView");
		contact.getSavebtn();
	}
	
	@Test
	public void createcontactwithsupportdate() throws InterruptedException, EncryptedDocumentException, IOException {
		home=new HomePage(driver);
		home.getConlnk().click();
		contact.getCreatecon().click();
		contact.getLastname().sendKeys(eu.getExcelData("Contact",9,2)+ju.getRandom());
		driver.findElement(By.id("jscal_field_support_start_date")).sendKeys(ju.getSystem());
		driver.findElement(By.id("jscal_field_support_end_date")).sendKeys(ju.getRequiredDate(30));
		contact.getSavebtn();
	}
	
}
