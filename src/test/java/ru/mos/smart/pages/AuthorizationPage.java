package ru.mos.smart.pages;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import ru.mos.smart.api.Authorization;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class AuthorizationPage {

    @Step("Авторизация {login}, {password}")
    public static void openUrlWithAuthorization(String url, String login, String password) {
        Authorization.auth(url, login, password);
    }

    public static void openUrlWithAuthorizationUI(String url, String login, String password) {

        step("Открытие ссылки " + url, () -> open(url));
        step("Заполнение формы авторизации", () -> {
            $(byText("Войти по логину и паролю")).click();
            $("#username").setValue(login);
            $("#password").setValue(password);
            $("#kc-login").click();
        });
    }

    public static void openUrlWithAuthorizationSudir(String url, String login, String password) {

        step("Открытие ссылки " + url, () -> open(url));
        step("Заполнение формы авторизации в СУДИР", () -> {
            $(byText("Войти как сотрудник ОИВ")).click();
            $("#login").setValue(login);
            $("#password").setValue(password);
            $("#bind").click();
            //$("#showMethodsList").click();
        });
    }
}