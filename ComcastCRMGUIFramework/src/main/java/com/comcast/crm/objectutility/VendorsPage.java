package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class VendorsPage {
	
	WebDriver driver;
	public VendorsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement createVendorButton;
	
	@FindBy(name = "search_text")
	private WebElement searchTb;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	
	
	public WebElement getSearchTb() {
		return searchTb;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getCreateVendorButton() {
		return createVendorButton;
	}
	
	

}
