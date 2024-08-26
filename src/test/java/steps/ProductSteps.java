package steps;

import core.pages.ProductsPage;
import io.cucumber.java.en.*;

public class ProductSteps {

    private final ProductsPage productsPage = new ProductsPage();

    @When("user adds a random product to the cart")
    public void user_adds_random_product() {
        productsPage.addRandomProductToCart();
        productsPage.goToCart();
    }

    @When("user adds three products to the cart")
    public void user_adds_three_products() {
        productsPage.addRandomProductToCart().addRandomProductToCart().addRandomProductToCart().goToCart();
    }
}