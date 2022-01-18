package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.AllureUtils;

@Log4j2
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

    @Test(retryAnalyzer = Retry.class, description = "Log in as a user using the correct username and password")
    public void checkingAddingToCart() {
        log.info("Running the checkingAddingToCart Test");
        log.info("For Login use userName:'problem_user' and password:'secret_sauce'");
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
        log.info("Completion Test checkingAddingToCart");
    }

    @Test(dataProvider = "loginData", description = "Log in as a user using an incorrect username and / or password")
    public void usernameShouldBeRequired(String userName, String password, String errorMessage) {
        log.info("Test start usernameShouldBeRequired");
        log.info("For Login use userName:' ' and password:'secret_sauce'");
        loginPage.open();
        loginPage.login(userName, password);
        log.debug("AsserEquels checking that registration failed and an error message 'Epic sadface: Username is required'");
        Assert.assertEquals(loginPage.getErrorMassage(), errorMessage, "Сообщение об ошибке не верно");
        log.info("Completion Test usernameShouldBeRequired");
    }

    @Test(description = "Log in as a user using the correct username but no password")
    public void passwordShouldBeRequired() {
        log.info("Test start passwordShouldBeRequired");
        log.info("For Login use userName:'problem_user' and password:' '");
        loginPage.open();
        loginPage.login("problem_user", "");
        log.debug("AsserEquels checking that registration failed and an error message 'Epic sadface: Password is required'");
        Assert.assertEquals(loginPage.getErrorMassage(), "Epic sadface: Password is required", "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver);
        log.info("Completion Test passwordShouldBeRequired");
    }

    @Test(description = "Log in as user using correct password and incorrect username")
    public void invalidLoginData() {
        log.info("Test start invalidLoginData");
        log.info("For Login use userName:'abv' and password:'secret_sauce'");
        loginPage.open();
        loginPage.login("abv", "secret_sauce");
        log.debug("AsserEquels checking that registration failed and an error message 'Epic sadface: Username and password do not match any user in this service'");
        Assert.assertEquals(loginPage.getErrorMassage(), "Epic sadface: Username and password do not match any user in this service", "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver);
        log.info("Completion Test invalidLoginData");
    }

    @Test(description = "Log in as a blocked user")
    public void userIsBlocked() {
        log.info("Test start userIsBlocked");
        log.info("For Login use userName:'locked_out_user' and password:'secret_sauce'");
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        log.debug("AsserEquels checking that registration failed and an error message 'Epic sadface: Sorry, this user has been locked out.'");
        Assert.assertEquals(loginPage.getErrorMassage(), "Epic sadface: Sorry, this user has been locked out.", "Сообщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver);
        log.info("Completion Test userIsBlocked");
    }
}