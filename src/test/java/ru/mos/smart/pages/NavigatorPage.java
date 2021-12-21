package ru.mos.smart.pages;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

/**
 * Описание навигатора.
 */

public class NavigatorPage {

    public NavigatorPage goToActions() {
        step("В навигаторе открыть раздел Госуслуги и функции -> Возможности", () ->
                $(("a[href='/main/#/app/actions']")).click());

        return this;
    }

    public NavigatorPage goToTasks() {
        step("В навигаторе открыть раздел Госуслуги и функции -> Задачи", () ->
                $(("a[href='/main/#/app/tasks']")).click());

        return this;
    }

    public NavigatorPage goToRegister() {
        step("В навигаторе открыть раздел Информация -> Реестр", () -> {
            $(byText("Информация")).click();
            $(("a[href='/main/#/app/catalog-registers']")).click();
        });

        return this;
    }

    public NavigatorPage goToSpravochnik() {
        step("В навигаторе открыть раздел Настройки -> Справочники", () -> {
            $(byText("Настройки")).click();
            $(("a[href='/main/#/app/dicts/system']")).click();
        });

        return this;
    }

    public void goToMaps() {
        step("В навигаторе открыть раздел Информация -> карта", () -> {
            $(byText("Информация")).click();
            $(("a[href='/map/#/map;onMode3D=true']")).click();
            switchTo().window(1);
            $(".mapboxgl-canvas").shouldBe(visible, Duration.ofSeconds(10));
        });

    }

    public NavigatorPage goToMaps3D() {
        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(20));
        });

        return this;
    }

    public NavigatorPage gotoChessboard() {
        step("В навигаторе открыть раздел Информация -> Дашборды -> Оперативный мониторинг за ходом переселения", () -> {
            $(byText("Информация")).click();
            $(byText("Дашборды")).click();
            $(("a[href='/ssr/chessboard/']")).click();
            switchTo().window(1);
        });

        return this;
    }

    public NavigatorPage goToSprit() {
        step("В навигаторе открыть раздел Выдача СПРИТ", () ->
                $(("a[href='/oasirx/sprit/#/app/sprit/list']")).click());

        return this;
    }

    public NavigatorPage goToEoo() {
        step("В Навигаторе открыть раздел ЭОО", () ->
                $(("a[href='/oasirx/eoo/#/app/eoo/list']")).click());
        step("Открыт раздел Общественные обсуждения", () ->
                $x("//div/h2[contains(text(),'Общеcтвенные обcуждения')]").shouldBe(visible));

        return this;
    }

    public NavigatorPage goToItmka() {
        step("Из боковой панели перейти в раздел Управление ИТ МКА", () ->
                $x("//span[text()='Управление ИТ МКА']").click());
        return this;
    }

    public NavigatorPage goToViolations() {
        step("Из боковой панели перейти в раздел Нарушения ОГД", () ->
                $x("//span[text()='Нарушения ОГД']").click());

        return this;
    }

    public NavigatorPage goToPkl() {
        step("Из боковой панели перейти в раздел ПКЛ", () ->
                $x("//span[text()='ПКЛ']").click());

        return this;
    }

    public NavigatorPage goToPmt() {
        step("Из боковой панели перейти в раздел ПМТ", () ->
                $x("//span[text()='ПМТ']").click());

        return this;
    }

    public NavigatorPage goToSzz() {
        step("Из боковой панели перейти в раздел СЗЗ", () ->
                $x("//span[text()='СЗЗ']").click());

        return this;
    }

    public void goToVri() {
        step("Из боковой панели перейти в раздел ВРИ", () ->
                $x("//span[text()='ВРИ']").click());
    }
}
