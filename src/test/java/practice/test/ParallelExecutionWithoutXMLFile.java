package practice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelExecutionWithoutXMLFile {

	@Test(threadPoolSize = 3, invocationCount = 4)
	public void Parallel_Execution_Without_xmlFile() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.gmail.com");
		Thread.sleep(1000);
		driver.quit();
	}
	
}
