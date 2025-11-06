package com.comcast.crm.producttest;

import org.openqa.selenium.By;
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
import com.comcast.crm.objectutility.CreateNewProductPage;
import com.comcast.crm.objectutility.CreateNewVendorPage;
import com.comcast.crm.objectutility.HomePage;
import com.comcast.crm.objectutility.LoginPage;
import com.comcast.crm.objectutility.ProductInfoPage;
import com.comcast.crm.objectutility.ProductsPage;
import com.comcast.crm.objectutility.VendorInfoPage;
import com.comcast.crm.objectutility.VendorsPage;

public class CreateProductWithVendorTest extends BaseClass{

	@Test
	public void createProductWithVendorTest() throws Exception	
	{
			
		String productName = el.getDataFromExcel("Product", 7, 2)+jl.getRandomNumber();
		String vendorName = el.getDataFromExcel("Product", 7, 3)+jl.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		WebElement more = hp.getMoreLink();
		wl.movingToElement(driver, more);
		hp.getVendorsLink().click();
		
		VendorsPage vp = new VendorsPage(driver);
		vp.getCreateVendorButton().click();
		
		CreateNewVendorPage cnvp = new CreateNewVendorPage(driver);
		cnvp.getVendorNameTB().sendKeys(vendorName);
		cnvp.getSaveButton().click();
		wl.waitForPageToLoad(driver);
		
		VendorInfoPage vip = new VendorInfoPage(driver);
		String actualVendor = vip.getHeaderInfo().getText();
		if(actualVendor.contains(vendorName))
		{
			System.out.println(vendorName+" vendor is verified & PASS");
		}
		else
		{
			System.out.println(vendorName+" vendor is not verified & FAIL");
		}
		
		hp.getProductsLink().click();
		
		ProductsPage pp = new ProductsPage(driver);
		pp.getCreateProdButton().click();
		
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.getProductNameTB().sendKeys(productName);
		cnpp.getAddVendorsBtn().click();
		
		wl.switchToTabViaURL(driver, "module=Vendors");
		vp.getSearchTb().sendKeys(vendorName);
		vp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		
		wl.switchToTabViaURL(driver, "module=Products");
		cnpp.getSaveButton().click();
		
		ProductInfoPage pip = new ProductInfoPage(driver);
		String actualHead = pip.getHeaderInfo().getText();
		if(actualHead.contains(productName))
		{
			System.out.println(productName+" header is verified & PASS");
		}
		else
		{
			System.out.println(productName+" header is not verified & FAIL");
		}
		
		String vendorInfo =pip.getVendorInfo().getText();
		if(vendorInfo.contains(vendorName))
		{
			System.out.println(vendorName+" vendor name is verified & PASS");
		}
		else
		{
			System.out.println(vendorName+" vendor name is not verified & FAIL");
		}
		
		
		
//		driver.findElement(By.name("user_name")).sendKeys(Username);
//		driver.findElement(By.name("user_password")).sendKeys(Password);
//		driver.findElement(By.id("submitButton")).click();
//		
//		WebElement more = driver.findElement(By.linkText("More"));
//		wl.movingToElement(driver, more);
//		driver.findElement(By.name("Vendors")).click();
//		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
//		driver.findElement(By.name("vendorname")).sendKeys(vendorName);
//		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
//		
//		//verification vendor header
//				String actualVendor = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
//				if(actualVendor.contains(vendorName))
//				{
//					System.out.println(vendorName+" header is verified & PASS");
//				}
//				else
//				{
//					System.out.println(vendorName+" header is not verified & FAIL");
//				}
//				
//		//navigation to Products page
//				driver.findElement(By.linkText("Products")).click();
//				driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//				
//				driver.findElement(By.name("productname")).sendKeys(productName);
//				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
//		//switch to child		
//				wl.switchToTabViaURL(driver, "module=Vendors");
//				driver.findElement(By.name("search_text")).sendKeys(vendorName);
//				driver.findElement(By.name("search")).click();
//				driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
//		//switch to parent		
//				wl.switchToTabViaURL(driver, "module=Products");
//				
//				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
//				
//		//verification of product
//				
//				String actualHead = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
//				if(actualHead.contains(productName))
//				{
//					System.out.println(productName+" header is verified & PASS");
//				}
//				else
//				{
//					System.out.println(productName+" header is not verified & FAIL");
//				}
//				
//				String vendorInfo = driver.findElement(By.id("mouseArea_Vendor Name")).getText();
//				if(vendorInfo.contains(vendorName))
//				{
//					System.out.println(vendorName+" header is verified & PASS");
//				}
//				else
//				{
//					System.out.println(vendorName+" header is not verified & FAIL");
//				}
//				
//				
//				driver.quit();
		

	}

}
