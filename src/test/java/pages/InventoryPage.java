package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    }

    public String checkTheInventoryPage() {
        return driver.findElement(TITLE_NAME).getText();
    }

    public void addToCart() {
        driver.findElement(ADD_PRODUCT_BUTTON).click();
    }

    public String isMenuDisplayed() {
        return driver.findElement(BURGER_MENU).getText();
    }

    public void openMENU() {
        driver.findElement(BURGER_MENU).click();
    }

    public String allItemsInTheBurgerMenu() {
        return driver.findElement(ALL_ITEMS).getText();
    }

    public String aboutInTheBurgerMenu() {
        return driver.findElement(ABOUT).getText();
    }

    public String logoutInTheBurgerMenu() {
        return driver.findElement(LOGOUT).getText();
    }

    public String resetAppStateInTheBurgerMenu() {
        return driver.findElement(RESET_APP_STATE).getText();
    }
}