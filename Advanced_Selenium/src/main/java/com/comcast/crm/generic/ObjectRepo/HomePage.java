package com.comcast.crm.generic.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orglnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement conlnk;
	
	@FindBy(xpath = "(//td[@class='small'])[2]/img")
	private WebElement accountbtn;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signbtn;

	public WebElement getOrglnk() {
		return orglnk;
	}

	public WebElement getConlnk() {
		return conlnk;
	}

	public WebElement getAccountbtn() {
		return accountbtn;
	}

	public WebElement getSignbtn() {
		return signbtn;
	}
	
}
