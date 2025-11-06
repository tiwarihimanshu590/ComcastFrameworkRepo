package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class DocumentsInfoPage {
	
	WebDriver driver;
	public DocumentsInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement documentHeader;
	
	@FindBy(id = "dtlview_Title")
	private WebElement docTitleInfo;
	
	@FindBy(xpath = "//td[@colspan='3']/p")
	private WebElement descriptionInfo;
	
	@FindBy(linkText = "Support Group")
	private WebElement groupInfo;
	
	public WebElement getGroupInfo() {
		return groupInfo;
	}

	public WebElement getDescriptionInfo() {
		return descriptionInfo;
	}

	public WebElement getDocumentHeader() {
		return documentHeader;
	}

	public WebElement getDocTitleInfo() {
		return docTitleInfo;
	}

}
