package ru.mos.smart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

/**
 * Главная страница описание, что есть что.
 */

public class MainPage {

    @Step("Возможности")
    public static void actions() {
        step("Возможности", ()-> {
            $(By.xpath("//nav//a[@href='/main/#/app/actions']"))
                    .shouldBe(visible).click();
        });
    }

    @Step("ЭОО")
    public static void dobavitEoo() {
        $(By.xpath("//nav//a//span[text()='ЭОО']")).click();
    }
}
