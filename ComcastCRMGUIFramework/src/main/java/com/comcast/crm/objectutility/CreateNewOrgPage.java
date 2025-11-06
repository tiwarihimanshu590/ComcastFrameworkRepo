package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrgPage {
	
	WebDriver driver;
	public CreateNewOrgPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameTF;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
	private WebElement saveButton;
	
	@FindBy(name = "industry")
	private WebElement industryDD;
	
	@FindBy(name = "accounttype")
	private WebElement typeDD;
	
	@FindBy(id = "phone")
	private WebElement phoneNumber;

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createOrg(String orgName) {
		orgNameTF.sendKeys(orgName);
		saveButton.click();
	}
	
	public void createOrg(String orgName, String industry) {
		orgNameTF.sendKeys(orgName);
		Select sec = new Select(industryDD);
		sec.selectByVisibleText(industry);
		saveButton.click();
	}

	public void createOrgWithNum(String orgName,String phoneNum) {
		orgNameTF.sendKeys(orgName);
		phoneNumber.sendKeys(phoneNum);
		saveButton.click();
	}
	
	public void createOrg(String orgName, String industry, String type) {
		orgNameTF.sendKeys(orgName);
		Select sec = new Select(industryDD);
		sec.selectByVisibleText(industry);
		Select sec2 = new Select(typeDD);
		sec2.selectByVisibleText(type);
		saveButton.click();
	}
}
