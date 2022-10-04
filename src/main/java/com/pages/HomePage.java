package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private By searchInput = By.id("search_query_top");
    private By searchButton = By.className("btn btn-default button-search");
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String  getTitle(){
        return driver.getTitle();
    }
    public void enterSearch(String text){
        driver.findElement(searchInput).sendKeys(text);
    }
    public SearchPage clickSearch(){
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }
}
