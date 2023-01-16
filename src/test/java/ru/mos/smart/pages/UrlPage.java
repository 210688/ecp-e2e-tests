package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static ru.mos.smart.data.UrlObjectType.EOO_URL;
import static ru.mos.smart.data.UrlObjectType.MAP_URL;

public class UrlPage {

    @Step("Переход на карту")
    public void goToMaps() {
        open(MAP_URL);
    }

    @Step("В Навигаторе открыть раздел ЭОО")
    public void goToEoo() {
        open(EOO_URL);
    }
}
