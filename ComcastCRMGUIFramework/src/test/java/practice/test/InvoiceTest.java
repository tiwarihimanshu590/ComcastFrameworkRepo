package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class InvoiceTest extends BaseClass{
	
	@Test
	public void createInvoiceTest()
	{
		System.out.println("execute createInvoiceTest");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
	}
	
	@Test
	public void createInvoiceWithDateTest()
	{
		System.out.println("execute createInvoiceWithDateTest");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
	}

}
