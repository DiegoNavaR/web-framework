package steps;

import core.pages.LoginPage;
import core.pages.ProductsPage;
import core.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import io.qameta.allure.Description;
import org.testng.Assert;

public class LoginSteps {
    private final WebDriver driver = DriverManager.getInstance().getDriver();
    private final LoginPage loginPage = new LoginPage();
    private final ProductsPage productsPage = new ProductsPage();

    @Given("user logs in with username {string} and password {string}")
    @Step("User logs in with username: {username} and password: {password}")
    @Description("Logs in the user with the provided username and password.")
    public void user_logs_in(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user logs out")
    @Step("User logs out")
    @Description("Logs out the current user.")
    public void user_logs_out() {
        productsPage.logout();
    }

    @Then("user is redirected to the login page {string}")
    @Step("Verifying user is redirected to the login page: {page}")
    @Description("Checks that the user is redirected to the specified login page.")
    public void redirected_to_login_page(String page) {
        Assert.assertTrue(driver.getCurrentUrl().contains(page));
    }
}