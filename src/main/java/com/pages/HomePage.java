package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private By signInButton = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    private By womenButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
    private By tShirtButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a");

    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }
    public LoginPage clickOnSignInButton() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public void Hover_Over_Women_Button() {
        Actions actions = new Actions(driver);
        WebElement womenButtonWE = driver.findElement(womenButton);
        actions.moveToElement(womenButtonWE).perform();
    }

    public TShirtsPage clickTShirtButton() {
        driver.findElement(tShirtButton).click();
        return new TShirtsPage(driver);
    }
}
