package core.pages;

import core.utils.DriverManager;
import core.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private final WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(css = ".btn_primary.cart_button")
    private WebElement continueButton;

    @FindBy(css = ".btn_action.cart_button")
    private WebElement finishButton;

    public CheckoutPage() {
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public void enterPersonalDetails(String firstName, String lastName, String postalCode) {
        WaitUtils.waitForElementToBeVisible(driver, firstNameInput);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
    }

    public void continueCheckout() {
        WaitUtils.waitForElementToBeClickable(driver, continueButton);
        continueButton.click();
    }

    public void finishCheckout() {
        WaitUtils.waitForElementToBeClickable(driver, finishButton);
        finishButton.click();
    }
}