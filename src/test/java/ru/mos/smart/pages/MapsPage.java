package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static java.time.Duration.ofSeconds;


/**
 * Описание Maps.
 */


public class MapsPage {

    private final SelenideElement
            addressSearch = $("input[placeholder='Поиск']"),
            layerSearch = $("input[placeholder='Найти слой']"),
            canvas = $("canvas[aria-label='Map']"),
            icon = $(("button[tooltip-right='3D режим']")),//$(".icon-alt-3d");
            traffic = $(("button[tooltip-right='Пробки']")),
            pedestrian = $(("button[tooltip-right='Панорамы']")),
            painting = $(("button[tooltip-right='Рисование']")),
            instruments = $(("button[tooltip-right='Измерение']")),
            legend = $(("button[tooltip-right='Условные обозначения']")),
            info = $(("button[tooltip-right='Информация']")),
            plus = $(("button[tooltip-right='Приблизить']")),
            minus = $(("button[tooltip-right='Отдалить']")),
            location = $(("button[tooltip-right='Мое местоположение']"));


    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("На карте 2D присутствует подложка")
    public void checkForMapsBox() {
        switchToWindow();
        canvas.shouldBe(visible, ofSeconds(20));
    }

    @Step("На карте 2D присутствуют кнопки {expectedTexts}")
    public void checkInstrumentsMaps(String[] expectedTexts) {
        switchToWindow();
        icon.should(visible, ofSeconds(15));
        traffic.should(visible, ofSeconds(15));
        pedestrian.should(visible, ofSeconds(15));
        painting.should(visible, ofSeconds(15));
        instruments.should(visible, ofSeconds(15));
        legend.should(visible, ofSeconds(15));
        info.should(visible, ofSeconds(15));
    }

    @Step("На карте 2D присутствует поле адресного поиска")
    public void checkAddressSearch() {
        switchToWindow();
        addressSearch.shouldBe(visible, ofSeconds(15));
    }

    @Step("На карте 2D присутствует поле поиска слоя")
    public void checkLayerSearch() {
        switchToWindow();
        layerSearch.shouldBe(visible, ofSeconds(10));
    }

    @Step("Осуществляется поиск адреса на карте 2D")
    public void checkSearchAddresses() {
        switchToWindow();
        addressSearch.setValue("улица Кузнецкий Мост").shouldBe(visible, ofSeconds(20));
    }

    @Step("Наличие инструментов масштабирования: кнопок + и - на карте 2D")
    public void checkScalingTools() {
        switchToWindow();
        plus.should(visible, ofSeconds(10));
        minus.should(visible, ofSeconds(10));
    }

    @Step("Наличие инструмента Мое местоположение на карте 2D")
    public void checkMyLocationTool() {
        switchToWindow();
        location.should(visible, ofSeconds(10));
    }

    @Step("Наличие инструмента Первоначальная позиция на карте 2D")
    public void checkInitialPositionTool() {
        switchToWindow();
        $(("button[tooltip-right='Первоначальная позиция']")).should(visible, ofSeconds(15));
    }
}
