package steps;

import core.pages.CheckoutPage;
import core.utils.TestContext;
import io.cucumber.java.en.*;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class CheckoutSteps {
    private final CheckoutPage checkoutPage;

    public CheckoutSteps(TestContext context, CheckoutPage checkoutPage) {
        this.checkoutPage = checkoutPage;
    }

    @When("user enters personal details and continues")
    @Step("User enters personal details: {firstName} {lastName}, zip: {zip}")
    @Description("This step allows the user to enter personal details and continue to the next step in the checkout process.")
    public void user_enters_personal_details() {
        checkoutPage.enterPersonalDetails("Diego", "Perez", "12345");
        checkoutPage.continueCheckout();
    }

    @When("user finishes the checkout process")
    @Step("User finishes the checkout process")
    @Description("This step finalizes the checkout process.")
    public void user_finishes_checkout() {
        checkoutPage.finishCheckout();
    }
}