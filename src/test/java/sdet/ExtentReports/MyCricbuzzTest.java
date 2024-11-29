package sdet.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

//@Listeners({sdet.ListenersTestNG.MyListener.class})
public class MyCricbuzzTest {

    WebDriver driver;
    @BeforeClass
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cricbuzz.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void verifyTitle() {

        boolean isTitleCorrect = "Live Cricket Score, Schedule, Latest News, Stats & Videos | Cricbuzz.com".equals(driver.getTitle());
        Assert.assertTrue(isTitleCorrect);
    }

    @Test(priority = 2)
    public void verifyURL() {

        boolean isURLCorrect = "https://www.cricbuzz.com/dd".equals(driver.getCurrentUrl());
        Assert.assertTrue(isURLCorrect);
    }

    @Test(priority = 3 , dependsOnMethods = {"verifyURL"})
    public void verifyCricbuzzPlus() {

        boolean isPresent = driver.findElement(By.xpath("//a[@id='cricbuzz-plus-main-menu']")).isDisplayed();
        Assert.assertTrue(isPresent);
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
