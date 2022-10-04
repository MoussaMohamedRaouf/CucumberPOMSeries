package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    private By productListCN  = By.className("product_list grid row");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    public String  getTitle(){
        return driver.getTitle();
    }








}
