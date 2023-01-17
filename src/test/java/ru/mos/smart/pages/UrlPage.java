package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static ru.mos.smart.data.UrlObjectType.*;

public class UrlPage {

    @Step("Переход на карту")
    public void goToMaps() {
        open(MAP_URL);
    }

    @Step("Переход на карту Цифровой Двойник")
    public void goToMapsCd() {
        open(MAP_CD);

    }

    @Step("В Навигаторе открыть раздел ЭОО")
    public void goToEoo() {
        open(EOO_URL);
    }
}
