package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage {
    /* класс pageObject для autoclose.html - предварительное открытие любого закрытого аутентификацией
     *  url платформы в браузере начинается с ввода логина и пароля с проходом через страницу авторизации.
     * место появления - при открытии любого url платформы на 1м шаге (в частности в Моём районе).
     * */

    public static SelenideElement
            loginWithPasswordLink = $(byText("Войти по логину и паролю")),
            loginInput = $("#username"),
            passwordInput = $("#password"),
            submitButton = $("#kc-login");

    public static void loginAs(String login, String password) {
        loginWithPasswordLink.click();
        loginInput.setValue(login);
        passwordInput.setValue(password);
        submitButton.click();
    }
}
