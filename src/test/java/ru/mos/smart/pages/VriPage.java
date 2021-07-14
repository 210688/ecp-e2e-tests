package ru.mos.smart.pages;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class VriPage {
    public VriPage checkIsOpened() {
        step("Открыт раздел ВРИ", () ->
                $x("//div/h2[contains(text(),'ВРИ')]").shouldBe(visible));

        return this;
    }

    public VriPage checkHasTabs(List<String> tabsList) {
        for (String tab : tabsList) {
            $(".tab-container").$(byText(tab)).shouldBe(visible);
        }

        return this;
    }
}
