package ru.baucenter.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePanel {
    SelenideElement
            panelActions = $(".header-wrap"),
            resPanel = $(".bl-wrapper"),
            cityOk = $("#city-ok"),
            searchSetProduct = $(".catalog-list"),
            setBasket = $(".product"),
            basket = $(".page-header_cart"),
            cookie = $(".cookie-popup__close"),
            resProduct = $("#cart-available-items");

    @Step("Открываем сайт")
    public HomePanel openPage() {
        open("https://baucenter.ru");
        cookie.click();
        return this;
    }

    @Step("Подтверждаем город")
    public HomePanel selectCity() {
        cityOk.click();
        return this;
    }

    @Step("Выбираем раздел Акции")
    public HomePanel selectActions() {
        panelActions.find(byText("Акции!")).click();
        return this;
    }
    @Step("Проверяем, что открылась страница Акции!")
    public HomePanel resActions(String resActions) {
        resPanel.shouldBe(text(resActions));
        return this;
    }

    @Step("Выбираем раздел Новинки")
    public HomePanel selectNewProducts() {
        panelActions.find(byText("Новинки")).click();
        return this;
    }
    @Step("Проверяем, что открылась страница Новинки")
    public HomePanel resNewProducts(String resNewProducts) {
        resPanel.shouldBe(text(resNewProducts));
        return this;
    }

    @Step("Выбираем раздел Бонусы и скидки")
    public HomePanel selectBonus() {
        panelActions.find(byText("Бонусы и скидки")).click();
        return this;
    }
    @Step("Проверяем, что открылась страница Бонусы и скидки")
    public HomePanel resBonus(String resBonus) {
        resPanel.shouldBe(text(resBonus));
        return this;
    }

    @Step("Выбираем раздел Сервис")
    public HomePanel selectServices() {
        panelActions.find(byText("Сервис")).click();
        return this;
    }
    @Step("Проверяем, что открылась страница Сервис")
    public HomePanel resServices(String resServices) {
        resPanel.shouldBe(text(resServices));
        return this;
    }

    @Step("Выбираем раздел Советы")
    public HomePanel selectAdvices() {
        panelActions.find(byText("Советы")).click();
        return this;
    }
    @Step("Проверяем, что открылась страница Советы")
    public HomePanel resAdvices(String resAdvices) {
        resPanel.shouldBe(text(resAdvices));
        return this;
    }
//Advices

}
