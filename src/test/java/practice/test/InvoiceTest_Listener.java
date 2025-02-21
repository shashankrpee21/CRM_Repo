package practice.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import generic.baseTest.BaseClass;

public class InvoiceTest_Listener  extends BaseClass{
	
	@Test
	public void createInvoiceTest(){
		System.out.println("execute createInvoiceTest");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	@Test
	public void createInvoiceWithContactTest(){
		System.out.println("execute createInvoiceWithContactTest");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
