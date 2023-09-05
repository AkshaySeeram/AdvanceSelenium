package com.comcast.crm.generic.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@alt,'Create')]")
	private WebElement createcon;
	
	@FindBy(name = "lastname")
	private WebElement lastname;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	public WebElement getCreatecon() {
		return createcon;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
}
