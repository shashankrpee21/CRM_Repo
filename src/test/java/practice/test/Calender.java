package practice.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Calender {

	@Test
	public void RedBus() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='dateText']")).click();
		driver.findElement(By.xpath("//span[text()='21']")).click();
		driver.quit();
	}
	
	@Test
	public void irctc_calender() throws Throwable {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//i[@class='fa fa-calendar']")).click();
			
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(dateObj);
		WebElement ele = driver.findElement(By.xpath("//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']"));
		
		ele.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A); 
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
		
        ele.sendKeys(date);
	}
	
	@Test
	public void MakeMyTrip() {
		String monthAndDate = "August 2025";
		int date = 18;

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();

		for (;;) {
			try {
				//String	expectedDate = driver.findElement(By.xpath("//div[text()='" + monthAndDate + "']")).getText();
				//if (monthAndDate.equals(expectedDate)) {
					driver.findElement(By.xpath("//div[text()='"+monthAndDate+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
					break;
				//}
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
	}
	
	@Test
	public void AirIndia() {
		String depMonAndYr = "March 2025";
		int dpDate = 18;

		String arrMonAndYr = "August 2025";
		int arDate = 18;

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://www.airindia.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-accept-btn-handler"))).click();

		driver.findElement(By.id("dpFromDate")).click();

		WebElement depDate = driver.findElement(By.xpath("//div[text()=' " + depMonAndYr + " ']/ancestor::div[@class='ngb-dp-month']/descendant::div[text()=' " + dpDate + " ']"));
		depDate.click();

		WebElement arrDate = driver.findElement(By.xpath("//div[text()=' " + arrMonAndYr + " ']/ancestor::div[@class='ngb-dp-month']/descendant::div[text()=' " + arDate + " ']"));
		WebElement nxtMonth = driver.findElement(By.xpath("//button[@title='Next month']"));

		for (;;) {
			try {
				String expectedDate = driver.findElement(By.xpath("//div[text()=' " + depMonAndYr + " ']")).getText();
				if (arrMonAndYr.equals(expectedDate)) {
					arrDate.click();
					break;
				}
			} catch (Exception e) {
				nxtMonth.click();
			}
		}

		driver.findElement(By.xpath("//button[@class='return-fair-confirm-btn']")).click();
	}
	
	
}
