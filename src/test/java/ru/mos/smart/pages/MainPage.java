package ru.mos.smart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

/**
 * Главная страница описание, что есть что.
 */

public class MainPage {

    @Step("Возможности")
    public static void actionsPage() {
        step("Возможности", () -> {
            $(By.xpath("//nav//a[@href='/main/#/app/actions']"))
                    .shouldBe(visible).click();
        });
    }

    @Step("Выход")
    public static void logOut() {
        $(withText("Выйти")).waitUntil(visible, 10000).click();
        $(withText("Войти")).waitUntil(visible, 10000);
    }
}