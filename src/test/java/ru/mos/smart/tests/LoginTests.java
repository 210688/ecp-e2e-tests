package ru.mos.smart.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
    void successfulLoginWithPassword(String url) {
        step("Открытие ссылки " + url, ()-> open(webUrl));

        step("Заполнение формы авторизации", ()-> {
            $(".login.title_login").click();
            //$(byText("Войти по логину и паролю")).click();
            $("#username").setValue(LOGIN_ECP_TEST);
            $("#password").setValue(PASSWORD_ECP_TEST);
            $("#kc-login").click();
        });

        step("Проверка успешной авторизации", ()-> {
            $(byText("Мои задачи")).shouldBe(Condition.visible);
        });
    }
}
