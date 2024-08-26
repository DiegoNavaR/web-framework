package steps;

import core.pages.CheckoutPage;
import core.utils.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class CheckoutSteps {
    private final WebDriver driver = DriverManager.getInstance().getDriver();
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