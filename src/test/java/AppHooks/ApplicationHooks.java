package AppHooks;

import com.resources.factory.DriverFactory;
import com.resources.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import testrunners.MyTestCase;

import java.util.Properties;

public class ApplicationHooks {

    private WebDriver driver;
    Properties prop;
    public static Logger log = LogManager.getLogger(MyTestCase.class);


    @Before(value="@Skip", order = 0)
    public void skip_scenario(Scenario scenario){
        log.debug("Sample DEBUG message");
        log.error("Sample ERROR message");
        log.info("Sample INFO message");
        log.warn("Sample WARN message");
        System.out.println("Skipped scenario is :"+ scenario.getName());

    }
    @Before(order = 1)
    public void getProperty(){
        ConfigReader configReader = new ConfigReader();

        prop = configReader.initProp();
    }
    @Before(order = 2)
    public void launchBrowser(){
        String browserName = prop.getProperty("browser");
        if (driver == null) {
            log.info("Starting logs...");
        }
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initDriver(browserName);
    }
    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }
    @After(order = 1)
    public void tearDown(Scenario scenario){
    if (scenario.isFailed()){
        String screenShotName = scenario.getName().replaceAll("","_");
        byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath,"image/png",screenShotName);
    }
    }
}
