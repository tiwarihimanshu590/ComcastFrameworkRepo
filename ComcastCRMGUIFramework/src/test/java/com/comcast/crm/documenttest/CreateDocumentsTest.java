package com.comcast.crm.documenttest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectutility.CreateNewDocumentPage;
import com.comcast.crm.objectutility.DocumentsInfoPage;
import com.comcast.crm.objectutility.DocumentsPage;
import com.comcast.crm.objectutility.HomePage;

public class CreateDocumentsTest extends BaseClass{

	@Test(groups="smokeTest")
	public void createDocumentsTest() throws Exception
	{
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String docTitle = el.getDataFromExcel("Document", 1, 2)+jl.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		hp.getDocumentLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create documents page");
		DocumentsPage dp = new DocumentsPage(driver);
		dp.getCreateDocButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Creating new document");
		CreateNewDocumentPage cndp = new CreateNewDocumentPage(driver);
		cndp.getDocTitleTB().sendKeys(docTitle);
		cndp.getSaveButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Validation started");
		DocumentsInfoPage dip = new DocumentsInfoPage(driver);
		String actualHead = dip.getDocumentHeader().getText();
		
		boolean status = actualHead.contains(docTitle);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS, "Document creation verified");
		
		String actualDocName = dip.getDocTitleInfo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualDocName, docTitle);
		UtilityClassObject.getTest().log(Status.PASS, "Document name verified");
		soft.assertAll();
		
	}
	
	@Test(groups="regressionTest")
	public void createDocumentsWithDescriptionTest() throws Exception	
	{
		
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String docTitle = el.getDataFromExcel("Document", 7, 2)+jl.getRandomNumber();
		String descData = el.getDataFromExcel("Document", 7, 3)+jl.getRandomNumber();
			
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		hp.getDocumentLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create documents page");
		DocumentsPage dp = new DocumentsPage(driver);
		dp.getCreateDocButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Creating new document");
		CreateNewDocumentPage cndp = new CreateNewDocumentPage(driver);
		cndp.getDocTitleTB().sendKeys(docTitle);
		UtilityClassObject.getTest().log(Status.INFO, "Switching to frame to enter description of doc");
		WebElement frame = cndp.getFrameElement();
		wl.switchToFrame(driver, frame);
		driver.switchTo().activeElement().sendKeys(descData);
		
		UtilityClassObject.getTest().log(Status.INFO, "Switching back to default frame to save");
		driver.switchTo().parentFrame();

		cndp.getSaveButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Validation started");
		DocumentsInfoPage dip = new DocumentsInfoPage(driver);
		String actualHead = dip.getDocumentHeader().getText();
		boolean status = actualHead.contains(docTitle);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS, "Document creation verified");
		
		String actualDocName = dip.getDocTitleInfo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualDocName, docTitle);
		UtilityClassObject.getTest().log(Status.PASS, "Document name verified");
				
		String actualDescription = dip.getDescriptionInfo().getText();
		soft.assertEquals(actualDescription, descData);
		UtilityClassObject.getTest().log(Status.PASS, "Document description verified");
		soft.assertAll();
		
	}
	
	@Test(groups="regressionTest")
	public void createDocumentsWithGroupTest() throws Exception	
	{
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String docTitle = el.getDataFromExcel("Document", 4, 2)+jl.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		hp.getDocumentLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create documents page");
		DocumentsPage dp = new DocumentsPage(driver);
		dp.getCreateDocButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Creating new document");
		CreateNewDocumentPage cndp = new CreateNewDocumentPage(driver);
		cndp.getDocTitleTB().sendKeys(docTitle);
		UtilityClassObject.getTest().log(Status.INFO, "Selecting group radio button and a group");
		cndp.getGroupRadioButton().click();
		WebElement dropDown = cndp.getGroupDD();
		Select sec = new Select(dropDown);
		sec.selectByContainsVisibleText("Support Group");
		cndp.getSaveButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Validation started");
		DocumentsInfoPage dip = new DocumentsInfoPage(driver);
		String actualHead = dip.getDocumentHeader().getText();
		boolean status = actualHead.contains(docTitle);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS, "Document creation verified");
		
		String actualDocName = dip.getDocTitleInfo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualDocName, docTitle);
		UtilityClassObject.getTest().log(Status.PASS, "Document name verified");
		
		String actualDescription = dip.getGroupInfo().getText();
		soft.assertEquals(actualDescription, "Support Group");
		UtilityClassObject.getTest().log(Status.PASS, "Group name verified");
		soft.assertAll();
		
	}	
}
