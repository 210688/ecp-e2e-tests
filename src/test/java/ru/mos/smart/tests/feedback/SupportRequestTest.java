package ru.mos.smart.tests.feedback;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.junit.OnPreprodOnly;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;
import static ru.mos.smart.data.enums.OpportunityForm.FEEDBACK_FORM;
import static ru.mos.smart.data.enums.Sidebar.OPPORTUNITIES;
import static ru.mos.smart.data.enums.Sidebar.SERVICES_AND_FUNCTION;

@Epic("OASI")
@Feature("FEEDBACK")
@Tags({@Tag("cdp"), @Tag("regres")})
public class SupportRequestTest extends TestBase {

    @Test
    @AllureId("17114")
    @OnPreprodOnly
    @DisplayName("Возможность инициировать обращение в техническую поддержку.")
    @Description("Проверить, что отправляется письмо в тех поддержку")
    void SupportRequestForward() {
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, OPPORTUNITIES );
        actionsPage.openToBusinessProcess(FEEDBACK_FORM);

        step("Заполнение поля Тип обращения", () -> {
            $x("//input[@role='combobox']").click();
            $x("//span[contains(text(),'Технические вопросы')]").click();
        });
        step("Заполнение поля Тема обращения", () -> {
            $(".ng-select-taggable input").click();
            $(".ng-select-taggable input").val("Не заходит на главную страницу").pressEnter();
        });
        step("Заполнение поля Ссылка на страницу с ошибкой", () -> {
            $(byName("pageUrl")).setValue(webConfig().webUrl());
            $x("//div/button[contains(text(),'Отправить')]").click();
        });
    }
}





