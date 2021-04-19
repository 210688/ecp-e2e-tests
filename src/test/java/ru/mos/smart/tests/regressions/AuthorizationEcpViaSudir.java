package ru.mos.smart.tests.regressions;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.SmsVerificationPage;
import ru.mos.smart.pages.SudirAuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class AuthorizationEcpViaSudir extends TestBase {

    @Test
    @AllureId("4161")
    @DisplayName("Проверка авторизации через СУДИР")
    @Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
    @Feature("Меню Госуслуги и функции")
    void AuthorizationEcpSudir() {
        step("Перейти на сайт https://smart-predprod.mos.ru/");
        SudirAuthorizationPage.openUrlWithAuthorization("", webConfig().login_sudir(), webConfig().password_sudir());
        new SmsVerificationPage().verifyBySms("79449440001");
    }
}
