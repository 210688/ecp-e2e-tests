package ru.mos.smart.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

/**
 * Описание навигатора.
 */

public class NavigatorPage {

    public static void goToActions() {
        step("В навигаторе открыть раздел Госуслуги и функции -> Возможности", () ->
                $(("a[href='/main/#/app/actions']")).click());
    }

    public static void goToTasks() {
        step("В навигаторе открыть раздел Госуслуги и функции -> Задачи", () ->
                $(("a[href='/main/#/app/tasks']")).click());
    }

    public static void goToRegister() {
        step("В навигаторе открыть раздел Информация -> Реестр", () -> {
            $(byText("Информация")).click();
            $(("a[href='/main/#/app/catalog-registers']")).click();
        });
    }

    public static void goToSpravochnik() {
        step("В навигаторе открыть раздел Настройки -> Справочники", () -> {
            $(byText("Настройки")).click();
            $(("a[href='/main/#/app/dicts/system']")).click();
        });
    }

    public static void goToMaps() {
        step("В навигаторе открыть раздел Информация -> карта", () -> {
            $(byText("Информация")).click();
            $(("a[href='/map/#/map;onMode3D=true']")).click();
        });
    }

    public static void gotoChessboard() {
        step("В навигаторе открыть раздел Информация -> Дашборды -> Оперативный мониторинг за ходом переселения", () -> {
            $(byText("Информация")).click();
            $(byText("Дашборды")).click();
            $(("a[href='/ssr/chessboard/']")).click();
            switchTo().window(1);
        });
    }

    public static void goToSprit() {
        step("В навигаторе открыть раздел Выдача СПРИТ", () ->
                $(("a[href='/oasirx/sprit/#/app/sprit/list']")).click());
    }

    public static void goToEoo() {
        step("В Навигаторе открыть раздел ЭОО", () ->
                $(("a[href='/oasirx/eoo/#/app/eoo/list']")).click());
        step("Открыт раздел Общественные обсуждения", () ->
                $x("//div/h2[contains(text(),'Общеcтвенные обcуждения')]").shouldBe(visible));
    }

    public static void goToItmka() {
        step("Из боковой панели перейти в раздел Управление ИТ МКА", () ->
                $x("//span[text()='Управление ИТ МКА']").click());
    }

    public static void goToViolations() {
        step("Из боковой панели перейти в раздел Нарушения ОГД", () ->
                $x("//span[text()='Нарушения ОГД']").click());
    }

    public static void goToPkl() {
        step("Из боковой панели перейти в раздел ПКЛ", () ->
                $x("//span[text()='ПКЛ']").click());
    }

    public static void goToPmt() {
        step("Из боковой панели перейти в раздел ПМТ", () ->
                $x("//span[text()='ПМТ']").click());
    }
}
