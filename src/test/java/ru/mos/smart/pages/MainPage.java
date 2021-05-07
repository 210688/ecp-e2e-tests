package ru.mos.smart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

/**
 * Главная страница описание, что есть что.
 */

public class MainPage {

    public static void ActionsPage() {
        step("Открытие Госуслуги и функции -> Возможности", () ->
                $(byCssSelector("a[href='/main/#/app/actions']")).click());
    }

    public static void TasksPage() {
        step("Открытие меню Госуслуги и функции -> Задачи", () -> {
            $(byCssSelector("a[href='/main/#/app/tasks']")).click();
        });
    }

    public static void ReestrPage() {
        step("Открытие меню Информация -> Реестр", () -> {
            $(byText("Информация")).click();
            $(byCssSelector("a[href='/main/#/app/catalog-registers']")).click();
        });
    }

    public static void SpravochnikPage() {
        step("Открытие меню Настройки -> Справочники", () -> {
            $(byText("Настройки")).click();
            $(byCssSelector("a[href='/main/#/app/dicts/system']")).click();
        });
    }

    public static void OpenMaps() {
        step("Открытие меню Информация -> карта", () -> {
            $(byText("Информация")).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });
    }


}

