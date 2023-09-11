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

    private final SelenideElement addressSearch = $("input[placeholder='Поиск']");
    private final SelenideElement layerSearch = $("input[placeholder='Найти слой']");
    private final SelenideElement canvas = $("canvas[aria-label='Map']");
    private final SelenideElement icon =  $(("button[tooltip-right='3D режим']")); //$(".icon-alt-3d");
    private final SelenideElement traffic = $(("button[tooltip-right='Пробки']"));
    private final SelenideElement pedestrian = $(("button[tooltip-right='Панорамы']"));
    private final SelenideElement painting = $(("button[tooltip-right='Рисование']"));
    private final SelenideElement instruments = $(("button[tooltip-right='Измерение']"));
    private final SelenideElement legend = $(("button[tooltip-right='Условные обозначения']"));
    private final SelenideElement info = $(("button[tooltip-right='Информация']"));
    private final SelenideElement plus = $(("button[tooltip-right='Приблизить']"));
    private final SelenideElement minus = $(("button[tooltip-right='Отдалить']"));
    private final SelenideElement location = $(("button[tooltip-right='Мое местоположение']"));


    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("Проверить наличие подложки")
    public void checkForMapsBox() {
        switchToWindow();
        canvas.shouldBe(visible, ofSeconds(20));
    }

    @Step("На карте присутствуют кнопки {expectedTexts}")
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

    @Step("На карте присутствует поле адресного поиска")
    public void checkAddressSearch() {
        switchToWindow();
        addressSearch.shouldBe(visible, ofSeconds(15));
    }

    @Step("На карте присутствует поле поиска слоя")
    public void checkLayerSearch() {
        switchToWindow();
        layerSearch.shouldBe(visible, ofSeconds(10));
    }

    @Step("Проверить поиск адреса")
    public void checkSearchAddresses() {
        switchToWindow();
        addressSearch.setValue("улица Кузнецкий Мост").shouldBe(visible, ofSeconds(20));
    }

    @Step("Проверить наличие инструментов масштабирования: кнопок + и -")
    public void checkScalingTools() {
        switchToWindow();
        plus.should(visible, ofSeconds(10));
        minus.should(visible, ofSeconds(10));
    }

    @Step("Проверить наличие инструмента Мое местоположение")
    public void checkMyLocationTool() {
        switchToWindow();
        location.should(visible, ofSeconds(10));
    }

    @Step("Проверить наличие инструмента Первоначальная позиция")
    public void checkInitialPositionTool() {
        switchToWindow();
        $(("button[tooltip-right='Первоначальная позиция']")).should(visible, ofSeconds(15));
    }
}
