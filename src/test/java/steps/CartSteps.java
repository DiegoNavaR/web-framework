package steps;

import core.pages.CartPage;
import core.utils.TestContext;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;

public class CartSteps {
    private final CartPage cartPage;

    public CartSteps(TestContext context, CartPage cartPage) {
        this.cartPage = cartPage;
    }

    @When("user proceeds to checkout")
    @Step("User proceeds to checkout")
    @Description("This step triggers the checkout process from the cart.")
    public void user_proceeds_to_checkout() {
        cartPage.clickCheckout();
    }

    @When("user removes all items from the cart")
    @Step("User removes all items from the cart")
    @Description("This step removes all items currently in the cart.")
    public void user_removes_all_items() {
        cartPage.removeAllItemsFromCart();
    }

    @Then("the cart is empty")
    @Step("Verifying that the cart is empty")
    @Description("Asserts that the cart has no items left.")
    public void cart_is_empty() {
        Assertions.assertTrue(cartPage.isCartEmpty());
    }
}