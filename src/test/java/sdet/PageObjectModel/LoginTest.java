package sdet.PageObjectModel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/my-account/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest(){
        LoginPageWithPageFactory lp = new LoginPageWithPageFactory(driver);
        lp.setEmail("abc@test090.com");
        lp.setPassword("1234Test@@");
        lp.clickOnLogin();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
