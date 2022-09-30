package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {
    private WebDriver driver;
    private By accountSection = By.cssSelector("div#center_column span");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public int getAccountSections(){
        return driver.findElements(accountSection).size();
    }
    public List<String> getAccountsSectionList(){
        List<String> accountsList = new ArrayList<>();
        List<WebElement> accountWEList =  driver.findElements(accountSection);
        for (WebElement e : accountWEList){
            String text = e.getText();
            System.out.println(text);
            accountsList.add(text);
        }
        return accountsList;
    }

}
