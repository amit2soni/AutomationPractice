package sdet.pageScroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Navigate to a webpage
        driver.get("https://www.cricbuzz.com");
        
       JavascriptExecutor js = (JavascriptExecutor)driver;
	
       //scroll by pixel
      // js.executeScript("window.scrollBy(0,1500)");
       
       // scroll the page till element is visible
       WebElement wb = driver.findElement(By.xpath("//div[@class='cb-col-25 cb-col']//img[@id='cb-logo-main-menu']"));
       js.executeScript("arguments[0].scrollIntoView()", wb);
       // print current scroll position
       System.out.println(js.executeAsyncScript("return window.pageYOffset;"));
       
       //scroll till end
       js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
       
       //scroll to initial position
       js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
       
       //file upload example
       driver.findElement(By.id("id")).sendKeys("path of file");
	}

}
