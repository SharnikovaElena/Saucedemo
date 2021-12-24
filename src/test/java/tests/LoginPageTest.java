package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"problem_user", "", "Epic sadface: Password is required"},
                {"abv", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkingAddingToCart() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
    }

    @Test(dataProvider = "loginData")
    public void usernameShouldBeRequired(String userName, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(userName, password);
        Assert.assertEquals(loginPage.getErrorMassage(), errorMessage, "Сообщение об ошибке не верно");
    }

    @Test
    public void passwordShouldBeRequired() {
        loginPage.open();
        loginPage.login("problem_user", "");
        Assert.assertEquals(loginPage.getErrorMassage(), "Epic sadface: Password is required", "Сообщение об ошибке не верно");
    }

    @Test
    public void invalidLoginData() {
        loginPage.open();
        loginPage.login("abv", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMassage(), "Epic sadface: Username and password do not match any user in this service", "Сообщение об ошибке не верно");
    }

    @Test
    public void userIsBlocked() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMassage(), "Epic sadface: Sorry, this user has been locked out.", "Сообщение об ошибке не верно");
    }
}