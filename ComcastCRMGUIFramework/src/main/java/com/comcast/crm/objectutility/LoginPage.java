package com.comcast.crm.objectutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")
	private WebElement userName;
	
	@FindBy(name="user_password")
	private WebElement passWord;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApp(String username, String password) 
	{
		maximizeWindow(driver);
   		userName.sendKeys(password);
		passWord.sendKeys(password);
		loginButton.click();
	}
	
	public void loginToApp(String url, String username, String password) 
	{
		driver.get(url);
		maximizeWindow(driver);
   		userName.sendKeys(password);
		passWord.sendKeys(password);
		loginButton.click();
	}
}
