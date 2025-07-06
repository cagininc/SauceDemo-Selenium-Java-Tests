package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;

public class InventoryPage {
	
	private WebDriver driver;
	
	
	public InventoryPage(WebDriver driver) {
		
		this.driver=driver;
	}

	
	private By inventoryContainer = By.id("inventory_container");
    private By productNames = By.className("inventory_item_name");
    private By addToCartButtons = By.cssSelector(".btn_inventory");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    
    private By cartBadge = By.className("shopping_cart_badge");

    public List<String> getProductNames() {
        List<WebElement> products = driver.findElements(productNames);
        List<String> names = new ArrayList<>();
        for (WebElement p : products) {
            names.add(p.getText());
        }
        return names;
        
        
        
        
    }
    public boolean isInventoryPageDisplayed() {
        List<WebElement> containers = driver.findElements(inventoryContainer);
        return !containers.isEmpty() && containers.get(0).isDisplayed();
    }

    public void addFirstProductToCart(){
    	
    	
    	List<WebElement> buttons = driver.findElements(addToCartButtons);
        if (!buttons.isEmpty()) {
            buttons.get(0).click(); 
        }
    }
    public void removeFirstProductFromCart() {
        List<WebElement> removeButtons = driver.findElements(By.cssSelector(".btn_secondary"));
        if (!removeButtons.isEmpty()) {
            removeButtons.get(0).click(); 
        }
    }
    public void addMultipleProductsToCart(int count) {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (int i = 0; i < count && i < buttons.size(); i++) {
            buttons.get(i).click();
        }
    }
    
    private By productPrices = By.className("inventory_item_price");

    public List<Double> getProductPrices() {
        List<WebElement> pricesElements = driver.findElements(productPrices);
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElem : pricesElements) {
            String priceText = priceElem.getText().replace("$", "").trim();
            try {
                double price = Double.parseDouble(priceText);
                prices.add(price);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return prices;
    }
    
    private By sortDropdown = By.className("product_sort_container");

    public void selectSortOption(String optionText) {
        WebElement dropdownElem = driver.findElement(sortDropdown);
        Select select = new Select(dropdownElem);
        select.selectByVisibleText(optionText);
    }
    public void clickMenu() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.elementToBeClickable(menuButton))
            .click();
    }

    public void clickLogout() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.elementToBeClickable(logoutLink))
            
            .click();
        
    }

    /** Kısa yol: Menü aç + logout tek metodda */
    public void logout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        // Menü butonuna tıkla
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));

        driver.findElement(logoutLink).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
    }
    
    public String getCartBadgeCount() {
    	
List<WebElement> badges=driver.findElements(cartBadge);
if(!badges.isEmpty()) {
	return badges.get(0).getText();
}else {
	return "0";
}
    }
    
    	
    }


