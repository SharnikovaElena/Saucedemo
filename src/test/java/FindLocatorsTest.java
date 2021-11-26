import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FindLocatorsTest extends BaseTest {

    @Test
    public void findLocators() {

        driver.get("https://www.saucedemo.com/");

// Не искала по tagname, linktext, partiallinktext

        WebElement userName = driver.findElement(By.name("user-name"));
        userName.sendKeys("problem_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();
        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        shoppingCart.click();
        WebElement continueShopping = driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_medium']"));
        continueShopping.click();

    }

    @Test
    public void findLocatorsXpath() {
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField = driver.findElement(By.name("user-name"));
        userNameField.sendKeys("problem_user");
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='login_credentials']/text()[3]"));
        passwordField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.cssSelector("[value=Login]"));
        loginButton.click();

        WebElement sortContainer = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        sortContainer.click();

        WebElement product1 = driver.findElement(By.xpath("//a//div[text()='Sauce Labs Bike Light']"));
        product1.click();
    }

    @Test
    public void findLocatorsCssSelector() {
//        .class - Выбирает все элементы с указанным именем после .
        WebElement loginButton = driver.findElement(By.cssSelector(".submit-button btn_action"));
//        .class.class - Выбирает все элементы, для которых в атрибуте class установлены как name1, так и name2.
        WebElement productName = driver.findElement(By.cssSelector(".inventory_item_label.inventory_item_name"));
//        .class .class - Выбирает все элементы с именем2, которые являются потомками элемента с именем1
        WebElement productDescription = driver.findElement(By.cssSelector(".inventory_item_description .inventory_item_desc"));
//         tagname
        WebElement logoTitle = driver.findElement(By.tagName("title"));
//        tagname.class - Выбирает все элементы <p> с class = "intro"
        WebElement headerLabel = driver.findElement(By.cssSelector("div.header_label"));
//        [attribute=value]
        WebElement productSortContainer = driver.findElement(By.cssSelector("[data-test=product_sort_container]"));
//        [attribute~=value]
        WebElement RemoveButton = driver.findElement(By.cssSelector("[data-test~=remove]"));
//        [attribute|=value]
        WebElement RemoveButton2 = driver.findElement(By.cssSelector("[data-test|=rem]"));
//        [attribute^=value]
        WebElement productTitleLink = driver.findElement(By.cssSelector("a[href^='#']"));
//        [attribute$=value]
        WebElement productDescription2 = driver.findElement(By.cssSelector("div[class$='description']"));
    }
}

