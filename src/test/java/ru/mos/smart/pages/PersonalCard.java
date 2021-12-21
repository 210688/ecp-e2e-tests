package ru.mos.smart.pages;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PersonalCard {
    @Step("Перейти на вкладку {tabName}")
    public PersonalCard gotoTab(String tabName) {
        //$$(".nav-link").findBy(text("Возможности")).click();
        $(".wrapper.wrapper-content").shouldBe(visible, Duration.ofSeconds(10));

        return this;
    }

    @Step("В модальном окне с предупреждением нажать на кнопку Ок")
    public PersonalCard clickOk() {
        $(".modal-content button").click();
        //$x("//button[contains(text(),'Ок')]").click();
        return this;
    }

    @Step("Открыть возможность {capabilityName}")
    public PersonalCard openCapability(String capabilityName) {
        $$("td").findBy(text(capabilityName)).click();

        return this;
    }
}
