package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import generic.fileUtility.ExcelUtility;
import generic.fileUtility.FileUtility;
import generic.webDriverUtility.WebDriverUtility;
import objectRepositoryUtility.LoginPage;

public class FetchDataFromExcelUsingDataProvider {

//	@Test
//	public void getData() throws Throwable {
//		FileUtility flib = new FileUtility();
//		WebDriverUtility wlib = new WebDriverUtility();
//		
//		String Url = flib.getDataFromPropertiesFile("url");
//		String Username = flib.getDataFromPropertiesFile("username");
//		String Password = flib.getDataFromPropertiesFile("password");
//		
//		WebDriver driver = new ChromeDriver();
//		
//		wlib.maximizeWindow(driver);
//		driver.get(Url);
//		wlib.implicitlyWait(driver);
//		
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToApp(Url, Username, Password);		
//	}
	
		/********** OR ************/
	
	@Test(dataProvider = "genericDataProvider")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Search Product
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys(brandName, Keys.ENTER);

		// Capture Product
		String x = "//span[text()='" + productName + "']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);

		driver.quit();
	}
	
	public Object[][] genericDataProvider() throws Throwable{
		ExcelUtility elib = new ExcelUtility();
		Object[][] value = elib.dataProvider("amazon");
		return value;
	}
}
