package ru.baucenter.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import ru.baucenter.helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.baucenter.pages.Home;
import ru.baucenter.pages.BuildingMaterials;
import ru.baucenter.pages.HomePanel;
import ru.baucenter.pages.HomeSearch;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Седлачек В.С.")
@Epic("Проверка сайта baucenter.ru")
public class MainTests extends TestBase {
    Home home = new Home();
    BuildingMaterials buildingMaterials = new BuildingMaterials();
    HomeSearch homeSearch = new HomeSearch();
    HomePanel homePanel = new HomePanel();

    String
            city = "Новороссийск",
            fittingsBuildingMaterials = "Замок-блокиратор створки окон ПВХ нижний белый",
            searchProduct = "отбойный молоток",
            selectedProduct = "Молоток отбойный STANLEY STHM10K-RU",
            resSearchProduct = "Молоток отбойный STANLEY STHM10K-RU 1600 Вт SDS-Max 25 Дж";

    @Test
    @Feature("Проверка ошибок в консоли разработчика")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка ошибок в консоли разработчика на сайте baucenter.ru")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем сайт 'https://baucenter.ru'", () ->
                open("https://baucenter.ru"));

        step("Проверяем в консоли разработчика наличие ошибок 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Feature("Проверка выбора адреса и города на сайте baucenter.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка выбора города")
    void automationSearchCity() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        home
                .openPage()
                .selectCity(city)
                .resDelivery("Новороссийск",city);
    }

    @Test
    @Feature("Проверка выбора товаров по категориям и наполнения корзины на сайте baucenter.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка выбора товаров в категории 'Стройматериалы'")
    void automationMenu() {
        buildingMaterials
                .openPage()
                .selectCity()
                .catalogBuildingMaterials()
                .resCatalogBuildingMaterials("Стройматериалы")
                .windowBuildingMaterials()
                .resCatalogWindow("Окна")
                .fittingsBuildingMaterials()
                .resCatalogFittings("Фурнитура оконная")
                .productBuildingMaterials()
                .resCatalogFittingsProduct("Замок-блокиратор створки окон ПВХ нижний белый")
                .setBasketBuildingMaterials()
                .basketBuildingMaterials()
                .resBasketBuildingMaterials("Замок-блокиратор створки окон ПВХ нижний белый", fittingsBuildingMaterials);
    }

    @Test
    @Feature("Проверка выбора товаров по поиску на главной и добавления товара в корзину на сайте baucenter.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка поиска товаров")
    void automationSearchMenu() {
        homeSearch
                .openPage()
                .selectCity()
                .searchMain(searchProduct)
                .resSearchPage("Результаты поиска по запросу")
                .setSearchProduct(selectedProduct)
                .setBasketSearchProduct()
                .basketSearch()
                .resBasketSearch("Молоток отбойный STANLEY STHM10K-RU 1600 Вт SDS-Max 25 Дж",resSearchProduct);
    }

    @Test
    @Feature("Проверка выбора разделов на сайте baucenter.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка выбора раздела Акции!")
    void automationPanelActions() {
        homePanel
                .openPage()
                .selectCity()
                .selectActions()
                .resActions("Акции");
    }

    @Test
    @Feature("Проверка выбора разделов на сайте baucenter.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка выбора раздела Новинки")
    void automationPanelNewProduct() {
        homePanel
                .openPage()
                .selectCity()
                .selectNewProducts()
                .resNewProducts("Новинки каталога");
    }

    @Test
    @Feature("Проверка выбора разделов на сайте baucenter.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка выбора раздела Бонусы и скидки")
    void automationBonus() {
        homePanel
                .openPage()
                .selectCity()
                .selectBonus()
                .resBonus("Бонусы и скидки");
    }

    @Test
    @Feature("Проверка выбора разделов на сайте baucenter.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка выбора раздела Сервис")
    void automationServices() {
        homePanel
                .openPage()
                .selectCity()
                .selectServices()
                .resServices("Сервис");
    }

    @Test
    @Feature("Проверка выбора разделов на сайте baucenter.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка выбора раздела Советы")
    void automationAdvices() {
        homePanel
                .openPage()
                .selectCity()
                .selectAdvices()
                .resAdvices("Советы");
    }
}