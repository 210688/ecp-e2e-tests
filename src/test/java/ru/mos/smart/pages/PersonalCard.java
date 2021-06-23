package ru.mos.smart.pages;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PersonalCard {
    @Step("Перейти на вкладку {tabName}")
    public static void gotoTab(String tabName) {
        $("app-standard-header").shouldBe(visible, Duration.ofSeconds(10));
        $$(".nav-link").findBy(text("Возможности")).click();
    }

    @Step("В модальном окне с предупреждением нажать на кнопку Ок")
    public static void clickOk() {
        $(".modal-content button").click();
    }

    @Step("Открыть возможность {capabilityName}")
    public static void openCapability(String capabilityName) {
        $$("td").findBy(text(capabilityName)).click();
    }
}
