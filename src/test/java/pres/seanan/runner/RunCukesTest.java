package pres.seanan.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/result.json"},
        features = "src/test/resources/cucumber/baidu.feature",
        glue = "pres.seanan.step"
)
public class RunCukesTest {
}

