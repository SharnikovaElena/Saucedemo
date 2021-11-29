package tests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsCriticalPathTest extends BaseTest {

    @Test
    public void checkInventoryPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.checkTheInventoryPage(), "PRODUCTS", "We are not on the Inventory page");
    }

    @Test
    public void addToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart();
        cartPage.open();
        Assert.assertEquals(cartPage.checkTheCartPage(), "YOUR CART", "We are not on the Cart page");
    }

    @Test
    public void checkTheNameItemInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart();
        cartPage.open();
        Assert.assertEquals(cartPage.checkTheNameItemInTheCart(), "Sauce Labs Onesie", "The name of the item in the cart does not match the name of the item in the catalog");
    }

    @Test
    public void checkThePriceItemInTheCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart();
        cartPage.open();
        Assert.assertEquals(cartPage.checkThePriceItemInTheCart(), "$7.99", "The price of the item in the cart does not match the price of the item in the catalog");
    }

    @Test
    public void returnFromCartPageToInventoryPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart();
        cartPage.open();
        cartPage.continueShopping();
        Assert.assertEquals(inventoryPage.checkTheInventoryPage(), "PRODUCTS", "We are not on the Inventory page");
    }
}
