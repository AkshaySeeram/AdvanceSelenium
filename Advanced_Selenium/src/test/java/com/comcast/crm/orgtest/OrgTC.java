package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.comcast.basetest.BaseClass;




public class OrgTC extends BaseClass{
	
	@Test
	public void createorg() throws InterruptedException, IOException {
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create')]")).click();
		driver.findElement(By.name("accountname")).sendKeys(eu.getExcelData("org",1,2)+ju.getRandom());
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
	@Test
	public void createorgwithindustry() throws EncryptedDocumentException, IOException, InterruptedException {
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create')]")).click();
		driver.findElement(By.name("accountname")).sendKeys(eu.getExcelData("org",5,2)+ju.getRandom());
		wu.selectByvalue(driver.findElement(By.name("industry")),eu.getExcelData("org",5,3));
		wu.selectByvalue(driver.findElement(By.name("accounttype")),eu.getExcelData("org",5,4));
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
	@Test
	public void createcontactwithsupportdate() throws InterruptedException, EncryptedDocumentException, IOException {
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create')]")).click();
		driver.findElement(By.name("accountname")).sendKeys(eu.getExcelData("org",9,2)+ju.getRandom());
		driver.findElement(By.id("phone")).sendKeys("82528895632");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
}
