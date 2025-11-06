package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewDocumentPage {
	
	WebDriver driver;
	public CreateNewDocumentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "notes_title")
	private WebElement docTitleTB;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//iframe[@tabindex='0']")
	private WebElement frameElement;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupRadioButton;
	
	@FindBy(name = "assigned_group_id")
	private WebElement groupDD;
	
	public WebElement getGroupDD() {
		return groupDD;
	}

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}

	public WebElement getFrameElement() {
		return frameElement;
	}

	public WebElement getDocTitleTB() {
		return docTitleTB;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
}
