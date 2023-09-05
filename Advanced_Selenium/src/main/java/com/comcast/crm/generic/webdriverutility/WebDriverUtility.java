package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElePresent(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void switchNewBrowser(WebDriver driver,String url) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();

		while(it.hasNext()) {
			String wid=it.next();
			driver.switchTo().window(wid);
			String crtUrl=driver.getCurrentUrl();
			if(crtUrl.contains(url)) {
				break;
			}
		}
	}

	public void switchFrameIndex(WebDriver driver, int index){
		driver.switchTo().frame(index);
	}

	public void switchFrameId(WebDriver driver, String id){
		driver.switchTo().frame(id);
	}

	public void switchFrameEle(WebDriver driver,String ele){
		driver.switchTo().frame(ele);
	}

	public void alertAcc(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void alertDis(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void selectByindex(WebElement ele,int index) {
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}

	public void selectByvalue(WebElement ele,String val) {
		Select sel=new Select(ele);
		sel.selectByValue(val);
	}

	public void selectByvisText(WebElement ele,String text) {
		Select sel=new Select(ele);
		sel.selectByVisibleText(text);
	}

	public void moveElement(WebDriver driver,WebElement ele) {
		Actions ac=new Actions(driver);
		ac.moveToElement(ele).perform();
	}

	public void doubleclick(WebDriver driver,WebElement ele) {
		Actions ac=new Actions(driver);
		ac.doubleClick(ele).perform();
	}
}