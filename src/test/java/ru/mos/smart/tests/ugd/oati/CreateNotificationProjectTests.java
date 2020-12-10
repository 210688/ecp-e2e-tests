package ru.mos.smart.tests.ugd.oati;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;



@Epic("UGD (УГД)")
@Feature("OATI (Уведомления ОАТИ)")
@Story("Создание проекта уведомдения")
class CreateNotificationProjectTests extends TestBase {

    @Test
    @DisplayName("Проверка доступности формы подачи Сформировать уведомление о проведении работ, предусмотренных АИП г. Москвы")
    @Tag("allModules")
    @Tag("prodRunPrc")
    void checkingNotificationSubmissionForm() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsers(), ConfigHelper.getPas());
        MainPage.actionsPage();

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
