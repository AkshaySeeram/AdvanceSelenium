package Selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenShot {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://flipkart.com/");
		EventFiringWebDriver web=new EventFiringWebDriver(driver);
		File src = web.getScreenshotAs(OutputType.FILE);
		File desc = new File("./screenshot/first.png");
		FileUtils.copyFile(src, desc);
		Thread.sleep(2000);
		driver.quit();
	}

}
