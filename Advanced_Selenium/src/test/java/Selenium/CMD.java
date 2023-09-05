package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CMD {
	
	//mvn -Dtest=CMDTest test -Durl="http://localhost:8888" -Dun="admin" -Dpwd="manager"
	
	@Test
	public void cmdtest() throws InterruptedException {
		String URL = System.getProperty("url");
		String UN = System.getProperty("un");
		String PWD = System.getProperty("pwd");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		Actions action=new Actions(driver);
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("(//td[@class='small'])[2]/img"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(3000);
		driver.quit();
	}	
}