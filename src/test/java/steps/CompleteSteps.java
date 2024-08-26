package steps;

import core.pages.CompletePage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CompleteSteps {
    private final CompletePage completePage = new CompletePage();

    @Then("the order is completed successfully")
    public void order_completed_successfully() {
        Assert.assertTrue(completePage.isOrderComplete(), "Order completion message is not displayed.");
    }
}