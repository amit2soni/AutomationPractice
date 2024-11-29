package sdet.XMlParametrisationAndParallelTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricbuzzTest {
   
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser"})
	public void beforeMethod(String br) {
		switch(br) {
		case "chrome" :
			WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        break;
		case "edge" :
			WebDriverManager.edgedriver().setup();
	        driver = new EdgeDriver();
	        break;
		case "firefox" :
			WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	        break;
	    default :
	    	System.out.println("Invalid Browser");
	    	return;
		}
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cricbuzz.com/");
        driver.manage().window().maximize();
	}

	@Test
	public void verifyTitle() {

		boolean isTitleCorrect = "Live Cricket Score, Schedule, Latest News, Stats & Videos | Cricbuzz.com".equals(driver.getTitle());
		Assert.assertTrue(isTitleCorrect);
	}
	
	@Test
	public void verifyURL() {

		boolean isURLCorrect = "https://www.cricbuzz.com/".equals(driver.getCurrentUrl());
		Assert.assertTrue(isURLCorrect);
	}
	
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
