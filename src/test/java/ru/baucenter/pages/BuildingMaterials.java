package ru.baucenter.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BuildingMaterials {
    SelenideElement
            deliveryCity = $(".city-dropdown"),
            deliveryMore = $("#city-more"),
            catalogMenu = $(".top-nav_catalog"),
            buildingMaterials = $("#menu-catalog"),
            windowFittings = $(".paddings"),
            fittingsProduct = $(".paddings"),
            lotProduct = $("#product-count_number"),
            setBasket = $(".product_right-col"),
            basket = $(".page-header_cart"),
            resProduct = $("#product-count_number"),
            windowsMenu = $(".categories_table");
    //
    @Step("Открываем сайт")
    public BuildingMaterials openPage() {
        open("https://baucenter.ru");
        return this;
    }

    @Step("Нажимаем на выбор города")
    public BuildingMaterials selectDelivery() {
        deliveryMore.click();
        return this;
    }
    @Step("Выбираем город")
    public BuildingMaterials selectCity() {
        deliveryCity.$(byText("Новороссийск")).click();
        return this;
    }

    @Step("Выбираем из общего каталога Стройматериалы")
    public BuildingMaterials catalogBuildingMaterials() {
        catalogMenu.click();
        buildingMaterials.$(byText("Стройматериалы")).click();
        return this;
    }
    @Step("Выбираем из в категории 'Стройматериалы' окна")
    public BuildingMaterials windowBuildingMaterials() {
        windowsMenu.$(byText("Окна")).click();
        return this;
    }
    @Step("Выбираем из в категории 'Окна' фурнитуру")
    public BuildingMaterials fittingsBuildingMaterials() {
        windowFittings.$(byText("Фурнитура оконная")).click();
        return this;
    }

    @Step("Выбираем из списка товар")
    public BuildingMaterials productBuildingMaterials() {
        fittingsProduct.$(byText("Ограничитель окон ПВХ 4 деления Tech-KREP белый")).click();
        return this;
    }

    @Step("Выбираем колличетсво товар")
    public BuildingMaterials lotFittingsBuildingMaterials(String lot) {
        lotProduct.doubleClick().clear();
        lotProduct.setValue(lot);
        return this;
    }

    @Step("Добавялем товар в корзину")
    public BuildingMaterials setBasketBuildingMaterials() {
        setBasket.$(byText("Добавить в корзину")).click();
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
    @Step("Проверяем колличество товара в коризне")
    public BuildingMaterials resLotBasketBuildingMaterials(String resLotBasket, String value) {
        resProduct.$(byText(resLotBasket))
                .parent().shouldHave(text(value));
        return this;
    }



}

