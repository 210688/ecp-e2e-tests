package ru.mos.smart.pages;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

/**
 * Описание навигатора.
 */

public class NavigatorPage {

    private final String reestrPage = "/main/#/app/catalogs/catalog-registers";
    private final String actionPage = "/main/#/app/actions";
    String url2D = "/map/#/map;onMode3D=true";
    String urlCD = "/map3d/#/map3d";
    String spravochnik = "/main/#/app/dicts/system";
    String task = "/main/#/app/tasks";

    public void goToActions() {
        step("Открытие рестра", () -> {
            open(actionPage);
        });
    }

    public NavigatorPage goToRegister() {
        step("Открытие рестра", () -> {
            open(reestrPage);
        });
        return this;
    }

    public void goToTasks() {
        step("В навигаторе открыть раздел Госуслуги и функции -> Задачи", () ->
                open(task));
    }

    public void goToSpravochnik() {
        step("В навигаторе открыть раздел Настройки -> Справочники", () -> {
            open(spravochnik);
        });
    }

    public void goToMaps() {
        step("Открытие 2D карты", () -> {
            open(url2D);
            $(".mapboxgl-canvas").shouldBe(visible, Duration.ofSeconds(10));
        });
    }

    public void goToMapsCD() {
        step("Открытие карты Цифровой двойник", () -> {
            open(urlCD);
            $("#city").should(visible, Duration.ofSeconds(40));
        });
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
