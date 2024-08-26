package steps;

import core.utils.DriverManager;
import core.utils.LoggerUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Before
    public void setup() {
        LoggerUtils.logInfo("Setting up driver");
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @After
    public void teardown() {
        LoggerUtils.logInfo("Tearing down driver");
        DriverManager.getInstance().quitDriver();
    }
}