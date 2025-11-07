package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
	
	WebDriver driver;
	public EmailPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "My Mails")
	private WebElement myMailLink;
	
	@FindBy(linkText = "Qualified Mails (As Contacts)")
	private WebElement qualifiedMailLink;
	
	@FindBy(linkText = "All Mails")
	private WebElement allMailsLink;
	
	public WebElement getMyMailLink() {
		return myMailLink;
	}
	
	public WebElement getQualifiedMailLink() {
		return qualifiedMailLink;
	}

	public WebElement getAllMailsLink() {
		return allMailsLink;
	}

}
