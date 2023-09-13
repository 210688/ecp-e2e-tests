package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.mos.smart.data.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Страница Возможности
 */

public class ActionsPage {
    private final SelenideElement process = $("trv-input input ");
    private final SelenideElement filter = $x("//button[contains(text(),'Фильтр')]");
    private final ElementsCollection registryName = $$("trv-input");

    @Step("Запуск бизнес-процесса {businessProcess}")
    public void openToBusinessProcess(String businessProcess) {
        filter.click();
        process.val(businessProcess);
        $(byText(businessProcess)).click();
    }

    @Step("Переход в реестр {registerName}")
    public void goToRegister(Registers registerName) {
        filter.click();
        registryName.get(1).$("input").val(registerName.value());
        $(byText(registerName.value())).click();
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
