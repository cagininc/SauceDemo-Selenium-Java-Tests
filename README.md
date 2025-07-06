# 🧪 SauceDemo Selenium Java Tests

Bu proje, [SauceDemo](https://www.saucedemo.com/) e-ticaret web uygulamasının test otomasyonunu kapsamaktadır. Proje, Java + Selenium WebDriver kullanılarak, Page Object Model (POM) mimarisiyle yazılmıştır. Ayrıca Allure raporlama entegrasyonu da sağlanmıştır.

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
