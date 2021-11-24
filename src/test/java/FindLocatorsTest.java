import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FindLocatorsTest extends BaseTest {

    @Test
    public void findLocators() {

        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.name("user-name"));
        userName.sendKeys("problem_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();
    }
}
