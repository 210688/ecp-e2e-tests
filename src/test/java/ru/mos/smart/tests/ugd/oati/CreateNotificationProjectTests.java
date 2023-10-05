package ru.mos.smart.tests.ugd.oati;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.junit.OnPreprodOnly;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.enums.OpportunityForm.OATI_TASK;
import static ru.mos.smart.data.enums.Sidebar.OPPORTUNITIES;
import static ru.mos.smart.data.enums.Sidebar.SERVICES_AND_FUNCTION;

@Epic("UGD")
@Feature("OATI")
class CreateNotificationProjectTests extends TestBase {

    @Test
    @AllureId("16982")
    @Story("Гоуслуги и функции")
    @Component("Возможности")
    @OnPreprodOnly
    @DisplayName("Доступность формы подачи Сформировать уведомление о проведении работ, предусмотренных АИП г. Москвы")
    @Description("Проверить, что форма открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regres")})
    void checkingNotificationSubmissionForm() {
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, OPPORTUNITIES);
        actionsPage.openToBusinessProcess(OATI_TASK);
        step("Выбрать Уведомление ОАТИ о проведении работ, предусмотренных АИП", () -> {
            $x("//div[contains(text(),'Уведомление ОАТИ о проведении работ, предусмотренных АИП')]").click();
            $x("//button[contains(text(),'Выбрать')]").click();
            $(byText("Выберите объект капитального строительства")).shouldBe(visible);
        });
    }
}
