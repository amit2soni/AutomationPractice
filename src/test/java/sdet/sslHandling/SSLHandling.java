package sdet.sslHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//use below option to pass SSL certificate
		options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com");
	}

}
