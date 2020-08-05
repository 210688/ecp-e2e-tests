package ru.mos.smart.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class LoginPage {

    @Step("Открытие ссылки {url} с авторизацией")
    public static void openUrlWithAuthorization(String url, String login, String password) {
        step("Открытие ссылки " + url, ()-> open(url));

        step("Заполнение формы авторизации", ()-> {
            $(byText("Войти по логину и паролю")).click();
            $("#username").setValue(login);
            $("#password").setValue(password);
            $("#kc-login").click();
        });

        step("Проверка успешной авторизации ", ()->
                $(byText("Выйти")).shouldBe(Condition.visible));
    }
}
