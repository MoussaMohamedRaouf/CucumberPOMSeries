package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DetailPage extends BasePage {

    private By plusButton = By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]");

    @FindBy(how = How.ID, using = "//*[@id=\"group_1\"]")
    WebElement dropdown;
    @FindBy(how = How.XPATH, using = "//*[@id=\"color_14\"]")
    WebElement color;
    private WebDriver driver;
    public DetailPage(WebDriver driver) {
        this.driver=driver;
    }

    public void increaseQte() {
        driver.findElement(plusButton).click();
    }

    public void updateSize(String l) {
        selectFromDropdownByVisibleText(dropdown,l);
    }

    public void updateColor() {
        color.click();
    }
}
