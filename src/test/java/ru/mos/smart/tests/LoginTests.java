package ru.mos.smart.tests;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.helpers.EnvironmentHelper.webUrl;


@Epic("Общие тесты для выполнения в первую очередь")
@Tag("login")
class LoginTests extends TestBase {
    @Test
    @DisplayName("Проверка Авторизации в системе")
    void successfulLoginWithPassword() {
        step("Открытие страницы авторизации ", ()-> open(webUrl));

        step("Заполнение формы авторизации", ()-> {
            $(byText("Войти по логину и паролю")).click();
            $("#username").setValue(LOGIN_ECP_TEST);
            $("#password").setValue(PASSWORD_ECP_TEST);
            $("#kc-login").click();
        });

        step("Проверка успешной авторизации", ()-> {
            $(byText("Правительство Москвы")) //test test test
                    .waitUntil(visible, 10000).shouldBe(visible);

        });
    }
}
