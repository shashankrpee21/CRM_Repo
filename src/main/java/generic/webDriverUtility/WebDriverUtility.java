package generic.webDriverUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/*
	 * minimize - maximize //Implicit wait //Explicit wait - 6 () //frames //Alert
	 * Action - movetoElement, drag&drop, right click, double click, scroll,
	 * scroll&clickOnEle, send keys dropDown, switch btw windows //TakeScreenShot
	 * //JSE - scroll, scroll to element
	 */

	// Minimize Window in Selenium 4 and above
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	// Minimize Window in Selenium 4 Below
	public void minimizeWindowWithRobot(WebDriver driver) throws Throwable {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_SPACE);
		robot.keyRelease(KeyEvent.VK_SPACE);
		robot.keyPress(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_N);
		robot.keyRelease(KeyEvent.VK_ALT);
	}

	// Maximize Window
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	//Page Load Timeout
	public void pageLoadTimeout(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}

	// Implicit Wait
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	// Explicit Wait
	public void explicitWaitUsingVisibilityOf(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void explicitWaitVisibilityOfAllElements(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void explicitWaitVisibilityOfElementLocated(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void explicitWaitElementToBeClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}	

	public void explicitWaitElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}	

	public void explicitWaitUrlContains(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains(url));
	}

	public void explicitWaitTitleContains(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void explicitWaitTextToBePresentInElement(WebDriver driver, WebElement ele, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
	}

	// Open Empty Window
	public void openNewEmptyTab(WebDriver driver) {
		driver.switchTo().newWindow(WindowType.TAB);
	}

	// Switch To Tab
	public void swtichToTabOnUrl(WebDriver driver, String partialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialUrl)) {
				break;
			}
		}
	}

//	public void switchtotabonurl(WebDriver driver, String partialUrl) {
//		Set<String> set = driver.getWindowHandles();
//		for(String st : set) {
//			driver.switchTo().window(partialUrl);
//			String actUrl =driver.getTitle();
//			if (actUrl.contains(partialUrl)) {
//				break;
//			}
//		}
//	}

	public void swtichToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialTitle)) {
				break;
			}
		}
	}

	// Frames
	public void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameById(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	public void switchToFrameByElement(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public void swtichToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void swtichToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// Alerts
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void AlertPopupText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.getText();
	}

	public void AlertPopupSendKeys(WebDriver driver, String keysToSend) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(keysToSend);
	}

	// Select - Drop down
	public void select(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void select(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void selectByContainsVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByContainsVisibleText(text);
	}

	public void handleDropdownGetOptions(WebElement ele) {
		Select s = new Select(ele);
		s.getOptions();
	}

	public void handleDropdownAllSelectedOptions(WebElement ele) {
		Select s = new Select(ele);
		s.getAllSelectedOptions();
	}

	public void handleDropdownFirstSelectedOption(WebElement ele) {
		Select s = new Select(ele);
		s.getFirstSelectedOption();
	}

	public boolean isMultiple(WebElement ele) {
		Select s = new Select(ele);
		boolean result = s.isMultiple();
		return result;
	}

	public void handleDropdownDeselectAll(WebElement ele) {
		Select s = new Select(ele);
		s.deselectAll();
	}

	public void handleDropdownDeselectByVisibleText(WebElement ele, String text) {
		Select s = new Select(ele);
		s.deselectByVisibleText(text);
	}

	public void handleDropdownDeselectByIndex(WebElement ele, int index) {
		Select s = new Select(ele);
		s.deselectByIndex(index);
	}

	// Actions
	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	public void dragDrop(WebDriver driver, WebElement src, WebElement dst) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}

	public void dragDropBy(WebDriver driver, WebElement src, int x, int y) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(src, x, y).perform();
	}

	public void rightClick(WebDriver driver, WebElement rClick) {
		Actions act = new Actions(driver);
		act.contextClick(rClick).perform();
	}

	public void rightClickAction(WebDriver driver, WebElement ele) throws AWTException {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
	}

	public void doubleClickActions(WebDriver driver, WebElement dClick) {
		Actions act = new Actions(driver);
		act.doubleClick(dClick).perform();
	}

	public void scrollToElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
	}

	public void scrollToElementClick(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.scrollToElement(ele).click().perform();
	}

	public void sendKeysAction(WebDriver driver, WebElement ele, String text) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().sendKeys(text);
	}

	public void scrollToElementClick(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}

	public void clickAndHold(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.clickAndHold(ele).perform();
	}

	// Take Screen Shot
	public void takeScreenShot(WebDriver driver) throws Throwable {
		String pics = "./screenShot/";
		Date d = new Date();
		String d1 = d.toString();
		String d2 = d1.replaceAll(":", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(pics + d2 + ".jpeg");
		FileHandler.copy(src, dst);
	}

	public void takeScreenshot(WebDriver driver, WebElement ele) throws IOException {
		String pics = "./screenShot/";
		Date d = new Date();
		String d1 = d.toString();
		String d2 = d1.replaceAll(":", "_");
		File src = ele.getScreenshotAs(OutputType.FILE);
		File dst = new File(pics + d2 + ".jpeg");
		FileHandler.copy(src, dst);
	}

	// Java Script Executor
	public void scrollToElementUsingJS(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	public void scrollUsingJS(WebDriver driver, WebElement ele, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
	}

	public void handleDisableElement(WebDriver driver, String id, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById(" + id + ").value=" + data + "");
	}

}