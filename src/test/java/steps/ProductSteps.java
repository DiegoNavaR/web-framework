package steps;

import core.pages.ProductsPage;
import core.utils.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class ProductSteps {
    private final WebDriver driver = DriverManager.getInstance().getDriver();
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