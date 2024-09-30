package steps;

import core.pages.LoginPage;
import core.pages.ProductsPage;
import core.utils.LoggerUtils;
import core.utils.TestContext;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {

    private final LoginPage loginPage;
    private final ProductsPage productsPage;
    private final TestContext context;

    public LoginSteps(TestContext context, LoginPage loginPage, ProductsPage productsPage) {
        this.context = context;
        this.loginPage = loginPage;
        this.productsPage = productsPage;
    }

    @Given("user logs in with username {string} and password {string}")
    @Step("User logs in with username: {username} and password: {password}")
    @Description("Logs in the user with the provided username and password.")
    public void user_logs_in(String username, String password) {
        LoggerUtils.logInfo("Logging in with username: " + username);
        loginPage.login(username, password);
    }

    @When("user logs out")
    @Step("User logs out")
    @Description("Logs out the current user.")
    public void user_logs_out() {
        LoggerUtils.logInfo("Logging out");
        productsPage.logout();
    }

    @Then("user is redirected to the login page {string}")
    @Step("Verifying user is redirected to the login page: {page}")
    @Description("Checks that the user is redirected to the specified login page.")
    public void redirected_to_login_page(String page) {
        LoggerUtils.logInfo("Verifying redirect to login page: " + page);
        Assertions.assertTrue(context.getDriver().getCurrentUrl().contains(page));
    }
}