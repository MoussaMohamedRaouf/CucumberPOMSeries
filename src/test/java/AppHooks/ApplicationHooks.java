package AppHooks;

import com.resources.factory.DriverFactory;
import com.resources.util.ConfigReader;
import com.resources.util.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

    private WebDriver driver;
    Properties prop;
    private final Logger LOG = LogManager.getLogger(ApplicationHooks.class);


    @Before(value="@Skip", order = 0)
    public void skip_scenario(Scenario scenario){
        System.out.println("SKIP SCENARIO: " + scenario.getName());
        Assume.assumeTrue(false);
    }
    @Before(order = 1)
    public void getProperty(){
        ConfigReader configReader = new ConfigReader();

        prop = configReader.initProp();
    }
    @Before(order = 2)
    public void launchBrowser(Scenario scenario){
        Log.startScenario(scenario.getName());
        String browserName = prop.getProperty("browser");
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.initDriver(browserName);
    }
    @After(order = 0)
    public void quitBrowser(Scenario scenario){
        Log.endScenario(scenario.getName());
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
