package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
public class GetProdDataUsingDataProvider {

	@Test(dataProvider = "getData")
	public void getDataFromAmazon(String brand, String product) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		//searching product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brand,Keys.ENTER);
		
		//capture product info
		String pricePath="//span[text()='"+product+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']";
		String price = driver.findElement(By.xpath(pricePath)).getText();
		System.out.println(price);
		
		driver.quit();
	}
	@DataProvider
	public Object[][] getData() throws Exception 
	{
		ExcelUtility el = new ExcelUtility();
		int rowCount = el.getRowCount("AmazonProd");
		
		Object[][] objArr = new Object[rowCount][2];
		for(int i=0;i<rowCount;i++)
		{
			objArr[i][0]=el.getDataFromExcel("AmazonProd", i+1, 0);
			objArr[i][1]=el.getDataFromExcel("AmazonProd", i+1, 1);
		}
		return objArr;
	}
}
