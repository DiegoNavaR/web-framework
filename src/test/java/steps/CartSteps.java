package steps;

import core.pages.CartPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CartSteps {
    private final CartPage cartPage = new CartPage();

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        cartPage.clickCheckout();
    }

    @When("user removes all items from the cart")
    public void user_removes_all_items() {
        cartPage.removeAllItemsFromCart();
    }

    @Then("the cart is empty")
    public void cart_is_empty() {
        Assert.assertTrue(cartPage.isCartEmpty());
    }
}