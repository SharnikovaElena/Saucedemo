package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
    String userNameInput = "user-name";
    String passwordInput = "password";
    String loginButton1 = "[value=Login]";


    @Test
    public void checkingAddingToCart() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
    }

    @Test
    public void usernameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMassage(), "Epic sadface: Username is required", "Сообщение об ошибке не верно");
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