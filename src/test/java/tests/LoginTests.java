package tests;


import org.junit.jupiter.api.*;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;


@Epic("SauceDemo E-ticaret Uygulaması")
@Feature("Login Fonksiyonu")

public class LoginTests extends BaseTest{

    private LoginPage loginPage;

    @BeforeAll
    static void setupAll() {
       
        WebDriverManager.chromedriver().setup();
        
    }

    @BeforeEach
    void initPages() {
    	
        loginPage = new LoginPage(driver);
    }

    @Test
    @Story("Geçerli bilgilerle başarılı giriş yapılabilmeli")
    @DisplayName("Başarılı login testi")
    @Description("Kullanıcı doğru username ve şifreyle giriş yaptığında inventory sayfasına yönlendirilmelidir.")
    @Severity(SeverityLevel.CRITICAL)
    void testValidLogin() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(
            currentUrl.contains("inventory"),
            "Login sonrası yönlenilen URL beklendiği gibi değil!"
        );
    }
    
    @Test
    @Story("Geçersiz bilgilerle login denemesi başarısız olmalı")
    @Description("Kullanıcı hatalı şifreyle giriş yaptığında hata mesajı görüntülenmelidir.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Yanlış şifre ile login başarısız olmalı")
    void testInvalidLogin() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("yanlis_sifre");
        loginPage.clickLogin();

        String actualError = loginPage.getErrorMessage();
        Assertions.assertTrue(
            actualError.contains("Username and password do not match"),
            "Hatalı giriş mesajı beklenenden farklı veya görünmüyor!"
        );
    }
   
}
