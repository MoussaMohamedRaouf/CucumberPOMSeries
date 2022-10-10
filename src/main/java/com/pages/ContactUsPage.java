package com.pages;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import com.qa.util.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ContactUsPage {
    private final WebDriver driver;

    Properties prop;
    private final String contactUrl;
    private final String excelFilePath;
    private final By subjectHeading = By.id("id_contact");
    private final By email = By.id("email");
    private final By orderRef = By.id("id_order");
    private final By messageText = By.id("message");
    private final By sendButton = By.id("submitMessage");
    private final By successMessg = By.cssSelector("div#center_column p");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        ConfigReader configReader = new ConfigReader();
        prop = configReader.initProp();
        contactUrl= prop.getProperty("contactUrl");
        excelFilePath = prop.getProperty("excelFilePath");
    }

    public void fillContactUsForm(String heading, String emailId, String orderReference, String message) {
        Select select = new Select(driver.findElement(subjectHeading));
        select.selectByVisibleText(heading);
        driver.findElement(email) .sendKeys(emailId);
        driver.findElement(orderRef) .sendKeys(orderReference);
        driver.findElement(messageText).sendKeys(message);
    }
    public void clickSend() {
        driver.findElement(sendButton).click();
    }
    public String getSuccessMessge() {
        return driver.findElement(successMessg).getText();
    }


    public void getToForm() {
        DriverFactory.getDriver().get(contactUrl);
    }

    public List<Map<String, String>> getMaps(String sheetName) throws InvalidFormatException,IOException{
            ExcelReader reader = new ExcelReader();
            List<Map<String,String>> testData;
            try {
                testData = reader.getData(excelFilePath, sheetName);
            } catch (InvalidFormatException e) {
                throw new InvalidFormatException("Runtime Exception occured"+e.getMessage());
            }catch (IOException e) {
                throw new IOException("Runtime Exception occured"+e.getMessage());
            }
            return testData;
    }
}
