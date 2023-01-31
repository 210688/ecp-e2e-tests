package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
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

    private final SelenideElement addressSearch = $("input[placeholder='Поиск']");
    private final SelenideElement layerSearch = $("input[placeholder='Найти слой']");
    private final SelenideElement mapsBox = $("canvas[aria-label='Map']");
    private final SelenideElement mapsBoxCd = $("#city");
    private final SelenideElement instruments = $(("button[tooltip-right='Измерение']"));
    private final SelenideElement myTask = $(".font-bold.hidden-xs");

    @Step("Проверить наличие подложки")
    public void checkForMapsBox() {
        mapsBox.shouldBe(visible, ofSeconds(10));
    }

    @Step("Проверить наличие адреса в поиске")
    public void checkSearch() {
        addressSearch.setValue("Новокузнецкая улица").shouldBe(visible);
/*        $(".results").shouldBe(visible,ofSeconds(20));
        AllureAttachments.screenshotAs("Maps");*/
    }


    @Step("Проверить наличие подложки")
    public void checkForMapsBoxCd() {
        mapsBoxCd.should(visible, ofSeconds(30));
    }

    @Step("Проверить наличие инструментов измерений: Измерение расстояния, Измерение площади, Измерение периметра")
    public void checkInstrumentsMaps() {
        instruments.click();
        distance.shouldBe(visible, ofSeconds(20));
        area.shouldBe(visible, ofSeconds(20));
        perimeter.shouldBe(visible, ofSeconds(20));
    }

    @Step("Проверить наличие поля адресного поиска")
    public void checkAddressSearch() {
        addressSearch.shouldBe(visible, ofSeconds(20));
    }

    @Step("Проверить наличие поля поиска слоя")
    public void checkLayerSearch() {
        layerSearch.shouldBe(visible, ofSeconds(20));
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
