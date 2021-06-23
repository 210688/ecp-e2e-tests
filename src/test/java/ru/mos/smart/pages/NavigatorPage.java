package ru.mos.smart.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

/**
 * Описание навигатора.
 */

public class NavigatorPage {

    public static void actionsPage() {
        step("В навигаторе открыть раздел Госуслуги и функции -> Возможности", () ->
                $(("a[href='/main/#/app/actions']")).click());
    }

    public static void tasksPage() {
        step("В навигаторе открыть раздел Госуслуги и функции -> Задачи", () -> {
            $(("a[href='/main/#/app/tasks']")).click();
        });
    }

    public static void reestrPage() {
        step("В навигаторе открыть раздел Информация -> Реестр", () -> {
            $(byText("Информация")).click();
            $(("a[href='/main/#/app/catalog-registers']")).click();
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

    public static void spravochnikPage() {
        step("В навигаторе открыть раздел Настройки -> Справочники", () -> {
            $(byText("Настройки")).click();
            $(("a[href='/main/#/app/dicts/system']")).click();
        });
    }

    public static void openMaps() {
        step("В навигаторе открыть раздел Информация -> карта", () -> {
            $(byText("Информация")).click();
            $(("a[href='/map/#/map;onMode3D=true']")).click();
        });
    }

    public static void openSprit() {
        step("В навигаторе открыть раздел Выдача СПРИТ", () -> {
            $(("a[href='/oasirx/sprit/#/app/sprit/list']")).click();
        });
    }


    public static void openEoo() {
        step("В Навигаторе открыть раздел ЭОО", () -> {
            $(("a[href='/oasirx/eoo/#/app/eoo/list']")).click();
        });
    }
}
