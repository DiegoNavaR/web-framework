package core.pages;

import core.utils.DriverManager;
import core.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductsPage {
    private WebDriver driver;

    @FindBy(css = ".inventory_item")
    private List<WebElement> products;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartLink;

    @FindBy(css = ".bm-burger-button")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public ProductsPage() {
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public void addRandomProductToCart() {
        int randomIndex = ThreadLocalRandom.current().nextInt(products.size());
        WebElement randomProduct = products.get(randomIndex);
        WebElement addButton = randomProduct.findElement(By.cssSelector(".btn_inventory"));
        WaitUtils.waitForElementToBeClickable(driver, addButton);
        addButton.click();
    }

    public void goToCart() {
        WaitUtils.waitForElementToBeClickable(driver, cartLink);
        cartLink.click();
    }

    public void logout() {
        WaitUtils.waitForElementToBeClickable(driver, menuButton);
        menuButton.click();
        WaitUtils.waitForElementToBeClickable(driver, logoutLink);
        logoutLink.click();
    }
}