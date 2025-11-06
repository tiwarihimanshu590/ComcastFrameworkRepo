package practice.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class flipkartPriceExtract {
	
	@Test
	public void getProdPrice() throws EncryptedDocumentException, IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		FileInputStream fis = new FileInputStream("C:\\Users\\HJELLO\\Desktop\\flipkartData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		String product1 = "mobiles";
		driver.findElement(By.name("q")).sendKeys(product1,Keys.ENTER);
		
		//capture price
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='KzDlHZ']/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]"));
		
		int index=1;
		for(int i=0;i<names.size();i++)
		{
			String prodName = names.get(i).getText();
			String prodPrice = prices.get(i).getText();
			System.out.println(prodName+"===="+prodPrice);
			
			Row row = wb.getSheet("Prod").createRow(index++);
			row.createCell(0).setCellValue(product1);
			row.createCell(1).setCellValue(prodName);
			row.createCell(2).setCellValue(prodPrice);
			
		}
		FileOutputStream fod = new FileOutputStream("C:\\Users\\HJELLO\\Desktop\\flipkartData.xlsx");
		wb.write(fod);
		wb.close();
		
		driver.quit();
	}
	

}
