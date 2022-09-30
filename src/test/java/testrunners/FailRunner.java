package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepsdefinition","AppHooks"},
        plugin = {
                "pretty",
                "rerun:target/failerun.txt"
        },
        monochrome = true,
        features={"@target/failedrerun.txt"}
        )

public class FailRunner {
}
