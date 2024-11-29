package sdet.SimpleDataProviders;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.automationtesting.in/my-account/");
        driver.manage().window().maximize();
	}

	@Test(dataProvider="loginDP")
	public void login(String email , String password) {
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		boolean isLogoutVisible = driver.findElement(By.xpath("//a[normalize-space()='Logout']")).isDisplayed();
		Assert.assertTrue(isLogoutVisible);
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}
	
	// indices will only run test with provided test index data
	
	@DataProvider(name="loginDP",indices = {0,1})
	Object[][] loginData(){
		
		Object[][] data = {
				{"test@gmail.com","pass29e2e"},
				{"abc@test090.com","1234Test@@"},
				{"test@343gmail.com","pac2c23e2e"},
				{"tes432t@gmail.com","2c352@2e"}
		};
		
		return data;
		
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
