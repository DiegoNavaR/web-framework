package steps;

import core.pages.*;
import core.utils.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepDefinitions {
    private WebDriver driver = DriverManager.getInstance().getDriver();
    private LoginPage loginPage = new LoginPage();
    private ProductsPage productsPage = new ProductsPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private CompletePage completePage = new CompletePage();

    @Given("user logs in with username {string} and password {string}")
    public void user_logs_in(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user adds a random product to the cart")
    public void user_adds_random_product() {
        productsPage.addRandomProductToCart();
        productsPage.goToCart();
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        cartPage.clickCheckout();
    }

    @When("user enters personal details and continues")
    public void user_enters_personal_details() {
        checkoutPage.enterPersonalDetails("Diego", "Perez", "12345");
        checkoutPage.continueCheckout();
    }

    @When("user finishes the checkout process")
    public void user_finishes_checkout() {
        checkoutPage.finishCheckout();
    }

    @Then("the order is completed successfully")
    public void order_completed_successfully() {
        Assert.assertTrue(completePage.isOrderComplete(), "Order completion message is not displayed.");
    }

    @When("user adds three products to the cart")
    public void user_adds_three_products() {
        productsPage.addRandomProductToCart();
        productsPage.addRandomProductToCart();
        productsPage.addRandomProductToCart();
        productsPage.goToCart();
    }

    @When("user removes all items from the cart")
    public void user_removes_all_items() {
        cartPage.removeAllItemsFromCart();
    }

    @Then("the cart is empty")
    public void cart_is_empty() {
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @When("user logs out")
    public void user_logs_out() {
        productsPage.logout();
    }

    @Then("user is redirected to the login page")
    public void redirected_to_login_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
    }
}