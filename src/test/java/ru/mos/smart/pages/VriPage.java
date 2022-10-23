package ru.mos.smart.pages;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VriPage {

    Faker faker = new Faker();
    public VriPage checkIsOpened() {
        step("Открыт раздел ВРИ", () ->
                $x("//div/h2[contains(text(),'ВРИ')]").shouldBe(visible));

        return this;
    }

    @Step("Проверить, что есть вкладки [{tabsList}]")
    public VriPage checkHasTabs(List<String> tabsList) {
        for (String tab : tabsList) {
            step("Видна вкладка " + tab, () ->
                    $(".tab-container").$(byText(tab)).shouldBe(visible));
        }

        return this;
    }

    @Step("Нажать на шестеренку и выбрать [{option}]")
    public VriPage cogWheelChoose(String option) {
        $(".fa.fa-cog").click();
        $(".additional-menu.dropdown").shouldHave(cssClass("show"));
        step("Выбрать " + option, () ->
                $(".additional-menu.dropdown").$(byText(option)).click());

        return this;
    }

    @Step("Нажать на кнопку [{buttonText}]")
    public VriPage clickButton(String buttonText) {
        $(".panel-title").$$("button").findBy(text(buttonText)).click();

        return this;
    }

    @Step("Открывается страница с историей изменений в заявке")
    public VriPage checkChangeLogShown() {
        $("cdp-document-log-by-date").shouldBe(visible);

        step("Отображается информация о смене статуса заявки, авторе и времени", () -> {
            $("cdp-document-log-status").shouldBe(visible);
            $(".table thead").shouldHave(text("Операция"));
            $(".table thead").shouldHave(text("Дата"));
            $(".table thead").shouldHave(text("Пользователь"));
            $(".table tbody").$$("tr").shouldHave(sizeGreaterThan(0));
        });

        return this;
    }

    @Step("Открывается таблица с приложенными материалами")
    public VriPage checkMaterialsShown() {
        $("app-vri-materials").shouldBe(visible);

        step("Отображается информация о смене статуса заявки, авторе и времени", () -> {
            $("app-vri-materials").$$("app-vri-material").shouldHave(sizeGreaterThan(0));
        });

        return this;
    }

    @Step("Открывается страница со схемой бизнес-процесса")
    public void openProcessDiagram() {
        $(".fa.fa-bar-chart").click();
        switchTo().window(1);
        assertTrue(title().contains("diagram"));
        Selenide.closeWindow();
        switchTo().window(0);
    }

    @Step("Открыть первую карточку")
    public VriPage openFirstCard() {
        $(".table tbody a").click();

        return this;
    }
}
