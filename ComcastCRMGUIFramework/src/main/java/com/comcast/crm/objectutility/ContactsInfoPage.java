package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	WebDriver driver;
	public ContactsInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeader;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement contactInfoName;
	
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a") //td[@id='mouseArea_Organization Name']/a
	private WebElement orgNameInfo;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDateInfo;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDateInfo;
	
	
	public WebElement getStartDateInfo() {
		return startDateInfo;
	}

	public WebElement getEndDateInfo() {
		return endDateInfo;
	}

	public WebElement getOrgNameInfo() {
		return orgNameInfo;
	}

	public WebElement getContactHeader() {
		return contactHeader;
	}

	public WebElement getContactInfoName() {
		return contactInfoName;
	}

}
