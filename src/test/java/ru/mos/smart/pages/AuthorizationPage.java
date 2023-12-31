package ru.mos.smart.pages;

import org.openqa.selenium.Cookie;
import ru.mos.smart.api.Authorization;

import java.util.Map;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class AuthorizationPage {
    private static final String redirectUrl = webConfig().webUrl();
    private static void setCookies(Map<String, String> cookiesMap) {
        open("/reg/favicon.ico");
        cookiesMap.forEach((k, v) -> getWebDriver().manage().addCookie(new Cookie(k, v)));
        open(redirectUrl);
    }

    public static void openUrlWithAuthorizationAPI(String login, String password) {
        step("Авторизоваться в УЗ", (step) -> {
            step.parameter("Login", login);
            Authorization authorization = new Authorization();
            setCookies(authorization.getAuthCookie(login, password));
        });
    }

    public static void openUrlWithAuthorizationUI(String url, String login, String password) {
        open(url);
        step("Авторизоваться в УЗ", (step) -> {
            $(".login-page__login").click();
            step.parameter("Ввести логин", login);
            $("#username").setValue(login);
            $("#password").setValue(password);
            $("#kc-login").click();
            step.parameter("Пользователь успешно авторизовался", "Логин: " + login);
        });
    }

    public static void openUrlWithAuthorizationUIWrongPassword(String url, String login) {
        open(url);
        step("Авторизоваться в УЗ", (step) -> {
            $(".login-page__login").click();
            step.parameter("Ввести логин", login);
            $("#username").setValue(login);
            $("#password").setValue("123456");
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
        });
    }
}