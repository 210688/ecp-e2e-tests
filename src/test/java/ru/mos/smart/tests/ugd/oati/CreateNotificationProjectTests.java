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
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

@Epic("UGD (УГД)")
@Feature("OATI (Уведомления ОАТИ)")
@Story("Гоуслуги и функции")
@Component("Возможности")
class CreateNotificationProjectTests extends TestBase {

    @Test
    @AllureId("16982")
    @OnPreprodOnly
    @DisplayName("Доступность формы подачи Сформировать уведомление о проведении работ, предусмотренных АИП г. Москвы")
    @Description("Проверить, что форма открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingNotificationSubmissionForm() {
        actionsPage
                .goToActions("Направить новое уведомление ОАТИ о проведении работ");

        step("Выбрать операцию Направить новое уведомление ОАТИ о проведении работ", () -> {
            $(byName("common")).setValue("Направить новое уведомление ОАТИ о проведении работ");
            $x("//button[contains(text(),'Найти')]").click();
            $x("//span[contains(text(),'Направить новое уведомление ОАТИ о проведении работ')]").click();
        });

        step("Выбрать Уведомление ОАТИ о проведении работ, предусмотренных АИП", () -> {
            $x("//div[contains(text(),'Уведомление ОАТИ о проведении работ, предусмотренных АИП')]").click();
            $x("//button[contains(text(),'Выбрать')]").click();
            $(byText("Выберите объект капитального строительства")).shouldBe(visible);
        });
    }
}
