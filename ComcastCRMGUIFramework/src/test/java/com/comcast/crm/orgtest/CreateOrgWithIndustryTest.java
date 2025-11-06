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

public class CreateOrgWithIndustryTest extends BaseClass{

	@Test
	public  void createOrgWithIndustryTest() throws Exception
	{
		
		String orgName = el.getDataFromExcel("Org", 4, 2) +jl.getRandomNumber();
		String industryName = el.getDataFromExcel("Org", 4, 3);
		String typeName = el.getDataFromExcel("Org", 4, 4);
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgButton().click();

		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createOrg(orgName,industryName,typeName);
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
		
		String actualIndustryName = oip.getIndustryName().getText();
		if(actualIndustryName.contains(industryName))
		{
			System.out.println(industryName + " name is verified and PASS");
		}
		else
		{
			System.out.println(industryName + " name is not verified and FAIL");
		}
		
		String actualTypeName = oip.getIndustryType().getText();
		if(actualTypeName.contains(typeName))
		{
			System.out.println(typeName + " name is verified and PASS");
		}
		else
		{
			System.out.println(typeName + " name is not verified and FAIL");
		}		
		
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		driver.findElement(By.name("accountname")).sendKeys(orgName);
//		
//		WebElement indus = driver.findElement(By.name("industry"));
//		Select sel1 = new Select(indus);
//		sel1.selectByVisibleText(industry);
//		
//		WebElement typ = driver.findElement(By.name("accounttype"));
//		Select sel2 = new Select(typ);
//		sel2.selectByVisibleText(type);
//		
//		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
//		
//		//verification of industry and type drop-down
//		
//		String actualIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
//		if(actualIndustry.contains(industry))
//		{
//			System.out.println(industry+" industry is verified & PASS");
//		}
//		else
//		{
//			System.out.println(industry+" industry is not verified & FAIL");
//		}	
//		
//		String actualType = driver.findElement(By.id("dtlview_Type")).getText();
//		if(actualType.contains(type))
//		{
//			System.out.println(type+" type is verified & PASS");
//		}
//		else
//		{
//			System.out.println(type+" type is not verified & FAIL");
//		}
//		
//		driver.quit();
	}

}
