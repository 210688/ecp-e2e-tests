package ru.mos.smart.pages;

import com.codeborne.selenide.Selectors;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class EooPagesButton {

    @Step("Нажатие на кнопку следующая задача")
    public static void SwitchTask() {
        $(".fa-lg").click();
    }
    @Step("Нажать на кнопку Взять задачу в работу?")
    public static void TakeTask() {
        $(byText("Взять в работу")).click();
    }
}

