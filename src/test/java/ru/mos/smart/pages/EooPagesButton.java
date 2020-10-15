package ru.mos.smart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class EooPagesButton {

    public static void switchTask(int Index) {
        $(".fa-lg", Index).click(); // треугольничек нажатие перейти к задачи
    }

    @Step("Взять в работу назначенным исполнителем")
    public static void buttonTakeTask(){ // Взять в работу назначенным исполнителем
        $x("//div/button[text()='Взять в работу']").click(); // взять в работу кнопка
    }

    @Step("Сохранить и перейти дальше")
    public static void saveButtonNextTask(){  //Сохранить и передать на подготовку
        $("#next").click();
    }

    @Step("Переход в задачу из ЭОО")
    public static void inTaskEoo() {
        $(by("uisref", "app.eoo.eoo")).click();
    }
}