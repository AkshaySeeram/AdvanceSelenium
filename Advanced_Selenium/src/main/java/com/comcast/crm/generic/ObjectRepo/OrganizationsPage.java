package com.comcast.crm.generic.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[contains(@title,'Create')]")
	private WebElement createorg;
	
	@FindBy(name = "accountname")
	private WebElement orgname;
	
	public WebElement getCreateorg() {
		return createorg;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
}
