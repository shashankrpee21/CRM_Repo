package practice.test;

import org.junit.Assert;
import org.testng.annotations.Test;

public class InvoiceTest_RetryListener{
	
	@Test(retryAnalyzer = generic.listenerUtility.RetryListenerImplementation.class)
	public void createInvoiceTest(){
		System.out.println("execute createInvoiceTest");
		Assert.assertEquals("", "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
