package steps;

import core.pages.CompletePage;
import core.utils.DriverManager;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class CompleteSteps {
    private final WebDriver driver = DriverManager.getInstance().getDriver();
    private final CompletePage completePage = new CompletePage();

    @Then("the order is completed successfully")
    public void order_completed_successfully() {
        Assert.assertTrue(completePage.isOrderComplete(), "Order completion message is not displayed.");
    }
}