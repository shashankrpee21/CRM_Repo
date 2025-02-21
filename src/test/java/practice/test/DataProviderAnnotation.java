package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.fileUtility.ExcelUtility;

//@Listeners(com.comcast.crm.listenerUtility.ListenerImlementationClass.class)
public class DataProviderAnnotation {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Search Product
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys(brandName, Keys.ENTER);

		// Capture Product
		String x = "//span[text()='" + productName
				+ "']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);

		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws Throwable {

		ExcelUtility elib = new ExcelUtility();
		int rowCount = elib.getRowCount("amazon");// Excel sheet name

		Object[][] objArr = new Object[rowCount][2];

		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = elib.getDataFromExcel("amazon", i + 1, 0);
			objArr[i][1] = elib.getDataFromExcel("amazon", i + 1, 1);

		}
		return objArr;
	}
}
