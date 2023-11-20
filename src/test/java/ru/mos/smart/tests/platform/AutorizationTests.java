package ru.mos.smart.tests.platform;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;

import static ru.mos.smart.config.ConfigHelper.*;

@Epic("Регрессионные тесты платформы (функционал)")
@Feature("Работа со справочниками")
@Tag("regressing")
public class AutorizationTests {
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test()
    void checkAuthorizationByLoginAndPassword() {
        AuthorizationPage.openUrlWithAuthorizationUI(getWebSecureUrl() ,getLoginRegress(), getPasswordRegress());

    }
}
