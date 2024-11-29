package sdet.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory {

    WebDriver driver;
    LoginPageWithPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(how = How.XPATH,using = "//input[@id='username']")
    WebElement emailBox;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordBox;

    @FindBy(xpath = "//input[@name='login']")
    WebElement login_btn;

    public void setEmail(String email){
        emailBox.sendKeys(email);
    }

    public void setPassword(String password){
        passwordBox.sendKeys(password);
    }

    public void clickOnLogin(){
        login_btn.click();
    }
}
