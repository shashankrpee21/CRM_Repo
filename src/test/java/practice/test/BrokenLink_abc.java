package practice.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink_abc {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8888/"); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        // Find all the links on the page
        List<WebElement> links = driver.findElements(By.xpath("//a"));

        // Loop through the links and check if they are broken
        for (WebElement link : links) {
            String url = link.getDomAttribute("href");
            checkLink(url);
        }

        // Close the browser
        driver.quit();
    }

    // Method to check the status of the URL
    public static void checkLink(String url) throws IOException {
        // Skip null or empty URLs
        if (url == null || url.isEmpty()) {
            return;
        }

        // Create a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");  // Use HEAD to check the status without downloading the content
        connection.connect();

        // Get the HTTP response code
        int responseCode = connection.getResponseCode();
        
        // Print the response code for the link
        if (responseCode >= 400) {
            System.out.println("Broken link: " + url + " - Response Code: " + responseCode);
        } else {
            System.out.println("Valid link: " + url + " - Response Code: " + responseCode);
        }

        // Disconnect the connection after checking the URL
        connection.disconnect();
    }
}
