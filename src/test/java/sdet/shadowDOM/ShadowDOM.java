package sdet.shadowDOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        // shadow dom is dom inside dom
		// the main document contains shadow host
		// these hosts hold the shadow roots
		// and these shadow roots contains elements/tree
		// shadow dom cannot be handled by xpath 
		// it can only be handled by css selectors
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to a webpage
        driver.get("https://dev.automationtesting.in/shadow-dom");
        driver.manage().window().maximize();
        
      //This Element is inside 3 nested shadow DOM.
        String cssSelectorForHost1 = "#shadow-root";
        String cssSelectorForHost2 = "#inner-shadow-dom";
        String cssSelectorForHost3 = "#nested-shadow-dom";
        Thread.sleep(1000);
        SearchContext shadow0 = driver.findElement(By.cssSelector(cssSelectorForHost1)).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(By.cssSelector(cssSelectorForHost2)).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow2 = shadow1.findElement(By.cssSelector(cssSelectorForHost3)).getShadowRoot();
        Thread.sleep(1000);
        System.out.println(shadow2.findElement(By.cssSelector("#multi-nested-shadow-element")).getText());
	}

}
