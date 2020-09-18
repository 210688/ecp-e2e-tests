package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MapsPage {

    @Step("Нажатие на пункты меню")
    public static void Menu() {
        $(byText("Информация")).click();
        $(byText("Карта")).click();
    }
}

