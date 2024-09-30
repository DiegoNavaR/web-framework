package steps;

import core.pages.ProductsPage;
import core.utils.TestContext;
import io.cucumber.java.en.*;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class ProductSteps {

    private final ProductsPage productsPage;

    public ProductSteps(TestContext context, ProductsPage productsPage) {
        this.productsPage = productsPage;
    }

    @When("user adds a random product to the cart")
    @Step("User adds a random product to the cart")
    @Description("This step adds a random product to the shopping cart.")
    public void user_adds_random_product() {
        productsPage.addRandomProductToCart();
        productsPage.goToCart();
    }

    @When("user adds three products to the cart")
    @Step("User adds three random products to the cart")
    @Description("This step adds three random products to the shopping cart.")
    public void user_adds_three_products() {
        productsPage.addRandomProductToCart().addRandomProductToCart().addRandomProductToCart().goToCart();
    }
}