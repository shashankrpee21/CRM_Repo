package practice.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        //driver.get("http://localhost:8888/"); s
        driver.get("https://upsc.gov.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        // Find all the links on the page
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println(links.size());

        // Loop through the links and check if they are broken
        for (WebElement eachLink : links) {
            String link = eachLink.getDomAttribute("href");
            
            try {
            	URL url = new URL(link);
            	
            	HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
            	
            	int statusCode = httpcon.getResponseCode();
            	if(statusCode>=400) {
            		System.out.println(link+"---->"+statusCode);
            	}
            }catch (Exception e) {
				
			} 
        }
       driver.close();
	}
}
