package com.comcast.crm.producttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectutility.CreateNewProductPage;
import com.comcast.crm.objectutility.CreateNewVendorPage;
import com.comcast.crm.objectutility.HomePage;
import com.comcast.crm.objectutility.ProductInfoPage;
import com.comcast.crm.objectutility.ProductsPage;
import com.comcast.crm.objectutility.VendorInfoPage;
import com.comcast.crm.objectutility.VendorsPage;

public class CreateProductTest extends BaseClass{

	@Test(groups="smokeTest")
	public void createProductTest() throws Exception	
	{
		
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String productName = el.getDataFromExcel("Product", 1, 2)+jl.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create product page");
		ProductsPage pp = new ProductsPage(driver);
		pp.getCreateProdButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Creating new product");
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.getProductNameTB().sendKeys(productName);
		cnpp.getSaveButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Validation started");
		ProductInfoPage pip = new ProductInfoPage(driver);
		String actualProductHeader = pip.getHeaderInfo().getText();
		boolean status = actualProductHeader.contains(productName);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS, "Product creation verified");
		
		String actualProductInfo = pip.getProductInfo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualProductInfo, productName);
		UtilityClassObject.getTest().log(Status.PASS, "Product name verified");
		soft.assertAll();
			
	}
	
	@Test(groups="regressionTest")
	public void createProductWithSupportDateTest() throws Exception	
	{
		
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String productName = el.getDataFromExcel("Product", 4, 2)+jl.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create product page");
		ProductsPage pp = new ProductsPage(driver);
		pp.getCreateProdButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Creating new product");
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.getProductNameTB().sendKeys(productName);
		
		String todayDate = jl.getSystemDateInYYYYMMDD();
		String supportDate = jl.getRequiredDateInYYYYMMDD(30);
		UtilityClassObject.getTest().log(Status.INFO, "Adding support dates");
		cnpp.getSupportStartDate().sendKeys(todayDate);
		cnpp.getSupportEndDate().sendKeys(supportDate);
		
		cnpp.getSaveButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Validation started");
		ProductInfoPage pip = new ProductInfoPage(driver);
		String actualProductHeader = pip.getHeaderInfo().getText();
		boolean status = actualProductHeader.contains(productName);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS, "Product creation verified");
				
		String actualProductInfo = pip.getProductInfo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualProductInfo, productName);
		UtilityClassObject.getTest().log(Status.PASS, "Product name verified");
				
		String actualTodayDate =pip.getStartDateInfo().getText();
		soft.assertEquals(actualTodayDate, todayDate);
		UtilityClassObject.getTest().log(Status.PASS, "Support start date verified");
				
		String actualSupportDate =pip.getEndDateInfo().getText();
		soft.assertEquals(actualSupportDate, supportDate);
		UtilityClassObject.getTest().log(Status.PASS, "Support end date verified");
		soft.assertAll();
		
	}
	
	@Test(groups="regressionTest")
	public void createProductWithVendorTest() throws Exception	
	{
		
		UtilityClassObject.getTest().log(Status.INFO, "Reading data from excel");
		String productName = el.getDataFromExcel("Product", 7, 2)+jl.getRandomNumber();
		String vendorName = el.getDataFromExcel("Product", 7, 3)+jl.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to home page");
		HomePage hp = new HomePage(driver);
		WebElement more = hp.getMoreLink();
		wl.movingToElement(driver, more);
		hp.getVendorsLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create vendor page");
		VendorsPage vp = new VendorsPage(driver);
		vp.getCreateVendorButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Creating new vendor");
		CreateNewVendorPage cnvp = new CreateNewVendorPage(driver);
		cnvp.getVendorNameTB().sendKeys(vendorName);
		cnvp.getSaveButton().click();
		wl.waitForPageToLoad(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, "Validating vendor creation");
		VendorInfoPage vip = new VendorInfoPage(driver);
		String actualVendor = vip.getHeaderInfo().getText();
		boolean status = actualVendor.contains(vendorName);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.PASS, "Vendor creation verified");
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to product page");
		hp.getProductsLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create product page");
		ProductsPage pp = new ProductsPage(driver);
		pp.getCreateProdButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Creating new product");
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.getProductNameTB().sendKeys(productName);
		cnpp.getAddVendorsBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Switching to child vendor search window");
		wl.switchToTabViaURL(driver, "module=Vendors");
		UtilityClassObject.getTest().log(Status.INFO, "Searching & selecting vendor");
		vp.getSearchTb().sendKeys(vendorName);
		vp.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Switching back to parent window & saving product information");
		wl.switchToTabViaURL(driver, "module=Products");
		cnpp.getSaveButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Verification started");
		ProductInfoPage pip = new ProductInfoPage(driver);
		String actualHead = pip.getHeaderInfo().getText();
		boolean status2 = actualHead.contains(productName);
		Assert.assertEquals(status2, true);
		UtilityClassObject.getTest().log(Status.INFO, "Product name verified");
		
		String vendorInfo =pip.getVendorInfo().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(vendorInfo, vendorName);
		UtilityClassObject.getTest().log(Status.INFO, "Vendor name verified");
		soft.assertAll();
		
	}	
}
