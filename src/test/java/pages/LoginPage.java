package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        log.info("Opening the page https://www.saucedemo.com/");
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Login as '{userName}' use password '{password}'")
    public void login(String userName, String password) {
        log.info("Running login method on LoginPage");
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.debug("Clicking on LOGIN_BUTTON for authorization on the site");
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Finish login method on LoginPage");
    }

    @Step("Message text in case of user authorization error")
    public String getErrorMassage() {
        log.info("Displaying an error message in case of invalid login and/or password");
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
