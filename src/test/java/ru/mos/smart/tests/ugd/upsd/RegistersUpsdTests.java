package ru.mos.smart.tests.ugd.upsd;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Epic("Платформа ЕЦП")
@Feature("UGD (УГД)")
@Story("Проверка доступности реестров УПСД")
class RegistersUpsdTests extends TestBase {

    @Test
    @Disabled()
    @DisplayName("Проверка доступности реестра \"УПСД. Подведомственные организации, утверждающие проектную документацию\"")
    void registerUpsdViewing() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister("УПСД");

        step("Найти реестр и перейти в него", () -> {

        });

        step("Проверка открытия реестра", () -> {

        });
    }
}