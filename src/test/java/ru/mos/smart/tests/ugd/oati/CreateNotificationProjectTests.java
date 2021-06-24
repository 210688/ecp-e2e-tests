package ru.mos.smart.tests.ugd.oati;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;


@Epic("UGD (УГД)")
@Feature("OATI (Уведомления ОАТИ)")
@Story("Создание проекта уведомдения")
class CreateNotificationProjectTests extends TestBase {

    @Test
    @DisplayName("Проверка доступности формы подачи Сформировать уведомление о проведении работ, предусмотренных АИП г. Москвы")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("oati")})
    void checkingNotificationSubmissionForm() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToActions();

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
