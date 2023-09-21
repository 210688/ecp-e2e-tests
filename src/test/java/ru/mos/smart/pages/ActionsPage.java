package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.OpportunityForm;
import ru.mos.smart.helpers.AllureAttachments;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Страница Возможности
 */

public class ActionsPage {
    private final SelenideElement businessProcessInputField = $("trv-input input");
    //private final SelenideElement buttonFilter = $x("//button[contains(text(),'Фильтр')]");
    private final SelenideElement buttonFilter = $("lib-button");
    @Step("Запуск бизнес-процесса {businessProcess}")
    public void openToBusinessProcess(OpportunityForm businessProcess) {
        buttonFilter.click();
        businessProcessInputField.val(businessProcess.value());
        $(byText(businessProcess.value())).click();
    }

    @Step("Список возможностей")
    public void checkActionsTask() {
        $("div[title='Провести консультирование']").should(visible);
        AllureAttachments.attachScreenshot("Список возможностей пользователя");
    }

    @Step("В меню доступны вкладки {tabAll} и {tabFavorites}")
    public void checkHeadersAction(String tabAll, String tabFavorites) {
        $("button[title='" + tabAll + "']").should(visible);
        $("button[title='" + tabFavorites + "']").should(visible);
    }

    @Step("Переход в меню Возможности {actionName}")
    public void goToActions(String actionName) {
        $(byName("common")).setValue(actionName);
        $(byText(actionName)).click();
    }
}
