package ru.mos.smart.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class MkasdprvPage {
    public void selectRefuseDocsRadioButton() {
        step("В поле «Принять решение по заявлению» выбрать радиобаттон «Отказать в приеме документов»", () -> {
            $("[for=Refuse]").parent().$("input").click();
        });
    }

    public void addComment(String commentText) {
        step("В поле «Комментарий» ввести произвольное текстовое значение", () -> {
            $("textarea.form-control").setValue(commentText);
        });
    }

    public void createDecisionFile() {
        step("Нажать на кнопку «Сформировать файл решения»", () ->
                $("button.for-reason-btn").click());
    }

    @Step("Удаление файла решения")
    public void deleteDecisionFile() {
        $$(".ex-small-file-box").last().$(".fa.fa-trash-o").click();
        $(".modal-content").$(".btn-primary").click();
    }

    @Step("Загрузка файла решения {fileName}")
    public void uploadDecisionFile(String fileName) {
        Selenide.executeJavaScript("$(\"input[type='file']\").last().val('');");
        $$("input[type='file']").last().uploadFromClasspath(fileName);
    }

    public void selectReason() {
        step("В поле «Причина отказа» выбрать причину из выпадающего списка", () -> {
            $("[placeholder=Причина]").click();
            $("ng-dropdown-panel").$(".ng-option").click();
        });
    }
}
