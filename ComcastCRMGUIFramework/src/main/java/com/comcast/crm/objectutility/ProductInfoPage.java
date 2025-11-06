package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	WebDriver driver;
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerInfo;
	
	@FindBy(id = "dtlview_Product Name")
	private WebElement productInfo;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDateInfo;
	
	@FindBy(id = "dtlview_Support Expiry Date")
	private WebElement endDateInfo;
	
	@FindBy(xpath = "//td[@id='mouseArea_Vendor Name']/a")
	private WebElement vendorInfo;
	
	public WebElement getVendorInfo() {
		return vendorInfo;
	}

	public WebElement getStartDateInfo() {
		return startDateInfo;
	}

	public WebElement getEndDateInfo() {
		return endDateInfo;
	}

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getProductInfo() {
		return productInfo;
	}

}
