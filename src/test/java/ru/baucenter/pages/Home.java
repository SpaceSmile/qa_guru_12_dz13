package ru.baucenter.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Home {
    SelenideElement
            delivery = $(".city-text"),
            deliveryCity = $(".city-dropdown"),
            deliveryHead = $(".well-bshadow"),
            cookie = $(".cookie-popup__close"),
            deliveryResults = $("#show-city-tooltip");

    @Step("Открываем сайт")
    public Home openPage() {
        open("https://baucenter.ru");
        cookie.click();
        return this;
    }

    @Step("Выбираем город")
    public Home selectCity(String city) {
        deliveryHead.click();
        delivery.click();
        deliveryCity.$(byText(city)).click();
        return this;
    }

    @Step("Проверяем есть ли на главной странице сайта выбранный город")
    public Home resDelivery(String resCity, String value) {
        deliveryResults.$(byText(resCity))
                .parent().shouldHave(text(value));
        return this;
    }
}
