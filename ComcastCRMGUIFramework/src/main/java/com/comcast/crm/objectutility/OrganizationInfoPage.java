package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerTitle;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryName;
	
	@FindBy(id = "dtlview_Type")
	private WebElement industryType;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement PhoneNo;
	
	public WebElement getPhoneNo() {
		return PhoneNo;
	}

	public WebElement getIndustryType() {
		return industryType;
	}
	
	public WebElement getIndustryName() {
		return industryName;
	}

	public WebElement getHeaderTitle() {
		return headerTitle;
	}	

}
