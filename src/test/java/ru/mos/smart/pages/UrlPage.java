package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeMain.MAP_CD;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeMain.MAP_URL;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeOasirx.*;

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
    @Step("В Навигаторе открыть раздел Публичные слушания")
    public void goToHearings() {
        open(HEARINGS_URL);
    }

    @Step("В Навигаторе открыть раздел Согласование документов")
    public void goToCrd() {
        open(CRD_URL);
    }

    @Step("В Навигаторе открыть раздел Фасады нежильё")
    public void goToFacades() {
        open(FCD_URL);
    }
}
