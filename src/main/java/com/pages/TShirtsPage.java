package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TShirtsPage {
    private WebDriver driver;
    private By productDiv = By.xpath("//*[@id=\"center_column\"]/ul/li");
    private By moreButton = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]");

    public TShirtsPage(WebDriver driver) {
        this.driver=driver;
    }

    public void hoverFirstProduct() {
        Actions actions = new Actions(driver);
        WebElement productDivWE = driver.findElement(productDiv);
        actions.moveToElement(productDivWE).perform();
    }

    public DetailPage clickMoreButton() {
        driver.findElement(moreButton).click();
        return new DetailPage(driver);
    }
}
