package ru.mos.smart.tests.ugd.upsd;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Epic("Платформа ЕЦП")
@Feature("UGD (УГД)")
@Story("Проверка доступности реестров УПСД")
@Tags({@Tag("preprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("upsd")})
class RegistersUpsdTests extends TestBase {

    @Test
    @Disabled()
    @DisplayName("Проверка доступности реестра \"УПСД. Подведомственные организации, утверждающие проектную документацию\"")
    void registerUpsdViewing() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();

        step("Найти реестр и перейти в него", () -> {

        });

        step("Проверка открытия реестра", () -> {

        });
    }
}