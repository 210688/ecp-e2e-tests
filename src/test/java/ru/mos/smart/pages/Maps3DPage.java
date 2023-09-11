package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;

/**
 * Описание Maps.
 */

public class Maps3DPage {

    private final SelenideElement addressSearch = $("input[placeholder='Найти адрес...']");
    private final SelenideElement address = $(".resultspanel");
    private final SelenideElement layerTree =  $("span[title='Дерево слоёв']");
    private final SelenideElement canvas = $(".cesium-viewer");
    private final ElementsCollection layerList = $$(".layerspanel.scroller");
    private final SelenideElement plus = $((".far.fa-plus"));
    private final SelenideElement minus = $((".far.fa-minus"));
    private final SelenideElement location = $("span[title='Первоначальная позиция']");


    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("Наличие подложки")
    public void checkForMapsBox() {
        switchToWindow();
        canvas.shouldBe(visible, ofSeconds(20));
    }

    @Step("На карте присутствует список слоев")
    public void checkLayerSearch() {
        switchToWindow();
        layerTree.click();
        layerList.shouldHave(sizeGreaterThan(0));
    }

    @Step("Проверить поиск адреса")
    public void checkSearchAddresses() {
        switchToWindow();
        addressSearch.setValue("Есенинский бульвар");
        address.shouldBe(visible, Duration.ofSeconds(30));
    }

    @Step("Наличие инструментов масштабирования: кнопок + и -")
    public void checkScalingTools() {
        switchToWindow();
        plus.should(visible, ofSeconds(20));
        minus.should(visible, ofSeconds(20));
    }

    @Step("Проверить наличие инструмента Первоначальная позиция")
    public void checkInitialPositionTool() {
        switchToWindow();
        location.shouldBe(visible).should(visible, ofSeconds(15));
    }
}
