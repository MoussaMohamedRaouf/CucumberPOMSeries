package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"src/test/resources/com/features"},
        glue = {"stepdefinitions"},
        plugin = {"pretty",
                "json:target/Reports/report.json",
                "junit:target/Reports/report.xml"
        }
)
public class MyTestRunner {

}
