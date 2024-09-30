package core.pages;

import core.utils.DriverManager;
import core.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CartPage {
    private final WebDriver driver;

    public CartPage(DriverManager driverManager) {
        this.driver = driverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cart_item")
    private List<WebElement> cartItems;

    @FindBy(css = ".btn_action.checkout_button")
    private WebElement checkoutButton;

    @FindBy(css = ".cart_button")
    private List<WebElement> removeButtons;

    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }

    public void removeAllItemsFromCart() {
        for (WebElement removeButton : removeButtons) {
            removeButton.click();
        }
    }

    public void clickCheckout() {
        WaitUtils.waitForElementToBeVisible(driver, checkoutButton);
        checkoutButton.click();
    }
}