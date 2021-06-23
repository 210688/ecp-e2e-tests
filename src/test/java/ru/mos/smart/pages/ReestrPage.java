package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ReestrPage {

    public static void Drone() {

        step("Найти и открыть реестр Данные аэрофотосъемки", () -> {
            $(byName("candidateSearchValue")).setValue("Данные аэрофотосъемки").pressEnter();
            $(byLinkText("Данные аэрофотосъемки")).click();
        });

    }

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
}
