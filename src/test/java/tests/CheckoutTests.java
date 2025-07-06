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

@Epic("SauceDemo E-Ticaret Uygulaması")
@Feature("Ödeme Süreci")
public class CheckoutTests extends BaseTest {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

   
    @BeforeEach
    void initPages() {
    	
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        inventoryPage.addFirstProductToCart();

        cartPage.goToCart();
        cartPage.clickCheckout();

    }

   

    @Test
    @Story("Geçerli bilgilerle checkout formu doldurma")
    @Description("Kullanıcı checkout formuna geçerli bilgiler girdiğinde, sistem onu ikinci checkout adımına yönlendirmelidir.")
    @DisplayName("Checkout formu doğru bilgilerle doldurulduğunda devam edebilmelidir")
    @Severity(SeverityLevel.NORMAL)

    void testCheckoutFormValidInput() {
        checkoutPage.enterFirstName("cagin");
        checkoutPage.enterLastName("Tester");
        checkoutPage.enterPostalCode("34000");

        // Continue butonu
        checkoutPage.clickContinue();

        // URL'in ikinci checkout adımına geçtiğini kontrol et
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("checkout-step-two"),
            "Başarılı form doldurma sonrası ikinci checkout adımına gidilmeli!");
    }
}
