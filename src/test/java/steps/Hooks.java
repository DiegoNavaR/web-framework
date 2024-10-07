package steps;

import core.utils.DriverManager;
import core.utils.LoggerUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

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

        takeScreenshot();

        DriverManager.getInstance().quitDriver();
    }

    @Step("Taking screenshot")
    private void takeScreenshot() {
        try {
            WebDriver driver = DriverManager.getInstance().getDriver();
            if (driver instanceof TakesScreenshot) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");
                LoggerUtils.logInfo("Screenshot captured and added to Allure report.");
            }
        } catch (Exception e) {
            LoggerUtils.logError("Failed to capture screenshot: " + e.getMessage());
        }
    }
}