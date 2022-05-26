package ru.metro.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    SelenideElement
            delivery = $(".header-address__receive-button"),
            deliveryResults = $(".header-main__content"),
            searchDelivery = $("#search-input"),
            windowDelivery = $(".receipt-order");
    //
    @Step("Открываем сайт")
    public MainPage openPage() {
        open("https://online.metro-cc.ru");
        return this;
    }

    @Step("Нажимаем на выбор доставки")
    public MainPage selectDelivery() {
        delivery.click();
        return this;
    }

    @Step("Вводим адрес доставки")
    public MainPage searchDelivery(String city) {
        searchDelivery.setValue(city);
        return this;
    }
    @Step("Сохраняем адрес доставки")
    public MainPage saveDelivery() {
        windowDelivery.$(byText("Сохранить")).click();
        return this;
    }

    @Step("Проверяем есть ли на главной выбранный адрес")
    public MainPage resDelivery(String resАddress, String value) {
        deliveryResults.$(byText(resАddress))
                .parent().shouldHave(text(value));
        return this;
    }
}
