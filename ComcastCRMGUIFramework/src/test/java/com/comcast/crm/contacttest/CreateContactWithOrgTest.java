package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectutility.ContactsInfoPage;
import com.comcast.crm.objectutility.ContactsPage;
import com.comcast.crm.objectutility.CreateNewContactPage;
import com.comcast.crm.objectutility.CreateNewOrgPage;
import com.comcast.crm.objectutility.HomePage;
import com.comcast.crm.objectutility.LoginPage;
import com.comcast.crm.objectutility.OrganizationInfoPage;
import com.comcast.crm.objectutility.OrganizationPage;

public class CreateContactWithOrgTest extends BaseClass{

	@Test
	public void createContactWithOrgTest() throws Exception	{
		
		String orgName = el.getDataFromExcel("Contact", 7, 2) +jl.getRandomNumber();
		String lastName = el.getDataFromExcel("Contact", 7, 3) +jl.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgButton().click();

		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createOrg(orgName);
		wl.waitForPageToLoad(driver);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgName = oip.getHeaderTitle().getText();
		if(actualOrgName.contains(orgName))
		{
			System.out.println(orgName + " name is verified and PASS");
		}
		else
		{
			System.out.println(orgName + " name is not verified and FAIL");
		}
		
		hp.getContactLink().click();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactButton().click();
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastName().sendKeys(lastName);
		cncp.getSelectOrgButton().click();
		
		wl.switchToTabViaURL(driver, "module=Accounts");
		
		op.getSearchOrgTB().sendKeys(orgName);
		op.getChildSerchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		wl.switchToTabViaURL(driver, "module=Contacts&action");
		cncp.getSaveButton().click();
		
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actuallastName = cip.getContactInfoName().getText();
		if(actuallastName.contains(lastName))
		{
			System.out.println(lastName+" last name information is verified & PASS");
		}
		else
		{
			System.out.println(lastName+" last name information is not verified & FAIL");
		}
		
		String actualOrg = cip.getOrgNameInfo().getText();
		if(actualOrg.contains(orgName))
		{
			System.out.println(orgName+" info is verified & PASS");
		}
		else
		{
			System.out.println(orgName+" info is not verified & FAIL");
		}
		
		
		
		
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		driver.findElement(By.name("accountname")).sendKeys(orgName);
//		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
//		
//		//verification organization header
//		String actualHead = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if(actualHead.contains(orgName))
//		{
//			System.out.println(orgName+" header is verified & PASS");
//		}
//		else
//		{
//			System.out.println(orgName+" header is not verified & FAIL");
//		}	
//		
//		// navigate to contact 
//		
//		driver.findElement(By.linkText("Contacts")).click();
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//		driver.findElement(By.name("lastname")).sendKeys(lastName);
//		
//		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
//		
//		//switch to child window
//		wl.switchToTabViaURL(driver, "module=Accounts");
//				
//		driver.findElement(By.name("search_text")).sendKeys(orgName);
//		driver.findElement(By.name("search")).click();
//		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
//		
//		//switch back to parent 
//		wl.switchToTabViaURL(driver, "module=Contacts&action");
//				
//		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
//		
//		//verify last name header
//		String actualLastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if(actualLastName.contains(lastName))
//		{
//			System.out.println(lastName+" header is verified & PASS");
//		}
//		else
//		{
//			System.out.println(lastName+" header is not verified & FAIL");
//		}
//		
//		//verify organization name 
//		String actualOrg = driver.findElement(By.id("mouseArea_Organization Name")).getText();
//		if(actualOrg.contains(orgName))
//		{
//			System.out.println(orgName+" info is verified & PASS");
//		}
//		else
//		{
//			System.out.println(orgName+" info is not verified & FAIL");
//		}
//		
//		
//		driver.quit();
	}

}
