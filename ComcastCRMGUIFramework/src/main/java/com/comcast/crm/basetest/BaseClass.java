package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectutility.HomePage;
import com.comcast.crm.objectutility.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelUtility el = new ExcelUtility();
	public DataBaseUtility db = new DataBaseUtility();
	public FileUtility fl = new FileUtility();
	public WebDriverUtility wl = new WebDriverUtility();
	public JavaUtility jl = new JavaUtility();
	public static WebDriver sdriver=null;

	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() throws Exception 
	{
		db.getDbConnection();
		System.out.println("===DB Connection established===");
		
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS() throws Exception 
	{
		db.closeDbConnection();
		System.out.println("===DB Connection closed===");

	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws Exception   //configBC(String browse)
	{
//		String BROWSER = browse;   
		String BROWSER = fl.getDataFromPropertiesFile("browser");
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		sdriver = driver;
		//UtilityClassObject.setDriver(driver);
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() 
	{
		driver.quit();
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Exception 
	{
		String URL = fl.getDataFromPropertiesFile("url");
		String USERNAME = fl.getDataFromPropertiesFile("username");
		String PASSWORD = fl.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() 
	{
		HomePage hp = new HomePage(driver);
		hp.signOut();
	}

}
