package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = {
                "com/configs",
                "com/steps",
                "hooks"
        },
        tags = "@Run")
public class RunCucumberTest {
}
