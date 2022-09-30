package testrunners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
@CucumberOptions(
        features ={"src/test/resources/AppFeatures"},
        glue = {"stepsdefinition","AppHooks"},
        plugin = {"pretty"}
)
public class SerenityTestCase {
}
