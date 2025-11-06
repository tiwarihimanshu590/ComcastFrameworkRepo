package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgButton;
	
	@FindBy(name = "search_text")
	private WebElement searchOrgTB;

	@FindBy(name = "search_field")
	private WebElement searchOrgDD;
	
	@FindBy(name = "submit")
	private WebElement searchButton;
	
	@FindBy(xpath = "//span[@class='genHeaderSmall']")
	private WebElement noOrgMssg;
	
	@FindBy(name = "search")
	private WebElement childSerchBtn;

	public WebElement getChildSerchBtn() {
		return childSerchBtn;
	}

	public WebElement getNoOrgMssg() {
		return noOrgMssg;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchOrgTB() {
		return searchOrgTB;
	}

	public WebElement getSearchOrgDD() {
		return searchOrgDD;
	}

	public WebElement getCreateOrgButton() {
		return createOrgButton;
	}
}
