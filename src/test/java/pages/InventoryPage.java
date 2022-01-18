package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class InventoryPage extends BasePage {

    public static final By BURGER_MENU = By.id("react-burger-menu-btn");
    public static final By TITLE_NAME = By.cssSelector("[class=title]");
    public static final By ADD_PRODUCT_BUTTON = By.id("add-to-cart-sauce-labs-onesie");
    public static final By ALL_ITEMS = By.xpath("//a[@id='inventory_sidebar_link']");
    public static final By ABOUT = By.id("about_sidebar_link");
    public static final By LOGOUT = By.id("logout_sidebar_link");
    public static final By RESET_APP_STATE = By.id("reset_sidebar_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/inventory.html");
        waitForPageLoaded();
    }

   @Step("Find an element on the Inventory Page to confirm that we are on this page")
    public String checkTheInventoryPage() {
        return driver.findElement(TITLE_NAME).getText();
    }

    @Step("Clicking on the button 'Add to cart'")
    public void addToCart() {
        driver.findElement(ADD_PRODUCT_BUTTON).click();
    }

    @Step("Find an element on the Inventory Page to confirm that Menu is displayed")
    public String isMenuDisplayed() {
        log.info("Find an element on the Inventory Page to confirm that Menu is displayed");
        return driver.findElement(BURGER_MENU).getText();
    }

    @Step("Opening 'MENU'")
    public void openMENU() {
        driver.findElement(BURGER_MENU).click();
    }

    @Step("Find the 'All Items' section in the Burger menu")
    public String allItemsInTheBurgerMenu() {
//        wait = new WebDriverWait(driver, 20);
//       wait.until(ExpectedCondition.visi)
        return driver.findElement(ALL_ITEMS).getText();
    }

    @Step("Find the 'About' section in the Burger menu")
    public String aboutInTheBurgerMenu() {
        return driver.findElement(ABOUT).getText();
    }

    @Step("Find the 'Logout' section in the Burger menu")
    public String logoutInTheBurgerMenu() {
        return driver.findElement(LOGOUT).getText();
    }

    @Step("Find the 'Reset App State' section in the Burger menu")
    public String resetAppStateInTheBurgerMenu() {
        return driver.findElement(RESET_APP_STATE).getText();
    }
}