package tests;

import io.qameta.allure.Feature;



import org.junit.jupiter.api.*;


import pages.InventoryPage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

   
    @BeforeEach
    void initPagesandLogin() {
    	
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }
        
    

    @Test
    @Feature("Logout Functionality")

    @DisplayName("User can logout successfully")
    void userCanLogout() {

        inventoryPage.logout();
    	String currentUrl = driver.getCurrentUrl();

        Assertions.assertEquals("https://www.saucedemo.com/", currentUrl,
        		"Logout sonrası tam kök URL'ye yönlendirilmeli"
);
    }

   
}
