package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Properties;

public class HomePage {
    Properties prop;

    private final By signInButton = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    private final By womenButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
    private final By tShirtButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a");

    private final WebDriver driver;
    private final String homeUrl;
    public HomePage(WebDriver driver) {
        this.driver=driver;
        ConfigReader configReader = new ConfigReader();
        prop = configReader.initProp();
        homeUrl = prop.getProperty("homeUrl");

    }

    public String getTitle(){
        return driver.getTitle();
    }
    public LoginPage clickOnSignInButton() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public void hoverOverWomenButton() {
        Actions actions = new Actions(driver);
        WebElement womenButtonWE = driver.findElement(womenButton);
        actions.moveToElement(womenButtonWE).perform();
    }

    public TShirtsPage clickTShirtButton() {
        driver.findElement(tShirtButton).click();
        return new TShirtsPage(driver);
    }

    public void getHome() {
        DriverFactory.getDriver().get(homeUrl);

    }
}
