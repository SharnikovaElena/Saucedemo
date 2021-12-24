package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {

    public static final By TITLE_NAME = By.cssSelector("[class=title]");
    public static final By PRODUCT_NAME = By.xpath("//a//div[@class='inventory_item_name']");
    public static final By PRODUCT_PRICE = By.xpath("//div[@class='inventory_item_price']");
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening the Cart Page")
    public void open() {
        driver.get("https://www.saucedemo.com/cart.html");
        waitForPageLoaded();
    }

    @Step("Find an element on the Cart Page to confirm that we are on this page")
    public String checkTheCartPage() {
        return driver.findElement(TITLE_NAME).getText();
    }

    @Step("Find the name of the added product on the Cart Page")
    public String checkTheNameItemInTheCart() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    @Step("Find the price of the added product on the Cart Page")
    public String checkThePriceItemInTheCart() {
        return driver.findElement(PRODUCT_PRICE).getText();
    }

    @Step("On the Cart Page click on the Continue Shopping button")
    public void continueShopping(){
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }
}


