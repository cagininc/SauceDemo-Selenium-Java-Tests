package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.LoginPage;
import pages.InventoryPage;


@Epic("SauceDemo E-ticaret Uygulaması")
@Feature("Ürün Listeleme ve Sepet İşlemleri")
public class InventoryTests extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    
    
    
    @BeforeEach
    void initPages() {
    
    	
        loginPage = new LoginPage(driver);
    	inventoryPage =new InventoryPage(driver);

    	loginPage.enterUsername("standard_user");
    	loginPage.enterPassword("secret_sauce");
    	loginPage.clickLogin();    	
    	
    	
    	
    	
    }
    
    @Test
    @Story("Sayfa Yüklenme Kontrolü")
    @Description("Login sonrası inventory sayfasının başarıyla yüklendiği doğrulanır.")
    @DisplayName("Inventory sayfası yüklendi mi kontrolü")

    
    void testInventoryPageIsDisplayed() {
    	
    	Assertions.assertTrue(
    			
    			inventoryPage.isInventoryPageDisplayed(),
    			"Inventorty sayfası görünür olmalı!"
    			);
    	
    
    
}
    
    @Test
    @Story("Sepete ürün ekleme işlemi")
    @Description("İlk ürün sepete eklendiğinde alışveriş sepeti rozeti 1 göstermelidir.")
    @DisplayName("İlk ürün sepete eklendiğinde badge sayısı 1 olmalı")
    @Severity(SeverityLevel.CRITICAL)
    
    void testAddFirstProductToCart() {
    	inventoryPage.addFirstProductToCart();
    	
    	String badgeCount = inventoryPage.getCartBadgeCount();
    	
    	Assertions.assertEquals("1", badgeCount,"ilk ürün sepete eklenince badge sayısı 1 olmalı "
    			);
    	
    }
    @Test
    @Story("Sepetten ürün çıkarma işlemi")
    @Description("Bir ürün sepete eklenip çıkarıldığında badge sayısının 0 olduğu doğrulanır.")
    @DisplayName("Bir ürün sepete eklenip çıkarıldığında badge 0 olmalı")
    @Severity(SeverityLevel.NORMAL)

    void testRemoveProductFromCart() {
        inventoryPage.addFirstProductToCart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));

        inventoryPage.removeFirstProductFromCart();

        String badgeCount = inventoryPage.getCartBadgeCount();
        Assertions.assertEquals("0", badgeCount, "Ürün çıkarıldığında badge 0 olmalı.");
    }
    
    
    
    @Test
    @Story("Ürünler fiyatına göre küçükten büyüğe sıralanabilmeli")
    @Description("User 'Price (low to high)' seçtiğinde ürün fiyatları artan sırada listelenmeli.")
    @DisplayName("Fiyat sıralama - düşükten yükseğe")
    @Severity(SeverityLevel.MINOR)

    void testSortByPriceLowToHigh() {
        inventoryPage.selectSortOption("Price (low to high)");

        List<Double> prices = inventoryPage.getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        Assertions.assertEquals(sortedPrices, prices, "Fiyatlar küçükten büyüğe sıralı olmalı.");
    }
    @Test
    @Story("Ürünler fiyatına göre büyükten küçüğe sıralanabilmeli")
    @Description("User 'Price (high to low)' seçtiğinde ürün fiyatları azalan sırada listelenmeli.")
    @DisplayName("Fiyat sıralama - yüksekten düşüğe")
    @Severity(SeverityLevel.MINOR)

    void testSortByPriceHighToLow() {
        inventoryPage.selectSortOption("Price (high to low)");

        List<Double> prices = inventoryPage.getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Comparator.reverseOrder());

        Assertions.assertEquals(sortedPrices, prices, "Fiyatlar büyükten küçüğe sıralı olmalı.");
    }
    @Test
    @Story("Ürünler ismine göre alfabetik olarak sıralanabilmeli")
    @Description("User 'Name (A to Z)' seçtiğinde ürünler alfabetik sırayla listelenmeli.")
    @DisplayName("İsim sıralama - A'dan Z'ye")
    @Severity(SeverityLevel.MINOR)

    void testSortByNameAToZ() {
        inventoryPage.selectSortOption("Name (A to Z)");

        List<String> names = inventoryPage.getProductNames();
        List<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);

        Assertions.assertEquals(sortedNames, names, "Ürün isimleri A'dan Z'ye sıralı olmalı.");
    }
    @Test
    @Story("Ürünler ismine göre ters alfabetik olarak sıralanabilmeli")
    @Description("User 'Name (Z to A)' seçtiğinde ürünler Z'den A'ya alfabetik sırada listelenmeli.")
    @DisplayName("İsim sıralama - Z'den A'ya")
    @Severity(SeverityLevel.MINOR)

    void testSortByNameZToA() {
        inventoryPage.selectSortOption("Name (Z to A)");

        List<String> names = inventoryPage.getProductNames();
        List<String> sortedNames = new ArrayList<>(names);
        sortedNames.sort(Comparator.reverseOrder());

        Assertions.assertEquals(sortedNames, names, "Ürün isimleri Z'den A'ya sıralı olmalı.");
    }

   
    
    
}
    
    
