package sdet.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    LoginPage(WebDriver driver){
        this.driver = driver;
    }


    By email_loc =  By.xpath("//input[@id='username']");
    By password_loc = By.xpath("//input[@id='password']");
    By login_btn_loc = By.xpath("//input[@name='login']");

    public void setEmail(String email){
        driver.findElement(email_loc).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(password_loc).sendKeys(password);
    }

    public void clickOnLogin(){
        driver.findElement(login_btn_loc).click();
    }
}
