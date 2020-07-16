package ru.mos.smart.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;


@Feature("Авторизация")
@Story("Авторизация по логину и паролю")
@Tag("login")
class LoginTests extends TestBase {
    @Test
    @Severity(CRITICAL)
    @DisplayName("Авторизация в УЗ соцсети с логином - телефоном")
    @Link("https://login-tech.mos.ru/sps/profile")
    void successfulLoginWithEmail() {
        step("Открытие страницы авторизации", ()-> {
            open("");
            $("#button").click();

            $("div.system-header")
                    .shouldHave(text("Доступ к информационным ресурсам города Москвы"));
            $("div.form-wrapper h1.page-title")
                    .shouldHave(text("Личный кабинет"));
        });

        step("Заполнение формы авторизации", ()-> {
            step("Ввод номера телефона в поле логина", ()->
                    $("#login").setValue(DEFAULT_EMAIL));
            step("Ввод пароль в поле логина", ()->
                    $("#password").setValue(DEFAULT_PASSWORD));
            step("Нажатие на кнопку Войти", ()->
                    $("#bind").click());
        });

        step("Проверка успешной авторизации", ()-> {
            $("#mos-header").shouldHave(text("Test testov"));
            $("#desktop__header").shouldHave(text("Рабочий стол"));
        });
    }
}
