# 🧪 SauceDemo Selenium Java Tests
Bu proje, [SauceDemo](https://www.saucedemo.com/) e-ticaret web uygulamasının test otomasyonunu kapsamaktadır.Techcareer.net Yazılım Otomasyon Bootcamp kapsamında geliştirilmiş Proje, Java + Selenium WebDriver kullanılarak, Page Object Model (POM) mimarisiyle yazılmıştır. Ayrıca Allure raporlama entegrasyonu da sağlanmıştır.

---

## 📌 Kullanılan Teknolojiler

- 🟨 Java
- 🧪 JUnit 5
- 🌐 Selenium WebDriver
- 📦 Maven
- 📄 Page Object Model (POM)
- 📊 Allure Report
- 🧠 Git & GitHub
- 💻 IDE: Eclipse

---

## 🗂️ Proje Yapısı
selenium-tests/
│
├── src/
│ ├── main/java/pages/ → Sayfa sınıfları (POM yapısı)
│ └── test/java/tests/ → Test sınıfları
│
├── pom.xml → Maven yapılandırması

## Test Senaryoları Özeti

Bu projede aşağıdaki temel test senaryoları otomatikleştirilmiştir:

- **Login Tests**: Başarılı ve başarısız kullanıcı giriş işlemlerinin doğrulanması.
- **Logout Test**: Kullanıcının sistemden başarılı şekilde çıkış yapabilmesi.
- **Inventory Tests**: Ürün listesinin doğru görüntülenmesi, ürün fiyatlarının kontrolü ve sepete ürün ekleme işlemleri.
- **Cart Page Tests**: Sepet sayfasında eklenen ürünlerin doğrulanması ve ürün çıkarma işlemleri.
- **Checkout Tests**: Ödeme sayfasındaki form validasyonları ve işlemlerin kontrolü.
- **Checkout Overview Tests**: Ödeme öncesi onay ekranındaki bilgilerin doğru gösterilmesi.

Tüm testler Selenium WebDriver kullanılarak Java ile yazılmış ve Maven ile yönetilmektedir. Test sonuçları **Allure Report** ile görselleştirilmiştir.


---

## 📷 Raporlama – Allure Report

Testlerin sonuçları **Allure** ile raporlanır. Aşağıda örnek bir ekran görüntüsü:

![Allure Report Screenshot](./Allure-report1.png)

Raporu çalıştırmak için:
```bash
mvn clean test
allure serve allure-results

--------------------------------------------------------------------------------------------------------------------------------------------
# 🧪 SauceDemo Selenium Java Tests

This project covers automated testing of the [SauceDemo](https://www.saucedemo.com/) e-commerce web application. It is implemented using Java + Selenium WebDriver with the Page Object Model (POM) design pattern. Allure reporting integration is also included.

---

## 📌 Technologies Used

- 🟨 Java  
- 🧪 JUnit 5  
- 🌐 Selenium WebDriver  
- 📦 Maven  
- 📄 Page Object Model (POM)  
- 📊 Allure Report  
- 🧠 Git & GitHub  
- 💻 IDE: Eclipse  

---

## 🗂️ Project Structure

selenium-tests/
│
├── src/
│ ├── main/java/pages/ → Page classes 
│ └── test/java/tests/ → Test classes
│
├── pom.xml → Maven configuration




---

## Test Scenarios Summary

The following key test scenarios are automated in this project:

- **Login Tests**: Verification of successful and unsuccessful user login attempts.  
- **Logout Test**: Ensuring the user can successfully log out from the system.  
- **Inventory Tests**: Checking correct display of product listings, verifying product prices, and adding products to the cart.  
- **Cart Page Tests**: Validating items added to the cart and removing products.  
- **Checkout Tests**: Validating the checkout form and the payment process.  
- **Checkout Overview Tests**: Verifying the accuracy of information on the pre-payment confirmation page.  

All tests are written using Selenium WebDriver with Java and managed via Maven. Test results are visualized with **Allure Reports**.

---

## 📷 Reporting – Allure Report

Test results are reported using **Allure**. Below is an example screenshot:

![Allure Report Screenshot](./Allure-report1.png)

To run the report, use these commands in the terminal:

```bash
mvn clean test
allure serve target/allure-results

