package ru.mos.smart.tests.regressions;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.SmsVerificationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Базовый функционал 2D")
public class AuthorizationEcpViaSudir extends TestBase {

    @Test
    @AllureId("4161")
    @DisplayName("Проверка авторизации через СУДИР")
    @Tag("regressions")
    void AuthorizationEcpSudir() {
        AuthorizationPage.openUrlWithAuthorizationSudir("", webConfig().login_sudir(), webConfig().password_sudir());
        step("Ввод СМС кода");
        new SmsVerificationPage().verifyBySms("79449440001");
        step("Проверка, что авторизация в ЕЦП успешна");
    }
}
