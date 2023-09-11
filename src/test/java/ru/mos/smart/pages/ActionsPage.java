package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.mos.smart.helpers.AllureAttachments;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница Возможности
 */

public class ActionsPage {
    private final SelenideElement process = $("trv-input input ");
    private final SelenideElement filter = $x("//button[contains(text(),'Фильтр')]");

    @Step("Запуск бизнес-процесса {businessProcess}")
    public void openToBusinessProcess(String businessProcess) {
        filter.click();
        process.val(businessProcess);
        $(byText(businessProcess)).click();
    }


    @Step("Список возможностей")
    public void checkActionsTask() {
        $("div[title='Провести консультирование']").should(visible);
        AllureAttachments.attachScreenshot("Список возможностей пользователя");
    }

    @Step("Переход в меню Возможности {actionName}")
    public void goToActions(String actionName) {
        $(byName("common")).setValue(actionName);
        $(byText(actionName)).click();
    }
}
