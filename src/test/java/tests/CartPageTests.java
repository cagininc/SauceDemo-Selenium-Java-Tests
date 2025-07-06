package tests;

import java.util.List;

import org.junit.jupiter.api.*;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;



@Epic("SauceDemo E-ticaret Uygulaması")
@Feature("Sepet Yönetimi")
public class CartPageTests extends BaseTest{

	private LoginPage loginPage;
	private InventoryPage inventoryPage;
	private CartPage cartPage;
	

@BeforeEach
void initPages() {

    loginPage = new LoginPage(driver);
    inventoryPage = new InventoryPage(driver);
    cartPage = new CartPage(driver);
    loginPage.enterUsername("standard_user");
    loginPage.enterPassword("secret_sauce");
    loginPage.clickLogin();
}


@Test
@Story("Sepet sayfasına erişim")
@Severity(SeverityLevel.NORMAL)

@DisplayName("Sepet sayfasına gidilebilir ve doğru sayfa açılır")
void testGoToCartPage() {
    cartPage.goToCart();

    Assertions.assertTrue(cartPage.isCartPageDisplayed(), "Sepet sayfası görüntülenmeli!");
}

@Test
@Story("Sepet ürünleri kontrolü")
@Severity(SeverityLevel.CRITICAL)
@DisplayName("Sepette ürün var mı ve ürün isimleri doğru mu kontrolü")
void testCartProducts() {
    inventoryPage.addFirstProductToCart();

    cartPage.goToCart();

    List<String> productNames = cartPage.getCartProductNames();

    Assertions.assertFalse(productNames.isEmpty(), "Sepette ürün olmalı!");

    String firstInventoryProduct = inventoryPage.getProductNames().get(0);
    Assertions.assertEquals(firstInventoryProduct, productNames.get(0), "Sepetteki ürün adı doğru olmalı!");
}
@Test
@Story("Sepetten ürün çıkarma")
@DisplayName("Sepetten ürün çıkarma" )
@Severity(SeverityLevel.NORMAL)

void removetestCartProducts() {
    inventoryPage.addFirstProductToCart();

    cartPage.goToCart();

    List<String> productNames = cartPage.getCartProductNames();

    Assertions.assertFalse(productNames.isEmpty(), "Sepette ürün olmalı!");

    String firstInventoryProduct = inventoryPage.getProductNames().get(0);
    Assertions.assertEquals(firstInventoryProduct, productNames.get(0), "Sepetteki ürün adı doğru olmalı!");
}



@Test
@Story("Checkout yönlendirmesi")
@DisplayName("Checkout sayfasına yönlendirme testi")
@Severity(SeverityLevel.NORMAL)

void testCheckoutNavigation() {
    inventoryPage.addFirstProductToCart();

    cartPage.goToCart();

    cartPage.clickCheckout();

    String currentUrl = driver.getCurrentUrl();

    Assertions.assertTrue(
        currentUrl.contains("checkout"),
        "Checkout sayfasına yönlendirilmelidir!"
    );
}


	
}
