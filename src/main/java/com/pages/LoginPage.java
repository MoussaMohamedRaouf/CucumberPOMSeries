package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By emailID = By.id("email");
    private By passwordID = By.id("passwd");
    private By submitButtonID = By.id("SubmitLogin");
    private By forgotPasswordLT = By.linkText("Forgot your password?");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
    public void enterEmail(String email){
        driver.findElement(emailID).sendKeys(email);
    }
    public void enterPassword(String password){
        driver.findElement(passwordID).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(submitButtonID).click();
    }

    public AccountPage login(String userName, String password){
        System.out.println("Loging in with email: "+userName+" and password:"+password);
        driver.findElement(emailID).sendKeys(userName);
        driver.findElement(passwordID).sendKeys(password);
        driver.findElement(submitButtonID).click();
        return new AccountPage(driver);
    }
}
