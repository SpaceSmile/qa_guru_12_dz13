package ru.baucenter.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    SelenideElement
            delivery = $(".city-text"),
            deliveryCity = $(".city-dropdown"),
            deliveryHead = $(".well-bshadow"),
            deliveryResults = $("#show-city-tooltip"),
            searchDelivery = $("[role=combobox"),
            windowDelivery = $(".receipt-order");

    @Step("Открываем сайт")
    public MainPage openPage() {
        open("https://baucenter.ru");
        return this;
    }

    @Step("Нажимаем на выбор города")
    public MainPage selectDelivery() {
        deliveryHead.click();
        delivery.click();
        return this;
    }
    @Step("Выбираем город")
    public MainPage selectCity() {
        deliveryCity.$(byText("Новороссийск")).click();
        return this;
    }

    @Step("Проверяем есть ли на главной выбранный город")
    public MainPage resDelivery(String resCity, String value) {
        deliveryResults.$(byText(resCity))
                .parent().shouldHave(text(value));
        return this;
    }
}
