package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница описания компонентов ЭОО
 */

public class EooComponents {

    public static void switchTask(int Index) {
        $(".fa-lg", Index).click(); // треугольничек нажатие перейти к задачи
    }

    @Step("Взять в работу назначенным исполнителем")
    public static void buttonTakeTask(){ // Взять в работу назначенным исполнителем
        $x("//div/button[text()='Взять в работу']")
                .waitUntil(visible, 10000).click(); // взять в работу кнопка
    }

    @Step("Сохранить и перейти дальше")
    public static void saveButtonNextTask(){  //Сохранить и передать на подготовку
        $("#next").waitUntil(visible, 10000).click();
    }

    @Step("Сохранить и перейти дальше")
    public static void saveButtonNextSoglas(){  //Сохранить и передать на подготовку approved
        $("#approved").waitUntil(visible, 10000).click();
    }

    @Step("Переход в задачу из ЭОО")
    public static void inTaskEoo() {
        $(by("uisref", "app.eoo.eoo"))
                .waitUntil(visible, 10000).click();
    }

    @Step("Назначение прав определенному лицу")
    public static void giveOutPrava(String task) {
        $(byText(task)).parent().parent().$((".fa-edit")).waitUntil(visible, 10000).click();
        $(".ng-input").waitUntil(visible, 10000).click();
        $(".ng-input input").waitUntil(visible, 10000).setValue("Электронные Общественные Обсуждения").pressEnter();
        $(".fa-save").waitUntil(visible, 10000).click();
    }
}

