package ru.mos.smart.pages;

import io.qameta.allure.Step;
import ru.mos.smart.helpers.AllureAttachments;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeMain.ACTIONS_URL;

/**
 * Страница Возможности
 */

public class ActionsPage {
    public static String
            actionName = "Создать ЭОО",
            feedback = "Инициировать обращение в техническую поддержку";

    @Step("Проверка, что в возможностях пользователя присутствует список возможностей")
    public void checkActionsTask() {
        $(".ag-header-cell-text").should(visible, Duration.ofSeconds(10));
        AllureAttachments.attachScreenshot("Список возможностей пользователя");
    }

    @Step("Переход в меню Возможности {actionName}")
    public void goToActions(String actionName) {
        open(ACTIONS_URL);
        $(byName("common")).setValue(actionName);
        $(byText(actionName)).click();
    }
}
