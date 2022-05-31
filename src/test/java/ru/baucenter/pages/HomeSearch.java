package ru.baucenter.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class HomeSearch {
    SelenideElement
            searchHome = $("#title-search-input"),
            resSearch = $("#h1_title"),
            cityOk = $("#city-ok"),
            searchSetProduct = $(".catalog-right"),
            setBasket = $(".product"),
            basket = $(".page-header_cart"),
            cookie = $(".cookie-popup__close"),
            setBasketProduct = $(".product_right-col"),
            resProduct = $("#cart-available-items");
    @Step("Открываем сайт")
    public HomeSearch openPage() {
        open("https://baucenter.ru");
        cookie.click();
        return this;
    }

    @Step("Подтверждаем город")
    public HomeSearch selectCity() {
        cityOk.click();
        return this;
    }
    @Step("Набираем текст для поиск товара")
    public HomeSearch searchMain(String searchProduct) {
        searchHome.click();
        searchHome.setValue(searchProduct).pressEnter();
        //sleep(10000);
        return this;
    }
    @Step("Проверяем загрузку страницы поиска")
    public HomeSearch resSearchPage(String resSearchPage) {
        resSearch.shouldBe(text(resSearchPage));
        return this;
    }
    @Step("Выбираем из списка товар")
    public HomeSearch setSearchProduct(String selectedProduct) {
        searchSetProduct.$(withText(selectedProduct)).click();
        //sleep(10000);
        return this;
    }

    @Step("Добавялем товар в корзину")
    public HomeSearch setBasketSearchProduct() {
        setBasketProduct.find(byText("Добавить в корзину")).click();
        return this;
    }

    @Step("Переходим в корзину")
    public HomeSearch basketSearch() {
        basket.click();
        return this;
    }

    @Step("Проверяем выбранный товар в коризне")
    public HomeSearch resBasketSearch(String resSearch, String value) {
        resProduct.$(byText(resSearch))
                .parent().shouldHave(text(value));
        return this;
    }
}

