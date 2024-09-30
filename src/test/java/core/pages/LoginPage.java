package core.pages;

import core.utils.DriverManager;
import core.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(DriverManager driverManager) {
        this.driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void login(final String username, String password) {
        WaitUtils.waitForElementToBeVisible(driver, userNameInput);
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        WaitUtils.waitForElementToBeClickable(driver, loginButton);
        loginButton.click();
    }
}