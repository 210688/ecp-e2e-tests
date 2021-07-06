package ru.mos.smart.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class MkapmiiPage {
    public void selectRefuseDocsRadioButton() {
        step("В поле «Принять решение по заявлению» выбрать радиобаттон «Отказать в приеме документов»", () -> {
            $("input[ng-reflect-value=NEGATIVE_DOC_REFUSED]").click();
            $(byText("Сформировать файл решения")).shouldBe(visible);
        });
    }

    public void selectTakeToWorkRadioButton() {
        step("В поле «Принять решение по заявлению» выбрать радиобаттон «Принять в работу»", () -> {
            $("input[ng-reflect-value=POSITIVE]").click();
            $(byText("Сформировать файл решения")).shouldNotBe(visible);
        });
    }

    public void addRefuseReason() {
        step("Нажать кнопку добавления причины отказа", () ->
                $(".fas.fa-plus").click());
    }

    public void deleteRefuseReason() {
        step("Нажать кнопку удаления причины отказа", () ->
                $(".fas.fa-minus").click());
    }

    public void selectReason() {
        step("В поле «Причина отказа» выбрать причину из выпадающего списка", () -> {
            $("[placeholder=Причина]").click();
            $("ng-dropdown-panel").$(".ng-option").click();
        });
    }

    public void createDecisionFile() {
        step("Нажать на кнопку «Сформировать файл решения»", () ->
                $("button.btn-file-generation").click());
    }
}
