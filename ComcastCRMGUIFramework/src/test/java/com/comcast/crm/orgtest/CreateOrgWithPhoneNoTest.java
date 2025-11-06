package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import com.comcast.crm.objectutility.CreateNewOrgPage;
import com.comcast.crm.objectutility.HomePage;
import com.comcast.crm.objectutility.LoginPage;
import com.comcast.crm.objectutility.OrganizationInfoPage;
import com.comcast.crm.objectutility.OrganizationPage;

public class CreateOrgWithPhoneNoTest extends BaseClass{

	@Test
	public void createOrgWithPhoneNoTest() throws Exception
	{

		String orgName = el.getDataFromExcel("Org", 7, 2) +jl.getRandomNumber();
		String phoneNo = el.getDataFromExcel("Org", 7, 3);
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgButton().click();

		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createOrgWithNum(orgName,phoneNo);
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
		
		String actualPhoneNo = oip.getPhoneNo().getText();
		if(actualPhoneNo.contains(phoneNo))
		{
			System.out.println(phoneNo + " contact is verified and PASS");
		}
		else
		{
			System.out.println(phoneNo + " contact is not verified and FAIL");
		}
				
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		driver.findElement(By.name("accountname")).sendKeys(orgName);
//		
//		driver.findElement(By.id("phone")).sendKeys(phoneNo);
//		
//		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
//		
//		//verification of industry and type drop-down
//		
//		String actualPhone = driver.findElement(By.id("dtlview_Phone")).getText();
//		if(actualPhone.contains(phoneNo))
//		{
//			System.out.println(phoneNo+" phoneNo is verified & PASS");
//		}
//		else
//		{
//			System.out.println(phoneNo+" phoneNo is not verified & FAIL");
//		}
//		
//		driver.quit();
	
	}

}
