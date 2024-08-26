package core.pages;

import core.utils.DriverManager;
import core.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage {
    private final WebDriver driver;

    @FindBy(css = ".complete-header")
    private WebElement thankYouMessage;

    public CompletePage() {
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean isOrderComplete() {
        WaitUtils.waitForElementToBeVisible(driver, thankYouMessage);
        return thankYouMessage.isDisplayed();
    }
}