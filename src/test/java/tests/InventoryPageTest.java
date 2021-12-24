package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.AllureUtils;

public class InventoryPageTest extends BaseTest {

    @Test (description = "Checking if the menu is displayed")
    public void checkMenuIsDisplayed() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.isMenuDisplayed(), "Open Menu", "BURGER MENU not found");
        AllureUtils.takeScreenshot(driver);
    }

    @Test(description = "Checking that the Burger menu displays the section name 'All Items'")
    public void allItemsInTheBurgerMenu() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.openMENU();
        Thread.sleep(2000);
        Assert.assertEquals(inventoryPage.allItemsInTheBurgerMenu(), "ALL ITEMS", "Link ALL ITEMS not found");
    }

    @Test(description = "Checking that the Burger menu displays the section name 'About'")
    public void aboutInTheBurgerMenu() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.openMENU();
        Thread.sleep(2000);
        Assert.assertEquals(inventoryPage.aboutInTheBurgerMenu(), "ABOUT", "Link ABOUT not found");
    }

    @Test(description = "Checking that the Burger menu displays the section name 'Logout'")
    public void logoutInTheBurgerMenu() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.openMENU();
        Thread.sleep(2000);
        Assert.assertEquals(inventoryPage.logoutInTheBurgerMenu(), "LOGOUT", "Link LOGOUT not found");
    }

    @Test(description = "Checking that the Burger menu displays the section name 'Reset App State'")
    public void resetAppStateInTheBurgerMenu() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.openMENU();
        Thread.sleep(2000);
        Assert.assertEquals(inventoryPage.resetAppStateInTheBurgerMenu(), "RESET APP STATE", "Link RESET APP STATE not found");
    }
}
