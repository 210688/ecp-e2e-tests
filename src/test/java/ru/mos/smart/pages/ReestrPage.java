package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ReestrPage {

    @Step("Открыть реестр {registerName}")
    public static void open(String registerName) {
        $(byName("candidateSearchValue")).setValue(registerName).pressEnter();
        $(byText(registerName)).click();
    }

    @Step("Открыть карточку жителя, нажав на поле с ФИО жителя")
    public static void gotoFirstCard() {
        $("showcase-builder-runtime a").click();
        switchTo().window(1);
    }

    @Step("Открытие раздела СД")
    public static void goToSdCard() {
        $(byText("СД")).click();
        $(byText("СД")).shouldBe(visible);
    }
}
