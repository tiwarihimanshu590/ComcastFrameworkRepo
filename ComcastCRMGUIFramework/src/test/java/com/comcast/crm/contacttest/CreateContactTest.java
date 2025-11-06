package com.comcast.crm.contacttest;

import org.testng.Reporter;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectutility.ContactsInfoPage;
import com.comcast.crm.objectutility.ContactsPage;
import com.comcast.crm.objectutility.CreateNewContactPage;
import com.comcast.crm.objectutility.CreateNewOrgPage;
import com.comcast.crm.objectutility.HomePage;
import com.comcast.crm.objectutility.OrganizationInfoPage;
import com.comcast.crm.objectutility.OrganizationPage;

public class CreateContactTest extends BaseClass{

	@Test(groups="smokeTest")
	public void createContactTest() throws Exception
	{
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String lastName = el.getDataFromExcel("Contact", 1, 2) +jl.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create contact page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Creating new contact");
		CreateNewContactPage cnp =  new CreateNewContactPage(driver);
		cnp.getLastName().sendKeys(lastName);
		cnp.getSaveButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Validation started");
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actualHead = cip.getContactHeader().getText();
		boolean status= actualHead.contains(lastName);
		Assert.assertEquals(status, true);
		Reporter.log("Contact header verified in CCT",true);
		UtilityClassObject.getTest().log(Status.PASS,"Contact creation verified" );
		
		String actuallastName = cip.getContactInfoName().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actuallastName, lastName);
		Reporter.log("Contact name verified in CCT",true);
		UtilityClassObject.getTest().log(Status.PASS,"Contact name verified" );
		soft.assertAll();
	}
	
	
	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws Exception	
	{
		
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String orgName = el.getDataFromExcel("Contact", 7, 2) +jl.getRandomNumber();
		String lastName = el.getDataFromExcel("Contact", 7, 3) +jl.getRandomNumber();
		
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

		UtilityClassObject.getTest().log(Status.INFO, "Verifying org creation started");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgName = oip.getHeaderTitle().getText();
		boolean status1= actualOrgName.contains(orgName);
		Assert.assertEquals(status1, true);
		Reporter.log("Organization name verified in CCWOT",true);
		UtilityClassObject.getTest().log(Status.PASS,"Organization creation verified" );
		
		
		/* Navigating to Contacts Page */
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to contacts page");
		hp.getContactLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create contacts page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactButton().click();
		
		/* Creating new contact by entering last name and clicking on adding organization button */
		UtilityClassObject.getTest().log(Status.INFO, "Creating new contact");
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastName().sendKeys(lastName);
		cncp.getSelectOrgButton().click();
		
		/* Switching to new window */
		UtilityClassObject.getTest().log(Status.INFO, "Switching to child org search window");
		wl.switchToTabViaURL(driver, "module=Accounts");
		
		/* Searching and selecting the above created organization  */
		UtilityClassObject.getTest().log(Status.INFO, "Searching & selecting organization");
		op.getSearchOrgTB().sendKeys(orgName);
		op.getChildSerchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		/* Switching back to parent window and save the details */
		UtilityClassObject.getTest().log(Status.INFO, "Switching back to parent window & saving contacts information");
		wl.switchToTabViaURL(driver, "module=Contacts&action");
		cncp.getSaveButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Verification started");
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actuallastName = cip.getContactInfoName().getText();
		boolean status2= actuallastName.contains(lastName);
		Assert.assertEquals(status2, true);
		UtilityClassObject.getTest().log(Status.PASS,"Contact name verified" );
		
		String actualOrg = cip.getOrgNameInfo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualOrg, orgName);
		UtilityClassObject.getTest().log(Status.PASS,"Organization name verified" );
		soft.assertAll();	
	}
	
	@Test(groups="regressionTest")
	public void createContactWithSupportDateTest() throws Exception
	{
		
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String lastName = el.getDataFromExcel("Contact", 4, 2) +jl.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to contacts page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Creating new contact with date");
		CreateNewContactPage cncp =  new CreateNewContactPage(driver);
		cncp.getLastName().sendKeys(lastName);
		
		String startDate = jl.getSystemDateInYYYYMMDD();
		String endDate = jl.getRequiredDateInYYYYMMDD(30);
		
		cncp.getStartDateTB().clear();
		cncp.getStartDateTB().sendKeys(startDate);
		
		cncp.getEndDateTB().clear();
		cncp.getEndDateTB().sendKeys(endDate);
		
		cncp.getSaveButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Verification started");
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actuallastName = cip.getContactInfoName().getText();
		boolean status= actuallastName.contains(lastName);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS,"Contact name verified" );
		
		String actualStartDate =cip.getStartDateInfo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualStartDate, startDate);
		UtilityClassObject.getTest().log(Status.PASS,"Support start date verified" );

		String actualEndDate = cip.getEndDateInfo().getText();
		soft.assertEquals(actualEndDate, endDate);
		UtilityClassObject.getTest().log(Status.PASS,"Support end date verified" );
		soft.assertAll();
		
	}

}
