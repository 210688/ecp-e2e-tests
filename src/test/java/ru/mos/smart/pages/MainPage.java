package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

/**
 * Главная страница описание, что есть что.
 */

public class MainPage {

    @Step("Возможности")
    public static void actions() {
        step("Возможности", ()-> {
            $x("//nav//a[@href='/main/#/app/actions']")
                    .shouldBe(visible).click();
        });
    }

    @Step("ЭОО")
    public static void dobavitEoo() {
        $x("//nav//a//span[text()='ЭОО']")
                .waitUntil(visible, 10000).click();
    }

    @Step("Реестры")
    public static void otkrytReestr() {
        $x("//nav//a[@href='/main/#/app/catalog-registers']")
                .shouldBe(visible).click();
    }
}
