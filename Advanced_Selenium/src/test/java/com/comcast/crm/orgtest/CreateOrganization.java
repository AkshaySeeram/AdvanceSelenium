package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganization {
	
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
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create')]")).click();
		driver.findElement(By.name("accountname")).sendKeys(eu.getExcelData("org",1,2)+ju.getRandom());
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("(//td[@class='small'])[2]/img"));
		wu.moveElement(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(5000);
		driver.close();
	}
	
}
