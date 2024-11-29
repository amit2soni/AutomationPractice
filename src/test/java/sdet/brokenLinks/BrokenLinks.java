package sdet.brokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to a webpage
        driver.get("http://www.deadlinkcity.com/");
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
	
	    int blinks = 0;
	    
	    for(WebElement wb : links) {
	    	
	    	String hrefValue = wb.getAttribute("href");
	    	
	    	if(hrefValue==null || hrefValue.isEmpty()) {
	    		System.out.println("href is empty");
	    		continue;
	    	}
	    	
	    	try {
				URL url = new URL(hrefValue);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.connect();
				
				if(conn.getResponseCode()>=400) {
					System.out.println(hrefValue+" - "+"Broken link");
					blinks++;
				}else {
					System.out.println(hrefValue+" - "+"Not a Broken link");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    	
	    }
	    System.out.println("Number of broken links - "+blinks);
	}

}
