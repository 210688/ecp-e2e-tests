/*
package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.helpers.annotations.Owner;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.SmsVerificationPage;
import ru.mos.smart.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Меню Госуслуги и функции")
public class AuthorizationEcpViaSudir extends TestBase {

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @DisplayName("Проверка авторизации через СУДИР")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void AuthorizationEcpSudir() {
        AuthorizationPage.openUrlWithAuthorizationSudir(webConfig().login_sudir(), webConfig().password_sudir());
        step("Ввод СМС кода");
        new SmsVerificationPage().verifyBySms("79449440001");
        step("Проверка, что авторизация в ЕЦП успешна");
    }
}
*/
