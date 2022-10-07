package com.pages;

import com.qa.util.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPage {
    Properties prop;
    private ConfigReader configReader;

    private WebDriver driver;
    private By emailID = By.id("email");
    private By passwordID = By.id("passwd");
    private By submitButtonID = By.id("SubmitLogin");
    private By forgotPasswordLT = By.linkText("Forgot your password?");
private String password;
private String username;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        initProperties();
    }
    public void initProperties(){
        configReader = new ConfigReader();
        prop = configReader.initProp();
        password = prop.getProperty("password");
        username = prop.getProperty("username");
    }
    /**
     * Page actions and it should be public in nature
     */
    public String  getLoginPageTitle(){
        return driver.getTitle();
    }
    public Boolean isForgotPasswordLink(){
        return driver.findElement(forgotPasswordLT).isDisplayed();
    }
    public void enterUserName(){
        driver.findElement(emailID).sendKeys(username);
    }
    public void enterPassword(){
        driver.findElement(passwordID).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(submitButtonID).click();
    }

    public AccountPage login(){
        driver.findElement(emailID).sendKeys(username);
        driver.findElement(passwordID).sendKeys(password);
        driver.findElement(submitButtonID).click();
        return new AccountPage(driver);
    }
}
