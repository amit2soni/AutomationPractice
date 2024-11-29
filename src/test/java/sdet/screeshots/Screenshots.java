package sdet.screeshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to a webpage
        driver.get("https://www.cricbuzz.com");
        driver.manage().window().maximize();
        TakesScreenshot ts = (TakesScreenshot)driver;
        
        // full page ss
//        File fullpage = ts.getScreenshotAs(OutputType.FILE);
//        File target = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\fullpage.png");
//        fullpage.renameTo(target);
        
        // capture specific section
        WebElement mainMenu = driver.findElement(By.xpath("//nav[@id='cb-main-menu']"));
        File menu = mainMenu.getScreenshotAs(OutputType.FILE);
        File targetMenu = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\mainMenu.png");
        menu.renameTo(targetMenu);
        
        driver.quit();
	}

}
