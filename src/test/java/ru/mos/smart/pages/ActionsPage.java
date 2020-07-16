package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ActionsPage {

    @Step("Нажатие на пункт \"{text}\"")
    public void selectOption(String text) {
        $(byText(text)).click();
        $(byText("Ок")).click();
    }

}
