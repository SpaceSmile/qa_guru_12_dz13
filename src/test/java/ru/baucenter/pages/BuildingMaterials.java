package ru.baucenter.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BuildingMaterials {
    SelenideElement
            resTitle = $("#h1_title"),
            catalogMenu = $("[data-menu-event='mouseenter']"),
            buildingMaterials = $("#menu-catalog"),
            windowFittings = $(".paddings"),
            fittingsProduct = $(".catalog-list"),
            setBasket = $(".product"),
            cityOk = $("#city-ok"),
            basket = $(".page-header_cart"),
            resProduct = $("#cart-available-items"),
            cookie = $(".cookie-popup__close"),
            categoryMenu = $(".categories_table");

    @Step("Открываем сайт")
    public BuildingMaterials openPage() {
        open("https://baucenter.ru");
        cookie.click();
        return this;
    }

    @Step("Подтверждаем город")
    public BuildingMaterials selectCity() {
        cityOk.click();
        return this;
    }

    @Step("Выбираем из общего каталога Стройматериалы")
    public BuildingMaterials catalogBuildingMaterials() {
        catalogMenu.click();
        buildingMaterials.find(byText("Стройматериалы")).click();
        return this;
    }
    @Step("Проверяем, что открылась страница Стройматериалы")
    public BuildingMaterials resCatalogBuildingMaterials(String resCatalog) {
        resTitle.shouldBe(text(resCatalog));
        return this;
    }

    @Step("Выбираем из в категории 'Стройматериалы' окна")
    public BuildingMaterials windowBuildingMaterials() {
        $$(".categories_row_item").find(Condition.text("Окна")).click();
        return this;
    }

    @Step("Проверяем, что открылась страница Окна")
    public BuildingMaterials resCatalogWindow(String resCatalogWindow) {
        resTitle.shouldBe(text(resCatalogWindow));
        return this;
    }
    @Step("Выбираем из в категории 'Окна' фурнитуру")
    public BuildingMaterials fittingsBuildingMaterials() {
        categoryMenu.find(byText("Фурнитура оконная")).click();
        return this;
    }

    @Step("Проверяем, что открылась страница Фурнитура оконная")
    public BuildingMaterials resCatalogFittings(String resCatalogFittings) {
        resTitle.shouldBe(text(resCatalogFittings));
        return this;
    }

    @Step("Выбираем из списка товар")
    public BuildingMaterials productBuildingMaterials() {
        fittingsProduct.find(byText("Замок-блокиратор створки окон ПВХ нижний белый")).click();
        return this;
    }

    @Step("Проверяем, что открылась страница выбранного товара")
    public BuildingMaterials resCatalogFittingsProduct(String resProductFittings) {
        setBasket.shouldBe(text(resProductFittings));
        return this;
    }


    @Step("Добавялем товар в корзину")
    public BuildingMaterials setBasketBuildingMaterials() {
        setBasket.find(byText("Добавить в корзину")).click();
        return this;
    }

    @Step("Переходим в корзину")
    public BuildingMaterials basketBuildingMaterials() {
        basket.click();
        return this;
    }

    @Step("Проверяем выбранный товар в коризне")
    public BuildingMaterials resBasketBuildingMaterials(String resBasket, String value) {
        resProduct.$(byText(resBasket))
                .parent().shouldHave(text(value));
        return this;
    }
}

