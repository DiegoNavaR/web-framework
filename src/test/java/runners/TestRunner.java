package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "html:target/cucumber-html-report",
                "json:target/cucumber.json"},
        tags = "@Regression"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}