package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseTest {

    @Test
    public void checkMenuIsDisplayed() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.isMenuDisplayed(), "Open Menu", "BURGER MENU not found");
    }

    @Test
    public void allItemsInTheBurgerMenu() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.openMENU();
        Thread.sleep(2000);
        Assert.assertEquals(inventoryPage.allItemsInTheBurgerMenu(), "ALL ITEMS", "Link ALL ITEMS not found");
    }

    @Test
    public void aboutInTheBurgerMenu() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.openMENU();
        Thread.sleep(2000);
        Assert.assertEquals(inventoryPage.aboutInTheBurgerMenu(), "ABOUT", "Link ABOUT not found");
    }

    @Test
    public void logoutInTheBurgerMenu() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.openMENU();
        Thread.sleep(2000);
        Assert.assertEquals(inventoryPage.logoutInTheBurgerMenu(), "LOGOUT", "Link LOGOUT not found");
    }

    @Test
    public void resetAppStateInTheBurgerMenu() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.openMENU();
        Thread.sleep(2000);
        Assert.assertEquals(inventoryPage.resetAppStateInTheBurgerMenu(), "RESET APP STATE", "Link RESET APP STATE not found");
    }
}
