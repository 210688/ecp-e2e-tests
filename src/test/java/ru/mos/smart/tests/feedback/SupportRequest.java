package ru.mos.smart.tests.feedback;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.helpers.EnvironmentHelper.webUrl;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;


@Layer("web")
@Epic("FEEDBACK (Форма обратной связи)")
@Tag("feedback")
class SupportRequest extends TestBase {

    @Test
    @DisplayName("Проверка отправки уведомления в тех подержку")
    void supportRequestForward() {
        openUrlWithAuthorization("", LOGIN_OSSIG, PASSWORD_OSSIG);

        step("Открытие ссылки \"Инициировать обращение в техническую поддержку\"", ()->
                open("/feedback/#/app/feedback/form"));

        step("Заполнение поля \"Тип обращения\"", ()-> {
            $(".ng-arrow-wrapper:nth-child(3)").click();
        });

        step("Заполнение поля \"Тема обращения\"", ()-> {
            $(".ng-input",1).click();
            $(":focus").setValue("Проверка автоматизации теста");
        });

        step("Заполнение поля \"Ссылка на страницу с ошибкой\"", ()-> {
            $(byName("pageUrl")).setValue(webUrl);
            $(".btn.btn-primary").click();
        });
    }
}
