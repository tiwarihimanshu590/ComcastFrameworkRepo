package com.comcast.crm.documenttest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectutility.CreateNewDocumentPage;
import com.comcast.crm.objectutility.DocumentsInfoPage;
import com.comcast.crm.objectutility.DocumentsPage;
import com.comcast.crm.objectutility.HomePage;
import com.comcast.crm.objectutility.LoginPage;

public class CreateDocumentsWithGroupTest extends BaseClass{

	@Test
	public void createDocumentsWithGroupTest() throws Exception	
	{
		String docTitle = el.getDataFromExcel("Document", 4, 2)+jl.getRandomNumber();
			
		HomePage hp = new HomePage(driver);
		hp.getDocumentLink().click();
		
		DocumentsPage dp = new DocumentsPage(driver);
		dp.getCreateDocButton().click();
		
		CreateNewDocumentPage cndp = new CreateNewDocumentPage(driver);
		cndp.getDocTitleTB().sendKeys(docTitle);
		cndp.getGroupRadioButton().click();
		WebElement dropDown = cndp.getGroupDD();
		Select sec = new Select(dropDown);
		sec.selectByContainsVisibleText("Support Group");
		cndp.getSaveButton().click();
		
		DocumentsInfoPage dip = new DocumentsInfoPage(driver);
		String actualHead = dip.getDocumentHeader().getText();
		if(actualHead.contains(docTitle))
		{
			System.out.println(docTitle+" document title header is verified & PASS");
		}
		else
		{
			System.out.println(docTitle+" document title header is not verified & FAIL");
		}	
		
		String actualDocName = dip.getDocTitleInfo().getText();
		if(actualDocName.contains(docTitle))
		{
			System.out.println(docTitle+" document title information is verified & PASS");
		}
		else
		{
			System.out.println(docTitle+" document title information is not verified & FAIL");
		}
		
		String actualDescription = dip.getGroupInfo().getText();
		if(actualDescription.contains("Support"))
		{
			System.out.println("Assigned group title header is verified & PASS");
		}
		
		else
		{
			System.out.println("Assigned group title header is not verified & FAIL");
		}
		
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
//		driver.findElement(By.linkText("Documents")).click();
//		driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
//		driver.findElement(By.name("notes_title")).sendKeys(docTitle);
//		
//		driver.findElement(By.xpath("//input[@value='T']")).click();
//		WebElement dropDown = driver.findElement(By.name("assigned_group_id"));
//		Select sec = new Select(dropDown);
//		sec.selectByContainsVisibleText("Support Group");
//
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
//		
//		String actualHead = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if(actualHead.contains(docTitle))
//		{
//			System.out.println(docTitle+" document title header is verified & PASS");
//		}
//		else
//		{
//			System.out.println(docTitle+" document title header is not verified & FAIL");
//		}	
//		
//		String actualDocName = driver.findElement(By.id("dtlview_Title")).getText();
//		if(actualDocName.contains(docTitle))
//		{
//			System.out.println(docTitle+" document title information is verified & PASS");
//		}
//		else
//		{
//			System.out.println(docTitle+" document title information is not verified & FAIL");
//		}
//		
//		String actualGroupName = driver.findElement(By.linkText("Support Group")).getText();
//		
//		if(actualGroupName.contains("Support"))
//		{
//			System.out.println("Assigned group title header is verified & PASS");
//		}
//		
//		else
//		{
//			System.out.println("Assigned group title header is not verified & FAIL");
//		}
//		
//		driver.quit();
	}

}
