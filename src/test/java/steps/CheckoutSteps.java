package steps;

import core.pages.CheckoutPage;
import io.cucumber.java.en.*;

public class CheckoutSteps {
    private final CheckoutPage checkoutPage = new CheckoutPage();

    @When("user enters personal details and continues")
    public void user_enters_personal_details() {
        checkoutPage.enterPersonalDetails("Diego", "Perez", "12345");
        checkoutPage.continueCheckout();
    }

    @When("user finishes the checkout process")
    public void user_finishes_checkout() {
        checkoutPage.finishCheckout();
    }
}