package ru.baucenter.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchHome {
    SelenideElement
            searchHome = $("#title-search-input"),
            resSearch = $("#h1_title"),
            cityOk = $("#city-ok"),
            searchSetProduct = $(".catalog-list"),
            setBasket = $(".product"),
            basket = $(".page-header_cart"),
            cookie = $(".cookie-popup__close"),
            resProduct = $("#cart-available-items");
    @Step("Открываем сайт")
    public SearchHome openPage() {
        open("https://baucenter.ru");
        cookie.click();
        return this;
    }

    @Step("Подтверждаем город")
    public SearchHome selectCity() {
        cityOk.click();
        return this;
    }
    @Step("Набираем текст для поиск товара")
    public SearchHome searchMain(String searchProduct) {
        searchHome.click();
        searchHome.setValue(searchProduct).pressEnter();
        return this;
    }
    @Step("Проверяем загрузку страницы поиска")
    public SearchHome resSearchPage(String resSearchPage) {
        resSearch.shouldBe(text(resSearchPage));
        return this;
        //(String resCatalog) {
        //        $("#h1_title").shouldBe(text(resCatalog));
        //        return this;
        //    }
    }
    @Step("Выбираем из списка товар")
    public SearchHome setSearchProduct(String selectedProduct) {
        searchSetProduct.$(withText(selectedProduct)).click();
        return this;
    }

    @Step("Добавялем товар в корзину")
    public SearchHome setBasketSearchProduct() {
        setBasket.find(byText("Добавить в корзину")).click();
        return this;
    }

    @Step("Переходим в корзину")
    public SearchHome basketSearch() {
        basket.click();
        return this;
    }

    @Step("Проверяем выбранный товар в коризне")
    public SearchHome resBasketSearch(String resSearch, String value) {
        resProduct.$(byText(resSearch))
                .parent().shouldHave(text(value));
        return this;
    }
}

