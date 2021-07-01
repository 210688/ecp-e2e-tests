package ru.mos.smart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import ru.mos.smart.api.Authorization;

import java.util.Map;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class AuthorizationPage {
    private static void setCookies(Map<String, String> cookiesMap) {
        open("/autoclose.html");
        cookiesMap.forEach((k, v) -> getWebDriver().manage().addCookie(new Cookie(k, v)));
    }

    @Step("Авторизация {login}, {password}")
    public static void openUrlWithAuthorization(String url, String login, String password) {
        Authorization authorization = new Authorization();
        setCookies(authorization.getAuthCookie(login, password));
        open(url);
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