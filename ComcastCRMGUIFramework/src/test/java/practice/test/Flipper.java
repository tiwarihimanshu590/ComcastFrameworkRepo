package practice.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipper {
	
	@Test
	public void getProdPrice() throws EncryptedDocumentException, IOException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		FileInputStream fis = new FileInputStream("C:\\Users\\HJELLO\\Desktop\\flipkartData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet("Flip");
		int rowCount = sheet.getLastRowNum();
		for(int i= 1;i<rowCount;i++)
		{
			Row row = sheet.getRow(i);
			String prod = row.getCell(0).toString();
			driver.findElement(By.name("q")).sendKeys(prod,Keys.ENTER);
			if(prod.equals("mobiles"))
			{
			String mobilePrice = driver.findElement(By.xpath("//div[text()='POCO C71 (Cool Blue, 128 GB)']/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]")).getText();
			wb.getSheet("Flip").getRow(1).createCell(2).setCellValue(mobilePrice);
			driver.findElement(By.name("q")).clear();
			}
			else if(prod.equals("kurtis"))
			{
			String kurtiPrice = driver.findElement(By.xpath("//a[@title=\"Women Abstract Viscose Rayon Frontslit Kurta\"]/parent::div/descendant::div[@class=\"Nx9bqj\"]")).getText();
			wb.getSheet("Flip").getRow(2).createCell(2).setCellValue(kurtiPrice);
			}
			
		}
		
		FileOutputStream fod = new FileOutputStream("C:\\Users\\HJELLO\\Desktop\\flipkartData.xlsx");
		wb.write(fod);
		wb.close();
		
		driver.quit();
		
	}
}


//prodName = row.getCell(1).toString();
//System.out.println(prod+"====="+prodName);
//driver.findElement(By.name("q")).sendKeys(prod,Keys.ENTER);
//String mobilePrice = driver.findElement(By.xpath("//div[text()='POCO C71 (Cool Blue, 128 GB)']/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]")).getText();
//wb.getSheet("Flip").getRow(1).createCell(2).setCellValue(mobilePrice);
