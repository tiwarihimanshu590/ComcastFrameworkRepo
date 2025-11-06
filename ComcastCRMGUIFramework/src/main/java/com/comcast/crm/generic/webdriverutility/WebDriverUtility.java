package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	//1. Waiting Conditions Methods
	
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}

	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//2. Switching Windows Methods
	
	public void switchToTabViaURL(WebDriver driver, String partialURL)
	{
		Set<String> allHandles = driver.getWindowHandles();
		Iterator<String> ite = allHandles.iterator();

		while(ite.hasNext())
		{
			String window = ite.next();
			driver.switchTo().window(window);

			String actualURL = driver.getCurrentUrl();
			if(actualURL.contains(partialURL))
			{
				break;
			}
		}
	}

	public void switchToTabViaTitle(WebDriver driver, String partialTitle)
	{
		Set<String> allHandles = driver.getWindowHandles();
		Iterator<String> ite = allHandles.iterator();

		while(ite.hasNext())
		{
			String window = ite.next();
			driver.switchTo().window(window);

			String actualURL = driver.getTitle();
			if(actualURL.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	//3. Switching Frames Methods

	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameID)
	{
		driver.switchTo().frame(nameID);
	}

	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}

	//3. Switching  to Alert Methods
	
	public void switchToAlertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	public void switchToAlertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	//3. Select Class Methods
	
	public void selectFromDropDown(WebElement element, String text)
	{
		Select sl = new Select(element);
		sl.selectByVisibleText(text);
	}

	public void selectFromDropDown(WebElement element, int index)
	{
		Select sl = new Select(element);
		sl.selectByIndex(index);
	}
	
	//4. Actions Class Methods
	
	public void scrollPageVertical(WebDriver driver, int pixelAmount)
	{
		Actions act = new Actions(driver);
		act.scrollByAmount(0, pixelAmount).perform();
	}
	
	public void scrollPageHorizontal(WebDriver driver, int pixelAmount)
	{
		Actions act = new Actions(driver);
		act.scrollByAmount(pixelAmount, 0).perform();
	}
	
	public void scrollPageToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	public void doubleClicking(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void doubleClicking(WebDriver driver,WebElement element) 
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void singleClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.click().perform();
	}
	
	public void singleClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.click(element).perform();
	}
	
	public void movingToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void rightClicking(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	public void rightClicking(WebDriver driver, WebElement element) 
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	

}

