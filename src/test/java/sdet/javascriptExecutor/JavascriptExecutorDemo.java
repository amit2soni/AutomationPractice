package sdet.javascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class JavascriptExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Navigate to a webpage
        driver.get("https://www.cricbuzz.com");
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        
        WebElement liveScore = driver.findElement(By.cssSelector("a[title='Live Cricket Score']"));
        
        js.executeScript("arguments[0].click()", liveScore);
        		
        WebElement more = driver.findElement(By.xpath("//header[@id='top']//div[6]"));
        js.executeScript("arguments[0].click()", more);
        
        WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contact Us']"));
        js.executeScript("arguments[0].click()", contact);
        
        WebElement name = driver.findElement(By.xpath("//input[@id='cb-contact-name']"));
        js.executeScript("arguments[0].setAttribute('value','Amit')", name);
        
        //driver.quit();

	}

}
