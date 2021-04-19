package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SudirAuthorizationPage {

    @Step("Открытие страницы авторизации")
    public static void openUrlWithAuthorization(String url, String login, String password) {
        step("Открытие ссылки " + url, () -> open(url));

        step("Заполнение формы авторизации", () -> {
            $(byText("Войти как государственный служащий")).shouldBe(visible).click();
            $("#login").setValue(login);
            $("#password").setValue(password);
            $("#bind").click();
        });
        step("Нажатие кнопки переход на страницу по подтверждению СМС", () ->
                $("#showMethodsList").click());
    }
}
