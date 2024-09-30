package steps;

import core.pages.CompletePage;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import io.qameta.allure.Step;
import io.qameta.allure.Description;

public class CompleteSteps {
    private final CompletePage completePage = new CompletePage();

    @Then("the order is completed successfully")
    @Step("Verifying that the order is completed successfully")
    @Description("Asserts that the order completion message is displayed on the Complete Page.")
    public void order_completed_successfully() {
        Assertions.assertTrue(completePage.isOrderComplete(), "Order completion message is not displayed.");
    }
}