package ru.metro.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import ru.metro.helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.metro.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Седлачек В.С.")
@Epic("Проверка сайта online.metro-cc.ru")
public class MainTests extends TestBase {
    MainPage mainPage = new MainPage();
    String
            city = "Краснодар, Кадетская улица, 5";

    @Test
    @Feature("Проверка ошибок в консоли разработчика")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка ошибок в консоли разработчика на сайте online.metro-cc.ru")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем сайт 'https://online.metro-cc.ru'", () ->
                open("https://online.metro-cc.ru"));

        step("Проверяем в консоли разработчика наличие ошибок 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Feature("Проверка ввода адреса и выбор города на сайте online.metro-cc.ru")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка ввода адреса и сохранения адреса доставки")
    void automationSearchCity() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        mainPage
                .openPage()
                .selectDelivery()
                .searchDelivery(city)
                .saveDelivery()
                .resDelivery("Краснодар, Кадетская улица, 5",city);
    }
}