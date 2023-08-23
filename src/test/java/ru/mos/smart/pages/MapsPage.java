package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Описание Maps.
 */


public class MapsPage {

    private final SelenideElement addressSearch = $("input[placeholder='Поиск']");
    private final SelenideElement layerSearch = $("input[placeholder='Найти слой']");
    private final SelenideElement canvas = $("canvas[aria-label='Map']");
    private final SelenideElement icon = $(("button[tooltip-right='3D режим']"));
    private final SelenideElement traffic = $(("button[tooltip-right='Пробки']"));
    private final SelenideElement pedestrian = $(("button[tooltip-right='Панорамы']"));
    private final SelenideElement painting = $(("button[tooltip-right='Рисование']"));
    private final SelenideElement instruments = $(("button[tooltip-right='Измерение']"));
    private final SelenideElement legend = $(("button[tooltip-right='Условные обозначения']"));
    private final SelenideElement info = $(("button[tooltip-right='Информация']"));
    private final SelenideElement plus = $(("button[tooltip-right='Приблизить']"));
    private final SelenideElement minus = $(("button[tooltip-right='Отдалить']"));
    private final SelenideElement location = $(("button[tooltip-right='Мое местоположение']"));


    private void switchToWindow(int windowIndex) {
        switchTo().window(windowIndex);
    }

    @Step("Проверить наличие подложки")
    public void checkForMapsBox() {
        switchToWindow(1);
        canvas.shouldBe(visible, ofSeconds(20));
    }

    @Step("Проверить наличие кнопок  {expectedTexts} 3D режим, Пробки, Панорамы, Рисование, Измерение, Условные обозначения, Информация")
    public void checkInstrumentsMaps(String[] expectedTexts) {
        switchToWindow(1);
        /*$$(".map-buttons top").shouldHave(texts("3D режим", "Пробки", "Панорамы", "Рисование",
                "Измерение", "Условные обозначения", "Информация"));*/
        icon.should(visible, ofSeconds(10));
        traffic.should(visible, ofSeconds(10));
        pedestrian.should(visible, ofSeconds(10));
        painting.should(visible, ofSeconds(10));
        instruments.should(visible, ofSeconds(10));
        legend.should(visible, ofSeconds(10));
        info.should(visible, ofSeconds(10));
    }

    @Step("Проверить наличие поля адресного поиска")
    public void checkAddressSearch() {
        switchToWindow(1);
        addressSearch.shouldBe(visible, ofSeconds(10));
    }

    @Step("Проверить наличие поля поиска слоя")
    public void checkLayerSearch() {
        switchToWindow(1);
        layerSearch.shouldBe(visible, ofSeconds(10));
    }

    @Step("Проверить поиск адреса")
    public void checkSearchAddresses() {
        switchToWindow(1);
        addressSearch.setValue("улица Кузнецкий Мост").shouldBe(visible, ofSeconds(20));
/*        $(".results").shouldBe(visible,ofSeconds(20));
        AllureAttachments.screenshotAs("Maps");*/
    }

    @Step("Проверить наличие инструментов масштабирования: кнопок + и -")
    public void checkScalingTools() {
        switchToWindow(1);
        plus.should(visible, ofSeconds(10));
        minus.should(visible, ofSeconds(10));
    }

    @Step("Проверить наличие инструмента Мое местоположение")
    public void checkMyLocationTool() {
        switchToWindow(1);
        location.should(visible, ofSeconds(10));
    }

    @Step("Проверить наличие инструмента Первоначальная позиция")
    public void checkInitialPositionTool() {
        switchToWindow(1);
        $(("button[tooltip-right='Первоначальная позиция']")).should(visible, ofSeconds(10));
    }
}
