package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyntraSearch {
	
	@Test
	public void getProducts()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys("denims",Keys.ENTER);
		////span[@class='product-discountedPrice'][number(translate(., 'Rs.', '')) > 1500]
	}

}
