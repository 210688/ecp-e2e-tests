package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

/**
 * Главная страница описание, что есть что.
 */

public class MainPage {

    @Step("Открытие меню  возможности")
    public static void actionsPage() {
        step("Возможности", () -> {
            $x("//nav//a[@href='/main/#/app/actions']")
                    .shouldBe(visible).click();
        });
    }

    @Step("Открытие Реестра")
    public static void InformaciyaAndReestr() { // Переход в реестры
        $(byLinkText("Информация")).waitUntil(visible, 10000).click();
        $x("//a[@href='/main/#/app/catalog-registers']").waitUntil(visible, 10000).click();
    }

    @Step("ЭОО")
    public static void dobavitEoo() {
        $x("//nav//a//span[text()='ЭОО']")
                .waitUntil(visible, 10000).click();
    }
}
