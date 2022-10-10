package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    public void selectFromDropdownByVisibleText(WebElement element, String size) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(size);
    }

}
