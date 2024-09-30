package steps;

import core.utils.LoggerUtils;
import core.utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Step;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private final TestContext testContext;
    private final WebDriver driver;

    public Hooks(TestContext context) {
        this.testContext = context;
        this.driver = context.getDriver();
    }

    @Before
    @Step("Setting up the WebDriver")
    @Description("This method sets up the WebDriver before each scenario.")
    public void setup() {
        LoggerUtils.logInfo("Setting up driver");

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @After
    @Step("Tearing down the WebDriver")
    @Description("This method tears down the WebDriver after each scenario.")
    public void teardown() {
        LoggerUtils.logInfo("Tearing down driver");
        testContext.quitDriver(); // Use the TestContext to quit the driver
    }
}