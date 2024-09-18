package steps;

import core.utils.DriverManager;
import core.utils.LoggerUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Step;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    @Step("Setting up the WebDriver")
    @Description("This method sets up the WebDriver before each scenario.")
    public void setup() {
        LoggerUtils.logInfo("Setting up driver");
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @After
    @Step("Tearing down the WebDriver")
    @Description("This method tears down the WebDriver after each scenario.")
    public void teardown() {
        LoggerUtils.logInfo("Tearing down driver");
        DriverManager.getInstance().quitDriver();
    }
}