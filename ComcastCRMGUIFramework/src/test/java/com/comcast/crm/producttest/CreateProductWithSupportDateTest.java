package com.comcast.crm.producttest;

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
import com.comcast.crm.objectutility.CreateNewProductPage;
import com.comcast.crm.objectutility.HomePage;
import com.comcast.crm.objectutility.LoginPage;
import com.comcast.crm.objectutility.ProductInfoPage;
import com.comcast.crm.objectutility.ProductsPage;
import com.mysql.cj.jdbc.Driver;

public class CreateProductWithSupportDateTest extends BaseClass{

	@Test
	public void createProductWithSupportDateTest() throws Exception	
	{
		
		String productName = el.getDataFromExcel("Product", 4, 2)+jl.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();
		
		ProductsPage pp = new ProductsPage(driver);
		pp.getCreateProdButton().click();
		
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.getProductNameTB().sendKeys(productName);
		
		String todayDate = jl.getSystemDateInYYYYMMDD();
		String supportDate = jl.getRequiredDateInYYYYMMDD(30);
		cnpp.getSupportStartDate().sendKeys(todayDate);
		cnpp.getSupportEndDate().sendKeys(supportDate);
		
		cnpp.getSaveButton().click();
		
		ProductInfoPage pip = new ProductInfoPage(driver);
		String actualProductHeader = pip.getHeaderInfo().getText();
		if(actualProductHeader.contains(productName))
		{
			System.out.println(productName+" header is verified & PASS");
		}
		else
		{
			System.out.println(productName+" header is not verified & FAIL");
		}	
		
		String actualProductInfo = pip.getProductInfo().getText();
		if(actualProductInfo.contains(productName))
		{
			System.out.println(productName+" information is verified & PASS");
		}
		else
		{
			System.out.println(productName+" information is not verified & FAIL");
		}
		
		String actualTodayDate =pip.getStartDateInfo().getText();
		if(actualTodayDate.contains(todayDate))
		{
			System.out.println(todayDate+" start date is verified & PASS");
		}
		else
		{
			System.out.println(todayDate+" start date is not verified & FAIL");
		}
		
		String actualSupportDate =pip.getEndDateInfo().getText();
		if(actualSupportDate.contains(supportDate))
		{
			System.out.println(supportDate+" end date is verified & PASS");
		}
		else
		{
			System.out.println(supportDate+" end date is not verified & FAIL");
		}
		
		
		
//		driver.findElement(By.name("user_name")).sendKeys(Username);
//		driver.findElement(By.name("user_password")).sendKeys(Password);
//		driver.findElement(By.id("submitButton")).click();
//		
//		driver.findElement(By.linkText("Products")).click();
//		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//		
//		driver.findElement(By.name("productname")).sendKeys(productName);
//		
//		String todayDate = jl.getSystemDateInYYYYMMDD();
//		String supportDate = jl.getRequiredDateInYYYYMMDD(30);
//		driver.findElement(By.name("start_date")).sendKeys(todayDate);
//		driver.findElement(By.name("expiry_date")).sendKeys(supportDate);
//		
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
//		
//		//header and data verification
//		String actualHead = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
//		if(actualHead.contains(productName))
//		{
//			System.out.println(productName+" header is verified & PASS");
//		}
//		else
//		{
//			System.out.println(productName+" header is not verified & FAIL");
//		}	
//		
//		String actualInfo = driver.findElement(By.id("dtlview_Product Name")).getText();
//		if(actualInfo.contains(productName))
//		{
//			System.out.println(productName+" information is verified & PASS");
//		}
//		else
//		{
//			System.out.println(productName+" information is not verified & FAIL");
//		}
//		
//		//date verification
//		String actualTodayDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
//		if(actualTodayDate.contains(todayDate))
//		{
//			System.out.println(todayDate+" start date is verified & PASS");
//		}
//		else
//		{
//			System.out.println(todayDate+" start date is not verified & FAIL");
//		}	
//		
//		String actualSupportDate = driver.findElement(By.id("dtlview_Support Expiry Date")).getText();
//		if(actualSupportDate.contains(supportDate))
//		{
//			System.out.println(supportDate+" end date is verified & PASS");
//		}
//		else
//		{
//			System.out.println(supportDate+" end date is not verified & FAIL");
//		}
//		
//		driver.quit();
		
		
		
	}

}
