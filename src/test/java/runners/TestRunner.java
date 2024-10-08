package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "steps",
        //when it's true, it generates steps definitions, otherwise it executes the code
        dryRun = false,
        tags = "@test",
        plugin = {"pretty"}
)

public class TestRunner {

}
