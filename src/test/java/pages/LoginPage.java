package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public static final By USERNAME_INPUT = By.name("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.cssSelector("[value=Login]");
    public static final By ERROR_MESSAGE = By.cssSelector(".error-message-container");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Site")
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Login as '{userName}' use password '{password}'")
    public void login(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Message text in case of user authorization error")
    public String getErrorMassage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
