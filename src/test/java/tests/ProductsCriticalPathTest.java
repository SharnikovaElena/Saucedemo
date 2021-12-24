package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;


public class ProductsCriticalPathTest extends BaseTest {

    @Test(description = "Go to the Inventory Page")
    public void checkInventoryPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.checkTheInventoryPage(), "PRODUCTS", "We are not on the Inventory page");
        AllureUtils.takeScreenshot(driver);
    }

    @Test (description = "Adding an item to the cart")
    public void addToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart();
        cartPage.open();
        Assert.assertEquals(cartPage.checkTheCartPage(), "YOUR CART", "We are not on the Cart page");
        AllureUtils.takeScreenshot(driver);
    }

    @Test(description = "Checking the name of the item in the cart with the name of the item that was added from the Inventory page")
    public void checkTheNameItemInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart();
        cartPage.open();
        Assert.assertEquals(cartPage.checkTheNameItemInTheCart(), "Sauce Labs Onesie", "The name of the item in the cart does not match the name of the item in the catalog");
        AllureUtils.takeScreenshot(driver);
    }

    @Test
    public void checkThePriceItemInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart();
        cartPage.open();
        Assert.assertEquals(cartPage.checkThePriceItemInTheCart(), "$7.99", "The price of the item in the cart does not match the price of the item in the catalog");
    }

    @Test (description = "We check the possibility of continuing shopping by going from the Cart to the Inventory Page")
    public void returnFromCartPageToInventoryPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart();
        cartPage.open();
        cartPage.continueShopping();
        Assert.assertEquals(inventoryPage.checkTheInventoryPage(), "PRODUCTS", "We are not on the Inventory page");
    }
}
