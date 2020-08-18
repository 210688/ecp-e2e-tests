package ru.mos.smart.tests.feedback;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
@Epic("Платформа ЕЦП")
@Feature("Модуль \"feedback\"")
@Story("Проверка отправки уведомления в тех подержку")
@Tag("feedback")
class SupportRequest extends TestBase {

    @Test
    @Description("Используется тестовый пользователь 89 c нужными правами")
    @DisplayName("Проверка отправки уведомления в тех подержку")
    void SupportRequestForward() {
        openUrlWithAuthorization("", LOGIN_FEEDBACK, PASSWORD_FEEDBACK); //авторизация в системе

        step("Открытие ссылки Инициировать обращение в техническую поддержку", ()->
                open("/feedback/#/app/feedback/form"));

        step("Заполнение поля Тип обращения", ()-> {
            $(".ng-arrow-wrapper:nth-child(3)").click();
        });

        step("Заполнение поля Тема обращения", ()-> {
            $(".ng-input",1).click();
            $(":focus").setValue("Проверка автоматизации теста");
        });

        step("Заполнение поля Ссылка на страницу с ошибкой", ()-> {
            $(byName("pageUrl")).setValue(webUrl);
            $(".btn.btn-primary").click();
        });
    }
}

