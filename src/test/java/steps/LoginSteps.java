package steps;

import core.pages.LoginPage;
import core.pages.ProductsPage;
import core.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginSteps {
    private final WebDriver driver = DriverManager.getInstance().getDriver();
    private final LoginPage loginPage = new LoginPage();
    private final ProductsPage productsPage = new ProductsPage();

    @Given("user logs in with username {string} and password {string}")
    public void user_logs_in(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user logs out")
    public void user_logs_out() {
        productsPage.logout();
    }

    @Then("user is redirected to the login page {string}")
    public void redirected_to_login_page(String page) {
        Assert.assertTrue(driver.getCurrentUrl().contains(page));
    }
}