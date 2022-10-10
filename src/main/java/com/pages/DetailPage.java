package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailPage extends BasePage {

    private final By plusButton = By.id("quantity_wanted_p");
    private final By dropDown = By.id("group_1");
    private final By color = By.id("color_14");
    private final By proceedButton = By.linkText("Proceed to checkout");
    private final By addButton = By.className("exclusive added");
    private final By layerCart = By.id("layer_cart");

    private final WebDriver driver;
    public DetailPage(WebDriver driver) {
        this.driver=driver;
    }

    public void increaseQte() {
        driver.findElement(plusButton).click();
    }

    public void updateSize(String size) {
        selectFromDropdownByVisibleText(driver.findElement(dropDown),size);
    }

    public void updateColor() {
        driver.findElement(color).click();
    }
    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void clickProcedButton() {
        driver.findElement(proceedButton).click();
    }
}
