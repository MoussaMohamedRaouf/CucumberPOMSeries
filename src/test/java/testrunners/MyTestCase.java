package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src/test/resources/AppFeatures/buyOrder.feature"},
        glue = {"stepsdefinition","AppHooks"},
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/",
                "html:target/cucumber",
                "json:target/cucumber.json"
        }
)
public class MyTestCase {
}