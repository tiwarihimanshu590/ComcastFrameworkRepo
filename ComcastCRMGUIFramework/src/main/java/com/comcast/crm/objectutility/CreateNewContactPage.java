package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastName;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement selectOrgButton;
	
	@FindBy(name = "support_start_date")
	private WebElement startDateTB;
	
	@FindBy(name = "support_end_date")
	private WebElement endDateTB;
	
	public WebElement getStartDateTB() {
		return startDateTB;
	}

	public WebElement getEndDateTB() {
		return endDateTB;
	}

	public WebElement getSelectOrgButton() {
		return selectOrgButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getLastName() {
		return lastName;
	}
	
}
