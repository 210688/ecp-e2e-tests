package ru.mos.smart.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MkapmiiPage {
    public void selectRefuseDocsRadioButton() {
        step("В поле «Принять решение по заявлению» выбрать радиобаттон «Отказать в приеме документов»", () -> {
            $("input[ng-reflect-value=NEGATIVE_DOC_REFUSED]").shouldNotHave(attribute("[disabled]")).click();
            $(byText("Сформировать файл решения")).shouldBe(visible);
        });
    }

    public void selectTakeToWorkRadioButton() {
        step("В поле «Принять решение по заявлению» выбрать радиобаттон «Принять в работу»", () -> {
            $("input[ng-reflect-value=POSITIVE]").shouldNotHave(attribute("[disabled]")).click();
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
        step("Нажать на кнопку «Сформировать файл решения»", () -> {
            $("button.btn-file-generation").click();
            $$(".toast-message").findBy(text("Заключение успешно сформировано!")).shouldBe(visible);
        });
    }

    public void createDecisionFile(String error) {
        step("Нажать на кнопку «Сформировать файл решения»", () ->
                $("button.btn-file-generation").click());
        step("Проверить, что всплывает алерт с ошибкой с указанием" +
                " на отсутствие причины отказа " + error, () -> {
            $$(".toast-message").findBy(text(error)).shouldBe(visible);
        });
    }

    public void addRefuseComment(String commentText) {
        step("В поле «Комментарий» ввести произвольное текстовое значение", () -> {
            $("textarea.form-control").setValue(commentText);
        });
    }
}
