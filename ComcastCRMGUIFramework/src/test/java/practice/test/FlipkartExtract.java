package practice.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipkartExtract {
	
	@Test
	public void getProdPrice() throws EncryptedDocumentException, IOException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		FileInputStream fis = new FileInputStream("C:\\Users\\HJELLO\\Desktop\\flipkartData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		String product1 = wb.getSheet("Flip").getRow(1).getCell(0).getStringCellValue();
		String product2 = wb.getSheet("Flip").getRow(2).getCell(0).getStringCellValue();
		
		driver.findElement(By.name("q")).sendKeys(product1,Keys.ENTER);
		String mobilePrice = driver.findElement(By.xpath("//div[text()='POCO C71 (Cool Blue, 128 GB)']/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]")).getText();
		wb.getSheet("Flip").getRow(1).createCell(2).setCellValue(mobilePrice);	
		
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys(product2,Keys.ENTER);
		String kurtiPrice = driver.findElement(By.xpath("//a[@title=\"Women Abstract Viscose Rayon Frontslit Kurta\"]/parent::div/descendant::div[@class=\"Nx9bqj\"]")).getText();
		wb.getSheet("Flip").getRow(2).createCell(2).setCellValue(kurtiPrice);
		
		FileOutputStream fod = new FileOutputStream("C:\\Users\\HJELLO\\Desktop\\flipkartData.xlsx");
		wb.write(fod);
		wb.close();
	
	}
	
}



//Sheet sheet = wb.getSheet("Flip");
//int rowCount = sheet.getLastRowNum();
//Set<String> prod = null;
//Set<String> prodName = null;
//for(int i= 1;i<=rowCount;i++)
//{
//	Row row = sheet.getRow(i);
//	prod = (Set<String>) row.getCell(0);
//	prodName = (Set<String>) row.getCell(1);
//	for (String pro : prod) {
//		
//	}
//	//driver.findElement(By.name("q")).sendKeys(prod,Keys.ENTER);
//	if(prod.equals(prodName))
//	{
//		String mobilePrice = driver.findElement(By.xpath("//div[text()='POCO C71 (Cool Blue, 128 GB)']/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]")).getText();
//		wb.getSheet("Flip").getRow(1).createCell(2)driver. //.setCellValue(mobilePrice);
//	}
//	
//}