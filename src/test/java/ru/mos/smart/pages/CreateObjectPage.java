package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreateObjectPage {

    @Step("Проверка, что форма создания объекта открылась")
    public void verifyCreateObjectFormIsOpened() {
        $(byText("Заполнить форму создания объекта")).shouldBe(visible);
        $(byText("Общие сведения")).shouldBe(visible);
    }
}
