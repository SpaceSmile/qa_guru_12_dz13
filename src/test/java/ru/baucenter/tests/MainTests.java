package ru.baucenter.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import ru.baucenter.helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.baucenter.pages.DeliveryPage;
import ru.baucenter.pages.BuildingMaterials;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Седлачек В.С.")
@Epic("Проверка сайта baucenter.ru")
public class MainTests extends TestBase {
    DeliveryPage deliveryPage = new DeliveryPage();
    BuildingMaterials buildingMaterials = new BuildingMaterials();
    String
            city = "Новороссийск",
            fittingsBuildingMaterials = "Ограничитель окон ПВХ 4 деления Tech-KREP белый",
            resLotBasket = "12";

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
        deliveryPage
                .openPage()
                .selectDelivery()
                .selectCity()
                .resDelivery("Новороссийск",city);
    }

    @Test
    @Feature("Проверка выбора товаров по категориям и наполнения корзины на сайте baucenter.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка выбора товаров в категории 'Стройматериалы'")
    void automationMenu() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        buildingMaterials
                .openPage()
                .selectDelivery()
                .selectCity()
                .catalogBuildingMaterials()
                .windowBuildingMaterials()
                .fittingsBuildingMaterials()
                .productBuildingMaterials()
                .lotFittingsBuildingMaterials(resLotBasket)
                .setBasketBuildingMaterials()
                .basketBuildingMaterials()
                .resBasketBuildingMaterials("Ограничитель окон ПВХ 4 деления Tech-KREP белый", fittingsBuildingMaterials)
                .resLotBasketBuildingMaterials("12",resLotBasket);
    }
}