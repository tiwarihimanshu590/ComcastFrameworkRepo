package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectutility.CreateNewOrgPage;
import com.comcast.crm.objectutility.HomePage;
import com.comcast.crm.objectutility.OrganizationInfoPage;
import com.comcast.crm.objectutility.OrganizationPage;

public class CreateOrganzationTest extends BaseClass{

	@Test(groups="smokeTest")
	public void createOrganzationTest() throws Exception
	{
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String orgName = el.getDataFromExcel("Org", 1, 2) +jl.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create org page");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgButton().click();

		UtilityClassObject.getTest().log(Status.INFO, "Creating new org");
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createOrg(orgName);
		wl.waitForPageToLoad(driver);

		UtilityClassObject.getTest().log(Status.INFO, "Validation started");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgName = oip.getHeaderTitle().getText();
		boolean status = actualOrgName.contains(orgName);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS,"Organization creation verified" );
		
	}
	
	@Test(groups="regressionTest")
	public  void createOrgWithIndustryTest() throws Exception
	{
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String orgName = el.getDataFromExcel("Org", 4, 2) +jl.getRandomNumber();
		String industryName = el.getDataFromExcel("Org", 4, 3);
		String typeName = el.getDataFromExcel("Org", 4, 4);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create org page");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgButton().click();

		UtilityClassObject.getTest().log(Status.INFO, "Creating new org");
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createOrg(orgName,industryName,typeName);
		wl.waitForPageToLoad(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, "Validation started");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgName = oip.getHeaderTitle().getText();
		boolean status = actualOrgName.contains(orgName);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS,"Organization creation verified" );
		
		String actualIndustryName = oip.getIndustryName().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualIndustryName, industryName);
		UtilityClassObject.getTest().log(Status.PASS,"Industry name verified" );
				
		String actualTypeName = oip.getIndustryType().getText();
		soft.assertEquals(actualTypeName, typeName);
		UtilityClassObject.getTest().log(Status.PASS,"Type name verified" );
		soft.assertAll();
		
	}
	
	
	@Test(groups="regressionTest")
	public void createOrgWithPhoneNoTest() throws Exception
	{

		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String orgName = el.getDataFromExcel("Org", 7, 2) +jl.getRandomNumber();
		String phoneNo = el.getDataFromExcel("Org", 7, 3);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create org page");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgButton().click();

		UtilityClassObject.getTest().log(Status.INFO, "Creating new org");
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createOrgWithNum(orgName,phoneNo);
		wl.waitForPageToLoad(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, "Validation started");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgName = oip.getHeaderTitle().getText();
		boolean status = actualOrgName.contains(orgName);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS,"Organization creation verified" );
		
		String actualPhoneNo = oip.getPhoneNo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualPhoneNo, phoneNo);
		UtilityClassObject.getTest().log(Status.PASS,"Phone number verified" );
		soft.assertAll();
	}
	
	@Test(groups="regressionTest")
	public void deleteOrgTest() throws Exception
	{

		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String orgName = el.getDataFromExcel("Org", 10, 2) +jl.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create org page");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgButton().click();

		UtilityClassObject.getTest().log(Status.INFO, "Creating new org");
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createOrg(orgName);
		wl.waitForPageToLoad(driver);

		UtilityClassObject.getTest().log(Status.INFO, "Validating Org creation");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgName = oip.getHeaderTitle().getText();
		boolean status = actualOrgName.contains(orgName);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS,"Organization creation verified" );
				
		/* going back to organization page */
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to Org page");
		hp.getOrgLink().click();
		
		/* search for organization to delete */
		UtilityClassObject.getTest().log(Status.INFO, "Searching for created Org");
		op.getSearchOrgTB().sendKeys(orgName);
		wl.selectFromDropDown(op.getSearchOrgDD(), "Organization Name");
		op.getSearchButton().click();
		
		/* in dynamic web table select and delete organization */
		UtilityClassObject.getTest().log(Status.INFO, "Deleting created Org");
		driver.findElement(By.xpath("//a[text()='"+orgName+"' and @title='Organizations']/ancestor::tr[@bgcolor='white']/descendant::a[text()='del']")).click();
		wl.switchToAlertAccept(driver);
		
		/* verification of deletion */
		UtilityClassObject.getTest().log(Status.INFO, "Validating deletion of created Org");
		op.getSearchOrgTB().sendKeys(orgName);
		wl.selectFromDropDown(op.getSearchOrgDD(), "Organization Name");
		op.getSearchButton().click();
		boolean status2 = op.getNoOrgMssg().isDisplayed();
		Assert.assertEquals(status2, true);
		UtilityClassObject.getTest().log(Status.PASS,"Organization deletion verified" );
		
	}
}
