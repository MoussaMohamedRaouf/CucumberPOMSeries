package AppHooks;

import com.resources.factory.DriverFactory;
import com.resources.util.ConfigReader;
import com.resources.util.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Ignore;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

    private WebDriver driver;
    Properties prop;

    @Before(value="@Skip", order = 0)
    @Ignore("Ticket")
    public void skip_scenario(Scenario scenario){
        System.out.println("SKIP SCENARIO: " + scenario.getName());
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
