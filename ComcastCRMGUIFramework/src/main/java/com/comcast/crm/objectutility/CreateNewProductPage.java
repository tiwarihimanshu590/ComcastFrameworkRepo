package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage {

	WebDriver driver;
	public CreateNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productNameTB;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(name = "start_date")
	private WebElement supportStartDate;
	
	@FindBy(name = "expiry_date")
	private WebElement supportEndDate;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement addVendorsBtn;
	
	

	public WebElement getAddVendorsBtn() {
		return addVendorsBtn;
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getProductNameTB() {
		return productNameTB;
	}
	
	
}
