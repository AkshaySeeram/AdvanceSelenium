package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgination {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		WebDriverUtility wu=new WebDriverUtility();
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getPropertyData("url"));
		driver.findElement(By.name("user_name")).sendKeys(fu.getPropertyData("username"));
		driver.findElement(By.name("user_password")).sendKeys(fu.getPropertyData("password"));
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create')]")).click();
		driver.findElement(By.name("lastname")).sendKeys(eu.getExcelData("Contact",9,2)+ju.getRandom());
		driver.findElement(By.xpath("(//img[@title=\"Select\"])[1]")).click();
		wu.switchNewBrowser(driver, "Accounts&action");
		driver.findElement(By.linkText("faceBook_")).click();
		wu.switchNewBrowser(driver, "EditView");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		wu.moveElement(driver,driver.findElement(By.xpath("(//td[@class='small'])[2]/img")));
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(5000);
		driver.close();
	}
	
}
