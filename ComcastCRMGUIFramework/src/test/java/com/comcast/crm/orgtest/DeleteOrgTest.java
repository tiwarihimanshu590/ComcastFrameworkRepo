package com.comcast.crm.orgtest;

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
import com.comcast.crm.objectutility.CreateNewOrgPage;
import com.comcast.crm.objectutility.HomePage;
import com.comcast.crm.objectutility.LoginPage;
import com.comcast.crm.objectutility.OrganizationInfoPage;
import com.comcast.crm.objectutility.OrganizationPage;

public class DeleteOrgTest extends BaseClass{

	@Test
	public void deleteOrgTest() throws Exception
	{

		String orgName = el.getDataFromExcel("Org", 10, 2) +jl.getRandomNumber();

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
		
		// going back to organization page
		hp.getOrgLink().click();
		
		//search for organization to delete
		op.getSearchOrgTB().sendKeys(orgName);
		wl.selectFromDropDown(op.getSearchOrgDD(), "Organization Name");
		op.getSearchButton().click();
		
		// in dynamic web table select and delete organization
		driver.findElement(By.xpath("//a[text()='"+orgName+"' and @title='Organizations']/ancestor::tr[@bgcolor='white']/descendant::a[text()='del']")).click();
		wl.switchToAlertAccept(driver);
		
		//verification of deletion
		op.getSearchOrgTB().sendKeys(orgName);
		wl.selectFromDropDown(op.getSearchOrgDD(), "Organization Name");
		op.getSearchButton().click();
		
		if(op.getNoOrgMssg().isDisplayed())
		{
			System.out.println(orgName+" is deleted.");
		}
		else
		{
			System.out.println(orgName+" is not yet deleted");
		}
		
	}
}
