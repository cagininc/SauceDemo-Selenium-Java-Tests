package tests;

import org.junit.jupiter.api.*;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.CheckoutOverviewPage;

@Epic("SauceDemo E-ticaret Uygulaması")
@Feature("Checkout Süreci")
public class CheckoutOverviewTests extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage overviewPage;

    
    @BeforeEach
    void initPages() {
    	
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new CheckoutOverviewPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();        inventoryPage.addFirstProductToCart();
        cartPage.goToCart();
        cartPage.clickCheckout();


        checkoutPage.enterFirstName("Çağın");
        checkoutPage.enterLastName("Tester");
        checkoutPage.enterPostalCode("34000");
        checkoutPage.clickContinue();

        Assertions.assertTrue(
            overviewPage.isOverviewPageDisplayed(),
            "Overview sayfası gösterilmeli"
        );
    }

 
    @Test
    @Feature("Checkout Süreci")
    @Story("Sipariş Özeti ve Ödeme")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Overview sayfasındaki toplam fiyatların ve verginin doğru hesaplanıp gösterildiği test edilir.")
    @DisplayName("Item total, tax ve final total doğru hesaplanmış mı")
    void testTaxCalculationAndTotals() {
        double itemTotal = overviewPage.getItemTotal();
        double actualTax = overviewPage.getTaxTotal();
        double actualFinal = overviewPage.getFinalTotal();

        // Vergi oranı %8
        double expectedTax = Math.round(itemTotal * 0.08 * 100.0) / 100.0;
        double expectedFinal = Math.round((itemTotal + expectedTax) * 100.0) / 100.0;

        Assertions.assertEquals(expectedTax, actualTax, 0.01,
            "Tax, itemTotal * 0.08 ile uyumlu olmalı");
        Assertions.assertEquals(expectedFinal, actualFinal, 0.01,
            "Final total, itemTotal + tax ile uyumlu olmalı");
    }
    
    @Test
    @Feature("Checkout Süreci")
    @Story("Sipariş Tamamlama")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Finish butonuna tıklayınca sipariş tamamlanmalı")
    void testFinishButtonCompletesOrder() {
        overviewPage.clickFinish();

        Assertions.assertTrue(overviewPage.isOrderCompleteDisplayed(), 
            "Sipariş tamamlandı sayfası görüntülenmeli!");
    }

    @Test
    @Feature("Checkout Süreci")
    @Story("Sipariş İptali")
    @Severity(SeverityLevel.NORMAL)
    @Description("Finish aşamasındaki Cancel butonuna basıldığında kullanıcı inventory sayfasına yönlendirilir.")
    @DisplayName("Finish aşamasında Cancel tıklanınca inventory sayfasına dönmeli")
    void testCancelButtonReturnsToInventory() {
        overviewPage.clickCancel();

        Assertions.assertTrue(
            inventoryPage.isInventoryPageDisplayed(),
            "Cancel sonrası inventory sayfası görüntülenmeli!"
        );
    }
}
