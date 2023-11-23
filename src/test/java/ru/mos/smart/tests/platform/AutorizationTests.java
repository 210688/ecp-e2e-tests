package ru.mos.smart.tests.platform;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.config.ConfigHelper.*;
import static ru.mos.smart.pages.AuthorizationPage.openUrlWithAuthorizationUI;
import static ru.mos.smart.pages.AuthorizationPage.openUrlWithAuthorizationUIWrongPassword;

@Epic("Регрессионные тесты платформы (функционал)")
@Feature("Авторизация на портале")
@Tag("regressing")
public class AutorizationTests extends TestBase {

    @Test()
    @AllureId("17928")
    @Owner("Soldatov")
    @DisplayName("Авторизация по логину и паролю")
    void checkAuthorizationByLoginAndPassword() {
        openUrlWithAuthorizationUI(getWebSecureUrl(), getLoginRegress(), getPasswordRegress());
        generalPage.checkFormMainPage();
    }

    @Test()
    @AllureId("18014")
    @Owner("Soldatov")
    @DisplayName("Авторизация с неверным паролем")
    @Description("Проверить сообщение Неправильное имя пользователя или пароль после ввода неправильного пароля")
    void checkAuthorizationWrongPassword() {
        openUrlWithAuthorizationUIWrongPassword(getWebSecureUrl(), getLoginRegress());
        generalPage.checkMessageWrongPassword();
    }
}
