package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static ru.mos.smart.data.UrlObjectType.EOO_URL;
import static ru.mos.smart.data.UrlObjectType.MAP_CD;


/**
 * Описание Maps.
 */


public class MapsPage {

    private final SelenideElement
            distance = $x("//button[contains(text(),'Измерение расстояния')]"),
            area = $x("//button[contains(text(),'Измерение площади')]"),
            perimeter = $x("//button[contains(text(),'Измерение периметра')]");

    private final SelenideElement
            layerSearch = $("input[placeholder='Найти слой']"),
            addressSearch = $("input[placeholder='Поиск']");
    private final SelenideElement mapsBox = $("canvas[aria-label='Map']");
    private final SelenideElement instruments = $(("button[tooltip-right='Измерение']"));
    private final SelenideElement myTask = $(".font-bold.hidden-xs");
    //private final SelenideElement searchTask = $(byName("search"));


    @Step("Проверить наличие подложки")
    public void checkForMapsBox() {
        mapsBox.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Проверить наличие инструментов измерений: Измерение расстояния, Измерение площади, Измерение периметра")
    public void checkInstruments() {
        instruments.click();
        distance.shouldBe(visible, Duration.ofSeconds(20));
        area.shouldBe(visible, Duration.ofSeconds(20));
        perimeter.shouldBe(visible, Duration.ofSeconds(20));
    }

    @Step("Проверить наличие строки адресного поиска")
    public void checkAddressSearch() {
        layerSearch.shouldBe(visible, Duration.ofSeconds(20));
        addressSearch.shouldBe(visible, Duration.ofSeconds(20));
    }

    @Step("Переход в карту Цифровой двойник")
    public void goToMapsCD() {
        open(MAP_CD);
    }

    @Step("В Навигаторе открыть раздел ЭОО")
    public void goToEoo() {
        open(EOO_URL);
        $(".ng-binding").shouldBe(visible);
    }
}
