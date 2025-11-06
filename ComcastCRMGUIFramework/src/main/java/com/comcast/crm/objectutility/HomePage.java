package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	@FindBy(linkText = "Documents")
	private WebElement documentLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(name = "Vendors")
	private WebElement vendorsLink;
	
	
	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getSignoutIcon() {
		return signoutIcon;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getDocumentLink() {
		return documentLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public void navigateToCampaign() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
	}
	
	public void signOut() {
		Actions act = new Actions(driver);
		act.moveToElement(signoutIcon).perform();
		signoutLink.click();
	}
}
