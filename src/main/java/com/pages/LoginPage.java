package com.pages;

import com.resources.factory.DriverFactory;
import com.resources.util.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginPage  {
    Properties prop;

    private final WebDriver driver;
    private final By emailID = By.id("email");
    private final By passwordID = By.id("passwd");
    private final By submitButtonID = By.id("SubmitLogin");
    private final By forgotPasswordLT = By.linkText("Forgot your password?");
private String password;
private String loginUrl;
private String username;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        initProperties();
    }
    public void initProperties(){
        ConfigReader configReader = new ConfigReader();
        prop = configReader.initProp();
        password = prop.getProperty("password");
        username = prop.getProperty("username");
        loginUrl = prop.getProperty("loginUrl");
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

    public void getToLoginURL() {
        DriverFactory.getDriver().get(loginUrl);
    }

}
