package sdet.incognitoMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncognitoMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        
        // Navigate to a webpage
        driver.get("https://www.cricbuzz.com");
        System.out.println("Passed");
        driver.quit();
	}

}
