package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cartIcon = By.id("shopping_cart_container");

    private By cartContentsContainer = By.id("cart_contents_container");

    private By cartItemNames = By.className("inventory_item_name");

    private By checkoutButton = By.id("checkout");

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public boolean isCartPageDisplayed() {
        List<WebElement> containers = driver.findElements(cartContentsContainer);
        return !containers.isEmpty() && containers.get(0).isDisplayed();
    }

    public List<String> getCartProductNames() {
        List<WebElement> products = driver.findElements(cartItemNames);
        List<String> names = new ArrayList<>();
        for (WebElement p : products) {
            names.add(p.getText());
        }
        return names;
    }
    public void removeFirstProductFromCart() {
        List<WebElement> removeButtons = driver.findElements(By.cssSelector(".cart_button"));
        if (!removeButtons.isEmpty()) {
            removeButtons.get(0).click();
        }}
        
        public boolean isCartEmpty() {
            List<WebElement> items = driver.findElements(By.className("cart_item"));
            return items.isEmpty(); 
        
        
        
    }
        public void clickCheckout() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
            checkoutBtn.click();
        }
}
