package com.comcast.crm.documenttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class CreateDocumentsWithDescriptionTest extends BaseClass{

	@Test
	public void createDocumentsWithDescriptionTest() throws Exception	
	{
		
		String docTitle = el.getDataFromExcel("Document", 7, 2)+jl.getRandomNumber();
		String descData = el.getDataFromExcel("Document", 7, 3)+jl.getRandomNumber();
			
		HomePage hp = new HomePage(driver);
		hp.getDocumentLink().click();
		
		DocumentsPage dp = new DocumentsPage(driver);
		dp.getCreateDocButton().click();
		
		CreateNewDocumentPage cndp = new CreateNewDocumentPage(driver);
		cndp.getDocTitleTB().sendKeys(docTitle);
		
		WebElement frame = cndp.getFrameElement();
		wl.switchToFrame(driver, frame);
		driver.switchTo().activeElement().sendKeys(descData);
		
		driver.switchTo().parentFrame();

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
		
		String actualDescription = dip.getDescriptionInfo().getText();
		if(actualDescription.contains(descData))
		{
			System.out.println(descData+" Description info is verified & PASS");
		}
		
		else
		{
			System.out.println(descData+" Description info is not verified & FAIL");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
//		driver.findElement(By.linkText("Documents")).click();
//		driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
//		driver.findElement(By.name("notes_title")).sendKeys(docTitle);
		
//		driver.findElement(By.id("cke_contents_notecontent")).click();
		
//		WebElement frame = driver.findElement(By.xpath("//iframe[@tabindex='0']"));
//		wl.switchToFrame(driver, frame);
//		driver.switchTo().activeElement().sendKeys(descData);
//		
//		driver.switchTo().parentFrame();
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
//		String actualDescription = driver.findElement(By.xpath("//td[@colspan='3']")).getText();
//		if(actualDescription.contains(descData))
//		{
//			System.out.println(descData+" Description info is verified & PASS");
//		}
//		
//		else
//		{
//			System.out.println(descData+" Description info is not verified & FAIL");
//		}
//		
//		driver.quit();
	}

}
