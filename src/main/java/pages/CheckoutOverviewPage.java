package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage {

    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    //  Sipariş tamamlama butonu
    private By finishButton = By.id("finish");
 // 🔙 Cancel butonunu temsil eden locator
    private By cancelButton = By.id("cancel");
    private By orderCompleteMessage = By.cssSelector("h2.complete-header[data-test='complete-header']");

    //  Cancel butonuna tıkla
    public void clickCancel() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Butonu tıkla
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
        // Navigasyonun gerçekleşmesini bekle
        wait.until(ExpectedConditions.urlContains("/inventory"));
    }

    //  Sayfa başlığı (Checkout: Overview)
    private By overviewTitle = By.className("title");

    //  Fiyat alanları
    private By itemTotal = By.className("summary_subtotal_label"); // "Item total: $29.99"
    private By taxTotal = By.className("summary_tax_label");       // "Tax: $2.40"
    private By finalTotal = By.className("summary_total_label");   // "Total: $32.39"

    //  Siparişi tamamla
    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    //  Doğru sayfada mıyız kontrolü
    public boolean isOverviewPageDisplayed() {
        return driver.findElement(overviewTitle).getText().equals("Checkout: Overview");
    }

    //  Item fiyatını al
    public double getItemTotal() {
        String text = driver.findElement(itemTotal).getText(); // "Item total: $29.99"
        return parsePrice(text);
    }

    //  Vergiyi al
    public double getTaxTotal() {
        String text = driver.findElement(taxTotal).getText(); // "Tax: $2.40"
        return parsePrice(text);
    }

    //  Genel toplamı al
    public double getFinalTotal() {
        String text = driver.findElement(finalTotal).getText(); // "Total: $32.39"
        return parsePrice(text);
    }

    //  Metinden sayıyı ayıkla (örn: $29.99 → 29.99)
    private double parsePrice(String text) {
        return Double.parseDouble(text.replaceAll("[^\\d.]", ""));
    }
    
    public boolean isOrderCompleteDisplayed() {
        try {
            return driver.findElement(orderCompleteMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }    	
    	
    	
    	
    	
    	
    }
}
