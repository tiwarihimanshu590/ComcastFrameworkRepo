package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryActivateSim {
	
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImplementClass.class)
	public void activateSim()
	{
		System.out.println("execute activateSim");
		Assert.assertEquals("", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
	}

}
