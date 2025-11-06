package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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
import com.comcast.crm.objectutility.HomePage;
import com.comcast.crm.objectutility.LoginPage;

public class CreateContactWithSupportDateTest extends BaseClass {

	@Test
	public void createContactWithSupportDateTest() throws Exception
	{
		
		String lastName = el.getDataFromExcel("Contact", 4, 2) +jl.getRandomNumber();
			
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactButton().click();
		
		CreateNewContactPage cncp =  new CreateNewContactPage(driver);
		cncp.getLastName().sendKeys(lastName);
		
		String startDate = jl.getSystemDateInYYYYMMDD();
		String endDate = jl.getRequiredDateInYYYYMMDD(30);
		
		cncp.getStartDateTB().clear();
		cncp.getStartDateTB().sendKeys(startDate);
		
		cncp.getEndDateTB().clear();
		cncp.getEndDateTB().sendKeys(endDate);
		
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
		
		String actualStartDate =cip.getStartDateInfo().getText();
		if(actualStartDate.contains(startDate))
		{
			System.out.println(startDate+" start date is verified & PASS");
		}
		else
		{
			System.out.println(startDate+" start date is not verified & FAIL");
		}	
		
		String actualEndDate = cip.getEndDateInfo().getText();
		if(actualEndDate.contains(endDate))
		{
			System.out.println(endDate+" end date is verified & PASS");
		}
		else
		{
			System.out.println(endDate+" end date is not verified & FAIL");
		}		
		
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
//		driver.findElement(By.linkText("Contacts")).click();
//		
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//		
//		String startDate = jl.getSystemDateInYYYYMMDD();
//		String endDate = jl.getRequiredDateInYYYYMMDD(30);
//		
//		driver.findElement(By.name("support_start_date")).clear();
//		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
//		
//		driver.findElement(By.name("support_end_date")).clear();
//		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
//		
//		driver.findElement(By.name("lastname")).sendKeys(lastName);
//		
//		
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
////		driver.switchTo().alert().accept();
//		
//		//verification
//		String actualStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
//		if(actualStartDate.contains(startDate))
//		{
//			System.out.println(startDate+" start date is verified & PASS");
//		}
//		else
//		{
//			System.out.println(startDate+" start date is not verified & FAIL");
//		}	
//		
//		String actualEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
//		if(actualEndDate.contains(endDate))
//		{
//			System.out.println(endDate+" end date is verified & PASS");
//		}
//		else
//		{
//			System.out.println(endDate+" end date is not verified & FAIL");
//		}
//		
//		driver.quit();
	}

}
