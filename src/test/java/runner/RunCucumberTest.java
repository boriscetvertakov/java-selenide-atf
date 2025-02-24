package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "classpath:features",
        glue = {
                "com/configs",
                "com/steps",
                "hooks"
        },
        tags = "@Run",
        plugin= {"timeline:<report folder>"})


public class RunCucumberTest extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}


