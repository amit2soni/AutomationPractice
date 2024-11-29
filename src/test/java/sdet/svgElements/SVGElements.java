package sdet.svgElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // instead of using //svg we have to use [name()='svg']
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigate to a webpage
        driver.get("https://developer.mozilla.org/en-US/docs/Web/SVG/Element/marker");
        driver.manage().window().maximize();
        
        WebElement svg = driver.findElement(By.xpath("/html/body//*[name()='svg' and @id='mdn-docs-logo']"));
        
        System.out.println(svg.getText());
	}

}
