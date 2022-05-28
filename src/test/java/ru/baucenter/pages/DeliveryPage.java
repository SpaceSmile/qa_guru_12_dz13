package ru.baucenter.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryPage {
    SelenideElement
            delivery = $(".city-text"),
            deliveryCity = $(".city-dropdown"),
            deliveryHead = $(".well-bshadow"),
            deliveryResults = $("#show-city-tooltip");

    @Step("Открываем сайт")
    public DeliveryPage openPage() {
        open("https://baucenter.ru");
        return this;
    }

    @Step("Нажимаем на выбор города")
    public DeliveryPage selectDelivery() {
        deliveryHead.click();
        delivery.click();
        return this;
    }
    @Step("Выбираем город")
    public DeliveryPage selectCity() {
        deliveryCity.$(byText("Новороссийск")).click();
        return this;
    }

    @Step("Проверяем есть ли на главной странице сайта выбранный город")
    public DeliveryPage resDelivery(String resCity, String value) {
        deliveryResults.$(byText(resCity))
                .parent().shouldHave(text(value));
        return this;
    }
}
