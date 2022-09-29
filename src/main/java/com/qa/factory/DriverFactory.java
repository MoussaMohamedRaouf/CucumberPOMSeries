package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This is used to initialize the ThreadLocal driver on the basisi of the given browser
     * @param browser
     * @return
     */
    public WebDriver initDriver(String browser){
        System.out.println("Browser value is:"+browser);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }else if(browser.equals("firefox")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new FirefoxDriver());
        }else {
            System.out.println("Please pass the correct browser value:" +browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    /**
     * This is used to get the driver with ThreadLocal
     * @return
     */
    public static WebDriver getDriver(){
        return tlDriver.get();
    }
}
